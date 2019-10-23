package com.ncrm.dao.entities;

import java.io.Serializable;

public class BeanServicesWin implements Serializable{
	    int idServices;
	    String nomServices,
	       description,
	       disponibles;
	public int getIdServices() {
		return idServices;
	}
	public void setIdServices(int idServices) {
		this.idServices = idServices;
	}
	public String getNomServices() {
		return nomServices;
	}
	public void setNomServices(String nomServices) {
		this.nomServices = nomServices;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDisponibles() {
		return disponibles;
	}
	public void setDisponibles(String disponibles) {
		this.disponibles = disponibles;
	}
	public BeanServicesWin(int idServices, String nomServices,
			String description, String disponibles) {
		super();
		this.idServices = idServices;
		this.nomServices = nomServices;
		this.description = description;
		this.disponibles = disponibles;
	}
	public BeanServicesWin() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
	
	
                   
}
