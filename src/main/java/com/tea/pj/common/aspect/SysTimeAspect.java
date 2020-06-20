package com.tea.pj.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * creatd by mengguoqing on 2020/6/20 4:16 下午
 */
@Component
@Aspect
public class SysTimeAspect {

    @Pointcut("bean(sysUserServiceImpl)")
    public void doAfterReturning(){
        System.out.println("time doAferReturning");
    }
}
