package com.ncrm.SprBatch.sgma;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ncrm.dao.entities.BeanEtatsChqSgma;







	public class etatschqRowMapper implements RowMapper<BeanEtatsChqSgma> {

		public etatschqRowMapper() {
			super();
		}

		@Override
		public BeanEtatsChqSgma mapRow(ResultSet rs, int rowNum) throws SQLException {
			BeanEtatsChqSgma etaChq=new BeanEtatsChqSgma();
			etaChq.setPk_obj_idt_Chq(rs.getString("pk_obj_idt_Chq"));
			etaChq.setBMCH_CPT(rs.getString("BMCH_CPT"));
			etaChq.setDTEMI(rs.getString("DTEMI"));
			etaChq.setBMCH_LOC(rs.getString("BMCH_LOC"));
			etaChq.setBMCH_ZBK(rs.getString("BMCH_ZBK"));
			etaChq.setBMCH_ZIB(rs.getString("BMCH_ZIB"));
			etaChq.setBmch_ZBK_lib(rs.getString("Bmch_ZBK_lib"));
			etaChq.setBMCH_NSER(rs.getString("bMCH_NSER"));
			etaChq.setBMCH_RIB(rs.getString("bMCH_RIB"));
			etaChq.setBMCH_CONF(rs.getString("bMCH_CONF"));
			etaChq.setBMCH_CODE_ERREURS(rs.getString("BMCH_CODE_ERREURS"));
			etaChq.setBMCH_ope_eta(rs.getString("bMCH_ope_eta"));
			etaChq.setBMCH_ANO(rs.getString("bMCH_ANO"));
			etaChq.setBMCH_MNT( rs.getString("BMCH_MNT"));
			etaChq.setBMCH_FLAG_IMP(rs.getString("bMCH_FLAG_IMP"));
			etaChq.setBMCH_FLAG_REJET(rs.getString("bMCH_FLAG_REJET"));
			etaChq.setBMCH_FLAG_SCAN_GR(rs.getString("BMCH_FLAG_SCAN_GR"));
			etaChq.setBmch_SQCA(rs.getString("bmch_SQCA"));
			etaChq.setBmch_ID_WEBCAPTUR(rs.getString("bmch_ID_WEBCAPTUR"));
			etaChq.setBmch_AGE_SCAN(rs.getString("bmch_AGE_SCAN"));
			etaChq.setBMCH_REJET_DELTA(rs.getString("BMCH_REJET_DELTA"));
			etaChq.setBMCH_RIO(rs.getString("BMCH_RIO")); 
			etaChq.setBmch_sign(rs.getString("bmch_sign"));
			etaChq.setBMTR_age(rs.getString("bMTR_age"));
			etaChq.setPk_obj_idt_rem(rs.getString("pk_obj_idt_rem"));
			
			etaChq.setAgeTr_lib(rs.getString("ageTr_lib"));
			etaChq.setBMTR_ope_eta(rs.getString("bMTR_ope_eta"));
			etaChq.setBMTR_Ano(rs.getString("bMTR_Ano"));
			etaChq.setBMTR_Flag_Rejet(rs.getString("bMTR_Flag_Rejet"));
			etaChq.setBMTR_mode(rs.getString("bMTR_mode"));
			etaChq.setBMTR_MNT(rs.getString("bMTR_MNT"));
			etaChq.setBMTR_CPT(rs.getString("bMTR_CPT"));
			etaChq.setBMTR_RIB(rs.getString("bMTR_RIB"));
			etaChq.setBMTR_loc(rs.getString("bMTR_loc"));
			etaChq.setBMTR_zbk(rs.getString("bMTR_zbk"));
			etaChq.setBMTR_NSER(rs.getString("bMTR_NSER"));
			etaChq.setBMTR_NBCH(rs.getString("bMTR_NBCH"));
			etaChq.setBmtr_ID_WEBCAPTUR(rs.getString("bmtr_ID_WEBCAPTUR"));			
			etaChq.setBmtr_AGE_SCAN(rs.getString("bmtr_AGE_SCAN"));
			etaChq.setBmtr_SECTEUR(rs.getString("bmtr_SECTEUR"));
			etaChq.setBMTa_ope_eta(rs.getString("bMTa_ope_eta"));
			etaChq.setBMTa_Ano(rs.getString("bMTa_Ano"));
			etaChq.setBMTa_Flag_Rejet(rs.getString("bMTa_Flag_Rejet"));
			etaChq.setBMTa_mode(rs.getString("bMTa_mode"));
			etaChq.setBMTa_MNTR(rs.getString("bMTa_MNTR"));
			etaChq.setBMTA_MNTREM(rs.getString("bMTA_MNTREM"));
			etaChq.setBMTA_MNT_DIFF(rs.getString("bMTA_MNT_DIFF"));
			etaChq.setBMTA_DIFF_NB(rs.getString("bMTA_DIFF_NB"));
			etaChq.setBMTA_NSER_TA(rs.getString("bMTA_NSER_TA"));
			etaChq.setBMTA_CPT(rs.getString("bMTA_CPT"));
			etaChq.setBMTA_NSER(rs.getString("bMTA_NSER"));
			etaChq.setBMTA_COUNT_REM(rs.getString("bMTA_COUNT_REM"));
			etaChq.setBMTA_age(rs.getString("bMTA_age"));			
			etaChq.setBMTN_Ano(rs.getString("bMTN_Ano"));
			etaChq.setBMTN_ope_eta(rs.getString("bMTN_ope_eta"));
			etaChq.setBMTN_DIFF(rs.getString("bMTN_DIFF"));
			etaChq.setBMTN_DIFF_NB(rs.getString("bMTN_DIFF_NB"));
			etaChq.setBMTN_sum_chq(rs.getString("bMTN_sum_chq"));
			etaChq.setBMTN_lecteur(rs.getString("bMTN_lecteur"));
			
			etaChq.setDATE(rs.getString("dATE"));
			etaChq.setBMCH_LIB_REJET_DELTA(rs.getString("bMCH_LIB_REJET_DELTA"));
			return etaChq;
		}

		
}
