/**
 * 
 */
package com.osm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.osm.dto.User;

/**
 * @author ouShiming
 *
 */

public interface UserDao {
	public int create(User user);
	public int update(User user);
	
	public int del(String id);
	
	public User getUserById(String id);
	
	public List<User> query();
}
