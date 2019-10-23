package com.ncrm.metier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ncrm.SprBatch.sgma.impayeChqSg;
import com.ncrm.dao.Idao;
import com.ncrm.dao.entities.BaaRecordLCN;
import com.ncrm.dao.entities.BaaRecordRemLCN;
import com.ncrm.dao.entities.BaaSilcnRecord;
import com.ncrm.dao.entities.BeanAgence;
import com.ncrm.dao.entities.BeanCompte;
import com.ncrm.dao.entities.BeanCountImpy;
import com.ncrm.dao.entities.BeanCountpye;
import com.ncrm.dao.entities.BeanDetailSuiviPhysique;
import com.ncrm.dao.entities.BeanFile;
import com.ncrm.dao.entities.BeanImpChq;
import com.ncrm.dao.entities.BeanImpChqSG;
import com.ncrm.dao.entities.BeanImpLcn;
import com.ncrm.dao.entities.BeanImpLcnSG;
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanReport;
import com.ncrm.dao.entities.BeanSuiviPhysique;
import com.ncrm.dao.entities.BeanTrt;
import com.ncrm.dao.entities.HeaderSiLCN;
import com.ncrm.dao.entities.RecordChq;
import com.ncrm.dao.entities.RecordLCN;
import com.ncrm.dao.entities.RecordLotChq;
import com.ncrm.dao.entities.RecordLotLcn;
import com.ncrm.dao.entities.RecordPaidValue;
import com.ncrm.dao.entities.RecordRemChq;
import com.ncrm.dao.entities.RecordRemLCN;
import com.ncrm.dao.entities.SilcnRecord;
import com.ncrm.dao.entities.beanScann;
import com.ncrm.dao.entities.rec.RecordRemise;
import com.ncrm.dao.entities.rec.RecordValue;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.library.utils.DirUtils;
import com.ncrm.library.utils.ImageUtils;
import com.ncrm.library.utils.NcrmUtils;
import com.ncrm.library.utils.RegexUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.library.utils.ZipUtils;
import com.ncrm.library.utils.beans.Journal;
import com.ncrm.tools.Propriete;



public class MetierImpl implements Imetier,Serializable{
	private static final Logger logger = Logger.getLogger(MetierImpl.class);
	protected static String regxMNT="^([0-9]+)\\.([0-9]{1,2})";
	protected static String regxDteIns="^([0-9]{4})-([0-9]{2})-([0-9]{2})";
	
	
	Idao dao;
	
	
//	################################################################################
//							EXTRACTION SI LCN 
//	###################################################################################
	
	public SilcnRecord formatChampsSILCN(String bq, String dteTr) {
		 SilcnRecord silcnRecord = null;
		 String cdeBq=Propriete.getInsatance().get(bq+".cde.bq");
		try
		{
	
		logger.debug("=== Formater les champs pour generer le fichier SI LCN Banque "+bq+" la date du traitement "+dteTr);
		
		logger.debug("@@@  Construire & Formater l'Entete SILCN");
	   BigInteger RemLcnTraited=dao.getCountRemTraited(dteTr,Propriete.getInsatance().get(bq+".REQ.GETCOUNT.REM.LCN"));
	   if(!RemLcnTraited.equals(new BigInteger("0")))
	   {
		   silcnRecord=new SilcnRecord();
		   HeaderSiLCN headerSiLcn=new HeaderSiLCN();
		   List<RecordRemLCN> listrecordRemLcn = new ArrayList<RecordRemLCN>();
		   
		   
		    headerSiLcn.setIdheader("0100");
			headerSiLcn.setNbrRemise(StringUtils.padRight(RemLcnTraited.intValue()+"", 6, "0"));
			headerSiLcn.setDteGener(DateUtils.formatDateToStirng(new Date(), "yyyyMMdd"));
		   
		   List<Object[]> header = dao.getCount2ndSumMntTraitedSI(dteTr,Propriete.getInsatance().get(bq+".REQ.GETCOUNTANDSUMMNT.LCN"));
	 	
	 	   headerSiLcn.setNbrLcn(StringUtils.padRight(header.get(0)[0]+"", 6, "0"));
			headerSiLcn.setMnttotal((String) header.get(0)[1]);
			
			
				String Mnttotal= headerSiLcn.getMnttotal();
			if(Mnttotal!=null)
			{
				Mnttotal=Mnttotal.replace(",", "");
			  if ( RegexUtils.matches(Mnttotal, regxMNT))
				 {
				  Mnttotal=StringUtils.replace(Mnttotal, regxMNT, "$1$2");
				  Mnttotal=StringUtils.padRight(Mnttotal+"", 16, "0");
				  headerSiLcn.setMnttotal(Mnttotal);
					
				}
			}
			  logger.debug("@@@ Entete SILCN ["+headerSiLcn.getIdheader()+headerSiLcn.getDteGener()+headerSiLcn.getNbrRemise()+headerSiLcn.getNbrLcn()+headerSiLcn.getMnttotal()+"]");
			  silcnRecord.setHeaderSiLcn(headerSiLcn);
			  listrecordRemLcn.clear();
			  listrecordRemLcn=dao.getRemLcnTraiter(dteTr,Propriete.getInsatance().get(bq+".REQ.GETREMTRAITED.LCN"));
			  logger.debug("@@@ Construire & Formater la line Remise du fichier SILCN "+ Propriete.getInsatance().get(bq+".REQ.GETREMTRAITED.LCN"));
				
			  for(RecordRemLCN recordRemLcn:listrecordRemLcn)
				{
					List<RecordLCN> listrecordsLcn = new ArrayList<RecordLCN>();
					
					
					
					recordRemLcn.setIdremise("02");
					String NumberDeclarer=recordRemLcn.getBmtr_NBCH();
					recordRemLcn.setBmtr_NBCH(StringUtils.padRight(NumberDeclarer, 6, "0"));
					recordRemLcn.setBmtr_NBCH(StringUtils.padRight(NumberDeclarer, 6, "0"));
					String MNtDeclarer=recordRemLcn.getBmtr_MNTDECL();
					String MNtReel=recordRemLcn.getBmtr_MNTREEL();
					String bmtr_RefCli=recordRemLcn.getBmtr_REFCLI();
					if(MNtDeclarer!=null)
					{
						MNtDeclarer=MNtDeclarer.replace(",", "");
					  if ( RegexUtils.matches(MNtDeclarer, regxMNT))
						 {
						  MNtDeclarer=StringUtils.replace(MNtDeclarer, regxMNT, "$1$2");
						  MNtDeclarer=StringUtils.padRight(MNtDeclarer, 16, "0");
						  recordRemLcn.setBmtr_MNTDECL(MNtDeclarer);
							
						}
					}
					if(MNtReel!=null)
					{
						MNtReel=MNtReel.replace(",", "");
					  if ( RegexUtils.matches(MNtReel, regxMNT))
						 {
						  MNtReel=StringUtils.replace(MNtReel, regxMNT, "$1$2");
						  MNtReel=StringUtils.padRight(MNtReel, 16, "0");
						  recordRemLcn.setBmtr_MNTREEL(MNtReel);
							
						}
					}
					if(bmtr_RefCli!=null){
					recordRemLcn.setBmtr_REFCLI(StringUtils.padLeft(bmtr_RefCli, 15, " "));
					}
					else {
						recordRemLcn.setBmtr_REFCLI(StringUtils.padLeft("", 15, " "));
					}
					logger.debug("@@@ REMISE ["+recordRemLcn.getIdremise()+recordRemLcn.getBmtr_CDECLT()+recordRemLcn.getBmtr_NSER()+recordRemLcn.getBmtr_NBCH()+recordRemLcn.getBmtr_NBCH()+recordRemLcn.getBmtr_MNTDECL()+recordRemLcn.getBmtr_MNTREEL()+recordRemLcn.getBmtr_MODE_ESC()+recordRemLcn.getBmtr_REFCLI()+"]");
					 
					
				 	List<RecordLCN> lcns=dao.getLCNTraited(dteTr,recordRemLcn.getBmtr_pk_obj_idt(),Propriete.getInsatance().get(bq+".REQ.GETVALUETRAITED.LCN"));
				 	 for(RecordLCN recordLcn:lcns){
				 		
				 		
				 		if(recordLcn.getBmtr_NSER().equalsIgnoreCase(recordRemLcn.getBmtr_NSER()))
				 		{
							  
							recordLcn.setIdLcn("03");
						
			
						
							String ribTire=recordLcn.getBmlcn_ZBK()+recordLcn.getBmlcn_LOC()+recordLcn.getBmlcn_CPT()+recordLcn.getBmlcn_RIB();
						
							recordLcn.setRibTire(ribTire);
							
							if(recordLcn.getBmlcn_RSOC_TIR()!=null)
							{
							recordLcn.setBmlcn_RSOC_TIR(StringUtils.padLeft(recordLcn.getBmlcn_RSOC_TIR(), 35, " "));
							}
							else
							{
								recordLcn.setBmlcn_RSOC_TIR(StringUtils.padLeft(" ", 35, " "));
							}
							
							if(recordLcn.getBmlcn_ADR_TIR()!=null)
							{
								recordLcn.setBmlcn_ADR_TIR(StringUtils.padLeft(recordLcn.getBmlcn_ADR_TIR(), 35, " "));
								
							}
							else 
							{
								recordLcn.setBmlcn_ADR_TIR(StringUtils.padLeft(" ", 35, " "));
							}
						String Bmlcn_MNT=recordLcn.getBmlcn_MNT();
							
						if(Bmlcn_MNT!=null)
						{
							Bmlcn_MNT=Bmlcn_MNT.replace(",", "");
						  if ( RegexUtils.matches(Bmlcn_MNT, regxMNT))
							 {
							  Bmlcn_MNT=StringUtils.replace(Bmlcn_MNT, regxMNT, "$1$2");
							  Bmlcn_MNT=StringUtils.padRight(Bmlcn_MNT, 16, "0");
							  recordLcn.setBmlcn_MNT(Bmlcn_MNT);
								
							}
						}
							
							
							
							recordLcn.setLcnTimber("0");
							
							if(recordLcn.getBmlcn_cdeAval()==null){
								recordLcn.setBmlcn_cdeAval("1");	
							}
							else{
								
							}
							if(recordLcn.getBmlcn_NOM_AVAL()!=null){
								recordLcn.setBmlcn_NOM_AVAL(StringUtils.padLeft(recordLcn.getBmlcn_NOM_AVAL(), 35, " "));
							}
							else{
								recordLcn.setBmlcn_NOM_AVAL(StringUtils.padLeft(" ", 35, " "));
							
							if(recordLcn.getBmlcn_cde_nom_endo()!=null){
								recordLcn.setBmlcn_cde_nom_endo(StringUtils.padLeft(recordLcn.getBmlcn_cde_nom_endo(), 35, " "));
							}
							else{
								recordLcn.setBmlcn_cde_nom_endo(StringUtils.padLeft(" ", 35, " "));
							}
							if(recordLcn.getBmlcn_cde_NOM_TIREUR()!=null){
								recordLcn.setBmlcn_cde_NOM_TIREUR(StringUtils.padLeft(recordLcn.getBmlcn_cde_NOM_TIREUR(), 35, " "));
							}
							else{
								recordLcn.setBmlcn_cde_NOM_TIREUR(StringUtils.padLeft(" ", 35, " "));
							}
							
							
							
					
						Date dateEchee;
						if(recordLcn.getBmlcn_DTEEC().equals("0"))
						{
							recordLcn.setBmlcn_DTEEC("00000000");
						}
						else 
						{
							dateEchee = DateUtils.formatStringToDate(recordLcn.getBmlcn_DTEEC(), "ddMMyyyy");
							recordLcn.setBmlcn_DTEEC(DateUtils.formatDateToStirng(dateEchee, "yyyyMMdd"));
						}
						
							Date dateCre=DateUtils.formatStringToDate(recordLcn.getBmlcn_DTECRE(), "yyyy-MM-dd");
							recordLcn.setBmlcn_DTECRE(DateUtils.formatDateToStirng(dateCre, "yyyyMMdd"));
							
							recordLcn.setBmlcn_CONF(recordLcn.getBmlcn_CONF());
							recordLcn.setBmlcn_VICE(recordLcn.getBmlcn_VICE());
							
							if((!bq.equalsIgnoreCase("PCDM"))&&(!bq.equalsIgnoreCase("BTI")))
							{
							if(recordLcn.getBmlcn_CONF().equals("1")){
								 String mnemoniqueConfor="000";
								 recordLcn.setBmlcn_VICE(mnemoniqueConfor);
							}
							else{
								
								String mnemoniqueConfor = NcrmUtils.getMnemonicAnoFast(recordLcn.getBmlcn_VICE());
								 if(mnemoniqueConfor.length()>0){
								mnemoniqueConfor=mnemoniqueConfor.substring(1, mnemoniqueConfor.length());
								recordLcn.setBmlcn_VICE(mnemoniqueConfor);
								}
								 else {
									 mnemoniqueConfor="000";
									 recordLcn.setBmlcn_VICE(mnemoniqueConfor);
								 }
							}
							}
							
//							Controle signature  
							
							if((bq.equalsIgnoreCase("PCDM"))||(bq.equalsIgnoreCase("BTI")))
							{
//								Statuts 
								
						          
						          
								//autres banques conformes
								if((recordLcn.getBmlcn_CONF().equals("1")) && (((recordLcn.getBmlcn_SIGN()==null)||(recordLcn.getBmlcn_SIGN().equals("1")))))
								{
									//inter-agences conforme
									
									if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
									{
										recordLcn.setBmlcn_CODE_STATUS("3");
										recordLcn.setBmlcn_VICE("   ");
									}
									
									else 
									{
										recordLcn.setBmlcn_CODE_STATUS("1");
										recordLcn.setBmlcn_VICE("   ");
									}
								}
								else 
									if ((recordLcn.getBmlcn_CONF().equals("1")) &&(recordLcn.getBmlcn_SIGN().equals("2")))
									{
										if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
										{
											recordLcn.setBmlcn_CODE_STATUS("5");
											recordLcn.setBmlcn_VICE("098");
										}
										else {
											recordLcn.setBmlcn_VICE("   ");
										}
									}
									else 
										if ((recordLcn.getBmlcn_CONF().equals("1")) &&(recordLcn.getBmlcn_SIGN().equals("3")))
										{
											if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
											{
												recordLcn.setBmlcn_CODE_STATUS("4");
												recordLcn.setBmlcn_VICE("099");
											}
											else {
												recordLcn.setBmlcn_VICE("   ");
											}

										}
								
										else 
											if (recordLcn.getBmlcn_CONF().equals("0"))
											{
												if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
												{
													recordLcn.setBmlcn_CODE_STATUS("2");
													String mnemoniqueConfor = NcrmUtils.getMnemonicAnoFast(recordLcn.getBmlcn_VICE());
													 if(mnemoniqueConfor.length()>0)
													 {
													mnemoniqueConfor=mnemoniqueConfor.substring(1, mnemoniqueConfor.length());
													recordLcn.setBmlcn_VICE(mnemoniqueConfor);
													}
													 else 
													 {
														 mnemoniqueConfor="   ";
														 recordLcn.setBmlcn_VICE(mnemoniqueConfor);
													 }
												}
												else 
												{
													recordLcn.setBmlcn_CODE_STATUS("1");
													recordLcn.setBmlcn_VICE("   ");
												}
											}
							
							}
//							RIB remettant
							recordLcn.setBmtr_RIBRMT(String.format("%-24s", recordLcn.getBmtr_RIBRMT()).replace(' ', '0'));
							
							
							
	
							logger.debug("@@@ METIER : LCN ["
							    +recordLcn.getIdLcn()
									+recordLcn.getBmlcn_NSER()
							         +recordLcn.getRibTire()
									+recordLcn.getBmlcn_RSOC_TIR()
							         +recordLcn.getBmlcn_ADR_TIR()
									+recordLcn.getBmlcn_MNT()+
									"|"+recordLcn.getLcnTimber()
									+recordLcn.getBmlcn_cdeAval()
									+recordLcn.getBmlcn_NOM_AVAL()
									+recordLcn.getBmlcn_cde_nom_endo()	
									+recordLcn.getBmlcn_cde_NOM_TIREUR()
									+recordLcn.getBmlcn_DTEEC()
									+recordLcn.getBmlcn_DTECRE()
									+recordLcn.getBmlcn_CONF()
									+recordLcn.getBmlcn_VICE()
									+recordLcn.getBmlcn_RECTO_US_GR()
									+recordLcn.getBmlcn_VERSO_DS_GR()+"]");
							
//							[03|0000076|101041000056110000238897|rue de reims n 12 ifriquia|rue de reims n 12 ifriquia|0000000002000000|0|0|                                   |                                   |                                   |20150404|20150404|1|000|#>F:\images\L_BPM\91900460_00001_20160614001C0002.134;70510;31207;jpg;|#>F:\images\L_BPM\91900460_00001_20160614001C0002.134;101717;8584;jpg;]
							 
							listrecordsLcn.add(recordLcn);	
						}
							
						}
				 		recordRemLcn.getRecordsLcn().clear();
				 		recordRemLcn.getRecordsLcn().addAll(listrecordsLcn);
					}
					
					silcnRecord.getRecordRemiseLcn().clear();
					silcnRecord.getRecordRemiseLcn().addAll(listrecordRemLcn);
				
					   
				   }
	   }

		} 
		catch (ParseException e) {
			logger.debug("+++ ParseException method formatChampsSILCN"+e.getMessage(),e);
		}
	 catch (Exception e) {
		logger.debug("+++ Exception method formatChampsSILCN"+e.getMessage(),e);
	}
		return silcnRecord;
	}

	public boolean createSiLCN(String bq,String dteTr,SilcnRecord silcnRecord){
		
		String OUTDIR_SI_LCN=Propriete.getInsatance().get(bq+".OUTDIR.SI.LCN");
		String nameFileSiLcn="";
		String nameZipFileSiLcn="";
		String nameFile="";
		boolean flag=true;
		
		try {
		
			if((!bq.equalsIgnoreCase("PCDM"))&&(!bq.equalsIgnoreCase("BTI")))
			{
			nameFileSiLcn=OUTDIR_SI_LCN+"\\SI_REM_LCN_"+DateUtils.formatDateToStirng(DateUtils.formatStringToDate(dteTr, "yyyy-MM-dd"), "yyyyMMdd");
			nameZipFileSiLcn =nameFileSiLcn+".zip";
			nameFile="SI_REM_LCN_"+DateUtils.formatDateToStirng(DateUtils.formatStringToDate(dteTr, "yyyy-MM-dd"), "yyyyMMdd")+".txt";
			}
			else
			{
				nameFileSiLcn=OUTDIR_SI_LCN+"\\SI_REM_LCN_"+DateUtils.formatDateToStirng(DateUtils.formatStringToDate(dteTr, "yyyy-MM-dd"), "yyyy-MM-dd")+"_0000000_000000000000";
				nameZipFileSiLcn =nameFileSiLcn+".zip";
				nameFile="SI_REM_LCN_"+DateUtils.formatDateToStirng(DateUtils.formatStringToDate(dteTr, "yyyy-MM-dd"), "yyyy-MM-dd")+"_0000000_000000000000"+".txt";
			}
			
		logger.debug("Nom du fichier  LCN :"+nameFileSiLcn,null);
		logger.debug("@@@ : ecrire un dossier temporaire   "+nameFileSiLcn,null);
		
		new File(nameFileSiLcn).mkdirs();
		File fileSiLcn=new File(nameFileSiLcn+"\\"+nameFile);
		System.out.println("nameFileSiLcn\\nameFile"+nameFileSiLcn+"\\"+nameFile);
		FileWriter fw=fw = new FileWriter(fileSiLcn);
		
		BufferedWriter bw=new BufferedWriter(fw);
		String header=silcnRecord.getHeaderSiLcn().getIdheader()+silcnRecord.getHeaderSiLcn().getNbrRemise()+silcnRecord.getHeaderSiLcn().getDteGener()+silcnRecord.getHeaderSiLcn().getNbrLcn()+silcnRecord.getHeaderSiLcn().getMnttotal();
//		
		
		logger.debug("===: 1- Valider les lignes ");
		if(RegexUtils.matches(header, Propriete.getInsatance().get(bq+".PATTERN.ENTETE.SILCN")))
		{
			logger.debug("header valide : "+header +">--> "+Propriete.getInsatance().get(bq+".PATTERN.ENTETE.SILCN"));
//			Ecrire L'entete du fichier pour UMnia Bank & ALyousr 
			
			if((!bq.equalsIgnoreCase("PCDM"))&&(!bq.equalsIgnoreCase("BTI")))
			{
				bw.write(header);
				bw.newLine();
				logger.debug("@@@ : [Entete   "+header+ " ]",null);
			}
			
			
			for(int i=0;i<silcnRecord.getRecordRemiseLcn().size();i++)
			{
				RecordRemLCN rem=silcnRecord.getRecordRemiseLcn().get(i);
				String[] urlImageRecto;
				String[] urlImageVerso;
				String RecordRem="";
				

				if((bq.equalsIgnoreCase("PCDM"))||(bq.equalsIgnoreCase("BTI")))
					{
//					Pour la PCDM  : IDREMISE + CDEAGE + CPTR + NSERREM + Nbr_LCN + MNTDeclarer + MNTCAlculer + MODE + REFERENCECli
					RecordRem=rem.getIdremise()+rem.getBmtr_AGE_RMT()+rem.getBmtr_CDECLT()+rem.getBmtr_NSER()+rem.getBmtr_NBCH()+rem.getBmtr_MNTDECL()+rem.getBmtr_MNTREEL()+rem.getBmtr_MODE_ESC()+rem.getBmtr_REFCLI();
					
					logger.debug(rem.getIdremise()+"|"+
							rem.getBmtr_AGE_RMT()+"|"+
							rem.getBmtr_CDECLT()+"|"+
							rem.getBmtr_NSER()+"|"+
							rem.getBmtr_NBCH()+"|"+
							rem.getBmtr_MNTDECL()+"|"+
							rem.getBmtr_MNTREEL()+"|"+
							rem.getBmtr_MODE_ESC()+"|"+
							rem.getBmtr_REFCLI());
					}
				else 
				    {
//					Pour la PCDM  : IDREMISE  CPTR + NSERREM + Nbr_LCN + Nbr_LCN + MNTDeclarer + MNTCAlculer + MODE + REFERENCECli
					RecordRem=rem.getIdremise()+rem.getBmtr_CDECLT()+rem.getBmtr_NSER()+rem.getBmtr_NBCH()+rem.getBmtr_NBCH()+rem.getBmtr_MNTDECL()+rem.getBmtr_MNTREEL()+rem.getBmtr_MODE_ESC()+rem.getBmtr_REFCLI();
					
				    }
				
				logger.debug("RecordRem valide : "+RecordRem +">--> "+Propriete.getInsatance().get(bq+".PATTERN.RECORDREM.SILCN"));
				if(RegexUtils.matches(RecordRem, Propriete.getInsatance().get(bq+".PATTERN.RECORDREM.SILCN")))
				{
					bw.write(RecordRem);
					bw.newLine();
					logger.debug(" @@@ : [Enregistrement REM  "+RecordRem+ " ]",null);
					
					
					for(int j=0;j<rem.getRecordsLcn().size();j++)
					{
						RecordLCN lcn=rem.getRecordsLcn().get(j);
						String recordlcn="";
						
						if((bq.equalsIgnoreCase("PCDM"))||(bq.equalsIgnoreCase("BTI")))
						{
						recordlcn=lcn.getIdLcn()+
								lcn.getBmtr_nser()+
								lcn.getBmtr_RIBRMT()+
								lcn.getBmlcn_NSER()+
								lcn.getRibTire()+
								lcn.getBmlcn_RSOC_TIR()
								+lcn.getBmlcn_ADR_TIR()
								+lcn.getBmlcn_cdeAval()
								+lcn.getBmlcn_cde_NOM_TIREUR()
								+lcn.getBmlcn_MNT()
								+lcn.getBmlcn_DTEEC()
								+lcn.getBmlcn_DTECRE()
								+lcn.getBmlcn_CODE_STATUS()
								+lcn.getBmlcn_VICE();
								
//								+lcn.getLcnTimber()
//								
//								+lcn.getBmlcn_NOM_AVAL()
//								+lcn.getBmlcn_cde_nom_endo()
								
						logger.debug(lcn.getIdLcn()+
								lcn.getBmtr_nser()+
								lcn.getBmtr_RIBRMT()+
								lcn.getBmlcn_NSER()+
								lcn.getRibTire()+
								lcn.getBmlcn_RSOC_TIR()
								+lcn.getBmlcn_ADR_TIR()
								+lcn.getBmlcn_cdeAval()
								+lcn.getBmlcn_cde_NOM_TIREUR()
								+lcn.getBmlcn_MNT()
								+lcn.getBmlcn_DTEEC()
								+lcn.getBmlcn_DTECRE()
								+lcn.getBmlcn_CODE_STATUS()
								+lcn.getBmlcn_VICE());	
							
								
						}
						else {
							recordlcn=lcn.getIdLcn()+lcn.getBmlcn_NSER()+lcn.getRibTire()+lcn.getBmlcn_RSOC_TIR()
								+lcn.getBmlcn_ADR_TIR()+lcn.getBmlcn_MNT()+lcn.getLcnTimber()+lcn.getBmlcn_cdeAval()+lcn.getBmlcn_NOM_AVAL()
								+lcn.getBmlcn_cde_nom_endo()+lcn.getBmlcn_cde_NOM_TIREUR()+lcn.getBmlcn_DTEEC()+lcn.getBmlcn_DTECRE()+lcn.getBmlcn_CONF()+lcn.getBmlcn_VICE();
						
							
						}
						
						if(RegexUtils.matches(recordlcn, Propriete.getInsatance().get(bq+".PATTERN.RECORDLCN.SILCN")))
						{
							if(!lcn.getBmlcn_ZBK().equalsIgnoreCase(Propriete.getInsatance().get(bq+".cde.bq"))){
								bw.write(recordlcn);
								bw.newLine();
								logger.debug(" @@@ : [Enregistrement LCN  CONF "+recordlcn+ " ]",null);
							}
							else
							{
								urlImageRecto=lcn.getBmlcn_RECTO_US_GR().split(";");
								urlImageRecto[0]=urlImageRecto[0].replace("#>F:", Propriete.getInsatance().get(bq+".SERVER.ADD"));
								
								FileOutputStream fosRecto = new FileOutputStream(nameFileSiLcn+"\\Recto_"+lcn.getBmlcn_NSER()+"_"+lcn.getRibTire()+".jpg");
								fosRecto.write(ImageUtils.getStream(urlImageRecto[0], Long.valueOf(urlImageRecto[1]).longValue(),  Integer.parseInt(urlImageRecto[2])));
								fosRecto.close();
								
								urlImageVerso=lcn.getBmlcn_VERSO_DS_GR().split(";");
								urlImageVerso[0]=urlImageVerso[0].replace("#>F:", Propriete.getInsatance().get(bq+".SERVER.ADD"));
								FileOutputStream fosVerso =  new FileOutputStream(nameFileSiLcn+"\\Verso_"+lcn.getBmlcn_NSER()+"_"+lcn.getRibTire()+".jpg");					
								fosVerso.write(ImageUtils.getStream(urlImageVerso[0], Long.valueOf(urlImageVerso[1]).longValue(),  Integer.parseInt(urlImageVerso[2])));
								fosVerso.close();
								
								recordlcn=recordlcn+"Recto_"+lcn.getBmlcn_NSER()+"_"+lcn.getRibTire()+".jpg"+"Verso_"+lcn.getBmlcn_NSER()+"_"+lcn.getRibTire()+".jpg";
								
     							bw.write(recordlcn);
								bw.newLine();
								logger.debug(" @@@ : [Enregistrement LCN  IA "+recordlcn+ " ]",null);
								
							}
							
						}
						else
						{
							logger.debug("+++ :  recordlcn   "+recordlcn+" ne resperct pas le pattern "+Propriete.getInsatance().get(bq+".PATTERN.RECORDLCN.SILCN"),null);
							i=silcnRecord.getRecordRemiseLcn().size();
							j=rem.getRecordsLcn().size();
							 bw.close();
							 DirUtils.deleteDir(nameFileSiLcn);
							flag=false;
					    }
		            }
		        }
				else 
				{
					logger.debug("+++ :  recordlcn   "+RecordRem+" ne resperct pas le pattern "+Propriete.getInsatance().get(bq+".PATTERN.RECORDREM.SILCN"),null);
					i=silcnRecord.getRecordRemiseLcn().size();
					 bw.close();
					 DirUtils.deleteDir(nameFileSiLcn);
					flag=false;
				}
		
		}	
			if(flag)
			{
			bw.write("99");
			bw.close();
			logger.debug("=== Metier : Compresser le fichier "+nameFileSiLcn+" ==>   "+nameZipFileSiLcn ,null);
		      ZipUtils.zipDir(nameFileSiLcn, nameZipFileSiLcn);
		      logger.debug("=== Metier : Supprimer  le dossier temporaire  "+nameFileSiLcn,null);
		      DirUtils.deleteDir(nameFileSiLcn);
				flag=true;
			
			}
		}
		else 
		{
			logger.debug("+++ :  recordlcn   "+header+" ne resperct pas le pattern "+Propriete.getInsatance().get(bq+".PATTERN.ENTETE.SILCN"),null);
			flag=false;
		}
		} catch (IOException e) {
			logger.debug("+++ : IOException sur la methode CreationSILCN "+e.getMessage(),e);
			flag=false;
		}
		catch (Exception e) {
			logger.debug("+++ : Exception sur la methode CreationSILCN "+e.getMessage(),e);
			flag=false;
		}
		return flag;
		
	}

	
//	################################################################################
//							EXTRACTION SI CHQ
//	###################################################################################	
	
	
	public List<RecordRemChq> formatChampsSIChq(String bq, String dteTr) {
		logger.debug("=== Metier : Formater les champs pour generer le fichier SI LCN Banque "+bq+" pour la date du traitement "+dteTr);
		List<RecordRemChq> recordsRemchq = null;
		try {
			recordsRemchq=dao.getRemChqTraiter(dteTr, Propriete.getInsatance().get(bq+".REQ.GETREMTRAITED.SI.CHQ"));
			
			if(recordsRemchq.size()!=0){
				logger.debug("@@@ Metier : Construire & Formater les champs de la ligne Remise ");
				
			for(RecordRemChq r:recordsRemchq){
				r.getRecordsChq().clear();
				r.getRecordsChq().addAll(dao.getChqTraited(dteTr, r.getBmtr_PK_OBJ_IDT(),Propriete.getInsatance().get(bq+".REQ.GETVALUETRAITED.SI.CHQ")));
				r.setIdRemise("02");
				r.setBmtr_NBRVALEUR(StringUtils.padRight(r.getBmtr_NBRVALEUR(), 6, "0"));	
				
				String MNTDECLARER=r.getBmtr_MNTDECLARER();
				if(MNTDECLARER!=null)
				{
					MNTDECLARER=MNTDECLARER.replace(",", "");
					
				  if ( RegexUtils.matches(MNTDECLARER, regxMNT))
					 {
					  MNTDECLARER=StringUtils.replace(MNTDECLARER, regxMNT, "$1$2");
					  MNTDECLARER=StringUtils.padRight(MNTDECLARER, 16, "0");
					  r.setBmtr_MNTDECLARER(MNTDECLARER);
						
					}
				}
				String MNTCALCULER=r.getBmtr_MNTCALCULER();
				if(MNTCALCULER!=null)
				{
					MNTCALCULER=MNTCALCULER.replace(",", "");
					
				  if ( RegexUtils.matches(MNTCALCULER, regxMNT))
					 {
					  MNTCALCULER=StringUtils.replace(MNTCALCULER, regxMNT, "$1$2");
					  MNTCALCULER=StringUtils.padRight(MNTCALCULER, 16, "0");
					  r.setBmtr_MNTCALCULER(MNTCALCULER);
						
					}
				}
				
				String refCli=r.getBmtr_RefCli();
				if(refCli != null && !refCli.isEmpty())
				{
											 
						 refCli=StringUtils.padLeft(refCli, 15, " ");
						  r.setBmtr_RefCli(refCli);
				}
				else 
				{
					 refCli=StringUtils.padLeft(" ", 15, " ");
					  r.setBmtr_RefCli(refCli);
				 }
				
				logger.debug("@@@ Metier : Remise Chq : "+r.getIdRemise()+r.getBmtr_AGE()+r.getBmtr_CPTREM()+r.getBmtr_REFREM()+r.getBmtr_NBRVALEUR()+r.getBmtr_MNTDECLARER()+r.getBmtr_MNTCALCULER()+r.getBmtr_TYPEREM()+r.getBmtr_RefCli());
				
				
				for(RecordChq c: r.getRecordsChq())
				{
					c.setIdChq("03");
					String MNTCHQ=c.getBmch_MNT();
					
					if(MNTCHQ!=null)
					{
						MNTCHQ=MNTCHQ.replace(",", "");
						
					  if ( RegexUtils.matches(MNTCHQ, regxMNT))
						 {
						  MNTCHQ=StringUtils.replace(MNTCHQ, regxMNT, "$1$2");
						  MNTCHQ=StringUtils.padRight(MNTCHQ, 16, "0");
						  c.setBmch_MNT(MNTCHQ);
							
						}
					}
					
					
					 String dateEm=c.getBmch_DTEEMIS();
						if(dateEm != null && !dateEm.isEmpty())
						{
							if(RegexUtils.matches(dateEm, "([0-9]{2})([0-9]{2})([0-9]{4})"))
							{
								dateEm=StringUtils.replace(dateEm, "([0-9]{2})([0-9]{2})([0-9]{4})", "$3$2$1");
							c.setBmch_DTEEMIS(dateEm);
							
							}
							else
							{
							logger.debug("@@@ Metier :  le Champ dateEm ne respect pas le pattern : dateEm " +dateEm,null);
							}
						}
						else 
						{
							logger.debug("@@@ Metier :  le Champ dateEm est vide ou null  : dateEm " +dateEm,null);
						}
						
						
						String mnemoniqueConfor;
						if(c.getBmch_CONFOR().equals("1")){
							 mnemoniqueConfor="000";
							 c.setBmch_REJETCONF(mnemoniqueConfor);
						}
						else{
							
							mnemoniqueConfor=NcrmUtils.getMnemonicAnoFast(c.getBmch_REJETCONF());
							 if(mnemoniqueConfor.length()>0){
							mnemoniqueConfor=mnemoniqueConfor.substring(1, mnemoniqueConfor.length());
							 c.setBmch_REJETCONF(mnemoniqueConfor);
							}else {
								 mnemoniqueConfor="000";
								 c.setBmch_REJETCONF(mnemoniqueConfor);
							}
						}
					 
					
						logger.debug("@@@ Metier : Cheque :  "+c.getIdChq()+c.getBmch_NUMCHQ()+c.getBmch_RIB()+c.getBmch_MNT()+c.getBmch_DTEEMIS()+c.getBmch_CONFOR()+c.getBmch_REJETCONF()+c.getBmch_IMGRECTO()+c.getBmch_IMGVERSO());

				}
				
			}
			
			}
		} catch (Exception e) {
			logger.debug("@@@ Metier : Exception formatChampsSIChq : "+e.getMessage(),e);
		}
		return recordsRemchq;
	}

	public boolean createSiChq(String bq, String dteTr, List<RecordRemChq> recordsRemChq) {
		String pattern_record_Rem=Propriete.getInsatance().get(bq+".PATTERN.RECORDREM.SICHQ");
		String pattern_record_Chq=Propriete.getInsatance().get(bq+".PATTERN.RECORDCHQ.SICHQ");;
		String OutDirSI=Propriete.getInsatance().get(bq+".OUTDIR.SI.CHQ");
		String nameTmpDirSiFile="";
		String nameZipSiFile="";
		String nameSiFile="";
		String prifixFileSi="SI_REM_CHQ_";
		String extensionFileSi=".txt";
		FileWriter fw=null;
		BufferedWriter bw=null;
		boolean flag=true;
		
		try {
			logger.debug("=== : Creation du fichier SI  ",null);	
			if(recordsRemChq.size()> 0)
			{
				for(int i=0;i<recordsRemChq.size();i++)
					{
					RecordRemChq r=recordsRemChq.get(i);
					String recordRem=r.getIdRemise()+r.getBmtr_AGE()+r.getBmtr_CPTREM()+r.getBmtr_REFREM()+r.getBmtr_NBRVALEUR()+r.getBmtr_MNTDECLARER()+r.getBmtr_MNTCALCULER()+r.getBmtr_TYPEREM()+r.getBmtr_RefCli();	
					if(RegexUtils.matches(recordRem, pattern_record_Rem))
						{
						
					
						logger.debug("@@@ : Ecrire un dossier Temporaire fichierSI chq  ",null);	
						nameTmpDirSiFile=prifixFileSi+r.getDATETR()+"_"+r.getBmtr_REFREM()+"_"+r.getBmtr_PK_OBJ_IDT();					
						new File(OutDirSI+"\\"+nameTmpDirSiFile).mkdirs();
						nameSiFile=OutDirSI+"\\"+nameTmpDirSiFile+"\\"+nameTmpDirSiFile+extensionFileSi;
						
						logger.debug("@@@ : Ecrire le fichierSI chq  "+nameSiFile,null);
						File fileSiREM=new File(nameSiFile);
						fw=new FileWriter(fileSiREM);
						bw=new BufferedWriter(fw);
					
						
						
					bw.write(recordRem);
					bw.newLine();
                   logger.debug("@@@ : Ecrire l'enregistrement remise[ "+recordRem+"]",null);
                   
                	   for(int j=0;j<r.getRecordsChq().size();j++)
                   {
                	    RecordChq c=r.getRecordsChq().get(j);
   						String recordChq=c.getIdChq()+c.getBmch_NUMCHQ()+c.getBmch_RIB()+c.getBmch_MNT()+c.getBmch_DTEEMIS()+c.getBmch_CONFOR()+c.getBmch_REJETCONF();//+c.getBmch_IMGRECTO()+c.getBmch_IMGVERSO();
//   						
   						 if(RegexUtils.matches(recordChq,pattern_record_Chq))
   						{
   							String[] urlImageRecto;
   							String[] urlImageVerso;
   							
   							if(c.getBmch_ZBK().equalsIgnoreCase(Propriete.getInsatance().get(bq+".cde.bq"))) {
   								
   								
   								urlImageRecto=c.getBmch_IMGRECTO().split(";");
								urlImageRecto[0]=urlImageRecto[0].replace("#>F:", Propriete.getInsatance().get(bq+".SERVER.ADD"));
								
								FileOutputStream fosRecto = new FileOutputStream(OutDirSI+"\\"+nameTmpDirSiFile+"\\Recto_"+c.getBmch_NUMCHQ()+"_"+c.getBmch_RIB()+".jpg");
								fosRecto.write(ImageUtils.getStream(urlImageRecto[0], Long.valueOf(urlImageRecto[1]).longValue(),  Integer.parseInt(urlImageRecto[2])));
								fosRecto.close();
								
								urlImageVerso=c.getBmch_IMGVERSO().split(";");
								urlImageVerso[0]=urlImageVerso[0].replace("#>F:", Propriete.getInsatance().get(bq+".SERVER.ADD"));
								FileOutputStream fosVerso =  new FileOutputStream(OutDirSI+"\\"+nameTmpDirSiFile+"\\Verso_"+c.getBmch_NUMCHQ()+"_"+c.getBmch_RIB()+".jpg");					
								fosVerso.write(ImageUtils.getStream(urlImageVerso[0], Long.valueOf(urlImageVerso[1]).longValue(),  Integer.parseInt(urlImageVerso[2])));
								fosVerso.close();
								
								recordChq=recordChq+"Recto_"+c.getBmch_NUMCHQ()+"_"+c.getBmch_RIB()+".jpg"+"Verso_"+c.getBmch_NUMCHQ()+"_"+c.getBmch_RIB()+".jpg";
   							}
   							
   							bw.write(recordChq);
   							bw.newLine();
   		                   logger.debug("@@@ : Ecrire l'enregistrement Cheque[ "+recordChq+"]",null);
   		                   flag=true;
   						}
   						else 
   						{
   							logger.debug("+++ : enregistrement cheque : ["+recordChq+"]  ne respect pas le pattern  : "+ pattern_record_Chq,null);
   							bw.close();
   							j=r.getRecordsChq().size();
   							new File(nameTmpDirSiFile).delete();
   							flag=false;
   						}
  					}
                   
                   
                	   bw.close();
 					  
   					
 			 	      if(flag){
 							dao.UpdateExt(r.getBmtr_PK_OBJ_IDT(), Propriete.getInsatance().get(bq+".REQ.UPDATEEXT.SI.CHQ"));
 							 nameZipSiFile=OutDirSI+"\\"+nameTmpDirSiFile+".zip";
 							   logger.debug("=== : Zipfolder "+nameZipSiFile,null);
 					 	       ZipUtils.zipDir(OutDirSI+"\\"+nameTmpDirSiFile, nameZipSiFile);
 					 	       logger.debug("=== : deletefolder "+OutDirSI+"\\"+nameTmpDirSiFile,null);
 					 	       DirUtils.deleteDir(OutDirSI+"\\"+nameTmpDirSiFile);
 					 	      logger.debug("@@@ : Modifier le Flag EXT de la remise [ "+Propriete.getInsatance().get(bq+".REQ.UPDATEEXT.CHQ")+"]",null);
 							
 							logger.debug("@@@ : Modifier le Flag EXT de la remise [ "+r.getBmtr_PK_OBJ_IDT()+"]",null);
 						}
                	   
						}
					
					
					}
				
				
				
			}
		} catch (IOException e) {
			logger.debug("+++ : Metier: IOException dans la method  createSiChq "+ e.getMessage(),e);
		} catch (Exception e) {
			logger.debug("+++ : Metier: Exception dans la method  createSiChq "+ e.getMessage(),e);
		}
		return flag;
	}
	
	public List<RecordRemChq> getAllRemChqTraiterFlager(String bq) {
		String req=Propriete.getInsatance().get(bq+".REQ.GETREM_TRAITED_FLAGER.SI.CHQ");
		System.out.println("REQ "+req);
		List<RecordRemChq> recs=dao.getAllRemChqTraiterFlager(req);
		return recs;
	}

	public List<RecordRemChq> getRemChqTraiterFlagerByDte(String bq,String dteTr) {
		String req=Propriete.getInsatance().get(bq+".REQ.GETREM_TRAITED_FLAGER_by_DTE.SI.CHQ");
		System.out.println("REQ "+req);
		return dao.getRemChqTraiterFlagerByDte(dteTr,req);
	}

//	################################################################################
//	EXTRACTION LOT CHQ
//###################################################################################	
	
	public List<RecordLotChq> formatChampsLotChq(String dteTr, String bq) {
	
	logger.debug("@@@ 1- Extraire les enregistrements du fichier LOT CHQ [bq="+bq+",DTEINS="+dteTr+"]");
	
    List<RecordLotChq> recordsLotChq=dao.getRecordLotchq(dteTr, Propriete.getInsatance().get(bq+".cde.bq"), Propriete.getInsatance().get(bq+".REQ.GETRECORD.LOT.CHQ"));
    
    logger.debug("@@@ 2- formater les enregistrement du fichier LOT CHQ");
    
	for(RecordLotChq r:recordsLotChq){
		
//		type d'operation 
		r.setTypeOperation("031");
//		Ref Operation 
		if(r.getBmch_PK_OBJ_IDT().length()<12)
		{
			r.setRefOperation(StringUtils.padRight(r.getBmch_PK_OBJ_IDT(), 12, "0"));
		}
		else if(r.getBmch_PK_OBJ_IDT().length()>=12)
		{
		
			r.setRefOperation(r.getBmch_PK_OBJ_IDT().substring(r.getBmch_PK_OBJ_IDT().length()-12));
		}
//		*************************************************
//		Information client Remettant 
//		*************************************************
		//		indicateur de presence 
		r.setIndicateurPreRem("1");
		
		//		RIB remettant
		String cleRib=null;
		if(r.getCPTR().length()!=24)
		{
			if(r.getBmtr_CDE_BPR()!=null &&  r.getLOCR()!=null && r.getCPTR()!=null)
			{
				System.out.println(r.getBmtr_CDE_BPR()+"_"+  r.getLOCR()+"_"+ r.getCPTR());
				cleRib=NcrmUtils.cleModulo97(r.getBmtr_CDE_BPR(), r.getLOCR(), r.getCPTR());
			}
			else 
			{
				logger.debug("+++ Erreur sur la methode calcule  cle RIB [ZBKR="+r.getBmtr_CDE_BPR()+", LOCR="+  r.getLOCR()+", CPTR="+ r.getCPTR()+"]");	
			}
			r.setCPT_REM(String.format("%-24s", r.getCPT_REM()+cleRib).replace(' ', '0'));
		}
		else
			{
			r.setCPT_REM(r.getCPTR());
			}
		
		//		PreFixe IBAN 	
		r.setPrifixIbanRem(StringUtils.padRight(" ", 4, " "));
		
		//		Raison sociale Remettant
         String resoc_rem=r.getRESOC_REM();
			if(resoc_rem==null){
				resoc_rem="";	
			}

		r.setRESOC_REM(String.format("%-35s", resoc_rem).replace(' ', ' '));
		
		//		Addresse Remettant
		r.setADD_REM(StringUtils.padRight(" ", 50, " "));
		

//		*************************************************
//		information Concernant le client Tiré  
//		*************************************************
		
		//		indicateur de presence 
		r.setIndicateurPreTire("1");
		
		//		Nser Chèque
		//		Rib Tire
		//		PreFixe IBAN 
		r.setPrifixIbanTire(StringUtils.padRight(" ", 4, " "));
		
		//		Raison sociale Tire
		String resoc_tire=r.getRSOC_TIRE();
		if(resoc_tire==null){
			resoc_tire="";	
		}
		r.setRSOC_TIRE(String.format("%35s",resoc_tire ).replace(' ', ' '));
		
		//		Addresse Tire
		String adr_tire=r.getADR_TIRE();
		if(adr_tire==null){
			adr_tire="";	
		}
		r.setADR_TIRE(String.format("%50s",adr_tire ).replace(' ', ' '));
		
		
		//		Montant chèque
		String mntchq=r.getBmch_mnt();
		
		if(mntchq!=null)
		{
			mntchq=mntchq.replace(",", "");
		  if ( RegexUtils.matches(mntchq, regxMNT))
			 {
			  mntchq=StringUtils.replace(mntchq, regxMNT, "$1$2");
			  mntchq=StringUtils.padRight(mntchq+"", 15, "0");
				
			}
		}
		r.setBmch_mnt(mntchq);
		
		//		Date de traitement 
		String dteEmi=r.getBmch_dteEmi().trim();
		if(RegexUtils.matches(dteEmi, "([0-9]{2})([0-9]{2})([0-9]{4})"))
		{
			dteEmi=StringUtils.replace(dteEmi, "([0-9]{2})([0-9]{2})([0-9]{4})", "$3$2$1");
			r.setBmch_dteEmi(dteEmi);
		}
		//		code chèque
		r.setCodeChq("0");
		
		//		Nature de compte 		
		r.setNatureChq("0");
	
		//		Filler 
		r.setFiller(StringUtils.padRight(" ", 275, " "));

		
	}
	
		return recordsLotChq;
	}
	
	public boolean createLotChq(String bq, String dteTr,List<RecordLotChq> recordsRemChq) {
		String OUTDIR_LOT_CHQ=Propriete.getInsatance().get(bq+".OUTDIR.LOT.CHQ");
		String cdeBq=Propriete.getInsatance().get(bq+".cde.bq");
		FileWriter fw=null;
		BufferedWriter bw=null;
		String requete=Propriete.getInsatance().get(bq+".REQ.GETSUMRECORD.LOT.CHQ");
		String nameLotFile=OUTDIR_LOT_CHQ+"\\"+cdeBq+"."+Propriete.getInsatance().get(bq+".SOURCE.LOT")+".001.031.MAD.LOT";
		String patternHeader=Propriete.getInsatance().get(bq+".PATTERN.RECORDENTETELOT.CHQ");
		String patternBody=Propriete.getInsatance().get(bq+".PATTERN.RECORDLOT.CHQ");
		boolean flag=true;
		
		try {
			
			logger.debug("@@@ Construire l'entete LOT CHQ");
			logger.debug("=== Calculer le Montant et le nombre des cheques traiter LOT CHQ ");
			  List<Object[]> countSum = dao.getCount2ndSumMntTraitedLOT(dteTr,cdeBq,requete);
			  String NbrChq=countSum.get(0)[0]+"";
		      String Mnttotal= (String) countSum.get(0)[1];
			
		     if(Mnttotal!=null)
			{
				Mnttotal=Mnttotal.replace(",", "");
			  if ( RegexUtils.matches(Mnttotal, regxMNT))
				 {
				  Mnttotal=StringUtils.replace(Mnttotal, regxMNT, "$1$2");
				  Mnttotal=StringUtils.padRight(Mnttotal, 16, "0");	
				 }
			 }
			
	    String header="ELOT"+cdeBq+Propriete.getInsatance().get(bq+".SOURCE.LOT")+"001"+"MAD"+StringUtils.padRight(NbrChq, 4, "0")+Mnttotal+"                            ";
		  
		if(RegexUtils.matches(header,patternHeader ))
		{
			logger.debug("=== Enregistrement Entete : ["+header+"]");
			fw = new FileWriter(new File(nameLotFile));
			bw=new BufferedWriter(fw);
			bw.write(header);
			bw.newLine();
			
			for(int i=0;i<recordsRemChq.size();i++)
			{
				RecordLotChq r=recordsRemChq.get(i);
		       String body=r.getTypeOperation()+r.getRefOperation()+r.getIndicateurPreRem()+r.getCPT_REM()+r.getPrifixIbanRem()+r.getRESOC_REM()+r.getADD_REM()+r.getIndicateurPreTire()+r.getBmch_nser()+r.getCPT_TIRE()+r.getPrifixIbanTire()+r.getRSOC_TIRE()+r.getADR_TIRE()+
		    		   r.getBmch_mnt()+r.getBmch_dteEmi()+r.getCodeChq()+r.getNatureChq()+r.getFiller();
            
				if(RegexUtils.matches(body, patternBody))
				{
					  logger.debug("=== Enregistrement Cord: ["+body+"]");
					  bw.write(body);
						bw.newLine();
				}
				else 
				{
					  logger.debug("+++ METIER :Enregistrement Cord: ["+body+"] ne respect pas le pattenr "+patternBody);
					  i=recordsRemChq.size();
					  bw.close();
					   new File(nameLotFile).delete();
					   flag=false;
				}
			}
				bw.close();
		}
		else 
		{
			logger.debug("+++ METIER :Enregistrement Entete : ["+header+"] ne respect pas le pattenr "+patternHeader);
			bw.close();
			new File(nameLotFile).delete();
			flag=false;
		}
			
		} catch (IOException e) {
			logger.debug("+++ METIER :IOException method createLotChq "+e.getMessage(),e);
			flag=false;
		}
		catch (Exception e) {
			logger.debug("+++ METIER :Exception method createLotChq "+e.getMessage(),e);
			flag=false;
		}
		
		
		return flag;
	}
	
//	################################################################################
//	EXTRACTION LOT LCN
//###################################################################################	
	
	public List<RecordLotLcn> formatChampsLotLcn(String ConfIA,String dtePr, String bq) {
       String reqGetRecord4calcIA=Propriete.getInsatance().get(bq+".REQ.GETRECORD4CALCUL.LOT.LCN")+" and zbkt ="+Propriete.getInsatance().get(bq+".cde.bq");
       String reqGetRecordLOTIA=Propriete.getInsatance().get(bq+".REQ.GETRECORD.LOT.LCN")+" and zbkt ="+Propriete.getInsatance().get(bq+".cde.bq");
       
       String reqGetRecord4calcCONF=Propriete.getInsatance().get(bq+".REQ.GETRECORD4CALCUL.LOT.LCN")+" and zbkt !="+Propriete.getInsatance().get(bq+".cde.bq");	
       String reqGetRecordLOTCONF=Propriete.getInsatance().get(bq+".REQ.GETRECORD.LOT.LCN")+" and zbkt !="+Propriete.getInsatance().get(bq+".cde.bq");
      
       String reqUpdateDtePre=Propriete.getInsatance().get(bq+".REQ.UPDATEDTEPRE.LOT.LCN");
       List<RecordLotLcn> recordLotLcn = null;	
       
       try {
    	   
		if(ConfIA.equalsIgnoreCase("IA"))
		   {
			logger.debug("=== 1- Extraireles enregistrement pour calculer la date de presentation  LOT LCN IA QMB [ reqGetRecord4calcIA= "+reqGetRecord4calcIA+"]");
			   recordLotLcn=dao.getRecordLotLcn4calcul(reqGetRecord4calcIA);	
		   }
		   else
		   {
			   logger.debug("=== 1- Extraireles enregistrement pour calculer la date de presentation  LOT LCN CONF QMB [ reqGetRecord4calcCONF= "+reqGetRecord4calcCONF+"]");
			   recordLotLcn=dao.getRecordLotLcn4calcul(reqGetRecord4calcCONF); 
		   }
		   
		   if(recordLotLcn.size()>0)
		   {
		      Log.debug(" === 2- Calculer la date de Presentation ");
			  
		      
		      for(RecordLotLcn r:recordLotLcn)
				   
		       {
				   Date dateEch = DateUtils.formatStringToDate(r.getDTEEC(), "yyyyMMdd");
				   String dateEcheecF = DateUtils.formatDateToStirng(dateEch,"yyyy-MM-dd");
				   Log.debug("@@@ : Formater la date Echeance " + r.getDTEEC()+ "en " + dateEcheecF);
				   Date datePResentation = DateUtils.formatStringToDate(dtePr,"yyyy-MM-dd");
				   
				   String datePreF = DateUtils.formatDateToStirng(datePResentation,"yyyy-MM-dd");
				   Log.debug("@@@ : Formater la date de presentation Saisi "+ dtePr + " en " + datePreF,null); 
				   
				   if ((datePResentation.compareTo(dateEch) > 0)|| (datePResentation.compareTo(dateEch) == 0)) {
						logger.debug("@@@: date de presentation " + datePreF+ "  >=  a la date d'Echeance : " + dateEcheecF,null);
						logger.debug("@@@: mettre dans la colomne dtePRe ["+ datePreF+"]",null);
						r.setDTEPRE(datePreF);
						
						Log.debug("=== 3 - Executer la modification de la date de presentation "+datePreF);
						dao.UpdateDtePr(r.getPK_OBJ_IDT(), datePreF, reqUpdateDtePre);
					}
					if (datePResentation.compareTo(dateEch) < 0) {
						logger.debug("@@@: date de presentation " + datePreF+ "  <  a la date d'Echeance : " + dateEcheecF,null);
						logger.debug("@@@: mettre dans la colomne dtePRe ["+ dateEcheecF+"]",null);
						Log.debug("=== 3 - Executer la modification de la date de presentation "+datePreF);
						r.setDTEPRE(dateEcheecF);
						
						dao.UpdateDtePr(r.getPK_OBJ_IDT(), dateEcheecF, reqUpdateDtePre);
					}
		       }
  
		   }
		   
		   
		   
		   
		   if(ConfIA.equalsIgnoreCase("IA"))
		   {
			   Log.debug("=== Extraire les enregistrement LOT IA avec dtePRe <= "+dtePr);
			  
			   recordLotLcn=dao.getRecordLotLcn(dtePr,reqGetRecordLOTIA);	
		   }
		   else
		   {
			   Log.debug("=== Extraire les enregistrement LOT CONF avec dtePRe <= "+dtePr);
			   recordLotLcn=dao.getRecordLotLcn(dtePr,reqGetRecordLOTCONF); 
		   }
		   
		  
		   if(recordLotLcn.size()>0)
		   {
			  
              for(RecordLotLcn r:recordLotLcn)
				   
		       {
            	// --------- Body 
          		logger.debug("=== : Construction du corp du fichier LOT LCN ",null);
          		
          			
          			// -------------- Type Operation 
          			r.setTypeOperation("060");
          			//--------------  Information de Reference de l'operation 
          			if(r.getPK_OBJ_IDT().length()<12)
          			{
          				r.setRefOperation(StringUtils.padRight(r.getPK_OBJ_IDT(), 12, "0"));
          			}
          			else if(r.getPK_OBJ_IDT().length()>=12){
          			
          				r.setRefOperation(r.getPK_OBJ_IDT().substring(r.getPK_OBJ_IDT().length()-12));
          			}
          			logger.debug("@@@ : PK_OBJ_IDT "+r.getPK_OBJ_IDT(),null);
          			//--------------  information Concernant le client Tiré 
          			r.setIndicateurPreTire("1");
          			
          			//concat(ZBKT,LOCT,cptt,ribt)
          			r.setRibClientTire(r.getZBKT()+r.getLOCT()+r.getCPTT()+r.getRIBT());
          			
          			logger.debug("@@@ : RIB TIRE "+r.getRibClientTire(),null);
          			
          			r.setPrefixeIbanTire(StringUtils.padRight(" ", 4, " "));
          			r.setRSOC_TIRE(StringUtils.padLeft(r.getRSOC_TIRE(), 35, " "));
          			logger.debug("@@@ : RSOC_TIRE "+r.getRSOC_TIRE(),null);
          			
          			r.setADR_TIRE(StringUtils.padLeft(r.getADR_TIRE(), 50, " "));
          			logger.debug("@@@ : ADR_TIRE "+r.getADR_TIRE(),null);
          			
          			//--------------  information Concernant le client Tireur  
          			r.setRSOC_RMT(StringUtils.padLeft(r.getRSOC_RMT(), 35, " "));
          			logger.debug("@@@ : RSOC_RMT "+r.getRSOC_RMT(),null);
          			
          			r.setADR_RMT(StringUtils.padLeft(r.getADR_RMT(), 50, " "));
          			logger.debug("@@@ : ADR_RMT "+r.getADR_RMT(),null);
          			//--------------  information Concernant le benificiare 
          			r.setIndicateurPreBeni("1");

          			//concat(cdeBPR,LOC,cpt,rib)
          			r.setCPT(StringUtils.padRight(r.getCPT(), 16, "0"));
          			String cleRib=null;
          			
          			if(r.getCDEBPR()!=null &&  r.getLOC()!=null && r.getCPT()!=null)
          			{
          				
          			cleRib=NcrmUtils.cleModulo97(r.getCDEBPR(), r.getLOC(), r.getCPT());
          			logger.debug("@@@ : Calcule CLE RIB REMETTANT  "+r.getCDEBPR()+"_"+r.getLOC()+"_"+ r.getCPT()+"_"+cleRib,null);
          			}
          			else 
          			{
          				logger.debug("+++ Erreur sur la methode calcule  cle RIB [ZBKR="+r.getCDEBPR()+", LOCR="+  r.getLOC()+", CPTR="+ r.getCPT()+"]");	
          			}
          			
     
          			r.setRibBeni(r.getCDEBPR()+r.getLOC()+ r.getCPT()+cleRib);
          			logger.debug("@@@ : RIB RMT "+r.getRibBeni(),null);
          			
          			r.setPrefixeIbanBeni(StringUtils.padRight(" ", 4, " "));
          			
          			r.setRSOC_BEN(StringUtils.padLeft(r.getRSOC_BEN(), 35, " "));
          			logger.debug("@@@ : RSOC_BEN "+r.getRSOC_BEN(),null);
          			
          			r.setADR_BEN(StringUtils.padLeft(r.getADR_BEN(), 50, " "));
          			logger.debug("@@@ : ADR_BEN "+r.getADR_BEN(),null);
          			
          			String MntLcn=r.getMNT();
          			if(MntLcn!=null)
        			{
          				MntLcn=MntLcn.replace(",", "");
        			  if ( RegexUtils.matches(MntLcn, regxMNT))
        				 {
        				  MntLcn=StringUtils.replace(MntLcn, regxMNT, "$1$2");
        				  MntLcn=StringUtils.padRight(MntLcn+"", 15, "0");
        				  r.setMNT(MntLcn);
        					
        				}
        			  else 
        			  {
        				  logger.debug("=== : MntLcn:"+MntLcn+" ne respect pas le pattern  "+regxMNT,null);  
        			  }
        			}
            		logger.debug("@@@ : MntLcn "+r.getMNT(),null);
          			
          			r.setDTEEC(StringUtils.padRight(r.getDTEEC(), 8, "0"));
          			logger.debug("@@@ : DTEEC "+r.getDTEEC(),null);
          			
          			r.setDTEMI(StringUtils.padRight(r.getDTEMI(), 8, "0"));
          			
          			logger.debug("@@@ : DTEMI "+r.getDTEMI(),null);
          			r.setLibelle(StringUtils.padRight(" ", 70, " "));
          			logger.debug("@@@ : Libelle "+r.getLibelle(),null);
          			r.setFiller(StringUtils.padRight(" ", 113, " "));
          			logger.debug("@@@ : Filler "+r.getFiller(),null);
          			
          			String body=r.getTypeOperation()+"|"+
    						r.getRefOperation()+"|"+
    						r.getIndicateurPreTire()+"|"+
    						r.getRibClientTire()+"|"+
    						r.getPrefixeIbanTire()+"|"+
    						r.getRSOC_TIRE()+"|"+
    						r.getADR_TIRE()+"|"+
    						r.getRSOC_BEN()+"|"+
    						r.getADR_BEN()+"|"+
    						r.getIndicateurPreBeni()+"|"+
    						r.getRibBeni()+"|"+
    						r.getPrefixeIbanBeni()+"|"+
    						r.getRSOC_BEN()+"|"+
    						r.getADR_BEN()+"|"+
    						r.getMNT()+"|"+
    						r.getNSER()+"|"+
    						r.getDTEEC()+"|"+
    						r.getDTEMI()+"|"+
    						r.getCDEAVAL()+"|"+
    						r.getLibelle()+"|"+
    						r.getFiller();
          			logger.debug("@@@ : body "+body,null);
    						
		       }
              
              
		   }
		   
		   
		   
	} catch (ParseException e) {
		Log.debug("+++ ParseException formatChampsLotLcn "+e.getMessage(),e);
	}
       catch (Exception e) {
   		Log.debug(" +++ Exception formatChampsLotLcn "+e.getMessage(),e);
   	}

		return recordLotLcn;
	}
		
	public boolean createLotLCN(String bq, String ConfIA,String dtepre,List<RecordLotLcn> recordsLotLcn) {
		
		String cdeBq=Propriete.getInsatance().get(bq+".cde.bq");
		FileWriter fw=null;
		BufferedWriter bw=null;
		String requete="";	
		String reqUpdateFlagExt=Propriete.getInsatance().get(bq+".REQ.UPDATEFLAGEXT.LOT.LCN");
		String patternHeader=Propriete.getInsatance().get(bq+".PATTERN.RECORDENTETELOT.LCN");
		String patternBody=Propriete.getInsatance().get(bq+".PATTERN.RECORDLOT.LCN");
		String OUTDIR_LOT_LCN="";
		String nameLotFile="";
		boolean flag=true;
try {
			
			
			if(ConfIA.equalsIgnoreCase("IA"))
			{
				  OUTDIR_LOT_LCN=Propriete.getInsatance().get(bq+".OUTDIR.LOT.IA.LCN");
				  nameLotFile=OUTDIR_LOT_LCN+"\\"+cdeBq+"."+Propriete.getInsatance().get(bq+".SOURCE.LOT")+".001.060.IA.MAD.LOT";
				  requete=Propriete.getInsatance().get(bq+".REQ.GETSUMRECORD.LOT.IA.LCN");
			}
			else
			{
				  OUTDIR_LOT_LCN=Propriete.getInsatance().get(bq+".OUTDIR.LOT.LCN");
				  nameLotFile=OUTDIR_LOT_LCN+"\\"+cdeBq+"."+Propriete.getInsatance().get(bq+".SOURCE.LOT")+".001.060.MAD.LOT";
				  requete=Propriete.getInsatance().get(bq+".REQ.GETSUMRECORD.LOT.LCN");
			}
			
		     
		if(recordsLotLcn.size()>0)   
		{
			
			logger.debug("=== Ecrire le fichier LOT LCN date dtePRe:"+dtepre+ " Banque "+cdeBq);
			logger.debug("@@@ 1 - Construire l'entete LOT LCN");
			logger.debug("@@@ Calculer le somme et le nombre des lcn traiter dtepre<="+dtepre);
			
			  List<Object[]> countSum = dao.getCount2ndSumMntTraitedLOT(dtepre,cdeBq,requete);
			  String NbrChq=countSum.get(0)[0]+"";
		      String Mnttotal= (String) countSum.get(0)[1];
			
		     if(Mnttotal!=null)
			{
				Mnttotal=Mnttotal.replace(",", "");
			  if ( RegexUtils.matches(Mnttotal, regxMNT))
				 {
				  Mnttotal=StringUtils.replace(Mnttotal, regxMNT, "$1$2");
				  Mnttotal=StringUtils.padRight(Mnttotal, 16, "0");	
				 }
			 }
	    String header="ELOT"+cdeBq+Propriete.getInsatance().get(bq+".SOURCE.LOT")+"001"+"MAD"+StringUtils.padRight(NbrChq, 4, "0")+Mnttotal+StringUtils.padRight(" ", 28, " ");
		  
		if(RegexUtils.matches(header,patternHeader ))
		{
			logger.debug("=== Enregistrement Entete : ["+header+"]");
			fw = new FileWriter(new File(nameLotFile));
			bw=new BufferedWriter(fw);
			bw.write(header);
			bw.newLine();
			
			for(int i=0;i<recordsLotLcn.size();i++)
			{
				RecordLotLcn r=recordsLotLcn.get(i);
		       String body=r.getTypeOperation()+
		    		       r.getRefOperation()+
		    		       r.getIndicateurPreTire()+
		    		       r.getRibClientTire()+
		    		       r.getPrefixeIbanTire()+
		    		       r.getRSOC_TIRE()+
		    		       r.getADR_TIRE()+
		    		       r.getRSOC_BEN()+
		    		       r.getADR_BEN()+
		    		       r.getIndicateurPreBeni()+
		    		       r.getRibBeni()+
		    		       r.getPrefixeIbanBeni()+
		    		       r.getRSOC_BEN()+
		    		       r.getADR_BEN()+		    		  
		    		       r.getMNT()+
		    		       r.getNSER()+
		    		       r.getDTEEC()+
		    		       r.getDTEMI()+
		    		       r.getCDEAVAL()+
		    		       r.getLibelle()+
		    		       r.getFiller();
            
				if(RegexUtils.matches(body, patternBody))
				{
					  logger.debug("=== Enregistrement Cord: ["+body+"]");
					  bw.write(body);
						bw.newLine();
				}
				else 
				{
					  logger.debug("+++ Enregistrement Cord: ["+body+"] ne respect pas le pattenr "+patternBody);
					  i=recordsLotLcn.size();
					  bw.close();
					   new File(nameLotFile).delete();
					   flag=false;
				}
			}
				bw.close();
		}
		else 
		{
			logger.debug("+++ Enregistrement Entete : ["+header+"] ne respect pas le pattenr "+patternHeader);
			bw.close();
			new File(nameLotFile).delete();
			flag=false;
		}
		}
		if(flag){
			for(int i=0;i<recordsLotLcn.size();i++)
			{
				 logger.debug("=== Modifier le FLAG EXT ");
				RecordLotLcn r=recordsLotLcn.get(i);
				dao.UpdateFlagEXT(r.getPK_OBJ_IDT(),reqUpdateFlagExt);
			}
		}
			
		} catch (IOException e) {
			logger.debug("+++ METIER :IOException method createLotChq "+e.getMessage(),e);
			flag=false;
		}
		
		
		return flag;
	}
	
	
//	################################################################################
//	EXTRACTION ETA
//###################################################################################	
	
	public int extractDataEta(String bq, String tr, String dteTr) {
		boolean flag=false;
		int count=0;
		
//		================================================== BAA ==================================================
		
		
		
		if(bq.equalsIgnoreCase("BAA"))
		{ 
			System.out.println("###" +bq);
			count=dao.getCountValueTraitedBaa(bq,  tr,dteTr).intValue();

		      if(count>0)
		      {
		    	  flag=dao.extractDataEtaChqLcntoCsvBaa(bq, tr, dteTr);
		    	  if(!flag)
		    	  {
		    		  count=0;  
		    	  }
		      }
		}
//		================================================== SGMA ==================================================
		
		else if(bq.equals("SGMA"))
		{ 
			count=dao.getCountValueTraitedSgma(bq,  tr,dteTr).intValue();

		      if(count>0)
		      {
		    	  flag=dao.extractDataEtaChqLcntoCsv(bq, tr, dteTr);
		    	  if(!flag)
		    	  {
		    		  count=0;  
		    	  }
		      }
		}
		
		
//		================================================== QMB/BPM ==================================================
		
		
		
		
		else 
		{
			count=dao.getCountValueTraited(bq,  tr,dteTr).intValue();

		      if(count>0)
		      {
		    	  flag=dao.extractDataEtaChqLcntoCsv(bq, tr, dteTr);
		    	  if(!flag)
		    	  {
		    		  count=0;  
		    	  }
		      }
		}
		
      
		return count;
	}
	
	
	public int getCountValueTraitedSgma(String bq,String   tr,String dteTr){
		return dao.getCountValueTraitedSgma(bq,  tr,dteTr).intValue();
	}
	
	
	public String getAnomalie(String bq,String cdeTr,String PK_ANO_MNE) {
		String anomalie="";
		
		
//		================================================== BAA ==================================================
		
		if(bq.equals("BAA"))
		{ 
			if(cdeTr.equalsIgnoreCase("031"))
			{
				anomalie=dao.getAnomalieBaa(PK_ANO_MNE, cdeTr, Propriete.getInsatance().get(bq+".REQ.GETLBLANO.CHQ"));
				
			}
			if(cdeTr.equalsIgnoreCase("060"))
			{
				anomalie=dao.getAnomalieBaa(PK_ANO_MNE, cdeTr, Propriete.getInsatance().get(bq+".REQ.GETLBLANO.LCN"));
				
			}
		
		}
		
		
//		================================================== SGMA ==================================================
		
		else if(bq.equals("SGMA"))
		{ 
			if(cdeTr.equalsIgnoreCase("031"))
			{
				anomalie=dao.getAnomalieSgma(PK_ANO_MNE, cdeTr, Propriete.getInsatance().get(bq+".REQ.GETLBLANO.CHQ"));
				
			}
			if(cdeTr.equalsIgnoreCase("060"))
			{
				anomalie=dao.getAnomalieSgma(PK_ANO_MNE, cdeTr, Propriete.getInsatance().get(bq+".REQ.GETLBLANO.LCN"));
				
			}
		
		}
		
		
//		================================================== BPM/QMB ==================================================
		else
		{
			if(cdeTr.equalsIgnoreCase("031"))
			{
				anomalie=dao.getAnomalie(PK_ANO_MNE, cdeTr, Propriete.getInsatance().get(bq+".REQ.GETLBLANO.CHQ"));
				
			}
			if(cdeTr.equalsIgnoreCase("060"))
			{
				anomalie=dao.getAnomalie(PK_ANO_MNE, cdeTr, Propriete.getInsatance().get(bq+".REQ.GETLBLANO.LCN"));
				
			}	
		}
		
		return anomalie;
	}
	
	
	
//	SUIVI PHYSIQUE 
	@Override
	public int extractData4Suvi(String bq,String trt,String dtetrt1,String dtetrt2,String Listpcapts){
		boolean flag=false;
		int count=0;
		if(bq.equals("SGMA"))
		{ 
			count=dao.getCountValueSuiviSgma(bq,  trt,dtetrt1,dtetrt2,Listpcapts).intValue();

		      if(count>0)
		      {
		    	  flag=dao.extractDataSuiviChqLcn(bq, trt, dtetrt1,dtetrt2,Listpcapts);
		    	 
		    	  if(!flag)
		    	  {
		    		  count=0;  
		    	  }
		      }
		}
		
		return count;
		
	}
	
	@Override
	public List<BeanSuiviPhysique> getRecupFluxphysique(String bq,String trt) {
		String req;
		if(trt.equals("031")){
		req=Propriete.getInsatance().get(bq+".REQ.RECUP.SUIVI.CHQ");
		}
		else{
			 req=Propriete.getInsatance().get(bq+".REQ.RECUP.SUIVI.LCN");
		}
		return dao.getRecupFluxphysique(req);
	}
	
	
	public List<BeanDetailSuiviPhysique> getDetailFluxphysique(String bq,String trt) {
		String req;
		if(trt.equals("031")){
		req=Propriete.getInsatance().get(bq+".REQ.DETAIL.SUIVI.CHQ");
		}
		else{
			 req=Propriete.getInsatance().get(bq+".REQ.DETAIL.SUIVI.LCN");
		}
		return dao.getDetailFluxphysique(req);
	}
	
	
//	################################################################################
//	GESTION CPT , AGE & SCANNER
//###################################################################################
	
	public List<BeanCompte> getAllComptes(String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.GETALL.COMPTE");
		List<BeanCompte> cpts;
		if(bq.equalsIgnoreCase("BAA")){
			cpts= dao.getAllComptesBaa(req);
		}
		else {
			cpts=dao.getAllComptes(req);
		}
		return cpts;
	}

	
	public int AddCpt(List<BeanCompte> listCpt, String bq) {
		// TODO Auto-generated method stub
				System.out.println("listage.size()"+listCpt.size());
				String req=Propriete.getInsatance().get(bq+".REQ.ADD.CPT");
				int count=0;
				for(BeanCompte cpt:listCpt)
				{
					int c=dao.AddCpt(cpt, req);
					System.out.println("Ccc"+c);
				if(c==1){
				count=count+1;	
				}
				}
				return count;
	}

	public int DeleteAllCpts(String bq) {
		// TODO Auto-generated method stub
				String req=Propriete.getInsatance().get(bq+".REQ.DEL.ALL.CPT");
				return dao.DeleteAllCpts(req);
	}
	
	public List<BeanAgence> getAllAgences(String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.GETALL.AGENCE");
		List<BeanAgence> ages;
		if(!bq.equalsIgnoreCase("BAA")){
			ages= dao.getAllAgences(req);
		}else 
		{
			ages= dao.getAllAgencesBaa(req);	
		}
		return ages;
	}

	public int AddAge( String bq,BeanAgence age) {
	
		String req=Propriete.getInsatance().get(bq+".REQ.ADD.AGE");
		int count=dao.AddAge(age, req);
		return count;
	}

	public int DeleteAge(String idage,String bq)  {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.DEL.AGE");
		return dao.DeleteAge(idage, req);
		
	}
	public BeanAgence getagebycde(String cdeAge, String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.GETAGE.BY.CDE");
		return dao.getagebycde(cdeAge, req);
	}

	public List<beanScann> getScannerByage(String cdeAge, String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.GETSCA.BY.AGE");
		List<beanScann> scans;
		if(bq.equalsIgnoreCase("BAA")){
		scans=dao.getScannerByageBaa(cdeAge, req);
		}
		else {
			scans=dao.getScannerByage(cdeAge, req);
		}
			
		 return scans;
	}

	public int AddScanner(beanScann sc,String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.ADDSCA.TOAGE");
		int i;
		if(bq.equalsIgnoreCase("BAA")){
			i=dao.AddScannerBaa(sc,req);
		}
		else {
			i=dao.AddScanner(sc,req);
		}
		return i;
	}

	
//	################################################################################
//	EXTRACTION IMP CHQ
//###################################################################################	
	
// *********** CONF
	
	public List<BeanImpChq> readFromCroCHQ(String bq) {
		return dao.readFromCroCHQ(bq);
	}

	public List<BeanImpChq> readFromProdCHQ(List<BeanImpChq> impyschq,String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.CHQ");
		return dao.readFromProdCHQ(impyschq, req);
	}

	public List<BeanImpChq> readFromIFPConfCHQ(String bq,List<BeanImpChq> impychq) {
		// TODO Auto-generated method stub
		return dao.readFromIFPConfCHQ(bq, impychq);
	}

// *********** IA 
	
	public  List<BeanImpChq> readFromIFPIACHQ(String bq) {
		// TODO Auto-generated method stub
		return dao.readFromIFPIACHQ(bq);
	}

	public List<BeanImpChq> readFromProdIACHQ(List<BeanImpChq> impychq,String dteTr1,String bq) {
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.IA.CHQ");
		return dao.readFromProdIACHQ(impychq, dteTr1, req);
	}

//	************* Charger Les impayees dans tbl temporaire 
	
	public List<BeanImpChq> loadImpysCHQ(List<BeanImpChq> impys, String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.ADDIMP.CHQ");
		return dao.loadImpysCHQ(impys, req);
	}

//	################################################################################
//	EXTRACTION IMP LCN
//###################################################################################	

	// *********** CONF
	
	public List<BeanImpLcn> readFromCroLCN(String bq) {
		// TODO Auto-generated method stub
		return dao.readFromCroLCN(bq);
	}

	public List<BeanImpLcn> readFromProdLCN(List<BeanImpLcn> impyslcn, String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.LCN");
		return dao.readFromProdLCN(impyslcn, req);
	}

	public List<BeanImpLcn> readFromIFPConfLCN(List<BeanImpLcn> impylcn,
			String bq) {
		// TODO Auto-generated method stub
		return dao.readFromIFPConfLCN(impylcn, bq);
	}

	// *********** IA 
	
	public List<BeanImpLcn> readFromIFPIALCN(String bq) {
		// TODO Auto-generated method stub
		return dao.readFromIFPIALCN(bq);
	}

	public List<BeanImpLcn> readFromProdIALCN(List<BeanImpLcn> impysLcn,
			String dteSort, String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.IA.LCN");
		return dao.readFromProdIALCN(impysLcn, dteSort, req);
	}

//	************* Charger Les impayees dans tbl temporaire 
	
	public List<BeanImpLcn> loadImpysLCN(List<BeanImpLcn> impys, String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.ADDIMP.LCN");
		return dao.loadImpysLCN(impys, req);
	}

//	************* Exporter les impayées dans un fichier plat CSV 
	
	public boolean chargertableimpaye(String bq, String cdeTr, String dteTrt) {
		// TODO Auto-generated method stub
		return dao.chargertableimpaye(bq, cdeTr, dteTrt);
	}


	public List<BeanCountImpy> getImpyChqByBq(String bq) {
		String req=Propriete.getInsatance().get(bq+".REQ.COUNT.IMP.CHQ");
		if(bq.equals("BAA")){
			return dao.getImpyChqByBqBaa(req);
		}
		else {
			return dao.getImpyChqByBq(req);
		}
	
	}
	
	
	public List<BeanCountImpy> getImpyLcnByBq(String bq) {
		// TODO Auto-generated method stub
				String req=Propriete.getInsatance().get(bq+".REQ.COUNT.IMP.LCN");
				if(bq.equals("BAA")){
					return dao.getImpyChqByBqBaa(req);
				}
				else {
					return dao.getImpyChqByBq(req);
				}
				
	}

	
	public List<BeanCountImpy> getImpyByBq(String bq,String trt) {
		// TODO Auto-generated method stub
		String req=null;
		if(trt.equalsIgnoreCase("060")){
				 req=Propriete.getInsatance().get(bq+".REQ.COUNT.IMP.LCN");
		}
		else {
			req=Propriete.getInsatance().get(bq+".REQ.COUNT.IMP.CHQ");
		}
				return dao.getImpyByBqSg(req,trt);
	}
	
	public  List<BeanImpLcnSG> readFromProdIALCNSg(List<BeanImpLcnSG> impysLcn,String dteSort,String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.IA.LCN");
		return dao.readFromProdIALCNSg(impysLcn, dteSort, req);
	}
	
	public Idao getDao() {
		return dao;
	}



	public void setDao(Idao dao) {
		this.dao = dao;
	}

	public List<Object[]> getopePrf() {
		List<Object[]> listrprofBmce=dao.gettr_prfBMCE();
		for(Object j:listrprofBmce){
			String pk=j.toString();
			System.out.println("TOTTOO "+pk);
			dao.Addta_prf_optBMCE(pk);
			
		}
		return dao.gettr_prfBMCE();
	}

	
	
	
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* CFG */	   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public boolean receptionFichierPayer(String bq, String trt) {
		// TODO Auto-generated method stub
		String FOLDER_IN=Propriete.getInsatance().get(bq+".FOLDER.IN.CLASSIFY.PAYEE."+trt);
		String PATTERN_FILE_IN=Propriete.getInsatance().get(bq+".PATTERN.FILE.IN.CLASSIFY.PAYEE."+trt);
		String nameFileIn="";
		File folder=new File(FOLDER_IN);
		File[] listOffile=null;
		
		ApplicationContext context=null ;
		JobLauncher jobLauncher=null ;
		Job job=null ;
		String StatusJob="";
		boolean flag=false;
		
		listOffile = folder.listFiles();
		// import All File .csv respect pattern csv
	
		try {
			logger.debug("=== parcourir le dossier : "+FOLDER_IN +" Pour inserer les fichier .csv",null);
			
			for (int i = 0; i < listOffile.length; i++) 
			{
				if (listOffile[i].isFile()) 
				{
				
					if (RegexUtils.matches(listOffile[i].getName(),PATTERN_FILE_IN)) 
					{
						
					if(trt.equalsIgnoreCase("CHQ")){	
						dao.purgeTablePaidChq(bq,trt);
					}
						
					if(trt.equalsIgnoreCase("LCN")){	
						dao.purgeTablePaidLcn(bq,trt);
					}	
						
						logger.debug("@@@ le fichier "+listOffile[i].getName()+" respect le pattern = "+PATTERN_FILE_IN,null);
						nameFileIn = listOffile[i].getPath();
						
						logger.debug("@@@ lancement du Batch Import File In",null);
						 String pathspringconfig="classpath:/../spring/batch/jobs/job-Impot-File-to-classify-paid-value-"+bq+".xml";
						 String[] springConfig = { pathspringconfig };
						 context = new ClassPathXmlApplicationContext(springConfig);
						 jobLauncher = (JobLauncher) context.getBean("jobLauncher");
						 job = (Job) context.getBean("importFile"+bq+trt);
						 
						 logger.debug("@@@ : import le fichier " + nameFileIn,null);
						JobParameters param = new JobParametersBuilder().addString("resource", nameFileIn).toJobParameters();
						JobExecution execution = jobLauncher.run(job, param);
						StatusJob = execution.getStatus().toString();
						
						if (execution.getStatus() == BatchStatus.COMPLETED)
						{
							logger.debug("@@@ : importation du fichier " + nameFileIn+ " est faite correctement StatusJob = "+StatusJob,null);
							logger.debug("=== Renommer le ficher .success == "+nameFileIn+ ".success",null);
					Files.move(Paths.get(nameFileIn),Paths.get(nameFileIn+ ".success"),StandardCopyOption.REPLACE_EXISTING);
//							new File(nameFileIn).renameTo(new File(nameFileIn+ ".success"));
							flag=true;
						}
						else
						{
							logger.debug("+++ : importation du fichier " + nameFileIn+ " est faite avec erreur StatusJob = "+StatusJob +"==> "+execution.getAllFailureExceptions(),null);							
							logger.debug("=== Renommer le ficher .filed == "+nameFileIn+ ".filed",null);
						Files.move(Paths.get(nameFileIn),Paths.get(nameFileIn+ ".filed"),StandardCopyOption.REPLACE_EXISTING);
//							new File(nameFileIn).renameTo(new File(nameFileIn+ ".filed"));
							flag=false;
						}

					}
				}

			}
		} catch (BeansException e) {
			logger.debug("+++ BeansException method receptionFichierPayer "+e.getMessage(),e);
		} catch (JobExecutionAlreadyRunningException e) {
			logger.debug("+++ JobExecutionAlreadyRunningException method receptionFichierPayer "+e.getMessage(),e);
		} catch (JobRestartException e) {
			logger.debug("+++ JobRestartException method receptionFichierPayer "+e.getMessage(),e);
		} catch (JobInstanceAlreadyCompleteException e) {
			logger.debug("+++ JobInstanceAlreadyCompleteException method receptionFichierPayer "+e.getMessage(),e);
		} catch (JobParametersInvalidException e) {
			logger.debug("+++ JobParametersInvalidException method receptionFichierPayer "+e.getMessage(),e);
		}
		catch (Exception e) {
			logger.debug("+++ Exception method receptionFichierPayer "+e.getMessage(),e);
		}
		return flag;
	}

	public void createFileSuiviPhysique(String bq, String trt,String listparams,String listPcapts,String IDuser,String datePr) {
		FileWriter fw=null;
		BufferedWriter bw=null;
		List<RecordPaidValue> RecordPaidValues=null;
		String nameFile=null;
		String OUTDIR= Propriete.getInsatance().get(bq+".OUT.REC.SUIVI."+trt)+"\\"+IDuser;
		try {
			
			
			if(trt.equalsIgnoreCase("CHQ")){
			RecordPaidValues=dao.getAllValueChq(bq, trt,listparams,listPcapts);
			}
			if(trt.equalsIgnoreCase("LCN")){
				RecordPaidValues=dao.getAllValueLcn(bq, trt,listPcapts);
			}
			
			
            if (RecordPaidValues.size()>0)
            {
            	
            	if (!new File(OUTDIR).exists()) {
    				new File(OUTDIR).mkdirs();
    			}
            	 nameFile=OUTDIR+"\\TraitedChq.txt";
     			
     			logger.debug("=== Ecrire le  fichier Machine Trt :"+trt+"==> "+nameFile,null);
                fw=fw = new FileWriter(new File(nameFile));
     			
            	bw=new BufferedWriter(fw);
			
         for(RecordPaidValue b:RecordPaidValues)
			{

//				##############################################################################################		
				if(bq.equalsIgnoreCase("SGMA")){

					
				
       if (trt.equalsIgnoreCase("LCN")){
    	   Date dateEch=null;
    	   String dateEcheecF="";
    	   Date datePResentation=null;
    	   String datePreF="";
    	  if ((b.getDteec()!=null)&&(b.getOpe_eta().equals("I"))){
    		
    		  String record="";
    	   
                 if((!b.getDteec().equals("0"))){
					  dateEch = DateUtils.formatStringToDate(b.getDteec(), "ddMMyyyy");
					  dateEcheecF = DateUtils.formatDateToStirng(dateEch,"yyyy-MM-dd");
	   
                 }
                 
                 else {
                	  dateEch = DateUtils.formatStringToDate("19101989", "ddMMyyyy");
					  dateEcheecF = DateUtils.formatDateToStirng(dateEch,"yyyy-MM-dd");	 
                 }
                 datePResentation = DateUtils.formatStringToDate(datePr,"yyyy-MM-dd");
				  datePreF = DateUtils.formatDateToStirng(datePResentation,"yyyy-MM-dd");
				  
				  System.out.println("datePreF"+datePreF+"<==> dateEcheecF"+dateEcheecF);
				 
				   
					   if ((datePResentation.compareTo(dateEch) > 0)|| (datePResentation.compareTo(dateEch) == 0)) {
							  
						   System.out.println("$$$ Echue ");  
						
							  
						   b.setPoche(StringUtils.padLeft(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.ECHUE."+trt), 4, " "));  
					   }
			
					   logger.debug("@@@ : [Poche="+b.getPoche()+"][VF="+b.getConf()+"][RD="+b.getRDelta()+"][IMPY="+b.getImpy()+"]",null);
						   
								if(b.getPoche()==null)
								{
				
									b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE."+trt));
								}
														
								if(b.getConf().equals("0")){
									b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.VF."+trt));
								}
//								if(b.getOpe_eta().equals("D")){
//									b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.SUP."+trt));
//								}
								if(b.getRDelta()!=null && b.getRDelta().equals("1")){
									b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.RD."+trt));
								}
								if(b.getImpy()!=null && b.getImpy().equals("1")){
									b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.IMP."+trt));
								}
								
								
							
									record=b.getZbk()+b.getLoc()+b.getNser()+b.getCpt()+b.getRib()+" "+StringUtils.padLeft(b.getPoche(), 4, " ");
									logger.debug("@@@ : record   "+record,null);
									bw.write(record);
									bw.newLine();
					  
       
       
//       if(b.getDteec().equals("0")){
//           
//		   
//		   String record=b.getZbk()+b.getLoc()+b.getNser()+b.getCpt()+b.getRib()+" "+StringUtils.padLeft(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.ECHUE."+trt), 4, " ");
//			logger.debug("@@@ : record   "+record,null);
//			bw.write(record);
//			bw.newLine(); 
//	   }
    	  }

					  
					   
					   
					
					
					
					
				}
					if  (trt.equalsIgnoreCase("CHQ")){
					
						if(b.getPoche()==null)
						{

							b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE."+trt));
						}
						
						if(b.getConf().equals("0")){
							b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.VF."+trt));
						}
//						if(b.getOpe_eta().equals("D")){
//							b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.SUP."+trt));
//						}
						if(b.getRDelta()!=null && b.getRDelta().equals("1")){
							b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.RD."+trt));
						}
						if(b.getImpy()!=null && b.getImpy().equals("1")){
							b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE.IMP."+trt));
						}
						if(!b.getOpe_eta().equals("D")){
						String record=b.getZbk()+b.getLoc()+b.getNser()+b.getCpt()+b.getRib()+" "+StringUtils.padLeft(b.getPoche(), 4, " ");
						logger.debug("@@@ : record   "+record,null);
						bw.write(record);
						bw.newLine();
					}
				}
				}
				
//				##############################################################################################
				
				
				else{
				
						if(b.getPoche()==null)
						{

							b.setPoche(Propriete.getInsatance().get(bq+".DEFAULT.POCHE."+trt));
						}
						
						if(!b.getOpe_eta().equals("D")){
						String record=b.getZbk()+b.getLoc()+b.getNser()+b.getCpt()+b.getRib()+" "+StringUtils.padLeft(b.getPoche(), 4, " ");
						logger.debug("@@@ : record   "+record,null);
						bw.write(record);
						bw.newLine();
					}
					
				}
				
			}
		
			}
			
		} catch (IOException e) {
			logger.debug("+++ : IOException   createFile "+e.getMessage(),e);
		}
		catch (Exception e) {
			logger.debug("+++ : Exception   createFile "+e.getMessage(),e);
		} finally {
		    if (bw != null) {
		        try {
		        	bw.close();
		        } catch (IOException ex) {
		            // ignore ... any significant errors should already have been
		            // reported via an IOException from the final flush.
		        }
		    }
		}
		

	}

	public List<BeanCountpye> getCountValue(String bq, String trt) {
		List<BeanCountpye> beancountpye=new ArrayList<BeanCountpye>();
		if(trt.equalsIgnoreCase("CHQ")){
			beancountpye=dao.getCountValueChq(bq, trt);
		}
		if(trt.equalsIgnoreCase("LCN")){
			beancountpye=dao.getCountValueLcn(bq, trt);
		}
		return beancountpye;
		}
	
	
	public int updateValideFluxphysique(String bq,String listPcapts,String listdte,String trt,String username){
		String req=Propriete.getInsatance().get(bq+".REQ.UPDATE.SUIVI."+trt);;
		return dao.updateValideFluxphysique(req, listPcapts, listdte,username);
	}
	
	public int synchronImpayeLCNFluxphysique(String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.SYNCH.IMPY.LCN");
		return dao.synchronImpayeLCNFluxphysique(req);
	}
//###############################################################################################################################################
	    /* BAA  */
//###############################################################################################################################################
	@Override
	public BaaSilcnRecord formatChampsSILCNBaa(String bq, String dteTr) {
		 BaaSilcnRecord silcnRecord = null;
			String dteJour=DateUtils.formatDateToStirng(new Date(), "ddMMyyyy");
			String cdeBq=Propriete.getInsatance().get(bq+".cde.bq");
			try
			{
		
			logger.debug("=== Metier : Formater les champs pour generer le fichier SI LCN Banque "+bq+" pour la date du traitement "+dteTr);
			logger.debug("@@@ Metier : Construire & Formater l'Entete SILCN");
		   
//			************* 1- Calculer le nombre de LCN 
			
			BigInteger RemLcnTraited=dao.getCountRemTraitedBaa(dteTr,Propriete.getInsatance().get(bq+".REQ.GETCOUNT.REM.LCN"));
		   
		   if(!RemLcnTraited.equals(new BigInteger("0")))
		   {
			   silcnRecord=new BaaSilcnRecord();
			   List<BaaRecordRemLCN> listrecordRemLcn = new ArrayList<BaaRecordRemLCN>();
				
//			************* 3- Get Remise LCNs traitées  
			   
				  listrecordRemLcn.clear();
				  listrecordRemLcn=dao.getRemLcnTraiterBaa(dteTr,Propriete.getInsatance().get(bq+".REQ.GETREMTRAITED.LCN"));
				 
				  logger.debug("@@@  Construire & Formater la line Remise du fichier SILCN "+ Propriete.getInsatance().get(bq+".REQ.GETREMTRAITED.LCN"));
					
/**** Formater l'enregistrement REMISE */	
				  
				  for(BaaRecordRemLCN recordRemLcn:listrecordRemLcn)
					{
						List<BaaRecordLCN> listrecordsLcn = new ArrayList<BaaRecordLCN>();
	
						recordRemLcn.setDteJour(dteJour);
						recordRemLcn.setTypeDoc("RE");
						recordRemLcn.setNumSeq("000000");
						
						String MNtDeclarer=recordRemLcn.getBmtr_MNTDECL();
						
						String MNtReel=recordRemLcn.getBmtr_MNTREEL().replace(",", "");
						
						String diffMnt=String.valueOf(Double.parseDouble(MNtReel)-Double.parseDouble(MNtDeclarer));
						
						if ( RegexUtils.matches(diffMnt, regxMNT))
						 {
						  String part1=StringUtils.replace(diffMnt, regxMNT, "$1");
						  String part2=StringUtils.replace(diffMnt, regxMNT, "$2");
						  part1=StringUtils.padRight(part1, 17, "0");
						  part2=StringUtils.padLeft(part2, 2, "0");
						  diffMnt=part1+","+part2;
						  recordRemLcn.setDiffMnt(diffMnt);
							
						}
						

						String bmtr_RefCli=recordRemLcn.getBmtr_REFCLI();
						
						if(bmtr_RefCli!=null){
							bmtr_RefCli=StringUtils.padRight(bmtr_RefCli, 12, " ");
						}
						else 
						{
							bmtr_RefCli=StringUtils.padRight("", 12, " ");
						}
						
						recordRemLcn.setBmtr_REFCLI(bmtr_RefCli);
						

						
						if(MNtDeclarer!=null)
						{
							MNtDeclarer=MNtDeclarer.replace(",", "");
						  if ( RegexUtils.matches(MNtDeclarer, regxMNT))
							 {
							  String part1=StringUtils.replace(MNtDeclarer, regxMNT, "$1");
							  String part2=StringUtils.replace(MNtDeclarer, regxMNT, "$2");
							  part1=StringUtils.padRight(part1, 17, "0");
							  MNtDeclarer=part1+","+part2;
							  recordRemLcn.setBmtr_MNTDECL(MNtDeclarer);
								
							}
						}
						
						
						
//						logger.debug("@@@ REMISE ["+
//						        recordRemLcn.getDteJour()+
//								recordRemLcn.getNumSeq()+
//								recordRemLcn.getTypeDoc()+
//								"0"+"0"+
//								recordRemLcn.getBmtr_REFCLI()+
//								recordRemLcn.getBmtr_NSER()+
//								recordRemLcn.getBmtr_MODE_ESC()+
//								recordRemLcn.getBmtr_AGE_RMT()+"000"+recordRemLcn.getBmtr_CDECLT()
//								+recordRemLcn.getBmtr_MNTDECL()
//								+StringUtils.padRight("", 98, " ")
//								+"]");
//						 
				
						
	/**** Formater l'enregistrement LCN */			
					 	List<BaaRecordLCN> lcns=dao.getLCNTraitedBaa(dteTr,recordRemLcn.getBmtr_pk_obj_idt(),Propriete.getInsatance().get(bq+".REQ.GETVALUETRAITED.LCN"));
					 	 for(BaaRecordLCN recordLcn:lcns){
					 		
					 		
					 		if(recordLcn.getBmtr_nser().equalsIgnoreCase(recordRemLcn.getBmtr_NSER()))
					 		{
								  
								recordLcn.setDteJour(dteJour);
								recordLcn.setNumSeq("000000");
								recordLcn.setTypeDoc("LC");
							
								String ribTire=recordLcn.getBmlcn_ZBK()+recordLcn.getBmlcn_LOC()+recordLcn.getBmlcn_CPT()+recordLcn.getBmlcn_RIB();
							
								recordLcn.setRibTire(ribTire);
								
								if(recordLcn.getBmlcn_cde_NOM_TIREUR()!=null)
								{
								recordLcn.setBmlcn_cde_NOM_TIREUR(StringUtils.padLeft(recordLcn.getBmlcn_cde_NOM_TIREUR(), 35, " "));
								}
								else
								{
									recordLcn.setBmlcn_cde_NOM_TIREUR(StringUtils.padLeft(" ", 35, " "));
								}
								
							String Bmlcn_MNT=recordLcn.getBmlcn_MNT();
								
							if(Bmlcn_MNT!=null)
							{
								Bmlcn_MNT=Bmlcn_MNT.replace(",", "");
							  if ( RegexUtils.matches(Bmlcn_MNT, regxMNT))
								 {
								  String part1=StringUtils.replace(Bmlcn_MNT, regxMNT, "$1");
								  String part2=StringUtils.replace(Bmlcn_MNT, regxMNT, "$2");
								  part1=StringUtils.padRight(part1, 17, "0");
								  part2=StringUtils.padLeft(part2, 2, "0");
								  Bmlcn_MNT=part1+","+part2;
								  recordLcn.setBmlcn_MNT(Bmlcn_MNT);
									
								}
							}
								
	
						
							
							recordLcn.setBmlcn_DTEEC(StringUtils.replace(recordLcn.getBmlcn_DTECRE(), regxDteIns, "$3$2$1"));
								
							
								
								if(recordLcn.getBmlcn_DTEEC().equals("0")){
									recordLcn.setBmlcn_DTEEC("00000000");
								}
								if(!RegexUtils.matches(recordLcn.getBmlcn_DTEEC(), "^([0-9]{2})([0-9]{2})([0-9]{4})")){
									logger.debug("+++ la date Echeance :"+recordLcn.getBmlcn_DTEEC() +" ne respect pas le pattern ^([0-9]{2})([0-9]{2})([0-9]{4})");
								}
								Date dateCre=DateUtils.formatStringToDate(recordLcn.getBmlcn_DTECRE(), "yyyy-MM-dd");
								recordLcn.setBmlcn_DTECRE(DateUtils.formatDateToStirng(dateCre, "ddMMyyyy"));
								
								
													
//								Statuts 
								
								          
								          
								//autres banques conformes
								if((recordLcn.getBmlcn_conf().equals("1")) && (((recordLcn.getBmlcn_sign()==null)||(recordLcn.getBmlcn_sign().equals("1")))))
								{
									//inter-agences conforme
									
									if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
									{
										recordLcn.setBmlcn_CODE_STATUS("3");
										recordLcn.setBmlcn_vice("   ");
									}
									
									else 
									{
										recordLcn.setBmlcn_CODE_STATUS("2");
										recordLcn.setBmlcn_vice("   ");
									}
								}
								else 
									if ((recordLcn.getBmlcn_conf().equals("1")) &&(recordLcn.getBmlcn_sign().equals("2")))
									{
										if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
										{
											recordLcn.setBmlcn_CODE_STATUS("4");
											recordLcn.setBmlcn_vice("SIGN");
										}
										else {
											recordLcn.setBmlcn_vice("   ");
										}
									}
									else 
										if ((recordLcn.getBmlcn_conf().equals("1")) &&(recordLcn.getBmlcn_sign().equals("3")))
										{
											if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
											{
												recordLcn.setBmlcn_CODE_STATUS("4");
												recordLcn.setBmlcn_vice("LSNE");
											}
											else {
												recordLcn.setBmlcn_vice("   ");
											}

										}
								
										else 
											if (recordLcn.getBmlcn_conf().equals("0"))
											{
												if(recordLcn.getBmlcn_ZBK().equals(cdeBq))
												{
													recordLcn.setBmlcn_CODE_STATUS("5");
													String mnemoniqueConfor = NcrmUtils.getMnemonicAnoFast(recordLcn.getBmlcn_vice());
													 if(mnemoniqueConfor.length()>0)
													 {
													mnemoniqueConfor=mnemoniqueConfor.substring(0, mnemoniqueConfor.length());
													recordLcn.setBmlcn_vice(mnemoniqueConfor);
													}
													 else 
													 {
														 mnemoniqueConfor="   ";
														 recordLcn.setBmlcn_vice(mnemoniqueConfor);
													 }
												}
												else 
												{
													recordLcn.setBmlcn_CODE_STATUS("1");
													System.out
															.println("recordLcn.getBmlcn_vice()"+recordLcn.getBmlcn_vice());
													String mnemoniqueConfor = NcrmUtils.getMnemonicAnoFast(recordLcn.getBmlcn_vice());
													 if(mnemoniqueConfor.length()>0)
													 {
													mnemoniqueConfor=mnemoniqueConfor.substring(0, mnemoniqueConfor.length());
													recordLcn.setBmlcn_vice(mnemoniqueConfor);
													}
													 else 
													 {
														 mnemoniqueConfor="   ";
														 recordLcn.setBmlcn_vice(mnemoniqueConfor);
													 }
												}
											}
								

//								logger.debug("@@@ LCN ["+
//								dteJour+recordLcn.getNumSeq()+recordLcn.getTypeDoc()+
//								"0"+"0"+
//								"            "+
//								recordLcn.getBmlcn_NSER()+
//								" "+
//								recordLcn.getBmlcn_RIB()+
//								recordLcn.getBmlcn_MNT()+
//								recordLcn.getBmlcn_cde_NOM_TIREUR()+
//								"060"+
//								recordLcn.getBmlcn_DTECRE()+
//								recordLcn.getBmlcn_DTEEC()+
//								recordLcn.getBmlcn_cdeAval()+
//								recordLcn.getBmlcn_CODE_STATUS()+
//								
//								
//								   "]");
								
//								[03|0000076|101041000056110000238897|rue de reims n 12 ifriquia|rue de reims n 12 ifriquia|0000000002000000|0|0|                                   |                                   |                                   |20150404|20150404|1|000|#>F:\images\L_BPM\91900460_00001_20160614001C0002.134;70510;31207;jpg;|#>F:\images\L_BPM\91900460_00001_20160614001C0002.134;101717;8584;jpg;]
								 
								listrecordsLcn.add(recordLcn);	
							}
								
							}
					 		recordRemLcn.getRecordsLcn().clear();
					 		recordRemLcn.getRecordsLcn().addAll(listrecordsLcn);
						}
						
						silcnRecord.getRecordRemiseLcn().clear();
						silcnRecord.getRecordRemiseLcn().addAll(listrecordRemLcn);
					
						   
					   }
		   

			} 
			catch (Exception e) {
			logger.debug("+++ METIER :Exception method formatChampsSILCN"+e.getMessage(),e);
		}
			return silcnRecord;
	}

	@Override
	public boolean createSiLCNBaa(String bq, String dteTr,BaaSilcnRecord silcnRecord) {
		String OUTDIR_SI_LCN=Propriete.getInsatance().get(bq+".OUTDIR.SI.LCN");
		boolean flag=true;
		String dteJour=DateUtils.formatDateToStirng(new Date(), "ddMMyyyy");
		int count=0;
		
		FileWriter fw=null;
		BufferedWriter bw=null;
		try {
		
		String nameFileSiLcn=OUTDIR_SI_LCN+"\\ALLERLCN001"+DateUtils.formatDateToStirng(DateUtils.formatStringToDate(dteTr, "yyyy-MM-dd"), "yyyyMMdd");
		
		logger.debug("Nom du fichier  LCN :"+nameFileSiLcn,null);
	
		fw=fw = new FileWriter(nameFileSiLcn);
		bw=new BufferedWriter(fw);
		
		
		logger.debug("=== Metier : 1- Valider les lignes ");
if(silcnRecord.getRecordRemiseLcn().size()>0)
{ 
// ************** RE
			for(int i=0;i<silcnRecord.getRecordRemiseLcn().size();i++)
			{
				count+=1;
				BaaRecordRemLCN rem=silcnRecord.getRecordRemiseLcn().get(i);
				String RecordRem=rem.getDteJour()+
						         StringUtils.padRight(""+count, 6, "0")+
								 rem.getTypeDoc()+"0"+"0"+
								 rem.getBmtr_REFCLI()+
								 rem.getBmtr_NSER()+
								 rem.getBmtr_MODE_ESC()+
								 rem.getBmtr_AGE_RMT()+"000"+rem.getBmtr_CDECLT()
								 +rem.getBmtr_MNTDECL()
								 +StringUtils.padRight("", 98, " ");
				
				
				if(RegexUtils.matches(RecordRem, Propriete.getInsatance().get(bq+".PATTERN.RECORDREM.SILCN")))
				{
					bw.write(RecordRem);
					bw.newLine();
					logger.debug("@@@ Record Remise  ["+RecordRem+"]");
					
 // ************** LC 				
					for(int j=0;j<rem.getRecordsLcn().size();j++)
					{
						count+=1;
						BaaRecordLCN lcn=rem.getRecordsLcn().get(j);
						String recordlcn=lcn.getDteJour()+
						         StringUtils.padRight(""+count, 6, "0")+
								 lcn.getTypeDoc()+"0"+"0"+
								 StringUtils.padRight("", 12, " ")+
								 lcn.getBmlcn_NSER()+
								  StringUtils.padRight("", 1, " ")+
								 lcn.getRibTire()+
								 lcn.getBmlcn_MNT()+
								 lcn.getBmlcn_cde_NOM_TIREUR()+
								 "060"+
								 lcn.getBmlcn_DTECRE()+
								 lcn.getBmlcn_DTEEC()+
								 lcn.getBmlcn_cdeAval()+
								 lcn.getBmlcn_CODE_STATUS()+
								 StringUtils.padRight(lcn.getBmlcn_vice(), 4, " ")+
								 StringUtils.padRight("", 4, " ")+
								 StringUtils.padRight("", 4, " ")+
								 StringUtils.padRight("", 30, " ");
							
						
						
						if(RegexUtils.matches(recordlcn, Propriete.getInsatance().get(bq+".PATTERN.RECORDLCN.SILCN")))
						{
							bw.write(recordlcn);
							bw.newLine();
							logger.debug("@@@ Record LCN  ["+recordlcn+"]");
						}
						else
						{
							logger.debug("+++ :  recordlcn   "+recordlcn+" ne resperct pas le pattern "+Propriete.getInsatance().get(bq+".PATTERN.RECORDLCN.SILCN"),null);
							i=silcnRecord.getRecordRemiseLcn().size();
							j=rem.getRecordsLcn().size();
							 bw.close();
							 new File(nameFileSiLcn).deleteOnExit();;
							flag=false;
					    }
		            }
					
// ************** DF
		        }
				else 
				{
					logger.debug("+++ :  RecordRem   "+RecordRem+" ne resperct pas le pattern "+Propriete.getInsatance().get(bq+".PATTERN.RECORDREM.SILCN"),null);
					i=silcnRecord.getRecordRemiseLcn().size();
					 bw.close();
					 new File(nameFileSiLcn).deleteOnExit();
					flag=false;
				}
				count+=1;
				String recordDf=
						  rem.getDteJour()+
				          StringUtils.padRight(""+count, 6, "0")+
						 "DF"+
						 StringUtils.padRight("", 46, " ")+
						 rem.getDiffMnt()+
						 StringUtils.padRight("", 98, " ");
				bw.write(recordDf);
				bw.newLine();
		}	
}
			if(flag)
			{count+=1;
				String recordTO=
						dteJour+
				          StringUtils.padRight(""+count, 6, "0")+
						 "TO"+
						 StringUtils.padRight("", 164, " ");
				bw.write(recordTO);
				bw.newLine();
				bw.close();
			
				flag=true;
			
			}
		
		} catch (IOException e) {
			logger.debug("+++ : IOException sur la methode CreationSILCN "+e.getMessage(),e);
			flag=false;
		}
		catch (Exception e) {
			logger.debug("+++ : Exception sur la methode CreationSILCN "+e.getMessage(),e);
			flag=false;
		}
		return flag;
		
	}
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* BMCE */	   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public List<Object[]> gettr_prfBMCE() {
		return dao.gettr_prfBMCE();
	}

	@Override
	public int Addta_prf_optBMCE(String pk) {
		return dao.Addta_prf_optBMCE(pk);
	}
	
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* SGMA */	   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//	##### IMPYEE CHQ 
	
	@Override
	public List<BeanImpChqSG> readFromCroCHQSg(String bq) {
		return dao.readFromCroCHQSg(bq);
	}

	@Override
	public List<BeanImpChqSG> readFromProdCHQSg(List<BeanImpChqSG> impyschq,String bq) {
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.CHQ");
		return dao.readFromProdCHQSg(impyschq, req);
	}

	public List<BeanImpChqSG> readFromIFPConfCHQSg(String bq,List<BeanImpChqSG> impychq){
		return dao.readFromIFPConfCHQSg(bq, impychq);
	}
	public List<BeanImpChqSG> readFromProdIACHQSg(List<BeanImpChqSG> listimpayIAChq, String dteTr1,String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.IA.CHQ");
		return dao.readFromProdIACHQSg(listimpayIAChq, dteTr1, req);
		
	}
	
	
	public  List<BeanImpChqSG> readFromIFPIACHQSg(String bq) {
		// TODO Auto-generated method stub
		return dao.readFromIFPIACHQSg(bq);
	}
	
	public  List<BeanImpChqSG> loadImpysCHQSg(List<BeanImpChqSG> impys,String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.ADDIMP.CHQ");
		return dao.loadImpysCHQSg(impys, req);
	}

	@Override
	public List<BeanImpChqSG> getAllimpayeCHQ(String bq, String dteTrt) {
		String req=Propriete.getInsatance().get(bq+".REQ.DATA.IMP.CHQ");
		return dao.getAllimpayeCHQ(req, dteTrt);
	}
	
	@Override
	public List<BeanImpChqSG> getAllImpayeChqSg(String bq, String dteTrt){
		String req=Propriete.getInsatance().get(bq+".REQ.DATA.IMP.CHQ");
		return dao.getAllImpayeChqSg(req, dteTrt);
		
		
	}
	
	@Override
	public List<BeanImpLcnSG> getAllImpayeLcnSg(String bq, String dteTrt){
		String req=Propriete.getInsatance().get(bq+".REQ.DATA.IMP.LCN");
		return dao.getAllImpayeLcnSg(req, dteTrt);
		
		
	}
	
	
	@Override
	public void createRCImpy(List<BeanImpChqSG> listImpay,String dteTrt,String nameFile) {
		
		FileWriter fw=null;
		BufferedWriter bw=null;
		System.out.println("nameFile "+nameFile);
	try {
		if(listImpay.size()>0)
			{
			fw = new FileWriter(nameFile);
			bw=new BufferedWriter(fw);
			String header="022131"+dteTrt;
			bw.write(header);	
			bw.newLine();
			
			for(BeanImpChqSG imp:listImpay)
				{
					String IdWcaprture=imp.getID_WEBCAPTUR();
					if(IdWcaprture!=null)
					{
						IdWcaprture=StringUtils.padRight(imp.getID_WEBCAPTUR(), 10, "0");
					}
					else
					{
					 IdWcaprture=StringUtils.padRight("0", 10, "0");
					}
				    String Nser=imp.getBmch_nser();
				    String RibTire=StringUtils.padLeft(imp.getBmch_ZBK()+imp.getBmch_LOC()+imp.getBmch_CPT()+imp.getBmch_rib(), 24, "0");
				    String Mnt=StringUtils.replace(imp.getBmch_MNT(), "([0-9]*)\\.([0-9]{1,2})","$1$2");
				           Mnt=StringUtils.padRight(Mnt, 16, "0");
				    String RioIni=imp.getRIOINI();
				    String cdeRejet=imp.getRejet();
				    String  LblRejet=imp.getREJET_LIB();
				    if(LblRejet!=null)
				    	{
					LblRejet=StringUtils.padLeft(imp.getREJET_LIB(), 100, " ");
				    	}
				    else 
				    {
					LblRejet=StringUtils.padLeft("", 100, " ");
				    }
				String  dteTr=StringUtils.replace(imp.getDTE_TRT(), "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
//			
			String copr=IdWcaprture+"|"+Nser+"|"+RibTire+"|"+Mnt+"|"+RioIni+"|"+cdeRejet+"|"+LblRejet
					;
			bw.write(copr);
			bw.newLine();
			

		 	
		 
			

			}
			}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
		
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
	
	
	
//	##### IMPYEE LCN 
	
	public List<BeanImpLcnSG> readFromCroLCNSg(String bq){
		return dao.readFromCroLCNSg(bq);
	}
	
	public  List<BeanImpLcnSG> readFromProdLCNSg(List<BeanImpLcnSG> impyslcn,String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.GETIMP.PROD.LCN");
		System.out.println("###"+req);
		return dao.readFromProdLCNSg(impyslcn, req);
	}
	
	public  List<BeanImpLcnSG> readFromIFPConfLCNSg(List<BeanImpLcnSG> impylcn,String bq){
		return dao.readFromIFPConfLCNSg(impylcn, bq);
		
	}
	
	public List<BeanImpLcnSG> loadImpysLCNSg(List<BeanImpLcnSG> impys, String bq) {
		// TODO Auto-generated method stub
		String req=Propriete.getInsatance().get(bq+".REQ.ADDIMP.LCN");
		return dao.loadImpysLCNSg(impys, req);
	}
	
	public  List<BeanImpLcnSG> readFromIFPIALCNSg(String bq){
		// TODO Auto-generated method stub
		return dao.readFromIFPIALCNSg(bq);
	}
	@Override
	public List<BeanImpLcnSG> getAllimpayeLCN(String bq, String dteTrt) {
		String req=Propriete.getInsatance().get(bq+".REQ.DATA.IMP.LCN");
		return dao.getAllimpayeLcn(req, dteTrt);
	}
	
	public List<BeanPcapt> getAllPcapt(String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.ALL.PCAPT");
		return dao.getAllPcapt(req);
		
	}
	
	public List<BeanPcapt> getDistinctCircuitSGMA(String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.ALL.CIRCUIT");
		return dao.getDistinctCircuit(req);
		
	}
	
	public List<BeanPcapt> getGetPcaptByCde(String bq,List<String> cde){
	String req=Propriete.getInsatance().get(bq+".REQ.PCAPT.CDE");
	return dao.getGetPcaptByCde(req,cde);
	
}
	public int AddPcapt(BeanPcapt p, String bq){
		String req=Propriete.getInsatance().get(bq+".REQ.ADD.NEW.PCAPT");
		return dao.AddPcapt(p, req);
	}
	
	
	@Override
	public int updatePcapt(int idpcapt, BeanPcapt pcapt,String bq) {
		String req=Propriete.getInsatance().get(bq+".REQ.UPDATE.PCAPT");
		return dao.UpdatePcapt(idpcapt,pcapt, req);
	}
	
	
	@Override
	public int deletePcapt(int idpcapt,String bq) {
		String req=Propriete.getInsatance().get(bq+".REQ.DELETE.PCAPT");
		System.out.println("reqreqreqreq"+req+idpcapt);
		return dao.DeletePcapt(idpcapt,req);
	}
	
	
	
	
	@Override
	public void createRCImpyLcn(List<BeanImpLcnSG> listImpay,String dteTrt,String nameFile) {
		
		FileWriter fw=null;
		BufferedWriter bw=null;
		System.out.println("nameFile "+nameFile);
	try {
		if(listImpay.size()>0)
			{
			fw = new FileWriter(nameFile);
			bw=new BufferedWriter(fw);
			String header="022160"+dteTrt;
			bw.write(header);	
			bw.newLine();
			
			for(BeanImpLcnSG imp:listImpay)
				{
//					String IdWcaprture=imp.getID_WEBCAPTUR();
//					if(IdWcaprture!=null)
//					{
//						IdWcaprture=StringUtils.padRight(imp.getID_WEBCAPTUR(), 10, "0");
//					}
//					else
//					{
//					 IdWcaprture=StringUtils.padRight("0", 10, "0");
//					}
//				    String Nser=imp.getBmlcn_nser();
//				    String RibTire=StringUtils.padLeft(imp.getBmlcn_ZBK()+imp.getBmlcn_LOC()+imp.getBmlcn_CPT()+imp.getBmlcn_rib(), 24, "0");
//				    String Mnt=StringUtils.replace(imp.getBmlcn_MNT(), "([0-9]*)\\.([0-9]{1,2})","$1$2");
//				           Mnt=StringUtils.padRight(Mnt, 16, "0");
//				    String RioIni=imp.getRIOINI();
//				    String cdeRejet=imp.getRejet();
//				    String  LblRejet=imp.getREJET_LIB();
//				    if(LblRejet!=null)
//				    	{
//					LblRejet=StringUtils.padLeft(imp.getREJET_LIB(), 100, " ");
//				    	}
//				    else 
//				    {
//					LblRejet=StringUtils.padLeft("", 100, " ");
//				    }
//				String  dteTr=StringUtils.replace(imp.getDTEINS(), "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
////			
//			String copr=IdWcaprture+"|"+Nser+"|"+RibTire+"|"+Mnt+"|"+RioIni+"|"+cdeRejet+"|"+LblRejet
//					
				String IdWcaprture=imp.getID_WEBCAPTUR();
				
				if(IdWcaprture!=null){
			       IdWcaprture=StringUtils.padRight(imp.getID_WEBCAPTUR(), 10, "0");
				}else{
					 IdWcaprture=StringUtils.padRight("0", 10, "0");
				}
		
				System.out.println(IdWcaprture);
				String Nser=imp.getBmlcn_nser();
				System.out.println(imp.getBmlcn_ZBK()+imp.getBmlcn_LOC()+imp.getBmlcn_CPT()+imp.getBmlcn_rib());
				String RibTire=StringUtils.padLeft(imp.getBmlcn_ZBK()+imp.getBmlcn_LOC()+imp.getBmlcn_CPT()+imp.getBmlcn_rib(), 24, "0");
				String Mnt=StringUtils.replace(imp.getBmlcn_MNT(), "([0-9]*)\\.([0-9]{2})","$1$2");
				Mnt=StringUtils.padRight(Mnt, 16, "0");
				String RioIni=imp.getRIOINI();
				String cdeRejet=imp.getRejet();
				String  LblRejet=imp.getREJET_LIB();
				if(LblRejet!=null){
			        LblRejet=StringUtils.padLeft(imp.getREJET_LIB(), 100, " ");
				}else {
					LblRejet=StringUtils.padLeft("", 100, " ");
				}
				
				String  dteTr=StringUtils.replace(imp.getDTEINS(), "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
				String dteSort=StringUtils.replace(imp.getDTE_SORT(), "([0-9]{2})-([0-9]{2})-([0-9]{4})","$3$2$1");
//				
			String copr=IdWcaprture+"|"+Nser+"|"+RibTire+"|"+Mnt+"|"+RioIni+"|"+dteTr+"|"+dteSort+"|"+cdeRejet+"|"+LblRejet
					;
			bw.write(copr);
			bw.newLine();
			

		 	
		 
			

			}
			}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
		
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
	@Override
	public List<BeanTrt> getAlltrt(String bq,String trt) {
		String req="";
		if(trt.equals("031")){
		  req=Propriete.getInsatance().get(bq+".REQ.TRT.CHQ");
		}
		else if (trt.equals("060")){
		  req=Propriete.getInsatance().get(bq+".REQ.TRT.LCN");	
		}
		else if (trt.equals("IMP_031")){
			req=Propriete.getInsatance().get(bq+".REQ.TRT.IMP.CHQ");
		}
		else {
			req=Propriete.getInsatance().get(bq+".REQ.TRT.IMP.LCN");
		}
		return dao.getAlltrt(req);
	}
	
	@Override
	public List<BeanTrt> getGetTrtByCde(String bq,List<String> cde){
		String req="";
		
		req=Propriete.getInsatance().get(bq+".REQ.TRT.CDE");
		
		return dao.getGetTrtByCde(req,cde);
		
	}

	@Override
	public List<BeanReport> getReportByTrt(String bq, int idT) {
		String req=Propriete.getInsatance().get(bq+".REQ.REPORT.IDTRT");
		return dao.getReportByTrt(req,idT);
	}
	
	
	
	
	
	@Override
	public  void ReportPdf(String templateJrxml, Map<String, Object> params,Connection dataSource, String outputEnreg, String NameFile) {			
		try {
			dataSource =dao.getConnectionLocal();
//			InputStream inputStream = getClass().getResourceAsStream(templateJrxml);
//			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);		
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			logger.debug("=== : [Template "+templateJrxml+"]");
			logger.debug("@@@ : [Out File "+outputEnreg+ "\\" + NameFile+"]");
			
			JasperReport jasperReport= (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream(templateJrxml));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
			if (!new File(outputEnreg).exists()) {
				new File(outputEnreg).mkdirs();
			}
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, outputEnreg+ "/" + NameFile);
		
//			dataSource.close();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

}
	
	
	@Override
	public  String ReportPdf2(String templateJrxml, Map<String, Object> params,Connection dataSource, String outputEnreg, String NameFile) {			
		String pathfile="";
		try {
			dataSource =dao.getConnectionLocal();
//			InputStream inputStream = getClass().getResourceAsStream(templateJrxml);
//			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);		
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			logger.debug("=== : [Template "+templateJrxml+"]");
			logger.debug("@@@ : [Out File "+outputEnreg+ "/" + NameFile+"]");
			pathfile=outputEnreg+ "/" + NameFile;
			JasperReport jasperReport= (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream(templateJrxml));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
			if (!new File(outputEnreg).exists()) {
				new File(outputEnreg).mkdirs();
			}
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, outputEnreg+ "/" + NameFile);
//			JasperViewer.viewReport(jasperPrint, false);
//			JasperPrintManager.printReport(jasperPrint, true);
			
//			dataSource.close();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pathfile;
		
	

}

	@Override
	public Connection geconnectionlocal() {
		return dao.getConnectionLocal();
	}

	@Override
	public List<RecordRemise> getRecordRemRec(String bq, String trt,String dteIns) {
		String req="";
		if(trt.equalsIgnoreCase("031")){
		req=Propriete.getInsatance().get(bq+".REQ.DATA.REM.REC.CHQ");
		}
		else{
		 req=Propriete.getInsatance().get(bq+".REQ.DATA.REM.REC.LCN");
		}
		List<RecordRemise> listrecordrem=dao.getRecordRemRec(req,trt,dteIns);
		
		for(RecordRemise r:listrecordrem)
		{
			
			 r.getRecordsValue().addAll(getRecordValuesRec(bq,trt,r.getPkObjIdtRem(),dteIns));
		 }
		
		return listrecordrem;
	}

	@Override
	public List<RecordValue> getRecordValuesRec(String bq, String trt,String pkobjidtRem,String dteIns) {
		String req="";
		if(trt.equalsIgnoreCase("031")){
			req=Propriete.getInsatance().get(bq+".REQ.DATA.REC.CHQ");
		}else{
			req=Propriete.getInsatance().get(bq+".REQ.DATA.REC.LCN");
		}
		return dao.getRecordValuesRec(req,trt,pkobjidtRem,dteIns);
	}
	
	@Override
	public List<RecordRemise> formatageChamps(List<RecordRemise> listeRemises,String dteInstance){
		String patternMNT="(^[0-9]+)\\.([0-9]{1,2})",
		       patternCdePcapt="([0-9]{5})",
		       patternNser="([0-9]{7})",
		       patternCdeAge="([0-9]{3})",
		       patternRibRemettant="([0-9]{9})",
		       patternTypeRemise="(0|1)",
		       patternRibtire="([0-9]{24})",
		       patternSign="([0-3]{1})",
		       patternConf="([a-zA-Z]{0,4})",
		       patternDteech="([0-9]{2})([0-9]{2})([0-9]{4})";
		
		String IdWebCapture=null,
			   cdePcapt=null,
			   nser=null,
			   cdeAge=null,
			   RibRemettant=null,
			   mnt=null,
			   typeRemise=null,
			   cdeAnomalie=null,
			   filter=null,
			   opeEtaRem=null,
			   Ribtire=null,
			   sign=null,
			   conf=null,
			   rio=null,
			   opeEtaChq=null,
			   dteech=null;
			   ;
		
		for(RecordRemise r:listeRemises)
		{	
			
			r.setCodeEnreg("1");
			
			IdWebCapture=r.getIdWebCapture();
			if(IdWebCapture==null)
			{
				IdWebCapture="0";
			}
			IdWebCapture=StringUtils.padRight(IdWebCapture, 10, "0");
            r.setIdWebCapture(IdWebCapture);
            
            cdePcapt=r.getCdePcapt();
		      if(RegexUtils.matches(cdePcapt, patternCdePcapt))
			  {
		    	  logger.debug("@@@ cdePcapt [ "+cdePcapt+" ]",null);
		    	  r.setCdePcapt(cdePcapt);
			  }
		      else 
		      {
		    		  logger.debug("+++ cdePcapt :[ "+cdePcapt+" ] ne respect pas le pattern   "+patternCdePcapt,null); 
		      }
		      
			  nser=r.getNser();
			  if(nser==null)
			  {
				  nser="0000000"; 
			  }
			 
			  if(RegexUtils.matches(nser, patternNser))
			  {
						  logger.debug("@@@ nser Remise  [ "+nser+" ]",null);
		    	  r.setNser(nser);
			  }
		      else 
		      {
		    	  logger.debug("+++ nser : ["+nser+"] ne respect pas le pattern   "+patternNser,null); 
		      }
			  
			  cdeAge=r.getCdeAge();
			  if(cdeAge==null)
			  {
				 cdeAge="000"; 
			  }
			  if(RegexUtils.matches(cdeAge, patternCdeAge))
			  {
				  logger.debug("@@@ cdeAge Remise ["+cdeAge+" ]",null);
		    	  r.setCdeAge(cdeAge);
			  }
		      else 
		      {
		    	  logger.debug("+++ cdeAge Remise : ["+cdeAge+" ] ne respect pas le pattern   "+patternCdeAge,null); 
		      }
			  
			  
			  RibRemettant= r.getRibRemettant();
			  if(RibRemettant==null){
				  RibRemettant="000000000";
			  }
			  if(RegexUtils.matches(RibRemettant, patternRibRemettant))
			  {
				  logger.debug("@@@ RibRemettant [ "+RibRemettant+" ]",null);
		    	  r.setRibRemettant(RibRemettant);
			  }
		      else 
		      {
		    	 
		    	
		    	  logger.debug("+++ RibRemettant : ["+RibRemettant+" ] ne respect pas le pattern   "+patternRibRemettant,null); 
		      }
			  
			  mnt=r.getMnt();
			  if(mnt==null){
				  mnt="0.00";
			  }
			  if(RegexUtils.matches(mnt, patternMNT))
			  {
				  
				  String part1=StringUtils.replace(mnt, patternMNT, "$1");
				  String part2=StringUtils.replace(mnt, patternMNT, "$2");
				  if(part2.matches("([0-9]{1})")){
					  part2=part2+"0";
				  }
				  
				  
				  mnt=StringUtils.padRight(part1+part2, 16, "0");
				  
				  
				  
//				  mnt=StringUtils.padRight(StringUtils.replace(mnt, patternMNT, "$1$2"), 16, "0");
				  logger.debug("@@@ mntRemsie   [ "+mnt+" ]",null);
				  r.setMnt(mnt);
			  }
			  else  if(RegexUtils.matches(mnt, "(^[0-9]+)"))
			  {
				  mnt=StringUtils.padRight(StringUtils.replace(mnt, "(^[0-9]+)", "$1"+"00"), 16, "0");
				  logger.debug("@@@ mntRemsie  "+mnt+" ]",null);
				  r.setMnt(mnt);
			  }
			  else 
			  {
				  if(r.getOpeEta().equalsIgnoreCase("D"))
				  {
					  mnt=StringUtils.padRight("", 16, ""); 
					  r.setMnt(mnt);
				  }
				  else 
				  {
					  logger.debug("+++ mntRemsie  : ["+mnt+"] ne respect pas ni pattern  (^[0-9]+) ni  "+patternMNT +" est c'est pas une anomalie ",null);  
				  }
			  }
			  
	        typeRemise=r.getTypeRemise();
	        if(typeRemise==null){
	        	typeRemise="0";
	        }
	        if(RegexUtils.matches(typeRemise, patternTypeRemise))
	        {
	        	logger.debug("@@@ typeRemise   [ "+typeRemise+" ]",null);
	        	 r.setTypeRemise(typeRemise);
	        }
	        else
	        {
	        	logger.debug("+++ typeRemise  : ["+typeRemise+"] ne respect pas le pattern   "+patternTypeRemise,null); 	
	        }
	 
	        cdeAnomalie=StringUtils.padLeft(r.getCdeAnomalie(), 12, " ");
	             logger.debug("@@@ cdeAnomalie Remise  [ "+cdeAnomalie+" ]",null);
	        r.setCdeAnomalie(cdeAnomalie);
	        filter="";
	        r.setFiller(filter);
	        opeEtaRem=r.getOpeEta();	
	        if(opeEtaRem.equalsIgnoreCase("D"))
	        {
	        	opeEtaRem="O";
	        	logger.debug("@@@ opeEtaRem   [ "+opeEtaRem+" ]",null);
	        	 r.setOpeEta(opeEtaRem);
	        }	
	        else
	        {
	        	opeEtaRem="N";
	        	logger.debug("@@@ opeEtaRem   ["+opeEtaRem+"]",null);
	        	r.setOpeEta(opeEtaRem);
	        }
	  
	  //(^1)([0-9]{10})([0-9]{5})([0-9]{7})([0-9]{3})([0-9]{9})([0-9]{16})(1|0)(O|N)(.{12})(.{48})
	        
	   logger.debug( "=== Formater les valeurs de la remise  "+r.getNser() +" & traiter le "+dteInstance, null);
			

			
			for(RecordValue c:r.getRecordsValue()){
				c.setCodeEnreg("2");
				IdWebCapture=c.getIdWebCapture();
				if(IdWebCapture==null){
					IdWebCapture="0";
				}
				 IdWebCapture=StringUtils.padRight(IdWebCapture, 10, "0");
				  c.setIdWebCapture(IdWebCapture); 
				  
				  cdePcapt=c.getCdePcapt();
				  if(RegexUtils.matches(cdePcapt, patternCdePcapt))
				  {
			    	  logger.debug("@@@ cdePcapt   ["+cdePcapt+"]",null);
			    	  c.setCdePcapt(cdePcapt);
				  }
			      else 
			      {
			    	  logger.debug("+++ cdePcapt  [:"+cdePcapt+" ]ne respect pas le pattern   "+patternCdePcapt,null); 
			      }
				  nser=c.getNser();
				  if(nser==null){
					  nser="0000000";
				  }
				  if(RegexUtils.matches(nser, patternNser))
				  {
			    	  logger.debug("@@@ nser Value   [ "+nser+" ]",null);
			    	  c.setNser(nser);
				  }
			      else 
			      {
			    	  logger.debug("+++ nser Value : ["+nser+"] ne respect pas le pattern   "+patternNser,null); 
			    	  c.setNser("0000000");
			      }
				  Ribtire= c.getRibTire();
				  if(Ribtire==null){
					  Ribtire="000000000000000000000000";
				  }
				  
				  if(RegexUtils.matches(Ribtire, patternRibtire))
				  {
			    	  logger.debug("@@@ Ribtire   ["+Ribtire+"]",null);
			    	  c.setRibTire(Ribtire);
				  }
			      else 
			      {
			    	  logger.debug("+++ Ribtire : ["+Ribtire+"] ne respect pas le pattern   "+patternRibtire,null); 
			    	  c.setRibTire("000000000000000000000000");
			      }
				  
				  mnt=c.getMnt();
				 if(mnt==null){
					 mnt="0.00";
				 }
				 
				  if(RegexUtils.matches(mnt, patternMNT))
				  {
					  String part1=StringUtils.replace(mnt, patternMNT, "$1");
					  String part2=StringUtils.replace(mnt, patternMNT, "$2");
					  if(part2.matches("([0-9]{1})")){
						  part2=part2+"0";
					  }
					  
					  
					  mnt=StringUtils.padRight(part1+part2, 16, "0");
					  logger.debug("@@@ mntvalue  ["+mnt+"]",null);
					  c.setMnt(mnt);				  }
				  else  if(RegexUtils.matches(mnt, "(^[0-9]+)"))
				  {
					  mnt=StringUtils.padRight(StringUtils.replace(mnt, "(^[0-9]+)", "$1"+"00"), 16, "0");
					  logger.debug("@@@ mnt value  ["+mnt+"]",null);
					  c.setMnt(mnt);	
				  }
				  else 
				  {
					  if((c.getOpeEta().equalsIgnoreCase("D"))&& (mnt==null || mnt.isEmpty()))
					  {
						  mnt=StringUtils.padRight("0", 16, "0"); 
						  c.setMnt(mnt);	
					  }
					  else 
					  {
					  logger.debug("+++ mntRemsie  : ["+mnt+"] ne respect pas ni pattern  (^[0-9]+) ni  "+patternMNT +" est c'est pas une anomalie ",null);  
					  }   
				  }
				 
				  sign=c.getSignature();
				  
				  if(sign==null||sign.length()==0){
					  sign="0"; 
				  }
				  if(RegexUtils.matches(sign, patternSign))
				  {
					  logger.debug("@@@ sign   ["+sign+"]",null);
					  c.setSignature(sign);	
				  }
				  else 
				  {
					  logger.debug("+++ sign  : ["+sign+"] ne respect pas ni pattern   "+patternSign,null);   
				  }
				  
				  conf=c.getConf();
				  if(conf==null || conf.length()==0)
				  {
				  conf=StringUtils.padLeft("", 4, " ");
				  c.setConf(conf);	
				  }
				  
				  else if(RegexUtils.matches(conf, patternConf))
				  {
					  logger.debug("@@@ conf   [ "+conf+" ]",null);
					  c.setConf(conf);
				  }
				  else 
				  {
					  logger.debug("+++ conf  : ["+conf+"] ne respect pas ni pattern   "+patternConf,null);  
				  }
				  
				  
				  
				  cdeAnomalie=c.getCdeAnomalie();
				
				  if(cdeAnomalie.trim().length()>0)
				  {
				   cdeAnomalie=StringUtils.padLeft(c.getCdeAnomalie(), 12, " ");
				  logger.debug("@@@ cdeAnomalie value  [ "+cdeAnomalie+" ]",null);
				  c.setCdeAnomalie(cdeAnomalie);
				 
				  }
				  else
				  {
					  cdeAnomalie=StringUtils.padLeft(r.getCdeAnomalie(), 12, " ");
					  logger.debug("@@@ cdeAnomalie value  [ "+cdeAnomalie+" ]",null);
					  c.setCdeAnomalie(cdeAnomalie); 
				  }
				  rio=c.getRio();
				  if(rio==null || rio.isEmpty()){
					  rio=StringUtils.padLeft(" ", 32, " ");
					  logger.debug("@@@ rio   [ "+rio+" ]",null);
					  c.setRio(rio);
				  }
				  else {
					  rio=StringUtils.padLeft(rio, 32, " "); 
					  logger.debug("@@@ rio   ["+rio+"]",null);
					  c.setRio(rio);
				  }
				  opeEtaChq=c.getOpeEta();	
				  if(opeEtaChq.equalsIgnoreCase("D"))
				  {
					  opeEtaChq="O";
					  logger.debug("@@@ opeEtaChq  [ "+opeEtaChq+" ]",null);
					  c.setOpeEta(opeEtaChq);
//					  
					  logger.debug("TOTO  "+"idWebCapture "+c.getIdWebCapture()+"-- "+c.getNser()+c.getRibTire()+c.getDteEchee()+c.getMnt()+"___"+" ([0-9]{7})([0-9]{24})([0-9]{1,8})([0-9]*)");
//					  if(RegexUtils.matches(c.getNser()+c.getRibTire()+c.getDteEchee()+c.getMnt()," ([0-9]{7})([0-9]{24})([0-9]{1,8})([0-9]*)")==false){
//						  logger.debug("SOS");
//						  c.setNser("0000000");
//						  c.setRibTire("000000000000000000000000");
//						  c.setMnt("0000000000000000");
//						  c.setDteEchee("00000000");
//					  }
					  
					  
				  }else{
					  opeEtaChq="N";
					  logger.debug("@@@ opeEtaChq  [ "+opeEtaChq+" ]",null);
					  c.setOpeEta(opeEtaChq);
				  }
				  
				  
				  dteech=c.getDteEchee();
				 
				  if(dteech!=null && dteech.equals("0")){
					  c.setDteEchee("00000000");
					  logger.debug("@@@ nser dteech   [ "+"00000000"+" ]",null);
				  }
				  if(dteech!=null && RegexUtils.matches(dteech, patternDteech))
				  {
					  dteech=StringUtils.replace(dteech, patternDteech, "$3$2$1");
					  c.setDteEchee(dteech);
					  logger.debug("@@@  dteech   [ "+dteech+" ]",null);
				  }
				  else 
					  if ((opeEtaChq.equalsIgnoreCase("D"))&& (dteech==null||dteech.isEmpty()))
					  {
					  c.setDteEchee("00000000");
					  logger.debug("@@@ dteech   [ "+"00000000"+" ]",null);
				      }
					  else if((dteech==null||dteech.isEmpty())){
						  c.setDteEchee("00000000");
						  logger.debug("@@@ nser dteech   [ "+"00000000"+" ]",null);
					  }
				  else 
				  {
					  logger.debug("+++ dteech  : ["+dteech+"] ne respect pas ni pattern   "+patternDteech,null);  
				  }
				
		// (^2)([0-9]{10})([0-9]{5})([0-9]{7})([0-9]{24})([0-9]{16})([0-3]{1})(.{4})(O|N)(.{12})(.{32})

				  
			}

		}
		return listeRemises;
		
	}

	@Override
	public List<RecordRemise> createFileRec(List<RecordRemise> listeRemises,String nameFile,String header,String cdeTr) {
	
		
		     FileWriter fw=null;
		     BufferedWriter bw=null;
		     String recordCheque=null;
		     int count=0;
		     String pattenHeder="";
		     String pattenbody="";
		     String filter="";
try {
	
			if(cdeTr.equalsIgnoreCase("031")){
				     pattenHeder="(^1)([0-9]{10})([0-9]{5})([0-9]{7})([0-9]{3})([0-9]{9})([0-9]{16})([0-3]{1})(O|N)(.{12})(.{48})$";
				     pattenbody="(^2)([0-9]{10})([0-9]{5})([0-9]{7})([0-9]{24})([0-9]{16})([0-3]{1})(.{4})(O|N)(.{12})(.{32})$";
				     filter=StringUtils.padLeft("", 48, " ");
			}
			else if (cdeTr.equalsIgnoreCase("060")){
				 pattenHeder="(^1)([0-9]{10})([0-9]{5})([0-9]{7})([0-9]{3})([0-9]{9})([0-9]{16})([0-3]{1})(O|N)(.{12})(.{24})$";
			     pattenbody="(^2)([0-9]{10})([0-9]{5})([0-9]{7})([0-9]{24})([0-9]{16})([0-9]{8})([0-3]{1})(.{4})(O|N)(.{12})$";
			     filter=StringUtils.padLeft("", 24, " ");
			}
			
			System.out.println(nameFile);
			fw = new FileWriter(new File(nameFile));
			
			bw =new BufferedWriter(fw);
			bw.write(header);
	for(RecordRemise r:listeRemises)
		{
		  bw.newLine();
          
		  r.setFiller(filter);
		  
		  String recordRemise="";
		  if(cdeTr.equalsIgnoreCase("031")){
			  recordRemise=
						r.getCodeEnreg()
						+r.getIdWebCapture() 
						+r.getCdePcapt()       
						+r.getNser()          
						+r.getCdeAge()        
						+r.getRibRemettant()  
						+r.getMnt()           
						+r.getTypeRemise()     
						+r.getOpeEta()    
						+r.getCdeAnomalie()     
						+r.getFiller()
						;
		  }else{
			  recordRemise=
						r.getCodeEnreg()
						+r.getIdWebCapture() 
						+r.getCdePcapt()       
						+r.getNser()          
						+r.getCdeAge()        
						+r.getRibRemettant()  
						+r.getMnt()           
						+r.getTypeRemise()     
						+r.getOpeEta()    
						+r.getCdeAnomalie()     
						+r.getFiller()
						;
		  }
		  System.out.println("recordRemise"+recordRemise);
		  
		  if(RegexUtils.matches(recordRemise, pattenHeder)){
				bw.write(recordRemise);
				 logger.debug("@@@ recordRemise  [ "+recordRemise+" ]",null);
		  }
		  else {
			  logger.debug("@@@ recordRemise  ne respect pas le pattern  [ "+pattenHeder+" ]",null);
			  count+=1;
		  }
				for(RecordValue c:r.getRecordsValue()){
					
					

			// 
					if(cdeTr.equalsIgnoreCase("031"))
					{ 
					recordCheque=
								 c.getCodeEnreg()  
								+c.getIdWebCapture()  
								+c.getCdePcapt()      
								+c.getNser()           												
								+c.getRibTire()  		   
								+c.getMnt()         
								+c.getSignature()            
								+c.getConf()              
								+c.getOpeEta()         
								+c.getCdeAnomalie()	  
								+c.getRio();
					
					System.out.println(recordCheque);
					}
					
					else if(cdeTr.equalsIgnoreCase("060"))
					{
						recordCheque=
								 c.getCodeEnreg()   
								+c.getIdWebCapture()   
								+c.getCdePcapt()       
								+c.getNser()           												
								+c.getRibTire()  		   
								+c.getMnt()
								+c.getDteEchee()
								+c.getSignature()              
								+c.getConf()              
								+c.getOpeEta()         
								+c.getCdeAnomalie();
					}
					 
					if(RegexUtils.matches(recordCheque, pattenbody)){
						bw.newLine();
						 logger.debug("@@@ recordCheque  [ "+recordCheque+" ]",null);
						  bw.write(recordCheque);
					}
					else {
						logger.debug("@@@ recordCheque [ "+recordCheque+" ] ne respect pas le pattern  [ "+pattenbody+" ]",null);
						count=count+1;
						System.out.println(recordCheque);
						System.out.println(pattenbody);
					}
					  
				}
				
				
			}
		bw.close();
		System.out.println("count "+count);
		if(count!=0){
			System.out.println("count "+count);
			
			new File(nameFile).delete();
			listeRemises.clear();
		}

			

			
			
			
			
			
			
		} catch (IOException e) {
			logger.debug("+++ IOException createFileRec  "+e.getMessage(),e);
		}
		
		
		return listeRemises;
	}

	@Override
	public int purgetableEta(String bq,String trt) {
		String req=null;
		if(trt.equals("031")){
		req=Propriete.getInsatance().get(bq+".DELETE.TABLE.ETA.CHQ");
		
		}
		else if(trt.equals("060")){
			req=Propriete.getInsatance().get(bq+".DELETE.TABLE.ETA.LCN");
		}
		else if(trt.equals("131")){
			req=Propriete.getInsatance().get(bq+".DELETE.TABLE.IMP.CHQ");
		}
		else if(trt.equals("160")){
			req=Propriete.getInsatance().get(bq+".DELETE.TABLE.IMP.LCN");
		}
		return dao.purgetableEta(req);
		
	}

	

	

	
}
