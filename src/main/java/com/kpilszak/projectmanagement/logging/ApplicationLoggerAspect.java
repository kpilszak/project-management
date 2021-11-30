package com.kpilszak.projectmanagement.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.kpilszak.projectmanagement.controllers..*)")
	public void definePackagePointcuts() {
	}
	
	@Around("definePackagePointcuts()")
	public Object logBefore(ProceedingJoinPoint jp) {
		log.debug(" \n \n \n ");
		log.debug("************* Before Method Execution ************* \n {}.{} () with arguments[s] = {}",
		jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("____________________________________________________ \n \n \n");
		
		Object o = null;
		
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.debug("************* After Method Execution ************* \n {}.{} () with arguments[s] = {}",
		          jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("____________________________________________________ \n \n \n");
		
		return o;
	}
	
}
