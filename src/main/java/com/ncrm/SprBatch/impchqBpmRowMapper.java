package com.ncrm.SprBatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



	public class impchqBpmRowMapper implements RowMapper<impayeChq> {

		public impchqBpmRowMapper() {
			super();
			// TODO Auto-generated constructor stub
		}


		public impayeChq mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			impayeChq impChqBpm=new impayeChq();
			impChqBpm.setREF(rs.getString("REF"));
			impChqBpm.setPK_OBJ_IDT(rs.getString("PK_OBJ_IDT"));
			impChqBpm.setRIO(rs.getString("RIO"));
			impChqBpm.setRIOINI(rs.getString("RIOINI"));
			impChqBpm.setREJET(rs.getString("REJET"));
			impChqBpm.setADR_RMT(rs.getString("ADR_RMT"));
			impChqBpm.setADR_RMT(rs.getString("ADR_TIR"));
			impChqBpm.setCDEBPR(rs.getString("CDEBPR"));
			impChqBpm.setCDEBPR_RMT(rs.getString("CDEBPR_RMT"));
			impChqBpm.setAGE(rs.getString("AGE"));
			impChqBpm.setAGE_RMT(rs.getString("AGE_RMT"));
			impChqBpm.setAGE_RMT_LIB(rs.getString("AGE_RMT_LIB"));
			impChqBpm.setCPT(rs.getString("CPT"));
			impChqBpm.setCPTT(rs.getString("CPTT"));
			impChqBpm.setDTEMI(rs.getString("DTEMI"));
			impChqBpm.setDTEREG(rs.getString("DTEREG"));
			impChqBpm.setLOC(rs.getString("LOC"));
			impChqBpm.setLOCT(rs.getString("LOCT"));
			impChqBpm.setMEM2(rs.getString("MEM2"));
			impChqBpm.setMNT(rs.getString("MNT"));
			impChqBpm.setMODE_ESC(rs.getString("MODE_ESC"));
			impChqBpm.setNSER(rs.getString("NSER"));
			impChqBpm.setSQCA(rs.getString("SQCA"));
			impChqBpm.setRIB(rs.getString("RIB"));
			impChqBpm.setRIBR(rs.getString("RIBR"));
			impChqBpm.setRSOC_RMT(rs.getString("RSOC_RMT"));
			impChqBpm.setRSOC_TIRE(rs.getString("RSOC_TIRE"));
			impChqBpm.setRSOC_BEN(rs.getString("RSOC_BEN"));
			impChqBpm.setZBK(rs.getString("ZBK"));
			impChqBpm.setZBK_lib(rs.getString("ZBK_lib"));
			impChqBpm.setNOMTIRE(rs.getString("NOMTIRE"));
			impChqBpm.setCIN(rs.getString("CIN"));
			impChqBpm.setRC(rs.getString("RC"));
			impChqBpm.setLieuEmission(rs.getString("lieuEmission"));
			impChqBpm.setMOTIF1(rs.getString("MOTIF1"));
			impChqBpm.setMOTIF2(rs.getString("MOTIF2"));
			impChqBpm.setMOTIF3(rs.getString("MOTIF3"));
			impChqBpm.setAdresseTire(rs.getString("adresseTire"));
			impChqBpm.setREJET_LIB(rs.getString("REJET_LIB"));
			impChqBpm.setDTREJET(rs.getString("DTREJET"));
			impChqBpm.setDTEINS(rs.getString("DTEINS"));
			impChqBpm.setDTEPRE(rs.getString("DTEPRE"));
			impChqBpm.setDTEemission(rs.getString("DTEemission"));
			impChqBpm.setDTETRT(rs.getString("DTETRT"));

					

			
			return impChqBpm;
		}

		
}
