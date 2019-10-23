package com.ncrm.SprBatch.bpm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;





import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ImpChqBpmJobListener  implements JobExecutionListener{
 
    private Date startTime, stopTime;
 
 
    public void beforeJob(JobExecution jobExecution) {
        startTime = new Date();
        System.out.println("ExamResult Job starts at :"+startTime);
    }
 
 
    public void afterJob(JobExecution jobExecution) {
        stopTime = new Date();
        System.out.println("ExamResult Job stops at :"+stopTime);
        System.out.println("Total time take in millis :"+getTimeInMillis(startTime , stopTime));
 
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            System.out.println("ExamResult job completed successfully");
            if(new File("./csv/outputs/impayesChqBpm.txt").renameTo(new File("./csv/outputs/IMP_CHQ_BPM_"+formatDateToString(new Date())+".csv"))){
            	zipFile("./csv/outputs/IMP_CHQ_BPM_"+formatDateToString(new Date())+".txt","./csv/outputs/IMP_CHQ_BPM_"+formatDateToString(new Date())+".zip","IMP_CHQ_BPM_"+formatDateToString(new Date())+".csv");
    			System.out.println("Rename succesful");
    		}else{
    			System.out.println("Rename failed");
    		}
            
            //Here you can perform some other business logic like cleanup
        }else if(jobExecution.getStatus() == BatchStatus.FAILED){
            System.out.println("ExamResult job failed with following exceptions ");
            List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
            for(Throwable th : exceptionList){
                System.err.println("exception :" +th.getLocalizedMessage());
            }
        }
    }
 
    private long getTimeInMillis(Date start, Date stop){
        return stop.getTime() - start.getTime();
    }
    public String formatDateToString(Date date){


    	Format formatter = new SimpleDateFormat("yyyyMMdd");
    	String s = formatter.format(date);

    	return s;
    	}


public void zipFile(String urlFile,String urlZip,String name)

{
byte[] buffer = new byte[1024];

try{
	
	FileOutputStream fos = new FileOutputStream(urlZip);
	ZipOutputStream zos = new ZipOutputStream(fos);
	
	ZipEntry ze= new ZipEntry(name);
	zos.putNextEntry(ze);
	FileInputStream in = new FileInputStream(urlFile);
  
	int len;
	while ((len = in.read(buffer)) > 0) {
		zos.write(buffer, 0, len);
	}

	in.close();
	zos.closeEntry();
   
	//remember close it
	zos.close();
  
	System.out.println("Done");
new File(urlFile).deleteOnExit();
}catch(IOException ex){
   ex.printStackTrace();
}

}



}
