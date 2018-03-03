/**
 * 
 */
package com.osm.security.core.properties;

/**
 * @author ouShiming
 *
 */
public class SmsCodeProperties {
	private int length = 6;
	private int expireIn = 60;
	
	private String url;	//需要进行拦截的URLs，用【，】分隔

	public int getLength() {
		return length;
	}
	public void setLength(int lenght) {
		this.length = lenght;
	}
	public int getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
