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
 * @author ouShiming
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	/* 在这里进行配置就相当于我们在springMVC里面的Web.xml进行配置*/
	@Autowired
	private TimeInterceptor timeInterceptor;

	@Override	//对异步线程的拦截器配置
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		super.configureAsyncSupport(configurer);
//		configurer.registerCallableInterceptors(null);	//对Callable方式的线程进行配置拦截器
//		configurer.registerDeferredResultInterceptors(null);	//对DeferredResultHolder方式的线程进行配置拦截器
//		configurer.setDefaultTimeout(10000);	//线程超时时间
//		configurer.setTaskExecutor(null);	//自己的线程池进行配置，不适用spring默认的线程池
	}
	
	@Override	//对同步线程的拦截器配置
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
	}
	
	@Bean	
	public FilterRegistrationBean timeFilter() {
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		//urls.add("/user/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
		
	}
}
