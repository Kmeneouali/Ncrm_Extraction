package com.ncrm.ihm.managerBeans.NAJMAH;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.ncrm.library.utils.DirUtils;
import com.ncrm.library.utils.FileUtils;
import com.ncrm.library.utils.JasperUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.library.utils.ZipUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "Etats_ChqNAJMAHBean")
@RequestScoped
public class EtatsChqBean {
	
	private final String LblBq="NAJMAH";
	private final  String cdeBq=Propriete.getInsatance().get(LblBq+".cde.bq");
	private final String folderOut=Propriete.getInsatance().get(LblBq+".FOLDER.ETA.CHQ");
//	private static final String folderREC = Propriete.getInsatance().get("SGDA.OUT.REC");
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
    private static final Logger logger = Logger.getLogger(EtatsChqBean.class);
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
	
	  }
	  else {
	    	 msg=" un problème et produit lorsque vous supprimez la table temporaire merci de voir les logs ";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg)); 
	     }
	
 }
 
 
 
 
 
 public void editetatsChq(){
	    parameters = new HashMap<String, Object>();
	    String dteInstance=DateUtils.formatDateToStirng(datetr,"yyyy-MM-dd");
	    String dteInstanceFolder=StringUtils.replace(dteInstance, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
	    List<String> list= null;
	    List<BeanPcapt> listpcaptSelected= null;
	    
	    List<String> listTrt= null;
	    List<BeanTrt> listTrtSelected =null;
		
	    try {
			parameters.put("dateInstance",DateUtils.formatStringToDate(dteInstance,"yyyy-MM-dd"));
			
			if(selectedpcapts.length>0 && selectedTrts.length>0){
				
				 list= new ArrayList<String>(Arrays.asList(selectedpcapts));
			     listpcaptSelected= metier.getGetPcaptByCde(LblBq,list );
			      listTrt= new ArrayList(Arrays.asList(selectedTrts));
				 listTrtSelected =metier.getGetTrtByCde(LblBq,listTrt);
				 String outDir="";
				 String outDirtr="";
				 String nameZip="";
				    
			for(BeanPcapt p:listpcaptSelected) 
			{
				
				logger.debug("@@@    [ Point de capture = "+p.getCdePcapt()+" - "+p.getNomPcapt()+" ]");
				
					parameters.put("cdepointCapture",p.getCdePcapt());
					parameters.put("pointCapture",p.getNomPcapt());	
				
//					
				for (BeanTrt t:listTrtSelected) 
				{
					
					outDirtr=t.getDossierEnre();
				if  (!t.getNom_Traitement().equalsIgnoreCase("ETA_CHQ_SGDA_CRT"))
					{
					
					if (t.getNom_Traitement().equalsIgnoreCase("ETA_CHQ_SGDA_AG"))
						{
						parameters.put("age_rattachement",p.getAgeRattachement());
						parameters.put("flag_scan_gr","0");
						
						}
				else
					if(t.getNom_Traitement().equalsIgnoreCase("ETA_CHQ_SGDA_GR"))
						{
						parameters.put("flag_scan_gr","1");
						}
					
						
					for (BeanReport rep : metier.getReportByTrt(LblBq, t.getIdT())) 
							{
								
								if(rep.isActive())
								{
//									outDir = t.getDossierEnre()+ "//" + p.getCdePcapt() + "//"+ dteInstanceFolder;
									outDir=t.getDossierEnre()+"//"+cdeBq+"_"+cdeTr+"_"+ p.getCdePcapt() + "_"+ dteInstanceFolder+"_ETA";
									String namePdfFile = rep.getId_report()+ "_" + p.getCdePcapt() + "_"+ dteInstanceFolder + ".pdf";	
									nameZip=outDir+".zip";
									
									metier.ReportPdf(rep.getModeleJRXML(),parameters, null, outDir,namePdfFile);
								}
						}
					
					
					
					     ZipUtils.zipDir(outDir, nameZip);
					   DirUtils.deleteDir(outDir);
				}
				
				else
				{
					
					
					
					for (BeanReport rep : metier.getReportByTrt(LblBq, t.getIdT())) 
						
					{
						
						
						if(rep.isActive())
						{
//							 outDir = t.getDossierEnre()+ "//" + "CRT" + "//"+ dteInstanceFolder;
							outDir=t.getDossierEnre()+"//"+cdeBq+"_"+cdeTr+"_"+ "CRT" + "_"+ dteInstanceFolder+"_ETA";
							String  namePdfFile = rep.getId_report()+ "_"+ dteInstanceFolder + ".pdf";						
							nameZip=outDir+".zip";
							metier.ReportPdf(rep.getModeleJRXML(),parameters, null, outDir,namePdfFile);
						}
				}
					ZipUtils.zipDir(outDir, nameZip);
					 DirUtils.deleteDir(outDir);
				}
				
				
				}
				
				 
			}
			
			msg="les etats sont bien généré dans  "+outDirtr;
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));

	    }
	else{
		 msg=" Merci de selectionner Traitement (s) & point(s) capture  ";
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
