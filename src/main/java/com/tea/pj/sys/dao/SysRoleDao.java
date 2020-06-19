package com.tea.pj.sys.dao;

import com.tea.pj.common.bo.CheckBox;
import com.tea.pj.common.bo.SysRoleMenu;
import com.tea.pj.sys.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface SysRoleDao {
    List<SysRole> findObjects(String name, Integer startIndex, Integer pageSize);
    int getRowCount(String name);
    int deleteObject(Integer id);
    SysRoleMenu findObjectById(Integer id);
    int updateObject(SysRole entity);
    int insertObject(SysRole entity);

    List<CheckBox> findObjects01();
}
