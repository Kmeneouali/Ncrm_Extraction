package com.ncrm.SprBatch.sgma;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;





	public class impyschqRowMapper implements RowMapper<impayeChqSg> {

		public impyschqRowMapper() {
			super();
		}

		@Override
		public impayeChqSg mapRow(ResultSet rs, int rowNum) throws SQLException {
			impayeChqSg impysChq=new impayeChqSg();
			
			impysChq.setREF(rs.getString("REF"));
			impysChq.setPK_OBJ_IDT(rs.getString("PK_OBJ_IDT"));
			impysChq.setRIO(rs.getString("RIO"));
			impysChq.setRIOINI(rs.getString("RIOINI"));
			impysChq.setREJET(rs.getString("REJET"));
			impysChq.setADR_RMT(rs.getString("ADR_RMT"));
			impysChq.setADR_TIR(rs.getString("ADR_TIR"));
			impysChq.setZBKT(rs.getString("ZBKT"));
		
//			impysChq.setAGE(rs.getString("AGE"));
			impysChq.setAGE_RMT(rs.getString("AGE_RMT"));
			impysChq.setAGE_RMT_LIB(rs.getString("AGE_RMT_LIB"));
			impysChq.setCPT(rs.getString("CPT"));
			impysChq.setCPTT(rs.getString("CPTT"));
//			impysChq.setDTEMI(rs.getString("DTEMI"));
			impysChq.setDTEREG(rs.getString("DTEREG"));
//			impysChq.setLOC(rs.getString("LOC"));
			impysChq.setLOCT(rs.getString("LOCT"));
			impysChq.setMEM2(rs.getString("MEM2"));
			impysChq.setMNT(rs.getString("MNT"));
//			impysChq.setMODE_ESC(rs.getString("MODE_ESC"));
			impysChq.setNSER(rs.getString("NSER"));
			impysChq.setSQCA(rs.getString("SQCA"));
			impysChq.setRIBT(rs.getString("RIBT"));
//			impysChq.setRIBR(rs.getString("RIBR"));
			impysChq.setRSOC_RMT(rs.getString("RSOC_RMT"));
			impysChq.setRSOC_TIRE(rs.getString("RSOC_TIRE"));
//			impysChq.setRSOC_BEN(rs.getString("RSOC_BEN"));
//			impysChq.setZBK(rs.getString("ZBK"));
			impysChq.setZBK_lib(rs.getString("ZBK_lib"));
			impysChq.setNOMTIRE(rs.getString("NOMTIRE"));
			impysChq.setCIN(rs.getString("CIN"));
			impysChq.setRC(rs.getString("RC"));
			impysChq.setLieuEmission(rs.getString("LieuEmission"));
			impysChq.setMOTIF1(rs.getString("MOTIF1"));
			impysChq.setMOTIF2(rs.getString("MOTIF2"));
			impysChq.setMOTIF3(rs.getString("MOTIF3"));
//			impysChq.setAdresseTire(rs.getString("AdresseTire"));
			impysChq.setREJET_LIB(rs.getString("REJET_LIB"));
			impysChq.setDTREJET(rs.getString("DTREJET"));
			impysChq.setDTEINS(rs.getString("DTEINS"));
			impysChq.setDTEPRE(rs.getString("DTEPRE"));
			impysChq.setDTEemission(rs.getString("DTEemission"));
			impysChq.setDTETRT(rs.getString("DTETRT"));
			impysChq.setDTE_SORT(rs.getString("DTE_SORT"));
			impysChq.setID_WEBCAPTUR(rs.getString("ID_WEBCAPTUR"));
			impysChq.setAGE_SCAN(rs.getString("AGE_SCAN"));
			
			
			return impysChq;
		}

		
}
