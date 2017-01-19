package com.examples.web.repository;

import com.examples.web.domain.Registration;

public interface RegistrationDao {

	
	public void insertRegistartion(Registration registration);
	
	public Registration getRegistrationByUserName(String username);
}
