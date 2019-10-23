package com.ncrm.ihm.managerBeans.SGMA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ncrm.SessionBean;
import com.ncrm.dao.entities.BeanDetailSuiviPhysique;
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanSuiviPhysique;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "DetailSuivi_ChqSGBean")
@SessionScoped
public class DetailSuiviChqBean {
	private static final Logger logger = Logger.getLogger(DetailSuiviChqBean.class);

	private final static String LblBq = "SGMA";
	private final String cdeTr = "031";
	
	

	private String idreport;
	private Date datetr1 = new Date();
	private Date datetr2 = new Date();
	Map<String, Object> parameters = null;
	String dteJour = DateUtils.formatDateToStirng(new Date(), "yyyyMMdd_HHMMss");
	HttpSession session = SessionBean.getSession();
    String username= (String) session.getAttribute("username");
	
	private String[] selectedcircuits;
	private List<BeanPcapt> circuits;
	private List<BeanDetailSuiviPhysique> listDetailPhysiqu = null;
	private List<BeanDetailSuiviPhysique> selectedlistDetailPhysiqu = null;
	StreamedContent pdfDocument; 
	@ManagedProperty("#{metier}")
	Imetier metier;

	String msg = "";
	

	

	@PostConstruct
	public void init() {
		
		
		listDetailPhysiqu = metier.getDetailFluxphysique(LblBq,"031");
		
		

	}

	
	



	
//	################################################################################################################
	/**imprimer Etats  **/	
//################################################################################################################
	
//	public void ImprimeReport(){
//		String listparams= "";
//		String listCircuit="";
//		String Report = null;
//		parameters = new HashMap<String, Object>();
//				try {
//					
//					System.out.println(idreport);
//					if(!idreport.equalsIgnoreCase("null")){
//						if(idreport.equalsIgnoreCase("RecupParPcapt")){
//							Report="/jrxml/sgma/SuiviPhysique/CHQ/ETA_CHQ_RECAP_BY_Pcapt.jasper";
//							parameters.put("username", username);
//						}
//						else if(idreport.equalsIgnoreCase("DetailParPcapt")){
//                        	Report="/jrxml/sgma/SuiviPhysique/CHQ/ETA_CHQ_Detail_BY_Pcapt.jasper";	
//						}
//						else if(idreport.equalsIgnoreCase("RecupPrBq")){
//							Report="/jrxml/sgma/SuiviPhysique/CHQ/ETA_CHQ_RECAP_BY_Bq.jasper";
//							parameters.put("username", username);
//						}
//                        else if(idreport.equalsIgnoreCase("DetailPrBq")){
//                        	Report="/jrxml/sgma/SuiviPhysique/CHQ/ETA_CHQ_Detail_BY_bq.jasper";	
//						}
//                        
//						
//						
//					
//					
//					
//					if (selectedlistRecupPhysiqu.size() > 0) {
//						for (BeanSuiviPhysique b : selectedlistRecupPhysiqu) {
//							listparams = listparams + "'" + b.getDATE_LECTEUR()+ "',";
//							listCircuit=listCircuit+b.getCircuit()+"_";
//
//						}
//						
//						
//						
//						
//						listparams = listparams.substring(0, listparams.length() - 1);
//						listCircuit = listCircuit.substring(0, listCircuit.length() - 1);
//
//
//						String NameFile = idreport+ "_"+generateRandomIdForNotCaching()+"_"+dteJour+".pdf";
//						
//						logger.debug("=== Editer l'etat  ["+NameFile+"] pour les point de capture ["+listparams+"] ");
//						
//						parameters.put("listparams", listparams);
//						
//
//						ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//						String realPath = ctx.getRealPath("/")+"\\workspaceTemp";
//						
//						logger.debug("=== Editer l'etat  ["+realPath+"\\"+NameFile+"] pour la selection : ["+listparams+"] ");
//						
//						
//						pdfDocument=refreshStream(metier.ReportPdf2(Report,parameters, null, realPath, NameFile));
////						msg = "L'impission  !!";
////						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));
//						
//						
//						
//						
//
//						
//
//					} else {
//						msg = "Veuillez sélectionner des point(s) de capture";
//						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
//					}
//					}
//					else {
//						msg = "Veuillez sélectionner un etat";
//						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
//					}
//				} catch (Exception  e) {
//					logger.debug("+++  Exception  ImprimeReport "+e.getMessage(),e);
//				}
//				
//		
//		
//	}
//	
//	
//	
//	public void deletepdftmp(){
//		
//		try {
//			if(pdfDocument.getName()!=null){
//				logger.debug("=== Supprimer le fichier temp  : [ "+pdfDocument.getName()+" ] ");
//			new File(pdfDocument.getName()).delete();
//			}
//			else {
//				pdfDocument=new DefaultStreamedContent();
//			}
//		} catch (Exception e) {
//			System.out.println("Exception");
//		}
//	}
//	//	################################################################################################################
//	/**Initialiser  la Reception des flux physique  **/	
////################################################################################################################
		public void InitialiserReception() {
		String  listParam = "";
		String  listParamDate = "";
		parameters = new HashMap<String, Object>();
		
		try {
		if (selectedlistDetailPhysiqu.size() > 0) {
		for (BeanDetailSuiviPhysique b : selectedlistDetailPhysiqu) {
			listParam = listParam + "'" + b.getCmc7() + "',";
			listParamDate = listParamDate + "'" + b.getDATE() + "',";
		
		}
		listParam = listParam.substring(0, listParam.length() - 1);
		listParamDate = listParamDate.substring(0, listParamDate.length() - 1);
	
		System.out.println(listParam);
		System.out.println(listParamDate);
//		metier.updateValideFluxphysique(LblBq, listParam, null, "CHQ",username);
//		
		msg = "Les flux selectionnées sont initialisee ";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));
//		listDetailPhysiqu = metier.getDetailFluxphysique(LblBq,"031");
		
		} 
//		else {
//		msg = "Veuillez sélectionner des point(s) de capture";
//		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
//		}

		}
		catch (Exception e) {
			logger.debug("+++  Exception  ValiderReception "+e.getMessage(),e);
			}
		}

		
		
		
		

		
	public Imetier getMetier() {
		return metier;
	}

	public String[] getSelectedcircuits() {
		return selectedcircuits;
	}

	public void setSelectedcircuits(String[] selectedcircuits) {
		this.selectedcircuits = selectedcircuits;
	}

	public List<BeanPcapt> getCircuits() {
		return circuits;
	}

	public void setCircuits(List<BeanPcapt> circuits) {
		this.circuits = circuits;
	}

	public Date getDatetr1() {
		return datetr1;
	}

	public void setDatetr1(Date datetr1) {
		this.datetr1 = datetr1;
	}

	public Date getDatetr2() {
		return datetr2;
	}

	public void setDatetr2(Date datetr2) {
		this.datetr2 = datetr2;
	}

	public void setMetier(Imetier metier) {
		this.metier = metier;
	}

	
	

	
	
	
	
	public List<BeanDetailSuiviPhysique> getListDetailPhysiqu() {
		return listDetailPhysiqu;
	}







	public void setListDetailPhysiqu(List<BeanDetailSuiviPhysique> listDetailPhysiqu) {
		this.listDetailPhysiqu = listDetailPhysiqu;
	}







	public void setSelectedlistDetailPhysiqu(
			List<BeanDetailSuiviPhysique> selectedlistDetailPhysiqu) {
		this.selectedlistDetailPhysiqu = selectedlistDetailPhysiqu;
	}







	public List<BeanDetailSuiviPhysique> getSelectedlistDetailPhysiqu() {
		return selectedlistDetailPhysiqu;
	}







	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected",
				((BeanSuiviPhysique) event.getObject()).getDATE());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected",
				((BeanSuiviPhysique) event.getObject()).getDATE());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}



	public String getIdreport() {
		return idreport;
	}



	public void setIdreport(String idreport) {
		this.idreport = idreport;
	}
	
	public StreamedContent getPdfDocument() {
		return pdfDocument;
	}



	public void setPdfDocument(StreamedContent pdfDocument) {
		this.pdfDocument = pdfDocument;
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
			
			logger.debug("+++  IOException  createStream "+e.getMessage(),e);
		}
		 catch (Exception e) {
			
			logger.debug("+++  IOException  createStream "+e.getMessage(),e);
		}
		DefaultStreamedContent streamedContent = new DefaultStreamedContent(inputStream, "application/pdf",fileName);
		return streamedContent;
}	
		
	public StreamedContent refreshStream(String pathpdf) {
		return createStream(pathpdf);
}


		
		


}
