package com.ncrm.dao.entities;

import java.io.Serializable;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

@javax.persistence.Entity
public class RecordRemChq implements Serializable {

	@Id
	String bmtr_PK_OBJ_IDT;
	String DATETR;
	@Transient
	String idRemise;
	String bmtr_SEQREM,
	bmtr_AGE,
	bmtr_CPTREM,
	bmtr_REFREM,
	bmtr_NBRVALEUR,
	bmtr_MNTDECLARER,
	bmtr_RefCli,
	bmtr_MNTCALCULER,
	bmtr_TYPEREM;
	
	@Transient
	List<RecordChq> recordsChq=new ArrayList<RecordChq>();

	public String getBmtr_PK_OBJ_IDT() {
		return bmtr_PK_OBJ_IDT;
	}

	public void setBmtr_PK_OBJ_IDT(String bmtr_PK_OBJ_IDT) {
		this.bmtr_PK_OBJ_IDT = bmtr_PK_OBJ_IDT;
	}

	public String getBmtr_SEQREM() {
		return bmtr_SEQREM;
	}

	public void setBmtr_SEQREM(String bmtr_SEQREM) {
		this.bmtr_SEQREM = bmtr_SEQREM;
	}

	public String getBmtr_AGE() {
		return bmtr_AGE;
	}

	public void setBmtr_AGE(String bmtr_AGE) {
		this.bmtr_AGE = bmtr_AGE;
	}

	public String getBmtr_CPTREM() {
		return bmtr_CPTREM;
	}

	public void setBmtr_CPTREM(String bmtr_CPTREM) {
		this.bmtr_CPTREM = bmtr_CPTREM;
	}

	public String getBmtr_REFREM() {
		return bmtr_REFREM;
	}

	public void setBmtr_REFREM(String bmtr_REFREM) {
		this.bmtr_REFREM = bmtr_REFREM;
	}

	public String getBmtr_NBRVALEUR() {
		return bmtr_NBRVALEUR;
	}

	public void setBmtr_NBRVALEUR(String bmtr_NBRVALEUR) {
		this.bmtr_NBRVALEUR = bmtr_NBRVALEUR;
	}

	public String getBmtr_MNTDECLARER() {
		return bmtr_MNTDECLARER;
	}

	public void setBmtr_MNTDECLARER(String bmtr_MNTDECLARER) {
		this.bmtr_MNTDECLARER = bmtr_MNTDECLARER;
	}

	public String getBmtr_RefCli() {
		return bmtr_RefCli;
	}

	public void setBmtr_RefCli(String bmtr_RefCli) {
		this.bmtr_RefCli = bmtr_RefCli;
	}

	public String getBmtr_MNTCALCULER() {
		return bmtr_MNTCALCULER;
	}

	public void setBmtr_MNTCALCULER(String bmtr_MNTCALCULER) {
		this.bmtr_MNTCALCULER = bmtr_MNTCALCULER;
	}

	public String getBmtr_TYPEREM() {
		return bmtr_TYPEREM;
	}

	public void setBmtr_TYPEREM(String bmtr_TYPEREM) {
		this.bmtr_TYPEREM = bmtr_TYPEREM;
	}

	public String getIdRemise() {
		return idRemise;
	}

	public void setIdRemise(String idRemise) {
		this.idRemise = idRemise;
	}

	public List<RecordChq> getRecordsChq() {
		return recordsChq;
	}

	public void setRecordsChq(List<RecordChq> recordsChq) {
		this.recordsChq = recordsChq;
	}

	public String getDATETR() {
		return DATETR;
	}

	public void setDATETR(String dATETR) {
		DATETR = dATETR;
	}
	
	
	
}
