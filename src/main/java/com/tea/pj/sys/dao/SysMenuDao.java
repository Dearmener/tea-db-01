package com.tea.pj.sys.dao;

import com.tea.pj.sys.entity.Node;
import com.tea.pj.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysMenuDao {

    int updateObject(SysMenu entity);

    int insertObject(SysMenu entity);

    //统计子菜单的个数
    @Select("select count(*) from sys_menus where parentId=#{id}")
    int getChildCount(Integer id);

    //基于id删除菜单信息
    @Delete("delete from sys_menus where id=#{id}")
    int deleteObject(Integer id);

    List<Map<String,Object>> doFindObjects();

    @Select("select id,name,parentId from sys_menus")
    List<Node> findZtreeMenuNodes();
}
