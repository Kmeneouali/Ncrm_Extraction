package com.ncrm.SprBatch.najmah;

import org.springframework.batch.item.ItemProcessor;











import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ncrm.dao.entities.BeanEtatsChqSgma;
import com.ncrm.library.utils.NcrmUtils;
import com.ncrm.metier.Imetier;




public class DataFilterProcessorEtaChq implements ItemProcessor<BeanEtatsChqSgma, BeanEtatsChqSgma>  {
	

	
	ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/../ApplicationContex.xml");
	BeanFactory factory = context;
	
	Imetier metier = (Imetier) factory.getBean("metier");
	String Mnemonique="";
	String libAno="";
	String cdeBq= com.ncrm.tools.Propriete.getInsatance().get("NAJMAH.cde.bq");
	public DataFilterProcessorEtaChq() {
		super();
//	logger = Journal.getInstance(fileconfig_log4J, "true");
	}
	
	@Override
	public BeanEtatsChqSgma process(BeanEtatsChqSgma etatsChq) throws Exception {
	
		
		
		
//		======================================================
//					Transformer les anomalies (Ta,Tn,tr,ch)
//		======================================================
		if(etatsChq.getBMTa_Ano().equalsIgnoreCase("D"))
		{
			
		Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBMTa_Ano());
		libAno=metier.getAnomalie("NAJMAH", "031", Mnemonique);
		etatsChq.setBMTa_Ano(Mnemonique);
		etatsChq.setBMTa_Ano_lib(libAno);
		
		}
		
		else
		{
    	etatsChq.setBMTa_Ano("");
		etatsChq.setBMTa_Ano_lib("");
		}
		
//		======================================================	
		if(etatsChq.getBMTN_ope_eta().equalsIgnoreCase("D"))
		{
			
		Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBMTN_Ano());
		libAno=metier.getAnomalie("NAJMAH", "031", Mnemonique);
		etatsChq.setBMTN_Ano(Mnemonique);
		etatsChq.setBMTN_ANO_LIB(libAno);

		}
		
		else
		{
    	etatsChq.setBMTN_Ano("");
		etatsChq.setBMTN_ANO_LIB("");
		}
		
//		======================================================	
	
		
        if(etatsChq.getBMTR_ope_eta().equalsIgnoreCase("D"))
        {
        	
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBMTR_Ano());
    		libAno=metier.getAnomalie("NAJMAH", "031", Mnemonique);
    		etatsChq.setBMTR_Ano(Mnemonique);
    		etatsChq.setBMTR_ANO_LIB(libAno);
		}
        else
        {
        	etatsChq.setBMTR_Ano("");
    		etatsChq.setBMTR_ANO_LIB("");
        }
    
        if(etatsChq.getBMCH_ope_eta().equalsIgnoreCase("D"))
        {
        	   System.out.println(etatsChq.getBMCH_ope_eta());
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(etatsChq.getBMCH_ANO());
    		libAno=metier.getAnomalie("NAJMAH", "031", Mnemonique);
    		etatsChq.setBMCH_ANO(Mnemonique);
    		etatsChq.setBMCH_ANO_LIB(libAno);
    		etatsChq.setBmch_sign("0");
		}
        else
        {
        	etatsChq.setBMCH_ANO("");
    		etatsChq.setBMCH_ANO_LIB("");
        }
        
//		======================================================
       
       
//		======================================================
//			Transformer le champs signature
//      ======================================================
        
        if((!etatsChq.getBMCH_ope_eta().equalsIgnoreCase("D")))//&&(!etatsChq.getBMCH_CONF().equalsIgnoreCase("0"))
        {
        if((!etatsChq.getBMCH_ZBK().equalsIgnoreCase(cdeBq))  )
        {
			etatsChq.setBmch_sign("0");
		}
		if ((etatsChq.getBmch_sign()==null) && (etatsChq.getBMCH_ZBK().equalsIgnoreCase(cdeBq)))
		{
			etatsChq.setBmch_sign("1");
		}
        }
        
		return etatsChq;
		
		
	}

	
	
	
	
	
}
