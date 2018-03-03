/**
 * 
 */
package com.osm.security.browser;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author ouShiMing
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService {


	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;
 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("登录的用户名： " + username);
		/*调Server根据用户名查数据库，获取用户信息
		 * 因为没有调用数据库，所以才会在这里用encode方法，
		 * 如果是实际开发中，应该是注册的时候就调用encode方法，
		 * 	这里就不需要再调用了encode了，直接放数据库的密码即可
		 * */
		String pwd = passwordEncoder.encode("123456");	
		logger.info("数据库存密码是：" + pwd);
		
		return new User(username, pwd, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
									//可用？		没过期？                                  密码没过期                                                      没被锁定？
//									       四个true 和 密码匹配成功  才能验证通过
//		如果输入的密码与这里的密码不匹配就会匹配不成功，登录失败， authorities：权限的集合
	}

}
