/**
 * @author ouShiMing
 *
 */
/**
 * 
 */
package com.osm.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import com.osm.domain.UserEntity;
import com.osm.domain.UserQueryConditionVo;
import com.osm.exception.UserNotExistException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable String id){
		System.out.println("del--id-->" + id);
	
	}
	
	@PutMapping("/{id:\\d+}")
	public UserEntity update(@Valid @RequestBody UserEntity user, BindingResult errors){
		if(errors.hasErrors()){
			errors.getAllErrors().stream()
			.forEach(
					error -> 
					{
//						FieldError fieldError = (FieldError)error;
//						String msg =  fieldError.getField() + " " + error.getDefaultMessage();
						System.out.println(error.getDefaultMessage());
					}
					);
		}
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	/*BindingResult 要配合valid才能使用*/
	@PostMapping
	public UserEntity create(@Valid @RequestBody UserEntity user, BindingResult errors){
		if(errors.hasErrors()){
			errors.getAllErrors().stream()
			.forEach(
					error -> 
					System.out.println(error.getDefaultMessage()));
		}
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}

	
	//@RequestMapping(value = "/user", method = RequestMethod.GET)
	/*
	 * public List<UserEntity> query(@RequestParam(name = "username", required =
	 * false, defaultValue = "Ou") String username) { System.out.println("--->"
	 * + username);
	 */
	@GetMapping()
	@JsonView(UserEntity.UserSimpleView.class)
	@ApiOperation(value = "用户查询接口")
	public List<UserEntity> query(UserQueryConditionVo condition, @PageableDefault(page = 5, size = 5, sort = "username, asc")Pageable pageable) {
		//利用反射toString
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		
		List<UserEntity> users = new ArrayList<>();
		users.add(new UserEntity());
		users.add(new UserEntity());
		users.add(new UserEntity());
		return users;
	}
	
	@JsonView(UserEntity.UserDetailView.class)
	//@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
	@GetMapping("/{id:\\d+}")
	public UserEntity getInfo(@ApiParam(value = "用户id") @PathVariable String id){
		System.out.println("id--> " + id);
//		throw new RuntimeException();
//		throw new UserNotExistException(id);
		UserEntity user = new UserEntity();
		user.setUsername("Ming");
		return user;
	}

}
