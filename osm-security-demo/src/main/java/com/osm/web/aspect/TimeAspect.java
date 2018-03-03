/**
 * 
 */
package com.osm.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * @author ouShiming
 *
 */
@Aspect
@Component
public class TimeAspect {

	@Around("execution(* com.osm.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		//System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();	//args就是当前调用的方法的入参
		for (Object arg : args) {
			//System.out.println("arg is " + arg);
		}
		
		long start = new Date().getTime();
		
		Object object = pjp.proceed();	//object就是你调用的方法所返回的数据
		
		//System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
		
		//System.out.println("time aspect end");
		
		return object;
	}
}
