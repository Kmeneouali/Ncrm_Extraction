package com.ncrm.SprBatch.sgma;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ncrm.dao.entities.BeanEtatsLCNSgma;




	public class etatsLcnRowMapper implements RowMapper<BeanEtatsLCNSgma> {

		public etatsLcnRowMapper() {
			super();
		}
		

		
		

		@Override
		public BeanEtatsLCNSgma mapRow(ResultSet rs, int rowNum) throws SQLException {
			BeanEtatsLCNSgma etaLcn=new BeanEtatsLCNSgma();
			etaLcn.setPk_obj_idt_rem(rs.getString("pk_obj_idt_rem"));
			etaLcn.setPk_obj_idt_LCN(rs.getString("pk_obj_idt_LCN"));
			etaLcn.setBmlcn_CPT(rs.getString("Bmlcn_CPT"));
			etaLcn.setDTEMI(rs.getString("DTEMI"));
			etaLcn.setBmlcn_LOC(rs.getString("BMLCN_LOC"));
			etaLcn.setBmlcn_ZBK(rs.getString("BMLCN_ZBK"));
			etaLcn.setBMLCN_ZIB(rs.getString("BMLCN_ZIB"));
			etaLcn.setBmlcn_ZBK_lib(rs.getString("bmlcn_ZBK_lib"));
			etaLcn.setBmlcn_NSER(rs.getString("bmlcn_NSER"));
			etaLcn.setBmlcn_RIB(rs.getString("bmlcn_RIB"));
			etaLcn.setBmlcn_CONF(rs.getString("bmlcn_CONF"));
			etaLcn.setBmlcn_CODE_ERREURS(rs.getString("bmlcn_CODE_ERREURS"));
			etaLcn.setBmlcn_ope_eta(rs.getString("bmlcn_ope_eta"));
			etaLcn.setBmlcn_ANO(rs.getString("bmlcn_ANO"));
			etaLcn.setBmlcn_MNT( rs.getString("bmlcn_MNT"));
			etaLcn.setBmlcn_FLAG_IMP(rs.getString("bmlcn_FLAG_IMP"));
			etaLcn.setBmlcn_FLAG_REJET(rs.getString("bmlcn_FLAG_REJET"));
			etaLcn.setBmlcn_FLAG_SCAN_GR(rs.getString("bmlcn_FLAG_SCAN_GR"));
			etaLcn.setBmlcn_SQCA(rs.getString("bmlcn_SQCA"));
			etaLcn.setBmlcn_ID_WEBCAPTUR(rs.getString("bmlcn_ID_WEBCAPTUR"));
			etaLcn.setBmlcn_AGE_SCAN(rs.getString("bmlcn_AGE_SCAN"));
			etaLcn.setBmlcn_REJET_DELTA(rs.getString("bmlcn_REJET_DELTA"));
			etaLcn.setBmlcn_sign(rs.getString("bmlcn_sign"));
			etaLcn.setBmlcn_rio(rs.getString("bmlcn_rio"));
			etaLcn.setBMTR_age(rs.getString("BMTR_age"));
			etaLcn.setAgeTr_lib(rs.getString("ageTr_lib"));
			
			
			etaLcn.setBMTR_ope_eta(rs.getString("BMTR_ope_eta"));
			etaLcn.setBMTR_Ano(rs.getString("BMTR_Ano"));
			etaLcn.setBMTR_Flag_Rejet(rs.getString("bMTR_Flag_Rejet"));
			etaLcn.setBMTR_mode(rs.getString("bMTR_mode"));
			etaLcn.setBMTR_MNT(rs.getString("bMTR_MNT"));
			etaLcn.setBMTR_CPT(rs.getString("bMTR_CPT"));
			etaLcn.setBMTR_RIB(rs.getString("bMTR_RIB"));
//			etaLcn.setBMTR_loc(rs.getString("bMTR_loc"));
			etaLcn.setBMTR_zbk(rs.getString("bMTR_zbk"));
			etaLcn.setBMTR_NSER(rs.getString("bMTR_NSER"));
			etaLcn.setBMTR_NBCH(rs.getString("bMTR_NBCH"));
			etaLcn.setBmtr_ID_WEBCAPTUR(rs.getString("bmtr_ID_WEBCAPTUR"));			
			etaLcn.setBmtr_AGE_SCAN(rs.getString("bmtr_AGE_SCAN"));
			etaLcn.setBmtr_SECTEUR(rs.getString("bmtr_SECTEUR"));
			etaLcn.setBMTa_ope_eta(rs.getString("bMTa_ope_eta"));
			etaLcn.setBMTa_Ano(rs.getString("bMTa_Ano"));
			etaLcn.setBMTa_Flag_Rejet(rs.getString("bMTa_Flag_Rejet"));
			etaLcn.setBMTa_mode(rs.getString("bMTa_mode"));
			etaLcn.setBMTa_MNTR(rs.getString("bMTa_MNTR"));
			etaLcn.setBMTA_MNTREM(rs.getString("bMTA_MNTREM"));
			etaLcn.setBMTA_MNT_DIFF(rs.getString("bMTA_MNT_DIFF"));
			etaLcn.setBMTA_DIFF_NB(rs.getString("bMTA_DIFF_NB"));
			etaLcn.setBMTA_NSER_TA(rs.getString("bMTA_NSER_TA"));
			etaLcn.setBMTA_CPT(rs.getString("bMTA_CPT"));
			etaLcn.setBMTA_NSER(rs.getString("bMTA_NSER"));
			etaLcn.setBMTA_COUNT_REM(rs.getString("bMTA_COUNT_REM"));
			etaLcn.setBMTA_age(rs.getString("bMTA_age"));			
			etaLcn.setBMTN_Ano(rs.getString("bMTN_Ano"));
			etaLcn.setBMTN_ope_eta(rs.getString("bMTN_ope_eta"));
			etaLcn.setBMTN_DIFF(rs.getString("bMTN_DIFF"));
			etaLcn.setBMTN_DIFF_NB(rs.getString("bMTN_DIFF_NB"));
			etaLcn.setBMTN_sum_Lcn(rs.getString("bMTN_sum_lcn"));
			etaLcn.setBMTN_lecteur(rs.getString("bMTN_lecteur"));
			etaLcn.setDATE(rs.getString("dATE"));
			etaLcn.setBmlcn_dteec(rs.getString("bmlcn_DTEEC"));
			etaLcn.setBMLCN_LIB_REJET_DELTA(rs.getString("bMLCN_LIB_REJET_DELTA"));
			return etaLcn;
		}

		
}
