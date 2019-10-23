package com.ncrm.ihm.managerBeans;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ncrm.dao.entities.RecordLotChq;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;


@ManagedBean(name = "ManagedBeanLotChq")
@RequestScoped
public class ManagedBeanLotChq {


private Date dateTraitement=new Date();
List<RecordLotChq> recordsLotChq;


	@ManagedProperty("#{metier}")
	 Imetier metier;

	
	public void ExtrationLotChq(String LblBq)
    {
		 String cdeBq=Propriete.getInsatance().get(LblBq+".cde.bq");
		 String OUTDIR_LOT_CHQ=Propriete.getInsatance().get(LblBq+".OUTDIR.LOT.CHQ");
		String dtetrString=DateUtils.formatDateToStirng(dateTraitement,"yyyy-MM-dd");
		
		recordsLotChq= metier.formatChampsLotChq(dtetrString, LblBq);
		
		if(recordsLotChq.size()>0){
			boolean flagCre=metier.createLotChq(LblBq, dtetrString, recordsLotChq);
			if(flagCre){
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", " Nombre de valeur traiter le  "+dtetrString+" == "+recordsLotChq.size() ));
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"-", " le fichier LOT est enregistrer dans :  "+ OUTDIR_LOT_CHQ));
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", " erreur durant la creation du fichier LOT Chèque voir les logs " ));	
			}
			
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", " Dans la base aucun enregistrement avec date de traitement = "+dtetrString ));	
		}

    }
	
	
	
	
	
	
	
	
	
	public Date getDateTraitement() {
		return dateTraitement;
	}

	public void setDateTraitement(Date dateTraitement) {
		this.dateTraitement = dateTraitement;
	}


	public List<RecordLotChq> getRecordsLotChq() {
		return recordsLotChq;
	}

	public void setRecordsLotChq(List<RecordLotChq> recordsLotChq) {
		this.recordsLotChq = recordsLotChq;
	}

	public Imetier getMetier() {
		return metier;
	}


	public void setMetier(Imetier metier) {
		this.metier = metier;
	}

	


	
	
	
}
