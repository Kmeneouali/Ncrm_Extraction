package com.ncrm.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeanCountImpy {
	@Id
	String ZBK;
	String ZBK_lib,DTE,CountVal,dteSort;
	public String getZBK() {
		return ZBK;
	}
	public void setZBK(String zBK) {
		ZBK = zBK;
	}
	public String getZBK_lib() {
		return ZBK_lib;
	}
	public void setZBK_lib(String zBK_lib) {
		ZBK_lib = zBK_lib;
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
	public BeanCountImpy(String zBK, String zBK_lib, String dTE, String countVal) {
		super();
		ZBK = zBK;
		ZBK_lib = zBK_lib;
		DTE = dTE;
		CountVal = countVal;
	}
	public BeanCountImpy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDteSort() {
		return dteSort;
	}
	public void setDteSort(String dteSort) {
		this.dteSort = dteSort;
	}
	
	

}
