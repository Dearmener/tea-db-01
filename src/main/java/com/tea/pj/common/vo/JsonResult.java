package com.tea.pj.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *VO:在当前项目中我们借助VO封装视图层要呈现的数据
 */
@Data
@NoArgsConstructor
public class JsonResult {
    private Integer state;
    private String message;
    private Object data;

    public JsonResult(String message){
        this.state = 1;
        this.message = message;
    }

    public JsonResult(Object data){
        this.state = 1;
        this.message = "OK";
        this.data = data;
    }

    //基于此构造方法进行错误信息的初始化
    public JsonResult(Throwable e){//Throwable是所有异常类的父类
        this.state = 0;//error
        this.message = e.getMessage();//获取异常信息
    }

}
