package com.tea.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户和角色关系
 */
@Mapper
public interface SysUserRoleDao {

    int deleteObjectsByRoleId(Integer roleId);
    
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 3:05 下午
     * Method:  
     * Description: 插入用户与角色关系到sys_user_roles表中
     */
    int insertObjects(Integer userId,Integer[] roleIds);

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 7:17 下午
     * Method:  
     * Description:    修改用户时查找用户菜单关系
     */
     List<Integer> findRoleIdsByUserId(Integer id);

     @Delete("delete from sys_user_roles where user_id=#{id}")
     int deleteObjectsByUserId(Integer id);

     int insertObjects();
}
