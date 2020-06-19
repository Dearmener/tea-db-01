package com.tea.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色和菜单关系
 */
@Mapper
public interface SysRoleMenuDao {

    //基于菜单ID删除角色菜单关系数据
    int deleteObjectsByRoleId(Integer roleId);

    int insertObjects(Integer roleId, Integer[]menuIds);

    Integer[] findMenuIdsByRoleId(Integer id);

}
