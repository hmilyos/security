/**
 * 
 */
package com.osm.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;


/**
 * @author ouShiming
 *抛出的验证码校验失败异常
 */
public class ValidateCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
