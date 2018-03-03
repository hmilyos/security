/**
 * 
 */
package com.osm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.osm.services.TestValidatorService;

/**
 * @author ouShiMing
 *
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	@Autowired
	private TestValidatorService testValidatorService;
	
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
	//	testValidatorService.greeting("Ming");
		System.out.println("My validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println("isValid-->" + value);
		testValidatorService.greeting("Ming");
		return false;
	}

}
