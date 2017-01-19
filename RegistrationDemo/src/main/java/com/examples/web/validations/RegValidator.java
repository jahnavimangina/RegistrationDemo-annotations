package com.examples.web.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.examples.web.domain.Registration;

@Component
public class RegValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object arg0, Errors errors) {
		Registration reg=(Registration)arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "registration.confirmpassword.error.empty","Confirm password should not be empty");
		if(!reg.getPassword().equals(reg.getConfirmPassword())){
			errors.rejectValue("confirmPassword", "registration.confirmpassword.error.notmatching",null,"Password and confirm password are not matching");
		}

	}

}
