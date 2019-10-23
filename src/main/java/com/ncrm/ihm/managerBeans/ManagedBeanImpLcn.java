package com.ncrm.ihm.managerBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ncrm.dao.entities.BeanCountImpy;
import com.ncrm.dao.entities.BeanImpLcn;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;



@ManagedBean(name = "ManagedBeanImpLcn")
@RequestScoped
public class ManagedBeanImpLcn {
	
	
	
	private List<BeanCountImpy> listCountImpayeeLcn=new ArrayList<BeanCountImpy>();
	private String msg="";
	
	 Date dteTr1=new Date(),
		  dteTr2=new Date();
	
	 
	 
		String cdeTr="060";

		 List<BeanImpLcn> listimpayLcn=null;
	
	
		 @ManagedProperty("#{metier}")
		 Imetier metier;
		
		public void ExtraireImpyeeLCN(String lblBq)
		{
			
				
				
				List<BeanImpLcn> listimpayLcn=metier.readFromCroLCN(lblBq);
				if(listimpayLcn.size()>0){
					 msg=" === Impayees Confreres === ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir du fichier CRO est fait correctement [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 listimpayLcn=metier.readFromProdLCN(listimpayLcn, lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					listimpayLcn=metier.readFromIFPConfLCN(listimpayLcn,lblBq);
					 msg=" 3- Chargement des donnes a partir des fichiers IFP CONF [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 
					 listimpayLcn=metier.loadImpysLCN(listimpayLcn, lblBq);	 
					 msg=" 4- Insertion des impayees CONF dans la table temporaire [ Nombre des impayees CONF ="+listimpayLcn.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
				}else
				{
					 msg="Le fichier CRO n est pas traite correctement ";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
				}
					 
				     
				     
				List<BeanImpLcn> listimpayIALCN=metier.readFromIFPIALCN(lblBq);
					 if(listimpayIALCN.size()>0){
						 msg=" === Impayees Inter-Agences === ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 msg=" 1- Chargement des donnes a partir des fichiers IFP IA [ Nombre des impayees IA ="+listimpayIALCN.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					 
					 listimpayIALCN=metier.readFromProdIALCN(listimpayIALCN,formatDateTostirng(dteTr1, "yyyy-MM-dd"), lblBq);
					 msg=" 2- Chargement des donnes a partir de la BDD Production [ Nombre des impayees IA ="+listimpayIALCN.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
					
					 
					 listimpayIALCN=metier.loadImpysLCN(listimpayIALCN, lblBq);	 
					 msg=" 3- Insertion des impayees IA dans la table temporaire [ Nombre des impayees IA ="+listimpayIALCN.size()+"]";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
				
					
					 }else {
						 msg="Le fichier IFP IA n est pas traite correctement  ";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn", msg));
					 }
					 
					 listCountImpayeeLcn=metier.getImpyLcnByBq(lblBq);
				
			
			
		}
	public void ExporterImpyeeLCN(String lblBq){
		
		String folderOut=Propriete.getInsatance().get(lblBq+".FOLDER.OUT.IMP.LCN");	
	
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
	


	public List<BeanCountImpy> getListCountImpayeeLCN() {
		return listCountImpayeeLcn;
	}



	public void setListCountImpayeeLCN(List<BeanCountImpy> listCountImpayeeLCN) {
		this.listCountImpayeeLcn = listCountImpayeeLCN;
	}



	public List<BeanImpLcn> getlistimpayLcn() {
		return listimpayLcn;
	}



	public void setlistimpayLcn(List<BeanImpLcn> listimpayLcn) {
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
