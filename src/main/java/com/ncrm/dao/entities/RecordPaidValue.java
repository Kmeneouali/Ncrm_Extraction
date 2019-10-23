package com.ncrm.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecordPaidValue implements Serializable {
@Id
String zbk,loc,nser,cpt,rib,conf,ope_eta,impy,RDelta,dteec;
String poche;

public String getZbk() {
	return zbk;
}

public void setZbk(String zbk) {
	this.zbk = zbk;
}

public String getLoc() {
	return loc;
}

public void setLoc(String loc) {
	this.loc = loc;
}

public String getNser() {
	return nser;
}

public void setNser(String nser) {
	this.nser = nser;
}

public String getCpt() {
	return cpt;
}

public void setCpt(String cpt) {
	this.cpt = cpt;
}

public String getRib() {
	return rib;
}

public void setRib(String rib) {
	this.rib = rib;
}

public String getPoche() {
	return poche;
}

public void setPoche(String poche) {
	this.poche = poche;
}


public String getConf() {
	return conf;
}

public void setConf(String conf) {
	this.conf = conf;
}

public String getOpe_eta() {
	return ope_eta;
}

public void setOpe_eta(String ope_eta) {
	this.ope_eta = ope_eta;
}

public String getImpy() {
	return impy;
}

public void setImpy(String impy) {
	this.impy = impy;
}

public String getRDelta() {
	return RDelta;
}

public void setRDelta(String rDelta) {
	RDelta = rDelta;
}

public String getDteec() {
	return dteec;
}

public void setDteec(String dteec) {
	this.dteec = dteec;
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
