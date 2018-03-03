/**
 * 
 */
package com.osm.domain;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.osm.validator.MyConstraint;

/**
 * @author ouShiMing
 *
 */
public class UserEntity {
	public interface UserSimpleView{};
	
	public interface UserDetailView extends UserSimpleView{};
	
	private String id;
	@MyConstraint(message="这是我自己的校验器")
	private String username;
	
	/*@NotBlank: 不能为空，要在api参数里面用@valid注解才生效*/
	@NotBlank(message = "密码不能为空")
	private String password;
	/**@Past: 过去的***/
	@Past(message = "生日应为过去时间")
	private Date birthday;

	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
