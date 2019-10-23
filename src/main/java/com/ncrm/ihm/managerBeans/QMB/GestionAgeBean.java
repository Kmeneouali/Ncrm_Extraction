package com.ncrm.ihm.managerBeans.QMB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


import com.ncrm.dao.entities.BeanAgence;
import com.ncrm.dao.entities.beanScann;
import com.ncrm.metier.Imetier;

@ManagedBean(name = "Gestion_AgeQMBBean")
@SessionScoped
public class GestionAgeBean {
	
	
	private String dateIns=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	private String codeAgence,
	nomAge;
	private String selecttypepcapt="AG";
	private String cdeScanner;
	private String msg;
	
	List<BeanAgence> agences=new ArrayList<BeanAgence>();
	List<BeanAgence> selectages=new ArrayList<BeanAgence>();
	List<beanScann> scanners=new ArrayList<beanScann>();
	boolean activePcapt;
	

private final String LblBq="QMB";

	
	@ManagedProperty("#{metier}")
	 Imetier metier;
	

	BeanAgence age= new BeanAgence();
	
public GestionAgeBean() {
		super();
		
		
		
	}

@PostConstruct
public void init(){
	agences=metier.getAllAgences(LblBq);
	selectages=metier.getAllAgences(LblBq);
	
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre d'agences QMB dans la base de reference  = "+agences.size()));

}
// ************************ MEthods Action **********************************





public String GetAllAges(){
	agences=metier.getAllAgences(LblBq);
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre d'agences QMB dans la base de reference  = "+agences.size()));

	return "QmbGestionAgence";
	
}



public List<beanScann> getScanner(){
	age=metier.getagebycde(codeAgence,LblBq);
	scanners=metier.getScannerByage(age.getAGE(), LblBq);
    
	
	return scanners;
}


public void saveScanner(){
	
	beanScann sc=new beanScann(cdeScanner, codeAgence, selecttypepcapt, "");
	metier.AddScanner(sc,LblBq);
    scanners=metier.getScannerByage(codeAgence,LblBq);
    cdeScanner="";

}

//*********************************************************************************
	
//      ***** Getters &&setters 




	public String getDateIns() {
		return dateIns;
	}


	public void setDateIns(String dateIns) {
		this.dateIns = dateIns;
	}


	public List<BeanAgence> getAgences() {
		return agences;
	}


	public void setAgences(List<BeanAgence> agences) {
		this.agences = agences;
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	
	public BeanAgence getAge() {
		age=metier.getagebycde(codeAgence,LblBq);
		scanners=metier.getScannerByage(age.getAGE(), LblBq);
		return age;
	}

	public void DetailAge(String cdeAge){
		System.out.println(cdeAge);
		setCodeAgence(cdeAge);
		scanners=metier.getScannerByage(codeAgence,LblBq);
				
	}
	public void setAge(BeanAgence age) {
		this.age = age;
	}

	public String getSelecttypepcapt() {
		return selecttypepcapt;
	}

	public void setSelecttypepcapt(String selecttypepcapt) {
		this.selecttypepcapt = selecttypepcapt;
	}
	public String getCdeScanner() {
		return cdeScanner;
	}
	public void setCdeScanner(String cdeScanner) {
		this.cdeScanner = cdeScanner;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<beanScann> getScanners() {
		scanners=metier.getScannerByage(codeAgence,LblBq);
		return scanners;
	}
	public void setScanners(List<beanScann> scanners) {
		this.scanners = scanners;
	}


	public String getNomAge() {
		return nomAge;
	}


	public void setNomAge(String nomAge) {
		this.nomAge = nomAge;
	}


	public List<BeanAgence> getSelectages() {
		
		return selectages;
	}


	public void setSelectages(List<BeanAgence> selectages) {
		this.selectages = selectages;
	}

	public boolean isActivePcapt() {
		return activePcapt;
	}

	public void setActivePcapt(boolean activePcapt) {
		this.activePcapt = activePcapt;
	}

	public Imetier getMetier() {
		return metier;
	}

	public void setMetier(Imetier metier) {
		this.metier = metier;
	}


	


	
}
