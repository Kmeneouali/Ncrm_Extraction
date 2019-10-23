package com.ncrm.ihm.managerBeans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "ManagedBeanEtat")
@RequestScoped
public class ManagedBeanEtat {
	
//	private final String LblBq="QMB";
//	
//	private final  String cdeTr="031";
	
	@ManagedProperty("#{metier}")
	 Imetier metier;
	 
    Date datetr=new Date();
    String msg="";


 
 
 public void extraireetats(String LblBq,String cdeTr){
	  String cdeBq=Propriete.getInsatance().get(LblBq+".cde.bq");
	  String lbltrt;
	  if(cdeTr.equals("031")) {
		  lbltrt="CHQ";
	  }
	  else {
		  lbltrt="LCN";
	  }
	  String folderOut=Propriete.getInsatance().get(LblBq+".FOLDER.ETA."+lbltrt);
	  String dtetrString=DateUtils.formatDateToStirng(datetr,"yyyy-MM-dd");
	  
	  int countValues=metier.extractDataEta(LblBq, cdeTr, dtetrString);
	 
	 if(countValues==0){
		 msg=" aucune instance pour la date selectionne ="+dtetrString;
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", msg));
	  
	 }
	 else 
	   {
		 msg=" Pour la date ="+dtetrString+" il y a "+countValues +" valeurs traitees ";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
		 msg="les "+countValues +" valeurs traitees sont bien extraites dans un fichier plat .csv [ "+ folderOut +" ]";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", msg)); 
		
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
 


 
}
