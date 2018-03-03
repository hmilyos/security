/**
 * 
 */
package com.osm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.osm.service.UserService;

/**
 * @author ouShiming
 *
 */
public class MyConstraintValidator  implements ConstraintValidator<MyConstraint, Object> {

	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println(value);
		System.out.println(context);
		////这里根据业务进行判断返回true（通过校验）还是false（不通过校验）
		boolean validator = userService.myConstraintValidator(value.toString());
		return validator;	
	}

}
