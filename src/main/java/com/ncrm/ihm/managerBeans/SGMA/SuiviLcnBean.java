package com.ncrm.ihm.managerBeans.SGMA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
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
import javax.faces.context.ExternalContext;
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
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanSuiviPhysique;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;

@ManagedBean(name = "Suivi_LcnSGBean")
@SessionScoped
public class SuiviLcnBean {
	private static final Logger logger = Logger.getLogger(SuiviLcnBean.class);

	private final static String LblBq = "SGMA";
	private final String cdeTr = "060";
	private final String cdeBq = Propriete.getInsatance().get(LblBq + ".cde.bq");

	
	private String idreport;
	private Date datetr1 = new Date();
	private Date datetr2 = new Date();
	private Date datePre = new Date();
	private Date datePrRec = new Date();
	Map<String, Object> parameters = null;
	String dteJour = DateUtils.formatDateToStirng(new Date(), "yyyyMMdd_HHMMss");
	HttpSession session = SessionBean.getSession();
    String username= (String) session.getAttribute("username");
	
	private String[] selectedcircuits;
	private List<BeanPcapt> circuits;
	private List<BeanSuiviPhysique> listRecupPhysiqu = null;
	private List<BeanSuiviPhysique> selectedlistRecupPhysiqu = null;
	StreamedContent pdfDocument=null; 
	
	@ManagedProperty("#{metier}")
	Imetier metier;

	String msg = "";
	

	List<BeanPcapt> pcapts;

	@PostConstruct
	public void init() {
//		circuits = metier.getDistinctCircuitSGMA(LblBq);
//		pcapts = metier.getAllPcaptSGMA(LblBq);
		listRecupPhysiqu = metier.getRecupFluxphysique(LblBq,"060");
		
		

	}

	
	
//	################################################################################################################
									/** Synchroniser data **/	
//	################################################################################################################
	public void synchrontable() {
		
		String dtetrString1 = DateUtils.formatDateToStirng(datetr1,"yyyy-MM-dd");
		String dtetrString2 = DateUtils.formatDateToStirng(datetr2,"yyyy-MM-dd");
		
		logger.debug("=== synchronisé les données traiter ["+dtetrString1+" - "+dtetrString2+"] ");
		
		int countValues = metier.extractData4Suvi(LblBq, cdeTr, dtetrString1,dtetrString2, null);
		
		logger.debug("@@@ countValues ["+countValues+"] ");
		if (countValues == 0) {
			msg = " aucune valeur n'a été traitée dans la plage sélectionnée  ="+ dtetrString1 + "jusqu'a " + dtetrString2;
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", msg));
            

		} else {
			msg = " les valeurs [" + countValues + "] traitées entre le  [ ="+ dtetrString1 + " &  " + dtetrString2+ " ] sont synchronises dans la table temporaire  ";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
			int countimpy=metier.synchronImpayeLCNFluxphysique(LblBq);
            msg = " Le nombre des impayees synchronise = "+countimpy;
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
			listRecupPhysiqu = metier.getRecupFluxphysique(LblBq,"060");
		}

		// }
	}


	
//	public void EditDetailParPcapt(String dteinstance,String lecteur) {
//		
//		parameters = new HashMap<String, Object>();
//	
//		
//		try {
//			
//				
//
//		
//				String NameFile = "Detail_par_dteTrt_pcapt_" +dteinstance+"_"+lecteur + ".pdf";
//				logger.debug("=== Editer l'etat  detail ["+NameFile+"] pour les point de capture ["+lecteur+"] ");
//				parameters.put("dteinstance", dteinstance);
//				parameters.put("lecteur", lecteur);
//				metier.ReportPdf2("/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Detail_BY_Pcapt.jasper",parameters, null, folderOut, NameFile);
//				msg = "L''États Recap par Banque est généré dans l'emplacement :  ["+ folderOut + NameFile + "]";
//				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));
//		
//		} 
//
//		catch (Exception  e) {
//			logger.debug("+++  Exception  EditRecupParPcapt "+e.getMessage(),e);
//		}
//	}

	
	
	
	
//	################################################################################################################
	/** Editer Recup par Pcapt pour le pointage **/	
//################################################################################################################
//public void EditRecupParPcapt() {
//String listparams= "";
//String listCircuit="";
//parameters = new HashMap<String, Object>();
//
//try {
//if (selectedlistRecupPhysiqu.size() > 0) {
//for (BeanSuiviPhysique b : selectedlistRecupPhysiqu) {
//listparams = listparams + "'" + b.getDATE_LECTEUR()+ "',";
//listCircuit=listCircuit+b.getCircuit()+"_";
////listDte = listDte + "'" + b.getDATE() + "',";
//
//}
//listparams = listparams.substring(0, listparams.length() - 1);
//listCircuit = listCircuit.substring(0, listCircuit.length() - 1);
////listDte = listDte.substring(0, listDte.length() - 1);
//
//String NameFile = "Recap_par_dteTrt_pcapt_" +listCircuit+"_"+ dteJour + ".pdf";
//logger.debug("=== Editer l'etat  ["+NameFile+"] pour les point de capture ["+listparams+"] & les date instance ["+listparams+"] ");
//parameters.put("listparams", listparams);
////parameters.put("dateInstance", listparams);
//metier.ReportPdf2("/jrxml/sgma/SuiviPhysique/ETA_CHQ_RECAP_BY_Pcapt.jasper",parameters, null, folderOut, NameFile);
//msg = "L''États Recap par Banque est généré dans l'emplacement :  ["+ folderOut + NameFile + "]";
//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));
//} else {
//msg = "Veuillez sélectionner des point(s) de capture";
//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
//}
//}
//catch (Exception  e) {
//logger.debug("+++  Exception  EditRecupParPcapt "+e.getMessage(),e);
//}
////catch (FileNotFoundException  e) {
////logger.debug("+++  FileNotFoundException  EditRecupParPcapt "+e.getMessage(),e);
////}
////catch (JRException  e) {
////logger.debug("+++  JRException  EditRecupParPcapt "+e.getMessage(),e);
////}
////catch (SQLException e) {
////logger.debug("+++  SQLException  EditRecupParPcapt "+e.getMessage(),e);
////}
//}

	
	
	
//	################################################################################################################
							/** Editer Recup par Banque + fichier de Rec machine  **/	
//################################################################################################################
	public void EditerRec() {
		 String OUTDIR= Propriete.getInsatance().get(LblBq+".OUT.REC.SUIVI.LCN");
		String listparams= "";
		String datePr = DateUtils.formatDateToStirng(datePrRec,"yyyy-MM-dd");
		System.out.println("datePrRec" +datePr);

		try {
			
			
			
			if (selectedlistRecupPhysiqu.size() > 0) {
				for (BeanSuiviPhysique b : selectedlistRecupPhysiqu) {
					listparams = listparams + "'" + b.getDATE_LECTEUR()+ "',";
					

				}
				listparams = listparams.substring(0, listparams.length() - 1);



		
				OUTDIR= OUTDIR+"\\"+username;
				String NameFile=OUTDIR+"\\TraitedChq.txt";
				logger.debug("=== Editer l'etat  ["+NameFile+"] pour les point de capture ["+listparams+"] ");
				

				

				logger.debug("=== Editer le fichier de Rec   [TraitedChq_"+dteJour+".txt"+"] pour les point de capture ["+listparams+"] ");
				metier.createFileSuiviPhysique(LblBq, "LCN", listparams, listparams, username,datePr);
				msg = "Le fichier de reconceliation est bien generer dans  :  ["+NameFile + "]";
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));

			} else {
				msg = "Veuillez sélectionner des point(s) de capture";
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
			}
		} catch (Exception  e) {
			logger.debug("+++  JRException  EditerRec "+e.getMessage(),e);
		}
		
	}
//
//	
//	
//	public void EditDetailPrBq() {
//		String listparams= "";
//		String listCircuit="";
//		parameters = new HashMap<String, Object>();
////System.out.println("metier.getopePrf().size() "+metier.getopePrf().size());
//		try {
//			if (selectedlistRecupPhysiqu.size() > 0) {
//				for (BeanSuiviPhysique b : selectedlistRecupPhysiqu) {
//					listparams = listparams + "'" + b.getDATE_LECTEUR()+ "',";
//					listCircuit=listCircuit+b.getCircuit()+"_";
////					listPcapt = listPcapt + "'" + b.getLECTEUR() + "',";
////					listDte = listDte + "'" + b.getDATE() + "',";
//
//				}
//				listparams = listparams.substring(0, listparams.length() - 1);
//				listCircuit = listCircuit.substring(0, listCircuit.length() - 1);
////				listDte = listDte.substring(0, listDte.length() - 1);
//				System.out.println("listparams" + listparams);
////				System.out.println("listDte" + listDte + "listDte.length()"+ listDte.length());
//
//				String NameFile = "Detail_par_dteTrt_Bq_" + listCircuit + "_"+username+"_"+dteJour+".pdf";
//				
//				logger.debug("=== Editer l'etat  ["+NameFile+"] pour les point de capture ["+listparams+"] ");
//				
//				parameters.put("listparams", listparams);
////				parameters.put("dateInstance", listDte);
//				metier.ReportPdf2("/jrxml/sgma/SuiviPhysique/ETA_CHQ_Detail_BY_bq.jasper",parameters, null, folderREC, NameFile);
//				msg = "L''États de Suivi est généré dans l'emplacement :  ["+ folderREC + NameFile + "]";
//				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));
//
//			} else {
//				msg = "Veuillez sélectionner des point(s) de capture";
//				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
//			}
//		} catch (Exception  e) {
//			logger.debug("+++  JRException  EditDetailPrBq "+e.getMessage(),e);
//		}
//		
//	}
//	
//	
//	
//	################################################################################################################
	/**imprimer Etats  **/	
//################################################################################################################
	
	public void ImprimeReport(){
		String listparams= "";
		String Report = null;
		parameters = new HashMap<String, Object>();
		//System.out.println("metier.getopePrf().size() "+metier.getopePrf().size());
				try {
					
					System.out.println(idreport);
					if(!idreport.equalsIgnoreCase("null")){
						if(idreport.equalsIgnoreCase("RecupParPcapt")){
							Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_RECAP_BY_Pcapt.jasper";	
							parameters.put("username", username);
						}
						else if(idreport.equalsIgnoreCase("DetailParPcapt")){
                        	Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Detail_BY_Pcapt.jasper";	
						}
						else if(idreport.equalsIgnoreCase("RecupPrBq")){
							Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_RECAP_BY_Bq.jasper";
							parameters.put("username", username);
						}
                        else if(idreport.equalsIgnoreCase("DetailPrBq")){
                        	Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Detail_BY_bq.jasper";	
						}
//						#################################################
                        else if(idreport.equalsIgnoreCase("RecupPrBqEchues")){
                        	Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Recup_BY_bq_Echues.jasper";	
						}
						
                        else if(idreport.equalsIgnoreCase("DetailPrBqEchues")){
                        	Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Detail_Echues_BY_bq.jasper";	
						}
                        else if(idreport.equalsIgnoreCase("RecupPrBqLointain")){
                        	Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Recup_BY_bq_Lointain.jasper";	
						}
						
                        else if(idreport.equalsIgnoreCase("RecupPrBqEcheanceLointain")){
                        	Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Recup_BY_bq_echee_Lointain.jasper";	
						}
                        else if(idreport.equalsIgnoreCase("DetailPrBqEcheanceLointain")){
                        	Report="/jrxml/sgma/SuiviPhysique/LCN/ETA_LCN_Detail_Lointain_BY_bq_Echeance.jasper";	
						}
						
						 
					
					
					if (selectedlistRecupPhysiqu.size() > 0) {
						for (BeanSuiviPhysique b : selectedlistRecupPhysiqu) {
							listparams = listparams + "'" + b.getDATE_LECTEUR()+ "',";
						}
						
						
						
						
						listparams = listparams.substring(0, listparams.length() - 1);


						String NameFile = idreport+ "_"+generateRandomIdForNotCaching()+"_"+dteJour+".pdf";
						
					
						
						parameters.put("listparams", listparams);
						parameters.put("dtePre", datePre);

						ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
						String realPath = ctx.getRealPath("/")+"\\workspaceTemp";
						
						logger.debug("=== Editer l'etat  ["+realPath+"\\"+NameFile+"] pour la selection : ["+listparams+"] ");
						pdfDocument=refreshStream(metier.ReportPdf2(Report,parameters, null, realPath, NameFile));

					} else {
						msg = "Veuillez sélectionner des point(s) de capture";
						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
					}
					}
					else {
						msg = "Veuillez sélectionner un etat";
						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
					}
				} catch (Exception  e) {
					logger.debug("+++  Exception  ImprimeReport "+e.getMessage(),e);
				}
				
		
		
	}
	
	public void deletepdftmp(){
	
		try {
			if(pdfDocument.getName()!=null){
				logger.debug("=== Supprimer le fichier temp  : [ "+pdfDocument.getName()+" ] ");
			new File(pdfDocument.getName()).delete();
			}
			else {
				pdfDocument=new DefaultStreamedContent();
			}
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	
//	################################################################################################################
	/**Valider la Reception des flux physique  **/	
//################################################################################################################
		public void ValiderReception() {
		String  listParam = "";
		parameters = new HashMap<String, Object>();
		
		try {
		if (selectedlistRecupPhysiqu.size() > 0) {
		for (BeanSuiviPhysique b : selectedlistRecupPhysiqu) {
			listParam = listParam + "'" + b.getDATE_LECTEUR() + "',";

		
		}
		listParam = listParam.substring(0, listParam.length() - 1);
		
		
		metier.updateValideFluxphysique(LblBq, listParam, null, "LCN",username);
		
		msg = "Les flux selectionnées sont flag par la date de reception = "+dteJour+" par "+username;
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",msg));
		listRecupPhysiqu = metier.getRecupFluxphysique(LblBq,"060");
		
		} else {
		msg = "Veuillez sélectionner des point(s) de capture";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",msg));
		}

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

	public List<BeanPcapt> getPcapts() {
		return pcapts;
	}

	public void setPcapts(List<BeanPcapt> pcapts) {
		this.pcapts = pcapts;
	}

	public List<BeanSuiviPhysique> getListRecupPhysiqu() {
		return listRecupPhysiqu;
	}

	public void setListRecupPhysiqu(List<BeanSuiviPhysique> listRecupPhysiqu) {
		this.listRecupPhysiqu = listRecupPhysiqu;
	}

	public List<BeanSuiviPhysique> getSelectedlistRecupPhysiqu() {
		return selectedlistRecupPhysiqu;
	}

	public void setSelectedlistRecupPhysiqu(
			List<BeanSuiviPhysique> selectedlistRecupPhysiqu) {
		this.selectedlistRecupPhysiqu = selectedlistRecupPhysiqu;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Circuit Selectionner ",
				((BeanSuiviPhysique) event.getObject()).getDATE());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Circuit Selectionner",
				((BeanSuiviPhysique) event.getObject()).getDATE());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}



	public String getIdreport() {
		return idreport;
	}



	public void setIdreport(String idreport) {
		this.idreport = idreport;
	}



	public Date getDatePre() {
		return datePre;
	}



	public void setDatePre(Date datePre) {
		this.datePre = datePre;
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
	

	public Date getDatePrRec() {
		return datePrRec;
	}



	public void setDatePrRec(Date datePrRec) {
		this.datePrRec = datePrRec;
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
