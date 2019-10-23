package com.ncrm.SprBatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ncrm.dao.entities.BeanEtatsChq;





	public class etatschqRowMapper implements RowMapper<BeanEtatsChq> {

		public etatschqRowMapper() {
			super();
		}

		
		public BeanEtatsChq mapRow(ResultSet rs, int rowNum) throws SQLException {
			BeanEtatsChq etaChqBpm=new BeanEtatsChq();
			etaChqBpm.setBmch_pk_obj_idt(rs.getString("bmch_pk_obj_idt"));
			etaChqBpm.setDATE(rs.getString("date"));		 
			etaChqBpm.setAge_r_lib(rs.getString("age_r_lib"));
			etaChqBpm.setBq_lib(rs.getString("bq_lib"));
			etaChqBpm.setBmtn_OPE_ETA(rs.getString("bmtn_OPE_ETA"));
			etaChqBpm.setBmtn_ANO(rs.getString("bmtn_ANO"));
			etaChqBpm.setBmtn_CDEBPR(rs.getString("bmtn_CDEBPR"));
			etaChqBpm.setBmtn_COUNT_CHQ(rs.getString("bmtn_COUNT_CHQ"));
			etaChqBpm.setBmtn_DIFF(rs.getString("bmtn_DIFF"));
			etaChqBpm.setBmtn_DIFF_NB(rs.getString("bmtn_DIFF_NB"));
			etaChqBpm.setBmtn_LECTEUR(rs.getString("bmtn_LECTEUR"));
			etaChqBpm.setBmtn_MEM2(rs.getString("bmtn_MEM2")); 
			etaChqBpm.setBmtn_SUM_CHQ(rs.getString("bmtn_SUM_CHQ")); 
			etaChqBpm.setBmta_OPE_ETA(rs.getString("bmta_OPE_ETA"));
			etaChqBpm.setBmta_Ano(rs.getString("bmta_Ano"));
			etaChqBpm.setBmta_CDEBPR(rs.getString("bmta_CDEBPR"));
			etaChqBpm.setBmta_MEM2(rs.getString("bmta_MEM2"));
			etaChqBpm.setBmta_SQCA(rs.getString("bmta_SQCA"));
			etaChqBpm.setBmtr_NSER(rs.getString("bmtr_NSER"));
			etaChqBpm.setBmtr_MEM2(rs.getString("bmtr_MEM2"));
			etaChqBpm.setBmtr_MNT(rs.getString("bmtr_MNT"));
			etaChqBpm.setBmtr_CDECLT(rs.getString("bmtr_CDECLT"));
			etaChqBpm.setBmtr_NBCH(rs.getString("bmtr_NBCH"));
			etaChqBpm.setBmtr_MODE_ESC(rs.getString("bmtr_MODE_ESC")); 
			etaChqBpm.setBmtr_OPE_ETA(rs.getString("bmtr_OPE_ETA"));
			etaChqBpm.setBmtr_SQCA(rs.getString("bmtr_SQCA"));
			etaChqBpm.setBmtr_AGE_RMT(rs.getString("bmtr_AGE_RMT"));
			etaChqBpm.setBmtr_TIERS(rs.getString("bmtr_TIERS")); 
			etaChqBpm.setBmtr_REFCLI(rs.getString("bmtr_REFCLI"));
			etaChqBpm.setBmtr_ANO(rs.getString("bmtr_ANO")); 
			etaChqBpm.setBmch_fk_ope_mne(rs.getString("bmch_fk_ope_mne"));
			etaChqBpm.setBmch_instance(rs.getString("bmch_instance"));
			etaChqBpm.setBmch_ope_eta(rs.getString("bmch_ope_eta")); 
			etaChqBpm.setBmch_ADR_RMT(rs.getString("bmch_ADR_RMT")); 
			etaChqBpm.setBmch_ADR_TIR(rs.getString("bmch_ADR_TIR"));
			etaChqBpm.setBmch_AGE(rs.getString("bmch_AGE"));
			etaChqBpm.setBmch_CDEBPR(rs.getString("bmch_CDEBPR"));
			etaChqBpm.setBmch_CDE_REJ(rs.getString("bmch_CDE_REJ"));
			etaChqBpm.setBmch_CPT(rs.getString("bmch_CPT"));
			etaChqBpm.setBmch_CPT2(rs.getString("bmch_CPT2"));
			etaChqBpm.setBmch_DBLT(rs.getString("bmch_DBLT"));
			etaChqBpm.setBmch_DTEEMI(rs.getString("bmch_DTEEMI"));
			etaChqBpm.setBmch_FLAG_IMP(rs.getString("bmch_FLAG_IMP"));
			etaChqBpm.setBmch_FLAG_REJET(rs.getString("bmch_FLAG_REJET"));
			etaChqBpm.setBmch_FLAG_AVAL(rs.getString("bmch_FLAG_AVAL"));
			etaChqBpm.setBmch_LOC(rs.getString("bmch_LOC")); 
			etaChqBpm.setBmch_MEM2(rs.getString("bmch_MEM2"));
			etaChqBpm.setBmch_MNT(rs.getString("bmch_MNT")); 
			etaChqBpm.setBmch_NSER(rs.getString("bmch_NSER"));
			etaChqBpm.setBmch_RIB(rs.getString("bmch_RIB")); 
			etaChqBpm.setBmch_RIO(rs.getString("bmch_RIO"));
			etaChqBpm.setBmch_RSOC_TIR(rs.getString("bmch_RSOC_TIR")); 
			etaChqBpm.setBmch_SQCA(rs.getString("bmch_SQCA")); 
			etaChqBpm.setBmch_ZBK(rs.getString("bmch_ZBK"));
			etaChqBpm.setBmch_ZIB(rs.getString("bmch_ZIB"));
			etaChqBpm.setBmch_ANO(rs.getString("bmch_ANO")); 
			etaChqBpm.setBmch_VICE(rs.getString("bmch_VICE"));
			etaChqBpm.setBmch_CONF(rs.getString("bmch_CONF"));
			etaChqBpm.setBmch_DTEINV(rs.getString("bmch_DTEINV")); 
			etaChqBpm.setBmch_AGE_RMT(rs.getString("bmch_AGE_RMT"));

			
			return etaChqBpm;
		}

		
}
