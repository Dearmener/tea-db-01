package com.tea.pj.sys.controller;

import com.tea.pj.common.vo.JsonResult;
import com.tea.pj.sys.entity.SysUser;
import com.tea.pj.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * creatd by mengguoqing on 2020/6/17 6:34 下午
 */
@RequestMapping("/user/")
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Integer pageCurrent){
        return new JsonResult(sysUserService.findPageObjects(username,pageCurrent));
    }

    @RequestMapping("doValidById")
    public JsonResult doValidById(Integer id,Integer valid){
        int i = sysUserService.validById(id, valid);
        return new
                JsonResult("更新成功");
    }

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 4:17 下午
     * Method:
     * Description:   添加用户
     */
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysUser entity, Integer[] roleIds){

        entity.getId();
        int i = sysUserService.insertObjects(entity, roleIds);
        return new JsonResult("添加成功");
    }

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        Map<String, Object> objectById = sysUserService.findObjectById(id);
        return new JsonResult(objectById);
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysUser entity,Integer[] roleIds){
        int i = sysUserService.updateObject(entity, roleIds);
        return new JsonResult("更新成功");
    }
}
