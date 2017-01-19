package com.examples.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.web.domain.Registration;
import com.examples.web.service.RegistrationService;
import com.examples.web.validations.RegValidator;

@Controller
@RequestMapping("/registration")
public class RegController {
	private static final Logger LOGGER=LoggerFactory.getLogger(RegController.class);
	
	@Autowired
	private RegValidator regValidator;
	
	@Autowired
	private RegistrationService registrationService;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String displayRegistrationInputPage(Map model) {
		
		model.put("registration", new Registration());
		return "reg_input";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistrationInputPage(@Valid Registration registration,BindingResult result) {
		regValidator.validate(registration, result);
		if(result.hasErrors()){
			LOGGER.error("User is not giving data in a correct format....");			
			return "reg_input";
		}
	
	//call service layer
		registrationService.insertRegistration(registration);
		
		LOGGER.info("registration Obj:"+registration);
		return "reg_output";
	}
	
	
}
