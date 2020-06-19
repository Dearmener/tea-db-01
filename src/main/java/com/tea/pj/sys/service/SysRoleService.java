package com.tea.pj.sys.service;

import com.tea.pj.common.bo.CheckBox;
import com.tea.pj.common.bo.PageObject;
import com.tea.pj.common.bo.SysRoleMenu;
import com.tea.pj.sys.entity.SysRole;

import java.util.List;

public interface SysRoleService {
    PageObject<SysRole> findObjects(String name, Integer pageCurrent);
    int getRowCount(String name);
    int deleteObject(Integer id);
    SysRoleMenu findObjectById(Integer id);
    int updateObject(SysRole entity, Integer[]menuIds);
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 3:24 下午
     * Method:   saveObject
     * Description:
     * 保存角色和菜单关系数据
     */
    int saveObject(SysRole entity, Integer[]menuIds);

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 5:55 下午
     * Method:  findObjects
     * Description:  查询添加用户时的复选框部分
     */
    List<CheckBox> findObjects();
}
