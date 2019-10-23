package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanPcapt {
	@Id
	private int idpcapt;
	private String cdePcapt,nomPcapt,Type,ageRattachement,secteur,circuit;
    boolean active;
	public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}



	public int getIdpcapt() {
	return idpcapt;
}

public void setIdpcapt(int idpcapt) {
	this.idpcapt = idpcapt;
}

	public String getCdePcapt() {
		return cdePcapt;
	}

	public void setCdePcapt(String cdePcapt) {
		this.cdePcapt = cdePcapt;
	}

	public String getNomPcapt() {
		return nomPcapt;
	}

	

	

	public void setNomPcapt(String nomPcapt) {
		this.nomPcapt = nomPcapt;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	
	public String getAgeRattachement() {
		return ageRattachement;
	}

	public void setAgeRattachement(String ageRattachement) {
		this.ageRattachement = ageRattachement;
	}

	

	public BeanPcapt(String cdePcapt, String nomPcapt, String type,
			String ageRattachement, boolean active) {
		super();
		this.cdePcapt = cdePcapt;
		this.nomPcapt = nomPcapt;
		Type = type;
		this.ageRattachement = ageRattachement;
		this.active = active;
	}

	public BeanPcapt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getCircuit() {
		return circuit;
	}

	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}
	
	
	

}
