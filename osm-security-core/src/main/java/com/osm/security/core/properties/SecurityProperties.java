/**
 * 
 */
package com.osm.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ouShiming
 *
 */
//扫描整个项目中的Properties文件中前缀为osm.security的配置
@ConfigurationProperties(prefix = "osm.security")
public class SecurityProperties {
	
	private BrowserProperties browser = new BrowserProperties();
	
	private ValidateCodeProperties code = new ValidateCodeProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}
	

}
