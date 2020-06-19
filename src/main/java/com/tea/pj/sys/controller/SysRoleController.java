package com.tea.pj.sys.controller;

import com.tea.pj.common.bo.PageObject;
import com.tea.pj.common.bo.SysRoleMenu;
import com.tea.pj.common.vo.JsonResult;
import com.tea.pj.sys.entity.SysRole;
import com.tea.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Auther: mengguoqing@gmail.com
 * Date: 2020/6/17 1:41 上午
 * Method:  
 * Description:
 */
@RequestMapping("/role/")
@RestController
public class SysRoleController {

    @Autowired
    private SysRoleService sysRolesService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindObjects(String name,Integer pageCurrent){
        System.out.println("SysRoleController.doFindObjects");
        PageObject<SysRole> objects = sysRolesService.findObjects(name,pageCurrent);
        return new JsonResult(objects);
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        int i = sysRolesService.deleteObject(id);
        return new JsonResult("delete ok");
    }

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 1:29 上午
     * Method:
     * Description:
     */
    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){
        SysRoleMenu objectByid = sysRolesService.findObjectById(id);
        return new JsonResult(objectByid);
    }

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 1:31 上午
     * Method:  
     * Description:
     */
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysRole sysRole, Integer[] menuIds){
        int i = sysRolesService.updateObject(sysRole,menuIds);
        return new JsonResult("更新成功");
    }

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 1:30 上午
     * Method:  
     * Description:
     */
    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysRole entity, Integer[] menuIds){
        int i = sysRolesService.saveObject(entity,menuIds);
        return new JsonResult("保存成功");
    }

    /**
     * Auther: mengguoqing@gmail.com 0ggg-g
     * Date: 2020/6/18 3:03 下午
     * Method:  
     * Description:  查询sys_roles中的角色信息到添加页面上
     */
    @RequestMapping("doFindRoles")
    public JsonResult doFindRoles(){
        return new JsonResult(sysRolesService.findObjects());
    }



}
