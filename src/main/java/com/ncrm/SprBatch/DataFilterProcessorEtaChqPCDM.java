package com.ncrm.SprBatch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;


















import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ncrm.dao.daoImpl;
import com.ncrm.dao.entities.BeanEtatsChq;
import com.ncrm.library.utils.NcrmUtils;
import com.ncrm.library.utils.beans.Journal;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;




public class DataFilterProcessorEtaChqPCDM implements ItemProcessor<BeanEtatsChq, BeanEtatsChq>  {
	
	
	private static final Logger logger = Logger.getLogger(DataFilterProcessorEtaChqPCDM.class);
	String cdeBq= Propriete.getInsatance().get("PCDM.cde.bq");
	
	String Mnemonique="";
	String libAno="";
	ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/../ApplicationContex.xml");
//	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContex.xml");
	BeanFactory factory = context;
	
	Imetier metier = (Imetier) factory.getBean("metier");
	
	public DataFilterProcessorEtaChqPCDM() {
		super();
	
	}
	
	public BeanEtatsChq process(BeanEtatsChq etatsChq) throws Exception {
		
//		======================================================
//			Transformer Vice 
//		======================================================
		
		if(etatsChq.getBmch_CONF().equalsIgnoreCase("0"))
		{
		etatsChq.setBmch_VICE(NcrmUtils.getMnemonicAnoFast(etatsChq.getBmch_VICE()));
		}
		else 
		{
			etatsChq.setBmch_VICE("");
		}
		System.out.println(etatsChq.getBmch_VICE());
		
		
//		======================================================
//					Transformer les anomalies (Ta,Tn,tr,ch)
//		======================================================
		if(etatsChq.getBmta_Ano().equalsIgnoreCase("D"))
		{
			
		Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBmta_Ano());
		libAno=metier.getAnomalie("PCDM", "031", Mnemonique);
		etatsChq.setBmta_Ano(Mnemonique);
		etatsChq.setBmta_Ano_lib(libAno);
		
		}
		
		else
		{
    	etatsChq.setBmta_Ano("");
		etatsChq.setBmta_Ano_lib("");
		}
		
//		======================================================	
		if(etatsChq.getBmtn_OPE_ETA().equalsIgnoreCase("D"))
		{
			
		Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBmtn_ANO());
		libAno=metier.getAnomalie("PCDM", "031", Mnemonique);
		etatsChq.setBmtn_ANO(Mnemonique);
		etatsChq.setBmtn_ANO_lib(libAno);

		}
		
		else
		{
    	etatsChq.setBmtn_ANO("");
		etatsChq.setBmtn_ANO_lib("");
		}
		
//		======================================================	
	
		
        if(etatsChq.getBmtr_OPE_ETA().equalsIgnoreCase("D"))
        {
        	
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBmtr_ANO());
        	libAno=metier.getAnomalie("PCDM", "031", Mnemonique);
    		
    		etatsChq.setBmtr_ANO(Mnemonique);
    		etatsChq.setBmtr_ANO_lib(libAno);
		}
        else
        {
        	System.out.println("Mnemonique TR "+Mnemonique);
    		System.out.println("libAno TR "+Mnemonique);
        	etatsChq.setBmtr_ANO("");
    		etatsChq.setBmtr_ANO_lib("");
        }
    
        if(etatsChq.getBmch_ope_eta().equalsIgnoreCase("D"))
        {
        	   System.out.println(etatsChq.getBmch_ope_eta());
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBmch_ANO());
        	libAno=metier.getAnomalie("PCDM", "031", Mnemonique);
    		etatsChq.setBmch_ANO(Mnemonique);
    		etatsChq.setBmch_ANO_lib(libAno);
    	
		}
        else
        {
        	etatsChq.setBmch_ANO("");
    		etatsChq.setBmch_ANO_lib("");
        }
        
//		======================================================
       
       
////		======================================================
////			Transformer le champs signature
////      ======================================================
//        
//        if((!etatsChq.getBmch_ope_eta().equalsIgnoreCase("D")))//&&(!etatsChq.getBMCH_CONF().equalsIgnoreCase("0"))
//        {
//        if((!etatsChq.getBMCH_ZBK().equalsIgnoreCase(cdeBq))  )
//        {
//			etatsChq.setBmch_sign("0");
//		}
//		if ((etatsChq.getBmch_sign().isEmpty()||etatsChq.getBmch_sign()==null) && (etatsChq.getBMCH_ZBK().equalsIgnoreCase(cdeBq)))
//		{
//			etatsChq.setBmch_sign("1");
//		}
//        }
        
		return etatsChq;
		
		
	}


	
	
	
}
