package com.tea.pj.common.aspect;

import com.tea.pj.common.cache.DefaultMapCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * creatd by mengguoqing on 2020/6/22 9:37 上午
 */
@Aspect
@Component
public class SysCacheAspect {

    @Autowired
    private DefaultMapCache mapCache;

    //由这个注解描述的方法为一个切入点方法
    @Pointcut("@annotation(com.tea.pj.common.aspect.RequiredCache)")
    public void doCache(){}

    @Pointcut("@annotation(com.tea.pj.common.aspect.ClearCache)")
    public void doClear(){}

    @Around("doCache()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
       // System.out.println("Get Data from Cache");
        Object obj = mapCache.getObject("roleCache");
        if(obj!=null) return obj;
        Object result = joinPoint.proceed();//目标方法的执行结果会赋予result
        mapCache.putObject("roleCache",result);
      //  System.out.println("put Data to cache");
        return result;
    }

    @AfterReturning("doClear()")
    public void doAfterReturning(){
        mapCache.clear();
    }





}
