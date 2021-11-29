package com.kpilszak.projectmanagement.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.kpilszak.projectmanagement.controllers..*) || within(com.kpilszak.projectmanagement.dao..*)")
	public void definePackagePointcuts() {
	}
	
	@After("definePackagePointcuts()")
	public void log() {
		log.debug(" ------------------------------------------------------------ ");
	}
	
}
