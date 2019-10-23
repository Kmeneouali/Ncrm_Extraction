package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanTrt {
	@Id
	private int idT;
	private String  nom_Traitement, Description, DossierEnre,Destinataire;
	private boolean active;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public int getIdT() {
		return idT;
	}
	public void setIdT(int idT) {
		this.idT = idT;
	}
	public String getNom_Traitement() {
		return nom_Traitement;
	}
	public void setNom_Traitement(String nom_Traitement) {
		this.nom_Traitement = nom_Traitement;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDossierEnre() {
		return DossierEnre;
	}
	public void setDossierEnre(String dossierEnre) {
		DossierEnre = dossierEnre;
	}
	
	
	
	
	public BeanTrt(int idT, String nom_Traitement, String description,
			String dossierEnre, String destinataire, boolean active) {
		super();
		this.idT = idT;
		this.nom_Traitement = nom_Traitement;
		Description = description;
		DossierEnre = dossierEnre;
		Destinataire = destinataire;
		this.active = active;
	}

	public String getDestinataire() {
		return Destinataire;
	}

	public void setDestinataire(String destinataire) {
		Destinataire = destinataire;
	}

	public BeanTrt() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
	

}
