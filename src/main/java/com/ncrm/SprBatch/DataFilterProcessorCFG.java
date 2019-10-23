package com.ncrm.SprBatch;

import org.springframework.batch.item.ItemProcessor;


import com.ncrm.dao.entities.BeanFile;
import com.ncrm.library.utils.StringUtils;


public class DataFilterProcessorCFG implements ItemProcessor<BeanFile, BeanFile>  {

	
	public BeanFile process(BeanFile bf) throws Exception {
		String zbk=StringUtils.replace(bf.getZib(), "([0-9]{3})([0-9]{3})", "$1");
		String loc=StringUtils.replace(bf.getZib(), "([0-9]{3})([0-9]{3})", "$2");
		String formatDate=StringUtils.replace(bf.getDteTrt(), "([0-9]{4})([0-9]{2})([0-9]{2})", "$3-$2-$1");
		bf.setDteTrt(formatDate);
		bf.setZbk(zbk);
		bf.setLoc(loc);

		return bf;
	}

}
