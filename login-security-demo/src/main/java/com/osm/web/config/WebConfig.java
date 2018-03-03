/**
 * 
 */
package com.osm.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.osm.web.filter.TimeFilter;
import com.osm.web.interceptor.TimeInterceptor;

/**
 * @author ouShiMing
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private TimeInterceptor timeInterceptor;
	
	/*用来拦截多线程的*/
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		/*对于Callable的多线程*/
		//configurer.registerCallableInterceptors(interceptors)
		/*对于DeferredResult的多线程*/
		//configurer.registerDeferredResultInterceptors(interceptors)
		configurer.setDefaultTimeout(4000);	//预防多线程堵塞，设置超时时间
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
	}
	
	@Bean
	public FilterRegistrationBean timeFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}
}
