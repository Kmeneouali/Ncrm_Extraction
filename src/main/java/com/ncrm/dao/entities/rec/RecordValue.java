package com.ncrm.dao.entities.rec;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class RecordValue implements Serializable{

	@Id
	private String  pkObjIdt;	
	
	@Transient
	private String 	codeEnreg;		
	
	private String  idWebCapture ,		
					cdePcapt,		
					nser,		
					ribTire	,	
					mnt,		
					signature,
					conf,
					opeEta,
					cdeAnomalie,
					dteEchee,
					rio;

	public String getCodeEnreg() {
		return codeEnreg;
	}

	public void setCodeEnreg(String codeEnreg) {
		this.codeEnreg = codeEnreg;
	}

	public String getIdWebCapture() {
		return idWebCapture;
	}

	public void setIdWebCapture(String idWebCapture) {
		this.idWebCapture = idWebCapture;
	}

	public String getCdePcapt() {
		return cdePcapt;
	}

	public void setCdePcapt(String cdePcapt) {
		this.cdePcapt = cdePcapt;
	}

	public String getNser() {
		return nser;
	}

	public void setNser(String nser) {
		this.nser = nser;
	}

	public String getRibTire() {
		return ribTire;
	}

	public void setRibTire(String ribTire) {
		this.ribTire = ribTire;
	}

	public String getMnt() {
		return mnt;
	}

	public void setMnt(String mnt) {
		this.mnt = mnt;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getConf() {
		return conf;
	}

	public void setConf(String conf) {
		this.conf = conf;
	}

	public String getOpeEta() {
		return opeEta;
	}

	public void setOpeEta(String opeEta) {
		this.opeEta = opeEta;
	}

	public String getCdeAnomalie() {
		return cdeAnomalie;
	}

	public void setCdeAnomalie(String cdeAnomalie) {
		this.cdeAnomalie = cdeAnomalie;
	}

	public String getRio() {
		return rio;
	}

	public void setRio(String rio) {
		this.rio = rio;
	}

	public RecordValue(String codeEnreg, String idWebCapture, String cdePcapt,
			String nser, String ribTire, String mnt, String signature,
			String conf, String opeEta, String cdeAnomalie, String rio) {
		super();
		this.codeEnreg = codeEnreg;
		this.idWebCapture = idWebCapture;
		this.cdePcapt = cdePcapt;
		this.nser = nser;
		this.ribTire = ribTire;
		this.mnt = mnt;
		this.signature = signature;
		this.conf = conf;
		this.opeEta = opeEta;
		this.cdeAnomalie = cdeAnomalie;
		this.rio = rio;
	}

	public RecordValue() {
		super();
	}

	public String getDteEchee() {
		return dteEchee;
	}

	public void setDteEchee(String dteEchee) {
		this.dteEchee = dteEchee;
	}

	public String getPkObjIdt() {
		return pkObjIdt;
	}

	public void setPkObjIdt(String pkObjIdt) {
		this.pkObjIdt = pkObjIdt;
	}
			
			
			
	
	

	
	
	
	
	
}
