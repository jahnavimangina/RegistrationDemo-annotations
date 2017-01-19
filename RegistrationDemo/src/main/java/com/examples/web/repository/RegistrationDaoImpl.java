package com.examples.web.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examples.web.domain.Registration;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertRegistartion(Registration registration) {

		jdbcTemplate.update("INSERT INTO REGISTRATION VALUES(?,?,?,?,?)", registration.getFirstName(),
				registration.getLastName(), registration.getUserName(), registration.getPassword(),
				registration.getEmail());
		LOGGER.info("insertion into database is successful");
	}

	public Registration getRegistrationByUserName(String username) {
		List<Registration> lst = jdbcTemplate.query("select * from Registration where user_name=?",
				new Object[] { username }, new RegistrationRowMapper());
		if (lst == null || lst.isEmpty()) {
			return null;
		}
		return lst.get(0);
	}

}
