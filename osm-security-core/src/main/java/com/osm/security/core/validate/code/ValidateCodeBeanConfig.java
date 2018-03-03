/**
 * 
 */
package com.osm.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.osm.security.core.properties.SecurityProperties;
import com.osm.security.core.validate.code.image.ImageCodeGenerator;
import com.osm.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.osm.security.core.validate.code.sms.SmsCodeSender;

/**
 * @author ouShiming
 *验证码的配置器，项目启动时检测有无调用者覆盖本默认的验证码生成逻辑，
 *若无，执行默认生成逻辑
 *有 ， 执行调用者的验证码生成逻辑
 */
@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean	
	//这里是指当系统启动初始化时如果有imageCodeGenerator这个bean就不执行本方法，即调用者覆盖本验证码生成逻辑
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator(); 
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}
	
	@Bean
	//这里是指当系统启动初始化时如果有SmsCodeSender.class就不执行本方法，即调用者覆盖本验证码生成逻辑
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}

}
