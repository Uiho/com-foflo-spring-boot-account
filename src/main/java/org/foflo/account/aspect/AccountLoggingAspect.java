package org.foflo.account.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component // Without Component annotation, it'll not work at all.
public class AccountLoggingAspect {
	
	private static Logger logger = LoggerFactory.getLogger(AccountLoggingAspect.class);
	
	
	
	@Before("execution(* org.foflo.account.view.*.*(..))")
	public void logBefore(JoinPoint jp){
		
		logger.info("Entering into "+jp.getSignature());
	}
	
	
	@After("execution(* org.foflo.account.view.*.*(..))")
	public void logAfter(JoinPoint jp) {
 
		logger.info("Escaping from "+jp.getSignature());
 
	}
	
	@AfterReturning(pointcut = "execution(* org.foflo.account.service.AccountServiceImpl.getSpecificAccount(..))", returning= "result")
	public void logAfterReturning(JoinPoint jp, Object result) {
		
		logger.info(jp.getSignature()+", return value: "+ result);
	}
	
	
	
	@AfterThrowing(pointcut="execution(* org.foflo.account.service.AccountServiceImpl.getSpecificAccount(..))", throwing="error")
	public void logAfterThrowing(JoinPoint jp, Throwable error){
		
		logger.info(jp.getSignature()+", Error: "+ error);
		
	}
}
