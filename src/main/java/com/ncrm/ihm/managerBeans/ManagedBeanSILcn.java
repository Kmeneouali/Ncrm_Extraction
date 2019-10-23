package com.ncrm.ihm.managerBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ncrm.dao.entities.RecordRemLCN;
import com.ncrm.dao.entities.SilcnRecord;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "ManagedBeanSILcn")
@RequestScoped
public class ManagedBeanSILcn {
	

	private SilcnRecord SiRecords =new SilcnRecord();
	List<RecordRemLCN> listRems=new ArrayList<RecordRemLCN>();

	private Date dateTr= new Date();

	@ManagedProperty("#{metier}")
	 Imetier metier;
	

	@PostConstruct
public void init(){
		
//	listRems=service.getRemiseChqTraiter(formatDateToString(new Date()),"060");
	}
	

	
	public void extraireSiLcn (String LblBq){
		String folderOut=Propriete.getInsatance().get(LblBq+".OUTDIR.SI.LCN");
		String dtetrString=DateUtils.formatDateToStirng(dateTr,"yyyy-MM-dd");
		SiRecords=metier.formatChampsSILCN(LblBq, dtetrString);
		if((SiRecords!=null)){
		
		boolean flagCre=metier.createSiLCN(LblBq, dtetrString, SiRecords);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nombre de remise Traiter pour la date du traitement "+dtetrString+" = "+SiRecords.getHeaderSiLcn().getNbrRemise()));
		 String msg="chemin fichier generé [ "+ folderOut +" ]";
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "-", msg)); 
		 listRems=SiRecords.getRecordRemiseLcn();
		 System.out.println("listRems.size() ==> "+listRems.size());
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




public List<RecordRemLCN> getListRems() {
	return listRems;
}


public void setListRems(List<RecordRemLCN> listRems) {
	this.listRems = listRems;
}


public Imetier getMetier() {
	return metier;
}


public void setMetier(Imetier metier) {
	this.metier = metier;
}



	
}
