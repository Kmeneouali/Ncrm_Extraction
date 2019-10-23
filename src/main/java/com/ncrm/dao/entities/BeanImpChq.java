package com.ncrm.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class BeanImpChq implements Serializable{
	@Id
	private String bmch_PK_OBJ_IDT;
	private String bmch_CPT,
	bmch_LOC,
	bmch_ZBK,
	ZBK_LIB,
	bmch_nser,
	bmch_rib,
	bmch_MNT,
	bmtr_AGE,
	AGE_LIB,
	bmtr_CPT,
	bmtn_lecteur,
	bmch_SQCA,
	DTE_TRT,
	DTE_SORT;
	
	@Transient
	String RSOC_RMT,RSOC_TIRE,ADR_RMT,NOMTIRE,CIN,RC,LieuEmission,DTEemission,DTREJET,MOTIF1,MOTIF2,MOTIF3,ADR_TIR,DTEPRE,
	RIOINI,RIO,Rejet;
	
	
	
	
	
	
	
	
	public String getBmch_PK_OBJ_IDT() {
		return bmch_PK_OBJ_IDT;
	}
	public void setBmch_PK_OBJ_IDT(String bmch_PK_OBJ_IDT) {
		this.bmch_PK_OBJ_IDT = bmch_PK_OBJ_IDT;
	}
	public String getBmch_CPT() {
		return bmch_CPT;
	}
	public void setBmch_CPT(String bmch_CPT) {
		this.bmch_CPT = bmch_CPT;
	}
	public String getBmch_LOC() {
		return bmch_LOC;
	}
	public void setBmch_LOC(String bmch_LOC) {
		this.bmch_LOC = bmch_LOC;
	}
	public String getBmch_ZBK() {
		return bmch_ZBK;
	}
	public void setBmch_ZBK(String bmch_ZBK) {
		this.bmch_ZBK = bmch_ZBK;
	}
	public String getZBK_LIB() {
		return ZBK_LIB;
	}
	public void setZBK_LIB(String zBK_LIB) {
		ZBK_LIB = zBK_LIB;
	}
	public String getBmch_nser() {
		return bmch_nser;
	}
	public void setBmch_nser(String bmch_nser) {
		this.bmch_nser = bmch_nser;
	}
	public String getBmch_rib() {
		return bmch_rib;
	}
	public void setBmch_rib(String bmch_rib) {
		this.bmch_rib = bmch_rib;
	}
	public String getBmch_MNT() {
		return bmch_MNT;
	}
	public void setBmch_MNT(String bmch_MNT) {
		this.bmch_MNT = bmch_MNT;
	}
	public String getBmtr_AGE() {
		return bmtr_AGE;
	}
	public void setBmtr_AGE(String bmtr_AGE) {
		this.bmtr_AGE = bmtr_AGE;
	}
	public String getAGE_LIB() {
		return AGE_LIB;
	}
	public void setAGE_LIB(String aGE_LIB) {
		AGE_LIB = aGE_LIB;
	}
	public String getBmtr_CPT() {
		return bmtr_CPT;
	}
	public void setBmtr_CPT(String bmtr_CPT) {
		this.bmtr_CPT = bmtr_CPT;
	}
	public String getBmtn_lecteur() {
		return bmtn_lecteur;
	}
	public void setBmtn_lecteur(String bmtn_lecteur) {
		this.bmtn_lecteur = bmtn_lecteur;
	}
	public String getRIOINI() {
		return RIOINI;
	}
	public void setRIOINI(String rIOINI) {
		RIOINI = rIOINI;
	}
	public String getBmch_SQCA() {
		return bmch_SQCA;
	}
	public void setBmch_SQCA(String bmch_SQCA) {
		this.bmch_SQCA = bmch_SQCA;
	}
	public String getDTE_TRT() {
		return DTE_TRT;
	}
	public void setDTE_TRT(String dTE_TRT) {
		DTE_TRT = dTE_TRT;
	}
	public String getDTE_SORT() {
		return DTE_SORT;
	}
	public void setDTE_SORT(String dTE_SORT) {
		DTE_SORT = dTE_SORT;
	}
	public String getRIO() {
		return RIO;
	}
	public void setRIO(String rIO) {
		RIO = rIO;
	}
	public String getRejet() {
		return Rejet;
	}
	public void setRejet(String rejet) {
		Rejet = rejet;
	}
	public String getNOMTIRE() {
		return NOMTIRE;
	}
	public void setNOMTIRE(String nOMTIRE) {
		NOMTIRE = nOMTIRE;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getRC() {
		return RC;
	}
	public void setRC(String rC) {
		RC = rC;
	}
	public String getLieuEmission() {
		return LieuEmission;
	}
	public void setLieuEmission(String lieuEmission) {
		LieuEmission = lieuEmission;
	}
	public String getDTEemission() {
		return DTEemission;
	}
	public void setDTEemission(String dTEemission) {
		DTEemission = dTEemission;
	}
	public String getDTREJET() {
		return DTREJET;
	}
	public void setDTREJET(String dTREJET) {
		DTREJET = dTREJET;
	}
	public String getMOTIF1() {
		return MOTIF1;
	}
	public void setMOTIF1(String mOTIF1) {
		MOTIF1 = mOTIF1;
	}
	public String getMOTIF2() {
		return MOTIF2;
	}
	public void setMOTIF2(String mOTIF2) {
		MOTIF2 = mOTIF2;
	}
	public String getMOTIF3() {
		return MOTIF3;
	}
	public void setMOTIF3(String mOTIF3) {
		MOTIF3 = mOTIF3;
	}
	public String getADR_TIR() {
		return ADR_TIR;
	}
	public void setADR_TIR(String aDR_TIR) {
		ADR_TIR = aDR_TIR;
	}
	public String getDTEPRE() {
		return DTEPRE;
	}
	public void setDTEPRE(String dTEPRE) {
		DTEPRE = dTEPRE;
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
	public String getADR_RMT() {
		return ADR_RMT;
	}
	public void setADR_RMT(String aDR_RMT) {
		ADR_RMT = aDR_RMT;
	}

	
	
	
	
}
