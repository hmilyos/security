/**
 * 
 */
package com.osm.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author ouShiMing
 *
 */
/**@Target: 指定自定义的验证能用在方法和字段上面****/
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)	/*运行时的注解*/
@Constraint(validatedBy =MyConstraintValidator.class)
public @interface MyConstraint {

	/*校验不通过返回的信息*/
	String message() ;

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
