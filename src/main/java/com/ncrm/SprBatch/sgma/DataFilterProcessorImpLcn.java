package com.ncrm.SprBatch.sgma;

import org.springframework.batch.item.ItemProcessor;




import com.ncrm.library.utils.beans.Journal;




public  class DataFilterProcessorImpLcn implements ItemProcessor<impayeLcnSg, impayeLcnSg>  {
	
	
	
	
	public DataFilterProcessorImpLcn() {
		super();
//		logger = Journal.getInstance(fileconfig_log4J, "true");
	}
	
	@Override
	public impayeLcnSg process(impayeLcnSg impysLcn) throws Exception {
		
		
		return impysLcn;
		
		
	}

}
