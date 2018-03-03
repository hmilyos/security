/**
 * 
 */
package com.osm.web.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.osm.dto.User;
import com.osm.dto.UserQueryCondition;
import com.osm.exception.UserNotExistException;
import com.osm.service.UserService;

/**
 * @author ouShiming
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	//@RequestMapping(value = "/user", method = RequestMethod.GET)
	//public List<User> query(@RequestParam(required = false, defaultValue = "Ou") String username){
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition user, Pageable pageable){
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getSort());
		List<User> query = new ArrayList<>();
		query.add(new User());
		query.add(new User());
		
		
		//List<User> query = userService.query();
		//ArrayList<User> list = new ArrayList<>();
	
		return query;
	}
	
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable String id) {
		//throw new UserNotExistException(id);
		
		//throw new RuntimeException("user not exist");
		User user = new User();
		user.setUsername("tom");
		//User userById = userService.getUserById(id);
		return user;
	}
	
	@PostMapping
	//public User create(@Valid @RequestBody User user, BindingResult errors) {
	public User create(@Valid @RequestBody User user, BindingResult errors) {
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}

		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());

		/*int row = userService.create(user);
		user.setId(row + "");*/
		
		user.setId("1");
		return user;
	}

	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors) {

		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> {
				// FieldError fieldError = (FieldError)error;
				// String message = fieldError.getField() +" "+
				// error.getDefaultMessage();
				System.out.println(error.getDefaultMessage());
			});
		}


		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		//int row = userService.update(user);
		return user;
	}

	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable String id) {
		int del = userService.del(id);
		System.out.println(id);
	}
}


