package com.ncrm.dao.entities;

import java.io.Serializable;




import javax.persistence.Id;


public class HeaderSiLCN implements Serializable {
    private String idheader;
	private String nbrRemise;
	private String dteGener;
	private String nbrLcn;
	private String mnttotal;
	public String getIdheader() {
		return idheader;
	}
	public void setIdheader(String idheader) {
		this.idheader = idheader;
	}
	public String getNbrRemise() {
		return nbrRemise;
	}
	public void setNbrRemise(String nbrRemise) {
		this.nbrRemise = nbrRemise;
	}
	public String getDteGener() {
		return dteGener;
	}
	public void setDteGener(String dteGener) {
		this.dteGener = dteGener;
	}
	public String getNbrLcn() {
		return nbrLcn;
	}
	public void setNbrLcn(String nbrLcn) {
		this.nbrLcn = nbrLcn;
	}
	public String getMnttotal() {
		return mnttotal;
	}
	public void setMnttotal(String mnttotal) {
		this.mnttotal = mnttotal;
	}
	
	
	
	
}
