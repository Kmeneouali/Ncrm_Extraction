package com.ncrm.dao.entities.rec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class RecordRemise implements Serializable{
	@Id
	private String  pkObjIdtRem;	
	@Transient
	private String  codeEnreg;	
			String  idWebCapture,		
					cdePcapt,		
					nser,		
					cdeAge,	
					ribRemettant,		
					mnt,	
					typeRemise,	
					opeEta,
					cdeAnomalie;
	@Transient
	String filler	;

	 @Transient
	List<RecordValue> RecordsValue=new ArrayList<>();
	
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

	public String getCdeAge() {
		return cdeAge;
	}

	public void setCdeAge(String cdeAge) {
		this.cdeAge = cdeAge;
	}

	public String getRibRemettant() {
		return ribRemettant;
	}

	public void setRibRemettant(String ribRemettant) {
		this.ribRemettant = ribRemettant;
	}

	public String getMnt() {
		return mnt;
	}

	public void setMnt(String mnt) {
		this.mnt = mnt;
	}

	public String getTypeRemise() {
		return typeRemise;
	}

	public void setTypeRemise(String typeRemise) {
		this.typeRemise = typeRemise;
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

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public RecordRemise(String codeEnreg, String idWebCapture, String cdePcapt,
			String nser, String cdeAge, String ribRemettant, String mnt,
			String typeRemise, String opeEta, String cdeAnomalie, String filler) {
		super();
		this.codeEnreg = codeEnreg;
		this.idWebCapture = idWebCapture;
		this.cdePcapt = cdePcapt;
		this.nser = nser;
		this.cdeAge = cdeAge;
		this.ribRemettant = ribRemettant;
		this.mnt = mnt;
		this.typeRemise = typeRemise;
		this.opeEta = opeEta;
		this.cdeAnomalie = cdeAnomalie;
		this.filler = filler;
	}

	public RecordRemise() {
		super();
	}

	public List<RecordValue> getRecordsValue() {
		return RecordsValue;
	}

	public void setRecordsValue(List<RecordValue> recordsValue) {
		RecordsValue = recordsValue;
	}

	public String getPkObjIdtRem() {
		return pkObjIdtRem;
	}

	public void setPkObjIdtRem(String pkObjIdtRem) {
		this.pkObjIdtRem = pkObjIdtRem;
	}

	
		
		


	
	
	
	
}
