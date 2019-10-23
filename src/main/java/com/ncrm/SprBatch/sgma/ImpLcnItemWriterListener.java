package com.ncrm.SprBatch.sgma;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import com.ncrm.library.utils.StringUtils;
import com.ncrm.library.utils.beans.Journal;
import com.ncrm.tools.Propriete;




public class ImpLcnItemWriterListener implements StepExecutionListener,ItemWriteListener<impayeLcnSg>{
private List<String> corpsWCimpy= new ArrayList<String>();
//private static final String fileconfig_log4J = ".\\config\\LOG4J.properties";
//private static Journal logger = null;
String out_Dir_Impy_WC=Propriete.getInsatance().get("SGMB.OUTFOLDER.IMPLCN.WC");


	@Override
	public void afterWrite(List<? extends impayeLcnSg> arg0) {
		String copr="";
//		for(impayeLcnSg imp:arg0){
//		copr=imp.getID_WEBCAPTUR()+"|"+imp.getNSER()+"|"+imp.getZBKT()+","+imp.getLOCT()+","+imp.getCPTT()+","+imp.getRIBT()+"|"+imp.getMNT()+"|"+imp.getRIOINI()+"|"+imp.getDTEINS()+"|"+imp.getDTE_SORT()+"|"+imp.getREJET()+"|"+imp.getREJET_LIB();
//		System.out.println(copr);
//		}
		//		//  logger = Journal.getInstance(fileconfig_log4J, "true");
//		//  logger.logEvent("D", "=== afterWrite in ImpLcnItemWriterListener" , null);
		for(impayeLcnSg imp:arg0){
			String IdWcaprture=imp.getID_WEBCAPTUR();
			
			if(IdWcaprture!=null){
		       IdWcaprture=StringUtils.padRight(imp.getID_WEBCAPTUR(), 10, "0");
			}else{
				 IdWcaprture=StringUtils.padRight("0", 10, "0");
			}
	
			System.out.println(IdWcaprture);
			String Nser=imp.getNSER();
			String RibTire=StringUtils.padLeft(imp.getZBKT()+imp.getLOCT()+imp.getCPTT()+imp.getRIBT(), 24, "0");
			String Mnt=StringUtils.replace(imp.getMNT(), "([0-9]*)\\.([0-9]{2})","$1$2");
			Mnt=StringUtils.padRight(Mnt, 16, "0");
			String RioIni=imp.getRIOINI();
			String cdeRejet=imp.getREJET();
			String  LblRejet=imp.getREJET_LIB();
			if(LblRejet!=null){
		        LblRejet=StringUtils.padLeft(imp.getREJET_LIB(), 100, " ");
			}else {
				LblRejet=StringUtils.padLeft("", 100, " ");
			}
			
			String  dteTr=StringUtils.replace(imp.getDTEINS(), "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
			String dteSort=StringUtils.replace(imp.getDTE_SORT(), "([0-9]{2})-([0-9]{2})-([0-9]{4})","$3$2$1");
//			
		copr=IdWcaprture+"|"+Nser+"|"+RibTire+"|"+Mnt+"|"+RioIni+"|"+dteTr+"|"+dteSort+"|"+cdeRejet+"|"+LblRejet
				;
		//  logger.logEvent("D", "=== enregistrement "+copr , null);
		corpsWCimpy.add(copr);		
		
		}
		
	}

	@Override
	public void beforeWrite(List<? extends impayeLcnSg> arg0) {
		
	}

	@Override
	public void onWriteError(Exception arg0, List<? extends impayeLcnSg> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		//  logger.logEvent("D", "=== afterStep in ImpLcnItemWriterListener" , null);
		
		if(arg0.getExitStatus().getExitCode().equalsIgnoreCase("COMPLETED")){
		String dte_Trt=arg0.getJobExecution().getJobParameters().getString("dtetraitement");
     	String nameFile=out_Dir_Impy_WC+"\\webcapture.022.160."+dte_Trt+".txt";
     	System.out.println("nameFile "+nameFile);
		FileWriter fw=null;
		BufferedWriter bw=null;
		try {
			fw = new FileWriter(nameFile);
			bw=new BufferedWriter(fw);
			String header="022160"+dte_Trt;
			bw.write(header);	
			bw.newLine();
			for(String s:corpsWCimpy){
				bw.write(s);
				bw.newLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//  logger.logEvent("D", "+++ IOException" , e);
		}finally{
			try {
			
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}else {
		System.out.println("");
		//  logger.logEvent("D", "+++ Step Field"+arg0.getExitStatus() , null);
	}
		
		
		return arg0.getExitStatus();
	}

	@Override
	public void beforeStep(StepExecution arg0) {
	
	
		
	}

	public List<String> getCorpsWCimpy() {
		return corpsWCimpy;
	}

	public void setCorpsWCimpy(List<String> corpsWCimpy) {
		this.corpsWCimpy = corpsWCimpy;
	}

	
	
}
