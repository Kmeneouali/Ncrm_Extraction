package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanReport {
	@Id
	private int idR;
	private String Id_report, descreption, modeleJRXML,typeGeneration, idT;
    boolean active;
	public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public int getIdR() {
	return idR;
}

public void setIdR(int idR) {
	this.idR = idR;
}

public String getId_report() {
	return Id_report;
}

public void setId_report(String id_report) {
	Id_report = id_report;
}

public String getDescreption() {
	return descreption;
}

public void setDescreption(String descreption) {
	this.descreption = descreption;
}

public String getModeleJRXML() {
	return modeleJRXML;
}

public void setModeleJRXML(String modeleJRXML) {
	this.modeleJRXML = modeleJRXML;
}

public String getIdT() {
	return idT;
}

public void setIdT(String idT) {
	this.idT = idT;
}

public BeanReport() {
	super();
	// TODO Auto-generated constructor stub
}

public String getTypeGeneration() {
	return typeGeneration;
}

public void setTypeGeneration(String typeGeneration) {
	this.typeGeneration = typeGeneration;
}

public BeanReport(int idR, String id_report, String descreption,
		String modeleJRXML, String typeGeneration, String idT, boolean active) {
	super();
	this.idR = idR;
	Id_report = id_report;
	this.descreption = descreption;
	this.modeleJRXML = modeleJRXML;
	this.typeGeneration = typeGeneration;
	this.idT = idT;
	this.active = active;
}








	

}
