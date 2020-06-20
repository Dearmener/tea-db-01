package com.tea.pj.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * creatd by mengguoqing on 2020/6/20 11:10 上午
 */
@Aspect
@Slf4j
@Component
public class SysLogAspect {

    @Pointcut("bean(sysUserServiceImpl)")
    public void logPointCut() {}

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint jp)
        throws Throwable{
        try {
            log.info("start:"+ System.currentTimeMillis());
            Object result = jp.proceed();
            log.info("after:"+System.currentTimeMillis());
            return result;
        }catch (Throwable e){
            log.error("T"+e.getMessage());
            throw e;
        }
    }

}
