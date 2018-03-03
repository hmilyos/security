/**
 * 
 */
package com.osm.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author ouShiming
 *
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
	@Override	//进入到调用方法前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("preHandle");
		//获取当前调用的url所在的类
		//System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
		//获取当前调用的url的方法名
		//System.out.println(((HandlerMethod)handler).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}

	@Override //进入到调用方法后执行，如果方法内发生异常就不会执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println("postHandle");
		Long start = (Long) request.getAttribute("startTime");
		//System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));
	}

	@Override	//进入到调用方法后，不管有没有报错，一定会执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex)
			throws Exception {
		//System.out.println("afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		//System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));
		//System.out.println("ex is "+ex);
	}

}
