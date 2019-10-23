package com.ncrm.SprBatch.sgda;

import org.springframework.batch.item.ItemProcessor;









import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ncrm.dao.entities.BeanEtatsLCNSgma;
import com.ncrm.library.utils.NcrmUtils;
import com.ncrm.library.utils.beans.Journal;
import com.ncrm.metier.Imetier;
import com.ncrm.tools.Propriete;




public class DataFilterProcessorEtaLCN  implements ItemProcessor<BeanEtatsLCNSgma, BeanEtatsLCNSgma>  {
	
	
	ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/../ApplicationContex.xml");
	BeanFactory factory = context;
	
	Imetier metier = (Imetier) factory.getBean("metier");
	String Mnemonique="";
	String libAno="";
	String cdeBq= com.ncrm.tools.Propriete.getInsatance().get("SGMA.cde.bq");
	
	public DataFilterProcessorEtaLCN() {
		super();

	}
	
	@Override
	public BeanEtatsLCNSgma process(BeanEtatsLCNSgma EtatsLCN) throws Exception {
	
		
		
//		======================================================
//			Transformer les anomalies (Ta,Tn,tr,lcn)
//      ======================================================
		if(EtatsLCN.getBMTa_Ano().equalsIgnoreCase("D"))
		{
			
		Mnemonique=NcrmUtils.getMnemonicAnoFast(EtatsLCN.getBMTa_Ano());
		libAno=metier.getAnomalie("SGMA", "060", Mnemonique);
		EtatsLCN.setBMTa_Ano(Mnemonique);
		EtatsLCN.setBMTa_Ano_lib(libAno);
		
		}
		
		else
		{
    	EtatsLCN.setBMTa_Ano("");
		EtatsLCN.setBMTa_Ano_lib("");
		}
		
//      ======================================================
		if(EtatsLCN.getBMTN_ope_eta().equalsIgnoreCase("D"))
		{
			
		Mnemonique=NcrmUtils.getMnemonicAnoFast(EtatsLCN.getBMTN_Ano());
		libAno=metier.getAnomalie("SGMA", "060", Mnemonique);
		EtatsLCN.setBMTN_Ano(Mnemonique);
		EtatsLCN.setBMTN_Ano_LIB(libAno);

		}
		else
		{
    	EtatsLCN.setBMTN_Ano("");
		EtatsLCN.setBMTN_Ano_LIB("");
		}
//      ======================================================
	
        if(EtatsLCN.getBMTR_ope_eta().equalsIgnoreCase("D"))
        {
        	
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(EtatsLCN.getBMTR_Ano());
    		libAno=metier.getAnomalie("SGMA", "060", Mnemonique);
    		EtatsLCN.setBMTR_Ano(Mnemonique);
    		EtatsLCN.setBMTR_Ano_LIB(libAno);
		}
        else
        {
        	EtatsLCN.setBMTR_Ano("");
    		EtatsLCN.setBMTR_Ano_LIB("");
        }
        
//      ======================================================
        if(EtatsLCN.getBmlcn_ope_eta().equalsIgnoreCase("D"))
        {
        	   System.out.println(EtatsLCN.getBmlcn_ope_eta());
        	Mnemonique=NcrmUtils.getMnemonicAnoFast(EtatsLCN.getBmlcn_ANO());
    		libAno=metier.getAnomalie("SGMA", "060", Mnemonique);
    		EtatsLCN.setBmlcn_ANO(Mnemonique);
    		EtatsLCN.setBmlcn_ANO_LIB(libAno);
    		EtatsLCN.setBmlcn_sign("0");
		}
        else
        {
        	EtatsLCN.setBmlcn_ANO("");
    		EtatsLCN.setBmlcn_ANO_LIB("");
        }
        
//      ======================================================
        
//		======================================================
//			Transformer le champs signature
//      ======================================================
        if((!EtatsLCN.getBmlcn_ope_eta().equalsIgnoreCase("D")))
        {
        if((!EtatsLCN.getBmlcn_ZBK().equalsIgnoreCase(cdeBq))  )
        {
			EtatsLCN.setBmlcn_sign("0");
		}
		if ((EtatsLCN.getBmlcn_sign()==null) && (EtatsLCN.getBmlcn_ZBK().equalsIgnoreCase(cdeBq)))
		{
			EtatsLCN.setBmlcn_sign("1");
		}
        }
        
		return EtatsLCN;
		
		
	}

	
	
	
	
	
}
