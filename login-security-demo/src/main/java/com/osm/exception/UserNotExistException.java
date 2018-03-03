/**
 * 
 */
package com.osm.exception;

/**
 * @author ouShiMing
 *
 */
public class UserNotExistException extends RuntimeException {

	/**
	 * http://blog.csdn.net/fbysss/article/details/5844478解释UID的原因
	 */
	private static final long serialVersionUID = -7439847447752319436L;

	private String id;
	
	public UserNotExistException(String id){
		super("user not exist");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
