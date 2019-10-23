package com.ncrm.SprBatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ncrm.dao.entities.beanScann;







	public class LcnStkRowMapper implements RowMapper<beanStk> {

		public LcnStkRowMapper() {
			super();
		}

		
		public beanStk mapRow(ResultSet rs, int rowNum) throws SQLException {
			beanStk beanStk=new beanStk();
			beanStk.setPK_OBJ_IDT(rs.getString("pK_OBJ_IDT"));
			beanStk.setADR_BEN(rs.getString("aDR_BEN"));
			beanStk.setADR_RMT(rs.getString("aDR_RMT"));
			beanStk.setADR_TIRE(rs.getString("aDR_TIRE"));
			beanStk.setCDEAVAL(rs.getString("cDEAVAL"));
			beanStk.setCDEBPR(rs.getString("cDEBPR"));
			beanStk.setCDEPRE(rs.getString("cDEPRE"));
			beanStk.setCPT(rs.getString("cPT"));
			beanStk.setCPTT(rs.getString("cPTT"));
			beanStk.setDTEEC(rs.getString("dTEEC"));
			beanStk.setDTEINS(rs.getString("dTEINS"));
			beanStk.setDTEMI(rs.getString("dTEMI"));
			beanStk.setLOC(rs.getString("lOC"));
			beanStk.setLOCT(rs.getString("lOCT"));
			beanStk.setMNT(rs.getString("mNT"));
			beanStk.setNSER(rs.getString("nSER"));
			beanStk.setRIB(rs.getString("rIB"));
			beanStk.setRIBT(rs.getString("rIBT"));
			beanStk.setRSOC_BEN(rs.getString("rSOC_BEN"));
			beanStk.setRSOC_RMT(rs.getString("rSOC_RMT"));
			beanStk.setRSOC_TIRE(rs.getString("rSOC_TIRE"));
			beanStk.setZBK(rs.getString("zBK"));
			beanStk.setZBKT(rs.getString("zBKT"));
			beanStk.setZIB(rs.getString("zIB"));
			beanStk.setZIBT(rs.getString("zIBT"));
			beanStk.setDTEPRE(rs.getString("dTEPRE"));
			beanStk.setDTEEXT(rs.getString("dTEEXT"));
			beanStk.setDTREG(rs.getString("dTREG"));
			beanStk.setFLAG_IMP(rs.getString("fLAG_IMP"));
			beanStk.setRIO(rs.getString("rIO"));
			beanStk.setMODE_ESC(rs.getString("mODE_ESC"));
			beanStk.setAGE_RMT(rs.getString("aGE_RMT"));
			beanStk.setAGE_RMT_LIB(rs.getString("aGE_RMT_LIB"));
			beanStk.setCDEBPR_RMT(rs.getString("cDEBPR_RMT"));
			beanStk.setFLAGEXT(rs.getString("fLAGEXT"));
			beanStk.setSQCA(rs.getString("sQCA"));
			beanStk.setMEm2(rs.getString("MEm2"));
			
			return beanStk;
		}

		
}
