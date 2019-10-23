package com.ncrm.dao.entities;

import java.io.Serializable;







import javax.persistence.Id;
import javax.persistence.Transient;

@javax.persistence.Entity
public class BaaRecordLCN implements Serializable {
    @Id
    String bmlcn_pk_obj_idt;
  
    @Transient
    String dteJour,NumSeq,typeDoc;
    @Transient
	String ribTire;
   
    
    String bmlcn_SQCA,
    bmlcn_NSER,bmlcn_ZBK,bmlcn_LOC,bmlcn_CPT,bmlcn_RIB,bmlcn_MNT,bmlcn_cde_NOM_TIREUR,
    bmlcn_DTECRE,bmlcn_DTEEC,bmlcn_cdeAval,bmlcn_CODE_STATUS,bmlcn_DTEEMI,DATE,
    bmlcn_vice,bmlcn_conf,bmlcn_sign,bmlcn_ope_eta,bmtr_nser;


	public String getBmlcn_pk_obj_idt() {
		return bmlcn_pk_obj_idt;
	}


	public void setBmlcn_pk_obj_idt(String bmlcn_pk_obj_idt) {
		this.bmlcn_pk_obj_idt = bmlcn_pk_obj_idt;
	}


	public String getDteJour() {
		return dteJour;
	}


	public void setDteJour(String dteJour) {
		this.dteJour = dteJour;
	}


	public String getNumSeq() {
		return NumSeq;
	}


	public void setNumSeq(String numSeq) {
		NumSeq = numSeq;
	}


	public String getTypeDoc() {
		return typeDoc;
	}


	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}


	public String getRibTire() {
		return ribTire;
	}


	public void setRibTire(String ribTire) {
		this.ribTire = ribTire;
	}


	public String getBmlcn_SQCA() {
		return bmlcn_SQCA;
	}


	public void setBmlcn_SQCA(String bmlcn_SQCA) {
		this.bmlcn_SQCA = bmlcn_SQCA;
	}


	public String getBmlcn_NSER() {
		return bmlcn_NSER;
	}


	public void setBmlcn_NSER(String bmlcn_NSER) {
		this.bmlcn_NSER = bmlcn_NSER;
	}


	public String getBmlcn_ZBK() {
		return bmlcn_ZBK;
	}


	public void setBmlcn_ZBK(String bmlcn_ZBK) {
		this.bmlcn_ZBK = bmlcn_ZBK;
	}


	public String getBmlcn_LOC() {
		return bmlcn_LOC;
	}


	public void setBmlcn_LOC(String bmlcn_LOC) {
		this.bmlcn_LOC = bmlcn_LOC;
	}


	


	public String getBmlcn_CPT() {
		return bmlcn_CPT;
	}


	public void setBmlcn_CPT(String bmlcn_CPT) {
		this.bmlcn_CPT = bmlcn_CPT;
	}


	public String getBmlcn_RIB() {
		return bmlcn_RIB;
	}


	public void setBmlcn_RIB(String bmlcn_RIB) {
		this.bmlcn_RIB = bmlcn_RIB;
	}


	public String getBmlcn_MNT() {
		return bmlcn_MNT;
	}


	public void setBmlcn_MNT(String bmlcn_MNT) {
		this.bmlcn_MNT = bmlcn_MNT;
	}


	public String getBmlcn_cde_NOM_TIREUR() {
		return bmlcn_cde_NOM_TIREUR;
	}


	public void setBmlcn_cde_NOM_TIREUR(String bmlcn_cde_NOM_TIREUR) {
		this.bmlcn_cde_NOM_TIREUR = bmlcn_cde_NOM_TIREUR;
	}


	public String getBmlcn_DTECRE() {
		return bmlcn_DTECRE;
	}


	public void setBmlcn_DTECRE(String bmlcn_DTECRE) {
		this.bmlcn_DTECRE = bmlcn_DTECRE;
	}


	public String getBmlcn_DTEEC() {
		return bmlcn_DTEEC;
	}


	public void setBmlcn_DTEEC(String bmlcn_DTEEC) {
		this.bmlcn_DTEEC = bmlcn_DTEEC;
	}


	public String getBmlcn_cdeAval() {
		return bmlcn_cdeAval;
	}


	public void setBmlcn_cdeAval(String bmlcn_cdeAval) {
		this.bmlcn_cdeAval = bmlcn_cdeAval;
	}


	public String getBmlcn_CODE_STATUS() {
		return bmlcn_CODE_STATUS;
	}


	public void setBmlcn_CODE_STATUS(String bmlcn_CODE_STATUS) {
		this.bmlcn_CODE_STATUS = bmlcn_CODE_STATUS;
	}


	public String getBmlcn_DTEEMI() {
		return bmlcn_DTEEMI;
	}


	public void setBmlcn_DTEEMI(String bmlcn_DTEEMI) {
		this.bmlcn_DTEEMI = bmlcn_DTEEMI;
	}


	public String getDATE() {
		return DATE;
	}


	public void setDATE(String dATE) {
		DATE = dATE;
	}


	public String getBmlcn_ope_eta() {
		return bmlcn_ope_eta;
	}


	public void setBmlcn_ope_eta(String bmlcn_ope_eta) {
		this.bmlcn_ope_eta = bmlcn_ope_eta;
	}


	public String getBmtr_nser() {
		return bmtr_nser;
	}


	public void setBmtr_nser(String bmtr_nser) {
		this.bmtr_nser = bmtr_nser;
	}


	public String getBmlcn_vice() {
		return bmlcn_vice;
	}


	public void setBmlcn_vice(String bmlcn_vice) {
		this.bmlcn_vice = bmlcn_vice;
	}


	public String getBmlcn_conf() {
		return bmlcn_conf;
	}


	public void setBmlcn_conf(String bmlcn_conf) {
		this.bmlcn_conf = bmlcn_conf;
	}


	public String getBmlcn_sign() {
		return bmlcn_sign;
	}


	public void setBmlcn_sign(String bmlcn_sign) {
		this.bmlcn_sign = bmlcn_sign;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	
	
	
	
	
}
