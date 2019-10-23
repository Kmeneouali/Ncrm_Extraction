package com.ncrm.ihm.managerBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.ncrm.dao.entities.RecordLotLcn;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;





@ManagedBean(name = "ManagedBeanLotLcn")
@RequestScoped
public class ManagedBeanLotLcn {

	private Date dateTraitement=new Date(),
			     datePresentation;

	List<RecordLotLcn> recordsLotLcn=new ArrayList<RecordLotLcn>();

 @ManagedProperty("#{metier}")
 Imetier metier;
	
	
	
	public void ExtrationLotIA(String LblBq)
    {
		
		
		String OUTDIR_LOT_LCN_IA=Propriete.getInsatance().get(LblBq+".OUTDIR.LOT.IA.LCN");
        String dtePrString=DateUtils.formatDateToStirng(datePresentation,"yyyy-MM-dd");
        recordsLotLcn=metier.formatChampsLotLcn("IA", dtePrString, LblBq);
        	if(recordsLotLcn.size()>0)
        	{
        		
        			boolean flagCre=metier.createLotLCN(LblBq,"IA", dtePrString, recordsLotLcn);
        			if(flagCre)
        			{
        				
        				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", " Nombre de valeur IA presenter le  "+dtePrString+" == "+recordsLotLcn.size() ));
        				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"-", " le fichier LOT IA est enregistrer dans :  "+ OUTDIR_LOT_LCN_IA));
        			}
        			else 
        			{
        				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", " erreur durant la creation du fichier LOT LCN voir les logs " ));	
        			}
        			
        	}
        	else 
        	{
        		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", " Dans la base aucun enregistrement avec date de Presentation = "+dtePrString ));
        	}
 	
    }
	
	
	
	public void ExtrationLotConf(String LblBq)
    {
		
			
			String OUTDIR_LOT_LCN_CONF=Propriete.getInsatance().get(LblBq+".OUTDIR.LOT.LCN");
            String dtePrString=DateUtils.formatDateToStirng(datePresentation,"yyyy-MM-dd");
		    recordsLotLcn=metier.formatChampsLotLcn("CONF", dtePrString, LblBq);
	if(recordsLotLcn.size()>0)
	{
		
			boolean flagCre=metier.createLotLCN(LblBq,"CONF", dtePrString, recordsLotLcn);
			if(flagCre)
			{
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", " Nombre de valeur presenter le  "+dtePrString+" == "+recordsLotLcn.size() ));
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"-", " le fichier LOT est enregistrer dans :  "+ OUTDIR_LOT_LCN_CONF));
			}
			else 
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", " erreur durant la creation du fichier LOT LCN voir les logs " ));	
			}
			
	}else 
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", " Dans la base aucun enregistrement avec date de Presentation = "+dtePrString ));
	}

        	
       
		
    }
	
	public String MenuItemBpmextractionlotConf() {
	
		return "BpmextractionlotConf";
    }
	
	
	public String MenuItemBpmextractionlotIA() {
		
		return "BpmextractionlotIA";
    }
	
	
	
	public void dateChange(SelectEvent event) {
		Date date = (Date) event.getObject();
		System.out.println(date);
		datePresentation=DateUtils.getdateFerierandWeenkend(dateTraitement);
		//Add facesmessage
		}
	// Getters et Setters
	
	public Date getDateTraitement() {
		return dateTraitement;
	}

	public void setDateTraitement(Date dateTraitement) {
		this.dateTraitement = dateTraitement;
	}

	public Date getDatePresentation() {
		return DateUtils.getdateFerierandWeenkend(dateTraitement);
	}

	public void setDatePresentation(Date datePresentation) {
		this.datePresentation = datePresentation;
	}



	public Imetier getMetier() {
		return metier;
	}



	public void setMetier(Imetier metier) {
		this.metier = metier;
	}


	
	
	

	



	
	

}
