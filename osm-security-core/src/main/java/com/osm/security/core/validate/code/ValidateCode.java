/**
 * 
 */
package com.osm.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * @author ouShiming
 *
 */
public class ValidateCode {
	private String code;	//验证码
	
	private LocalDateTime expireTime; //验证码过期时间
	
	public ValidateCode(String code, int expireIn){
		this.code = code;	//传入的是过期时长，而不是具体的过期时间
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}
	
	public ValidateCode(String code, LocalDateTime expireTime){
		this.code = code;
		this.expireTime = expireTime;
	}
	
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	
}
