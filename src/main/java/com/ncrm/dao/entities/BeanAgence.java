package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanAgence {

	@Id

	String AGE;
	String LIB,LOC,DTEINS;
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public String getLIB() {
		return LIB;
	}
	public void setLIB(String lIB) {
		LIB = lIB;
	}
	public String getLOC() {
		return LOC;
	}
	public void setLOC(String lOC) {
		LOC = lOC;
	}
	public String getDTEINS() {
		return DTEINS;
	}
	public void setDTEINS(String dTEINS) {
		DTEINS = dTEINS;
	}
	public BeanAgence(String aGE, String lIB, String lOC, String dTEINS) {
		super();
		AGE = aGE;
		LIB = lIB;
		LOC = lOC;
		DTEINS = dTEINS;
	}
	public BeanAgence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	

	
	
}
