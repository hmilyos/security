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
 * @author ouShiming
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("登录用户名:" + username);
		// 根据用户名查找用户信息
		//这一加密应该是在注册时就加密的，这里只是为了不去连接数据库而写死的
		String password = passwordEncoder.encode("123456");	
		logger.info("数据库密码是:" + password);
		//根据查找到的用户信息判断用户是否被冻结，
		//这里返回的User对象不是唯一的，也可以由我们自定义一个对象，然后实现UserDetails接口，在我们自定义的对象里面进行登录的判断
		//password:数据库存的密码，账号是否可用（即是否被删除)? 没过期？ 密码没过期？没被锁定？ 当前用户所拥有的权限。
		return new User(username, password,
				true, true, true, true,
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
