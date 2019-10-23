package com.ncrm.tools.Utilitaire;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Iutilitaire {
	public int createDerectory(String url);
	public File createFile(String nameFile);

	public void ZipFolder(String sourceFolderName,String outputFileName) throws Exception;
	public void DeleteDirectoryAfterZip(String Directory);
	public  byte [] getStream(String filename,long offset,int taille) throws IOException;
public  Date formateStringToDate(String str,String format);

public  String formatDateTostirng(Date d,String format);
public boolean checkpattern(String text,String patterntext);
public boolean WsdlIsavailible(String wdsl);
public Date getdateFerierandWeenkend(Date d);	
	
	
}
