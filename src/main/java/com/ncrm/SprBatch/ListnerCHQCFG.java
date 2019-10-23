package com.ncrm.SprBatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import com.ncrm.dao.Idao;
import com.ncrm.dao.daoImpl;


public class ListnerCHQCFG implements JobExecutionListener{
 
    
	Idao dao=new daoImpl();
   

	public void afterJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeJob(JobExecution arg0) {
		System.out.println("Before Execution ...");
//		dao.purgeTablePaid("CFG","CHQ");
		
	}

}
