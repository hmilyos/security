package com.osm.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TimeAspect {
	
	/*一般都会使用这个注解当切入点
	 * execution(* com.osm.web.controller.UserController.*(..))
	 * 执行		*：返回值 		指定类						*(..)类里面的所有方法
	 * */
	@Around("execution(* com.osm.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable{
		/*pjp里面包含了当前拦截的方法的所有信息*/
		System.out.println("time aspect start");
		Object[] args = pjp.getArgs();
		for(Object arg: args){
			System.out.println("arg is " + arg);
		}
		Long start = new Date().getTime();
		/*执行被拦着的方法*/
		Object object = pjp.proceed();
		System.out.println("time aspect end 耗时：" + (new Date().getTime() - start));
		return object;
	}
}
