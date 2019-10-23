package com.ncrm.ihm.managerBeans;

import java.text.Format;
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

import com.ncrm.dao.entities.RecordRemChq;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "ManagedBeanSIChq")
@RequestScoped
public class ManagedBeanSIChq {
	
	private List<RecordRemChq> listRems=new ArrayList<RecordRemChq>();
	private Date dateTr=new Date();

	
	
	 
	 @ManagedProperty("#{metier}")
	 Imetier metier;

	@PostConstruct
public void init(){
		
//			listRems=metier.getAllRemChqTraiterFlager("BPM");	
	}
	
	
	
	public void searchbydate(String LblBq){
		
		if(dateTr!=null){
		String dtetrString=DateUtils.formatDateToStirng(dateTr,"yyyy-MM-dd");
		listRems=metier.getRemChqTraiterFlagerByDte(LblBq,dtetrString);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre de remise Traiter pour la date du traitement "+dtetrString +" = "+listRems.size()));
		}
		else {
			listRems=metier.getAllRemChqTraiterFlager(LblBq);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre de remise Traiter dans la base =" +listRems.size()));
			
		}
		
	}

	
	
	
	

	public List<RecordRemChq> getListRems() {
		return listRems;
	}

	public void setListRems(List<RecordRemChq> listRems) {
		this.listRems = listRems;
	}

	public Date getDateTr() {
		return dateTr;
	}

	public void setDateTr(Date dateTr) {
		this.dateTr = dateTr;
	}

	public Imetier getMetier() {
		return metier;
	}

	public void setMetier(Imetier metier) {
		this.metier = metier;
	}






	
}
