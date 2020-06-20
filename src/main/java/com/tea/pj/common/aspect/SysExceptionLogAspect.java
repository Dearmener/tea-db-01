package com.tea.pj.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * creatd by mengguoqing on 2020/6/20 5:36 下午
 */
@Slf4j
@Aspect
@Component
public class SysExceptionLogAspect {

    @Pointcut("bean(sysUserServiceImpl)")
    public void doExceptionPointCut(){}

    @AfterThrowing(value = "doExceptionPointCut()",throwing = "e")
    public void doExceptionLog(Throwable e){
        log.error("error msg {}",e.getMessage());
    }

}
