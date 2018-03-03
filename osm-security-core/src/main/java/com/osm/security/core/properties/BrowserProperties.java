/**
 * 
 */
package com.osm.security.core.properties;

/**
 * @author ouShiming
 *
 */
public class BrowserProperties {
	//如果调用者没有配置登录页
	//就使用我这个浏览器登录模块自定义的登录页
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
	//用于判断登录成功是返回json还是返回html
	private LoginResponseType loginType = LoginResponseType.JSON;
	//记住我功能的记住多久时间，多久会过期，单位秒
	private int rememberMeSeconds = 3600;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	
	
}
