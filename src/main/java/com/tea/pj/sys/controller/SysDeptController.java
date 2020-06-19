package com.tea.pj.sys.controller;

import com.tea.pj.common.vo.JsonResult;
import com.tea.pj.sys.entity.SysDepts;
import com.tea.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * creatd by mengguoqing on 2020/6/18 12:28 上午
 */
@RestController
@RequestMapping("/dept/")
public class SysDeptController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("doFindZTreeNodes")
    public JsonResult doFindZTreeNodes(){
        List<SysDepts> zTreeNodes = sysUserService.findZTreeNodes();
        return new JsonResult(zTreeNodes);
    }
}
