/**
 * 
 */
package com.osm.security.core.validate.code.sms;

/**
 * @author ouShiming
 *
 */
public interface SmsCodeSender {
	void send(String mobile, String code);
}
