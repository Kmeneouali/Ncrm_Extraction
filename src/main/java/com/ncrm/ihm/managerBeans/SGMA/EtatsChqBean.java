package com.ncrm.ihm.managerBeans.SGMA;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
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


















import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;

import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanReport;
import com.ncrm.dao.entities.BeanTrt;
import com.ncrm.dao.entities.rec.RecordRemise;
import com.ncrm.dao.entities.rec.RecordValue;

import com.ncrm.library.utils.DateUtils;
import com.ncrm.library.utils.JasperUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "Etats_ChqSGBean")
@RequestScoped
public class EtatsChqBean {
	private static final Logger logger = Logger.getLogger(EtatsChqBean.class);
	private final String LblBq="SGMA";
	private final  String cdeBq=Propriete.getInsatance().get(LblBq+".cde.bq");
	private final String folderOut=Propriete.getInsatance().get(LblBq+".FOLDER.ETA.CHQ");
	private static final String folderREC = Propriete.getInsatance().get("SGMA.OUT.REC");
	
	private final  String cdeTr="031";
	 private String[] selectedpcapts;
	 private List<BeanPcapt> pcapts;
	 private String[] selectedTrts;
	 private List<BeanTrt> trts;
	@ManagedProperty("#{metier}")
	 Imetier metier;
	 
    Date datetr=new Date();
    String msg="";

    Map<String, Object> parameters =null;
    
    @PostConstruct
    public void init() {
    	pcapts = metier.getAllPcapt(LblBq);
    	trts=metier.getAlltrt(LblBq,cdeTr);
    	
//    	pcapts.add(new BeanPcapt("01001", "Test", "type", "ageRattachement", true));
//    	pcapts.add(new BeanPcapt("01002", "Test2", "type", "ageRattachement", true));
    }
 
 public void extraireetatsChq(){
		int flagpurge=metier.purgetableEta(LblBq, cdeTr);
		System.out.println(flagpurge);
	  if(flagpurge!=0||flagpurge==0){
//	     if(metier.purgetableEta(LblBq, cdeTr)==0){
		 String dtetrString=DateUtils.formatDateToStirng(datetr,"yyyy-MM-dd");
	     int countValues=metier.extractDataEta(LblBq, cdeTr, dtetrString);
	 
	 if(countValues==0){
		 msg=" aucune instance pour la date selectionne ="+dtetrString;
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", msg));
	  
	 }
	 else 
	   {
		 msg=" les valeurs ["+countValues+"] le [ ="+dtetrString+" ] sont synchronises dans la table temporaire  ";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
//		 msg="la base temporaire a été synchronisé avec la base de production Nombre de valeur traitées ["+countValues+"]";
//		 msg="les "+countValues +" valeurs traitees sont bien extraites dans un fichier plat .csv [ "+ folderOut +" ]";
//		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", msg)); 
		
	      }
	
	     }else {
	    	 msg=" un problème et produit lorsque vous supprimez la table temporaire merci de voir les logs ";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg)); 
	     }
	
 }
 
 
 
 
 
 public void editetatsChq(){
	    parameters = new HashMap<String, Object>();
	    String dteInstance=DateUtils.formatDateToStirng(datetr,"yyyy-MM-dd");
	    String dteInstanceFolder=StringUtils.replace(dteInstance, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
	    List<RecordRemise> recordRems=metier.getRecordRemRec(LblBq, cdeTr, dteInstance);
		
		
	   
		
	    try {
	    	
	    	
	    	 if(selectedpcapts.length>0 && selectedTrts.length>0)
	     	{
	    		 if(recordRems.size()>0){	 
	 	    List<String> list= new ArrayList(Arrays.asList(selectedpcapts));
	 	    List<BeanPcapt> listpcaptSelected= metier.getGetPcaptByCde(LblBq,list );
	 	    
	 	    List<String> listTrt= new ArrayList(Arrays.asList(selectedTrts));
	 	    List<BeanTrt> listTrtSelected =metier.getGetTrtByCde(LblBq,listTrt);
			parameters.put("dateInstance",DateUtils.formatStringToDate(dteInstance,"yyyy-MM-dd"));
			
			for(BeanPcapt p:listpcaptSelected) 
			{
				
				logger.debug("@@@    [ Point de capture = "+p.getCdePcapt()+" - "+p.getNomPcapt()+" ]");
				
					parameters.put("cdepointCapture",p.getCdePcapt());
					parameters.put("pointCapture",p.getNomPcapt());	
				
				for (BeanTrt t:listTrtSelected) 
				{
					
				if  (!t.getNom_Traitement().equalsIgnoreCase("ETA_CHQ_SGMA_CRT"))
					{
					
					if (t.getNom_Traitement().equalsIgnoreCase("ETA_CHQ_SGMA_AG"))
						{
						parameters.put("age_rattachement",p.getAgeRattachement());
						parameters.put("flag_scan_gr","0");
						
						}
				else
					if(t.getNom_Traitement().equalsIgnoreCase("ETA_CHQ_SGMA_GR"))
						{
						parameters.put("flag_scan_gr","1");
						}
					
						
					for (BeanReport rep : metier.getReportByTrt(LblBq, t.getIdT())) 
							{
								
								if(rep.isActive())
								{
									String outDir = t.getDossierEnre()+ "//" + p.getCdePcapt() + "//"+ dteInstanceFolder;
									String namePdfFile = rep.getId_report()+ "_" + p.getCdePcapt() + "_"+ dteInstanceFolder + ".pdf";							
									
									metier.ReportPdf(rep.getModeleJRXML(),parameters, null, outDir,namePdfFile);
								}
						}
				}
				
				else
				{
					for (BeanReport rep : metier.getReportByTrt(LblBq, t.getIdT())) 
					{
						
						if(rep.isActive())
						{
							String outDir = t.getDossierEnre()+ "//" + "CRT" + "//"+ dteInstanceFolder;
							String namePdfFile = rep.getId_report()+ "_"+ dteInstanceFolder + ".pdf";						
							
							metier.ReportPdf(rep.getModeleJRXML(),parameters, null, outDir,namePdfFile);
						}
				}
				}
				}
				
				
			}
			 msg="Les 'États de traitement sont bien gérés pour chaque point de capture dans ["+dteInstanceFolder+"]";
    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
	     	}
	    		 else{
		    		 msg="pas de valeurs  pour la date sélectionnée  ["+dteInstance+"]";
		    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
		    	}
	     	}
	    	  else{
	 	   		 msg=" Veuillez sélectionner Traitement(s) et point(s) de capture";
	 	   		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
	 	   	}
		} catch (ParseException e1) {
			logger.debug("+++    ParseException editetatsChq = "+e1.getMessage(),e1);
			 msg="+++    ParseException editetatsChq = "+e1.getMessage();
    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));
		} catch (FileNotFoundException e1) {
			logger.debug("+++    FileNotFoundException editetatsChq = "+e1.getMessage(),e1);
			 msg="+++    FileNotFoundException editetatsChq = "+e1.getMessage();
    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));
		} catch (JRException e1) {
			logger.debug("+++    JRException editetatsChq = "+e1.getMessage(),e1);
			 msg="+++    JRException editetatsChq = "+e1.getMessage();
    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));
		} catch (SQLException e1) {
			logger.debug("+++    SQLException editetatsChq = "+e1.getMessage(),e1);
			 msg="+++    SQLException editetatsChq = "+e1.getMessage();
    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));
		}
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
 
 public void editRcWc(){
	 String dteInstance=DateUtils.formatDateToStirng(datetr,"yyyy-MM-dd");
	 List<RecordRemise> recordRems=metier.getRecordRemRec(LblBq, cdeTr, dteInstance);
	
		if(recordRems.size()>0){
		metier.formatageChamps(recordRems, dteInstance);
		
		 dteInstance=StringUtils.replace(dteInstance, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
		 String nameFiletmp=folderREC+"\\022.031."+dteInstance+".rec.tmp";
		 String nameFile=folderREC+"\\022.031."+dteInstance+".rec";
			String header="RECO022031"+dteInstance;
		metier.createFileRec(recordRems, nameFiletmp, header, cdeTr);
		new File(nameFiletmp).renameTo(new File(nameFile));
		msg="le fichier de reconciliation WebCapture est généré    ["+nameFile+"]";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", msg));
		}
		
			else{
	    		 msg="pas de valeurs  pour la date sélectionnée  ["+dteInstance+"]";
	    		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
	    	}
		
		 
 }
 
public Date getDatetr() {
	return datetr;
}

public void setDatetr(Date datetr) {
	this.datetr = datetr;
}


public Imetier getMetier() {
	return metier;
}


public void setMetier(Imetier metier) {
	this.metier = metier;
}


public List<BeanPcapt> getPcapts() {
	return pcapts;
}

public void setPcapts(List<BeanPcapt> pcapts) {
	this.pcapts = pcapts;
}



public String[] getSelectedpcapts() {
	return selectedpcapts;
}

public void setSelectedpcapts(String[] selectedpcapts) {
	this.selectedpcapts = selectedpcapts;
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
