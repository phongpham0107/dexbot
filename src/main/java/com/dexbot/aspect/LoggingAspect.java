package com.dexbot.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class LoggingAspect {
	
	/**
	 * Show log api
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.dexbot.portal..*Controller.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		String info = method.getName() + " - (" + pjp.getSignature().getDeclaringTypeName() + ")";
		long start = System.currentTimeMillis();
		log.info("--------------------");
		log.info("Going to call the method:" + info);
		Object output = pjp.proceed(pjp.getArgs());
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution completed: " + elapsedTime + " miliseconds.");
		log.info("--------------------");
		return output;
	}
}
