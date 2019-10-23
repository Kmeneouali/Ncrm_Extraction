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
import com.ncrm.tools.Propriete;






public class ImpChqItemWriterListener implements StepExecutionListener,ItemWriteListener<impayeChqSg>{
private List<String> corpsWCimpy= new ArrayList<String>();
String out_Dir_Impy_WC=Propriete.getInsatance().get("SGMB.OUTFOLDER.IMPCHQ.WC");


	@Override
	public void afterWrite(List<? extends impayeChqSg> arg0) {
		String copr="";
		for(impayeChqSg imp:arg0){
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
			}
			else {
				LblRejet=StringUtils.padLeft("", 100, " ");
			}
			String  dteTr=StringUtils.replace(imp.getDTETRT(), "([0-9]{4})-([0-9]{2})-([0-9]{2})","$1$2$3");
//			
		copr=IdWcaprture+"|"+Nser+"|"+RibTire+"|"+Mnt+"|"+RioIni+"|"+cdeRejet+"|"+LblRejet
				;
		System.out.println(copr);
		corpsWCimpy.add(copr);		
		
		}
		
	}

	@Override
	public void beforeWrite(List<? extends impayeChqSg> arg0) {
		
	}

	@Override
	public void onWriteError(Exception arg0, List<? extends impayeChqSg> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		if(arg0.getExitStatus().getExitCode().equalsIgnoreCase("COMPLETED")){
		String dte_Trt=arg0.getJobExecution().getJobParameters().getString("dtetraitement");
     	String nameFile=out_Dir_Impy_WC+"\\webcapture.022.131."+dte_Trt+".txt";
     	System.out.println("nameFile "+nameFile);
		FileWriter fw=null;
		BufferedWriter bw=null;
		try {
			fw = new FileWriter(nameFile);
			bw=new BufferedWriter(fw);
			String header="022131"+dte_Trt;
			bw.write(header);	
			bw.newLine();
			for(String s:corpsWCimpy){
				bw.write(s);
				bw.newLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
			
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}else {
		System.out.println("Step Field");
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
