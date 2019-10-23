package com.ncrm.dao.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="ROLE")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name",length=20,unique=true) 
	private String name;

	

	//bi-directional many-to-one association to UserGroup
	@OneToMany(mappedBy="role")
	private List<User> users;
	
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private Set<Page> pages= new HashSet<Page>();
	
	
	
	public Role() {
	}

	

	




	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	

	
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Set<Page> getPages() {
		return pages;
	}


	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	
	public void addPage(Page p) {
		if (!getPages().contains(p)) {
			pages.add(p);

		}
		if (!p.getRoles().contains(this)) {
			p.getRoles().add(this);
		}
	}
	

	
	public void removePage(Page p) {
		 if ((getPages()!=null)&&(!getPages().contains(p)) ){
			 pages.remove(p);
				p.setRoles(null);

		 }
		}

	

}