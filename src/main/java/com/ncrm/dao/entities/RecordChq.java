package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class RecordChq {
@Id
String bmch_PK_OBJ_IDT;
@Transient
String idChq;
String bmch_ZBK,
bmch_NUMCHQ,
bmch_RIB,
bmch_MNT,
bmch_DTEEMIS,
bmch_CONFOR,
bmch_REJETCONF,
bmch_IMGRECTO,
bmch_IMGVERSO;
public String getBmch_PK_OBJ_IDT() {
	return bmch_PK_OBJ_IDT;
}
public void setBmch_PK_OBJ_IDT(String bmch_PK_OBJ_IDT) {
	this.bmch_PK_OBJ_IDT = bmch_PK_OBJ_IDT;
}
public String getBmch_ZBK() {
	return bmch_ZBK;
}
public void setBmch_ZBK(String bmch_ZBK) {
	this.bmch_ZBK = bmch_ZBK;
}
public String getBmch_NUMCHQ() {
	return bmch_NUMCHQ;
}
public void setBmch_NUMCHQ(String bmch_NUMCHQ) {
	this.bmch_NUMCHQ = bmch_NUMCHQ;
}
public String getBmch_RIB() {
	return bmch_RIB;
}
public void setBmch_RIB(String bmch_RIB) {
	this.bmch_RIB = bmch_RIB;
}
public String getBmch_MNT() {
	return bmch_MNT;
}
public void setBmch_MNT(String bmch_MNT) {
	this.bmch_MNT = bmch_MNT;
}
public String getBmch_DTEEMIS() {
	return bmch_DTEEMIS;
}
public void setBmch_DTEEMIS(String bmch_DTEEMIS) {
	this.bmch_DTEEMIS = bmch_DTEEMIS;
}
public String getBmch_CONFOR() {
	return bmch_CONFOR;
}
public void setBmch_CONFOR(String bmch_CONFOR) {
	this.bmch_CONFOR = bmch_CONFOR;
}
public String getBmch_REJETCONF() {
	return bmch_REJETCONF;
}
public void setBmch_REJETCONF(String bmch_REJETCONF) {
	this.bmch_REJETCONF = bmch_REJETCONF;
}
public String getBmch_IMGRECTO() {
	return bmch_IMGRECTO;
}
public void setBmch_IMGRECTO(String bmch_IMGRECTO) {
	this.bmch_IMGRECTO = bmch_IMGRECTO;
}
public String getBmch_IMGVERSO() {
	return bmch_IMGVERSO;
}
public void setBmch_IMGVERSO(String bmch_IMGVERSO) {
	this.bmch_IMGVERSO = bmch_IMGVERSO;
}
public String getIdChq() {
	return idChq;
}
public void setIdChq(String idChq) {
	this.idChq = idChq;
}


}
