package com.ncrm.ihm.managerBeans.CFG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.ncrm.SessionBean;
import com.ncrm.dao.entities.BeanCountpye;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;



@ManagedBean(name = "paye_ChqCFGBean")
@SessionScoped
public class PayeChqBean implements Serializable {
	
	
	

	private String msg="";
	
	 Date dteTr1=new Date(),
		  dteTr2=new Date();
	 String lblBq="CFG";
	 String cdeBq=Propriete.getInsatance().get(lblBq+".cde.bq");
		
		String cdeTr="031";
		 HttpSession session = SessionBean.getSession();
		 String username= (String) session.getAttribute("username");
		 List<BeanCountpye> listCountpay=new ArrayList<BeanCountpye>();
		 List<BeanCountpye> filterlistCountpay=null;
		 StreamedContent pdfDocument; 
		 private String idreport;
		 String dteJour = DateUtils.formatDateToStirng(new Date(), "yyyyMMdd_HHMMss");
		 Map<String, Object> parameters = null;
		 @ManagedProperty("#{metier}")
		 Imetier metier;
		 
		 
		 @PostConstruct
		 public void init(){
			 
			 filterlistCountpay=metier.getCountValue(lblBq, "CHQ");
			 listCountpay=metier.getCountValue(lblBq, "CHQ");
	
		 }
		 
		
		public void ReptionFile()
		{
			String INDIR=Propriete.getInsatance().get(lblBq+".FOLDER.IN.CLASSIFY.PAYEE."+"CHQ");
			String OUTDIR=Propriete.getInsatance().get(lblBq+".FOLDER.OUT.CLASSIFY.PAYEE."+"CHQ");
				if(metier.receptionFichierPayer(lblBq, "CHQ"))
				{
					msg=" la reception du fichier est faite avec success  !";
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg)); 
					
					 filterlistCountpay=metier.getCountValue(lblBq, "CHQ");
					 listCountpay=metier.getCountValue(lblBq, "CHQ");
					if (listCountpay.size()>0)
					{
					metier.createFileSuiviPhysique(lblBq, "CHQ",null,null,username,null);
					msg=" le  fichier Machine Traitement cheques est crees avec succes  dans :"+OUTDIR+"\\"+username;
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", msg)); 	
					}
					else 
					{
						msg=" Erreur Erreur durant la creation du fichier Machine Traitement cheques (Voir les logs)  !";
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", msg)); 	
					}
					
				}
				else
				{
					msg=" Merci de verifier que le fichier IN est bien place dans le dossier IN  : "+INDIR;
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", msg)); 
				}

				 
		}
	
	


	

		public void ImprimeReport(){
			
			String Report = null;
			parameters = new HashMap<String, Object>();
					try {
						
						System.out.println(idreport);
						if(!idreport.equalsIgnoreCase("null")){
							if(idreport.equalsIgnoreCase("valueMoin")){
								Report="/jrxml/CFG/SuiviPhysique/CHQ/ETA_CHQ_valueMoin.jasper";
						
							}
							else if(idreport.equalsIgnoreCase("valuePlus")){
	                        	Report="/jrxml/CFG/SuiviPhysique/CHQ/ETA_CHQ_valuePlus.jasper";	
							}
							
	                        
							
							
						
						


							String NameFile = idreport+ "_"+generateRandomIdForNotCaching()+"_"+dteJour+".pdf";
							
							// logger.debug("=== Editer l'etat  ["+NameFile+"] pour les point de capture ["+listparams+"] ");
							
//						#####	parameters.put("listparams", listparams);
							

							ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
							String realPath = ctx.getRealPath("/")+"\\workspaceTemp";
							
							// logger.debug("=== Editer l'etat  ["+realPath+"\\"+NameFile+"] pour la selection : ["+listparams+"] ");
							
							
							pdfDocument=refreshStream(metier.ReportPdf2(Report,parameters, null, realPath, NameFile));
//							msg = "L'impission  !!";
//							FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));

						}
						else {
							msg = "Veuillez sélectionner un etat";
							FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
						}
					} catch (Exception  e) {
						// logger.debug("+++  Exception  ImprimeReport "+e.getMessage(),e);
					}
					
			
			
		}
		
		
		
		public void deletepdftmp(){
			
			try {
				if(pdfDocument.getName()!=null){
					// logger.debug("=== Supprimer le fichier temp  : [ "+pdfDocument.getName()+" ] ");
				new File(pdfDocument.getName()).delete();
				}
				else {
					pdfDocument=new DefaultStreamedContent();
				}
			} catch (Exception e) {
				System.out.println("Exception");
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


	public StreamedContent getPdfDocument() {
		return pdfDocument;
	}


	public void setPdfDocument(StreamedContent pdfDocument) {
		this.pdfDocument = pdfDocument;
	}


	public String getIdreport() {
		return idreport;
	}


	public void setIdreport(String idreport) {
		this.idreport = idreport;
	} 

	public String generateRandomIdForNotCaching() {
		return java.util.UUID.randomUUID().toString();
}
	private StreamedContent createStream(String fileName) {
		File file = new File(fileName);
		InputStream inputStream=null;
		try {
			inputStream = new FileInputStream(file);
	
		} catch (IOException e) {
			
//			logger.debug("+++  IOException  createStream "+e.getMessage(),e);
		}
		 catch (Exception e) {
			
//			logger.debug("+++  IOException  createStream "+e.getMessage(),e);
		}
		DefaultStreamedContent streamedContent = new DefaultStreamedContent(inputStream, "application/pdf",fileName);
		return streamedContent;
}	
		
	public StreamedContent refreshStream(String pathpdf) {
		return createStream(pathpdf);
}

	
}
