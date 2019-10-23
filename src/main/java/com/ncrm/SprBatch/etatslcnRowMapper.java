package com.ncrm.SprBatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ncrm.dao.entities.BeanEtatsLcn;



public class etatslcnRowMapper implements RowMapper<BeanEtatsLcn> {

	

	public etatslcnRowMapper() {
		super();
	}


	public BeanEtatsLcn mapRow(ResultSet rs, int rowNum) throws SQLException {
		BeanEtatsLcn etaChqBpm = new BeanEtatsLcn();
		etaChqBpm.setBmlcn_pk_obj_idt(rs.getString("bmlcn_pk_obj_idt"));
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
		etaChqBpm.setBmta_CDEBPR(rs.getString("bmta_CDEBPR"));
		etaChqBpm.setBmta_MEM2(rs.getString("bmta_MEM2"));
		etaChqBpm.setBmta_SQCA(rs.getString("bmta_SQCA"));
//		etaChqBpm.setBmta_ANO(rs.getString("bmta_ANO"));
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
		etaChqBpm.setBmlcn_fk_ope_mne(rs.getString("Bmlcn_fk_ope_mne"));
		etaChqBpm.setBmlcn_instance(rs.getString("Bmlcn_instance"));
		etaChqBpm.setBmlcn_ope_eta(rs.getString("Bmlcn_ope_eta"));
		etaChqBpm.setBmlcn_ADR_RMT(rs.getString("Bmlcn_ADR_RMT"));
		etaChqBpm.setBmlcn_ADR_TIR(rs.getString("Bmlcn_ADR_TIR"));
		etaChqBpm.setBmlcn_AGE(rs.getString("Bmlcn_AGE"));
		etaChqBpm.setBmlcn_CDEBPR(rs.getString("Bmlcn_CDEBPR"));
		etaChqBpm.setBmlcn_CDE_REJ(rs.getString("Bmlcn_CDE_REJ"));
		etaChqBpm.setBmlcn_CPT(rs.getString("Bmlcn_CPT"));
		etaChqBpm.setBmlcn_CPT2(rs.getString("Bmlcn_CPT2"));
		etaChqBpm.setBmlcn_DBLT(rs.getString("Bmlcn_DBLT"));
		etaChqBpm.setBmlcn_DTEEMI(rs.getString("Bmlcn_DTEEMI"));
		etaChqBpm.setBmlcn_FLAG_REJET(rs.getString("Bmlcn_FLAG_REJET"));
		etaChqBpm.setBmlcn_FLAG_AVAL(rs.getString("Bmlcn_FLAG_AVAL"));
		etaChqBpm.setBmlcn_LOC(rs.getString("Bmlcn_LOC"));
		etaChqBpm.setBmlcn_MEM2(rs.getString("Bmlcn_MEM2"));
		etaChqBpm.setBmlcn_MNT(rs.getString("Bmlcn_MNT"));
		etaChqBpm.setBmlcn_NSER(rs.getString("Bmlcn_NSER"));
		etaChqBpm.setBmlcn_RIB(rs.getString("Bmlcn_RIB"));
		etaChqBpm.setBmlcn_RSOC_TIR(rs.getString("Bmlcn_RSOC_TIR"));
		etaChqBpm.setBmlcn_SQCA(rs.getString("Bmlcn_SQCA"));
		etaChqBpm.setBmlcn_ZBK(rs.getString("Bmlcn_ZBK"));
		etaChqBpm.setBmlcn_ZIB(rs.getString("Bmlcn_ZIB"));
		etaChqBpm.setBmlcn_ANO(rs.getString("Bmlcn_ANO"));
		etaChqBpm.setBmlcn_VICE(rs.getString("Bmlcn_VICE"));
		etaChqBpm.setBmlcn_CONF(rs.getString("Bmlcn_CONF"));
		etaChqBpm.setBmlcn_AGE_RMT(rs.getString("Bmlcn_AGE_RMT"));

		return etaChqBpm;
	}

}
