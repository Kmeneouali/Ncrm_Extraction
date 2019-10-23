package com.ncrm;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.ncrm.dao.Idao;
import com.ncrm.dao.entities.RecordChq;
import com.ncrm.dao.entities.RecordLCN;
import com.ncrm.dao.entities.RecordRemLCN;
import com.ncrm.dao.entities.User;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;



@ManagedBean(name="loginBean")
@SessionScoped
public class loginBean implements Serializable{
	/**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(loginBean.class);
	private static final long serialVersionUID = 1L;
private String username;
//
//User usr;
//@ManagedProperty("#{metier}")
//Imetier metier;



	public String loggedName() throws ServletException, IOException {
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
	
	    return username;
	}


//logout event, invalidate session
public String logout() {
    HttpSession session = SessionBean.getSession();
    session.invalidate();
    return "spring_security_login";
}


public String getUsername() {
	try {
		username=loggedName();
		HttpSession session = SessionBean.getSession();
        session.setAttribute("username", username);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return username;
}


public void setUsername(String username) {
	this.username = username;
}















}