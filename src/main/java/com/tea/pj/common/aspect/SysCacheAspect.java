package com.tea.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * creatd by mengguoqing on 2020/6/22 9:37 上午
 */
@Aspect
@Component
public class SysCacheAspect {

    //由这个注解描述的方法为一个切入点方法
    @Pointcut("@annotation(com.tea.pj.common.aspect.RequiredCache)")
    public void doCache(){}

    @Around("doCache()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Get Data from Cache");
        Object result = joinPoint.proceed();//目标方法的执行结果会赋予result
        System.out.println("put Data to cache");
        return result;
    }



}
