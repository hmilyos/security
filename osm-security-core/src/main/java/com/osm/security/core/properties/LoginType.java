/**
 * 
 */
package com.osm.security.core.properties;

/**
 * @author ouShiming
 *用于判断登录成功或失败后返回json还是html
 */
public enum LoginType {
	/**
	 * 跳转
	 */
	REDIRECT,
	
	/**
	 * 返回json
	 */
	JSON

}
