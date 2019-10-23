package com.ncrm.ihm.managerBeans.SGMA;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import org.primefaces.event.SelectEvent;

import net.sf.jasperreports.engine.JRException;

import com.ncrm.dao.daoImpl;
import com.ncrm.dao.entities.BeanCountImpy;
import com.ncrm.dao.entities.BeanImpChqSG;
import com.ncrm.dao.entities.BeanImpLcn;
import com.ncrm.dao.entities.BeanImpLcnSG;
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanReport;
import com.ncrm.dao.entities.BeanTrt;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.library.utils.JasperUtils;
import com.ncrm.library.utils.RegexUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;



@ManagedBean(name = "Impaye_LcnSGBean")
@RequestScoped
public class ImpayeLcnBean {
	
	
	private static final Logger logger = Logger.getLogger(ImpayeLcnBean.class);

	private List<BeanCountImpy> listCountImpayeeLcn=new ArrayList<BeanCountImpy>();
	private String msg="";
	
	 Date dteTr1=new Date();
	 Date dtePr=new Date();
		
	 String lblBq="SGMA";
	 String cdeBq=Propriete.getInsatance().get(lblBq+".cde.bq");
	 private final String folderOut=Propriete.getInsatance().get(lblBq+".FOLDER.OUT.IMP.LCN");	
	 private static final String folderREC = Propriete.getInsatance().get("SGMA.OUT.REC");
		String cdeTr="060";
		Map<String, Object> parameters =null;
		 List<BeanImpLcnSG> listimpayLcn=null;
		 private String[] selectedpcapts;
		 private List<BeanPcapt> pcapts;
		 private String[] selectedTrts;
		 private List<BeanTrt> trts;
	
		 String dossierEnrg="";
		 @ManagedProperty("#{metier}")
		 Imetier metier;
		
		 
		 @PostConstruct
		    public void init() {
			 listCountImpayeeLcn=metier.getImpyByBq(lblBq,"060");
			 pcapts = metier.getAllPcapt(lblBq);
		     trts=metier.getAlltrt(lblBq,"IMP_"+cdeTr);
		     
		     Calendar cal = Calendar.getInstance();
			  cal.setTime(dtePr);
			  cal.add(Calendar.DATE, -1);
			  dtePr=new Date(cal.getTime().getTime());
			  dteTr1=DateUtils.getdateFerierandWeenkend(dtePr);

		    }
		public void ExtraireImpyeeLCN()
		{
			int flagpurge=metier.purgetableEta(lblBq, "160");
			System.out.println(flagpurge);
		  if(flagpurge!=0||flagpurge==0){
				
			  
				List<BeanImpLcnSG> listimpayLcn=metier.readFromCroLCNSg(lblBq);
				if(listimpayLcn.size()>0){
					 msg=" === Impayees Confreres === ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir du fichier CRO est fait correctement [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 listimpayLcn=metier.readFromProdLCNSg(listimpayLcn, lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					listimpayLcn=metier.readFromIFPConfLCNSg(listimpayLcn,lblBq);
					 msg=" 3- Chargement des donnes a partir des fichiers IFP CONF [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 
					 listimpayLcn=metier.loadImpysLCNSg(listimpayLcn, lblBq);	 
					 msg=" 4- Insertion des impayees CONF dans la table temporaire [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
				}else
				{
					 msg="Le fichier CRO n est pas traite correctement ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
				}
					 
				     
				     
				List<BeanImpLcnSG> listimpayIALCN=metier.readFromIFPIALCNSg(lblBq);
				
				
					 if(listimpayIALCN.size()>0){
						 msg=" === Impayees Inter-Agences === ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir des fichiers IFP IA [ Nombre des impayees IA ="+listimpayIALCN.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 listimpayIALCN=metier.readFromProdIALCNSg(listimpayIALCN,formatDateTostirng(dteTr1, "dd-MM-yyyy"), lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees IA ="+listimpayIALCN.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
					 
					 listimpayIALCN=metier.loadImpysLCNSg(listimpayIALCN, lblBq);
					 msg=" 3- Insertion des impayees IA dans la table temporaire [ Nombre des impayees IA ="+listimpayIALCN.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
				
					
					
					 }else {
						 msg="Le fichier IFP IA n est pas traite correctement  ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
					 }
					 
					 listCountImpayeeLcn=metier.getImpyByBq(lblBq,"060");
			  }
			  else {
					 msg=" un problème et produit lorsque vous supprimez la table temporaire merci de voir les logs ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg)); 
				 }
			
			
		}
	public void ExporterImpyeeLCN(){
		
		
	
		 boolean flagExport=metier.chargertableimpaye(lblBq,cdeTr,formatDateTostirng(dteTr1, "yyyy-MM-dd"));//service.generateImpayeeLCN(cdeBq, cdeTr,dteTr1)
		
		 if(flagExport){
			 msg=" les impyees LCN sont bien exporter  dans un fichier plat .csv [ "+folderOut+" ]";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg)); 
		 }
		 else {
			 msg=" Error sur l action Exportation impyees voir les logs  !";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg)); 
		 }
	 
	}
	
	public void EditeImpyeeLCN(){
		
		
		
		    parameters = new HashMap<String, Object>();
		  
		
		
		    
		    
		    try {
		    	
		    	
		        if(selectedpcapts.length>0 && selectedTrts.length>0)
		    	{
			    List<String> list= new ArrayList(Arrays.asList(selectedpcapts));
			    List<BeanPcapt> listpcaptSelected= metier.getGetPcaptByCde(lblBq,list );
			    List<String> listTrt= new ArrayList(Arrays.asList(selectedTrts));
			    List<BeanTrt> listTrtSelected =metier.getGetTrtByCde(lblBq,listTrt);
			    
		    	String dteSort=DateUtils.formatDateToStirng(dteTr1,"yyyy-MM-dd");
		        String dteInstanceFolder=StringUtils.replace(dteSort, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
		        List<BeanImpLcnSG> listAllImpy=metier.getAllimpayeLCN(lblBq, StringUtils.replace(dteSort, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$3-$2-$1"));


		    	if(listAllImpy.size()>0){
		        
		        logger.debug("=== Edition des Impayées LCN pour la banque :=> "+lblBq+"[ dteSort :"+dteSort+"]");
		        parameters.put("dateInstance",DateUtils.formatStringToDate(dteSort,"yyyy-MM-dd"));
		       
				for(BeanPcapt p:listpcaptSelected) 
				{
				     logger.debug("@@@ [ Point de Capture :"+p.getCdePcapt()+"-"+p.getNomPcapt()+"]");
					
					
						parameters.put("cdepointCapture",p.getCdePcapt());
						parameters.put("pointCapture",p.getNomPcapt());	
					
						
						
					for (BeanTrt t:listTrtSelected) 
					{
						
					if  (!t.getNom_Traitement().equalsIgnoreCase("IMP_LCN_SGMA_CRT"))
						{
						
						if (t.getNom_Traitement().equalsIgnoreCase("IMP_LCN_SGMA_AG"))
							{
							logger.debug("@@@ [ Traitement  :"+t.getNom_Traitement()+"]");
							
							parameters.put("age_rattachement",p.getAgeRattachement());
							parameters.put("flag_scan_gr","0");
							dossierEnrg=t.getDossierEnre();
							}
					else
						if(t.getNom_Traitement().equalsIgnoreCase("IMP_LCN_SGMA_GR"))
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
					
//					else
//					{
//						for (BeanReport rep : metier.getReportByTrtSGMA(lblBq, t.getIdT())) 
//						{
//							
//							if(rep.isActive())
//							{
//								String outDir = t.getDossierEnre()+ "//" + "CRT" + "//"+ dteInstanceFolder;
//								String namePdfFile = rep.getId_report()+ "_"+ dteInstanceFolder + ".pdf";						
//								
//								metier.ReportPdf(rep.getModeleJRXML(),parameters, null, outDir,namePdfFile);
//							}
//					}
//					}
					}
					
					
					
					 
					dteSort=StringUtils.replace(dteSort, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$3-$2-$1");
					
					System.out.println("listAllImpy.size() "+listAllImpy.size());
					

					 logger.debug("=== Edition des ANP LCN pour la banque :=> "+lblBq+"[ dteSort :"+dteSort+"]");
					
					
					String JrxmlANPLcn= Propriete.getInsatance().get(lblBq+".JRXML.ANP");
					for(BeanImpLcnSG imp:listAllImpy)
					{
						
							
						logger.debug("@@@ cde Pcapt : " + p.getCdePcapt()+ "-" + p.getNomPcapt(), null);
						if(
								(imp.getDTE_SORT().equalsIgnoreCase(dteSort)) && (p.getCdePcapt().equalsIgnoreCase(imp.getBmtn_lecteur())&&(imp.getNOMTIRE()!=null))
//								&&
//								(imp.getCIN().trim().length()!=0 && imp.getCIN()!=null )
//										||
//										( imp.getRC()!=null && imp.getRC().trim().length()!=0 )
										)
								{
							
							logger.debug("@@@ imp.getMEM2() : " + imp.getBmtn_lecteur(), null);
									
						String outDir = dossierEnrg +"//"+p.getCdePcapt()+"//"+StringUtils.replace(imp.getDTE_SORT(), "([0-9]{2})-([0-9]{2})-([0-9]{4})","$3$2$1");
//						$ZBK.022.MAD.000.ANP.$CDE_PCAPT.$DTE_SORT.$WEBCAPTURE_ID.pdf
						String namePdfFile = imp.getBmlcn_ZBK()+ ".022.MAD.000.ANP."+p.getCdePcapt()+"."+StringUtils.replace(dteSort, "([0-9]{2})-([0-9]{2})-([0-9]{4})","$3$2$1")+"." +imp.getID_WEBCAPTUR()+".pdf";
						

						parameters.put("p_nser",imp.getBmlcn_nser());
						parameters.put("p_CPT",imp.getBmtr_CPT());
						parameters.put("p_ZBK_lib",imp.getZBK_LIB());
						
						parameters.put("p_ZBKT",imp.getBmlcn_ZBK());
						parameters.put("p_LOCTT",imp.getBmlcn_LOC());
						parameters.put("p_CPTT",imp.getBmlcn_CPT());	
						parameters.put("p_RIBT",imp.getBmlcn_rib());	
						
						
						parameters.put("p_MNT",imp.getBmlcn_MNT());	
							
						parameters.put("p_NomTire",imp.getNOMTIRE());	
						parameters.put("p_CIN",imp.getCIN());
						parameters.put("p_RC",imp.getRC());
						parameters.put("p_AdrTire",imp.getAdresseTire());
						String dteEmi=imp.getDTEemission();
						if(dteEmi!=null && RegexUtils.matches(dteEmi, "([0-9]{4})([0-9]{2})([0-9]{2})")){
							dteEmi=StringUtils.replace(dteEmi, "([0-9]{4})([0-9]{2})([0-9]{2})","$3/$2/$1");
						}else{
							dteEmi="";
						}
						
						parameters.put("p_DteEmi",dteEmi)	;
						
						String dteIns=imp.getDTEINS();
						if(dteIns!=null && RegexUtils.matches(dteIns, "([0-9]{4})([0-9]{2})([0-9]{2})")){
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
						
						
						
						String dteEch=imp.getDTEEC();
						if(dteEch!=null && RegexUtils.matches(dteEch, "([0-9]{2})([0-9]{2})([0-9]{4})")){
							dteEch=StringUtils.replace(dteEch, "([0-9]{2})([0-9]{2})([0-9]{4})","$1/$2/$3");
						}
						else
						{
							dteEch="";
						}
						parameters.put("p_DTEEC",dteEch);
						parameters.put("p_dteRej",dteRej);
					
						
						
						parameters.put("p_RejLib",imp.getREJET_LIB());
					
						
						
						metier.ReportPdf(JrxmlANPLcn,parameters, null, outDir,namePdfFile);
					   
						}
					
						
						
			}
					
					
				}
				 msg="L'États non-payés et les ANP sont bien gérés pour chaque point de capture dans ["+dteInstanceFolder+"]";
	    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
		    	}
		    	else{
		    		 msg="pas de valeurs impayées pour la date sélectionnée  ["+dteSort+"]";
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

	
	
	public void EditepyeeLCN(){
	    parameters = new HashMap<String, Object>();
	    String strDteSetRio="";
		String strDtePre=DateUtils.formatDateToStirng(dtePr,"yyyy-MM-dd");
	        try {
				if(selectedpcapts.length>0)
				{
				List<String> list= new ArrayList(Arrays.asList(selectedpcapts));
				List<BeanPcapt> listpcaptSelected= metier.getGetPcaptByCde(lblBq,list );								
				
				Calendar cal = Calendar.getInstance(); 
				cal.setTime(dtePr); 
//				CAlculer la date de set RIO 
				do {
			         System.out.println("dtePre : " +strDtePre );
			         cal.add(Calendar.DATE, -1);
			         Date dte_setRio = cal.getTime();
			         strDteSetRio=DateUtils.formatDateToStirng(dte_setRio,"yyyy-MM-dd");
			         System.out.println("dteSetRio : " +strDteSetRio );
			      }while( metier.getCountValueTraitedSgma(lblBq, "PAYEE", strDteSetRio)==0);
						
				
				logger.debug("=== Edition des payées LCN pour la banque :=> "+lblBq+"[ dtePre :"+strDtePre+"]");
				parameters.put("dtePre",strDtePre);
				logger.debug("=== Edition des payées LCN pour la banque :=> "+lblBq+"[ dteSetRio :"+strDteSetRio+"]");
				parameters.put("dteSetRio",strDteSetRio);
				
      
				
				for(BeanPcapt p:listpcaptSelected) 
				{
				     logger.debug("@@@ [ Point de Capture :"+p.getCdePcapt()+"-"+p.getNomPcapt()+"]");
					
					
						parameters.put("cdepointCapture",p.getCdePcapt());
						parameters.put("pointCapture",p.getNomPcapt());	
//						ETA_DETAIL_IMP_CHQ_10001_20171127.pdf
						String dteSort=DateUtils.formatDateToStirng(dteTr1,"yyyyMMdd");
						String namePdfFile = "ETA_DETAIL_PAY_LCN"+ "_" + p.getCdePcapt() + "_"+ dteSort + ".pdf";							
						String outDir = "\\\\172.17.0.151\\sorties\\SGMA\\editions\\" + p.getCdePcapt() + "\\"+ dteSort;
						metier.ReportPdf("/jrxml/sgma/Impayees/LCN/ETAT_PAYES_LCN_BY_PCAP.jasper",parameters, null, outDir,namePdfFile);
						
				}
				String dteSort=DateUtils.formatDateToStirng(dteTr1,"yyyyMMdd");
				String namePdfFile = "ETA_DETAIL_PAY_LCN"+ "_" + "CRT" + "_"+ dteSort + ".pdf";							
				String outDir = "\\\\172.17.0.151\\sorties\\SGMA\\editions\\" +"CRT" + "\\"+ dteSort;
				metier.ReportPdf("/jrxml/sgma/Impayees/LCN/CRT/ETAT_PAYES_LCN_BY_CRT.jasper",parameters, null, outDir,namePdfFile);
				 msg="L'etats payes sont bien geres pour chaque point de capture dans [\\\\172.17.0.150\\sorties\\SGMA\\editions\\]";
	    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
				
				}
				
					 else{
				   		 msg=" Veuillez sélectionner point(s) de capture";
				   		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
				   	}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
				
	}
	
	public void editRC(){
		String dteTrt=DateUtils.formatDateToStirng(dteTr1,"yyyy-MM-dd");
		List<BeanImpLcnSG> listImpay=metier.getAllImpayeLcnSg(lblBq, StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$3-$2-$1"));
		
		
if(listImpay.size()>0){
          dteTrt=StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
		 String nameFile=folderREC+"\\webcapture.022.160."+dteTrt+".txt";
		 metier.createRCImpyLcn(listImpay, dteTrt, nameFile);
		 msg="le fichier de rapprochement impayé est bien généré ["+nameFile+"]";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
}
else {
 msg="pas de valeurs impayées pour la date sélectionnée  ["+dteTrt+"]";
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
}
		
		
	}
	public List<BeanCountImpy> getListCountImpayeeLCN() {
		return listCountImpayeeLcn;
	}



	public void setListCountImpayeeLCN(List<BeanCountImpy> listCountImpayeeLCN) {
		this.listCountImpayeeLcn = listCountImpayeeLCN;
	}



	public List<BeanImpLcnSG> getlistimpayLcn() {
		return listimpayLcn;
	}



	public void setlistimpayLcn(List<BeanImpLcnSG> listimpayLcn) {
		this.listimpayLcn = listimpayLcn;
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
	public Date getDtePr() {
		return dtePr;
	}
	public void setDtePr(Date dtePr) {
		this.dtePr = dtePr;
	} 
	public void dateChange(SelectEvent event) {
		Date date = (Date) event.getObject();
		System.out.println(date);
		dteTr1=DateUtils.getdateFerierandWeenkend(dtePr);
		//Add facesmessage
		}
	


	
}
