package com.swanoff.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	
	@Pointcut("execution(* com.swanoff.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.swanoff.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.swanoff.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " + theMethod);
		
		// display the arguements to the method
		
		// get the arguements
		Object[] args = theJoinPoint.getArgs();
		
		// loop thorugh and display the arguements
		for (Object tempArg : args) {
			myLogger.info("=====>> arguement: " + tempArg);
		}
	}
	
	// add @AfterReturning advice
	
}
