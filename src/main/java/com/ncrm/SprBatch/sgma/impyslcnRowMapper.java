package com.ncrm.SprBatch.sgma;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;





	public class impyslcnRowMapper implements RowMapper<impayeLcnSg> {

		public impyslcnRowMapper() {
			super();
		}

		@Override
		public impayeLcnSg mapRow(ResultSet rs, int rowNum) throws SQLException {
			impayeLcnSg impysLcn=new impayeLcnSg();
			
			impysLcn.setREF(rs.getString("REF"));
			impysLcn.setPK_OBJ_IDT(rs.getString("PK_OBJ_IDT"));
			impysLcn.setRIO(rs.getString("RIO"));
			impysLcn.setRIOINI(rs.getString("RIOINI"));
			impysLcn.setREJET(rs.getString("REJET"));
			impysLcn.setADR_RMT(rs.getString("ADR_RMT"));
			impysLcn.setADR_TIR(rs.getString("ADR_TIR"));
			impysLcn.setZBKT(rs.getString("ZBKT"));
//			impysLcn.setAGE(rs.getString("AGE"));
			impysLcn.setAGE_RMT(rs.getString("AGE_RMT"));
			impysLcn.setAGE_RMT_LIB(rs.getString("AGE_RMT_LIB"));
			impysLcn.setCPT(rs.getString("CPT"));
			impysLcn.setCPTT(rs.getString("CPTT"));
//			impysLcn.setDTEMI(rs.getString("DTEMI"));
			impysLcn.setDTEREG(rs.getString("DTEREG"));
//			impysLcn.setLOC(rs.getString("LOC"));
			impysLcn.setLOCT(rs.getString("LOCT"));
			impysLcn.setMEM2(rs.getString("MEM2"));
			impysLcn.setMNT(rs.getString("MNT"));
//			impysLcn.setMODE_ESC(rs.getString("MODE_ESC"));
			impysLcn.setNSER(rs.getString("NSER"));
			impysLcn.setSQCA(rs.getString("SQCA"));
			impysLcn.setRIBT(rs.getString("RIBT"));
//			impysLcn.setRIBR(rs.getString("RIBR"));
			impysLcn.setRSOC_RMT(rs.getString("RSOC_RMT"));
			impysLcn.setRSOC_TIRE(rs.getString("RSOC_TIRE"));
//			impysLcn.setRSOC_BEN(rs.getString("RSOC_BEN"));
//			impysLcn.setZBK(rs.getString("ZBK"));
			impysLcn.setZBK_lib(rs.getString("ZBK_lib"));
			impysLcn.setNOMTIRE(rs.getString("NOMTIRE"));
			impysLcn.setCIN(rs.getString("CIN"));
			impysLcn.setRC(rs.getString("RC"));
			impysLcn.setLieuEmission(rs.getString("LieuEmission"));
			impysLcn.setMOTIF1(rs.getString("MOTIF1"));
			impysLcn.setMOTIF2(rs.getString("MOTIF2"));
			impysLcn.setMOTIF3(rs.getString("MOTIF3"));
//			impysLcn.setAdresseTire(rs.getString("AdresseTire"));
			impysLcn.setREJET_LIB(rs.getString("REJET_LIB"));
			impysLcn.setDTREJET(rs.getString("DTREJET"));
			impysLcn.setDTEINS(rs.getString("DTEINS"));
			impysLcn.setDTEPRE(rs.getString("DTEPRE"));
			impysLcn.setDTEemission(rs.getString("DTEemission"));
			impysLcn.setDTETRT(rs.getString("DTETRT"));
			impysLcn.setDTE_SORT(rs.getString("DTE_SORT"));
			impysLcn.setDTEEC(rs.getString("dteec"));
			impysLcn.setID_WEBCAPTUR(rs.getString("ID_WEBCAPTUR"));
			impysLcn.setAGE_SCAN(rs.getString("AGE_SCAN"));
			
			
			return impysLcn;
		}

		
}
