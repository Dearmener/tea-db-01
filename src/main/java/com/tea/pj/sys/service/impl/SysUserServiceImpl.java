package com.tea.pj.sys.service.impl;

import com.tea.pj.common.bo.PageObject;
import com.tea.pj.common.bo.SysUserDept;
import com.tea.pj.common.exception.ServiceException;
import com.tea.pj.sys.dao.SysUserDao;
import com.tea.pj.sys.dao.SysUserRoleDao;
import com.tea.pj.sys.entity.SysDepts;
import com.tea.pj.sys.entity.SysUser;
import com.tea.pj.sys.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.*;

/**
 * creatd by mengguoqing on 2020/6/17 6:26 下午
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;



    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 11:17 下午
     * Method:
     * Description:
     *  查找数据
     */
    @Override
    public PageObject<SysUser> findPageObjects(String username, Integer pageCurrent) {
        if(pageCurrent==null || pageCurrent < 1) throw new IllegalArgumentException("当前页码值不合法");
        int rowCount = sysUserDao.getRowCount(username);
        if(rowCount==0) throw new ServiceException("没有对应记录");
        int pageSize=3;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysUser> pageObjects = sysUserDao.findPageObjects(username, startIndex, pageSize);
        return new PageObject<>(pageObjects,rowCount,pageSize,pageCurrent);
    }

    @Override
    public int validById(Integer id, Integer valid) {
        if(id==null||id<=0) throw new ServiceException("参数不合法,id="+id);
        if(valid!=1&&valid!=0) throw new ServiceException("参数不合法,valid="+valid);
//        if(StringUtils.isEmpty(modifiedUser)) throw new ServiceException("修改用户不能为空");
        int rows = sysUserDao.validById(id, valid, "admin");
        if (rows==0) throw new ServiceException("此记录可能不存在");
        return 0;
    }

    @Override
    public List<SysDepts> findZTreeNodes() {
        List<SysDepts> zTreeNodes = sysUserDao.findZTreeNodes();
        return zTreeNodes;
    }

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/18 4:28 下午
     * Method:  
     * Description: 保存数据
     */
    @Override
    public int insertObjects(SysUser entity, Integer[] roleIds) {
        if(entity==null) throw new ServiceException("用户信息为空");
        if(StringUtils.isEmpty(entity.getUsername())) throw new IllegalArgumentException("用户名为空");
        if(roleIds==null || roleIds.length==0) throw new ServiceException("必须为角色分配角色");
        String source=entity.getPassword();
        String salt=UUID.randomUUID().toString();
        SimpleHash sh=new SimpleHash(//Shiro框架
                "MD5",//algorithmName 算法
                source,//原密码
                salt, //盐值
                1);//hashIterations表示加密次数
        entity.setSalt(salt);
        entity.setPassword(sh.toHex());
        sysUserDao.insertObjects(entity);
        sysUserRoleDao.insertObjects(entity.getId(), roleIds);
        return 0;
    }

    @Override
    public Map<String,Object> findObjectById(Integer id) {
        if(id==null) throw new IllegalArgumentException("参数不合法");
        SysUserDept user = sysUserDao.findObjectById(id);
        if(user==null) throw new ServiceException("用户已经不存在");
        List<Integer> roleId = sysUserRoleDao.findRoleIdsByUserId(id);
        Map<String,Object> map = new HashMap();
        map.put("user",user);
        map.put("roleIds",roleId);
        return map;
    }

    @Override
    public int updateObject(SysUser entity,Integer[] roleIds) {
        if(entity==null) throw new IllegalArgumentException("参数不正确");
        if(roleIds==null||roleIds.length<0) throw new IllegalArgumentException("用户部门不能为空");
        int i2 = sysUserRoleDao.insertObjects(entity.getId(), roleIds);
        int i = sysUserRoleDao.deleteObjectsByUserId(entity.getId());
        int i1 = sysUserDao.updateObject(entity);
        return 0;
    }


}
