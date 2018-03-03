/**
 * 
 */
package com.osm.security.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.osm.security.core.authentication.AbstractChannelSecurityConfig;
import com.osm.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.osm.security.core.properties.SecurityConstants;
import com.osm.security.core.properties.SecurityProperties;
import com.osm.security.core.validate.code.ValidateCodeSecurityConfig;

/**
 * @author ouShiming
 *
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
	
	@Autowired
	private SecurityProperties securityProperties;

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Bean	//配置记住我功能的数据库源
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		//在数据中创建一张用于存储用户名和token的表，第一次时就需要执行这个，后面就不需要了
		//tokenRepository.setCreateTableOnStartup(true);	
		return tokenRepository;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		//如果使用了其他的加密方式，这里就应该返回对应的加密方式，重写一个类实现PasswordEncoder接口
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		applyPasswordAuthenticationConfig(http);
		
		http.apply(validateCodeSecurityConfig)
				.and()
			.apply(smsCodeAuthenticationSecurityConfig)
				.and()
			.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
				.userDetailsService(userDetailsService)
				.and()
			.authorizeRequests()
				.antMatchers(
					SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
					SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
					securityProperties.getBrowser().getLoginPage(),
					SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*")
					.permitAll()
				.anyRequest()
				.authenticated()
				.and()
			.csrf().disable();
		
		
/*//		http.httpBasic()	//配置弹窗登录方式	
		http.formLogin()	//配置表单登录方式
			.loginPage("/signIn.html")
			.loginProcessingUrl("/authentication/form")
			.and()
			.authorizeRequests()
			.antMatchers("/signIn.html").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.csrf().disable();*/
		
	}

}
