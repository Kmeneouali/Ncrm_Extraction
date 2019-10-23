package com.ncrm.SprBatch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ncrm.dao.entities.beanScann;







	public class tblScannRowMapper implements RowMapper<beanScann> {

		public tblScannRowMapper() {
			super();
		}

		
		public beanScann mapRow(ResultSet rs, int rowNum) throws SQLException {
			beanScann tblScann=new beanScann();
			tblScann.setCdeScanner(rs.getString("cdeScanner"));
			tblScann.setAge(rs.getString("AGE"));
			tblScann.setLib(rs.getString("LIB"));
			tblScann.setType(rs.getString("TYPE"));
			
			return tblScann;
		}

		
}
