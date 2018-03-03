/**
 * 
 */
package com.osm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osm.dao.UserDao;
import com.osm.dto.User;
import com.osm.service.UserService;

/**
 * @author ouShiming
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int create(User user) {
		System.out.println("--This is create---");
		System.out.println(user.toString());
		int r = userDao.create(user);
		return r;
	}

	@Override
	public int update(User user) {
		System.out.println("--This is update---");
		int update = userDao.update(user);
		return update;
	}

	@Override
	public int del(String id) {
		System.out.println("--This is del---");
		int del = userDao.del(id);
		return del;
	}

	@Override
	public User getUserById(String id) {
		System.out.println("--This is getUserById---");
		User userById = userDao.getUserById(id);
		System.out.println(userById.toString());
		return userById;
	}

	@Override
	public List<User> query() {
		System.out.println("--This is query---");
		List<User> query = userDao.query();
		return query;
	}

	@Override
	public boolean myConstraintValidator(String name) {
		System.out.println("service获得的值：" + name);
		return true;//这里根据业务进行判断返回true（通过校验）还是false（不通过校验）
	}

}
