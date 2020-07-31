package com.oldpei.myback.utils.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ServiceLogAspect class.
 * 
 * @author ben.zhang
 * @version 1.0
 */
@Aspect
@Component
public class ServiceLogAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLogAspect.class);
	
	@Around("execution(* com.sbibits.papyless.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
		
		LOGGER.info("====== start {}.{} ======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        // do service
        Object result = joinPoint.proceed();
        
		LOGGER.info("====== end {}.{} ======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        return result;
    }
}
