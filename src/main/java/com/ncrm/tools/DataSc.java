package com.ncrm.tools;

import org.apache.commons.dbcp.BasicDataSource;



public class DataSc {
	
	
	
	private static BasicDataSource dataSource=null;
	static String urlDb = Propriete.getInsatance().get("DATASOURCE.URL");
	static String loginDb = Propriete.getInsatance().get("DATASOURCE.USERNAME");
	static String passwordDb = Propriete.getInsatance().get("DATASOURCE.PASSWORD");
	static{
		dataSource = new BasicDataSource();
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 dataSource.setUrl(urlDb);
		 dataSource.setUsername(loginDb);
		 dataSource.setPassword(passwordDb);
		 dataSource.setInitialSize(5);
		 dataSource.setMaxActive(100);
//	     dataSource.setMaxWait(10000);
		 dataSource.setTestOnBorrow(true);
		 dataSource.setValidationQuery("select 1");
		 dataSource.setMaxIdle(3);
}
	
	
	public static  BasicDataSource getDataSources() {
	      return dataSource;
	   }
}
