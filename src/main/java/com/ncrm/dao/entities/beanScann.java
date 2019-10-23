package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class beanScann {
	
	@Id
	String cdeScanner;
	String age, type;
	
	@Transient
	String lib;

	public String getCdeScanner() {
		return cdeScanner;
	}

	public void setCdeScanner(String cdeScanner) {
		this.cdeScanner = cdeScanner;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public beanScann(String cdeScanner, String age, String type, String lib) {
		super();
		this.cdeScanner = cdeScanner;
		this.age = age;
		this.type = type;
		this.lib = lib;
	}

	public beanScann() {
		super();
	}

}
