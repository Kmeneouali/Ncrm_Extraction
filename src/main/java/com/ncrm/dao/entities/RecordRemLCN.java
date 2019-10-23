package com.ncrm.dao.entities;

import java.io.Serializable;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

@javax.persistence.Entity
public class RecordRemLCN implements Serializable {
    @Id
	String bmtr_pk_obj_idt;
	@Transient
    String idremise;
	
    String bmtr_NSER,
	bmtr_MEM2,
	bmtr_CDECLT,
	bmtr_MNTDECL,
	bmtr_NBCH,
	bmtr_MODE_ESC,
	bmtr_OPE_ETA,
	bmtr_SQCA,
	bmtr_AGE_RMT,
	bmtr_TIERS,
	bmtr_REFCLI,
	bmtr_MNTREEL;
	
	@Transient
	List<RecordLCN>recordsLcn=new ArrayList<RecordLCN>();
	
	
	public String getBmtr_pk_obj_idt() {
		return bmtr_pk_obj_idt;
	}
	public void setBmtr_pk_obj_idt(String bmtr_pk_obj_idt) {
		this.bmtr_pk_obj_idt = bmtr_pk_obj_idt;
	}
	public String getBmtr_MEM2() {
		return bmtr_MEM2;
	}
	public void setBmtr_MEM2(String bmtr_MEM2) {
		this.bmtr_MEM2 = bmtr_MEM2;
	}
	
	
	
	
	public String getBmtr_NSER() {
		return bmtr_NSER;
	}
	public void setBmtr_NSER(String bmtr_NSER) {
		this.bmtr_NSER = bmtr_NSER;
	}
	public String getBmtr_MNTDECL() {
		return bmtr_MNTDECL;
	}
	public void setBmtr_MNTDECL(String bmtr_MNTDECL) {
		this.bmtr_MNTDECL = bmtr_MNTDECL;
	}
	public String getBmtr_NBCH() {
		return bmtr_NBCH;
	}
	public void setBmtr_NBCH(String bmtr_NBCH) {
		this.bmtr_NBCH = bmtr_NBCH;
	}
	public String getBmtr_MODE_ESC() {
		return bmtr_MODE_ESC;
	}
	public void setBmtr_MODE_ESC(String bmtr_MODE_ESC) {
		this.bmtr_MODE_ESC = bmtr_MODE_ESC;
	}
	public String getBmtr_OPE_ETA() {
		return bmtr_OPE_ETA;
	}
	public void setBmtr_OPE_ETA(String bmtr_OPE_ETA) {
		this.bmtr_OPE_ETA = bmtr_OPE_ETA;
	}
	public String getBmtr_SQCA() {
		return bmtr_SQCA;
	}
	public void setBmtr_SQCA(String bmtr_SQCA) {
		this.bmtr_SQCA = bmtr_SQCA;
	}
	public String getBmtr_AGE_RMT() {
		return bmtr_AGE_RMT;
	}
	public void setBmtr_AGE_RMT(String bmtr_AGE_RMT) {
		this.bmtr_AGE_RMT = bmtr_AGE_RMT;
	}
	public String getBmtr_TIERS() {
		return bmtr_TIERS;
	}
	public void setBmtr_TIERS(String bmtr_TIERS) {
		this.bmtr_TIERS = bmtr_TIERS;
	}
	public String getBmtr_REFCLI() {
		return bmtr_REFCLI;
	}
	public void setBmtr_REFCLI(String bmtr_REFCLI) {
		this.bmtr_REFCLI = bmtr_REFCLI;
	}
	public String getBmtr_MNTREEL() {
		return bmtr_MNTREEL;
	}
	public void setBmtr_MNTREEL(String bmtr_MNTREEL) {
		this.bmtr_MNTREEL = bmtr_MNTREEL;
	}
	public List<RecordLCN> getRecordsLcn() {
		return recordsLcn;
	}
	public void setRecordsLcn(List<RecordLCN> recordsLcn) {
		this.recordsLcn = recordsLcn;
	}
	public String getIdremise() {
		return idremise;
	}
	public void setIdremise(String idremise) {
		this.idremise = idremise;
	}
	public String getBmtr_CDECLT() {
		return bmtr_CDECLT;
	}
	public void setBmtr_CDECLT(String bmtr_CDECLT) {
		this.bmtr_CDECLT = bmtr_CDECLT;
	}
	
	
	
	
	
}
