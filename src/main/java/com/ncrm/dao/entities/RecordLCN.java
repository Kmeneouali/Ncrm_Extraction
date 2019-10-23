package com.ncrm.dao.entities;

import java.io.Serializable;




import javax.persistence.Id;
import javax.persistence.Transient;

@javax.persistence.Entity
public class RecordLCN implements Serializable {
    @Id
    String bmlcn_pk_obj_idt;
    @Transient
    String idLcn;
    @Transient
	String ribTire;
    @Transient
    String LcnTimber;
    String bmtr_RIBRMT,bmtr_nser,bmlcn_CODE_STATUS;
	String bmlcn_RECTO_US_GR;
	String bmlcn_VERSO_DS_GR,
	DATE,
	bmlcn_cdeAval,
	bmlcn_NOM_AVAL,
	bmlcn_cdeend,
	bmlcn_cde_nom_endo,
	bmlcn_cde_NOM_TIREUR,
	bmtr_NSER,
	bmtr_MEM2,
	bmtr_MNTDECL,
	bmtr_CDECLT,
	bmtr_NBCH,
	bmtr_MODE_ESC,
	bmtr_OPE_ETA,
	bmtr_SQCA,
	bmtr_AGE_RMT,
	bmtr_TIERS,
	bmtr_REFCLI,
	bmlcn_ope_eta,
	bmlcn_ADR_RMT,
	bmlcn_ADR_TIR,
	bmlcn_AGE,
	bmlcn_CDEBPR,
	bmlcn_CDE_REJ,
	bmlcn_CONF,
	bmlcn_SIGN,
	bmlcn_CPT,
	bmlcn_CPT2,
	bmlcn_DBLT,
	bmlcn_DTEEMI,
	bmlcn_DTEEC,
	bmlcn_DTECRE,
	bmlcn_FLAG_REJET,
	bmlcn_FLAG_AVAL,
	bmlcn_LOC,
	bmlcn_MEM2,
	bmlcn_MNT,
	bmlcn_NSER,
	bmlcn_RIB,
	bmlcn_RSOC_TIR,
	bmlcn_SQCA,
	bmlcn_ZBK,
	bmlcn_ZIB,
	bmlcn_ANO,
	bmlcn_VICE,
	bmlcn_AGE_RMT ;
	public String getBmlcn_RECTO_US_GR() {
		return bmlcn_RECTO_US_GR;
	}
	public void setBmlcn_RECTO_US_GR(String bmlcn_RECTO_US_GR) {
		this.bmlcn_RECTO_US_GR = bmlcn_RECTO_US_GR;
	}
	public String getBmlcn_VERSO_DS_GR() {
		return bmlcn_VERSO_DS_GR;
	}
	public void setBmlcn_VERSO_DS_GR(String bmlcn_VERSO_DS_GR) {
		this.bmlcn_VERSO_DS_GR = bmlcn_VERSO_DS_GR;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getBmlcn_cdeAval() {
		return bmlcn_cdeAval;
	}
	public void setBmlcn_cdeAval(String bmlcn_cdeAval) {
		this.bmlcn_cdeAval = bmlcn_cdeAval;
	}
	public String getBmlcn_NOM_AVAL() {
		return bmlcn_NOM_AVAL;
	}
	public void setBmlcn_NOM_AVAL(String bmlcn_NOM_AVAL) {
		this.bmlcn_NOM_AVAL = bmlcn_NOM_AVAL;
	}
	public String getBmlcn_cdeend() {
		return bmlcn_cdeend;
	}
	public void setBmlcn_cdeend(String bmlcn_cdeend) {
		this.bmlcn_cdeend = bmlcn_cdeend;
	}
	public String getBmlcn_cde_nom_endo() {
		return bmlcn_cde_nom_endo;
	}
	public void setBmlcn_cde_nom_endo(String bmlcn_cde_nom_endo) {
		this.bmlcn_cde_nom_endo = bmlcn_cde_nom_endo;
	}
	public String getBmlcn_cde_NOM_TIREUR() {
		return bmlcn_cde_NOM_TIREUR;
	}
	public void setBmlcn_cde_NOM_TIREUR(String bmlcn_cde_NOM_TIREUR) {
		this.bmlcn_cde_NOM_TIREUR = bmlcn_cde_NOM_TIREUR;
	}
	public String getBmtr_NSER() {
		return bmtr_NSER;
	}
	public void setBmtr_NSER(String bmtr_NSER) {
		this.bmtr_NSER = bmtr_NSER;
	}
	public String getBmtr_MEM2() {
		return bmtr_MEM2;
	}
	public void setBmtr_MEM2(String bmtr_MEM2) {
		this.bmtr_MEM2 = bmtr_MEM2;
	}
	public String getBmtr_MNTDECL() {
		return bmtr_MNTDECL;
	}
	public void setBmtr_MNTDECL(String bmtr_MNTDECL) {
		this.bmtr_MNTDECL = bmtr_MNTDECL;
	}
	public String getBmtr_CDECLT() {
		return bmtr_CDECLT;
	}
	public void setBmtr_CDECLT(String bmtr_CDECLT) {
		this.bmtr_CDECLT = bmtr_CDECLT;
	}
	public String getBmtr_NBCH() {
		return bmtr_NBCH;
	}
	public void setBmtr_NBCH(String bmtr_NBCH) {
		this.bmtr_NBCH = bmtr_NBCH;
	}
	public String getBmtr_MODE_ESC() {
		return bmtr_MODE_ESC;
	}
	public void setBmtr_MODE_ESC(String bmtr_MODE_ESC) {
		this.bmtr_MODE_ESC = bmtr_MODE_ESC;
	}
	public String getBmtr_OPE_ETA() {
		return bmtr_OPE_ETA;
	}
	public void setBmtr_OPE_ETA(String bmtr_OPE_ETA) {
		this.bmtr_OPE_ETA = bmtr_OPE_ETA;
	}
	public String getBmtr_SQCA() {
		return bmtr_SQCA;
	}
	public void setBmtr_SQCA(String bmtr_SQCA) {
		this.bmtr_SQCA = bmtr_SQCA;
	}
	public String getBmtr_AGE_RMT() {
		return bmtr_AGE_RMT;
	}
	public void setBmtr_AGE_RMT(String bmtr_AGE_RMT) {
		this.bmtr_AGE_RMT = bmtr_AGE_RMT;
	}
	public String getBmtr_TIERS() {
		return bmtr_TIERS;
	}
	public void setBmtr_TIERS(String bmtr_TIERS) {
		this.bmtr_TIERS = bmtr_TIERS;
	}
	public String getBmtr_REFCLI() {
		return bmtr_REFCLI;
	}
	public void setBmtr_REFCLI(String bmtr_REFCLI) {
		this.bmtr_REFCLI = bmtr_REFCLI;
	}
	public String getBmlcn_ope_eta() {
		return bmlcn_ope_eta;
	}
	public void setBmlcn_ope_eta(String bmlcn_ope_eta) {
		this.bmlcn_ope_eta = bmlcn_ope_eta;
	}
	public String getBmlcn_ADR_RMT() {
		return bmlcn_ADR_RMT;
	}
	public void setBmlcn_ADR_RMT(String bmlcn_ADR_RMT) {
		this.bmlcn_ADR_RMT = bmlcn_ADR_RMT;
	}
	public String getBmlcn_ADR_TIR() {
		return bmlcn_ADR_TIR;
	}
	public void setBmlcn_ADR_TIR(String bmlcn_ADR_TIR) {
		this.bmlcn_ADR_TIR = bmlcn_ADR_TIR;
	}
	public String getBmlcn_AGE() {
		return bmlcn_AGE;
	}
	public void setBmlcn_AGE(String bmlcn_AGE) {
		this.bmlcn_AGE = bmlcn_AGE;
	}
	public String getBmlcn_CDEBPR() {
		return bmlcn_CDEBPR;
	}
	public void setBmlcn_CDEBPR(String bmlcn_CDEBPR) {
		this.bmlcn_CDEBPR = bmlcn_CDEBPR;
	}
	public String getBmlcn_CDE_REJ() {
		return bmlcn_CDE_REJ;
	}
	public void setBmlcn_CDE_REJ(String bmlcn_CDE_REJ) {
		this.bmlcn_CDE_REJ = bmlcn_CDE_REJ;
	}
	public String getBmlcn_CONF() {
		return bmlcn_CONF;
	}
	public void setBmlcn_CONF(String bmlcn_CONF) {
		this.bmlcn_CONF = bmlcn_CONF;
	}
	public String getBmlcn_CPT() {
		return bmlcn_CPT;
	}
	public void setBmlcn_CPT(String bmlcn_CPT) {
		this.bmlcn_CPT = bmlcn_CPT;
	}
	public String getBmlcn_CPT2() {
		return bmlcn_CPT2;
	}
	public void setBmlcn_CPT2(String bmlcn_CPT2) {
		this.bmlcn_CPT2 = bmlcn_CPT2;
	}
	public String getBmlcn_DBLT() {
		return bmlcn_DBLT;
	}
	public void setBmlcn_DBLT(String bmlcn_DBLT) {
		this.bmlcn_DBLT = bmlcn_DBLT;
	}
	public String getBmlcn_DTEEMI() {
		return bmlcn_DTEEMI;
	}
	public void setBmlcn_DTEEMI(String bmlcn_DTEEMI) {
		this.bmlcn_DTEEMI = bmlcn_DTEEMI;
	}
	public String getBmlcn_DTEEC() {
		return bmlcn_DTEEC;
	}
	public void setBmlcn_DTEEC(String bmlcn_DTEEC) {
		this.bmlcn_DTEEC = bmlcn_DTEEC;
	}
	public String getBmlcn_DTECRE() {
		return bmlcn_DTECRE;
	}
	public void setBmlcn_DTECRE(String bmlcn_DTECRE) {
		this.bmlcn_DTECRE = bmlcn_DTECRE;
	}
	public String getBmlcn_FLAG_REJET() {
		return bmlcn_FLAG_REJET;
	}
	public void setBmlcn_FLAG_REJET(String bmlcn_FLAG_REJET) {
		this.bmlcn_FLAG_REJET = bmlcn_FLAG_REJET;
	}
	public String getBmlcn_FLAG_AVAL() {
		return bmlcn_FLAG_AVAL;
	}
	public void setBmlcn_FLAG_AVAL(String bmlcn_FLAG_AVAL) {
		this.bmlcn_FLAG_AVAL = bmlcn_FLAG_AVAL;
	}
	public String getBmlcn_LOC() {
		return bmlcn_LOC;
	}
	public void setBmlcn_LOC(String bmlcn_LOC) {
		this.bmlcn_LOC = bmlcn_LOC;
	}
	public String getBmlcn_MEM2() {
		return bmlcn_MEM2;
	}
	public void setBmlcn_MEM2(String bmlcn_MEM2) {
		this.bmlcn_MEM2 = bmlcn_MEM2;
	}
	public String getBmlcn_MNT() {
		return bmlcn_MNT;
	}
	public void setBmlcn_MNT(String bmlcn_MNT) {
		this.bmlcn_MNT = bmlcn_MNT;
	}
	public String getBmlcn_NSER() {
		return bmlcn_NSER;
	}
	public void setBmlcn_NSER(String bmlcn_NSER) {
		this.bmlcn_NSER = bmlcn_NSER;
	}
	public String getBmlcn_RIB() {
		return bmlcn_RIB;
	}
	public void setBmlcn_RIB(String bmlcn_RIB) {
		this.bmlcn_RIB = bmlcn_RIB;
	}
	public String getBmlcn_RSOC_TIR() {
		return bmlcn_RSOC_TIR;
	}
	public void setBmlcn_RSOC_TIR(String bmlcn_RSOC_TIR) {
		this.bmlcn_RSOC_TIR = bmlcn_RSOC_TIR;
	}
	public String getBmlcn_SQCA() {
		return bmlcn_SQCA;
	}
	public void setBmlcn_SQCA(String bmlcn_SQCA) {
		this.bmlcn_SQCA = bmlcn_SQCA;
	}
	public String getBmlcn_ZBK() {
		return bmlcn_ZBK;
	}
	public void setBmlcn_ZBK(String bmlcn_ZBK) {
		this.bmlcn_ZBK = bmlcn_ZBK;
	}
	public String getBmlcn_ZIB() {
		return bmlcn_ZIB;
	}
	public void setBmlcn_ZIB(String bmlcn_ZIB) {
		this.bmlcn_ZIB = bmlcn_ZIB;
	}
	public String getBmlcn_ANO() {
		return bmlcn_ANO;
	}
	public void setBmlcn_ANO(String bmlcn_ANO) {
		this.bmlcn_ANO = bmlcn_ANO;
	}
	public String getBmlcn_VICE() {
		return bmlcn_VICE;
	}
	public void setBmlcn_VICE(String bmlcn_VICE) {
		this.bmlcn_VICE = bmlcn_VICE;
	}
	public String getBmlcn_AGE_RMT() {
		return bmlcn_AGE_RMT;
	}
	public void setBmlcn_AGE_RMT(String bmlcn_AGE_RMT) {
		this.bmlcn_AGE_RMT = bmlcn_AGE_RMT;
	}
	public String getBmlcn_pk_obj_idt() {
		return bmlcn_pk_obj_idt;
	}
	public void setBmlcn_pk_obj_idt(String bmlcn_pk_obj_idt) {
		this.bmlcn_pk_obj_idt = bmlcn_pk_obj_idt;
	}
	
	
	
	public String getIdLcn() {
		return idLcn;
	}
	public void setIdLcn(String idLcn) {
		this.idLcn = idLcn;
	}
	public String getRibTire() {
		return ribTire;
	}
	public void setRibTire(String ribTire) {
		this.ribTire = ribTire;
	}
	
	public String getLcnTimber() {
		return LcnTimber;
	}
	public void setLcnTimber(String lcnTimber) {
		LcnTimber = lcnTimber;
	}
	public String getBmtr_RIBRMT() {
		return bmtr_RIBRMT;
	}
	public void setBmtr_RIBRMT(String bmtr_RIBRMT) {
		this.bmtr_RIBRMT = bmtr_RIBRMT;
	}
	public String getBmtr_nser() {
		return bmtr_nser;
	}
	public void setBmtr_nser(String bmtr_nser) {
		this.bmtr_nser = bmtr_nser;
	}
	public String getBmlcn_CODE_STATUS() {
		return bmlcn_CODE_STATUS;
	}
	public void setBmlcn_CODE_STATUS(String bmlcn_CODE_STATUS) {
		this.bmlcn_CODE_STATUS = bmlcn_CODE_STATUS;
	}
	public String getBmlcn_SIGN() {
		return bmlcn_SIGN;
	}
	public void setBmlcn_SIGN(String bmlcn_SIGN) {
		this.bmlcn_SIGN = bmlcn_SIGN;
	}
	
	
	
	
}
