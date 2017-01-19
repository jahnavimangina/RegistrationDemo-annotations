package com.examples.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.web.domain.Registration;
import com.examples.web.repository.RegistrationDao;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	private static final Logger LOGGER=LoggerFactory.getLogger(RegistrationServiceImpl.class);
	@Autowired
	private RegistrationDao registartionDao;

	public void insertRegistration(Registration registration) {
		registartionDao.insertRegistartion(registration);
		LOGGER.info("Registration Successful");
	}

}
