package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanCompte {

	@Id  
	private String  CPT;
	
	String AGE,CLIENT,TIERS,DTEINS;
	
	public String getCPT() {
		return CPT;
	}
	public void setCPT(String cPT) {
		CPT = cPT;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public String getCLIENT() {
		return CLIENT;
	}
	public void setCLIENT(String cLIENT) {
		CLIENT = cLIENT;
	}
	public String getTIERS() {
		return TIERS;
	}
	public void setTIERS(String tIERS) {
		TIERS = tIERS;
	}
	public String getDTEINS() {
		return DTEINS;
	}
	public void setDTEINS(String dTEINS) {
		DTEINS = dTEINS;
	}
	public BeanCompte(String cPT, String aGE, String cLIENT, String tIERS,
			String dTEINS) {
		super();
		CPT = cPT;
		AGE = aGE;
		CLIENT = cLIENT;
		TIERS = tIERS;
		DTEINS = dTEINS;
	}
	public BeanCompte(String cPT, String aGE, String cLIENT, String tIERS) {
		super();
		CPT = cPT;
		AGE = aGE;
		CLIENT = cLIENT;
		TIERS = tIERS;
	}
	public BeanCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
