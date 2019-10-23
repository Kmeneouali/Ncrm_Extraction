package com.ncrm.ihm.managerBeans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean(name="language2")
@SessionScoped
public class LanguageBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String localeCode;
	 private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	 
	 	 
	 
	 	    public Locale getLocale() {
	 
	 	        return locale;
	 
	 	    }
	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("English", Locale.ENGLISH); //label, value
		countries.put("francais", Locale.FRANCE);
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	
	public String getLocaleCode() {
		return localeCode;
	}


	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public void changeLanguage(String language) {
		
			        locale = new Locale(language);
		
			        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
		
			    }
	
	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){
		String newLocaleValue ="fr";
		newLocaleValue = e.getNewValue().toString();
		
		//loop country map to compare the locale code
                for (Map.Entry<String, Object> entry : countries.entrySet()) {
        System.out.println(newLocaleValue);
        System.out.println(entry.getValue().toString());
        	   if(entry.getValue().toString().equals(newLocaleValue)){
        		
        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());
        		
        	  }
               }
	}

}