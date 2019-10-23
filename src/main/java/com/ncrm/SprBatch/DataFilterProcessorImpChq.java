package com.ncrm.SprBatch;

import org.springframework.batch.item.ItemProcessor;





public class DataFilterProcessorImpChq implements ItemProcessor<impayeChq, impayeChq>  {
	
	
	public impayeChq process(impayeChq imp) throws Exception {
		
		if ((imp.getPK_OBJ_IDT()!= null )){
//			if(dao.getImpChq(imp.getREF())==0){
//				System.out.println(imp.getREF());
//			return imp;
//			}
//			else 
//			{
//				return null;
//			}
//			
			System.out.println(imp.getPK_OBJ_IDT());
			return imp;
		  }
		else
		{  
		   return null;  
		  }
	  
	}

}
