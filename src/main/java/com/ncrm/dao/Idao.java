package com.ncrm.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

import com.ncrm.SprBatch.sgma.impayeChqSg;
import com.ncrm.dao.entities.BaaRecordLCN;
import com.ncrm.dao.entities.BaaRecordRemLCN;
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
import com.ncrm.dao.entities.Page;
import com.ncrm.dao.entities.RecordChq;
import com.ncrm.dao.entities.RecordLCN;
import com.ncrm.dao.entities.RecordLotChq;
import com.ncrm.dao.entities.RecordLotLcn;
import com.ncrm.dao.entities.RecordPaidValue;
import com.ncrm.dao.entities.RecordRemChq;
import com.ncrm.dao.entities.RecordRemLCN;
import com.ncrm.dao.entities.Role;
import com.ncrm.dao.entities.User;
import com.ncrm.dao.entities.beanScann;
import com.ncrm.dao.entities.rec.RecordRemise;
import com.ncrm.dao.entities.rec.RecordValue;

public interface Idao {


//	######################################################################################
			//	########## BANQUE PARTICIPATIVES (QMB,BPM) 	##########
//	######################################################################################
//  ~~~~~~~~~~~~~~~~~~~~
//	EDITION SI 
//	~~~~~~~~~~~~~~~~~~~
	
/** Traitement chèques  */	
	
	public List<RecordRemChq> getRemChqTraiter(String dteTr,String Req);
	public List<RecordChq> getChqTraited(String dteTr,String pk_obj_id_Rem,String Req);
	public int UpdateExt(String pk_obj_id_Rem,String Req);
	
	public List<RecordRemChq> getAllRemChqTraiterFlager(String Req);
	public List<RecordRemChq> getRemChqTraiterFlagerByDte(String dteTr,String Req);
	
/** Traitement LCN  */		

public BigInteger getCountRemTraited(String dteTr,String Req);
public List<Object[]> getCount2ndSumMntTraitedSI(String dteTr,String Req);
public List<RecordRemLCN> getRemLcnTraiter(String dteTr,String Req);
public List<RecordLCN> getLCNTraited(String dteTr,String pk_obj_id_Rem,String Req);

// ~~~~~~~~~~~~~~~~~~~~
//	EDITION LOT 
// ~~~~~~~~~~~~~~~~~~~

/** Traitement chèques  */	

public List<RecordLotChq> getRecordLotchq(String dteTr,String cdeBq,String Req);
public List<Object[]> getCount2ndSumMntTraitedLOT(String dteTr,String cdeBq,String Req);

/** Traitement LCN  */	
	
public List<RecordLotLcn> getRecordLotLcn4calcul(String Req);
public int UpdateDtePr(String pkObjIdt,String dtePre,String req);
public List<RecordLotLcn> getRecordLotLcn(String dtePre,String Req);
public int UpdateFlagEXT(String pkObjIdt,String req);
	
//~~~~~~~~~~~~~~~~~~~~
//	EDITION ETAT 
//~~~~~~~~~~~~~~~~~~~

/** Traitement chèques & Traitement LCN  */	

public BigInteger getCountValueTraited(String bq,String cdeTr,String dteTr);
public boolean extractDataEtaChqLcntoCsv(String bq,String tr,String dteTr);
public String getAnomalie(String PK_ANO_MNE,String cdeTr, String Req);


//~~~~~~~~~~~~~~~~~~~~
//EDITION IMPAYEES 
//~~~~~~~~~~~~~~~~~~~

/** Traitement chèques  */	

	public List<BeanImpChq> readFromCroCHQ(String bq);
	public List<BeanImpChq> readFromProdCHQ(List<BeanImpChq> impyschq,String req);
	public List<BeanImpChq> readFromIFPConfCHQ(String bq,List<BeanImpChq> impychq);

	public  List<BeanImpChq> readFromIFPIACHQ(String bq);
	public List<BeanImpChq> readFromProdIACHQ(List<BeanImpChq> impychq,String dteTr1,String req);

	public  List<BeanImpChq> loadImpysCHQ(List<BeanImpChq> impys,String req);
	public  List<BeanCountImpy> getImpyChqByBq(String req);
	
/** Traitement LCN  */
	
	public List<BeanImpLcn> readFromCroLCN(String bq);
	public  List<BeanImpLcn> readFromProdLCN(List<BeanImpLcn> impyslcn,String req);
	public  List<BeanImpLcn> readFromIFPConfLCN(List<BeanImpLcn> impylcn,String bq);

	public  List<BeanImpLcn> readFromIFPIALCN(String bq);
	public  List<BeanImpLcn> readFromProdIALCN(List<BeanImpLcn> impysLcn,String dteSort,String req);

	public  List<BeanImpLcn> loadImpysLCN(List<BeanImpLcn> impys,String req);

	public  boolean chargertableimpaye(String bq, String cdeTr,String dteTrt);

	public  List<BeanImpLcnSG> getAllimpayeLcn(String req, String dteTrt);
	
//~~~~~~~~~~~~~~~~~~~~
//GESTION DES AGENCES,SCANNERS & COMPTES 
//~~~~~~~~~~~~~~~~~~~
	
/** CPT */
	
public List<BeanCompte> getAllComptes(String Req);
public int AddCpt(BeanCompte cpt,String req);
public int DeleteAllCpts(String req);

/** AGE */

public List<BeanAgence> getAllAgences(String Req);
public int AddAge(BeanAgence age,String req);
public int DeleteAge(String idage,String req) ;
public BeanAgence getagebycde(String cdeAge,String req);

/** SCANNER */

public List<beanScann> getScannerByage(String cdeAge,String req);
public int AddScanner(beanScann sc,String req);



//######################################################################################
		//	##########  SGMA 	##########
//######################################################################################

//~~~~~~~~~~~~~~~~~~~~
//EDITION ETAT 
//~~~~~~~~~~~~~~~~~~~

/** Traitement chèques  */	/** Traitement LCN  */

public BigInteger getCountValueTraitedSgma(String bq,String cdeTr,String dteTr);
//public boolean extractDataEtaChqLcntoCsvSgma(String bq,String tr,String dteTr);
public String getAnomalieSgma(String PK_ANO_MNE,String cdeTr, String Req);
public int purgetableEta(String req);


//~~~~~~~~~~~~~~~~~~~~
//EDITION REC FILE
//~~~~~~~~~~~~~~~~~~~
/** Traitement chèques  */	

public List<RecordRemise> getRecordRemRec(String req,String trt,String dteIns);
public List<RecordValue> getRecordValuesRec(String req,String trt,String pkobjidtRem,String dteIns);

/** Traitement LCN  */

//~~~~~~~~~~~~~~~~~~~~
//EDITION IMPAYEES  
//~~~~~~~~~~~~~~~~~~~

/** Traitement chèques  */	

public List<BeanImpChqSG> readFromCroCHQSg(String bq);
public List<BeanImpChqSG> readFromProdCHQSg(List<BeanImpChqSG> impyschq,String req) ;
public List<BeanImpChqSG> readFromIFPConfCHQSg(String bq,List<BeanImpChqSG> impychq);

public  List<BeanImpChqSG> readFromIFPIACHQSg(String bq);
public List<BeanImpChqSG> readFromProdIACHQSg(List<BeanImpChqSG> impychq,String dteTr1,String req);

public  List<BeanImpChqSG> loadImpysCHQSg(List<BeanImpChqSG> impys,String req);
public  List<BeanCountImpy> getImpyChqByBqSg(String req,String trt);

public  List<BeanImpChqSG> getAllimpayeCHQ(String req, String dteTrt);

public List<BeanImpChqSG> getAllImpayeChqSg(String req, String dteTrt);

/** Traitement LCN  */


public List<BeanImpLcnSG> readFromCroLCNSg(String bq);
public  List<BeanImpLcnSG> readFromProdLCNSg(List<BeanImpLcnSG> impyslcn,String req);
public  List<BeanImpLcnSG> readFromIFPConfLCNSg(List<BeanImpLcnSG> impylcn,String bq);

public  List<BeanImpLcnSG> readFromIFPIALCNSg(String bq);
public  List<BeanImpLcnSG> readFromProdIALCNSg(List<BeanImpLcnSG> impysLcn,String dteSort,String req);

public  List<BeanImpLcnSG> loadImpysLCNSg(List<BeanImpLcnSG> impys,String req);
public  List<BeanCountImpy> getImpyByBqSg(String req,String trt);

List<BeanImpLcnSG> getAllImpayeLcnSg(String req, String dteTrt);

//~~~~~~~~~~~~~~~~~~~~
//GESTION DES PCAPTs,TRAITEMENT,REPORT  
//~~~~~~~~~~~~~~~~~~~

/** PCAPTs */

public List<BeanPcapt> getAllPcapt(String Req);
public List<BeanPcapt> getGetPcaptByCde(String req,List<String> cde);
int AddPcapt(BeanPcapt p, String req);
public int UpdatePcapt(int idpcapt,BeanPcapt pcapt, String req);
public int DeletePcapt(int idpcapt,String req);

/** TRAITEMENTs */

public List<BeanTrt> getGetTrtByCde(String req,List<String> cde);
public List<BeanTrt> getAlltrt(String Req);

/** REPORTs */

public List<BeanReport> getReportByTrt(String Req,int idT);
public List<BeanPcapt> getDistinctCircuit(String req);

//List<String> GetDistinctSecteurSg(String req);
//List<String> GetDistinctCircuitSg(String req);


//######################################################################################
		//	##########  BAA 	##########
//######################################################################################

//~~~~~~~~~~~~~~~~~~~~
//EDITION SI 
//~~~~~~~~~~~~~~~~~~~

/** Traitement LCN  */

public BigInteger getCountRemTraitedBaa(String dteTr,String Req);
public List<Object[]> getCount2ndSumMntTraitedSIBaa(String dteTr,String Req);
public List<BaaRecordRemLCN> getRemLcnTraiterBaa(String dteTr,String Req);
public List<BaaRecordLCN> getLCNTraitedBaa(String dteTr,String pk_obj_id_Rem,String Req);


//~~~~~~~~~~~~~~~~~~~~
//EDITION ETAT
//~~~~~~~~~~~~~~~~~~~
/** Traitement chèques  & Traitement LCN  */


public BigInteger getCountValueTraitedBaa(String bq,String cdeTr,String dteTr);
public boolean extractDataEtaChqLcntoCsvBaa(String bq,String tr,String dteTr);
public String getAnomalieBaa(String PK_ANO_MNE,String cdeTr, String Req);

// SUIVI PHYSIQUE

public BigInteger getCountValueSuiviSgma(String bq, String trt, String dtetrt1,String dtetrt2,String listPcapts);

public boolean extractDataSuiviChqLcn(String bq, String trt, String dtetrt1,String dtetrt2,String listPcapts);
public List<BeanSuiviPhysique> getRecupFluxphysique(String req);
public int updateValideFluxphysique(String req,String listPcapts,String listdte,String username);
public int synchronImpayeLCNFluxphysique(String req);

public List<BeanDetailSuiviPhysique> getDetailFluxphysique(String req);
//~~~~~~~~~~~~~~~~~~~~
//EDITION IMPAYEES
//~~~~~~~~~~~~~~~~~~~
/** Traitement chèques  & Traitement LCN  */
public  List<BeanCountImpy> getImpyChqByBqBaa(String req);

//~~~~~~~~~~~~~~~~~~~~
//GESTION DES AGENCES,SCANNERS & COMPTES 
//~~~~~~~~~~~~~~~~~~~
	
/** CPT */

public List<BeanCompte> getAllComptesBaa(String Req);

/** AGENCES */

public List<BeanAgence> getAllAgencesBaa(String Req);

/** SCANNER */

public List<beanScann> getScannerByageBaa(String cdeAge,String req);
public int AddScannerBaa(beanScann sc,String req);



//######################################################################################
/*** BMCE ***/
//######################################################################################
public List<Object[]> gettr_prfBMCE();
public int Addta_prf_optBMCE(String pk);

//######################################################################################
/*** CFG ***/
//######################################################################################
public int purgeTablePaidChq(String bq,String trt);
public List<RecordPaidValue> getAllValueChq(String bq,String trt,String listDte,String listPcapts);
public List<BeanCountpye> getCountValueChq(String bq,String trt);

public int purgeTablePaidLcn(String bq,String trt);
public List<RecordPaidValue> getAllValueLcn(String bq,String trt,String listPcapts);
public List<BeanCountpye> getCountValueLcn(String bq,String trt);


//#######################################################################################################################################################################
public Connection getConnectionLocal();









}
