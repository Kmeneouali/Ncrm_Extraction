package com.ncrm.dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="user")
//@NamedQuery(name="findUser",query="select usr from User usr where usr_name=:USE_NAME or usr_login=:LOGIN or usr_password=:PWD")

public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long  usr_id;
	 String usr_name, usr_login, usr_password, usr_login_start_time,
			usr_last_login_time, usr_password_expiry, usr_IsLocked,
			usr_ip_adress;
	//bi-directional many-to-one association to Role
		@ManyToOne(fetch=FetchType.EAGER)
		private Role role;

	

	public Long getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(Long usr_id) {
		this.usr_id = usr_id;
	}

	public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	public String getUsr_login() {
		return usr_login;
	}

	public void setUsr_login(String usr_login) {
		this.usr_login = usr_login;
	}

	public String getUsr_password() {
		return usr_password;
	}

	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}

	public String getUsr_login_start_time() {
		return usr_login_start_time;
	}

	public void setUsr_login_start_time(String usr_login_start_time) {
		this.usr_login_start_time = usr_login_start_time;
	}

	public String getUsr_last_login_time() {
		return usr_last_login_time;
	}

	public void setUsr_last_login_time(String usr_last_login_time) {
		this.usr_last_login_time = usr_last_login_time;
	}

	public String getUsr_password_expiry() {
		return usr_password_expiry;
	}

	public void setUsr_password_expiry(String usr_password_expiry) {
		this.usr_password_expiry = usr_password_expiry;
	}

	public String getUsr_IsLocked() {
		return usr_IsLocked;
	}

	public void setUsr_IsLocked(String usr_IsLocked) {
		this.usr_IsLocked = usr_IsLocked;
	}

	public String getUsr_ip_adress() {
		return usr_ip_adress;
	}

	public void setUsr_ip_adress(String usr_ip_adress) {
		this.usr_ip_adress = usr_ip_adress;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	

}
