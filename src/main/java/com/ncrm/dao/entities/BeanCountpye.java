package com.ncrm.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanCountpye implements Serializable {
	@Id
	String ZBK,DTE;
	String CountVal;
	public String getZBK() {
		return ZBK;
	}
	public void setZBK(String zBK) {
		ZBK = zBK;
	}
	
	public String getDTE() {
		return DTE;
	}
	public void setDTE(String dTE) {
		DTE = dTE;
	}
	public String getCountVal() {
		return CountVal;
	}
	public void setCountVal(String countVal) {
		CountVal = countVal;
	}
	public BeanCountpye(String zBK,  String dTE, String countVal) {
		super();
		ZBK = zBK;
		DTE = dTE;
		CountVal = countVal;
	}
	public BeanCountpye() {
		super();
		// TODO Auto-generated constructor stub
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
