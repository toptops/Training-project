package com.network.pratice.validation.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.network.pratice.validation.dto.Request;

public class CustomValidator implements ConstraintValidator<CustomValid, Request>{
	@Override
	public boolean isValid(Request value, ConstraintValidatorContext context) {
		System.out.println(value);
		return true;
	}

}
