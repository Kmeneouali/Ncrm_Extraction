package com.ncrm.ihm.managerBeans.SGDA;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.ncrm.dao.entities.BeanAgence;
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;
import com.ncrm.tools.Utilitaire.Iutilitaire;
import com.ncrm.tools.Utilitaire.UtilitaireImpl;



@ManagedBean(name = "AddNewPcaptSgdaBean")
@RequestScoped
public class AddNewPcaptSgmaBean {
    String cdePcapt,cdePcaptSelected,
           nomPcapt;
    String type="AG";
    String msg="";
    String cdeAge="",secteur="",circuit="";
//           libAge="";
	String lblBq="SGDA";
   
 
	List<BeanPcapt> listpcapts=new ArrayList<BeanPcapt>();
	List<BeanPcapt> listpcaptSelecteds=new ArrayList<BeanPcapt>();
  
   
    @ManagedProperty("#{metier}")
	 Imetier metier;
    
@PostConstruct
public void init(){
	
	
		
	    listpcapts =metier.getAllPcapt(lblBq);
     	listpcaptSelecteds=metier.getAllPcapt(lblBq);
//		listages=service.getAllAge();
	
}
 
 
 public void AddNewpcaptSgma(){
	 String msg="";
	 
	 
			
	 BeanPcapt pcapt=new BeanPcapt();
	 
	 pcapt.setCdePcapt(cdePcapt);
	 pcapt.setNomPcapt(nomPcapt);
	 pcapt.setType(type);
	 pcapt.setCircuit(circuit);
	 pcapt.setSecteur(secteur);
	
	 cdeAge=cdePcapt;	
	 
	 pcapt.setAgeRattachement(cdeAge);
	
     int flag=metier.AddPcapt(pcapt, lblBq);
     
	 if(flag==0 ){
		 msg=" La point Capture "+cdePcapt+"-"+nomPcapt+"-"+type+" n'est pas enregistrer Voir les log";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", msg));
	  
	 }
	 else {
		 
		 msg=" La point Capture "+cdePcapt+"-"+nomPcapt+"-"+type+" est bien enregistrer";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
          metier.AddAge(lblBq, new BeanAgence(pcapt.getAgeRattachement(), pcapt.getNomPcapt(), null, null));
		
		 }
	
	 listpcapts =metier.getAllPcapt(lblBq);
     listpcaptSelecteds=metier.getAllPcapt(lblBq);
 }
 

 public void deletePcapt(int idpcapt,String ageAtt){
	 System.out.println("cdePacapt"+idpcapt);
	 
	
			int flag=metier.deletePcapt(idpcapt,lblBq);
			if(flag==1 ){
	       msg="La supprission est bien fait"; 
	       
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", msg)); 
			
		     metier.DeleteAge(ageAtt, lblBq);
			}
			else {
				 msg="La supprission n'est pas bien fait ,voir les logs !"; 
			       
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "-", msg)); 
			}
			
			 listpcapts =metier.getAllPcapt(lblBq);
		     listpcaptSelecteds=metier.getAllPcapt(lblBq);
		
 }
 
 
 
 public void onRowEdit(RowEditEvent event) {
	 BeanPcapt pcapt=(BeanPcapt) event.getObject();

		int flag=metier.updatePcapt(pcapt.getIdpcapt(), pcapt,lblBq);
		System.out.println(pcapt.getIdpcapt());
		if(flag==1 ){
       msg="La modification est bien fait "; 
       
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", msg)); 
		listpcapts=metier.getAllPcapt(lblBq);
		listpcaptSelecteds=metier.getAllPcapt(lblBq);
		}
		else {
			 msg="La modification n'est pas bien fait ,voir les logs !"; 
		       
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "-", msg)); 
		}

 }
// 
// 

public String getCdePcapt() {
	return cdePcapt;
}


public void setCdePcapt(String cdePcapt) {
	this.cdePcapt = cdePcapt;
}


public String getNomPcapt() {
	return nomPcapt;
}


public void setNomPcapt(String nomPcapt) {
	this.nomPcapt = nomPcapt;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}




public List<BeanPcapt> getListpcapts() {
	return listpcapts;
}


public void setListpcapts(List<BeanPcapt> listpcapts) {
	this.listpcapts = listpcapts;
}


public String getCdeAge() {
	return cdeAge;
}


public void setCdeAge(String cdeAge) {
	this.cdeAge = cdeAge;
}







public List<BeanPcapt> getListpcaptSelecteds() {
	return listpcaptSelecteds;
}


public void setListpcaptSelecteds(List<BeanPcapt> listpcaptSelecteds) {
	this.listpcaptSelecteds = listpcaptSelecteds;
}


public String getCdePcaptSelected() {
	return cdePcaptSelected;
}


public void setCdePcaptSelected(String cdePcaptSelected) {
	this.cdePcaptSelected = cdePcaptSelected;
}


public Imetier getMetier() {
	return metier;
}


public void setMetier(Imetier metier) {
	this.metier = metier;
}


public String getSecteur() {
	return secteur;
}


public void setSecteur(String secteur) {
	this.secteur = secteur;
}


public String getCircuit() {
	return circuit;
}


public void setCircuit(String circuit) {
	this.circuit = circuit;
}
 



}
