package com.tea.pj.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * creatd by mengguoqing on 2020/6/20 4:16 下午
 */
@Component
@Aspect
public class SysTimeAspect {
//
//    @Pointcut("bean(sysUserServiceImpl)")
//    public void doTime(){}
//
//    @Around("doTime()")
//    public void doAround(ProceedingJoinPoint pj){
//        System.out.println("Around Before");
//        try {
//            Object proceed = pj.proceed();
//            System.out.println("Around After");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//
//    @Before("doTime()")
//    public void doBefore(){
//        System.out.println("doTime before");
//    }
//
//    @After("doTime()")
//    public void doAfter(){
//        System.out.println("doTime After");
//    }
//
//    @AfterReturning("doTime()")
//    public void doAfterReturning(){
//        System.out.println("doAfterReturning");
//    }
//
//    @AfterThrowing("doTime()")
//    public void doAfterThrowing(){
//        System.out.println("doAfterThrowing");
//    }


}
