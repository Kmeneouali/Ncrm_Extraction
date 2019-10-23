package com.ncrm.SprBatch.sgma;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ncrm.dao.entities.BeanPcapt;





	public class pcaptRowMapper implements RowMapper<BeanPcapt> {

		public pcaptRowMapper() {
			super();
		}

		@Override
		public BeanPcapt mapRow(ResultSet rs, int rowNum) throws SQLException {
			BeanPcapt pcapt=new BeanPcapt();
//			idpcapt,cdePcapt,nomPcapt,Type,active,ageRattachement
			pcapt.setIdpcapt(rs.getInt("idpcapt"));
			pcapt.setCdePcapt(rs.getString("cdePcapt"));
			pcapt.setNomPcapt(rs.getString("Lib"));
			pcapt.setType(rs.getString("type"));
			pcapt.setActive(rs.getBoolean("active"));
			pcapt.setAgeRattachement(rs.getString("cdeAge"));
			return pcapt;
		}

		
}
