package com.hyde.aspectj;


import com.hyde.config.P6SPYConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author ：yuyingcong
 * @date ：2024/06/13   14:23:26
 * @description： 操作日志记录
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.hyde.controller..*(..))")
    public void controllerMethods() {
    }

    @Before("controllerMethods()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("=======>>>>>  当前使用的方法是: /" + methodName);
    }

}
