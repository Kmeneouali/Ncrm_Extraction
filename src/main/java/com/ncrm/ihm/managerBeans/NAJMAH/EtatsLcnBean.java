package com.ncrm.ihm.managerBeans.NAJMAH;


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
import org.primefaces.event.SelectEvent;

import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanReport;
import com.ncrm.dao.entities.BeanTrt;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "Etats_LcnNAJMAHBean")
@RequestScoped
public class EtatsLcnBean {
	
	Map<String, Object> parameters ;
    private static final Logger logger = Logger.getLogger(EtatsLcnBean.class);
    Date datetr=new Date();
    Date datePr=new Date();
    String msg="";
	private final String LblBq="SGDA";
	private final  String cdeBq=Propriete.getInsatance().get(LblBq+".cde.bq");
	private final String folderOut=Propriete.getInsatance().get(LblBq+".FOLDER.ETA.CHQ");
	private final  String cdeTr="060";
	private String[] selectedpcapts;
	 private List<BeanPcapt> pcapts;
	 private String[] selectedTrts;
	 private List<BeanTrt> trts;
	@ManagedProperty("#{metier}")
	 Imetier metier;
	 
	
	@PostConstruct
	 public void init() {
	    	pcapts = metier.getAllPcapt(LblBq);
	    	trts=metier.getAlltrt(LblBq,cdeTr);
	    	
//	    	pcapts.add(new BeanPcapt("01001", "Test", "type", "ageRattachement", true));
//	    	pcapts.add(new BeanPcapt("01002", "Test2", "type", "ageRattachement", true));
	    }
	
    


 
 
 public void extraireetatsLcn(){
	
	
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
		 
//		 msg=" Pour la date ="+dtetrString+" il y a "+countValues +" valeurs traitees ";
//		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
//		 msg="les "+countValues +" valeurs traitees sont bien extraites dans un fichier plat .csv [ "+ folderOut +" ]";
//		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", msg)); 
		
	      }
	
	
	
 }
 
 
 
 
 public void editetatsLCN(){
	    parameters = new HashMap<String, Object>();
	    String dteInstance=DateUtils.formatDateToStirng(datetr,"yyyy-MM-dd");
	    String dtepres=DateUtils.formatDateToStirng(datePr,"yyyy-MM-dd");
	    String dteInstanceFolder=StringUtils.replace(dteInstance, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
	    List<String> list= new ArrayList(Arrays.asList(selectedpcapts));
	    List<BeanPcapt> listpcaptSelected= metier.getGetPcaptByCde(LblBq,list );
	    
	    List<String> listTrt= new ArrayList(Arrays.asList(selectedTrts));
	    List<BeanTrt> listTrtSelected =metier.getGetTrtByCde(LblBq,listTrt);
		
	    try {
			parameters.put("dateInstance",DateUtils.formatStringToDate(dteInstance,"yyyy-MM-dd"));
			parameters.put("dtepre",DateUtils.formatStringToDate(dtepres,"yyyy-MM-dd"));
			
		
			for(BeanPcapt p:listpcaptSelected) 
			{
				
				logger.debug("@@@    [ Point de capture = "+p.getCdePcapt()+" - "+p.getNomPcapt()+" ]");
				
					parameters.put("cdepointCapture",p.getCdePcapt());
					parameters.put("pointCapture",p.getNomPcapt());	
				
				for (BeanTrt t:listTrtSelected) 
				{
					
				if  (!t.getNom_Traitement().equalsIgnoreCase("ETA_LCN_SGMA_CRT"))
					{
					
					if (t.getNom_Traitement().equalsIgnoreCase("ETA_LCN_SGMA_AG"))
						{
						parameters.put("age_rattachement",p.getAgeRattachement());
						parameters.put("flag_scan_gr","0");
						
						}
				else
					if(t.getNom_Traitement().equalsIgnoreCase("ETA_LCN_SGMA_GR"))
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

 
 
 
 public void dateChange(SelectEvent event) {
		Date date = (Date) event.getObject();
		System.out.println(date);
		datePr=DateUtils.getdateFerierandWeenkend(datetr);
		//Add facesmessage
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






public Date getDatePr() {
	return datePr=DateUtils.getdateFerierandWeenkend(datetr);
}






public void setDatePr(Date datePr) {
	this.datePr = datePr;
}
 



}
