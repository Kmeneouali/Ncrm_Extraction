package com.ncrm.tools.Utilitaire;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;






public class UtilitaireImpl implements Iutilitaire{
	
	public int createDerectory(String urlDossier) {
		final int NEWDOSSIER = 1;
		final int DOSSIEREXIST = 2;
		final int ERREURCREATION = 3;
		int flag = 0;
		try {
			File DirectroryOutput = new File(urlDossier);
			if (!DirectroryOutput.exists()) {

				//log.debug("@@@ : Creation D'un nouveau dossier d'enregistrement pour le traitment selectionne"+ urlDossier);
				boolean result = DirectroryOutput.mkdirs();
				if (result) {
					//log.debug("@@@ : Nouveau Dossier est bien Crier " + urlDossier);
					flag = NEWDOSSIER;
				} else {
					//log.error("+++ : erreur lors de la cr�ation du dossier  ... "+ urlDossier);
					flag = ERREURCREATION;
				}
			} else {
				//log.debug("@@@ : Dossier existe Deja...  ");
				// System.out.println("Etat Cree dossier Exist");
				flag = DOSSIEREXIST;
			}

		} catch (Exception e) {
			//log.error("+++ : erreur lors de la cr�ation du dossier ",e);
		}

		return flag;
	}
	
	public File createFile(String nameFile) {
   
			final int NEWFILE = 1;
			final int FILEEXIST = 2;
			final int ERREURCREATION = 3;
			File file = null;
			int flag = 0;
			try {
				 
			      file = new File(nameFile);
		 
			      if (file.createNewFile()){
			    	  //log.debug("@@@ : Creation D'un nouveau Fichier "+ nameFile);
			        flag=NEWFILE;
			      }else{
			    		//log.debug("@@@ : Fichier existe Deja...  ");
			        flag=FILEEXIST;
			      }
		 
		    	} catch (IOException e) {
		    		flag=ERREURCREATION ;
		    		//log.error("+++ : erreur lors de la cr�ation du fichier ",e);
			}
		return file;
	}
	
	public void ZipFolder(String sourceFolderName,String outputFileName) throws Exception {
        FileOutputStream fos = new FileOutputStream(outputFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);
        zos.setLevel(9);
        //log.debug(" @@@ : Begin to compress folder : " + sourceFolderName + " to " + outputFileName);       
        addFolder(zos, sourceFolderName, sourceFolderName);
        zos.close();
        //log.debug(" @@@ : zipFolder ended successfully!");   
    }
 
    private static void addFolder(ZipOutputStream zos,String folderName,String baseFolderName)throws Exception{
        File f = new File(folderName);
        try {
			
		
        if(f.exists()){
 
            if(f.isDirectory()){
            	   //log.debug(" @@@ : Check if folder is empty " ); 
                if(!folderName.equalsIgnoreCase(baseFolderName)){
                    String entryName = folderName.substring(baseFolderName.length()+1,folderName.length()) + File.separatorChar;
                    //log.debug(" @@@ : Adding folder entry " + entryName); 
                    ZipEntry ze= new ZipEntry(entryName);
                    zos.putNextEntry(ze);    
                }
                File f2[] = f.listFiles();
                for(int i=0;i<f2.length;i++){
                    addFolder(zos,f2[i].getAbsolutePath(),baseFolderName);    
                }
            }else{
                //add file
                //extract the relative name for entry purpose
                String entryName = folderName.substring(baseFolderName.length()+1,folderName.length());
                
                //log.debug(" @@@ :Adding file entry " + entryName + "..."); 
                ZipEntry ze= new ZipEntry(entryName);
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(folderName);
                int len;
                byte buffer[] = new byte[1024];
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
                zos.closeEntry();
                //log.debug(" @@@ :OK for Compression..."); 
               
 
            }
        }else{
        	//log.debug("+++ : File or directory not found " + folderName); 
        	}
        } 
        catch (Exception e) {
        	//log.debug("+++ : File or directory not found ", e);
		} 
        
        
 
    
		
	}

	
	public void DeleteDirectoryAfterZip(String Directory) {
		File directory = new File(Directory);
		 
    	//make sure directory exists
    	if(!directory.exists()){
 
           System.out.println("Directory does not exist.");
          //log.error("+++ : Directory does not exist.");
          
 
        }else{
 
           try{
        	   //log.debug("=== : Supprission du dossier .");
               delete(directory);
 
           }catch(IOException e){
        	   //log.error("+++ : Erreur Supprission du dossier .");
               
              
           }
        }
    	 //log.debug("@@@ : fin Supprission .");
    	
    	
    }
 
    public static void delete(File file)
    	throws IOException{
 
    	if(file.isDirectory()){
 
    		//directory is empty, then delete it
    		if(file.list().length==0){
              
    		   file.delete();
    		   
    		   //log.debug("@@@ :Directory is deleted : " + file.getAbsolutePath());
    		   
 
    		}else{
 
    		   //list all the directory contents
        	   String files[] = file.list();
 
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
 
        	      //recursive delete
        	     delete(fileDelete);
        	   }
 
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	     file.delete();
           	  //log.debug("@@@ :Directory is deleted : " + file.getAbsolutePath());
        	     
        	   }
    		}
 
    	}else{
    		//if file, then delete it
    		file.delete();
    		 //log.debug("@@@ : File is deleted : " + file.getAbsolutePath());
    		
    	}
    
    }
	
	public byte [] getStream(String filename,long offset,int taille) throws IOException
	{
		
		RandomAccessFile raf1=null;
		byte [] stm=null;
				
		try {
			
			raf1 = new RandomAccessFile(filename, "r");
			raf1.seek(offset);			
			stm=new byte[taille];						
			raf1.read(stm);
			
		}catch(Exception exp)
		{
			exp.printStackTrace();
			stm=null;
		}finally
		{
			
			if (raf1!=null)
				raf1.close();
			
			raf1=null;
		}
								
		return stm;

	}
	public  Date formateStringToDate(String str,String format){
		Date d = null;
		SimpleDateFormat formatter;
		try {
		  formatter = new SimpleDateFormat(format);//"yyyyMMdd"
			
			
		
				d = formatter.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return d;
	}
	
	
	public  String formatDateTostirng(Date d,String format){//yyyy-MM-dd
		String dateEcheeFormater=new SimpleDateFormat(format).format(d);
		return dateEcheeFormater ;
	}


	
	public boolean checkpattern(String text,String patterntext) {
		Pattern pattern;
		Matcher matcher;
		boolean isOk;

		// String mot="013.CRE.DEM.20130617";
		//log.debug("=== : Verification est ce que le "+text  + "respect le pattern : "+patterntext); 
		
		pattern = Pattern.compile(patterntext, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(text);
		if (matcher.find()) {
			//log.debug("@@@ : la regle de nommage est bonne  !... "); 
			isOk = true;
		} else {
			//log.debug("@@@ : la regle de nommage n'est pas bonne!... "); 
			isOk = false;
		}
		return isOk;
	}
	public boolean WsdlIsavailible(String wsdl) {
		boolean flag=false;
		//log.debug("===: test la disponibilit� du Wsdl "+wsdl); 
		String urlStr = wsdl;
	    URL url = null;
	    URLConnection urlConnection = null;
	    try {
	      url = new URL(urlStr);
	      urlConnection = url.openConnection();
	      if(urlConnection.getContent() != null) {
	    	  //log.debug("===: le Wsdl "+wsdl +" :"+"est disponible"); 
	    	  flag=true;
	      } else {
	    	  //log.debug("===: le Wsdl "+wsdl +" :"+"est indisponible"); 
	    	  flag=false;
	      }
	    } catch (MalformedURLException ex) {
	    	//log.debug("+++ mauvais URL  :"+wsdl +" :",ex); 
	    	 flag=false;
	    } catch (IOException ex) {
	    	
	    	 flag=false;
	    	 //log.debug("+++ �chec de la connexion d'ouverture. Peut-�tre WS "+wsdl+" n'est pas en place?",ex);
	    } 
	 catch (Exception ex) {
    	 flag=false;
    	 //log.debug("+++ �chec de la connexion d'ouverture. Peut-�tre WS "+wsdl+" n'est pas en place?",ex);
    } 
		return flag;
	}
	
	
	
	public Date getdateFerierandWeenkend(Date d) {
		try {
				
		Map<String, Date> jourFerier=new HashMap<String, Date>();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    int year= new Date().getYear();
			Date ferierNewYear=formatter.parse("01/01/"+year);
			Date manifesteIndependance=formatter.parse("11/01/"+year);
			Date feteDuTravail=formatter.parse("01/05/"+year);
			Date feteIndependance=formatter.parse("05/07/"+year);
			Date feteDutrone=formatter.parse("30/07/"+year);
			Date allegeanceOuedEddahab=formatter.parse("14/08/"+year);
			Date revolutionRoipeuple=formatter.parse("20/08/"+year);
			Date feteJunesse=formatter.parse("21/08/"+year);


			
			jourFerier.put("Le Nouvel An", ferierNewYear);
			jourFerier.put("Manifeste de l'Ind�pendance", manifesteIndependance);	
			jourFerier.put("F�te du travail", feteDuTravail);
			jourFerier.put("F�te de l'ind�pendance", feteIndependance);
			jourFerier.put("F�te du tr�ne", feteDutrone);
			jourFerier.put("All�geance Oued Eddahab", allegeanceOuedEddahab);
			jourFerier.put("La R�volution du Roi et du peuple", revolutionRoipeuple);
			jourFerier.put("F�te de la jeunesse", feteJunesse);
			  
					
					Calendar cal = Calendar.getInstance();
					  cal.setTime(d);
					  int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
					  if (dayOfWeek == Calendar.FRIDAY) { // If it's Friday so skip to Monday
					
			              cal.add(Calendar.DATE, 3);
			            
			          } else if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday skip to Monday
			              cal.add(Calendar.DATE, 2);
			          } else {
			              cal.add(Calendar.DATE, 1);
			          }		
					  d=new Date(cal.getTime().getTime());
					  for(int i=0;i<=jourFerier.size();i++)
							if(jourFerier.values().equals(d)){
								cal.setTime(d);
								cal.add(Calendar.DATE, 1);
								
							}
					  
					 
			
				} catch (ParseException e) {
				
					
				}
 
		return d;
	}
}
