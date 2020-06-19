package com.tea.pj.sys.dao;

import com.tea.pj.common.bo.SysUserDept;
import com.tea.pj.sys.entity.SysDepts;
import com.tea.pj.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * creatd by mengguoqing on 2020/6/17 6:10 下午
 */
@Mapper
public interface SysUserDao {
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 6:12 下午
     * Method:  findPageObjects
     * Description:  查询所有信息并分页
     */
    List<SysUser> findPageObjects(String username, Integer startIndex, Integer pageSize);
    int getRowCount(String username);

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 11:25 下午
     * Method: validById
     * Description: 更新sys_user表中的valid状态
     */
    int validById(Integer id,Integer valid,String modifiedUser);

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 11:39 上午
     * Method:  
     * Description:     添加用户中的树结构的显示
     */
    @Select("select * from sys_depts")
    List<SysDepts> findZTreeNodes();

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 3:10 下午
     * Method:
     * Description: 给sys_users表中添加用户数据
     */
    int insertObjects(SysUser entity);

    SysUserDept findObjectById(Integer userId);

    int updateObject(SysUser entity);
}
