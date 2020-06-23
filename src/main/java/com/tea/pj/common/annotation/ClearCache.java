package com.tea.pj.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * creatd by mengguoqing on 2020/6/22 10:39 上午
 */
@Retention(RetentionPolicy.RUNTIME)//定义注解何时有效  RetentionPolicy.RUNTIME为运行时有效
@Target(ElementType.METHOD)
public @interface ClearCache {
    String key() default "";
}