package com.ncrm.ihm.managerBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import com.ncrm.dao.entities.BeanCountImpy;
import com.ncrm.dao.entities.BeanImpChq;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;



@ManagedBean(name = "ManagedBeanImpChq")
@RequestScoped
public class ManagedBeanImpChq {
	
	
	
	private List<BeanCountImpy> listCountImpayeeChq=new ArrayList<BeanCountImpy>();
	private String msg="";
	
	 Date dteTr1=new Date(),
		  dteTr2=new Date();
	
	
		
		String cdeTr="031";

		 List<BeanImpChq> listimpayChq=null;
	
	
		 @ManagedProperty("#{metier}")
		 Imetier metier;
		
		public void ExtraireImpyeeChq(String lblBq)
		{
			
				
				
				List<BeanImpChq> listimpayChq=metier.readFromCroCHQ(lblBq);
				if(listimpayChq.size()>0){
					 msg=" === Impayees Confreres === ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir du fichier CRO est fait correctement [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					listimpayChq=metier.readFromProdCHQ(listimpayChq, lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					listimpayChq=metier.readFromIFPConfCHQ(lblBq,listimpayChq);
					 msg=" 3- Chargement des donnes a partir des fichiers IFP CONF [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 
					 listimpayChq=metier.loadImpysCHQ(listimpayChq, lblBq);	 
					 msg=" 4- Insertion des impayees CONF dans la table temporaire [ Nombre des impayees CONF ="+listimpayChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
				}else
				{
					 msg="Le fichier CRO n est pas traite correctement ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
				}
					 
				     
				     
				List<BeanImpChq> listimpayIAChq=metier.readFromIFPIACHQ(lblBq);
					 if(listimpayIAChq.size()>0){
						 msg=" === Impayees Inter-Agences === ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir des fichiers IFP IA [ Nombre des impayees IA ="+listimpayIAChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 listimpayIAChq=metier.readFromProdIACHQ(listimpayIAChq,formatDateTostirng(dteTr1, "yyyy-MM-dd"), lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees IA ="+listimpayIAChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
					 
					 listimpayIAChq=metier.loadImpysCHQ(listimpayIAChq, lblBq);	 
					 msg=" 3- Insertion des impayees IA dans la table temporaire [ Nombre des impayees IA ="+listimpayIAChq.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
				
					
					 }else {
						 msg="Le fichier IFP IA n est pas traite correctement  ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
					 }
					 
					 listCountImpayeeChq=metier.getImpyChqByBq(lblBq);
				
			
			
		}
	public void ExporterImpyeeChq(String lblBq){
		
		
	
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
	


	public List<BeanCountImpy> getListCountImpayeeChq() {
		return listCountImpayeeChq;
	}



	public void setListCountImpayeeChq(List<BeanCountImpy> listCountImpayeeChq) {
		this.listCountImpayeeChq = listCountImpayeeChq;
	}



	public List<BeanImpChq> getListimpayChq() {
		return listimpayChq;
	}



	public void setListimpayChq(List<BeanImpChq> listimpayChq) {
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

	


	
}
