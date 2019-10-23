package com.ncrm.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanSuiviPhysique implements Serializable {
@Id
	private String DATE, LECTEUR;
	private String circuit, LECTEUR_LIB, NBR_CHQ_DEC, NBR_CHQ_TRT,DATE_LECTEUR,
			NBR_CHQ_SUPP, NBR_CHQ_VF, NBR_CHQ_RD, NBR_CHQ_IMP;
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getLECTEUR() {
		return LECTEUR;
	}
	public void setLECTEUR(String lECTEUR) {
		LECTEUR = lECTEUR;
	}
	public String getCircuit() {
		return circuit;
	}
	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}
	public String getLECTEUR_LIB() {
		return LECTEUR_LIB;
	}
	public void setLECTEUR_LIB(String lECTEUR_LIB) {
		LECTEUR_LIB = lECTEUR_LIB;
	}
	public String getNBR_CHQ_DEC() {
		return NBR_CHQ_DEC;
	}
	public void setNBR_CHQ_DEC(String nBR_CHQ_DEC) {
		NBR_CHQ_DEC = nBR_CHQ_DEC;
	}
	public String getNBR_CHQ_TRT() {
		return NBR_CHQ_TRT;
	}
	public void setNBR_CHQ_TRT(String nBR_CHQ_TRT) {
		NBR_CHQ_TRT = nBR_CHQ_TRT;
	}
	public String getNBR_CHQ_SUPP() {
		return NBR_CHQ_SUPP;
	}
	public void setNBR_CHQ_SUPP(String nBR_CHQ_SUPP) {
		NBR_CHQ_SUPP = nBR_CHQ_SUPP;
	}
	public String getNBR_CHQ_VF() {
		return NBR_CHQ_VF;
	}
	public void setNBR_CHQ_VF(String nBR_CHQ_VF) {
		NBR_CHQ_VF = nBR_CHQ_VF;
	}
	public String getNBR_CHQ_RD() {
		return NBR_CHQ_RD;
	}
	public void setNBR_CHQ_RD(String nBR_CHQ_RD) {
		NBR_CHQ_RD = nBR_CHQ_RD;
	}
	public String getNBR_CHQ_IMP() {
		return NBR_CHQ_IMP;
	}
	public String getDATE_LECTEUR() {
		return DATE_LECTEUR;
	}
	public void setDATE_LECTEUR(String dATE_LECTEUR) {
		DATE_LECTEUR = dATE_LECTEUR;
	}
	public void setNBR_CHQ_IMP(String nBR_CHQ_IMP) {
		NBR_CHQ_IMP = nBR_CHQ_IMP;
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
