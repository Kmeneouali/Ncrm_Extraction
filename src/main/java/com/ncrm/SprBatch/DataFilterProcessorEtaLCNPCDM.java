package com.ncrm.SprBatch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ncrm.dao.entities.BeanEtatsLcn;
import com.ncrm.library.utils.NcrmUtils;
import com.ncrm.library.utils.beans.Journal;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;




public class DataFilterProcessorEtaLCNPCDM implements ItemProcessor<BeanEtatsLcn, BeanEtatsLcn>  {
	
	
	private static final Logger logger = Logger.getLogger(DataFilterProcessorEtaLCNPCDM.class);
	String cdeBq= Propriete.getInsatance().get("PCDM.cde.bq");
	
	String Mnemonique="";
	String libAno="";
	ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/../ApplicationContex.xml");
//	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContex.xml");
	BeanFactory factory = context;
	
	Imetier metier = (Imetier) factory.getBean("metier");
	
	public DataFilterProcessorEtaLCNPCDM() {
	
	}
	

	public BeanEtatsLcn process(BeanEtatsLcn etatsLcn) throws Exception {
		
//		======================================================
//			Transformer Vice 
//		======================================================
		
		if(etatsLcn.getBmlcn_CONF().equalsIgnoreCase("0"))
		{
		etatsLcn.setBmlcn_VICE(NcrmUtils.getMnemonicAnoFast(etatsLcn.getBmlcn_VICE()));
		}
		else 
		{
			etatsLcn.setBmlcn_VICE("");
		}
		System.out.println(etatsLcn.getBmlcn_VICE());
		
		
//		======================================================
//					Transformer les anomalies (Ta,Tn,tr,ch)
//		======================================================
//		if(etatsLcn.getBmta_ANO().equalsIgnoreCase("D"))
//		{
//			
//		Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsLcn.getBmta_ANO());
//		libAno=getAnomalie(Mnemonique);
//		etatsLcn.setBmta_ANO(Mnemonique);
//		etatsLcn.setBmta_ANO_lib(libAno);
//		
//		}
//		
//		else
//		{
//    	etatsLcn.setBmta_ANO("");
//		etatsLcn.setBmta_ANO_lib("");
//		}
		
//		======================================================	
		if(etatsLcn.getBmtn_OPE_ETA().equalsIgnoreCase("D"))
		{
			
		Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsLcn.getBmtn_ANO());
		libAno=metier.getAnomalie("PCDM", "060", Mnemonique);
		etatsLcn.setBmtn_ANO(Mnemonique);
		etatsLcn.setBmtn_ANO_lib(libAno);

		}
		
		else
		{
    	etatsLcn.setBmtn_ANO("");
		etatsLcn.setBmtn_ANO_lib("");
		}
		
//		======================================================	
	
		
        if(etatsLcn.getBmtr_OPE_ETA().equalsIgnoreCase("D"))
        {
        	
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsLcn.getBmtr_ANO());
        	libAno=metier.getAnomalie("PCDM", "060", Mnemonique);
    		
    		etatsLcn.setBmtr_ANO(Mnemonique);
    		etatsLcn.setBmtr_ANO_lib(libAno);
    		System.out.println("Mnemonique TR "+Mnemonique);
    		System.out.println("libAno TR "+libAno);
		}
        else
        {
        	
        	etatsLcn.setBmtr_ANO("");
    		etatsLcn.setBmtr_ANO_lib("");
        }
    
        if(etatsLcn.getBmlcn_ope_eta().equalsIgnoreCase("D"))
        {
        	   System.out.println(etatsLcn.getBmlcn_ope_eta());
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsLcn.getBmlcn_ANO());
        	libAno=metier.getAnomalie("PCDM", "060", Mnemonique);
    		etatsLcn.setBmlcn_ANO(Mnemonique);
    		etatsLcn.setBmlcn_ANO_lib(libAno);
    		System.out.println("Anomalie "+etatsLcn.getBmlcn_ANO());
    		System.out.println("Mnemonique LCN "+Mnemonique);
    		System.out.println("libAno LCN "+libAno);
    	
		}
        else
        {
        	etatsLcn.setBmlcn_ANO("");
    		etatsLcn.setBmlcn_ANO_lib("");
        }
        
//		======================================================
       
       
////		======================================================
////			Transformer le champs signature
////      ======================================================
//        
//        if((!etatsLcn.getBmlcn_ope_eta().equalsIgnoreCase("D")))//&&(!etatsLcn.getBMCH_CONF().equalsIgnoreCase("0"))
//        {
//        if((!etatsLcn.getBMCH_ZBK().equalsIgnoreCase(cdeBq))  )
//        {
//			etatsLcn.setBmlcn_sign("0");
//		}
//		if ((etatsLcn.getBmlcn_sign().isEmpty()||etatsLcn.getBmlcn_sign()==null) && (etatsLcn.getBMCH_ZBK().equalsIgnoreCase(cdeBq)))
//		{
//			etatsLcn.setBmlcn_sign("1");
//		}
//        }
        
		return etatsLcn;
		
		
	}

	
	
	
	
	
}
