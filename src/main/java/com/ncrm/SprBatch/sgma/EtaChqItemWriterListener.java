package com.ncrm.SprBatch.sgma;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ncrm.dao.entities.BeanEtatsChqSgma;
import com.ncrm.dao.entities.rec.RecordRemise;
import com.ncrm.library.utils.RegexUtils;
import com.ncrm.library.utils.StringUtils;
import com.ncrm.metier.Imetier;
import com.ncrm.metier.MetierImpl;
import com.ncrm.tools.Propriete;




public class EtaChqItemWriterListener  implements StepExecutionListener{
	private static final Logger logger = Logger.getLogger(EtaChqItemWriterListener.class);
	private static final String folderREC = Propriete.getInsatance().get("SGMA.OUT.REC");
	
	ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/../ApplicationContex.xml");
	BeanFactory factory = context;
	
	Imetier metier = (Imetier) factory.getBean("metier");
	
	List<BeanEtatsChqSgma> listBeanEtaChq=new ArrayList<>();
	

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		
//		String dteInstance = stepExecution.getJobParameters().getString("dtetraitement");
//		
//		String nameFile=folderREC+"\\022.031."+dteInstance+".rec";
//		String header="RECO022031"+dteInstance;
//        
//		dteInstance = StringUtils.replace(dteInstance, "([0-9]{4})([0-9]{2})([0-9]{2})","$1-$2-$3");
//		
//		
//		
//		List<RecordRemise> listeRemises=metier.getRecordRemRec("SGMA","031",dteInstance);
//		
//
//		if(listeRemises.size()>0)
//		{	
//			
//			listeRemises=metier.formatageChamps(listeRemises, dteInstance);
//			listeRemises=metier.createFileRec(listeRemises, nameFile,header,"031");
//			
//									
//	    }
		
		return stepExecution.getExitStatus();
	}

}
