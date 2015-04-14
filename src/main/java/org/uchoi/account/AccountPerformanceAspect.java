package org.uchoi.account;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AccountPerformanceAspect {

	private static Logger logger = LoggerFactory.getLogger(AccountPerformanceAspect.class);
	
	@Around("execution(* org.uchoi.account.*.*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		
        Object retVal = pjp.proceed();
        
        long end = System.currentTimeMillis();
        
		logger.info("Time to run method " + pjp.getSignature() + ": " + (end - start) + " ms.");
        
        return retVal;
	}

}
