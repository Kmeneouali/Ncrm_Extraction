package com.ncrm.dao.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="PAGE")

public class Page implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	
	private String targetPath;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "PAGE_ROLE", joinColumns = @JoinColumn(name = "ID_PAGE", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "id"))
    private Set<Role> roles=new HashSet<Role>();

	
	
	public Page() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role r) {
		if (!getRoles().contains(r)) {
			roles.add(r);

		}
		if ((r.getPages()!=null)&&(!r.getPages().contains(this))) {
			r.getPages().add(this);
		}
	}
	
	public void removeRole(Role r) {
		 if (!getRoles().contains(r)) {
			 roles.remove(r);
				r.setPages(null);

		 }
		}
	
}