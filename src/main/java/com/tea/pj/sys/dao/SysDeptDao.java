package com.tea.pj.sys.dao;

import com.tea.pj.sys.entity.Node;
import com.tea.pj.sys.entity.SysDepts;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * creatd by mengguoqing on 2020/6/18 7:48 下午
 */
@Mapper
public interface SysDeptDao {

    SysDepts findById(Integer deptId);

    @Select("select c.*,p.name parentName from sys_depts c left join sys_depts p on c.parentId=p.id")
    List<Map<String,Object>> findObjects();

    @Select("select id,name,parentId from sys_depts")
    List<Node> findZTreeNodes();

    int updateObject(SysDepts entity);
    int insertObject(SysDepts entity);

    @Select("select count(*) from sys_depts where parentId=#{id}")
    int getChildCount(Integer id);

    @Delete("delete from sys_depts where id=#{id}")
    int deleteObject(Integer id);

}
