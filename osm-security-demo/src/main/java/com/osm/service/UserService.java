/**
 * 
 */
package com.osm.service;

import java.util.List;

import com.osm.dto.User;

/**
 * @author ouShiming
 *
 */
public interface UserService {
	
	int create(User user);
	
	int update(User user);
	
	int del(String id);
	
	User getUserById(String id);
	
	List<User> query();
	
	boolean myConstraintValidator(String name);
}
