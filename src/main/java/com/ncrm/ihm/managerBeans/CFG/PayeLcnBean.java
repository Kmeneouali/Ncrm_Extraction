package com.ncrm.ihm.managerBeans.CFG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ncrm.SessionBean;
import com.ncrm.dao.entities.BeanCountpye;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;



@ManagedBean(name = "paye_LcnCFGBean")
@SessionScoped
public class PayeLcnBean implements Serializable {
	
	
	

	private String msg="";
	 String lblBq="CFG";


	 HttpSession session = SessionBean.getSession();
	 String username= (String) session.getAttribute("username");
	
		 @ManagedProperty("#{metier}")
		 Imetier metier;
		 List<BeanCountpye> listCountpay=new ArrayList<BeanCountpye>();
		 List<BeanCountpye> filterlistCountpay;
		 
		 @PostConstruct
		 public void init(){
			 
//			 filterlistCountpay=metier.getCountValue(lblBq, "LCN");
//			 listCountpay=metier.getCountValue(lblBq, "LCN");
//	
		 }
		 
		
		public void ReptionFile()
		{
			String INDIR=Propriete.getInsatance().get(lblBq+".FOLDER.IN.CLASSIFY.PAYEE."+"LCN");
			String OUTDIR=Propriete.getInsatance().get(lblBq+".FOLDER.OUT.CLASSIFY.PAYEE."+"LCN");
				if(metier.receptionFichierPayer(lblBq, "LCN"))
				{
					msg=" la reception du fichier est faite avec success  !";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg)); 
					
					 filterlistCountpay=metier.getCountValue(lblBq, "LCN");
					 listCountpay=metier.getCountValue(lblBq, "LCN");
					if (listCountpay.size()>0)
					{
					metier.createFileSuiviPhysique(lblBq, "LCN",null,null,username,null);
					msg=" le  fichier Machine Traitement LCN est crees avec succes  dans :"+OUTDIR+"\\"+username;
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", msg)); 	
					}
					else 
					{
						msg=" Erreur Erreur durant la creation du fichier Machine Traitement LCNs (Voir les logs)  !";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", msg)); 	
					}
					
				}
				else
				{
					msg=" Merci de verifier que le fichier IN est bien place dans le dossier IN  : "+INDIR;
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", msg)); 
				}

				
		}
	
	


	


	



	public List<BeanCountpye> getListCountpay() {
		return listCountpay;
	}
	public void setListCountpay(List<BeanCountpye> listCountpay) {
		this.listCountpay = listCountpay;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	






	
	
	
	public List<BeanCountpye> getFilterlistCountpay() {
		return filterlistCountpay;
	}


	public void setFilterlistCountpay(List<BeanCountpye> filterlistCountpay) {
		this.filterlistCountpay = filterlistCountpay;
	}


	public Imetier getMetier() {
		return metier;
	}
	public void setMetier(Imetier metier) {
		this.metier = metier;
	} 

	


	
}
