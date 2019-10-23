package com.ncrm.ihm.managerBeans.BAA;

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





import com.ncrm.dao.entities.BaaRecordRemLCN;
import com.ncrm.dao.entities.BaaSilcnRecord;
import com.ncrm.dao.entities.RecordRemLCN;
import com.ncrm.dao.entities.SilcnRecord;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "ExtractionSI_LcnBAABean")
@RequestScoped
public class ExtractionSILcnBean {
	
	private final String LblBq="BAA";	
	private BaaSilcnRecord SiRecords =new BaaSilcnRecord();
	List<BaaRecordRemLCN> listRems=new ArrayList<BaaRecordRemLCN>();
	
//	private String  headertable="";
	private Date dateTr= new Date();

	@ManagedProperty("#{metier}")
	 Imetier metier;
	

	@PostConstruct
public void init(){
		
//	listRems=service.getRemiseChqTraiter(formatDateToString(new Date()),"060");
	}
	
	
	public void searchbydate(){
//		Extraction data from base production && format and creat in SI file 
		String dtetrString=DateUtils.formatDateToStirng(dateTr,"yyyy-MM-dd");
		SiRecords=metier.formatChampsSILCNBaa(LblBq, dtetrString);

		if((SiRecords!=null)){
		listRems=SiRecords.getRecordRemiseLcn();
		boolean flagCre=metier.createSiLCNBaa(LblBq, dtetrString, SiRecords);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre de remise Traiter pour la date du traitement "+dtetrString+" = "+listRems.size()));
		if(flagCre){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Le fichier SI LCN est bien genere dans : "+Propriete.getInsatance().get(LblBq+".OUTDIR.SI.LCN")));
			
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Merci de voir les logs "));
		}
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "aucune remise Traiter pour la date du traitement "+dtetrString));
		}
		
		
	}
	
	
	

		

public Date getDateTr() {
		return dateTr;
	}


	public void setDateTr(Date dateTr) {
		this.dateTr = dateTr;
	}


public String MenuItemBpmextractionlotIA() {
		
		return "GetSICHQ";
    }



public Imetier getMetier() {
	return metier;
}


public void setMetier(Imetier metier) {
	this.metier = metier;
}


public List<BaaRecordRemLCN> getListRems() {
	return listRems;
}


public void setListRems(List<BaaRecordRemLCN> listRems) {
	this.listRems = listRems;
}



	
}
