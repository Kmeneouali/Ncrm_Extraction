package com.ncrm.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanDetailSuiviPhysique implements Serializable {
@Id
	private String cmc7;
private String DATE, lecteur,
				nser,
				zbkt,
				loct,
				cptt,
				ribt,
				conf,
				mnt,
				FLAG_IMP,
				ope_eta,
				dateReception,
				receptionist;







	


	public String getCmc7() {
	return cmc7;
}


public void setCmc7(String cmc7) {
	this.cmc7 = cmc7;
}


public String getMnt() {
	return mnt;
}


public void setMnt(String mnt) {
	this.mnt = mnt;
}


	public String getDATE() {
	return DATE;
}


public void setDATE(String dATE) {
	DATE = dATE;
}


public String getLecteur() {
	return lecteur;
}


public void setLecteur(String lecteur) {
	this.lecteur = lecteur;
}


public String getNser() {
	return nser;
}


public void setNser(String nser) {
	this.nser = nser;
}




	public String getZbkt() {
	return zbkt;
}


public void setZbkt(String zbkt) {
	this.zbkt = zbkt;
}


public String getLoct() {
	return loct;
}


public void setLoct(String loct) {
	this.loct = loct;
}


public String getCptt() {
	return cptt;
}


public void setCptt(String cptt) {
	this.cptt = cptt;
}


public String getRibt() {
	return ribt;
}


public void setRibt(String ribt) {
	this.ribt = ribt;
}


public String getConf() {
	return conf;
}


public void setConf(String conf) {
	this.conf = conf;
}


public String getFLAG_IMP() {
	return FLAG_IMP;
}


public void setFLAG_IMP(String fLAG_IMP) {
	FLAG_IMP = fLAG_IMP;
}


public String getOpe_eta() {
	return ope_eta;
}


public void setOpe_eta(String ope_eta) {
	this.ope_eta = ope_eta;
}


public String getDateReception() {
	return dateReception;
}


public void setDateReception(String dateReception) {
	this.dateReception = dateReception;
}


public String getReceptionist() {
	return receptionist;
}


public void setReceptionist(String receptionist) {
	this.receptionist = receptionist;
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
