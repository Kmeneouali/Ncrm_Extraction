package com.ncrm.metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ncrm.SprBatch.sgma.impayeChqSg;
import com.ncrm.dao.entities.BaaSilcnRecord;
import com.ncrm.dao.entities.BeanAgence;
import com.ncrm.dao.entities.BeanCompte;
import com.ncrm.dao.entities.BeanCountImpy;
import com.ncrm.dao.entities.BeanCountpye;
import com.ncrm.dao.entities.BeanDetailSuiviPhysique;
import com.ncrm.dao.entities.BeanImpChq;
import com.ncrm.dao.entities.BeanImpChqSG;
import com.ncrm.dao.entities.BeanImpLcn;
import com.ncrm.dao.entities.BeanImpLcnSG;
import com.ncrm.dao.entities.BeanPcapt;
import com.ncrm.dao.entities.BeanReport;
import com.ncrm.dao.entities.BeanSuiviPhysique;
import com.ncrm.dao.entities.BeanTrt;
import com.ncrm.dao.entities.RecordLotChq;
import com.ncrm.dao.entities.RecordLotLcn;
import com.ncrm.dao.entities.RecordRemChq;
import com.ncrm.dao.entities.SiChqRecord;
import com.ncrm.dao.entities.SilcnRecord;
import com.ncrm.dao.entities.beanScann;
import com.ncrm.dao.entities.rec.RecordRemise;
import com.ncrm.dao.entities.rec.RecordValue;
import com.ncrm.library.utils.RegexUtils;
import com.ncrm.library.utils.beans.Journal;

public interface Imetier {
	
//	################################################################################
			//		EXTRACTION SI LCN 
//###################################################################################
	public SilcnRecord formatChampsSILCN(String bq,String dteTr);
	public boolean createSiLCN(String bq,String dteTr,SilcnRecord silcnRecord);
		
//	################################################################################
			//		EXTRACTION SI CHQ 
//###################################################################################
	
	public List<RecordRemChq> formatChampsSIChq(String bq,String dteTr);
	public boolean createSiChq(String bq,String dteTr, List<RecordRemChq> recordsRemChq);
	
	public List<RecordRemChq> getAllRemChqTraiterFlager(String bq);
	public List<RecordRemChq> getRemChqTraiterFlagerByDte(String bq,String dteTr);

//	################################################################################
			//		EXTRACTION LOT CHQ 
//###################################################################################
	
	public List<RecordLotChq> formatChampsLotChq(String dteTr,String bq);
	public boolean createLotChq(String bq,String dteTr, List<RecordLotChq> recordsRemChq);
	
	
//	################################################################################
			//		EXTRACTION LOT LCN 
//###################################################################################
	
	public List<RecordLotLcn> formatChampsLotLcn(String ConfIA,String dtePr,String bq);
	public boolean createLotLCN(String bq,String ConfIA,String dtepre, List<RecordLotLcn> recordsLotLcn);
	
	
//	################################################################################
			//		EXTRACTION ETA CHQ/LCN
//###################################################################################
	
	public int extractDataEta(String bq,String tr,String dteTr);
	public int getCountValueTraitedSgma(String bq,String tr,String dteTr);
	public String getAnomalie(String bq,String cdeTr,String PK_ANO_MNE) ;
	
//	################################################################################
			//		CONSULTATION CPT & AGE & SCANNER
//###################################################################################	
	public List<BeanCompte> getAllComptes(String bq);
	
	public int AddCpt(List<BeanCompte> listCpt,String bq);
	public int DeleteAllCpts(String bq);
	
	public List<BeanAgence> getAllAgences(String bq);
	public BeanAgence getagebycde(String cdeAge,String bq);
	
	public int AddAge(String bq,BeanAgence age) ;
	public int DeleteAge(String idage,String req);
	
	public List<beanScann> getScannerByage(String cdeAge,String bq);
	public int AddScanner(beanScann sc,String bq);
	
//	################################################################################
			//		EXTRACTION IMPY CHQ
//###################################################################################	
	public List<BeanImpChq> readFromCroCHQ(String bq);
	public List<BeanImpChq> readFromProdCHQ(List<BeanImpChq> impyschq,String bq);
	public List<BeanImpChq> readFromIFPConfCHQ(String bq,List<BeanImpChq> impychq);
	
	public  List<BeanImpChq> readFromIFPIACHQ(String bq);
	public List<BeanImpChq> readFromProdIACHQ(List<BeanImpChq> impychq,String dteTr1,String bq);
	
	public  List<BeanImpChq> loadImpysCHQ(List<BeanImpChq> impys,String bq);
	public  List<BeanCountImpy> getImpyChqByBq(String bq);
	
//	################################################################################
			//		EXTRACTION IMPY LCN
//###################################################################################	
	public List<BeanImpLcn> readFromCroLCN(String bq);
	public  List<BeanImpLcn> readFromProdLCN(List<BeanImpLcn> impyslcn,String bq);
	public  List<BeanImpLcn> readFromIFPConfLCN(List<BeanImpLcn> impylcn,String bq);

	public  List<BeanImpLcn> readFromIFPIALCN(String bq);
	public  List<BeanImpLcn> readFromProdIALCN(List<BeanImpLcn> impysLcn,String dteSort,String bq);

	public  List<BeanImpLcn> loadImpysLCN(List<BeanImpLcn> impys,String bq);
	public  List<BeanCountImpy> getImpyLcnByBq(String bq);
	
	public  boolean chargertableimpaye(String bq, String cdeTr,String dteTrt);
	
	
	
	
	
	
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  /* SGMA*/	   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
//	#### IMPAYEE CHEQUE 
	
	public List<BeanImpChqSG> readFromCroCHQSg(String bq);
	public List<BeanImpChqSG> readFromProdCHQSg(List<BeanImpChqSG> impyschq,String req) ;
	public List<BeanImpChqSG> readFromIFPConfCHQSg(String bq,List<BeanImpChqSG> impychq);
	
	public  List<BeanImpChqSG> readFromIFPIACHQSg(String bq);
	public List<BeanImpChqSG> readFromProdIACHQSg(List<BeanImpChqSG> listimpayIAChq, String formatDateTostirng,String lblBq);
	
	public  List<BeanImpChqSG> loadImpysCHQSg(List<BeanImpChqSG> impys,String req);
	public  List<BeanImpChqSG> getAllimpayeCHQ(String bq, String dteTrt);
	public List<BeanImpChqSG> getAllImpayeChqSg(String bq, String dteTrt);
	public void createRCImpy(List<BeanImpChqSG> listImpay,String dteTrt,String nameFile);
//	#### IMPAYEE LCN 
	
	public List<BeanImpLcnSG> readFromCroLCNSg(String bq);
	public  List<BeanImpLcnSG> readFromProdLCNSg(List<BeanImpLcnSG> impyslcn,String req);
	public  List<BeanImpLcnSG> readFromIFPConfLCNSg(List<BeanImpLcnSG> impylcn,String req);
	
	public  List<BeanImpLcnSG> readFromIFPIALCNSg(String bq);
	public  List<BeanImpLcnSG> readFromProdIALCNSg(List<BeanImpLcnSG> impysLcn,String dteSort,String req);
	
	public  List<BeanImpLcnSG> loadImpysLCNSg(List<BeanImpLcnSG> impys,String req);
	
	public  List<BeanImpLcnSG> getAllimpayeLCN(String bq, String dteTrt);
	public List<BeanCountImpy> getImpyByBq(String bq,String trt);
	List<BeanImpLcnSG> getAllImpayeLcnSg(String bq, String dteTrt);
	public void createRCImpyLcn(List<BeanImpLcnSG> listImpay,String dteTrt,String nameFile);
//	###### LISTE DEROULANTE PARTIE WEB 
	
	public List<BeanPcapt> getAllPcapt(String bq);
	public List<BeanPcapt> getGetPcaptByCde(String bq,List<String> cde);
	public List<BeanTrt> getAlltrt(String bq,String trt);
	public List<BeanTrt> getGetTrtByCde(String bq,List<String> cde);
	public List<BeanReport> getReportByTrt(String bq,int idT);
	
	int AddPcapt(BeanPcapt p, String bq);
	public int updatePcapt(int idpcapt, BeanPcapt pcapt,String bq);
	public int deletePcapt(int idpcapt,String bq);
	public List<BeanPcapt> getDistinctCircuitSGMA(String bq);
//	#####  Edition de fichier de Reconciliation 
	
	public List<RecordRemise> getRecordRemRec(String bq,String trt,String dteIns);
	public List<RecordValue> getRecordValuesRec(String bq,String trt,String pkobjidtRem,String dteIns);
	List<RecordRemise> formatageChamps(List<RecordRemise> listeRemises,String dteInstance);
	List<RecordRemise> createFileRec(List<RecordRemise> listeRemises,String nameFile, String header, String cdeTr);
	
//	#####  Edition des etats PDF 
	int purgetableEta(String bq,String trt);
	void ReportPdf(String templateJrxml, Map<String, Object> params,Connection dataSource, String outputEnreg, String NameFile) throws FileNotFoundException, JRException, SQLException;
	
	String ReportPdf2(String templateJrxml, Map<String, Object> params,
			Connection dataSource, String outputEnreg, String NameFile);
	
	public Connection geconnectionlocal();
	
	
	
//	#### SUIVI PHYSIQUE
	
	int extractData4Suvi(String bq, String trt, String dtetrt1, String dteTrt2,String listPcapts);
	public List<BeanSuiviPhysique> getRecupFluxphysique(String bq,String trt) ;
	public List<BeanDetailSuiviPhysique> getDetailFluxphysique(String bq,String trt) ;
	public int updateValideFluxphysique(String bq,String listPcapts,String listdte,String trt,String username);
	public int synchronImpayeLCNFluxphysique(String bq);
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    		  /* BAA */	   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
//	####################################
			//		EXTRACTION SI LCN BAA
//#######################################
	public BaaSilcnRecord formatChampsSILCNBaa(String bq,String dteTr);
	public boolean createSiLCNBaa(String bq,String dteTr,BaaSilcnRecord silcnRecord);
	
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             /* CFG */	   
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public boolean receptionFichierPayer(String lblbq,String trt);
	public void createFileSuiviPhysique(String bq,String trt,String listDte,String listPcapts,String IDuser,String dtePre);
	public List<BeanCountpye> getCountValue(String bq,String trt);

	
	
	
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /* BMCE*/	   
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public List<Object[]> gettr_prfBMCE();
	public int Addta_prf_optBMCE(String pk);
	public List<Object[]> getopePrf();
	
	

	
	

	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	

	
	
	
	
}
