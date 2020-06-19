package com.tea.pj.common.web;

import com.tea.pj.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理异常
 * @ControllerAdvice 描述的类为一个全局异常处理类
 * 1.假如控制层方法出现了异常，
 * 此异常没有try()catch操作，而是继续抛出了，这个异常会抛出给方法调用者
 * 此对象会检测抛出异常的controller类中
 * 是否有定义异常处理方法，这个方法能否处理抛出的异常，假如不可以，那么
 * DispatcherServlet对象还会检测是否有全局的异常处理类，假如有则调用
 * 全局异常处理类中的相关异常处理方法。
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException e){
        e.printStackTrace();
        return new JsonResult(e);
    }

}
