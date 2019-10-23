/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ncrm.tools;
// -----------------------------------------------------------------------------
// PropertyFiles.java
// -----------------------------------------------------------------------------

/*
 * =============================================================================
 * Copyright (c) 1998-2005 Jeffrey M. Hunter. All rights reserved.
 *
 * All source code and material located at the Internet address of
 * http://www.idevelopment.info is the copyright of Jeffrey M. Hunter, 2005 and
 * is protected under copyright laws of the United States. This source code may
 * not be hosted on any other site without my express, prior, written
 * permission. Application to host any of the material elsewhere can be made by
 * contacting me at jhunter@idevelopment.info.
 *
 * I have made every effort and taken great care in making sure that the source
 * code and other content included on my web site is technically accurate, but I
 * disclaim any and all responsibility for any loss, damage or destruction of
 * data or any other property which may arise from relying on it. I will in no
 * case be liable for any monetary damages arising from such loss, damage or
 * destruction.
 *
 * As with any code, ensure to test this code in a development environment
 * before attempting to run it in production.
 * =============================================================================
 */

import java.io.File;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

/**
 * -----------------------------------------------------------------------------
 * Used to provide an example of how to get/set Properties and load/save
 * property files.
 *
 * @version 1.0
 * @author  Jeffrey M. Hunter  (jhunter@idevelopment.info)
 * @author  http://www.idevelopment.info
 * -----------------------------------------------------------------------------
 */

public class Propriete {
	

    private static Propriete instance=null;
    private static final String PROPFILE= new File("D:\\NCRM\\Appli\\NCRM_EXTRACTION\\config\\configs.properties").getAbsolutePath();
    private SortedProperties props;

    private Propriete() {
        props=new SortedProperties();
        this.loadProperties();
    }    

    public static Propriete getInsatance()
    {
        if (instance==null)
            instance = new Propriete();
        
        return instance;
    }

    @SuppressWarnings("unused")
	private static Properties createDefaultProperties() {

        Properties tempProp = new Properties();
        //tempProp.setProperty("company_name", "iDevelopment, Inc.");
        return tempProp;

    }

    public String get(String key)
    {
        if (props.containsKey(key))
            return props.getProperty(key);

        return "";
        
    }

    public void printProperties() {

        System.out.println();        
        System.out.println("========================================");
        System.out.println("+---------------------------------------+");
        System.out.println("| Print Application Properties          |");
        System.out.println("+---------------------------------------+");
        props.list(System.out);
        System.out.println();
    }


    private void saveProperties() {

        OutputStream propsFile;

        try {
            propsFile = new FileOutputStream(PROPFILE);
            props.store(propsFile, "Client properties file");
            propsFile.close();
        } catch (IOException ioe) {
            System.out.println("I/O Exception.");
            ioe.printStackTrace();
            
        }

    }


    private Properties loadProperties() {

        InputStream propsFile;
        

        try {
            propsFile = getClass().getClassLoader().getResourceAsStream("configs.properties");//new FileInputStream(PROPFILE);
            props.load(propsFile);
            propsFile.close();
        } catch (IOException ioe) {
            System.out.println("I/O Exception.");
            ioe.printStackTrace();
        }

        return props;

    }


    public Properties alterProperty(String key, String value) {

        // Si il contient
        if (props.containsKey(key))
        {
            props.setProperty(key, value);
        }
        else
        {
            props.put(key, value);
        }

        this.saveProperties();
        return props;

    }

    public Properties getProperties()
    {
        return props;
    }
}

