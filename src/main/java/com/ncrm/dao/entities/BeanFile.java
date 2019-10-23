package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanFile {
	@Id
	int id;
String dteTrt,nser,
zib,
zbk,
loc,
cpt,rib,mnt;

public String getDteTrt() {
	return dteTrt;
}

public void setDteTrt(String dteTrt) {
	this.dteTrt = dteTrt;
}

public String getNser() {
	return nser;
}

public void setNser(String nser) {
	this.nser = nser;
}

public String getZib() {
	return zib;
}

public void setZib(String zib) {
	this.zib = zib;
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

public String getMnt() {
	return mnt;
}

public void setMnt(String mnt) {
	this.mnt = mnt;
}



public BeanFile(String dteTrt, String nser, String zib, String zbk, String loc,
		String cpt, String rib, String mnt) {
	super();
	this.dteTrt = dteTrt;
	this.nser = nser;
	this.zib = zib;
	this.zbk = zbk;
	this.loc = loc;
	this.cpt = cpt;
	this.rib = rib;
	this.mnt = mnt;
}

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

public BeanFile() {
	super();
	// TODO Auto-generated constructor stub
}


}
