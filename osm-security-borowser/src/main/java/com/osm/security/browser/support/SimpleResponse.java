/**
 * 
 */
package com.osm.security.browser.support;

/**
 * @author ouShiming
 *用于客户端请求时返回需要登录的提示
 */
public class SimpleResponse {
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
