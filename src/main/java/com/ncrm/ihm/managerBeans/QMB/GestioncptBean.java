package com.ncrm.ihm.managerBeans.QMB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;


import com.ncrm.dao.entities.BeanCompte;
import com.ncrm.metier.Imetier;


@ManagedBean(name = "Gestion_cptQMBBean")

public class GestioncptBean {
	
	
	private String dateIns=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	List<BeanCompte> comptes=new ArrayList<BeanCompte>();
	List<BeanCompte> selectCpts;
	BeanCompte cpt=new BeanCompte();
	private String cdecpt="",
			nomCilent="",
			cdeage="";
	String msg="";
	
	private final String LblBq="QMB";

	
	@ManagedProperty("#{metier}")
	 Imetier metier;
	

	@PostConstruct
	public void init(){
		
			
			comptes=metier.getAllComptes(LblBq);
			selectCpts=metier.getAllComptes(LblBq);
		}
		

	

	
	
	public String GetAllCompt() {
		
			comptes=metier.getAllComptes(LblBq);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre de comptes QMB dans la base de reference = "+comptes.size()));

		
		
		return "QmbGestionCpt";

	}
	
	public List<BeanCompte> getcpt(){

		return comptes;
	}
	



	public String getDateIns() {
		return dateIns;
	}


	public void setDateIns(String dateIns) {
		this.dateIns = dateIns;
	}


	

	public List<BeanCompte> getComptes() {
		return comptes;
	}

	public void setComptes(List<BeanCompte> comptes) {
		this.comptes = comptes;
	}
	public BeanCompte getCpt() {
		return cpt;
	}
	public void setCpt(BeanCompte cpt) {
		this.cpt = cpt;
	}


	public String getCdecpt() {
		return cdecpt;
	}


	public void setCdecpt(String cdecpt) {
		this.cdecpt = cdecpt;
	}


	public String getNomCilent() {
		return nomCilent;
	}


	public void setNomCilent(String nomCilent) {
		this.nomCilent = nomCilent;
	}


	public String getCdeage() {
		return cdeage;
	}


	public void setCdeage(String cdeage) {
		this.cdeage = cdeage;
	}


	public List<BeanCompte> getSelectCpts() {
		
		return selectCpts;
	}


	public void setSelectCpts(List<BeanCompte> selectCpts) {
		this.selectCpts = selectCpts;
	}






	public Imetier getMetier() {
		return metier;
	}






	public void setMetier(Imetier metier) {
		this.metier = metier;
	}


	

	





	
}
