package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class RecordLotLcn {

//	private String pk_obj_idt,dteec,dteins,dtepre,flagext;
	
	
	@Id
	private String PK_OBJ_IDT;

	@Transient
	String  typeOperation ,refOperation,indicateurPreTire,RibClientTire,prefixeIbanTire,indicateurPreBeni,RibBeni,prefixeIbanBeni,libelle,filler;
	String  ADR_BEN ,
	  ADR_RMT ,
	  ADR_TIRE ,
	  CDEAVAL ,
	  CDEBPR ,
	  CDEPRE ,
	  CPT ,
	  CPTT ,
	  DTEEC ,
	  DTEINS ,
	  DTEMI ,
	  LOC ,
	  LOCT ,
	  MNT ,
	  NSER ,	
	  RIB ,
	  RIBT,
	  RSOC_BEN,
	  RSOC_RMT ,
	  RSOC_TIRE ,
	  ZBK,
	  ZBKT,
	  ZIB ,
	  ZIBT ,
	  DTEPRE ,  
	  DTEEXT,

	  DTREG,
	  FLAG_IMP ,
	  RIO,
	  AGE_RMT ,
	  AGE_RMT_LIB ,
	  CDEBPR_RMT ,
	  
	  FLAGEXT ;

	public String getPK_OBJ_IDT() {
		return PK_OBJ_IDT;
	}

	public void setPK_OBJ_IDT(String pK_OBJ_IDT) {
		PK_OBJ_IDT = pK_OBJ_IDT;
	}

	public String getADR_BEN() {
		return ADR_BEN;
	}

	public void setADR_BEN(String aDR_BEN) {
		ADR_BEN = aDR_BEN;
	}

	public String getADR_RMT() {
		return ADR_RMT;
	}

	public void setADR_RMT(String aDR_RMT) {
		ADR_RMT = aDR_RMT;
	}

	public String getADR_TIRE() {
		return ADR_TIRE;
	}

	public void setADR_TIRE(String aDR_TIRE) {
		ADR_TIRE = aDR_TIRE;
	}

	public String getCDEAVAL() {
		return CDEAVAL;
	}

	public void setCDEAVAL(String cDEAVAL) {
		CDEAVAL = cDEAVAL;
	}

	public String getCDEBPR() {
		return CDEBPR;
	}

	public void setCDEBPR(String cDEBPR) {
		CDEBPR = cDEBPR;
	}

	public String getCDEPRE() {
		return CDEPRE;
	}

	public void setCDEPRE(String cDEPRE) {
		CDEPRE = cDEPRE;
	}

	public String getCPT() {
		return CPT;
	}

	public void setCPT(String cPT) {
		CPT = cPT;
	}

	public String getCPTT() {
		return CPTT;
	}

	public void setCPTT(String cPTT) {
		CPTT = cPTT;
	}

	public String getDTEEC() {
		return DTEEC;
	}

	public void setDTEEC(String dTEEC) {
		DTEEC = dTEEC;
	}

	public String getDTEINS() {
		return DTEINS;
	}

	public void setDTEINS(String dTEINS) {
		DTEINS = dTEINS;
	}

	public String getDTEMI() {
		return DTEMI;
	}

	public void setDTEMI(String dTEMI) {
		DTEMI = dTEMI;
	}

	public String getLOC() {
		return LOC;
	}

	public void setLOC(String lOC) {
		LOC = lOC;
	}

	public String getLOCT() {
		return LOCT;
	}

	public void setLOCT(String lOCT) {
		LOCT = lOCT;
	}

	public String getMNT() {
		return MNT;
	}

	public void setMNT(String mNT) {
		MNT = mNT;
	}

	public String getNSER() {
		return NSER;
	}

	public void setNSER(String nSER) {
		NSER = nSER;
	}

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public String getRIBT() {
		return RIBT;
	}

	public void setRIBT(String rIBT) {
		RIBT = rIBT;
	}

	public String getRSOC_BEN() {
		return RSOC_BEN;
	}

	public void setRSOC_BEN(String rSOC_BEN) {
		RSOC_BEN = rSOC_BEN;
	}

	public String getRSOC_RMT() {
		return RSOC_RMT;
	}

	public void setRSOC_RMT(String rSOC_RMT) {
		RSOC_RMT = rSOC_RMT;
	}

	public String getRSOC_TIRE() {
		return RSOC_TIRE;
	}

	public void setRSOC_TIRE(String rSOC_TIRE) {
		RSOC_TIRE = rSOC_TIRE;
	}

	public String getZBK() {
		return ZBK;
	}

	public void setZBK(String zBK) {
		ZBK = zBK;
	}

	public String getZBKT() {
		return ZBKT;
	}

	public void setZBKT(String zBKT) {
		ZBKT = zBKT;
	}

	public String getZIB() {
		return ZIB;
	}

	public void setZIB(String zIB) {
		ZIB = zIB;
	}

	public String getZIBT() {
		return ZIBT;
	}

	public void setZIBT(String zIBT) {
		ZIBT = zIBT;
	}

	public String getDTEPRE() {
		return DTEPRE;
	}

	public void setDTEPRE(String dTEPRE) {
		DTEPRE = dTEPRE;
	}

	public String getDTEEXT() {
		return DTEEXT;
	}

	public void setDTEEXT(String dTEEXT) {
		DTEEXT = dTEEXT;
	}

	public String getDTREG() {
		return DTREG;
	}

	public void setDTREG(String dTREG) {
		DTREG = dTREG;
	}

	public String getFLAG_IMP() {
		return FLAG_IMP;
	}

	public void setFLAG_IMP(String fLAG_IMP) {
		FLAG_IMP = fLAG_IMP;
	}

	public String getRIO() {
		return RIO;
	}

	public void setRIO(String rIO) {
		RIO = rIO;
	}

	public String getAGE_RMT() {
		return AGE_RMT;
	}

	public void setAGE_RMT(String aGE_RMT) {
		AGE_RMT = aGE_RMT;
	}

	public String getAGE_RMT_LIB() {
		return AGE_RMT_LIB;
	}

	public void setAGE_RMT_LIB(String aGE_RMT_LIB) {
		AGE_RMT_LIB = aGE_RMT_LIB;
	}

	public String getCDEBPR_RMT() {
		return CDEBPR_RMT;
	}

	public void setCDEBPR_RMT(String cDEBPR_RMT) {
		CDEBPR_RMT = cDEBPR_RMT;
	}

	public String getFLAGEXT() {
		return FLAGEXT;
	}

	public void setFLAGEXT(String fLAGEXT) {
		FLAGEXT = fLAGEXT;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public String getRefOperation() {
		return refOperation;
	}

	public void setRefOperation(String refOperation) {
		this.refOperation = refOperation;
	}

	public String getIndicateurPreTire() {
		return indicateurPreTire;
	}

	public void setIndicateurPreTire(String indicateurPreTire) {
		this.indicateurPreTire = indicateurPreTire;
	}

	public String getRibClientTire() {
		return RibClientTire;
	}

	public void setRibClientTire(String ribClientTire) {
		RibClientTire = ribClientTire;
	}

	public String getPrefixeIbanTire() {
		return prefixeIbanTire;
	}

	public void setPrefixeIbanTire(String prefixeIbanTire) {
		this.prefixeIbanTire = prefixeIbanTire;
	}

	public String getIndicateurPreBeni() {
		return indicateurPreBeni;
	}

	public void setIndicateurPreBeni(String indicateurPreBeni) {
		this.indicateurPreBeni = indicateurPreBeni;
	}

	public String getRibBeni() {
		return RibBeni;
	}

	public void setRibBeni(String ribBeni) {
		RibBeni = ribBeni;
	}

	public String getPrefixeIbanBeni() {
		return prefixeIbanBeni;
	}

	public void setPrefixeIbanBeni(String prefixeIbanBeni) {
		this.prefixeIbanBeni = prefixeIbanBeni;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}



	
	
}
