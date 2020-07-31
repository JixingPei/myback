package com.oldpei.myback.utils.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ControllerLogAspect class.
 * 
 * @author ben.zhang
 * @version 1.0
 */
@Aspect
@Component
public class ControllerLogAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);
	
	ThreadLocal<Long> startTime = new ThreadLocal<>();
    /**
     * A join point is in the web layer if the method is defined
     * in a type in the com.xyz.someapp.web package or any sub-package
     * under that.
     */
    @Pointcut("within(com.oldpei.myback.controller..*)")
    public void webLog() {
    	
    }
 
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
		LOGGER.info("====== start {}.{} ======",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null != attributes) {

            HttpServletRequest request = attributes.getRequest();
     
            LOGGER.info("URL : " + request.getRequestURL().toString());
            LOGGER.info("HTTP_METHOD : " + request.getMethod());
            LOGGER.info("IP : " + request.getRemoteAddr());
        }
        LOGGER.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
 
    }
 
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {

		LOGGER.info("====== end {}.{} ======",
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
    }
    
    
    
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
    	LOGGER.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()) + " milliseconds");
    }

}
