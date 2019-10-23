package com.ncrm.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class BeanImpLcnSG implements Serializable {
	@Id
	private String  bmlcn_PK_OBJ_IDT;
	String bmlcn_CPT,
	bmlcn_LOC,
	bmlcn_ZBK,
	 ZBK_LIB,
	bmlcn_nser,
	bmlcn_rib,
	bmlcn_MNT,
	bmtr_AGE,
	AGE_LIB,
	bmtr_CPT,
	bmtn_lecteur,
	RIOINI,
	DTE_TRT,
	DTE_SORT,bmlcn_SQCA,
	
	DTEEC,ID_WEBCAPTUR,AGE_SCAN;
			
//			
		String 	NOMTIRE, CIN, RC,RIO,
			lieuEmission, Rejet,MOTIF1, MOTIF2, MOTIF3, adresseTire,ADR_RMT,RSOC_RMT,RSOC_TIRE, REJET_LIB,DTEPRE,
			DTREJET, DTEINS, DTEemission,NSER_REM,MODE_REM;
		@Transient
String mnt2;
		public String getBmlcn_PK_OBJ_IDT() {
			return bmlcn_PK_OBJ_IDT;
		}

		public void setBmlcn_PK_OBJ_IDT(String bmlcn_PK_OBJ_IDT) {
			this.bmlcn_PK_OBJ_IDT = bmlcn_PK_OBJ_IDT;
		}

		public String getBmlcn_CPT() {
			return bmlcn_CPT;
		}

		public void setBmlcn_CPT(String bmlcn_CPT) {
			this.bmlcn_CPT = bmlcn_CPT;
		}

		public String getBmlcn_LOC() {
			return bmlcn_LOC;
		}

		public void setBmlcn_LOC(String bmlcn_LOC) {
			this.bmlcn_LOC = bmlcn_LOC;
		}

		public String getBmlcn_ZBK() {
			return bmlcn_ZBK;
		}

		public void setBmlcn_ZBK(String bmlcn_ZBK) {
			this.bmlcn_ZBK = bmlcn_ZBK;
		}

		public String getZBK_LIB() {
			return ZBK_LIB;
		}

		public void setZBK_LIB(String zBK_LIB) {
			ZBK_LIB = zBK_LIB;
		}

		public String getBmlcn_nser() {
			return bmlcn_nser;
		}

		public void setBmlcn_nser(String bmlcn_nser) {
			this.bmlcn_nser = bmlcn_nser;
		}

		public String getBmlcn_rib() {
			return bmlcn_rib;
		}

		public void setBmlcn_rib(String bmlcn_rib) {
			this.bmlcn_rib = bmlcn_rib;
		}

		public String getBmlcn_MNT() {
			return bmlcn_MNT;
		}

		public void setBmlcn_MNT(String bmlcn_MNT) {
			this.bmlcn_MNT = bmlcn_MNT;
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

		public String getDTEPRE() {
			return DTEPRE;
		}

		public void setDTEPRE(String dTEPRE) {
			DTEPRE = dTEPRE;
		}

		public String getDTEEC() {
			return DTEEC;
		}

		public void setDTEEC(String dTEEC) {
			DTEEC = dTEEC;
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
			return lieuEmission;
		}

		public void setLieuEmission(String lieuEmission) {
			this.lieuEmission = lieuEmission;
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

		public String getAdresseTire() {
			return adresseTire;
		}

		public void setAdresseTire(String adresseTire) {
			this.adresseTire = adresseTire;
		}

		public String getREJET_LIB() {
			return REJET_LIB;
		}

		public void setREJET_LIB(String rEJET_LIB) {
			REJET_LIB = rEJET_LIB;
		}

		public String getDTREJET() {
			return DTREJET;
		}

		public void setDTREJET(String dTREJET) {
			DTREJET = dTREJET;
		}

		public String getDTEINS() {
			return DTEINS;
		}

		public void setDTEINS(String dTEINS) {
			DTEINS = dTEINS;
		}

		public String getDTEemission() {
			return DTEemission;
		}

		public void setDTEemission(String dTEemission) {
			DTEemission = dTEemission;
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

		public String getADR_RMT() {
			return ADR_RMT;
		}

		public void setADR_RMT(String aDR_RMT) {
			ADR_RMT = aDR_RMT;
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

		public String getID_WEBCAPTUR() {
			return ID_WEBCAPTUR;
		}

		public void setID_WEBCAPTUR(String iD_WEBCAPTUR) {
			ID_WEBCAPTUR = iD_WEBCAPTUR;
		}

		public String getAGE_SCAN() {
			return AGE_SCAN;
		}

		public void setAGE_SCAN(String aGE_SCAN) {
			AGE_SCAN = aGE_SCAN;
		}

		public String getBmlcn_SQCA() {
			return bmlcn_SQCA;
		}

		public void setBmlcn_SQCA(String bmlcn_SQCA) {
			this.bmlcn_SQCA = bmlcn_SQCA;
		}

		public String getMnt2() {
			return mnt2;
		}

		public void setMnt2(String mnt2) {
			this.mnt2 = mnt2;
		}

		public String getNSER_REM() {
			return NSER_REM;
		}

		public void setNSER_REM(String nSER_REM) {
			NSER_REM = nSER_REM;
		}

		public String getMODE_REM() {
			return MODE_REM;
		}

		public void setMODE_REM(String mODE_REM) {
			MODE_REM = mODE_REM;
		}

		

	
	
}
