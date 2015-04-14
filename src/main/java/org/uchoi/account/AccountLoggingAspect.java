package org.uchoi.account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountLoggingAspect {
	
	private static Logger logger = LoggerFactory.getLogger(AccountLoggingAspect.class);
	
	
	
	@Before("execution(* org.uchoi.account.*(..))")
	public void logBefore(JoinPoint jp){
		
		logger.info("Entering into "+jp.getSignature());
	}
	
	
	@After("execution(* org.uchoi.account.*(..))")
	public void logAfter(JoinPoint jp) {
 
		logger.info("Escaping from "+jp.getSignature());
 
	}
	
	@AfterReturning(pointcut = "execution(* banking.dao.AccountDaoImpl.saveAccount(..))", returning= "result")
	public void logAfterReturning(JoinPoint jp, Object result) {
		
		logger.info(jp.getSignature()+", return value: "+ result);
	}
	
	
	
	@AfterThrowing(pointcut="execution(* banking.dao.AccountDaoImpl.saveAccount(..)", throwing="error")
	public void logAfterThrowing(JoinPoint jp, Throwable error){
		
		logger.info(jp.getSignature()+", Error: "+ error);
		
	}
}
