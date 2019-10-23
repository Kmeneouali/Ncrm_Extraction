package com.ncrm.dao.entities;

import java.util.ArrayList;
import java.util.List;

public class SilcnRecord {
	HeaderSiLCN headerSiLcn;
	List<RecordRemLCN> recordRemiseLcn =new ArrayList<RecordRemLCN>() ;
	

	
	
	
	public HeaderSiLCN getHeaderSiLcn() {
		return headerSiLcn;
	}





	public void setHeaderSiLcn(HeaderSiLCN headerSiLcn) {
		this.headerSiLcn = headerSiLcn;
	}





	public List<RecordRemLCN> getRecordRemiseLcn() {
		return recordRemiseLcn;
	}





	public void setRecordRemiseLcn(List<RecordRemLCN> recordRemiseLcn) {
		this.recordRemiseLcn = recordRemiseLcn;
	}





	public SilcnRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
