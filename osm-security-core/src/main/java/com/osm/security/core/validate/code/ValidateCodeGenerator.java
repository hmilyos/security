/**
 * 
 */
package com.osm.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;


/**
 * @author ouShiming
 *抽出生成验证码的方法，利于调用者覆盖原本的方法
 */
public interface ValidateCodeGenerator {
	ValidateCode generate(ServletWebRequest request);
}
