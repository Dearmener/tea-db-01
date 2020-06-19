package com.tea.pj.sys.controller;

import com.tea.pj.common.vo.JsonResult;
import com.tea.pj.sys.entity.Node;
import com.tea.pj.sys.entity.SysMenu;
import com.tea.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/menu/")
@RestController
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysMenu entity){
        int i = sysMenuService.updateObject(entity);
        return new JsonResult("update ok");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysMenu entity){
        int i = sysMenuService.insertObject(entity);
        return new JsonResult("save ok");
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        sysMenuService.deleteObjects(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects(){
        return new JsonResult(sysMenuService.findObjects());
    }

    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){
        List<Node> nodes = sysMenuService.doFindZtreeMenuNodes();
        return new JsonResult(nodes);
    }
}
