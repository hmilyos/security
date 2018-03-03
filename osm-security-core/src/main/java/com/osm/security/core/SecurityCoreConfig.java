/**
 * 
 */
package com.osm.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.osm.security.core.properties.SecurityProperties;

/**
 * @author ouShiming
 *
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
