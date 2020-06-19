package com.tea.pj.sys.service;

import com.tea.pj.common.bo.PageObject;
import com.tea.pj.sys.entity.SysDepts;
import com.tea.pj.sys.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * creatd by mengguoqing on 2020/6/17 6:19 下午
 */
public interface SysUserService {
    PageObject<SysUser> findPageObjects(String name, Integer pageCurrent);
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 11:46 下午
     * Method: validById
     * Description:
     *          更改sys_user表中的valid状态
     */
    int validById(Integer id,Integer valid);
    
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 3:07 下午
     * Method:  
     * Description:   给添加页面中的弹出的树结构添加数据
     */
    List<SysDepts> findZTreeNodes();
    
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 3:08 下午
     * Method:  
     * Description:  给sys_users表中添加用户数据
     */
    int insertObjects(SysUser entity, Integer[] menuIds);
    
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 7:21 下午
     * Method:  
     * Description: 修改用户
     */
    Map<String,Object> findObjectById(Integer id);

    int updateObject(SysUser entity,Integer[] roleIds);
}
