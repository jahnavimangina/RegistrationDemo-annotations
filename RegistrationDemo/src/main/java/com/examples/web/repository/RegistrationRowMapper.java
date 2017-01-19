package com.examples.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.examples.web.domain.Registration;

public class RegistrationRowMapper implements RowMapper<Registration> {

	public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
		Registration reg=new Registration();
		reg.setFirstName(rs.getString("FIRST_NAME"));
		
		//----------
		return reg;
	}

}
