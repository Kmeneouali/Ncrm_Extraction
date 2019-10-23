package com.ncrm.SprBatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

	public class implcnBpmRowMapper implements RowMapper<impayeLcn> {

		public implcnBpmRowMapper() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		public impayeLcn mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			impayeLcn implcnBpm=new impayeLcn();
//		
//			 DTREG, 
			

			implcnBpm.setREF(rs.getString("REF"));
			implcnBpm.setPK_OBJ_IDT(rs.getString("PK_OBJ_IDT"));
			implcnBpm.setRIO(rs.getString("RIO"));
			implcnBpm.setRIOINI(rs.getString("RIOINI"));
			implcnBpm.setREJET(rs.getString("REJET"));
			implcnBpm.setADR_RMT(rs.getString("ADR_RMT"));
			implcnBpm.setADR_TIRE(rs.getString("ADR_TIRE"));
			implcnBpm.setCDEBPR(rs.getString("CDEBPR"));
			implcnBpm.setCDEBPR_RMT(rs.getString("CDEBPR_RMT"));
			implcnBpm.setAGE(rs.getString("AGE"));
			implcnBpm.setAGE_RMT(rs.getString("AGE_RMT"));
			implcnBpm.setAGE_RMT_LIB(rs.getString("AGE_RMT_LIB"));
			implcnBpm.setCPT(rs.getString("CPT"));
			implcnBpm.setCPTT(rs.getString("CPTT"));
			implcnBpm.setDTEEC(rs.getString("DTEEC"));	
			implcnBpm.setDTEMI(rs.getString("DTEMI"));
			implcnBpm.setLOC(rs.getString("LOC"));
			implcnBpm.setLOCT(rs.getString("LOCT"));
			implcnBpm.setMEM2(rs.getString("MEM2"));
			implcnBpm.setMNT(rs.getString("MNT"));
			implcnBpm.setMODE_ESC(rs.getString("MODE_ESC"));
			implcnBpm.setNSER(rs.getString("NSER"));
			implcnBpm.setRIB(rs.getString("RIB"));
			implcnBpm.setRIBT(rs.getString("RIBT"));		
			implcnBpm.setRSOC_RMT(rs.getString("RSOC_RMT"));
			implcnBpm.setRSOC_TIRE(rs.getString("RSOC_TIRE"));
			implcnBpm.setRSOC_BEN(rs.getString("RSOC_BEN"));
			implcnBpm.setZBK(rs.getString("ZBK"));
			implcnBpm.setZBK_lib(rs.getString("ZBK_lib"));
			implcnBpm.setNOMTIRE(rs.getString("NOMTIRE"));
			implcnBpm.setCIN(rs.getString("CIN"));
			implcnBpm.setRC(rs.getString("RC"));		
			implcnBpm.setLieuEmission(rs.getString("lieuEmission"));
			implcnBpm.setMOTIF1(rs.getString("MOTIF1"));
			implcnBpm.setMOTIF2(rs.getString("MOTIF2"));
			implcnBpm.setMOTIF3(rs.getString("MOTIF3"));
			implcnBpm.setAdresseTire(rs.getString("adresseTire"));
			implcnBpm.setREJET_LIB(rs.getString("REJET_LIB"));
			
			implcnBpm.setDTREJET(rs.getString("DTREJET"));
			implcnBpm.setDTEINS(rs.getString("DTEINS"));
			implcnBpm.setDTEPRE(rs.getString("DTEPRE"));
			implcnBpm.setDTEemission(rs.getString("DTEemission"));
			implcnBpm.setDTREG(rs.getString("DTREG"));

					

			
			return implcnBpm;
		}

		
}
