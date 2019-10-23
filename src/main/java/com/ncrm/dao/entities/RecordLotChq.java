package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class RecordLotChq {

	@Id
	String bmch_PK_OBJ_IDT;
	String DATETR,
	bmtr_AGE_RMT,
	bmtr_CDE_BPR,
	CPT_REM,
	LOCR,
	CPTR,
	RESOC_REM,
	
	REF_REM,
	CPT_TIRE,
	RSOC_TIRE,
	ADR_TIRE,
	bmch_nser,
	bmch_mnt,
	bmch_dteEmi
	;
	
	@Transient
	String 
	ADD_REM;
	
	@Transient
	String typeOperation;
	@Transient
	String RefOperation;
	@Transient
	String indicateurPreRem;
	@Transient
	String PrifixIbanRem;
	@Transient
	String indicateurPreTire;
	@Transient
	String PrifixIbanTire;
	@Transient
	String codeChq;
	@Transient
	String natureChq;
	@Transient
	String filler;

	public String getBmch_PK_OBJ_IDT() {
		return bmch_PK_OBJ_IDT;
	}

	public void setBmch_PK_OBJ_IDT(String bmch_PK_OBJ_IDT) {
		this.bmch_PK_OBJ_IDT = bmch_PK_OBJ_IDT;
	}

	public String getDATETR() {
		return DATETR;
	}

	public void setDATETR(String dATETR) {
		DATETR = dATETR;
	}

	public String getBmtr_AGE_RMT() {
		return bmtr_AGE_RMT;
	}

	public void setBmtr_AGE_RMT(String bmtr_AGE_RMT) {
		this.bmtr_AGE_RMT = bmtr_AGE_RMT;
	}

	public String getBmtr_CDE_BPR() {
		return bmtr_CDE_BPR;
	}

	public void setBmtr_CDE_BPR(String bmtr_CDE_BPR) {
		this.bmtr_CDE_BPR = bmtr_CDE_BPR;
	}

	public String getCPT_REM() {
		return CPT_REM;
	}

	public void setCPT_REM(String cPT_REM) {
		CPT_REM = cPT_REM;
	}

	public String getLOCR() {
		return LOCR;
	}

	public void setLOCR(String lOCR) {
		LOCR = lOCR;
	}

	public String getCPTR() {
		return CPTR;
	}

	public void setCPTR(String cPTR) {
		CPTR = cPTR;
	}

	public String getRESOC_REM() {
		return RESOC_REM;
	}

	public void setRESOC_REM(String rESOC_REM) {
		RESOC_REM = rESOC_REM;
	}

	public String getREF_REM() {
		return REF_REM;
	}

	public void setREF_REM(String rEF_REM) {
		REF_REM = rEF_REM;
	}

	public String getCPT_TIRE() {
		return CPT_TIRE;
	}

	public void setCPT_TIRE(String cPT_TIRE) {
		CPT_TIRE = cPT_TIRE;
	}

	public String getRSOC_TIRE() {
		return RSOC_TIRE;
	}

	public void setRSOC_TIRE(String rSOC_TIRE) {
		RSOC_TIRE = rSOC_TIRE;
	}

	public String getADR_TIRE() {
		return ADR_TIRE;
	}

	public void setADR_TIRE(String aDR_TIRE) {
		ADR_TIRE = aDR_TIRE;
	}

	public String getBmch_nser() {
		return bmch_nser;
	}

	public void setBmch_nser(String bmch_nser) {
		this.bmch_nser = bmch_nser;
	}

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public String getRefOperation() {
		return RefOperation;
	}

	public void setRefOperation(String refOperation) {
		RefOperation = refOperation;
	}

	public String getIndicateurPreRem() {
		return indicateurPreRem;
	}

	public void setIndicateurPreRem(String indicateurPreRem) {
		this.indicateurPreRem = indicateurPreRem;
	}

	public String getPrifixIbanRem() {
		return PrifixIbanRem;
	}

	public void setPrifixIbanRem(String prifixIbanRem) {
		PrifixIbanRem = prifixIbanRem;
	}

	public String getIndicateurPreTire() {
		return indicateurPreTire;
	}

	public void setIndicateurPreTire(String indicateurPreTire) {
		this.indicateurPreTire = indicateurPreTire;
	}

	public String getPrifixIbanTire() {
		return PrifixIbanTire;
	}

	public void setPrifixIbanTire(String prifixIbanTire) {
		PrifixIbanTire = prifixIbanTire;
	}

	public String getCodeChq() {
		return codeChq;
	}

	public void setCodeChq(String codeChq) {
		this.codeChq = codeChq;
	}

	public String getNatureChq() {
		return natureChq;
	}

	public void setNatureChq(String natureChq) {
		this.natureChq = natureChq;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public String getADD_REM() {
		return ADD_REM;
	}

	public void setADD_REM(String aDD_REM) {
		ADD_REM = aDD_REM;
	}

	public String getBmch_mnt() {
		return bmch_mnt;
	}

	public void setBmch_mnt(String bmch_mnt) {
		this.bmch_mnt = bmch_mnt;
	}

	public String getBmch_dteEmi() {
		return bmch_dteEmi;
	}

	public void setBmch_dteEmi(String bmch_dteEmi) {
		this.bmch_dteEmi = bmch_dteEmi;
	}
	
	
	
	
}
