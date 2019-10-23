package com.ncrm.ihm.managerBeans.SGMA;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;










import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;

import com.ncrm.SprBatch.sgma.impayeChqSg;
import com.ncrm.dao.entities.BeanCountImpy;
import com.ncrm.dao.entities.BeanImpChqSG;
import com.ncrm.dao.entities.BeanImpLcnSG;
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanReport;
import com.ncrm.dao.entities.BeanTrt;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.library.utils.RegexUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;



@ManagedBean(name = "Impaye_ChqSGBean")
@RequestScoped
public class ImpayeChqBean {
	
	
	private static final Logger logger = Logger.getLogger(ImpayeChqBean.class);
	private static final String folderREC = Propriete.getInsatance().get("SGMA.OUT.REC");
	private List<BeanCountImpy> listCountImpayeeChq=new ArrayList<BeanCountImpy>();
	private String msg="";
	
	 Date dteTr1=new Date(),
		  dteTr2=new Date();
	 String lblBq="SGMA";
	 String cdeBq=Propriete.getInsatance().get(lblBq+".cde.bq");
		
		String cdeTr="031";

		 List<BeanImpChqSG> listimpayChq=null;
	
		 private String[] selectedpcapts;
		 private List<BeanPcapt> pcapts;
		 private String[] selectedTrts;
		 private List<BeanTrt> trts;
		 Map<String, Object> parameters =null;
		 String dossierEnrg="";
		 @ManagedProperty("#{metier}")
		 Imetier metier;
		
		 
		 @PostConstruct
		    public void init() {
			 listCountImpayeeChq=metier.getImpyByBq(lblBq,"031");
			 pcapts = metier.getAllPcapt(lblBq);
		    	trts=metier.getAlltrt(lblBq,"IMP_"+cdeTr);

		    }
		 
		 
		 
//		 #####################################################################################
		 							/* EXTRAIRE LES IMPAYEE APARTIR CRO + IFP + PROD  */
//		 #####################################################################################
		 
		public void ExtraireImpyeeChq()
		{
			
				int flagpurge=metier.purgetableEta(lblBq, "131");
				System.out.println(flagpurge);
			  if(flagpurge!=0||flagpurge==0){
				List<BeanImpChqSG> listimpayChq=metier.readFromCroCHQSg(lblBq);
				if(listimpayChq.size()>0){
					 msg=" === Impayees Confreres === ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir du fichier CRO est fait correctement [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					listimpayChq=metier.readFromProdCHQSg(listimpayChq, lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					listimpayChq=metier.readFromIFPConfCHQSg(lblBq,listimpayChq);
					 msg=" 3- Chargement des donnes a partir des fichiers IFP CONF [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 
					 listimpayChq=metier.loadImpysCHQSg(listimpayChq, lblBq);	 
					 msg=" 4- Insertion des impayees CONF dans la table temporaire [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
				}else
				{
					 msg="Le fichier CRO n est pas traite correctement ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
				}
					 
				     
				     
				List<BeanImpChqSG> listimpayIAChq=metier.readFromIFPIACHQSg(lblBq);
					 if(listimpayIAChq.size()>0){
						 msg=" === Impayees Inter-Agences === ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir des fichiers IFP IA [ Nombre des impayees IA ="+listimpayIAChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 listimpayIAChq=metier.readFromProdIACHQSg(listimpayIAChq,formatDateTostirng(dteTr1, "yyyy-MM-dd"), lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees IA ="+listimpayIAChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
					 
					 listimpayIAChq=metier.loadImpysCHQSg(listimpayIAChq, lblBq);	 
					 msg=" 3- Insertion des impayees IA dans la table temporaire [ Nombre des impayees IA ="+listimpayIAChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
				
					
					 }else {
						 msg="Le fichier IFP IA n est pas traite correctement  ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
					 }
					 
					 listCountImpayeeChq=metier.getImpyByBq(lblBq,"031");
				
			  }
			  else {
					 msg=" un problème et produit lorsque vous supprimez la table temporaire merci de voir les logs ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg)); 
				 }
			
		}
	
		
		
//		 #####################################################################################
									/* EXPORTER LES IMPAYEES SUR UN FICHIER PLAT .CSV  */
//		 #####################################################################################
		
		public void ExporterImpyeeChq(){
		
		
	
		 boolean flagExport=metier.chargertableimpaye(lblBq,cdeTr,formatDateTostirng(dteTr1, "yyyy-MM-dd"));//service.generateImpayeeChq(cdeBq, cdeTr,dteTr1)
		
		 if(flagExport){
			 msg=" les impyees Cheques sont bien exporter  !";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg)); 
		 }
		 else {
			 msg=" Error sur l action Exportation impyees voir les logs  !";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg)); 
		 }
	 
	}
	
		
		public void editRC(){
			String dteTrt=DateUtils.formatDateToStirng(dteTr1,"yyyy-MM-dd");
			List<BeanImpChqSG> listImpay=metier.getAllImpayeChqSg(lblBq, dteTrt);
			
			
   if(listImpay.size()>0){
	          dteTrt=StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
			 String nameFile=folderREC+"\\webcapture.022.131."+dteTrt+".txt";
			 metier.createRCImpy(listImpay, dteTrt, nameFile);
			 msg="le fichier de rapprochement impayé est bien généré ["+nameFile+"]";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
}
else {
	 msg="pas de valeurs impayées pour la date sélectionnée  ["+dteTrt+"]";
	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
}
			
			
		}
//		 #####################################################################################
									/*  EDITIONS DES ETATS D4ACCOMPAGNEMENT */
//		#####################################################################################
	
	    public void EditeImpyeeCHQ(){
		
		
		
	    parameters = new HashMap<String, Object>();
	   
	
	    
	    
	    try {
	    	if(selectedpcapts.length>0 && selectedTrts.length>0)
	    	{
	    	 List<String> list= new ArrayList(Arrays.asList(selectedpcapts));
	 	    List<BeanPcapt> listpcaptSelected= metier.getGetPcaptByCde(lblBq,list );
	 	    List<String> listTrt= new ArrayList(Arrays.asList(selectedTrts));
	 	    List<BeanTrt> listTrtSelected =metier.getGetTrtByCde(lblBq,listTrt);
	    	String dteTrt=DateUtils.formatDateToStirng(dteTr1,"yyyy-MM-dd");
	    	List<BeanImpChqSG> listAllImpy=metier.getAllimpayeCHQ(lblBq, dteTrt);


	    	if(listAllImpy.size()>0){
	    	
	        String dteInstanceFolder=StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
			
	        
	        logger.debug("=== Edition des Impayées CHQ pour la banque :=> "+lblBq+"[ dteTrt :"+dteTrt+"]");
	       
	        parameters.put("dateInstance",DateUtils.formatStringToDate(dteTrt,"yyyy-MM-dd"));
	        
			for(BeanPcapt p:listpcaptSelected) 
			{
			     logger.debug("@@@ [ Point de Capture :"+p.getCdePcapt()+"-"+p.getNomPcapt()+"]");
				
				
					parameters.put("cdepointCapture",p.getCdePcapt());
					parameters.put("pointCapture",p.getNomPcapt());	
				
				for (BeanTrt t:listTrtSelected) 
				{
					
				if  (!t.getNom_Traitement().equalsIgnoreCase("IMP_CHQ_SGMA_CRT"))
					{
					
					if (t.getNom_Traitement().equalsIgnoreCase("IMP_CHQ_SGMA_AG"))
						{
						logger.debug("@@@ [ Traitement  :"+t.getNom_Traitement()+"]");
						
						parameters.put("age_rattachement",p.getAgeRattachement());
						parameters.put("flag_scan_gr","0");
						dossierEnrg=t.getDossierEnre();
						}
				else
					if(t.getNom_Traitement().equalsIgnoreCase("IMP_CHQ_SGMA_GR"))
						{
						parameters.put("flag_scan_gr","1");
						dossierEnrg=t.getDossierEnre();
						}
					
						
					for (BeanReport rep : metier.getReportByTrt(lblBq, t.getIdT())) 
							{
								
								if(rep.isActive())
								{
									logger.debug("@@@ [ Report  :"+rep.getId_report()+"]");
									String outDir = t.getDossierEnre()+ "//" + p.getCdePcapt() + "//"+ dteInstanceFolder;
									String namePdfFile = rep.getId_report()+ "_" + p.getCdePcapt() + "_"+ dteInstanceFolder + ".pdf";							
									
									metier.ReportPdf(rep.getModeleJRXML(),parameters, null, outDir,namePdfFile);
								}
						}
				}
				

				}
				
				
				
				 
		
			
				

				 logger.debug("=== Edition des CRP CHQ pour la banque :=> "+lblBq+"[ dteTrt :"+dteTrt+"]");
				
				
				String JrxmlANPLcn= Propriete.getInsatance().get(lblBq+".JRXML.CRP");
				for(BeanImpChqSG imp:listAllImpy)
				{
					
						
					logger.debug("@@@ cde Pcapt : " + p.getCdePcapt()+ "-" + p.getNomPcapt(), null);
					if(
							(imp.getDTE_TRT().equalsIgnoreCase(dteTrt)) && (p.getCdePcapt().equalsIgnoreCase(imp.getBmtn_lecteur())&&(imp.getNOMTIRE()!=null))
//							&&
//							(imp.getCIN().trim().length()!=0 && imp.getCIN()!=null )
//									||
//									( imp.getRC()!=null && imp.getRC().trim().length()!=0 )
									)
							{
						
						logger.debug("@@@ imp.getMEM2() : " + imp.getBmtn_lecteur(), null);
								
					String outDir = dossierEnrg +"//"+p.getCdePcapt()+"//"+StringUtils.replace(imp.getDTE_TRT(), "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
//					$ZBK.022.MAD.000.ANP.$CDE_PCAPT.$DTE_SORT.$WEBCAPTURE_ID.pdf
					String namePdfFile = imp.getBmch_ZBK()+ ".022.MAD.000.CRP."+p.getCdePcapt()+"."+StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")+"." +imp.getID_WEBCAPTUR()+".pdf";
					

					parameters.put("p_nser",imp.getBmch_nser());
					parameters.put("p_CPT",imp.getBmtr_CPT());
					parameters.put("p_ZBK_lib",imp.getZBK_LIB());
					
					parameters.put("p_ZBKT",imp.getBmch_ZBK());
					parameters.put("p_LOCTT",imp.getBmch_LOC());
					parameters.put("p_CPTT",imp.getBmch_CPT());	
					parameters.put("p_RIBT",imp.getBmch_rib());	
					
					
					parameters.put("p_MNT",imp.getBmch_MNT());	
						
					parameters.put("p_NomTire",imp.getNOMTIRE());	
					parameters.put("p_CIN",imp.getCIN());
					parameters.put("p_RC",imp.getRC());
					parameters.put("p_AdrTire",imp.getADR_TIR());
					String dteEmi=imp.getDTEemission();
					if(dteEmi!=null && RegexUtils.matches(dteEmi, "([0-9]{4})([0-9]{2})([0-9]{2})")){
						dteEmi=StringUtils.replace(dteEmi, "([0-9]{4})([0-9]{2})([0-9]{2})","$3/$2/$1");
					}else{
						dteEmi="";
					}
					
					parameters.put("p_DteEmi",dteEmi)	;
					
					String dteIns=imp.getDTE_TRT();
					if(dteIns!=null && RegexUtils.matches(dteIns, "([0-9]{4})-([0-9]{2})-([0-9]{2})")){
						dteIns=StringUtils.replace(dteIns, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$3/$2/$1");
					}else{
						dteIns="";
					}
					parameters.put("p_dteTr",dteIns);
					
					String dteRej=imp.getDTREJET();
					if(dteRej!=null && RegexUtils.matches(dteRej, "([0-9]{4})([0-9]{2})([0-9]{2})")){
						dteRej=StringUtils.replace(dteRej, "([0-9]{4})([0-9]{2})([0-9]{2})","$3/$2/$1");
					}
					else
					{
						dteRej="";
					}
	
					parameters.put("p_dteRej",dteRej);
				
					
					
					parameters.put("p_RejLib",imp.getREJET_LIB());
				
					
					
					metier.ReportPdf(JrxmlANPLcn,parameters, null, outDir,namePdfFile);
				   
					}
				
					
					
		}
				
				
			}
			 msg="L'États non-payés et les CRP sont bien gérés pour chaque point de capture dans ["+dteInstanceFolder+"]";
    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
			
	    	}
	    	else{
	    		 msg="pas de valeurs impayées pour la date sélectionnée  ["+dteTrt+"]";
	    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
	    	}

	    }
	        
	        else{
	   		 msg=" Veuillez sélectionner Traitement(s) et point(s) de capture";
	   		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
	   	}
	    	
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
		
		
		
		
		
		
		
		
		
		
		
		
}



	public List<BeanCountImpy> getListCountImpayeeChq() {
		return listCountImpayeeChq;
	}



	public void setListCountImpayeeChq(List<BeanCountImpy> listCountImpayeeChq) {
		this.listCountImpayeeChq = listCountImpayeeChq;
	}



	public List<BeanImpChqSG> getListimpayChq() {
		return listimpayChq;
	}



	public void setListimpayChq(List<BeanImpChqSG> listimpayChq) {
		this.listimpayChq = listimpayChq;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	public Date getDteTr1() {
		return dteTr1;
	}



	public void setDteTr1(Date dteTr1) {
		this.dteTr1 = dteTr1;
	}



	public Date getDteTr2() {
		return dteTr2;
	}



	public void setDteTr2(Date dteTr2) {
		this.dteTr2 = dteTr2;
	}



	public  String formatDateTostirng(Date d,String format){
		String dateEcheeFormater=new SimpleDateFormat(format).format(d);
		return dateEcheeFormater ;
	}
	
	
	
	public Imetier getMetier() {
		return metier;
	}
	public void setMetier(Imetier metier) {
		this.metier = metier;
	}

	public String[] getSelectedpcapts() {
		return selectedpcapts;
	}

	public void setSelectedpcapts(String[] selectedpcapts) {
		this.selectedpcapts = selectedpcapts;
	}

	public List<BeanPcapt> getPcapts() {
		return pcapts;
	}

	public void setPcapts(List<BeanPcapt> pcapts) {
		this.pcapts = pcapts;
	}

	public String[] getSelectedTrts() {
		return selectedTrts;
	}

	public void setSelectedTrts(String[] selectedTrts) {
		this.selectedTrts = selectedTrts;
	}

	public List<BeanTrt> getTrts() {
		return trts;
	}

	public void setTrts(List<BeanTrt> trts) {
		this.trts = trts;
	} 

	


	
}
