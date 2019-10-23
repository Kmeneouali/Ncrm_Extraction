package com.ncrm.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

















































import com.ncrm.SprBatch.sgma.impayeChqSg;
import com.ncrm.dao.entities.BaaRecordLCN;
import com.ncrm.dao.entities.BaaRecordRemLCN;
import com.ncrm.dao.entities.BeanAgence;
import com.ncrm.dao.entities.BeanCompte;
import com.ncrm.dao.entities.BeanCountImpy;
import com.ncrm.dao.entities.BeanCountpye;
import com.ncrm.dao.entities.BeanDetailSuiviPhysique;
import com.ncrm.dao.entities.BeanEtatsLcn;
import com.ncrm.dao.entities.BeanFile;
import com.ncrm.dao.entities.BeanImpChq;
import com.ncrm.dao.entities.BeanImpChqSG;
import com.ncrm.dao.entities.BeanImpLcn;
import com.ncrm.dao.entities.BeanImpLcnSG;
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanReport;
import com.ncrm.dao.entities.BeanSuiviPhysique;
import com.ncrm.dao.entities.BeanTrt;
import com.ncrm.dao.entities.RecordChq;
import com.ncrm.dao.entities.RecordLCN;
import com.ncrm.dao.entities.RecordLotChq;
import com.ncrm.dao.entities.RecordLotLcn;
import com.ncrm.dao.entities.RecordPaidValue;
import com.ncrm.dao.entities.RecordRemChq;
import com.ncrm.dao.entities.RecordRemLCN;
import com.ncrm.dao.entities.beanScann;
import com.ncrm.dao.entities.rec.RecordRemise;
import com.ncrm.dao.entities.rec.RecordValue;
import com.ncrm.library.utils.DateUtils;
import com.ncrm.library.utils.DirUtils;
import com.ncrm.library.utils.RegexUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.library.utils.ZipUtils;
import com.ncrm.library.utils.beans.Journal;
import com.ncrm.tools.Propriete;

//

public class daoImpl implements Idao,Serializable {
	
	
	
	private static final Logger logger = Logger.getLogger(daoImpl.class);

	 
	 
	 @PersistenceContext(unitName="Bpm_chq")
		EntityManager emBpmchq;
	 
	 @PersistenceContext(unitName="Bpm_lcn")
		EntityManager emBpmlcn;
	
	 @PersistenceContext(unitName="Cfg_chq")
		EntityManager emCfgchq;
	 
	 @PersistenceContext(unitName="Cfg_lcn")
		EntityManager emCfglcn;
	
	 @PersistenceContext(unitName="Baa_chq")
		EntityManager emBaachq;
	 
	 @PersistenceContext(unitName="Baa_lcn")
		EntityManager emBaalcn;
	 
	 @PersistenceContext(unitName="Sgma_chq")
		EntityManager emSgmachq;
	 
	 @PersistenceContext(unitName="Sgma_lcn")
		EntityManager emSgmalcn;
	 
	 @PersistenceContext(unitName="local")
		EntityManager emLocal;
	 
//		################################################################################
//	 				EXTRACTION SI LCN 
//	 	###################################################################################
		
	 
	 
	 
		public BigInteger getCountRemTraited(String dteTr,String Req) {
			logger.debug("@@@ DAO : getCountRemTraited  le "+dteTr);
			Query q = emBpmlcn.createNativeQuery(Req);
			q.setParameter("Date", dteTr);
			BigInteger  CountRemTraited =  (BigInteger) q.getSingleResult();
			return CountRemTraited;
		}	
		
		public List<Object[]> getCount2ndSumMntTraitedSI(String dteTr,String Req) {
			logger.debug("@@@ DAO : getCount2ndSumMntTraitedSI  le "+dteTr);
			Query q = emBpmlcn.createNativeQuery(Req);
			q.setParameter("Date", dteTr);
			List<Object[]>  Count2ndSumMntLcn = q.getResultList();
			return Count2ndSumMntLcn;
		}
	 
	 public List<RecordRemLCN> getRemLcnTraiter(String dteTr,String Req) {
			logger.debug("@@@ DAO : getRemLcnTraiter  le "+dteTr);
			Query q = emBpmlcn.createNativeQuery(Req,RecordRemLCN.class);
			q.setParameter("Date", dteTr);
			List<RecordRemLCN> RecordRemLCNs = q.getResultList();
			return RecordRemLCNs;
		}

		public List<RecordLCN> getLCNTraited(String dteTr, String pk_obj_id_Rem,String Req) {
			logger.debug("@@@ DAO : getLCNTraited DATA  LCNs remise : "+pk_obj_id_Rem +" & traitées le "+dteTr);
			Query q = emBpmlcn.createNativeQuery(Req,RecordLCN.class);
			q.setParameter("Date", dteTr);
			q.setParameter("pk_obj_id_Rem", pk_obj_id_Rem);
			List<RecordLCN> DATALCN = q.getResultList();
			return DATALCN;
		}

		
//		################################################################################
//			EXTRACTION SI CHQ 
//     ###################################################################################
		
		public List<RecordRemChq> getRemChqTraiter(String dteTr, String Req) {
			logger.debug("@@@ DAO : getRemChqTraiter  le "+dteTr);
			Query q = emBpmchq.createNativeQuery(Req,RecordRemChq.class);
//			q.setParameter("Date", dteTr);
			List<RecordRemChq> RecordRemChqs = q.getResultList();
			return RecordRemChqs;
		}

		public List<RecordChq> getChqTraited(String dteTr,String pk_obj_id_Rem, String Req) {
			logger.debug("@@@ DAO : getChqTraited DATA  CHQ remise : "+pk_obj_id_Rem +" & traitées le "+dteTr);
			Query q = emBpmchq.createNativeQuery(Req,RecordChq.class);
//			q.setParameter("Date", dteTr);
			q.setParameter("pk_obj_id_Rem", pk_obj_id_Rem);
			List<RecordChq> DATACHQ = q.getResultList();
			return DATACHQ;
		}
		
		@Transactional("jpaTransactionManagerBpm_chq")
		public int UpdateExt(String pk_obj_id_Rem,String Req) {
			logger.debug("@@@ DAO : Modifier le flag EXT table  remise : "+pk_obj_id_Rem );
			Query q = emBpmchq.createNativeQuery(Req);
//			q.setParameter("Date", dteTr);
    		q.setParameter("pk_obj_id_Rem", pk_obj_id_Rem);
	
			int flag=q.executeUpdate();
			

			return flag;
		}
			
		public List<RecordRemChq> getAllRemChqTraiterFlager(String Req) {
			logger.debug("@@@ DAO : getAllRemChqTraiterFlager  "+Req);
			Query q = emBpmchq.createNativeQuery(Req,RecordRemChq.class);
			List<RecordRemChq> RecordRemChqs = q.getResultList();
			return RecordRemChqs;
		}

		public List<RecordRemChq> getRemChqTraiterFlagerByDte(String dteTr,String Req) {
			logger.debug("@@@ DAO : getRemChqTraiterFlagerByDte "+dteTr);
			Query q = emBpmchq.createNativeQuery(Req,RecordRemChq.class);
			q.setParameter("Date", dteTr);
			List<RecordRemChq> RecordRemChqs = q.getResultList();
			return RecordRemChqs;
		}
		
	
//		################################################################################
//				EXTRACTION LOT CHQ 
//      ###################################################################################
		
		public List<RecordLotChq> getRecordLotchq(String dteTr, String cdeBq, String Req) {
			logger.debug("@@@ getRecordLotchq  parammetres :[DTEINS= "+dteTr+",zbk= "+cdeBq+"]");
			logger.debug("@@@ getRecordLotchq  Requete :["+Req+"]");
			Query q = emBpmchq.createNativeQuery(Req,RecordLotChq.class);
			q.setParameter("Date", dteTr);
			q.setParameter("zbk", cdeBq);
			List<RecordLotChq> RecordLotChqs = q.getResultList();
			return RecordLotChqs;
		}
			
		public List<Object[]> getCount2ndSumMntTraitedLOT(String dteTr,String cdeBq,String Req) {
			logger.debug("@@@ getCount2ndSumMntTraited  parammetres :[DTE= "+dteTr+",zbk= "+cdeBq+"]");
			logger.debug("@@@ getCount2ndSumMntTraited  Requete :["+Req+"]");

			Query q = emBpmlcn.createNativeQuery(Req);
			q.setParameter("Date", dteTr);
			q.setParameter("zbk", cdeBq);
			List<Object[]>  Count2ndSumMntLcn = q.getResultList();
			return Count2ndSumMntLcn;
		}

 
//		################################################################################
//				EXTRACTION LOT LCN 
		//###################################################################################
	 
	 
		public List<RecordLotLcn> getRecordLotLcn4calcul(String Req) {
			logger.debug("@@@ DAO : getRecordLotLcn4calcul  ");
			Query q = emBpmlcn.createNativeQuery(Req,RecordLotLcn.class);
			List<RecordLotLcn> RecordLotLcns = q.getResultList();
			return RecordLotLcns;
		}
		
			
		@Transactional("jpaTransactionManagerBpm_lcn")
		public int UpdateDtePr(String pkObjIdt,String dtePre,String Req) {
			logger.debug("@@@ Modifier la date de presentation [parammetre pk_obj_idt ="+pkObjIdt+", dtePResentation ="+dtePre+"]" );
			logger.debug("@@@ requete ="+Req+"]" );
			Query q = emBpmlcn.createNativeQuery(Req);
//			q.setParameter("Date", dteTr);
    		q.setParameter("pkObjIdt", pkObjIdt);
    		q.setParameter("dtePre", dtePre);
			int flag=q.executeUpdate();
			
			return flag;
		}

		public List<RecordLotLcn> getRecordLotLcn(String dtePre, String Req) {
			logger.debug("@@@ DAO : getRecordLotLcn  parammetre [dtePre="+dtePre+"]");
			logger.debug("@@@ DAO : getRecordLotLcn  requete [dtePre="+Req+"]");
			Query q = emBpmlcn.createNativeQuery(Req,RecordLotLcn.class);
			q.setParameter("dtePre", dtePre);
			List<RecordLotLcn> RecordLotLcns = q.getResultList();
			
			return RecordLotLcns;
		}
		
		

		@Transactional("jpaTransactionManagerBpm_lcn")
		public int UpdateFlagEXT(String pkObjIdt, String req) {
			logger.debug("@@@ DAO : UpdateFlagEXT parametre pkObjIdt : "+pkObjIdt );
			logger.debug("@@@ DAO : Requeste : "+req );
			Query q = emBpmlcn.createNativeQuery(req);
//			q.setParameter("Date", dteTr);
    		q.setParameter("pkObjIdt", pkObjIdt);
			int flag=q.executeUpdate();
			return flag;
		}
	 
	 
//		################################################################################
//		EXTRACTION ETA CHQ & LCN 
//###################################################################################
	 
		
		public BigInteger getCountValueTraited(String bq,String cdeTr,String dteTr) {
			String Req="";
			Query q=null;
			logger.debug("@@@ DAO : getCountValueTraited  le "+dteTr+"Traitement "+cdeTr);
			
			if(cdeTr.equalsIgnoreCase("031"))
			{
				Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.CHQ");
				 q = emBpmchq.createNativeQuery(Req);
			}
			
			if(cdeTr.equalsIgnoreCase("060"))
			{
				Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.LCN");
				 q = emBpmlcn.createNativeQuery(Req);
			}
			q.setParameter("Date", dteTr);
			BigInteger  CountRemTraited =  (BigInteger) q.getSingleResult();
			return CountRemTraited;
		}
			
		public boolean extractDataEtaChqLcntoCsv(String bq,String tr,String dteTr) {
			 
			String StatusJob = "";
			String folderETA="",
					namesinputfils="" ,
					csvfile = "",
					zipfile="",
					namesinputfilsStk="",
					csvfileStock = "",
					zipfileStock="",
					namesinputfilsPcapt="",
					zipfilePcapt="",
					csvfilePcapt="";
			String cdebq=Propriete.getInsatance().get(bq+".cde.bq");
			String requeteDatatraitedChq =Propriete.getInsatance().get(bq+".REQ.DATA.CHQ")+"'"+dteTr+"'";
			String requeteDatatraitedLcn =Propriete.getInsatance().get(bq+".REQ.DATA.LCN")+"'"+dteTr+"'";
			String requeteStockLcn=Propriete.getInsatance().get(bq+".REQ.DATA.STKLCN");
			 String requetetblScanners=Propriete.getInsatance().get(bq+".REQ.DATA.PCAPT");
			 
			 String springconfig="classpath:/../spring/batch/jobs/job-extract-eta-chqlcn-"+bq+".xml";
			String[] springConfig = { springconfig };
			ApplicationContext context=null;
			JobLauncher jobLauncher = null;
			Job job=null;
			JobParameters param=null;
			boolean flag = false;
				try {
					
					if(tr.equalsIgnoreCase("031"))
					{
						
						context = new FileSystemXmlApplicationContext(springConfig);
						jobLauncher = (JobLauncher) context.getBean("jobLauncher");
						job = (Job) context.getBean("jobExporterETAChq"+bq);
						folderETA= Propriete.getInsatance().get(bq+".FOLDER.ETA.CHQ");
						
						
						
						namesinputfils = cdebq+"_ETA_031_"+ dteTr;
						csvfile=folderETA+ "\\"+namesinputfils+".csv";
						zipfile=folderETA+ "\\"+namesinputfils+".zip";
						
						namesinputfilsPcapt = cdebq+"_Pcapts_"+dteTr;
						csvfilePcapt=folderETA+"\\"+namesinputfilsPcapt+".csv";
						zipfilePcapt=folderETA+"\\"+namesinputfilsPcapt+".zip";
						
						
						logger.debug("=== DAO :Extraire donner Etats Chèque  "+requeteDatatraitedChq);
						logger.debug("@@@ DAO : parammetre de config :Spring Batch  "+springConfig);
						logger.debug("@@@ DAO : BeanJob :Spring Batch  "+"jobExporterETAChq"+bq);
						logger.debug("@@@ DAO : Nom dossier OUT "+folderETA);
						logger.debug("@@@ DAO : Nom fichier ETA Chq CSV"+csvfile);
						logger.debug("@@@ DAO : Nom fichier PCAPT CSV"+csvfilePcapt);

					   param = new JobParametersBuilder()
					        .addString("resource", csvfile)
					        .addString("req", requeteDatatraitedChq)
					        
							.addString("resource2", csvfilePcapt)
							.addString("req2", requetetblScanners)
	                        .addString("dtetraitement", StringUtils.replace(dteTr, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")).toJobParameters();
					   
					   
		
					}
					
					if(tr.equalsIgnoreCase("060")){
						folderETA = Propriete.getInsatance().get(bq+".FOLDER.ETA.LCN");
						
						namesinputfils = cdebq+"_ETA_060_"+ dteTr;
						namesinputfilsStk=cdebq+"_ETA_Stock_"+ dteTr;
						csvfile=folderETA+ "\\"+namesinputfils+".csv";
						zipfile=folderETA+ "\\"+namesinputfils+".zip";
						csvfileStock=folderETA+ "\\"+cdebq+"_ETA_Stock_"+ dteTr+".csv";
						zipfileStock=folderETA+ "\\"+namesinputfilsStk+".zip";
						
						
						context = new ClassPathXmlApplicationContext(springConfig);
						jobLauncher = (JobLauncher) context.getBean("jobLauncher");
						job = (Job) context.getBean("jobExporterETALCN"+bq);
						
						param = new JobParametersBuilder()
						.addString("resource", csvfile)
						.addString("req", requeteDatatraitedLcn)
						
						.addString("resourceStock", csvfileStock)
						.addString("reqStock", requeteStockLcn).
						toJobParameters();
						
						   logger.debug("=== DAO :Extraire donner Etats LCN  "+requeteDatatraitedLcn);
							logger.debug("@@@ DAO : parammetre de config :Spring Batch  "+springConfig);
							logger.debug("@@@ DAO : BeanJob :Spring Batch  "+"jobExporterETAChq"+bq);
							logger.debug("@@@ DAO : Nom dossier OUT "+folderETA);
							logger.debug("@@@ DAO : Nom fichier ETA LCN CSV"+csvfile);

						}
					
					logger.debug("=== DAO :Start JobExecution ");
					JobExecution execution = jobLauncher.run(job, param);
					StatusJob = execution.getStatus().toString();
					logger.debug("@@@ DAO :Exit Status  "+StatusJob);
					
					
					if (StatusJob.equalsIgnoreCase("COMPLETED"))
					{
						logger.debug("=== DAO :Job completed successfully ");
						System.out.println("ExamResult job completed successfully");
						
						

						if((!bq.equalsIgnoreCase("SGMA")&&(!bq.equalsIgnoreCase("SGDA"))&&(!bq.equalsIgnoreCase("NAJMAH"))))
						{
							logger.debug("=== compresser le fichier "+zipfile ,null);
							ZipUtils.zipFile(csvfile, zipfile,namesinputfils+".csv");
							logger.debug("=== delete le fichier apres la compression  "+csvfile,null );
							new File(csvfile).delete();
							
							if (tr.equalsIgnoreCase("031"))
			                {
			                	
			                		logger.debug("=== compresser le fichier "+zipfilePcapt ,null);
			                		ZipUtils.zipFile(csvfilePcapt, zipfilePcapt,namesinputfilsPcapt+".csv");
			                		logger.debug("=== delete le fichier apres la compression  "+csvfilePcapt,null );
			                		new File(csvfilePcapt).delete();
			              
			                }
			                else 
			                {
			                
			                	logger.debug("=== compresser le fichier "+zipfileStock ,null);
				               
			                	ZipUtils.zipFile(csvfileStock, zipfileStock,namesinputfilsStk+".csv");
				                logger.debug("=== delete le fichier apres la compression  "+csvfileStock,null );
				                new File(csvfileStock).delete();
			                	
			                }
	
						}

						flag = true;
						
						
					}
					else{
						flag = false;
						logger.debug("+++ DAO :Exit FailureExceptions  "+execution.getAllFailureExceptions());
						logger.debug("+++ DAO :Exit Status  "+StatusJob);
					}
				
				} catch ( JobExecutionAlreadyRunningException e) {
					logger.debug("+++ DAO :JobExecutionAlreadyRunningException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
					flag = false;
				}
				catch ( JobRestartException e) {
					logger.debug("+++ DAO :JobRestartException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
					flag = false;
				}
				catch (  JobInstanceAlreadyCompleteException e) {
					logger.debug("+++ DAO :JobInstanceAlreadyCompleteException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
					flag = false;
				}
				catch (JobParametersInvalidException e) {
					logger.debug("+++ DAO :JobParametersInvalidException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
					flag = false;
				}
				catch (Exception e) {
					logger.debug("+++ DAO :Exception extractDataEtaChqLcntoCsv "+e.getMessage(),e);
					flag = false;
				}
			
			return flag;
		}
	
		public String getAnomalie(String PK_ANO_MNE,String cdeTr, String Req) {
			Query q=null;
			String  lblAnomalie="";
			if(cdeTr.equalsIgnoreCase("031"))
			{
			q= emBpmchq.createNativeQuery(Req);
			}
			if(cdeTr.equalsIgnoreCase("060"))
			{
			System.out.println("Req "+Req);
				q= emBpmlcn.createNativeQuery(Req);
			}
			if((!PK_ANO_MNE.trim().equalsIgnoreCase(""))||(!PK_ANO_MNE.trim().isEmpty())){
			q.setParameter("PK_ANO_MNE", PK_ANO_MNE);
		    lblAnomalie =  (String) q.getSingleResult();
			System.out.println("lblAnomalie ==>"+lblAnomalie);
			}
			return lblAnomalie;
		}

	
		
//		############################################################
//		          GET ALL AGENCES & COMPTES
//		############################################################

		public List<BeanCompte> getAllComptes(String Req) {
			logger.debug("@@@ DAO : getAllComptes  ");
			Query q = emBpmlcn.createNativeQuery(Req,BeanCompte.class);
			
			List<BeanCompte> BeanComptes = q.getResultList();
			
			return BeanComptes;
			
		}

		public List<BeanAgence> getAllAgences(String Req) {
			logger.debug("@@@ DAO : getAllAgences  ");
			Query q = emBpmchq.createNativeQuery(Req,BeanAgence.class);
			List<BeanAgence> BeanAgences = q.getResultList();
			return BeanAgences;
		}

		public BeanAgence getagebycde(String cdeAge, String req) {
			logger.debug("@@@ DAO : getagebycde  ");
			Query q = emBpmchq.createNativeQuery(req,BeanAgence.class);
			q.setParameter("cdeAge", cdeAge);
			BeanAgence BeanAgence = (com.ncrm.dao.entities.BeanAgence) q.getSingleResult();
			return BeanAgence;
		}

		public List<beanScann> getScannerByage(String cdeAge, String req) {
			logger.debug("@@@ DAO : getScannerByage  ");
			Query q = emBpmchq.createNativeQuery(req,beanScann.class);
			q.setParameter("cdeAge", cdeAge);
			List<beanScann> beanScanns = q.getResultList();
			return beanScanns;
		}
		
		@Transactional("jpaTransactionManagerBpm_chq")
		public int AddScanner(beanScann sc,String req) {		
			logger.debug("@@@ DAO : AddScannerToAge ");
			Query q = emBpmchq.createNativeQuery(req,beanScann.class);
			q.setParameter(1, sc.getCdeScanner());
			q.setParameter(2, sc.getAge());
			q.setParameter(3, sc.getType());
			int flag=q.executeUpdate();
			return flag;
		}
	 
		@Transactional("jpaTransactionManagerBpm_chq")
		public int AddAge(BeanAgence age, String req) {
			logger.debug("@@@ DAO : AddAge ");
			Query q = emBpmchq.createNativeQuery(req,BeanAgence.class);
			q.setParameter(1, age.getAGE());
			q.setParameter(2, age.getLIB());
			q.setParameter(3, age.getLOC());
//			q.setParameter(4, new Date());
			int flag=q.executeUpdate();
			return flag;
		}
		
		@Transactional("jpaTransactionManagerBpm_chq")	
		public int DeleteAge(String idage,String req) {
//			Query q = emBpmchq.createNativeQuery(req,BeanAgence.class);
			Query q = emBpmchq.createNativeQuery(req);
			q.setParameter(1, idage);
			int flag=q.executeUpdate();
			
			return flag;
		
			
		
		}
	
		@Transactional("jpaTransactionManagerBpm_chq")
		public int AddCpt(BeanCompte cpt, String req) {
						logger.debug("@@@ DAO : AddCpt ");
						Query q = emBpmchq.createNativeQuery(req,BeanCompte.class);
						System.out.println("cpt.getCPT()"+cpt.getCPT());
						System.out.println("cpt.getAGE()"+cpt.getAGE());
						System.out.println("cpt.getCLIENT()"+cpt.getCLIENT());
						System.out.println("cpt.getTIERS()"+cpt.getTIERS());
						
						q.setParameter(1, cpt.getCPT());
						q.setParameter(2, cpt.getAGE());
						q.setParameter(3, cpt.getCLIENT());
						q.setParameter(4, cpt.getTIERS());
						q.setParameter(5, new Date());
						int flag=q.executeUpdate();
						return flag;
		}

		@Transactional("jpaTransactionManagerBpm_chq")
		public int DeleteAllCpts(String req) {
			Query q = emBpmchq.createNativeQuery(req);
			int flag=q.executeUpdate();
			return flag;
		}
		
		
//	 ########################################################################
//	         ********** EDITON IMPAYEE CHQ  CSV 	
//   #####################################################################
	 
	 
	 
		public List<BeanImpChq> readFromCroCHQ(String bq) {

			String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.CHQ");
			String PATTERN_CROFIL = Propriete.getInsatance().get(bq+".PATTERN.CROFILE.CHQ");
			String regxBodylineCro = Propriete.getInsatance().get(bq+".PATTERN.RECORDCRO.CHQ");
		
			
			
			
			String HeaderLine = null;
			String bodyLine = null;
			File folderInCRO = null;
			BufferedReader br=null;
			int numbreofline = 0;
			List<BeanImpChq> impayeesChq = new ArrayList<BeanImpChq>();

			try {
				
				
				logger.debug("Dao: === Lire a partir du fichier .CRO CHQ " , null);
				logger.debug("Dao: @@@ PArcourir le dossier IN  : "+IN_DIR_CRO , null);
				
				folderInCRO = new File(IN_DIR_CRO);
				
				List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInCRO, PATTERN_CROFIL);
				for (String s : listCro) {
					br = new BufferedReader(new FileReader(IN_DIR_CRO + "\\" + s));
					
					logger.debug("@@@ Parser le fichier >> "+IN_DIR_CRO + "\\" + s +" ligne par ligne" , null);
					
					if ((HeaderLine = br.readLine()) != null) 
					{
						
						numbreofline=numbreofline+1;
						while ((bodyLine = br.readLine()) != null) 
						{
							numbreofline=numbreofline+1;
							if (RegexUtils.matches(bodyLine, regxBodylineCro)) 
							{
								BeanImpChq impchq = new BeanImpChq();
								Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineCro);
								String rio = (String) v.get(1) + v.get(2)+ v.get(3);
								String rejet = (String) v.get(6);
								String rioini = (String) v.get(9);

								impchq.setRIOINI(rioini);
								impchq.setRIO(rio);
								impchq.setRejet(rejet);
								impayeesChq.add(impchq);
								
								logger.debug("@@@ ligne N: "+numbreofline+">>"+IN_DIR_CRO +"[RIOINI="+rioini+"]"+">"+"[RIO="+rio+"]"+">"+"[CDEREJET="+rejet+"]" , null);	
								
							}else{
								logger.debug("+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineCro , null);	
								impayeesChq.clear();
								break;
								
							}
						}
					}
					
					if(impayeesChq.size()>0){
					br.close();
					new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO +"\\"+s+".OK"));
					logger.debug( "=== renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".OK",null);
					}else
						{
							br.close();
							new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO + "\\" + s+".KO"));
							logger.debug( "+++ renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".KO",null);
							}
					
				}
			} catch (IOException e) {
				logger.debug("+++ IOExeption Sur la method readFromCroChq "+e.getMessage(),e);
			}
			catch (Exception e) {
				logger.debug("+++ Exeption Sur la method readFromCroChq "+e.getMessage(),e);
			}
			return impayeesChq;
		}
	 
		public List<BeanImpChq> readFromProdCHQ(List<BeanImpChq> impyschq,String req) {

			try {
	
				logger.debug( "=== Lire a partir du PROD",null);
				for (BeanImpChq imp : impyschq) 
				{
					logger.debug("@@@ DAO : readFromProdCHQ ");
					Query q = emBpmchq.createNativeQuery(req,BeanImpChq.class);
					q.setParameter("RIOINI",  imp.getRIOINI());
					
					logger.debug("@@@ RIOINI "+  imp.getRIOINI());
					
					List<BeanImpChq> foundbeanImpChq = (List<BeanImpChq>) q.getResultList();
				
					logger.debug("@@@  foundbeanImpChq.size() "+foundbeanImpChq.size());
					
			        if (foundbeanImpChq.size()>0) {
			        	BeanImpChq beanImpChq = foundbeanImpChq.get(0);
//						BeanImpChq  beanImpChq =   (BeanImpChq) q.getSingleResult();
							
							imp.setBmch_PK_OBJ_IDT(beanImpChq.getBmch_PK_OBJ_IDT());
							imp.setBmch_CPT(beanImpChq.getBmch_CPT());
							imp.setBmch_LOC(beanImpChq.getBmch_LOC());
							imp.setBmch_ZBK(beanImpChq.getBmch_ZBK());
							imp.setZBK_LIB(beanImpChq.getZBK_LIB());
							imp.setBmch_nser(beanImpChq.getBmch_nser());
							imp.setBmch_rib(beanImpChq.getBmch_rib());
							imp.setBmch_MNT(beanImpChq.getBmch_MNT());
							imp.setBmtr_AGE(beanImpChq.getBmtr_AGE());
							imp.setAGE_LIB(beanImpChq.getAGE_LIB());
							imp.setBmtr_CPT(beanImpChq.getBmtr_CPT());
							imp.setBmch_SQCA(beanImpChq.getBmch_SQCA());
							imp.setBmtn_lecteur(beanImpChq.getBmtn_lecteur());
							imp.setDTE_TRT(beanImpChq.getDTE_TRT());
							imp.setDTE_SORT(beanImpChq.getDTE_SORT());
							
							logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[bmch_nser="+imp.getBmch_nser()+" RIOINI="+imp.getRIOINI()+" ==>"+imp.getDTE_TRT()+"]",null);

			        	 
			        }
			        
					}
				
				
			} 
			catch (Exception e) {
				logger.debug("+++ Exception Sur la method ReadFromPROD "+e.getMessage(),e);
			}

			return impyschq;
		}	
	 
		public List<BeanImpChq> readFromIFPConfCHQ(String bq,List<BeanImpChq> impychq) {
			
			String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.CHQ");
			// IFP
			String IN_DIR_IFP = Propriete.getInsatance().get(bq+".INDIR.IFPCONF.CHQ");
			String PATTERN_IFP_FIL = Propriete.getInsatance().get(bq+".PATTERN.IFPCONFFILE.CHQ");
			String regxBodyIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.CONF.CHQ");;
			File folderInIFP = null;
			BufferedReader br;
			String HeaderLine;
			String bodyLine;
//			List<impayeChqBpm> impayeesChq = null;
			boolean renomeFile = false;
			boolean errorFile = false;
			int numbreofline = 0;

			try {
				logger.debug( "=== Lire a partir du fichiers .IFP " , null);
				logger.debug( "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP , null);
				folderInIFP = new File(IN_DIR_IFP);
//				impayeesChq = new ArrayList<impayeChqBpm>();
				List<String> listIfp = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFP_FIL);
				for (String s : listIfp) {
					br = new BufferedReader(new FileReader(IN_DIR_IFP + "\\" + s));
					
					logger.debug( "=== parser le fichier  : "+IN_DIR_IFP + "\\" + s , null);
					
					HeaderLine = br.readLine();
					if ((HeaderLine != null)&& (RegexUtils.matches(HeaderLine,"(^MCRP)([0-9]{10})$"))) {
						renomeFile = true;
						numbreofline=numbreofline+1;
						while ((bodyLine = br.readLine()) != null) {
							if (RegexUtils.matches(bodyLine, regxBodyIfp)) {
								Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodyIfp);
								numbreofline=numbreofline+1;
								
								for (BeanImpChq imp : impychq) {
									String rioini = (String) v.get(5);
									
									if (imp.getRIOINI().equalsIgnoreCase(rioini)) {
										
										logger.debug( "=== mapping de la ligne N "+numbreofline+" avec le RIOINI : "+rioini , null);
										
										String nomTire = (String) v.get(8);
										String cin = (String) v.get(9);
										String rc = (String) v.get(10);
										String lieuEmi = (String) v.get(13);
										String dteEmi = (String) v.get(14);
										String dteRejet = (String) v.get(15);
										String codeRejet1 = (String) v.get(16);
										String codeRejet2 = (String) v.get(17);
										String codeRejet3 = (String) v.get(18);
										String adrTire = (String) v.get(19);
										imp.setNOMTIRE(nomTire);
										imp.setCIN(cin);
										imp.setRC(rc);
										imp.setLieuEmission(lieuEmi);
										imp.setDTEemission(dteEmi);
										imp.setDTREJET(dteRejet);
										imp.setMOTIF1(codeRejet1);
										imp.setMOTIF2(codeRejet2);
										imp.setMOTIF3(codeRejet3);
										imp.setADR_TIR(adrTire);
									}
								}
								
								errorFile=true;
							}
							else{
								logger.debug( "+++ la ligne N "+numbreofline+" ne respect pas le pattern: "+regxBodyIfp , null);	
								
							}
						}
					}
					logger.debug(  "### renomeFile ### "+renomeFile);
					if (renomeFile) {
						br.close();
						logger.debug(  "=== renomme le fichier >>"+IN_DIR_CRO +"\\" + s ,null);
						new File((IN_DIR_IFP + "\\" + s)).renameTo(new File((IN_DIR_CRO + "\\" + s )));
						

					}
				}
			} catch (IOException e) {
				logger.debug( "+++ IOException Sur la method ReadFromIFPCONF "+e.getMessage(),e);
			}
			catch (Exception e) {
				logger.debug( "+++ Exception Sur la method ReadFromIFPCONF "+e.getMessage(),e);
			}
			return impychq;

		}
	 
		@Transactional("jpaTransactionManagerBpm_chq")
		public  List<BeanImpChq> loadImpysCHQ(List<BeanImpChq> impys,String req) {
			List<BeanImpChq> Insertimpys=null;
			try {
				
				logger.debug( "=== inserer data CRO+PROD+IFPCONF dans la table IMP [" +req+" ]", null);
			
				Insertimpys=new ArrayList<BeanImpChq>();
				for(BeanImpChq imp:impys)
				{
					logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[RIOINI="+imp.getRIOINI()+"]",null);
					if(!(imp.getBmch_PK_OBJ_IDT()==null))
					{
						logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[RIOINI="+imp.getRIOINI()+"]",null);
						
						Query q = emBpmchq.createNativeQuery(req,BeanImpChq.class);
System.out.println("imp.getDTE_TRT() "+imp.getDTE_TRT());
						q.setParameter(1, imp.getBmch_PK_OBJ_IDT());
						q.setParameter(2, imp.getBmch_PK_OBJ_IDT());
						q.setParameter(3, imp.getRIO());
						q.setParameter(4, imp.getRIOINI());
						q.setParameter(5, imp.getRejet());
						q.setParameter(6, imp.getADR_RMT());
						q.setParameter(7, imp.getADR_TIR());
					    q.setParameter(8, imp.getBmch_ZBK());
					    q.setParameter(9, imp.getBmtr_AGE());
					    q.setParameter(10, imp.getAGE_LIB());
					    q.setParameter(11, imp.getBmtr_CPT());
					    q.setParameter(12, imp.getBmch_CPT());
					    q.setParameter(13, imp.getDTE_TRT());
					    q.setParameter(14, imp.getBmch_LOC());
					    q.setParameter(15, imp.getBmtn_lecteur());
					    q.setParameter(16, imp.getBmch_MNT());
					    q.setParameter(17, imp.getBmch_nser());
					    q.setParameter(18, imp.getBmch_SQCA());
					    q.setParameter(19, imp.getBmch_rib());
					    q.setParameter(20, imp.getRSOC_RMT());
					    q.setParameter(21, imp.getRSOC_TIRE());
					    q.setParameter(22, imp.getZBK_LIB());
					    q.setParameter(23, imp.getNOMTIRE());
					    q.setParameter(24, imp.getCIN());
					    q.setParameter(25, imp.getRC());
					    q.setParameter(26, imp.getLieuEmission());
					    q.setParameter(27, imp.getMOTIF1());
					    q.setParameter(28, imp.getMOTIF2());
					    q.setParameter(29, imp.getMOTIF3());
					    q.setParameter(30, imp.getRejet());
					    q.setParameter(31, imp.getDTREJET());
					    q.setParameter(32, imp.getDTE_TRT());
					    q.setParameter(33, imp.getDTEPRE());
					    q.setParameter(34, imp.getDTEemission());
					    q.setParameter(35, imp.getDTE_TRT());
					    q.setParameter(36, imp.getDTE_SORT());
					  
					    int flag=q.executeUpdate();
						logger.debug( "@@@ flag ==> "+flag);
			    if(flag==1){
			    	Insertimpys.add(imp);
			    }
				}
			    
			    }
			} 
			catch (Exception e) {
				logger.debug( "+++ Exception Sur la method NISERTDATA dans tmpo table imp",e);
			
			}
			
			return Insertimpys;
		}
	 
		public  List<BeanImpChq> readFromIFPIACHQ(String bq) {
			String IN_DIR_IFP_IA = Propriete.getInsatance().get(bq+".INDIR.IFPIA.CHQ");
			String PATTERN_IFPIAFIL = Propriete.getInsatance().get(bq+".PATTERN.IFPIAFILE.CHQ");
			String regxBodylineIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.IA.CHQ");
//					"(^[0-9]{3})([0-9]{3})(.{3})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})0([0-9]{7})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})(.{32})([0-9]{3})(.{50})(.{10})(.{20})([0-9]{7})([0-9]{15})(.{20})([0-9]{8})([0-9]{8})(.{3})(.{3})(.{3})(.{100})";
//					"(^[0-9]{3})([0-9]{3})(.{3})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})(.{32})(.{32})([0-9]{3})(.{50})(.{10})(.{20})([0-9]{7})([0-9]{15})(.{20})([0-9]{8})([0-9]{8})(.{3})(.{3})(.{3})(.{100})";
			String HeaderLine = null;
			String bodyLine = null;
			File folderInIFP = null;
			BufferedReader br;
			int numbreofline = 0;
			List<BeanImpChq> impayeesChq = new ArrayList<BeanImpChq>();

			try {
				
				logger.debug("=== Lire a partir du fichier .IFP IA " , null);
				logger.debug( "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP_IA , null);
				folderInIFP = new File(IN_DIR_IFP_IA);
				List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFPIAFIL);
				for (String s : listCro) {
					br = new BufferedReader(new FileReader(IN_DIR_IFP_IA + "\\" + s));
					logger.debug( "@@@ Parser le fichier >> "+IN_DIR_IFP_IA + "\\" + s +" ligne par ligne" , null);
					if ((HeaderLine = br.readLine()) != null) {
						
						numbreofline=numbreofline+1;
						while ((bodyLine = br.readLine()) != null) {
							numbreofline=numbreofline+1;
							if (RegexUtils.matches(bodyLine, regxBodylineIfp)) {
								BeanImpChq impchq = new BeanImpChq();
								Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineIfp);
								String zbk=(String) v.get(9);
								String loc=(String) v.get(10);
								String cpt=(String) v.get(11);
								String rib=(String) v.get(12);
								String rioini=(String) v.get(8)+zbk+loc+cpt+rib;
								String rio=(String) v.get(13);
								String nomTire=(String) v.get(15);
							    String cin=(String) v.get(16);
							    String rc=(String) v.get(17);
							    String nser=(String) v.get(18);
							    String mnt=(String) v.get(19);
							    String lieuEmi=(String) v.get(20);
							    String dteEmi=(String) v.get(21);
							    String dteRejet=(String) v.get(22);
							    String codeRejet1=(String) v.get(23);
							    String codeRejet2=(String) v.get(24);
							    String codeRejet3=(String) v.get(25);
							    String adrTire=(String) v.get(26);
								
					
							    impchq.setBmch_ZBK(zbk);
							    impchq.setBmch_LOC(loc);
							    impchq.setBmch_CPT(cpt);
							    impchq.setBmch_rib(rib);
								impchq.setRIOINI(rioini);
								impchq.setRIO(rio);
								impchq.setNOMTIRE(nomTire);
								impchq.setCIN(cin);
								impchq.setRC(rc);
								impchq.setBmch_nser(nser);
								impchq.setBmch_MNT(mnt);
								impchq.setLieuEmission(lieuEmi);
								impchq.setDTEemission(dteEmi);
								impchq.setDTREJET(dteRejet);
								
								
								impchq.setMOTIF1(codeRejet1);
								impchq.setMOTIF2(codeRejet2);
								impchq.setMOTIF3(codeRejet3);
								System.out.println(codeRejet1+"|"+codeRejet2+"|"+codeRejet3);
								
								if(codeRejet1.equalsIgnoreCase("   ")){
									if(codeRejet2.equalsIgnoreCase("   ")){
										if(codeRejet3.equalsIgnoreCase("   ")){
											impchq.setRejet(codeRejet3);
										}
										else{
											impchq.setRejet(codeRejet3);
										}
									}
									else{
										impchq.setRejet(codeRejet2);
									}
								}
								else  {
									impchq.setRejet(codeRejet1);
								}
								
								impchq.setADR_TIR(adrTire);
								
								impayeesChq.add(impchq);
								
								logger.debug( "@@@ ligne N: "+numbreofline+">>"+"[NSER="+nser+"]"+"[RIB TIRE="+zbk+loc+cpt+rib+"]" , null);	
								
							}else{
								logger.debug( "+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineIfp , null);	
								impayeesChq.clear();
								break;
								
							}
						}
					}
					
					if(impayeesChq.size()>0){
					br.close();
					new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA +"\\"+s+".OK"));
					logger.debug( "=== renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".OK",null);
					}else
						{
							br.close();
							new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA + "\\" + s+".KO"));
							logger.debug( "+++ renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".KO",null);
							}
					
				}
			} catch (IOException e) {
				logger.debug( "+++ IOExeption Sur la method ReadFromCRO",e);
			}
			catch (Exception e) {
				logger.debug( "+++ Exeption Sur la method ReadFromCRO",e);
			}
			return impayeesChq;
		}
	 
		public List<BeanImpChq> readFromProdIACHQ(List<BeanImpChq> impychq,String dteTr1,String req) {
			

			try {
				
				logger.debug( "=== Lire a partir du PROD pour les valeur IA ",null);
				for (BeanImpChq imp : impychq) {

					Query q = emBpmchq.createNativeQuery(req,BeanImpChq.class);
					q.setParameter("ZBKT", imp.getBmch_ZBK());
					q.setParameter("LOCT", imp.getBmch_LOC());
					q.setParameter("CPTT", imp.getBmch_CPT());
					q.setParameter("RIBT", imp.getBmch_rib());
					q.setParameter("NSER", imp.getBmch_nser());
					q.setParameter("DTETRT", dteTr1);
	
					
					System.out.println("ZBKT"+ imp.getBmch_ZBK());
					System.out.println("LOCT"+ imp.getBmch_LOC());
					System.out.println("CPTT"+ imp.getBmch_CPT());
					System.out.println("RIBT"+ imp.getBmch_rib());
					System.out.println("NSER"+ imp.getBmch_nser());
					System.out.println("DTETRT"+ dteTr1);
					
					List<BeanImpChq> foundbeanImpChq = (List<BeanImpChq>) q.getResultList();
					System.out.println("foundbeanImpChq "+foundbeanImpChq.size());
			        if (foundbeanImpChq.size()>0) {
			        	BeanImpChq beanImpChq = foundbeanImpChq.get(0);
//						BeanImpChq  beanImpChq =   (BeanImpChq) q.getSingleResult();
						
						
						
							imp.setBmch_PK_OBJ_IDT(beanImpChq.getBmch_PK_OBJ_IDT());
							imp.setBmch_CPT(beanImpChq.getBmch_CPT());
							imp.setBmch_LOC(beanImpChq.getBmch_LOC());
							imp.setBmch_ZBK(beanImpChq.getBmch_ZBK());
							imp.setZBK_LIB(beanImpChq.getZBK_LIB());
							imp.setBmch_nser(beanImpChq.getBmch_nser());
							imp.setBmch_rib(beanImpChq.getBmch_rib());
							imp.setBmch_MNT(beanImpChq.getBmch_MNT());
							imp.setBmtr_AGE(beanImpChq.getBmtr_AGE());
							imp.setAGE_LIB(beanImpChq.getAGE_LIB());
							imp.setBmtr_CPT(beanImpChq.getBmtr_CPT());
							imp.setBmch_SQCA(beanImpChq.getBmch_SQCA());
							imp.setBmtn_lecteur(beanImpChq.getBmtn_lecteur());
							imp.setDTE_TRT(beanImpChq.getDTE_TRT());
							imp.setDTE_SORT(beanImpChq.getDTE_SORT());
							
							logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[bmch_nser="+imp.getBmch_nser()+" RIOINI="+imp.getRIOINI()+"]",null);

			        	 
			        }

		

				}
			} 
			catch (Exception e) {
				logger.debug( "+++ Exception Sur la method ReadFromPRODIA "+e.getMessage(),e);
			}
			return impychq;
		}
		
		public  List<BeanCountImpy> getImpyChqByBq(String req){
			
			logger.debug("@@@ DAO : getAllImpyee  "+req);
			Query q = emBpmchq.createNativeQuery(req,BeanCountImpy.class);
			List<BeanCountImpy> CountImp = q.getResultList();
			return CountImp;
			
		}
		
        public  List<BeanCountImpy> getImpyChqByBqBaa(String req){
			
			logger.debug("@@@ DAO : getAllImpyee  "+req);
			Query q = emBaachq.createNativeQuery(req,BeanCountImpy.class);
			List<BeanCountImpy> CountImp = q.getResultList();
			return CountImp;
			
		}
		
		
		
		
	 
		
	 
//		 ########################################################################
//        ********** EDITON IMPAYEE LCN  CSV 	
//		#####################################################################	
		
		
		public List<BeanImpLcn> readFromCroLCN(String bq) {

			String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.LCN");
			String PATTERN_CROFIL = Propriete.getInsatance().get(bq+".PATTERN.CROFILE.LCN");
			String regxBodylineCro = Propriete.getInsatance().get(bq+".PATTERN.RECORDCRO.LCN");
			
			String HeaderLine = null;
			String bodyLine = null;
			File folderInCRO = null;
			BufferedReader br=null;
			int numbreofline = 0;
			List<BeanImpLcn> impayeesLCN = new ArrayList<BeanImpLcn>();

			try {
				
				logger.debug( "=== Lire a partir du fichier .CRO LCN " , null);

					
			
				
				
					logger.debug(  "@@@ PArcourir le dossier IN  : "+IN_DIR_CRO , null);
				folderInCRO = new File(IN_DIR_CRO);
				System.out.println(IN_DIR_CRO);
				List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInCRO, PATTERN_CROFIL);
				for (String s : listCro) {
					br = new BufferedReader(new FileReader(IN_DIR_CRO + "\\" + s));
					logger.debug(  "@@@ Parser le fichier >> "+IN_DIR_CRO + "\\" + s +" ligne par ligne" , null);
					if ((HeaderLine = br.readLine()) != null) {
						
						numbreofline=numbreofline+1;
						while ((bodyLine = br.readLine()) != null) {
							numbreofline=numbreofline+1;
							if (RegexUtils.matches(bodyLine, regxBodylineCro)) {
								BeanImpLcn implcn = new BeanImpLcn();
								Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineCro);
								String rio = (String) v.get(1) + v.get(2)+ v.get(3);
								String rejet = (String) v.get(6);
								String rioini = (String) v.get(9);

								implcn.setRIOINI(rioini);
								implcn.setRIO(rio);
								implcn.setRejet(rejet);
								impayeesLCN.add(implcn);
								
						logger.debug(  "@@@ ligne N: "+numbreofline+">>"+IN_DIR_CRO +"[RIOINI="+rioini+"]"+">"+"[RIO="+rio+"]"+">"+"[CDEREJET="+rejet+"]" , null);	
								
							}else{
								logger.debug(  "+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineCro , null);	
								impayeesLCN.clear();
								break;
								
							}
						}
					}
					
					if(impayeesLCN.size()>0){
					br.close();
					new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO +"\\"+s+".OK"));
					logger.debug(  "=== renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".OK",null);
					}else
						{
							br.close();
							new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO + "\\" + s+".KO"));
							logger.debug(  "+++ renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".KO",null);
							}
					
				}
			} catch (IOException e) {
				logger.debug(  "+++ IOExeption Sur la method ReadFromCROLCN"+e.getMessage(),e);
			}
			catch (Exception e) {
				logger.debug(  "+++ Exeption Sur la method ReadFromCROLCN"+e.getMessage(),e);
			}
			return impayeesLCN;
		}
		
	    public  List<BeanImpLcn> readFromProdLCN(List<BeanImpLcn> impyslcn,String req) {
			
			

			try {
				

					
					
					logger.debug(  "=== Lire a partir du PROD LCN",null);
					for (BeanImpLcn imp : impyslcn) {

						Query q = emBpmlcn.createNativeQuery(req,BeanImpLcn.class);
						q.setParameter("RIOINI",  imp.getRIOINI());
						System.out.println("RIOINI"+  imp.getRIOINI());
						List<BeanImpLcn> foundbeanImpLcn = (List<BeanImpLcn>) q.getResultList();
						System.out.println("foundbeanImpChq "+foundbeanImpLcn.size());
				        if (foundbeanImpLcn.size()>0) {
				        	BeanImpLcn beanImplcn = foundbeanImpLcn.get(0);
						logger.debug(  "@@@  [RIOINI="+imp.getRIOINI()+"]",null);
					
					
						
							imp.setBmlcn_PK_OBJ_IDT(beanImplcn.getBmlcn_PK_OBJ_IDT());
							imp.setBmlcn_CPT(beanImplcn.getBmlcn_CPT());
							imp.setBmlcn_LOC(beanImplcn.getBmlcn_LOC());
							imp.setBmlcn_ZBK(beanImplcn.getBmlcn_ZBK());
							imp.setZBK_LIB(beanImplcn.getZBK_LIB());
							imp.setBmlcn_nser(beanImplcn.getBmlcn_nser());
							imp.setBmlcn_rib(beanImplcn.getBmlcn_rib());
							imp.setBmlcn_MNT(beanImplcn.getBmlcn_MNT());
							imp.setBmtr_AGE(beanImplcn.getBmtr_AGE());
							imp.setAGE_LIB(beanImplcn.getAGE_LIB());
							imp.setBmtr_CPT(beanImplcn.getBmtr_CPT());
//							imp.setSQCA(beanImplcn.getbmch_SQCA());
							imp.setBmtn_lecteur(beanImplcn.getBmtn_lecteur());
							imp.setDTEINS(beanImplcn.getDTE_TRT());
							
							imp.setDTE_SORT(beanImplcn.getDTE_SORT());
							imp.setDTEEC(beanImplcn.getDTEEC());
							imp.setDTEPRE(beanImplcn.getDTEPRE());
							
							logger.debug(  "@@@  [PK_OBJ_IDT="+imp.getBmlcn_PK_OBJ_IDT()+"]&&[bmlcn_nser="+imp.getBmlcn_nser()+"]",null);

						}

				}
				
				
			} 
	   
			catch (Exception e) {
				logger.debug(  "+++ Exception Sur la method ReadFromPRODLCN "+e.getMessage(),e);
			}

			return impyslcn;
		}
	    
	    public  List<BeanImpLcn> readFromIFPConfLCN(List<BeanImpLcn> impylcn,String bq) {
	    	String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.LCN");
	    	// IFP
			String IN_DIR_IFP = Propriete.getInsatance().get(bq+".INDIR.IFPCONF.LCN");
			String PATTERN_IFP_FIL = Propriete.getInsatance().get(bq+".PATTERN.IFPCONFFILE.LCN");
			String regxBodyIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.CONF.LCN");
			File folderInIFP = null;
			BufferedReader br;
			String HeaderLine;
			String bodyLine;
			boolean renomeFile = false;
			boolean errorFile = false;
			int numbreofline = 0;

			try {
				
				logger.debug(  "=== Lire a partir du fichiers .IFP " , null);
				logger.debug(  "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP , null);
				folderInIFP = new File(IN_DIR_IFP);
//				impayeesChq = new ArrayList<impayeChqBpm>();
				List<String> listIfp = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFP_FIL);
				for (String s : listIfp) {
					br = new BufferedReader(new FileReader(IN_DIR_IFP + "\\" + s));
					logger.debug(  "=== parser le fichier  : "+IN_DIR_IFP + "\\" + s , null);
					HeaderLine = br.readLine();
					if ((HeaderLine != null)&& (RegexUtils.matches(HeaderLine,"(^MCNP)([0-9]{10})$"))) {
						renomeFile = true;
						numbreofline=numbreofline+1;
						while ((bodyLine = br.readLine()) != null) {
							
							if (RegexUtils.matches(bodyLine, regxBodyIfp)) {
								Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodyIfp);
								numbreofline=numbreofline+1;
								for (BeanImpLcn imp : impylcn) {
									String rioini = (String) v.get(5);
									if (imp.getRIOINI().equalsIgnoreCase(rioini)) {
										logger.debug(  "=== mapping de la ligne N "+numbreofline+" avec le RIOINI : "+rioini , null);
										String nomTire = (String) v.get(8);
										String cin = (String) v.get(9);
										String rc = (String) v.get(10);
										String lieuEmi = (String) v.get(13);
										String dteEmi = (String) v.get(14);
										String dteRejet = (String) v.get(15);
										String codeRejet1 = (String) v.get(16);
										String codeRejet2 = (String) v.get(17);
										String codeRejet3 = (String) v.get(18);
										String adrTire = (String) v.get(19);
										imp.setNOMTIRE(nomTire);
										imp.setCIN(cin);
										imp.setRC(rc);
										imp.setLieuEmission(lieuEmi);
										imp.setDTEemission(dteEmi);
										imp.setDTREJET(dteRejet);
										imp.setMOTIF1(codeRejet1);
										imp.setMOTIF2(codeRejet2);
										imp.setMOTIF3(codeRejet3);
										imp.setAdresseTire(adrTire);
									}
								}
								
								errorFile=true;
							}
							else{
								logger.debug(  "+++ la ligne N "+numbreofline+" ne respect pas le pattern: "+regxBodyIfp , null);	
								
							}
						}
					}
					if (renomeFile) {
						br.close();
//						new File((IN_DIR_IFP + "\\" + s)).renameTo(new File((IN_DIR_IFP + "\\" + s + ".LCN")));
//						logger.debug(  "=== renomme le fichier >>"+IN_DIR_IFP +"\\" + s + ".LCN",null);
						
						logger.debug(  "=== renomme le fichier >>"+IN_DIR_CRO +"\\" + s ,null);
						new File((IN_DIR_IFP + "\\" + s)).renameTo(new File((IN_DIR_CRO + "\\" + s )));

					}
				}
			} catch (IOException e) {
				logger.debug(  "+++ IOException Sur la method ReadFromIFPCONF "+e.getMessage(),e);
			}
			catch (Exception e) {
				logger.debug(  "+++ Exception Sur la method ReadFromIFPCONF "+e.getMessage(),e);
			}
			return impylcn;

		}
		
	    public  List<BeanImpLcn> readFromIFPIALCN(String bq) {
			String IN_DIR_IFP_IA = Propriete.getInsatance().get(bq+".INDIR.IFPIA.LCN");
			String PATTERN_IFPIAFIL = Propriete.getInsatance().get(bq+".PATTERN.IFPIAFILE.LCN");
			String regxBodylineIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.IA.LCN");
//					"(^[0-9]{3})([0-9]{3})(.{3})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})(.{32})(.{32})([0-9]{3})(.{50})(.{10})(.{20})([0-9]{7})([0-9]{15})(.{20})([0-9]{8})([0-9]{8})(.{3})(.{3})(.{3})(.{100})";
			String HeaderLine = null;
			String bodyLine = null;
			File folderInIFP = null;
			BufferedReader br;
			int numbreofline = 0;
			List<BeanImpLcn> impayeesLcn = new ArrayList<BeanImpLcn>();

			try {
				
				logger.debug(  "=== Lire a partir du fichier .IFP IA " , null);
				logger.debug(  "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP_IA , null);
				folderInIFP = new File(IN_DIR_IFP_IA);
				List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFPIAFIL);
				for (String s : listCro) {
					br = new BufferedReader(new FileReader(IN_DIR_IFP_IA + "\\" + s));
					logger.debug(  "@@@ Parser le fichier >> "+IN_DIR_IFP_IA + "\\" + s +" ligne par ligne" , null);
					if ((HeaderLine = br.readLine()) != null) {
						
						numbreofline=numbreofline+1;
						while ((bodyLine = br.readLine()) != null) {
							numbreofline=numbreofline+1;
							if (RegexUtils.matches(bodyLine, regxBodylineIfp)) {
								
								
								BeanImpLcn implcn = new BeanImpLcn();
								Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineIfp);
								String zbk=(String) v.get(4);
								String loc=(String) v.get(5);
								String cpt=(String) v.get(6);
								String rib=(String) v.get(7);
								String rioini=(String) v.get(8);
								String rio=(String) v.get(9);
								String nomTire=(String) v.get(11);
							    String cin=(String) v.get(12);
							    String rc=(String) v.get(13);
							    String nser=(String) v.get(14);
							    String mnt=(String) v.get(15);
							    String lieuEmi=(String) v.get(16);
							    String dteEmi=(String) v.get(17);
							    String dteRejet=(String) v.get(18);
							    String codeRejet1=(String) v.get(19);
							    String codeRejet2=(String) v.get(20);
							    String codeRejet3=(String) v.get(21);
							    String adrTire=(String) v.get(22);
							    
							    implcn.setBmlcn_ZBK(zbk);
							    implcn.setBmlcn_LOC(loc);
							    implcn.setBmlcn_CPT(cpt);
							    implcn.setBmlcn_rib(rib);
								implcn.setRIOINI(rioini);
								implcn.setRIO(rio);
								implcn.setNOMTIRE(nomTire);
								implcn.setCIN(cin);
								implcn.setRC(rc);
								implcn.setBmlcn_nser(nser);
								implcn.setBmlcn_MNT(formatMnt(mnt));
								implcn.setLieuEmission(lieuEmi);
								implcn.setDTEemission(dteEmi);
								implcn.setDTREJET(dteRejet);
								
								
								implcn.setMOTIF1(codeRejet1);
								implcn.setMOTIF2(codeRejet2);
								implcn.setMOTIF3(codeRejet3);
//								System.out.println(codeRejet1+"|"+codeRejet2+"|"+codeRejet3);
								
								if(codeRejet1.equalsIgnoreCase("   ")){
									if(codeRejet2.equalsIgnoreCase("   ")){
										if(codeRejet3.equalsIgnoreCase("   ")){
											implcn.setRejet("000");
										}
										else{
											implcn.setRejet(codeRejet3);
										}
									}
									else{
										implcn.setRejet(codeRejet2);
									}
								}
								else  {
									implcn.setRejet(codeRejet1);
								}
								
								implcn.setAdresseTire(adrTire);
								
								impayeesLcn.add(implcn);
								
						logger.debug(  "@@@ ligne N: "+numbreofline+">>"+"[NSER="+nser+"]"+"[RIB TIRE="+zbk+"-"+loc+"-"+cpt+"-"+rib+"]" , null);	
								
							}else{
								logger.debug(  "+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineIfp , null);	
								impayeesLcn.clear();
								break;
								
							}
						}
					}
					
					if(impayeesLcn.size()>0){
					br.close();
//					new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA +"\\"+s+".OK"));
					logger.debug(  "=== renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".OK",null);
					}else
						{
							br.close();
							new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA + "\\" + s+".KO"));
							logger.debug(  "+++ renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".KO",null);
							}
					
				}
			
			} catch (IOException e) {
				logger.debug(  "+++ IOExeption Sur la method readFromIFPIALCN "+e.getMessage(),e);
			}
			catch (Exception e) {
				logger.debug(  "+++ Exeption Sur la method readFromIFPIALCN "+e.getMessage(),e);
			}
			return impayeesLcn;
		}
		
	    public  List<BeanImpLcn> readFromProdIALCN(List<BeanImpLcn> impysLcn,String dteSort,String req) {
			String REQ_DATA_FROM_PROIA = "BPM.REQ.GETIMP.PROD.IA.LCN";

			try {
				
				logger.debug(  "=== Lire a partir du PROD pour les valeur IA ",null);
				for (BeanImpLcn imp : impysLcn) {

					Query q = emBpmlcn.createNativeQuery(req,BeanImpLcn.class);
					q.setParameter("RIOINI",  imp.getRIOINI());
					q.setParameter("ZBKT", imp.getBmlcn_ZBK());
					q.setParameter("LOCT", imp.getBmlcn_LOC());
					q.setParameter("CPTT", imp.getBmlcn_CPT());
					q.setParameter("RIBT", imp.getBmlcn_rib());
					q.setParameter("NSER", imp.getBmlcn_nser());
					q.setParameter("DTESORT", dteSort);
					
					
					System.out.println("RIOINI"+  imp.getRIOINI());
					List<BeanImpLcn> foundbeanImpLcn = (List<BeanImpLcn>) q.getResultList();
					System.out.println("foundbeanImpLCN IA  "+foundbeanImpLcn.size());
			        if (foundbeanImpLcn.size()>0) {
			        	BeanImpLcn beanImplcn = foundbeanImpLcn.get(0);
					logger.debug(  "@@@  [RIOINI="+imp.getRIOINI()+"]",null);
				
				
					
						imp.setBmlcn_PK_OBJ_IDT(beanImplcn.getBmlcn_PK_OBJ_IDT());
						imp.setBmlcn_CPT(beanImplcn.getBmlcn_CPT());
						imp.setBmlcn_LOC(beanImplcn.getBmlcn_LOC());
						imp.setBmlcn_ZBK(beanImplcn.getBmlcn_ZBK());
						imp.setZBK_LIB(beanImplcn.getZBK_LIB());
						imp.setBmlcn_nser(beanImplcn.getBmlcn_nser());
						imp.setBmlcn_rib(beanImplcn.getBmlcn_rib());
						imp.setBmlcn_MNT(beanImplcn.getBmlcn_MNT());
						imp.setBmtr_AGE(beanImplcn.getBmtr_AGE());
						imp.setAGE_LIB(beanImplcn.getAGE_LIB());
						imp.setBmtr_CPT(beanImplcn.getBmtr_CPT());
//						imp.setSQCA(beanImplcn.getbmch_SQCA());
						imp.setBmtn_lecteur(beanImplcn.getBmtn_lecteur());
						imp.setDTEINS(beanImplcn.getDTE_TRT());
						
						imp.setDTE_SORT(beanImplcn.getDTE_SORT());
						imp.setDTEEC(beanImplcn.getDTEEC());
						imp.setDTEPRE(beanImplcn.getDTEPRE());
						logger.debug(  "@@@  [PK_OBJ_IDT="+imp.getBmlcn_PK_OBJ_IDT()+"]&&[bmlcn_nser="+imp.getBmlcn_nser()+"]",null);

					}

					
					logger.debug(  "@@@  execute la requete ["+REQ_DATA_FROM_PROIA+"]",null);
					
//					
					}
				
			} 
			catch (Exception e) {
				logger.debug(  "+++ Exception Sur la method ReadFromPRODIALCN "+e.getMessage(),e);
			
			}
			return impysLcn;
		}
	     
	    @Transactional("jpaTransactionManagerBpm_lcn")
	    public  List<BeanImpLcn> loadImpysLCN(List<BeanImpLcn> impys,String req) {
			List<BeanImpLcn> Insertimpys=null;
			try {
			
				logger.debug( "=== inserer les données mapping a partir du fichier CRO+PROD+IFPCONF dans la table IMP LCN" , null);
				
				Insertimpys=new ArrayList<BeanImpLcn>();
				String REQ_INSERT_DATA_IMP="BPM.REQ.ADDIMP.LCN";
				
				logger.debug("@@@ execute la requete "+REQ_INSERT_DATA_IMP , null);
				for(BeanImpLcn imp:impys){
					System.out.println(imp.getBmlcn_PK_OBJ_IDT());
	  		if(!(imp.getBmlcn_PK_OBJ_IDT()==null)){
					logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmlcn_PK_OBJ_IDT()+"]&&[RIOINI="+imp.getRIOINI()+"]",null);
					Query q = emBpmlcn.createNativeQuery(req,BeanImpChq.class);
					q.setParameter(1, imp.getBmlcn_PK_OBJ_IDT());
					q.setParameter(2, imp.getBmlcn_PK_OBJ_IDT());
			    q.setParameter(3, imp.getRIO());
			    q.setParameter(4, imp.getRIOINI());
				  q.setParameter(5, imp.getRejet());
			    q.setParameter(6, imp.getADR_RMT());
			    q.setParameter(7, imp.getAdresseTire());
			    q.setParameter(8, imp.getBmlcn_ZBK());
			    q.setParameter(9, imp.getBmtr_AGE());
			    q.setParameter(10, imp.getAGE_LIB());
			    q.setParameter(11, imp.getBmtr_CPT());
			    q.setParameter(12, imp.getBmlcn_CPT());
			    q.setParameter(13, imp.getBmlcn_LOC());
			    q.setParameter(14, imp.getBmtn_lecteur());
			    q.setParameter(15, imp.getBmlcn_MNT());
			    q.setParameter(16, imp.getBmlcn_nser());
			    q.setParameter(17, imp.getBmlcn_rib());
			    q.setParameter(18, imp.getRSOC_RMT());
			    q.setParameter(19, imp.getRSOC_TIRE());
			    q.setParameter(20, imp.getZBK_LIB());
			    q.setParameter(21, imp.getNOMTIRE());
			    q.setParameter(22, imp.getCIN());
			    q.setParameter(23, imp.getRC());
			    q.setParameter(24, imp.getLieuEmission());
			    q.setParameter(25, imp.getMOTIF1());
			    q.setParameter(26, imp.getMOTIF2());
			    q.setParameter(27, imp.getMOTIF3());
			    q.setParameter(28, imp.getRejet());
			    q.setParameter(29, imp.getDTREJET());
			    q.setParameter(30, imp.getDTEINS());
			    q.setParameter(31, imp.getDTEPRE());
			    q.setParameter(32, imp.getDTEemission());
			    q.setParameter(33, imp.getDTE_SORT());
			    q.setParameter(34, imp.getDTEEC());
			    int i=q.executeUpdate();
			    if(i==1){
			    	Insertimpys.add(imp);
			    }
				}
			    
			    }
			} 
			catch (Exception e) {
				logger.debug( "+++ Exception Sur la method INISERTDATA dans tmpo table imp LCN"+e.getMessage(),e);
				e.printStackTrace();
			}
			
			return Insertimpys;
		}
	    
	    public  boolean chargertableimpaye(String bq, String cdeTr,String dteTrt) {
			boolean flag=false;
			String cdeBq=Propriete.getInsatance().get(bq+".cde.bq");
			String folderImpCHQ = Propriete.getInsatance().get(bq+".FOLDER.OUT.IMP.CHQ");
			String folderImpLCN = Propriete.getInsatance().get(bq+".FOLDER.OUT.IMP.LCN");
			String StatusJob="";
		
			String nameFile="";
			String csvFile = "" ;
			String zipFile="";		
			 String jobExporterImp="";
			 String ReqExportDataTmp="";
			 String[] springConfig = { "classpath:/../spring/batch/jobs/job-extract-impy-chqLcn-"+bq+".xml" };
			 ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
			logger.debug( "=== Debut Extraction des impayées BPM Spring Batch",null);
			logger.debug( "################################################ ",null);
			logger.debug( "############# Lancement de Batch jobExporterImp ############ ",null);
			logger.debug( "################################################ ",null);
			
			if(cdeTr.equalsIgnoreCase("031")){
				
				String dte=null;
//				if(bq.equalsIgnoreCase("SGMA"))
//				{
//				
//					nameFile = cdeBq+"_IMP_031_"+StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")+"_"+DateUtils.formatDateToStirng(new Date(),"yyyyMMdd");
//					csvFile=folderImpCHQ+ "\\"+nameFile+".csv";
//					zipFile=folderImpCHQ+ "\\"+nameFile+".zip";
//				}
//				else {
//					
//					nameFile=cdeBq+"_IMP_"+cdeTr+"_"+DateUtils.formatDateToStirng(new Date(),"yyyyMMdd");
//					csvFile = folderImpCHQ + "\\"+nameFile+".csv";
//					zipFile=folderImpCHQ + "\\"+nameFile+".zip";
//				}
				
				
				
				nameFile = cdeBq+"_IMP_031_"+StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")+"_"+DateUtils.formatDateToStirng(new Date(),"yyyyMMdd");
				csvFile=folderImpCHQ+ "\\"+nameFile+".csv";
				zipFile=folderImpCHQ+ "\\"+nameFile+".zip";
				ReqExportDataTmp= Propriete.getInsatance().get(bq+".REQ.DATA.IMP.CHQ")+"'"+dteTrt+"'" ;
//						Propriete.getInsatance().get("BPM.REQUETE.EXPORTDATAFROM.TMPTBL.CHQ");
				
				JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
				jobExporterImp="jobExporterImpChq"+bq;
				Job job = (Job) context.getBean("jobExporterImpChq"+bq);
				logger.debug( "################################################ ",null);
				 logger.debug( "=== JOB traitement CHQ "+jobExporterImp,null);
				 logger.debug( "@@@ Dossier OUT des Impayees  :"+folderImpCHQ,null);
				 logger.debug( "@@@ Non du fichier .csv :"+csvFile,null);
				 logger.debug( "@@@ Non du fichier .zip :"+zipFile,null);
				 logger.debug( "############################################### ",null);
					try {
						JobParameters param = new JobParametersBuilder().addString("resource", csvFile).addString("req", ReqExportDataTmp).addString("dtetraitement", StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")).toJobParameters();
						// JobParameters param = new JobParameters();
						logger.debug( "=== Start du job :  : "+jobExporterImp,null); 
						JobExecution execution = jobLauncher.run(job, param);
						StatusJob = execution.getStatus().toString();
						logger.debug( "@@@  Status return : " + StatusJob,null);

						
						if (StatusJob.equalsIgnoreCase("COMPLETED")) {
							logger.debug( "@@@ jobExporterImpChqBPM Terminer Correctement",null);
							logger.debug( "=== Start Compression le fichier "+csvFile+" dans "+zipFile,null);
							logger.debug( "@@@ zipFile("+csvFile+"," +zipFile+", "+nameFile+".csv",null);
							ZipUtils.zipFile(csvFile, zipFile, nameFile+".csv");
							logger.debug( "=== File("+csvFile+").delete()",null);
							new File(csvFile).delete();
							flag = true;
						}
						else 
						{
							flag=false;
							logger.debug( "+++ "+ jobExporterImp+ " : job completed Filed",null);
							logger.debug( "+++ Exit Status : "+ execution.getAllFailureExceptions(),null);
						}
					} catch (Exception e) {
						logger.debug( "+++ Exception dans la method Envoyertableimpaye ",e);
					}
					

				}
			if(cdeTr.equalsIgnoreCase("060")){
				String dte=null;
					if(bq.equalsIgnoreCase("SGMA"))
					{
						dte=StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$3-$2-$1");
						
					}
					else {
						dte=dteTrt;
//						nameFile=cdeBq+"_IMP_"+cdeTr+"_"+DateUtils.formatDateToStirng(new Date(),"yyyyMMdd");
//						csvFile = folderImpLCN + "\\"+nameFile+".csv";
//						zipFile=folderImpLCN + "\\"+nameFile+".zip";
					}
					System.out.println("*********************** "+dteTrt);
					nameFile = cdeBq+"_IMP_060_"+StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")+"_"+DateUtils.formatDateToStirng(new Date(),"yyyyMMdd");;					
					
					csvFile=folderImpLCN+ "\\"+nameFile+".csv";
					zipFile=folderImpLCN+ "\\"+nameFile+".zip";
				ReqExportDataTmp=Propriete.getInsatance().get(bq+".REQ.DATA.IMP.LCN")+"'"+dte+"'" ;
//						Propriete.getInsatance().get("BPM.REQUETE.EXPORTDATAFROM.TMPTBL.LCN");
				
				JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
				jobExporterImp="jobExporterImpLCN"+bq;
				Job job = (Job) context.getBean("jobExporterImpLCN"+bq);
				logger.debug( "################################################ ",null);
				 logger.debug( "=== JOB traitement LCN "+jobExporterImp,null);
				 logger.debug( "@@@ Dossier OUT des Impayees  :"+folderImpLCN,null);
				 logger.debug( "@@@ Non du fichier .csv :"+csvFile,null);
				 logger.debug( "@@@ Non du fichier .zip :"+zipFile,null);
				 logger.debug( "@@@ ReqExportDataTmp :"+ReqExportDataTmp,null);
				 logger.debug( "############################################### ",null);
					try {

					
						JobParameters param = new JobParametersBuilder().addString("resource", csvFile).addString("req", ReqExportDataTmp).addString("dtetraitement", StringUtils.replace(dteTrt, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")).toJobParameters();
						// JobParameters param = new JobParameters();
						logger.debug( "=== Start du job :  : "+jobExporterImp,null);
						JobExecution execution = jobLauncher.run(job, param);
						StatusJob = execution.getStatus().toString();
						logger.debug( "@@@ Exit Status : " + StatusJob,null);
						

						
						if (StatusJob.equalsIgnoreCase("COMPLETED")) {
							logger.debug( "@@@ jobExporterImpChqBPM Terminer Correctement",null);
							logger.debug( "=== Start Compression le fichier "+csvFile+" dans "+zipFile,null);
							logger.debug( "@@@ zipFile("+csvFile+"," +zipFile+", "+nameFile+".csv",null);
							ZipUtils.zipFile(csvFile, zipFile, nameFile+".csv");
							new File(csvFile).delete();
							flag = true;
						}
						else 
						{
							flag=false;
							logger.debug( "+++ "+ jobExporterImp+ " : job completed Filed",null);
							logger.debug( "+++ Exit Status : "+ execution.getAllFailureExceptions(),null);
						}
					} catch (Exception e) {
						logger.debug( "+++ Exception dans la method Envoyertableimpaye "+e.getMessage(),e);
					}
					

				}
					

			return flag;
		}
	    
	    
	    public static String formatMnt(String mntString){
	    			
	    			double mnt = Double.parseDouble(mntString);
	    			mntString=String.format("%.0f", new BigDecimal(mnt));
	    			mntString=StringUtils.replace(mntString, "([0-9]*),([0-9]{2})$","$1");
	    			mntString=mntString.substring(0, mntString.length()-2)+"."+mntString.substring(mntString.length()-2, mntString.length());
	    			return mntString;
	    			
	    		}

	    	 
	    	 
//	 #########################################################
//	    	 BMCE
//	 #########################################################
	    	 
		public List<Object[]> gettr_prfBMCE() {
		String Req="SELECT PK_PRF_NUM FROM r_multi_37.tr_prf where PRF_NOM like '%BMCE%' ;";
				Query q = emBpmlcn.createNativeQuery(Req);
			
				List<Object[]>  listrprofBmce = q.getResultList();
				
				return listrprofBmce;
			}

		@Transactional("jpaTransactionManagerBpm_chq")
		public int Addta_prf_optBMCE(String pk) {
			String req="INSERT INTO r_multi_37.ta_prf_opt (PK_USR_IDT,PK_PRF_NUM,PK_OPT_MNE,OPT_VAL,OPT_PRE,OPT_SYS) VALUES "
					+ "(0,"+pk+",'NAJMA','0','',NULL),"
					+ "(0,"+pk+",'L_NAJMA','0','',NULL),"
					
					+ "(0,"+pk+",'NAJMR','0','',NULL),"
					+ "(0,"+pk+",'L_NAJMR','0','',NULL),"
					
					+ "(0,"+pk+",'S_NAJM','0','',NULL)";
//					+ "(0,"+pk+",'L_SGDAR','0','',NULL),"
//						+ "(0,"+pk+",'SIGN','0','',NULL)";
//					+ "(0,"+pk+",'S_SGDA','0','',NULL);";
			System.out.println("["+req+"]");
			Query q = emBpmchq.createNativeQuery(req);
			int flag=q.executeUpdate();
			return flag;
		}

		
//#########################################################
//   	 CFG
//#########################################################
		@Transactional("jpaTransactionManagerCfg_chq")	
		public int purgeTablePaidChq(String bq,String trt) {
			String req=Propriete.getInsatance().get(bq+".REQ.PURGE.TABLE."+trt);;
			System.out.println(req);
			Query q = emCfgchq.createNativeQuery(req,BeanFile.class);
			return q.executeUpdate();
			
			
		}

		public List<RecordPaidValue> getAllValueChq(String bq, String trt,String listparams,String listPcapts) {
			Query q =null;
			String Req=Propriete.getInsatance().get(bq+".REQ.GET.ALL.VALUE."+trt);
			logger.debug("@@@  getAllValue cheque "+Req);
			if(bq.equalsIgnoreCase("CFG")){
			q = emCfgchq.createNativeQuery(Req,RecordPaidValue.class);
			}
			else{
				Req=Req+" and concat(date,BMTN_lecteur) in ("+listparams+")";
				System.out.println(" ### "+Req);
				q = emLocal.createNativeQuery(Req,RecordPaidValue.class);
			}
			List<RecordPaidValue> BeansFile = q.getResultList();
			return BeansFile;
		}

		public List<BeanCountpye> getCountValueChq(String bq, String trt) {
			String Req=Propriete.getInsatance().get(bq+".REQ.GET.COUNT.VALUE."+trt);
			logger.debug("@@@  getCountValueChq cheque  "+Req);
			Query q = emCfgchq.createNativeQuery(Req,BeanCountpye.class);
			List<BeanCountpye> BeansFile = q.getResultList();
			return BeansFile;
		}

		
		//#########################################################
		
		@Transactional("jpaTransactionManagerCfg_lcn")
		public int purgeTablePaidLcn(String bq, String trt) {
			String req=Propriete.getInsatance().get(bq+".REQ.PURGE.TABLE."+trt);;
			System.out.println(req);
			Query q = emCfglcn.createNativeQuery(req,BeanFile.class);
			return q.executeUpdate();
		}

		@Override
		public List<RecordPaidValue> getAllValueLcn(String bq, String trt,String listPcapts) {
			String Req=Propriete.getInsatance().get(bq+".REQ.GET.ALL.VALUE."+trt);
			Req=Req+" and concat(date,BMTN_lecteur) in ("+listPcapts+")";
			logger.debug("@@@  getAllValue LCN "+Req);
			Query q = emCfglcn.createNativeQuery(Req,RecordPaidValue.class);
			List<RecordPaidValue> BeansFile = q.getResultList();
			return BeansFile;
		}

		@Override
		public List<BeanCountpye> getCountValueLcn(String bq, String trt) {
			String Req=Propriete.getInsatance().get(bq+".REQ.GET.COUNT.VALUE."+trt);
			logger.debug("@@@  getCountValueLcn LCN  "+Req);
			Query q = emCfglcn.createNativeQuery(Req,BeanCountpye.class);
			List<BeanCountpye> BeansFile = q.getResultList();
			return BeansFile;
		}

//		 #######################################################################
//		 ## BAA
//		########################################################################
		public BigInteger getCountRemTraitedBaa(String dteTr,String Req) {
			logger.debug("@@@ DAO : getCountRemTraitedBaa  le "+dteTr);
			Query q = emBaalcn.createNativeQuery(Req);
			q.setParameter("Date", dteTr);
			BigInteger  CountRemTraited =  (BigInteger) q.getSingleResult();
			return CountRemTraited;
		}	
		
		public List<Object[]> getCount2ndSumMntTraitedSIBaa(String dteTr,String Req) {
			logger.debug("@@@ DAO : getCount2ndSumMntTraitedSIBaa  le "+dteTr);
			Query q = emBaalcn.createNativeQuery(Req);
			q.setParameter("Date", dteTr);
			List<Object[]>  Count2ndSumMntLcn = q.getResultList();
			return Count2ndSumMntLcn;
		}
		
		
		public List<BaaRecordRemLCN> getRemLcnTraiterBaa(String dteTr,String Req) {
				logger.debug("@@@ DAO : getRemLcnTraiter Baa  le "+dteTr);
				
				Query q = emBaalcn.createNativeQuery(Req,BaaRecordRemLCN.class);
				q.setParameter("Date", dteTr);
				List<BaaRecordRemLCN> RecordRemLCNs = q.getResultList();
				return RecordRemLCNs;
			}

			public List<BaaRecordLCN> getLCNTraitedBaa(String dteTr, String pk_obj_id_Rem,String Req) {
				logger.debug("@@@ DAO : getLCNTraited Baa DATA  LCNs remise : "+pk_obj_id_Rem +" & traitées le "+dteTr);
				Query q = emBaalcn.createNativeQuery(Req,BaaRecordLCN.class);
				q.setParameter("Date", dteTr);
				q.setParameter("pk_obj_id_Rem", pk_obj_id_Rem);
				List<BaaRecordLCN> DATALCN = q.getResultList();
				return DATALCN;
			}

			public BigInteger getCountValueTraitedBaa(String bq,String cdeTr,String dteTr) {
				String Req="";
				Query q=null;
				logger.debug("@@@ DAO : getCountValueTraited  le "+dteTr+"Traitement "+cdeTr);
				
				if(cdeTr.equalsIgnoreCase("031"))
				{
					Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.CHQ");
					 q = emBaachq.createNativeQuery(Req);
				}
				
				if(cdeTr.equalsIgnoreCase("060"))
				{
					Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.LCN");
					 q = emBaalcn.createNativeQuery(Req);
				}
				q.setParameter("Date", dteTr);
				BigInteger  CountRemTraited =  (BigInteger) q.getSingleResult();
				return CountRemTraited;
			}
				
			public boolean extractDataEtaChqLcntoCsvBaa(String bq,String tr,String dteTr) {
				 
				String StatusJob = "";
				String folderETA="",
						namesinputfils="" ,
						csvfile = "",
						zipfile="",
						namesinputfilsPcapt="",
						zipfilePcapt="",
						csvfilePcapt="";
				String cdebq=Propriete.getInsatance().get(bq+".cde.bq");
				String requeteDatatraitedChq =Propriete.getInsatance().get(bq+".REQ.DATA.CHQ")+"'"+dteTr+"'";
				String requeteDatatraitedLcn =Propriete.getInsatance().get(bq+".REQ.DATA.LCN")+"'"+dteTr+"'";
				 String requetetblScanners=Propriete.getInsatance().get(bq+".REQ.DATA.PCAPT");
				 
				 String springconfig="classpath:/../spring/batch/jobs/job-extract-eta-chqlcn-"+bq+".xml";
				String[] springConfig = { springconfig };
				ApplicationContext context=null;
				JobLauncher jobLauncher = null;
				Job job=null;
				JobParameters param=null;
				boolean flag = false;
					try {
						
						if(tr.equalsIgnoreCase("031")){
							System.out.println(springConfig);
							context = new FileSystemXmlApplicationContext(springConfig);
							jobLauncher = (JobLauncher) context.getBean("jobLauncher");
							job = (Job) context.getBean("jobExporterETAChq"+bq);
							folderETA= Propriete.getInsatance().get(bq+".FOLDER.ETA.CHQ");
							namesinputfils = cdebq+"_ETA_031_"+ dteTr;
							csvfile=folderETA+ "\\"+namesinputfils+".csv";
							zipfile=folderETA+ "\\"+namesinputfils+".zip";
							
							namesinputfilsPcapt = cdebq+"_Pcapts_"+dteTr;
							csvfilePcapt=folderETA+"\\"+namesinputfilsPcapt+".csv";
							zipfilePcapt=folderETA+"\\"+namesinputfilsPcapt+".zip";
							logger.debug("=== DAO :Extraire donner Etats Chèque  "+requeteDatatraitedChq);
							logger.debug("@@@ DAO : parammetre de config :Spring Batch  "+springConfig);
							logger.debug("@@@ DAO : BeanJob :Spring Batch  "+"jobExporterETAChq"+bq);
							logger.debug("@@@ DAO : Nom dossier OUT "+folderETA);
							logger.debug("@@@ DAO : Nom fichier ETA Chq CSV"+csvfile);
							logger.debug("@@@ DAO : Nom fichier PCAPT CSV"+csvfilePcapt);

						   param = new JobParametersBuilder().addString("resource", csvfile).addString("req", requeteDatatraitedChq)
								.addString("resource2", csvfilePcapt).addString("req2", requetetblScanners)
		                        .addString("dtetraitement", StringUtils.replace(dteTr, "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3")).toJobParameters();
						   
						   
			
						}
						
						if(tr.equalsIgnoreCase("060")){
							folderETA = Propriete.getInsatance().get(bq+".FOLDER.ETA.LCN");
							namesinputfils = cdebq+"_ETA_060_"+ dteTr;
							csvfile=folderETA+ "\\"+namesinputfils+".csv";
							zipfile=folderETA+ "\\"+namesinputfils+".zip";
							context = new ClassPathXmlApplicationContext(springConfig);
							jobLauncher = (JobLauncher) context.getBean("jobLauncher");
							job = (Job) context.getBean("jobExporterETALCN"+bq);
							param = new JobParametersBuilder().addString("resource", csvfile).addString("req", requeteDatatraitedLcn).toJobParameters();
							
							   logger.debug("=== DAO :Extraire donner Etats LCN  "+requeteDatatraitedLcn);
								logger.debug("@@@ DAO : parammetre de config :Spring Batch  "+springConfig);
								logger.debug("@@@ DAO : BeanJob :Spring Batch  "+"jobExporterETAChq"+bq);
								logger.debug("@@@ DAO : Nom dossier OUT "+folderETA);
								logger.debug("@@@ DAO : Nom fichier ETA LCN CSV"+csvfile);

							}
						
						logger.debug("=== DAO :Start JobExecution ");
						JobExecution execution = jobLauncher.run(job, param);
						StatusJob = execution.getStatus().toString();
						logger.debug("@@@ DAO :Exit Status  "+StatusJob);
						
						
						if (StatusJob.equalsIgnoreCase("COMPLETED")) {
							logger.debug("=== DAO :Job completed successfully ");
							System.out.println("ExamResult job completed successfully");
							
							logger.debug("=== compresser le fichier "+zipfile ,null);

							ZipUtils.zipFile(csvfile, zipfile,namesinputfils+".csv");
							
							logger.debug("=== delete le fichier apres la compression  "+csvfile,null );
			                new File(csvfile).delete();
			                
			                if (tr.equalsIgnoreCase("031")){
			                	logger.debug("=== compresser le fichier "+zipfilePcapt ,null);
			                ZipUtils.zipFile(csvfilePcapt, zipfilePcapt,namesinputfilsPcapt+".csv");
			                logger.debug("=== delete le fichier apres la compression  "+csvfilePcapt,null );
			                new File(csvfilePcapt).delete();
			                }
							flag = true;
							
							
						}
						else{
							flag = false;
							logger.debug("+++ DAO :Exit FailureExceptions  "+execution.getAllFailureExceptions());
							logger.debug("+++ DAO :Exit Status  "+StatusJob);
						}
					
					} catch ( JobExecutionAlreadyRunningException e) {
						logger.debug("+++ DAO :JobExecutionAlreadyRunningException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch ( JobRestartException e) {
						logger.debug("+++ DAO :JobRestartException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch (  JobInstanceAlreadyCompleteException e) {
						logger.debug("+++ DAO :JobInstanceAlreadyCompleteException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch (JobParametersInvalidException e) {
						logger.debug("+++ DAO :JobParametersInvalidException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch (Exception e) {
						logger.debug("+++ DAO :Exception extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
				
				return flag;
			}
		
			public String getAnomalieBaa(String PK_ANO_MNE,String cdeTr, String Req) {
				Query q=null;
				String  lblAnomalie="";
				if(cdeTr.equalsIgnoreCase("031"))
				{
				q= emBaachq.createNativeQuery(Req);
				}
				if(cdeTr.equalsIgnoreCase("060"))
				{
				System.out.println("Req "+Req);
					q= emBaalcn.createNativeQuery(Req);
				}
				if((!PK_ANO_MNE.trim().equalsIgnoreCase(""))||(!PK_ANO_MNE.trim().isEmpty())){
				q.setParameter("PK_ANO_MNE", PK_ANO_MNE);
			    lblAnomalie =  (String) q.getSingleResult();
				System.out.println("lblAnomalie ==>"+lblAnomalie);
				}
				return lblAnomalie;
			}

			public List<BeanAgence> getAllAgencesBaa(String Req) {
				// TODO Auto-generated method stub
				logger.debug("@@@ DAO : getAllAgences  ");
				Query q = emBaachq.createNativeQuery(Req,BeanAgence.class);
				List<BeanAgence> BeanAgences = q.getResultList();
				return BeanAgences;
			}
			
			
			public List<beanScann> getScannerByageBaa(String cdeAge, String req) {
				// TODO Auto-generated method stub
				logger.debug("@@@ DAO : getScannerByage  Baa ");
				Query q = emBaachq.createNativeQuery(req,beanScann.class);
				q.setParameter("cdeAge", cdeAge);
				List<beanScann> beanScanns = q.getResultList();
				return beanScanns;
			}
			
			@Transactional("jpaTransactionManagerBaa_chq")
			public int AddScannerBaa(beanScann sc,String req) {
				// TODO Auto-generated method stub			
				logger.debug("@@@ DAO : AddScannerToAge Baa ");
				Query q = emBaachq.createNativeQuery(req,beanScann.class);
				q.setParameter(1, sc.getCdeScanner());
				q.setParameter(2, sc.getAge());
				q.setParameter(3, sc.getType());
				int flag=q.executeUpdate();
				return flag;
			}
			
			public List<BeanCompte> getAllComptesBaa(String Req) {
				// TODO Auto-generated method stub
				logger.debug("@@@ DAO : getAllComptes Baa ");
				Query q = emBaalcn.createNativeQuery(Req,BeanCompte.class);
				
				List<BeanCompte> BeanComptes = q.getResultList();
				
				return BeanComptes;
				
			}

//			 #######################################################################
//			 ## SGMA
//			########################################################################	
			
			
			@Override
			 public BigInteger getCountValueTraitedSgma(String bq,String cdeTr,String dteTr) {
				String Req="";
				Query q=null;
				logger.debug("@@@ DAO : getCountValueTraited SGMA le "+dteTr+"Traitement "+cdeTr);
				
				if(cdeTr.equalsIgnoreCase("031"))
				{
					Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.CHQ");
					 q = emSgmachq.createNativeQuery(Req);
				}
				
				else if(cdeTr.equalsIgnoreCase("060"))
				{
					Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.LCN");
					 q = emSgmalcn.createNativeQuery(Req);
				}
				else
				{
					Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATAPAYE.LCN");
					 q = emSgmalcn.createNativeQuery(Req);
					
				}
				q.setParameter("Date", dteTr);
				BigInteger  CountRemTraited =  (BigInteger) q.getSingleResult();
				return CountRemTraited;
			}

			@Override
			public String getAnomalieSgma(String PK_ANO_MNE, String cdeTr,
					String Req) {
				// TODO Auto-generated method stub
				Query q=null;
				String  lblAnomalie="";
				if(cdeTr.equalsIgnoreCase("031"))
				{
				q= emSgmachq.createNativeQuery(Req);
				}
				if(cdeTr.equalsIgnoreCase("060"))
				{
				System.out.println("Req "+Req);
					q= emSgmalcn.createNativeQuery(Req);
				}
				if((!PK_ANO_MNE.trim().equalsIgnoreCase(""))||(!PK_ANO_MNE.trim().isEmpty())){
				q.setParameter("PK_ANO_MNE", PK_ANO_MNE);
			    lblAnomalie =  (String) q.getSingleResult();
				System.out.println("lblAnomalie ==>"+lblAnomalie);
				}
				return lblAnomalie;
			}
			
			
//			SUIVI PHYSIQUE 
			
			@Override
			
			public BigInteger getCountValueSuiviSgma(String bq, String trt,
					String dtetrt1, String dtetrt2,String listPcapts) {
				String Req="";
				Query q=null;
				logger.debug("@@@ DAO : getCountValueTraited SGMA le "+dtetrt1+" & "+dtetrt2+" Traitement "+trt);
				
				if(trt.equalsIgnoreCase("031"))
				{
					Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.SUIVI.CHQ");//+" and bmtn.LECTEUR in ("+listPcapts+")";
					 q = emSgmachq.createNativeQuery(Req);
				}
				
				if(trt.equalsIgnoreCase("060"))
				{
					Req=Propriete.getInsatance().get(bq+".REQ.COUNTDATA.SUIVI.LCN");//+" and bmtn.LECTEUR in ("+listPcapts+")";
					 q = emSgmalcn.createNativeQuery(Req);
				}
				q.setParameter("Date1", dtetrt1);
				q.setParameter("Date2", dtetrt2);
			
				System.out.println(Req);
				BigInteger  CountRemTraited =  (BigInteger) q.getSingleResult();
				
				
				System.out.println("CountRemTraited "+CountRemTraited);
				return CountRemTraited;
			}

			@Override
			public boolean extractDataSuiviChqLcn(String bq, String tr,
					String dtetrt1, String dtetrt2,String listPcapts) {
				String StatusJob = "";
		
				String cdebq=Propriete.getInsatance().get(bq+".cde.bq");
				String requeteDatatraitedChq =Propriete.getInsatance().get(bq+".REQ.DATA.SUIVI.CHQ")+" and date in ('"+dtetrt1+"','"+dtetrt2+"') ";//+and bmtn.LECTEUR in ("+listPcapts+") ";
				String requeteDatatraitedLcn =Propriete.getInsatance().get(bq+".REQ.DATA.SUIVI.LCN")+" and date in ('"+dtetrt1+"','"+dtetrt2+"') "; // +and bmtn.LECTEUR in ("+listPcapts+")";
				
				
				 
				 String springconfig="classpath:/../spring/batch/jobs/job-extract-Suivi-chqlcn-"+bq+".xml";
				String[] springConfig = { springconfig };
				ApplicationContext context=null;
				JobLauncher jobLauncher = null;
				Job job=null;
				JobParameters param=null;
				boolean flag = false;
					try {
						
						if(tr.equalsIgnoreCase("031"))
						{
							
							context = new FileSystemXmlApplicationContext(springConfig);
							jobLauncher = (JobLauncher) context.getBean("jobLauncher");
							job = (Job) context.getBean("jobExporterSUIVIChq"+bq);
						
							
							
							
							
							

							
							logger.debug("=== DAO :Extraire donner Etats Chèque  "+requeteDatatraitedChq);
							logger.debug("@@@ DAO : parammetre de config :Spring Batch  "+springConfig);
							logger.debug("@@@ DAO : BeanJob :Spring Batch  "+"jobExporterSUIVIChq"+bq);
						
						
						   param = new JobParametersBuilder().addString("req", requeteDatatraitedChq).toJobParameters();
						   
						   
			
						}
						
						if(tr.equalsIgnoreCase("060")){
						
							
							
							

							context = new ClassPathXmlApplicationContext(springConfig);
							jobLauncher = (JobLauncher) context.getBean("jobLauncher");
							job = (Job) context.getBean("jobExporterSUIVILCN"+bq);
							
							param = new JobParametersBuilder().addString("req", requeteDatatraitedLcn).toJobParameters();
							
							   logger.debug("=== DAO :Extraire donner Etats LCN  "+requeteDatatraitedLcn);
								logger.debug("@@@ DAO : parammetre de config :Spring Batch  "+springConfig);
								logger.debug("@@@ DAO : BeanJob :Spring Batch  "+"jobExporterETAChq"+bq);
						

							}
						
						logger.debug("=== DAO :Start JobExecution ");
						JobExecution execution = jobLauncher.run(job, param);
						StatusJob = execution.getStatus().toString();
						logger.debug("@@@ DAO :Exit Status  "+StatusJob);
						
						
						if (StatusJob.equalsIgnoreCase("COMPLETED")) {
							logger.debug("=== DAO :Job completed successfully ");
							System.out.println("ExamResult job completed successfully");
							
							
							flag=true;
							
			                }
			               
							
							
							
						
					
					} catch ( JobExecutionAlreadyRunningException e) {
						logger.debug("+++ DAO :JobExecutionAlreadyRunningException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch ( JobRestartException e) {
						logger.debug("+++ DAO :JobRestartException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch (  JobInstanceAlreadyCompleteException e) {
						logger.debug("+++ DAO :JobInstanceAlreadyCompleteException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch (JobParametersInvalidException e) {
						logger.debug("+++ DAO :JobParametersInvalidException extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
					catch (Exception e) {
						logger.debug("+++ DAO :Exception extractDataEtaChqLcntoCsv "+e.getMessage(),e);
						flag = false;
					}
				
				return flag;
			}
			@Override
			public List<BeanDetailSuiviPhysique> getDetailFluxphysique(String req){
				Query q = null;
				logger.debug("@@@ DAO : getDetailFluxphysique  "+req);
				q = emLocal.createNativeQuery(req,BeanDetailSuiviPhysique.class);
				List<BeanDetailSuiviPhysique> BeanDetailSuiviPhysique = q.getResultList();
				return BeanDetailSuiviPhysique;
			}
			
			@Override
			public List<BeanSuiviPhysique> getRecupFluxphysique(String req) {
				Query q = null;
				logger.debug("@@@ DAO : getRecupFluxphysique  "+req);
				q = emLocal.createNativeQuery(req,BeanSuiviPhysique.class);
				List<BeanSuiviPhysique> BeanSuiviPhysique = q.getResultList();
				return BeanSuiviPhysique;
				
			}
			
			
			@Override
			@Transactional("jpaTransactionManagerlocal")
			public int updateValideFluxphysique(String req, String listParam,
					String listdte,String username) {
				req=req+" and concat(date,BMTN_lecteur) in ("+listParam+")";
					logger.debug("@@@  updateValideFluxphysique : "+req);
					Query q = emLocal.createNativeQuery(req);
//				
					
					q.setParameter("receptionist", username);
					int flag=q.executeUpdate();
					return flag;
				
			}
			
			
			@Override
			@Transactional("jpaTransactionManagerlocal")
			public int synchronImpayeLCNFluxphysique(String req){
			
				logger.debug("@@@  synchronImpayeLCNFluxphysique : "+req);
				Query q = emLocal.createNativeQuery(req);

					int flag=q.executeUpdate();
				return flag;
			}
			// ################## IMPAYE CHQ
			
			public List<BeanImpChqSG> readFromProdCHQSg(List<BeanImpChqSG> impyschq,String req) {

				try {
		
					logger.debug( "=== Lire a partir du PROD SGMA",null);
					for (BeanImpChqSG imp : impyschq) 
					{
						logger.debug("@@@ DAO : readFromProdCHQ SGMA "+ req);
						Query q = emSgmachq.createNativeQuery(req,BeanImpChqSG.class);
						q.setParameter("RIOINI",  imp.getRIOINI());
						
						logger.debug("@@@ RIOINI "+  imp.getRIOINI());
						
						List<BeanImpChqSG> foundbeanImpChq = (List<BeanImpChqSG>) q.getResultList();
					
						logger.debug("@@@  foundbeanImpChq.size() "+foundbeanImpChq.size());
						
				        if (foundbeanImpChq.size()>0) {
				        	BeanImpChqSG beanImpChq = foundbeanImpChq.get(0);
//							BeanImpChq  beanImpChq =   (BeanImpChq) q.getSingleResult();
								
								imp.setBmch_PK_OBJ_IDT(beanImpChq.getBmch_PK_OBJ_IDT());
								imp.setBmch_CPT(beanImpChq.getBmch_CPT());
								imp.setBmch_LOC(beanImpChq.getBmch_LOC());
								imp.setBmch_ZBK(beanImpChq.getBmch_ZBK());
								imp.setZBK_LIB(beanImpChq.getZBK_LIB());
								imp.setBmch_nser(beanImpChq.getBmch_nser());
								imp.setBmch_rib(beanImpChq.getBmch_rib());
								imp.setBmch_MNT(beanImpChq.getBmch_MNT());
								imp.setBmtr_AGE(beanImpChq.getBmtr_AGE());
								imp.setAGE_LIB(beanImpChq.getAGE_LIB());
								imp.setBmtr_CPT(beanImpChq.getBmtr_CPT());
								imp.setBmch_SQCA(beanImpChq.getBmch_SQCA());
								imp.setBmtn_lecteur(beanImpChq.getBmtn_lecteur());
								imp.setDTE_TRT(beanImpChq.getDTE_TRT());
								imp.setDTE_SORT(beanImpChq.getDTE_SORT());
								imp.setID_WEBCAPTUR(beanImpChq.getID_WEBCAPTUR());
								imp.setAGE_SCAN(beanImpChq.getAGE_SCAN());
								imp.setBmtr_nser(beanImpChq.getBmtr_nser());
								imp.setBmtr_mode(beanImpChq.getBmtr_mode());
								logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[bmch_nser="+imp.getBmch_nser()+" RIOINI="+imp.getRIOINI()+" ==>"+imp.getDTE_TRT()+"]",null);

				        	 
				        }
				        
						}
					
					
				} 
				catch (Exception e) {
					logger.debug("+++ Exception Sur la method ReadFromPROD "+e.getMessage(),e);
				}

				return impyschq;
			}	
			
			public List<BeanImpChqSG> readFromCroCHQSg(String bq) {

				String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.CHQ");
				String PATTERN_CROFIL = Propriete.getInsatance().get(bq+".PATTERN.CROFILE.CHQ");
				String regxBodylineCro = Propriete.getInsatance().get(bq+".PATTERN.RECORDCRO.CHQ");
			
				
				
				
				String HeaderLine = null;
				String bodyLine = null;
				File folderInCRO = null;
				BufferedReader br=null;
				int numbreofline = 0;
				List<BeanImpChqSG> impayeesChq = new ArrayList<BeanImpChqSG>();

				try {
					
					
					logger.debug("Dao: === Lire a partir du fichier .CRO CHQ SGMA " , null);
					logger.debug("Dao: @@@ PArcourir le dossier IN  : "+IN_DIR_CRO , null);
					
					folderInCRO = new File(IN_DIR_CRO);
					
					List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInCRO, PATTERN_CROFIL);
					for (String s : listCro) {
						br = new BufferedReader(new FileReader(IN_DIR_CRO + "\\" + s));
						
						logger.debug("@@@ Parser le fichier >> "+IN_DIR_CRO + "\\" + s +" ligne par ligne" , null);
						
						if ((HeaderLine = br.readLine()) != null) 
						{
							
							numbreofline=numbreofline+1;
							while ((bodyLine = br.readLine()) != null) 
							{
								numbreofline=numbreofline+1;
								if (RegexUtils.matches(bodyLine, regxBodylineCro)) 
								{
									BeanImpChqSG impchq = new BeanImpChqSG();
									Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineCro);
									String rio = (String) v.get(1) + v.get(2)+ v.get(3);
									String rejet = (String) v.get(6);
									String rioini = (String) v.get(9);

									impchq.setRIOINI(rioini);
									impchq.setRIO(rio);
									impchq.setRejet(rejet);
									impayeesChq.add(impchq);
									
									logger.debug("@@@ ligne N: "+numbreofline+">>"+IN_DIR_CRO +"[RIOINI="+rioini+"]"+">"+"[RIO="+rio+"]"+">"+"[CDEREJET="+rejet+"]" , null);	
									
								}else{
									logger.debug("+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineCro , null);	
									impayeesChq.clear();
									break;
									
								}
							}
						}
						
						if(impayeesChq.size()>0){
						br.close();
						new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO +"\\"+s+".OK"));
						logger.debug( "=== renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".OK",null);
						}else
							{
								br.close();
								new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO + "\\" + s+".KO"));
								logger.debug( "+++ renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".KO",null);
								}
						
					}
				} catch (IOException e) {
					logger.debug("+++ IOExeption Sur la method readFromCroChq SGMA"+e.getMessage(),e);
				}
				catch (Exception e) {
					logger.debug("+++ Exeption Sur la method readFromCroChq SGMA "+e.getMessage(),e);
				}
				return impayeesChq;
			}

			public List<BeanImpChqSG> readFromIFPConfCHQSg(String bq,List<BeanImpChqSG> impychq) {
				
				String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.CHQ");
				// IFP
				String IN_DIR_IFP = Propriete.getInsatance().get(bq+".INDIR.IFPCONF.CHQ");
				String PATTERN_IFP_FIL = Propriete.getInsatance().get(bq+".PATTERN.IFPCONFFILE.CHQ");
				String regxBodyIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.CONF.CHQ");;
				File folderInIFP = null;
				BufferedReader br;
				String HeaderLine;
				String bodyLine;
//				List<impayeChqBpm> impayeesChq = null;
				boolean renomeFile = false;
				boolean errorFile = false;
				int numbreofline = 0;

				try {
					logger.debug( "=== Lire a partir du fichiers .IFP SGMA" , null);
					logger.debug( "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP , null);
					folderInIFP = new File(IN_DIR_IFP);
//					impayeesChq = new ArrayList<impayeChqBpm>();
					List<String> listIfp = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFP_FIL);
					for (String s : listIfp) {
						br = new BufferedReader(new FileReader(IN_DIR_IFP + "\\" + s));
						
						logger.debug( "=== parser le fichier  : "+IN_DIR_IFP + "\\" + s , null);
						
						HeaderLine = br.readLine();
						if ((HeaderLine != null)&& (RegexUtils.matches(HeaderLine,"(^MCRP)([0-9]{10})$"))) {
							renomeFile = true;
							numbreofline=numbreofline+1;
							while ((bodyLine = br.readLine()) != null) {
								if (RegexUtils.matches(bodyLine, regxBodyIfp)) {
									Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodyIfp);
									numbreofline=numbreofline+1;
									
									for (BeanImpChqSG imp : impychq) {
										String rioini = (String) v.get(5);
										
										if (imp.getRIOINI().equalsIgnoreCase(rioini)) {
											
											logger.debug( "=== mapping de la ligne N "+numbreofline+" avec le RIOINI : "+rioini , null);
											
											String nomTire = (String) v.get(8);
											String cin = (String) v.get(9);
											String rc = (String) v.get(10);
											String lieuEmi = (String) v.get(13);
											String dteEmi = (String) v.get(14);
											String dteRejet = (String) v.get(15);
											String codeRejet1 = (String) v.get(16);
											String codeRejet2 = (String) v.get(17);
											String codeRejet3 = (String) v.get(18);
											String adrTire = (String) v.get(19);
											imp.setNOMTIRE(nomTire);
											imp.setCIN(cin);
											imp.setRC(rc);
											imp.setLieuEmission(lieuEmi);
											imp.setDTEemission(dteEmi);
											imp.setDTREJET(dteRejet);
											imp.setMOTIF1(codeRejet1);
											imp.setMOTIF2(codeRejet2);
											imp.setMOTIF3(codeRejet3);
											imp.setADR_TIR(adrTire);
										}
									}
									
									errorFile=true;
								}
								else{
									logger.debug( "+++ la ligne N "+numbreofline+" ne respect pas le pattern: "+regxBodyIfp , null);	
									
								}
							}
						}
						logger.debug(  "### renomeFile ### "+renomeFile);
						if (renomeFile) {
							br.close();
							logger.debug(  "=== renomme le fichier >>"+IN_DIR_CRO +"\\" + s ,null);
							new File((IN_DIR_IFP + "\\" + s)).renameTo(new File((IN_DIR_CRO + "\\" + s )));
							

						}
					}
				} catch (IOException e) {
					logger.debug( "+++ IOException Sur la method ReadFromIFPCONF "+e.getMessage(),e);
				}
				catch (Exception e) {
					logger.debug( "+++ Exception Sur la method ReadFromIFPCONF "+e.getMessage(),e);
				}
				return impychq;

			}
					
			public  List<BeanImpChqSG> readFromIFPIACHQSg(String bq) {
				String IN_DIR_IFP_IA = Propriete.getInsatance().get(bq+".INDIR.IFPIA.CHQ");
				String PATTERN_IFPIAFIL = Propriete.getInsatance().get(bq+".PATTERN.IFPIAFILE.CHQ");
				String regxBodylineIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.IA.CHQ");
//						"(^[0-9]{3})([0-9]{3})(.{3})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})0([0-9]{7})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})(.{32})([0-9]{3})(.{50})(.{10})(.{20})([0-9]{7})([0-9]{15})(.{20})([0-9]{8})([0-9]{8})(.{3})(.{3})(.{3})(.{100})";
//						"(^[0-9]{3})([0-9]{3})(.{3})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})(.{32})(.{32})([0-9]{3})(.{50})(.{10})(.{20})([0-9]{7})([0-9]{15})(.{20})([0-9]{8})([0-9]{8})(.{3})(.{3})(.{3})(.{100})";
				String HeaderLine = null;
				String bodyLine = null;
				File folderInIFP = null;
				BufferedReader br;
				int numbreofline = 0;
				List<BeanImpChqSG> impayeesChq = new ArrayList<BeanImpChqSG>();

				try {
					
					logger.debug("=== Lire a partir du fichier .IFP IA " , null);
					logger.debug( "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP_IA , null);
					logger.debug( "@@@ PArcourir le dossier IN  : "+PATTERN_IFPIAFIL , null);
					folderInIFP = new File(IN_DIR_IFP_IA);
					List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFPIAFIL);
					for (String s : listCro) {
						br = new BufferedReader(new FileReader(IN_DIR_IFP_IA + "\\" + s));
						logger.debug( "@@@ Parser le fichier >> "+IN_DIR_IFP_IA + "\\" + s +" ligne par ligne" , null);
						if ((HeaderLine = br.readLine()) != null) {
							
							numbreofline=numbreofline+1;
							while ((bodyLine = br.readLine()) != null) {
								numbreofline=numbreofline+1;
								if (RegexUtils.matches(bodyLine, regxBodylineIfp)) {
									BeanImpChqSG impchq = new BeanImpChqSG();
									Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineIfp);
									String zbk=(String) v.get(4);
									String loc=(String) v.get(5);
									String cpt=(String) v.get(6);
									String rib=(String) v.get(7);
									String rioini=(String) v.get(8);
									String rio=(String) v.get(9);
									String nomTire=(String) v.get(11);
								    String cin=(String) v.get(12);
								    String rc=(String) v.get(13);
								    String nser=(String) v.get(14);
								    String mnt=(String) v.get(15);
								    String lieuEmi=(String) v.get(16);
								    String dteEmi=(String) v.get(17);
								    String dteRejet=(String) v.get(18);
								    String codeRejet1=(String) v.get(19);
								    String codeRejet2=(String) v.get(20);
								    String codeRejet3=(String) v.get(21);
								    String adrTire=(String) v.get(22);
								    String mnt2=formatMnt(mnt);
								    impchq.setBmch_ZBK(zbk);
								    impchq.setBmch_LOC(loc);
								    impchq.setBmch_CPT(cpt);
								    impchq.setBmch_rib(rib);
									impchq.setRIOINI(rioini);
									impchq.setRIO(rio);
									impchq.setNOMTIRE(nomTire);
									impchq.setCIN(cin);
									impchq.setRC(rc);
									impchq.setBmch_nser(nser);
									impchq.setBmch_MNT(mnt);
									impchq.setLieuEmission(lieuEmi);
									impchq.setDTEemission(dteEmi);
									impchq.setDTREJET(dteRejet);
									
									
									impchq.setMOTIF1(codeRejet1);
									impchq.setMOTIF2(codeRejet2);
									impchq.setMOTIF3(codeRejet3);
									impchq.setMnt2(mnt2);
									System.out.println(codeRejet1+"|"+codeRejet2+"|"+codeRejet3);
									
									
									if(codeRejet1.equalsIgnoreCase("   ")){
										if(codeRejet2.equalsIgnoreCase("   ")){
											if(codeRejet3.equalsIgnoreCase("   ")){
												impchq.setRejet(codeRejet3);
											}
											else{
												impchq.setRejet(codeRejet3);
											}
										}
										else{
											impchq.setRejet(codeRejet2);
										}
									}
									else  {
										impchq.setRejet(codeRejet1);
									}
									
									impchq.setADR_TIR(adrTire);
									
									impayeesChq.add(impchq);
									
									logger.debug( "@@@ ligne N: "+numbreofline+">>"+"[NSER="+nser+"]"+"[RIB TIRE="+zbk+loc+cpt+rib+"]" , null);	
									
								}else{
									logger.debug( "+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineIfp , null);	
									impayeesChq.clear();
									break;
									
								}
							}
						}
						
						if(impayeesChq.size()>0){
						br.close();
						new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA +"\\"+s));
						logger.debug( "=== renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".OK",null);
						}else
							{
								br.close();
								new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA + "\\" + s+".KO"));
								logger.debug( "+++ renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".KO",null);
								}
						
					}
				} catch (IOException e) {
					logger.debug( "+++ IOExeption Sur la method ReadFromCRO",e);
				}
				catch (Exception e) {
					logger.debug( "+++ Exeption Sur la method ReadFromCRO",e);
				}
				return impayeesChq;
			}
						
			public List<BeanImpChqSG> readFromProdIACHQSg(List<BeanImpChqSG> impychq,String dteTr1,String req) {
				

				try {
					
					logger.debug( "=== Lire a partir du PROD pour les valeur IA ",null);
					for (BeanImpChqSG imp : impychq) {
						Query q = emSgmachq.createNativeQuery(req,BeanImpChqSG.class);
						q.setParameter("ZBKT", imp.getBmch_ZBK());
//						q.setParameter("LOCT", imp.getBmch_LOC());
//						q.setParameter("CPTT", imp.getBmch_CPT());
						q.setParameter("mnt", imp.getMnt2());
						q.setParameter("NSER", imp.getBmch_nser());
						q.setParameter("DTETRT", dteTr1);
						
						
						List<BeanImpChqSG> foundbeanImpChq = (List<BeanImpChqSG>) q.getResultList();
						System.out.println("foundbeanImpChq "+foundbeanImpChq.size());
				        if (foundbeanImpChq.size()>0) {
				        	BeanImpChqSG beanImpChq = foundbeanImpChq.get(0);
//							BeanImpChq  beanImpChq =   (BeanImpChq) q.getSingleResult();
							
							System.out.println("beanImpChq.getBmch_PK_OBJ_IDT() "+beanImpChq.getBmch_PK_OBJ_IDT());
							System.out.println("ZBKT"+ imp.getBmch_ZBK());
							System.out.println("LOCT"+ imp.getBmch_LOC());
							System.out.println("CPTT"+ imp.getBmch_CPT());
							System.out.println("RIBT"+ imp.getBmch_rib());
							System.out.println("NSER"+ imp.getBmch_nser());
							System.out.println("DTETRT"+ dteTr1);
							System.out.println("mnt"+ imp.getMnt2());
							
								imp.setBmch_PK_OBJ_IDT(beanImpChq.getBmch_PK_OBJ_IDT());
								imp.setBmch_CPT(beanImpChq.getBmch_CPT());
								imp.setBmch_LOC(beanImpChq.getBmch_LOC());
								imp.setBmch_ZBK(beanImpChq.getBmch_ZBK());
								imp.setZBK_LIB(beanImpChq.getZBK_LIB());
								imp.setBmch_nser(beanImpChq.getBmch_nser());
								imp.setBmch_rib(beanImpChq.getBmch_rib());
								imp.setBmch_MNT(beanImpChq.getBmch_MNT());
								imp.setBmtr_AGE(beanImpChq.getBmtr_AGE());
								imp.setAGE_LIB(beanImpChq.getAGE_LIB());
								imp.setBmtr_CPT(beanImpChq.getBmtr_CPT());
								imp.setBmch_SQCA(beanImpChq.getBmch_SQCA());
								imp.setBmtn_lecteur(beanImpChq.getBmtn_lecteur());
								imp.setID_WEBCAPTUR(beanImpChq.getID_WEBCAPTUR());
								imp.setAGE_SCAN(beanImpChq.getAGE_SCAN());
								imp.setDTE_TRT(beanImpChq.getDTE_TRT());
								imp.setDTE_SORT(beanImpChq.getDTE_SORT());
								imp.setBmtr_nser(beanImpChq.getBmtr_nser());
								imp.setBmtr_mode(beanImpChq.getBmtr_mode());
								logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[bmch_nser="+imp.getBmch_nser()+" RIOINI="+imp.getRIOINI()+"]",null);

				        	 
				        }

			

					}
				} 
				catch (Exception e) {
					logger.debug( "+++ Exception Sur la method ReadFromPRODIA "+e.getMessage(),e);
				}
				return impychq;
			}
				
			@Transactional("jpaTransactionManagerlocal")
			public  List<BeanImpChqSG> loadImpysCHQSg(List<BeanImpChqSG> impys,String req) {
				List<BeanImpChqSG> Insertimpys=null;
				try {
					
					logger.debug( "=== inserer data CRO+PROD+IFPCONF dans la table IMP [" +req+" ]", null);
				
					Insertimpys=new ArrayList<BeanImpChqSG>();
					for(BeanImpChqSG imp:impys)
					{
						logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[RIOINI="+imp.getRIOINI()+"]",null);
						if(!(imp.getBmch_PK_OBJ_IDT()==null))
						{
							logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmch_PK_OBJ_IDT()+"]&&[RIOINI="+imp.getRIOINI()+"]",null);
							
							Query q = emLocal.createNativeQuery(req,BeanImpChq.class);
	System.out.println("imp.getDTE_TRT() "+imp.getDTE_TRT());
							q.setParameter(1, imp.getBmch_PK_OBJ_IDT());
							q.setParameter(2, imp.getBmch_PK_OBJ_IDT());
							q.setParameter(3, imp.getRIO());
							q.setParameter(4, imp.getRIOINI());
							q.setParameter(5, imp.getRejet());
							q.setParameter(6, imp.getADR_RMT());
							q.setParameter(7, imp.getADR_TIR());
						    q.setParameter(8, imp.getBmch_ZBK());
						    q.setParameter(9, imp.getBmtr_AGE());
						    q.setParameter(10, imp.getAGE_LIB());
						    q.setParameter(11, imp.getBmtr_CPT());
						    q.setParameter(12, imp.getBmch_CPT());
						    q.setParameter(13, imp.getDTE_TRT());
						    
						    q.setParameter(14, imp.getBmch_LOC());
						    q.setParameter(15, imp.getBmtn_lecteur());
						    q.setParameter(16, imp.getBmch_MNT());
						    q.setParameter(17, imp.getBmch_nser());
						    q.setParameter(18, imp.getBmch_SQCA());
						    q.setParameter(19, imp.getBmch_rib());
						    q.setParameter(20, imp.getRSOC_RMT());
						    q.setParameter(21, imp.getRSOC_TIRE());
						    q.setParameter(22, imp.getZBK_LIB());
						    q.setParameter(23, imp.getNOMTIRE());
						    q.setParameter(24, imp.getCIN());
						    q.setParameter(25, imp.getRC());
						    q.setParameter(26, imp.getLieuEmission());
						    q.setParameter(27, imp.getMOTIF1());
						    q.setParameter(28, imp.getMOTIF2());
						    q.setParameter(29, imp.getMOTIF3());
						    q.setParameter(30, imp.getRejet());
						    q.setParameter(31, imp.getDTREJET());
						    q.setParameter(32, imp.getDTE_TRT());
						    q.setParameter(33, imp.getDTEPRE());
						    q.setParameter(34, imp.getDTEemission());
						    q.setParameter(35, imp.getDTE_TRT());
						    q.setParameter(36, imp.getDTE_SORT());
						    q.setParameter(37, imp.getID_WEBCAPTUR());
						    q.setParameter(38, imp.getAGE_SCAN());
						    q.setParameter(39, imp.getBmtr_nser());
						    q.setParameter(40, imp.getBmtr_mode());
						    int flag=q.executeUpdate();
							logger.debug( "@@@ flag ==> "+flag);
				    if(flag==1){
				    	Insertimpys.add(imp);
				    }
					}
				    
				    }
				} 
				catch (Exception e) {
					logger.debug( "+++ Exception Sur la method NISERTDATA dans tmpo table imp",e);
				
				}
				
				return Insertimpys;
			}
			
			public  List<BeanCountImpy> getImpyChqByBqSg(String req,String trt){
				
				logger.debug("@@@ DAO : getAllImpyee SGMA ");
				
				Query q = null;
if(trt.equalsIgnoreCase("031")){
	q = emSgmachq.createNativeQuery(req,BeanCountImpy.class);
}else {
	q = emSgmalcn.createNativeQuery(req,BeanCountImpy.class);
}
				List<BeanCountImpy> CountImp = q.getResultList();
				return CountImp;
				
			}
				
			@Override
			public List<BeanImpChqSG> getAllimpayeCHQ(String req,
					String dteTrt) {
				logger.debug("@@@ DAO : getAllimpaye CHQ  "+req+" dteTrt "+dteTrt);
				Query q = emLocal.createNativeQuery(req,BeanImpChqSG.class);
				q.setParameter("date", dteTrt);
				List<BeanImpChqSG> listAllImp = q.getResultList();
				return listAllImp;
			}
			
			// ################## IMPAYEE LCN 

			public List<BeanImpLcnSG> readFromCroLCNSg(String bq) {

				String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.LCN");
				String PATTERN_CROFIL = Propriete.getInsatance().get(bq+".PATTERN.CROFILE.LCN");
				String regxBodylineCro = Propriete.getInsatance().get(bq+".PATTERN.RECORDCRO.LCN");
				
				String HeaderLine = null;
				String bodyLine = null;
				File folderInCRO = null;
				BufferedReader br=null;
				int numbreofline = 0;
				List<BeanImpLcnSG> impayeesLCN = new ArrayList<BeanImpLcnSG>();

				try {
					
					logger.debug( "=== Lire a partir du fichier .CRO LCN " , null);

						
				
					
					
						logger.debug(  "@@@ PArcourir le dossier IN  : "+IN_DIR_CRO , null);
					folderInCRO = new File(IN_DIR_CRO);
					System.out.println(IN_DIR_CRO);
					List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInCRO, PATTERN_CROFIL);
					for (String s : listCro) {
						br = new BufferedReader(new FileReader(IN_DIR_CRO + "\\" + s));
						logger.debug(  "@@@ Parser le fichier >> "+IN_DIR_CRO + "\\" + s +" ligne par ligne" , null);
						if ((HeaderLine = br.readLine()) != null) {
							
							numbreofline=numbreofline+1;
							while ((bodyLine = br.readLine()) != null) {
								numbreofline=numbreofline+1;
								if (RegexUtils.matches(bodyLine, regxBodylineCro)) {
									BeanImpLcnSG implcn = new BeanImpLcnSG();
									Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineCro);
									String rio = (String) v.get(1) + v.get(2)+ v.get(3);
									String rejet = (String) v.get(6);
									String rioini = (String) v.get(9);

									implcn.setRIOINI(rioini);
									implcn.setRIO(rio);
									implcn.setRejet(rejet);
									impayeesLCN.add(implcn);
									
							logger.debug(  "@@@ ligne N: "+numbreofline+">>"+IN_DIR_CRO +"[RIOINI="+rioini+"]"+">"+"[RIO="+rio+"]"+">"+"[CDEREJET="+rejet+"]" , null);	
									
								}else{
									logger.debug(  "+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineCro , null);	
									impayeesLCN.clear();
									break;
									
								}
							}
						}
						
						if(impayeesLCN.size()>0){
						br.close();
						new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO +"\\"+s+".OK"));
						logger.debug(  "=== renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".OK",null);
						}else
							{
								br.close();
								new File(IN_DIR_CRO + "\\" + s).renameTo(new File(IN_DIR_CRO + "\\" + s+".KO"));
								logger.debug(  "+++ renomme le fichier >>"+IN_DIR_CRO + "\\"+s+".KO",null);
								}
						
					}
				} catch (IOException e) {
					logger.debug(  "+++ IOExeption Sur la method ReadFromCROLCN"+e.getMessage(),e);
				}
				catch (Exception e) {
					logger.debug(  "+++ Exeption Sur la method ReadFromCROLCN"+e.getMessage(),e);
				}
				return impayeesLCN;
			}
			
			public  List<BeanImpLcnSG> readFromProdLCNSg(List<BeanImpLcnSG> impyslcn,String req) {
				
				

				try {
					

						
						
						logger.debug(  "=== Lire a partir du PROD LCN SGMA ",null);
						for (BeanImpLcnSG imp : impyslcn) {

							Query q = emSgmalcn.createNativeQuery(req,BeanImpLcnSG.class);
							q.setParameter("RIOINI",  imp.getRIOINI());
							System.out.println("RIOINI"+  imp.getRIOINI());
							List<BeanImpLcnSG> foundbeanImpLcn = (List<BeanImpLcnSG>) q.getResultList();
							System.out.println("foundbeanImpChq "+foundbeanImpLcn.size());
					        if (foundbeanImpLcn.size()>0) {
					        	BeanImpLcnSG beanImplcn = foundbeanImpLcn.get(0);
							logger.debug(  "@@@  [RIOINI="+imp.getRIOINI()+"]",null);
						
						
							
								imp.setBmlcn_PK_OBJ_IDT(beanImplcn.getBmlcn_PK_OBJ_IDT());
								imp.setBmlcn_CPT(beanImplcn.getBmlcn_CPT());
								imp.setBmlcn_LOC(beanImplcn.getBmlcn_LOC());
								imp.setBmlcn_ZBK(beanImplcn.getBmlcn_ZBK());
								imp.setZBK_LIB(beanImplcn.getZBK_LIB());
								imp.setBmlcn_nser(beanImplcn.getBmlcn_nser());
								imp.setBmlcn_rib(beanImplcn.getBmlcn_rib());
								imp.setBmlcn_MNT(beanImplcn.getBmlcn_MNT());
								imp.setBmtr_AGE(beanImplcn.getBmtr_AGE());
								imp.setAGE_LIB(beanImplcn.getAGE_LIB());
								imp.setBmtr_CPT(beanImplcn.getBmtr_CPT());
//								imp.setSQCA(beanImplcn.getbmch_SQCA());
								imp.setBmtn_lecteur(beanImplcn.getBmtn_lecteur());
								imp.setDTEINS(beanImplcn.getDTE_TRT());
								imp.setBmlcn_SQCA(beanImplcn.getBmlcn_SQCA());
								imp.setDTE_SORT(beanImplcn.getDTE_SORT());
								imp.setDTEEC(beanImplcn.getDTEEC());
//								imp.setDTEPRE(beanImplcn.getDTEPRE());
								imp.setID_WEBCAPTUR(beanImplcn.getID_WEBCAPTUR());
								imp.setAGE_SCAN(beanImplcn.getAGE_SCAN());
								imp.setNSER_REM(beanImplcn.getNSER_REM());
								
								imp.setMODE_REM(beanImplcn.getMODE_REM());
								
								logger.debug(  "@@@  [PK_OBJ_IDT="+imp.getBmlcn_PK_OBJ_IDT()+"]&&[bmlcn_nser="+imp.getBmlcn_nser()+"] "+beanImplcn.getAGE_SCAN(),null);

							}

					}
					
					
				} 
		   
				catch (Exception e) {
					logger.debug(  "+++ Exception Sur la method ReadFromPRODLCN "+e.getMessage(),e);
				}

				return impyslcn;
			}
					
			public  List<BeanImpLcnSG> readFromIFPConfLCNSg(List<BeanImpLcnSG> impylcn,String bq) {
				// IFP
				String IN_DIR_CRO = Propriete.getInsatance().get(bq+".INDIR.CRO.LCN");
				String IN_DIR_IFP = Propriete.getInsatance().get(bq+".INDIR.IFPCONF.LCN");
				String PATTERN_IFP_FIL = Propriete.getInsatance().get(bq+".PATTERN.IFPCONFFILE.LCN");
				String regxBodyIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.CONF.LCN");
				File folderInIFP = null;
				BufferedReader br;
				String HeaderLine;
				String bodyLine;
				boolean renomeFile = false;
				boolean errorFile = false;
				int numbreofline = 0;

				try {
					
					logger.debug(  "=== Lire a partir du fichiers .IFP " , null);
					logger.debug(  "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP , null);
					folderInIFP = new File(IN_DIR_IFP);
//					impayeesChq = new ArrayList<impayeChqBpm>();
					List<String> listIfp = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFP_FIL);
					for (String s : listIfp) {
						br = new BufferedReader(new FileReader(IN_DIR_IFP + "\\" + s));
						logger.debug(  "=== parser le fichier  : "+IN_DIR_IFP + "\\" + s , null);
						HeaderLine = br.readLine();
						if ((HeaderLine != null)&& (RegexUtils.matches(HeaderLine,"(^MCNP)([0-9]{10})$"))) {
							renomeFile = true;
							numbreofline=numbreofline+1;
							while ((bodyLine = br.readLine()) != null) {
								if (RegexUtils.matches(bodyLine, regxBodyIfp)) {
									Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodyIfp);
									numbreofline=numbreofline+1;
									for (BeanImpLcnSG imp : impylcn) {
										String rioini = (String) v.get(5);
										if (imp.getRIOINI().equalsIgnoreCase(rioini)) {
											logger.debug(  "=== mapping de la ligne N "+numbreofline+" avec le RIOINI : "+rioini , null);
											String nomTire = (String) v.get(8);
											String cin = (String) v.get(9);
											String rc = (String) v.get(10);
											String lieuEmi = (String) v.get(13);
											String dteEmi = (String) v.get(14);
											String dteRejet = (String) v.get(15);
											String codeRejet1 = (String) v.get(16);
											String codeRejet2 = (String) v.get(17);
											String codeRejet3 = (String) v.get(18);
											String adrTire = (String) v.get(19);
											imp.setNOMTIRE(nomTire);
											imp.setCIN(cin);
											imp.setRC(rc);
											imp.setLieuEmission(lieuEmi);
											imp.setDTEemission(dteEmi);
											imp.setDTREJET(dteRejet);
											imp.setMOTIF1(codeRejet1);
											imp.setMOTIF2(codeRejet2);
											imp.setMOTIF3(codeRejet3);
											imp.setAdresseTire(adrTire);
										}
									}
									
									errorFile=true;
								}
								else{
									logger.debug(  "+++ la ligne N "+numbreofline+" ne respect pas le pattern: "+regxBodyIfp , null);	
									
								}
							}
						}
						if (renomeFile) {
							br.close();
							
							new File((IN_DIR_IFP + "\\" + s)).renameTo(new File((IN_DIR_CRO + "\\" + s )));
							logger.debug(  "=== renomme le fichier >>"+IN_DIR_IFP +"\\" + s + ".LCN",null);

						}
					}
				} catch (IOException e) {
					logger.debug(  "+++ IOException Sur la method ReadFromIFPCONF "+e.getMessage(),e);
				}
				catch (Exception e) {
					logger.debug(  "+++ Exception Sur la method ReadFromIFPCONF "+e.getMessage(),e);
				}
				return impylcn;

			}
					
			 @Transactional("jpaTransactionManagerlocal")
			public  List<BeanImpLcnSG> loadImpysLCNSg(List<BeanImpLcnSG> impys,String req) {
					List<BeanImpLcnSG> Insertimpys=null;
					try {
					
						logger.debug( "=== inserer les données mapping a partir du fichier CRO+PROD+IFPCONF dans la table IMP LCN SGMA"+req , null);
						
						Insertimpys=new ArrayList<BeanImpLcnSG>();
						String REQ_INSERT_DATA_IMP=req;//"BPM.REQ.ADDIMP.LCN";
						
						logger.debug("@@@ execute la requete "+REQ_INSERT_DATA_IMP , null);
						System.out.println(impys.size());
						for(BeanImpLcnSG imp:impys){
							System.out.println(imp.getBmlcn_PK_OBJ_IDT());
			  		if((imp.getBmlcn_PK_OBJ_IDT()!=null)){
							logger.debug( "@@@  [PK_OBJ_IDT="+imp.getBmlcn_PK_OBJ_IDT()+"]&&[RIOINI="+imp.getRIOINI()+"]",null);
							Query q = emLocal.createNativeQuery(req,BeanImpLcnSG.class);
//							REF,PK_OBJ_IDT,RIO,RIOINI,REJET,ADR_RMT,ADR_TIR,ZBKT,AGE_RMT,AGE_RMT_LIB,CPT,CPTT,DTEREG,LOCT,MEM2,MNT,NSER,SQCA,RIBT,RSOC_RMT,RSOC_TIRE,ZBK_lib,NOMTIRE,CIN,RC,lieuEmission,MOTIF1,MOTIF2,MOTIF3,REJET_LIB,DTREJET,DTEINS,DTEPRE,DTEemission,DTETRT,DTE_SORT,DTEEC,ID_WEBCAPTUR,AGE_SCAN
							q.setParameter(1, imp.getBmlcn_PK_OBJ_IDT());
						    q.setParameter(2, imp.getBmlcn_PK_OBJ_IDT());
						    q.setParameter(3, imp.getRIO());
						    q.setParameter(4, imp.getRIOINI());
							q.setParameter(5, imp.getRejet());
						    q.setParameter(6, imp.getADR_RMT());
						    q.setParameter(7, imp.getAdresseTire());
						    q.setParameter(8, imp.getBmlcn_ZBK());
						    q.setParameter(9, imp.getBmtr_AGE());
						    q.setParameter(10, imp.getAGE_LIB());
						    q.setParameter(11, imp.getBmtr_CPT());
						    q.setParameter(12, imp.getBmlcn_CPT());
						    q.setParameter(13, imp.getDTEPRE());
						    q.setParameter(14, imp.getBmlcn_LOC());
						    q.setParameter(15, imp.getBmtn_lecteur());
						    q.setParameter(16, imp.getBmlcn_MNT());
						    q.setParameter(17, imp.getBmlcn_nser());
						    q.setParameter(18, imp.getBmlcn_SQCA());
						    q.setParameter(19, imp.getBmlcn_rib());
						    q.setParameter(20, imp.getRSOC_RMT());
						    q.setParameter(21, imp.getRSOC_TIRE());
						    q.setParameter(22, imp.getZBK_LIB());
						    q.setParameter(23, imp.getNOMTIRE());
						    q.setParameter(24, imp.getCIN());
						    q.setParameter(25, imp.getRC());
						    q.setParameter(26, imp.getLieuEmission());
						    q.setParameter(27, imp.getMOTIF1());
						    q.setParameter(28, imp.getMOTIF2());
						    q.setParameter(29, imp.getMOTIF3());
						    q.setParameter(30, imp.getRejet());
						    q.setParameter(31, imp.getDTREJET());
						    q.setParameter(32, imp.getDTEINS());
						    q.setParameter(33, imp.getDTEPRE());
						    q.setParameter(34, imp.getDTEemission());
						    q.setParameter(35, imp.getDTE_TRT());
						    q.setParameter(36, imp.getDTE_SORT());
						    q.setParameter(37, imp.getDTEEC());
						    q.setParameter(38, imp.getID_WEBCAPTUR());
						    q.setParameter(39, imp.getAGE_SCAN());
						    q.setParameter(40, imp.getNSER_REM());
						    q.setParameter(41, imp.getMODE_REM());
					    int i=q.executeUpdate();
					    if(i==1){
					    	Insertimpys.add(imp);
					    }
						}
					    
					    }
					} 
					catch (Exception e) {
						logger.debug( "+++ Exception Sur la method INISERTDATA dans tmpo table imp LCN"+e.getMessage(),e);
						e.printStackTrace();
					}
					
					return Insertimpys;
				}
			    
			public  List<BeanImpLcnSG> readFromIFPIALCNSg(String bq) {
					String IN_DIR_IFP_IA = Propriete.getInsatance().get(bq+".INDIR.IFPIA.LCN");
					String PATTERN_IFPIAFIL = Propriete.getInsatance().get(bq+".PATTERN.IFPIAFILE.LCN");
					String regxBodylineIfp = Propriete.getInsatance().get(bq+".PATTERN.RECORDIFP.IA.LCN");
//							"(^[0-9]{3})([0-9]{3})(.{3})([0-9]{3})([0-9]{3})([0-9]{16})([0-9]{2})(.{32})(.{32})([0-9]{3})(.{50})(.{10})(.{20})([0-9]{7})([0-9]{15})(.{20})([0-9]{8})([0-9]{8})(.{3})(.{3})(.{3})(.{100})";
					String HeaderLine = null;
					String bodyLine = null;
					File folderInIFP = null;
					BufferedReader br;
					int numbreofline = 0;
					List<BeanImpLcnSG> impayeesLcn = new ArrayList<BeanImpLcnSG>();

					try {
						
						logger.debug(  "=== Lire a partir du fichier .IFP IA " , null);
						logger.debug(  "@@@ PArcourir le dossier IN  : "+IN_DIR_IFP_IA , null);
						folderInIFP = new File(IN_DIR_IFP_IA);
						List<String> listCro = DirUtils.readDirEndGetEligibleFile(folderInIFP, PATTERN_IFPIAFIL);
						if(listCro!=null){
						for (String s : listCro) {
							br = new BufferedReader(new FileReader(IN_DIR_IFP_IA + "\\" + s));
							logger.debug(  "@@@ Parser le fichier >> "+IN_DIR_IFP_IA + "\\" + s +" ligne par ligne" , null);
							if ((HeaderLine = br.readLine()) != null) {
								
								numbreofline=numbreofline+1;
								while ((bodyLine = br.readLine()) != null) {
									numbreofline=numbreofline+1;
									if (RegexUtils.matches(bodyLine, regxBodylineIfp)) {
										
										
										BeanImpLcnSG implcn = new BeanImpLcnSG();
										Vector v = RegexUtils.getGroupesCapture(bodyLine,regxBodylineIfp);
										String zbk=(String) v.get(4);
										String loc=(String) v.get(5);
										String cpt=(String) v.get(6);
										String rib=(String) v.get(7);
										String rioini=(String) v.get(8);
										String rio=(String) v.get(9);
										String nomTire=(String) v.get(11);
									    String cin=(String) v.get(12);
									    String rc=(String) v.get(13);
									    String nser=(String) v.get(14);
									    String mnt=(String) v.get(15);
									    String lieuEmi=(String) v.get(16);
									    String dteEmi=(String) v.get(17);
									    String dteRejet=(String) v.get(18);
									    String codeRejet1=(String) v.get(19);
									    String codeRejet2=(String) v.get(20);
									    String codeRejet3=(String) v.get(21);
									    String adrTire=(String) v.get(22);
									    String mnt2=formatMnt(mnt);
									    implcn.setBmlcn_ZBK(zbk);
									    implcn.setBmlcn_LOC(loc);
									    implcn.setBmlcn_CPT(cpt);
									    implcn.setBmlcn_rib(rib);
										implcn.setRIOINI(rioini);
										implcn.setRIO(rio);
										implcn.setNOMTIRE(nomTire);
										implcn.setCIN(cin);
										implcn.setRC(rc);
										implcn.setBmlcn_nser(nser);
										implcn.setBmlcn_MNT(formatMnt(mnt));
										implcn.setLieuEmission(lieuEmi);
										implcn.setDTEemission(dteEmi);
										implcn.setDTREJET(dteRejet);
										
										
										implcn.setMOTIF1(codeRejet1);
										implcn.setMOTIF2(codeRejet2);
										implcn.setMOTIF3(codeRejet3);
										implcn.setMnt2(mnt2);
//										System.out.println(codeRejet1+"|"+codeRejet2+"|"+codeRejet3);
										
										if(codeRejet1.equalsIgnoreCase("   ")){
											if(codeRejet2.equalsIgnoreCase("   ")){
												if(codeRejet3.equalsIgnoreCase("   ")){
													implcn.setRejet("000");
												}
												else{
													implcn.setRejet(codeRejet3);
												}
											}
											else{
												implcn.setRejet(codeRejet2);
											}
										}
										else  {
											implcn.setRejet(codeRejet1);
										}
										
										implcn.setAdresseTire(adrTire);
										
										impayeesLcn.add(implcn);
										
								logger.debug(  "@@@ ligne N: "+numbreofline+">>"+"[NSER="+nser+"]"+"[RIB TIRE="+zbk+"-"+loc+"-"+cpt+"-"+rib+"]" , null);	
										
									}else{
										logger.debug(  "+++ ligne N: "+numbreofline+">> ["+bodyLine+"] ne Respect pas le pattern"+regxBodylineIfp , null);	
//										impayeesLcn.clear();
//										break;
										
									}
								}
							}
						
							if(impayeesLcn.size()>0){
							br.close();
							new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA +"\\"+s+".OK"));
							logger.debug(  "=== renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".OK",null);
							}else
								{
									br.close();
									new File(IN_DIR_IFP_IA + "\\" + s).renameTo(new File(IN_DIR_IFP_IA + "\\" + s+".KO"));
									logger.debug(  "+++ renomme le fichier >>"+IN_DIR_IFP_IA + "\\"+s+".KO",null);
									}
							
						}
						}
					} catch (IOException e) {
						logger.debug(  "+++ IOExeption Sur la method readFromIFPIALCN "+e.getMessage(),e);
					}
					catch (Exception e) {
						logger.debug(  "+++ Exeption Sur la method readFromIFPIALCN "+e.getMessage(),e);
					}
					return impayeesLcn;
				}
			 
			public  List<BeanCountImpy> getImpyByBqSg(String req,String trt){
				 Query q =null;
					logger.debug("@@@ DAO : getAllImpyee  "+trt);
//					if(trt.equals("031")){
//					q = emLocal.createNativeQuery(req,BeanCountImpy.class);
//					}
					q = emLocal.createNativeQuery(req,BeanCountImpy.class);
//					else {
//						q = emSgmalcn.createNativeQuery(req,BeanCountImpy.class);
//						
//					}
					List<BeanCountImpy> CountImp = q.getResultList();
					return CountImp;
					
				}
			 
			public  List<BeanImpLcnSG> readFromProdIALCNSg(List<BeanImpLcnSG> impysLcn,String dteSort,String req) {
					

					try {
						
						logger.debug(  "=== Lire a partir du PROD pour les valeur IA SGMA "+req,null);
						for (BeanImpLcnSG imp : impysLcn) {

							Query q = emSgmalcn.createNativeQuery(req,BeanImpLcnSG.class);
//							q.setParameter("RIOINI",  imp.getRIOINI());
							q.setParameter("ZBKT", imp.getBmlcn_ZBK());
//							q.setParameter("LOCT", imp.getBmlcn_LOC());
//							q.setParameter("CPTT", imp.getBmlcn_CPT());
//							q.setParameter("RIBT", imp.getBmlcn_rib());
							q.setParameter("NSER", imp.getBmlcn_nser());
							q.setParameter("mnt", imp.getMnt2());
							q.setParameter("DTESORT", dteSort);
							
							
							System.out.println("RIOINI"+  imp.getBmlcn_ZBK()+imp.getBmlcn_LOC()+imp.getBmlcn_CPT()+imp.getBmlcn_rib()+imp.getBmlcn_nser()+dteSort);
							List<BeanImpLcnSG> foundbeanImpLcn = (List<BeanImpLcnSG>) q.getResultList();
							System.out.println("foundbeanImpLCN IA  "+foundbeanImpLcn.size());
					        if (foundbeanImpLcn.size()>0) {
					        	BeanImpLcnSG beanImplcn = foundbeanImpLcn.get(0);
							logger.debug(  "@@@  [RIOINI="+imp.getRIOINI()+"]",null);
						
						
							
								imp.setBmlcn_PK_OBJ_IDT(beanImplcn.getBmlcn_PK_OBJ_IDT());
								imp.setBmlcn_CPT(beanImplcn.getBmlcn_CPT());
								imp.setBmlcn_LOC(beanImplcn.getBmlcn_LOC());
								imp.setBmlcn_ZBK(beanImplcn.getBmlcn_ZBK());
								imp.setZBK_LIB(beanImplcn.getZBK_LIB());
								imp.setBmlcn_nser(beanImplcn.getBmlcn_nser());
								imp.setBmlcn_rib(beanImplcn.getBmlcn_rib());
								imp.setBmlcn_MNT(beanImplcn.getBmlcn_MNT());
								imp.setBmtr_AGE(beanImplcn.getBmtr_AGE());
								imp.setAGE_LIB(beanImplcn.getAGE_LIB());
								imp.setBmtr_CPT(beanImplcn.getBmtr_CPT());
								imp.setBmlcn_SQCA(beanImplcn.getBmlcn_SQCA());
								imp.setBmtn_lecteur(beanImplcn.getBmtn_lecteur());
								imp.setDTEINS(beanImplcn.getDTE_TRT());
								
								imp.setDTE_SORT(beanImplcn.getDTE_SORT());
								imp.setDTEEC(beanImplcn.getDTEEC());
								imp.setDTEPRE(beanImplcn.getDTEPRE());
								imp.setID_WEBCAPTUR(beanImplcn.getID_WEBCAPTUR());
								imp.setAGE_SCAN(beanImplcn.getAGE_SCAN());
								imp.setMODE_REM(beanImplcn.getMODE_REM());
								logger.debug(  "@@@  [PK_OBJ_IDT="+imp.getBmlcn_PK_OBJ_IDT()+"]&&[bmlcn_nser="+imp.getBmlcn_nser()+"]",null);

							}

							
							logger.debug(  "@@@  execute la requete ["+req+"]",null);
							
//							
							}
						
					} 
					catch (Exception e) {
						logger.debug(  "+++ Exception Sur la method ReadFromPRODIALCN "+e.getMessage(),e);
					
					}
					return impysLcn;
				}
			
			@Override
			public List<BeanImpLcnSG> getAllimpayeLcn(String req,
					String dteTrt) {
				logger.debug("@@@ DAO : getAllimpaye  "+req);
				Query q = emLocal.createNativeQuery(req,BeanImpLcnSG.class);
				q.setParameter("date", dteTrt);
				List<BeanImpLcnSG> listAllImp = q.getResultList();
				return listAllImp;
			}
		
			// ################## FICHIER RECO 
			
			@Override
			public List<RecordRemise> getRecordRemRec(String req, String trt,String dteIns) {
				logger.debug("@@@ DAO : getRecordRemRec  "+req);
				Query q = emLocal.createNativeQuery(req,RecordRemise.class);
				q.setParameter("date", dteIns);
				List<RecordRemise> listRecordsRemise = q.getResultList();
				
				return listRecordsRemise;
			}
	
			@Override
			public List<RecordValue> getRecordValuesRec(String req, String trt,String pkobjidtRem,String dteIns) {
				logger.debug("@@@ DAO : getRecordValuesRec  "+req);
				Query q = emLocal.createNativeQuery(req,RecordValue.class);
				q.setParameter("date", dteIns);
				q.setParameter("pkobjidRem", pkobjidtRem);
				List<RecordValue> RecordValue = q.getResultList();
				return RecordValue;
			}
									
//			edit Report SGMA 
			
			@Override
			public List<BeanPcapt> getAllPcapt(String Req) {
				logger.debug("@@@ DAO : getAllPcaptSGMA  "+Req);
				Query q = emLocal.createNativeQuery(Req,BeanPcapt.class);
				List<BeanPcapt> BeanPcapt = q.getResultList();
				return BeanPcapt;
			}
			
			
			@Override
			public List<BeanPcapt> getDistinctCircuit(String req) {
				logger.debug("@@@ DAO : getDistinctCircuitSGMA  "+req);
				Query q = emLocal.createNativeQuery(req,BeanPcapt.class);
				List<BeanPcapt> BeanPcapt = q.getResultList();
				return BeanPcapt;
			}
			@Override
			public List<BeanPcapt> getGetPcaptByCde(String req,List<String> cde) {
				logger.debug("@@@ DAO : getGetPcaptByCdeSGMA  "+req);
				Query q = emLocal.createNativeQuery(req,BeanPcapt.class);
				q.setParameter("cde", cde);
				List<BeanPcapt> BeanPcapt = q.getResultList();
				return BeanPcapt;
			}
			
						
			@Override
			public List<BeanTrt> getGetTrtByCde(String req,List<String> cde) {
				logger.debug("@@@ DAO : getGetTrtByCdeSGMA  "+req);
				Query q = emLocal.createNativeQuery(req,BeanTrt.class);
				q.setParameter("nom_Traitement", cde);
				List<BeanTrt> BeanTrt = q.getResultList();
				return BeanTrt;
			}
		
			@Override
	        public List<BeanTrt> getAlltrt(String Req) {
				logger.debug("@@@ DAO : getAlltrtSGMA  "+Req);
				Query q = emLocal.createNativeQuery(Req,BeanTrt.class);
				List<BeanTrt> BeanTrt = q.getResultList();
				return BeanTrt;
			}	
		
		   @Override
		    
			public List<BeanReport> getReportByTrt(String Req,int idT) {
			logger.debug("@@@ DAO : getReportByTrtSGMA  "+Req+" "+idT);
			Query q = emLocal.createNativeQuery(Req,BeanReport.class);
			
			q.setParameter("idT", idT);
			List<BeanReport> BeanReport = q.getResultList();
			return BeanReport;
		}	
			
			public Connection getConnectionLocal(){
			Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 connection = DriverManager.getConnection("jdbc:mysql://172.17.0.4:3306", "root", "fast");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			java.sql.Connection connection = emLocal.unwrap(java.sql.Connection.class);
			
			return connection;
		}

			@Override
			public List<BeanImpChqSG> getAllImpayeChqSg(String req, 
					String dteTrt) {
				logger.debug("@@@ DAO : getAllImpayeChqSg  "+req);
				Query q = emLocal.createNativeQuery(req,BeanImpChqSG.class);
				q.setParameter("date", dteTrt);
				List<BeanImpChqSG> RecordimpayeChqSg = q.getResultList();
				return RecordimpayeChqSg;
			}
			
			@Override
			public List<BeanImpLcnSG> getAllImpayeLcnSg(String req, String dteTrt) {
				logger.debug("@@@ DAO : getAllImpayeLcnSg  "+req+"-- "+dteTrt);
				Query q = emLocal.createNativeQuery(req,BeanImpLcnSG.class);
				q.setParameter("date", dteTrt);
				List<BeanImpLcnSG> RecordimpayeLcnSg = q.getResultList();
				return RecordimpayeLcnSg;
			}
		
		
			@Transactional("jpaTransactionManagerlocal")
			public int AddPcapt(BeanPcapt p,String req) {
				// TODO Auto-generated method stub			
				logger.debug("@@@ DAO : AddPcapt SGMA");
				Query q = emLocal.createNativeQuery(req,BeanPcapt.class);
				q.setParameter(1, p.getCdePcapt());
				q.setParameter(2, p.getNomPcapt());
				q.setParameter(3, p.getType());
				q.setParameter(4, p.getAgeRattachement());
				q.setParameter(5, p.getSecteur());
				q.setParameter(6, p.getCircuit());
				int flag=q.executeUpdate();
				return flag;
			}

			@Transactional("jpaTransactionManagerlocal")
			public int UpdatePcapt(int idpcapt,BeanPcapt p, String req) {
				logger.debug("@@@ DAO : Modifier Pcapt : "+p.getCdePcapt()+""+req );
				Query q = emLocal.createNativeQuery(req);
//				q.setParameter("Date", dteTr);
				q.setParameter(1, p.getCdePcapt());
				q.setParameter(2, p.getNomPcapt());
				q.setParameter(3, p.getType());
				q.setParameter(4, p.getAgeRattachement());
				q.setParameter(5, p.getSecteur());
				q.setParameter(6, p.getCircuit());
				q.setParameter(7, idpcapt);
//				cdePcapt=?,Lib=?,type=?,active=?,cdeAge=?,secteur=?,circuit=? where idpcapt=?
				int flag=q.executeUpdate();
				return flag;
			}

			@Transactional("jpaTransactionManagerlocal")
			public int DeletePcapt(int idpcapt,String req) {
				Query q = emLocal.createNativeQuery(req);
				q.setParameter(1, idpcapt);
				int flag=q.executeUpdate();
				return flag;
			}

			@Transactional("jpaTransactionManagerlocal")
			public int purgetableEta(String req) {
				Query q = emLocal.createNativeQuery(req);
				int flag=q.executeUpdate();
				return flag;
				
			}

			

		

			

		

		
			 
}
