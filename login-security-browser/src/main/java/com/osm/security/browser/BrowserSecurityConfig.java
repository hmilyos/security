/**
 * 
 */
package com.osm.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ouShiMing
 *
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		/*如果你用了其他的加密方法，比如MD5加密，需要自己实现PasswordEncoder这个类   ，然后再返回这个类即可*/
		return new BCryptPasswordEncoder();
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
//		http.httpBasic()
		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated();
	}
}
