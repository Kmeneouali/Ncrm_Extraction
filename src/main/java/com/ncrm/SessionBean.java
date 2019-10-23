package com.ncrm;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ncrm.dao.entities.User;
 
public class SessionBean {
 
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
 
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
 
//    public static User getUserName() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//                .getExternalContext().getSession(false);
//        return (User) session.getAttribute("user");
//    }
// 
    public static User getUser() {
        HttpSession session = getSession();
        if (session != null)
            return (User) session.getAttribute("user");
        else
            return null;
    }
}
