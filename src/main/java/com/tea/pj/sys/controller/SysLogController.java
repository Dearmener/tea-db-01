package com.tea.pj.sys.controller;

import com.tea.pj.common.bo.PageObject;
import com.tea.pj.common.vo.JsonResult;
import com.tea.pj.sys.entity.SysLog;
import com.tea.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/log/")
public class SysLogController {

    @Autowired
    SysLogService sysLogService;

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String username,Integer pageCurrent){
        PageObject<SysLog> pageObjects = sysLogService.findPageObjects(username,pageCurrent);
        return new JsonResult(pageObjects);
    }
}
