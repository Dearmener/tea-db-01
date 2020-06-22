package com.tea.pj.common.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * creatd by mengguoqing on 2020/6/22 9:29 上午
 */

//所有的接口都会实现Annotation接口

@Retention(RetentionPolicy.RUNTIME)//定义注解何时有效  RetentionPolicy.RUNTIME为运行时有效
@Target(ElementType.METHOD)
public @interface RequiredCache {//最终编译成.class文件
    String key() default "";
}
