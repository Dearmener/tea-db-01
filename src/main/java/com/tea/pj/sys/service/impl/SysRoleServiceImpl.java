package com.tea.pj.sys.service.impl;

import com.tea.pj.common.bo.CheckBox;
import com.tea.pj.common.bo.PageObject;
import com.tea.pj.common.bo.SysRoleMenu;
import com.tea.pj.common.exception.ServiceException;
import com.tea.pj.sys.dao.SysRoleDao;
import com.tea.pj.sys.dao.SysRoleMenuDao;
import com.tea.pj.sys.dao.SysUserRoleDao;
import com.tea.pj.sys.entity.SysRole;
import com.tea.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public PageObject<SysRole> findObjects(String name, Integer pageCurrent) {
        if(pageCurrent==null || pageCurrent<1) throw new IllegalArgumentException("当前页码值无效");
        int rowCount = sysRoleDao.getRowCount(name);
        if(rowCount==0) throw new ServiceException("没有找到对应记录");
        int pageSize=3;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysRole> objects = sysRoleDao.findObjects(name,startIndex,pageSize);
        return new PageObject<>(objects,rowCount,pageSize,pageCurrent);
    }

    @Override
    public int getRowCount(String name) {
        int rowCount = sysRoleDao.getRowCount(name);
        return 0;
    }

    @Override
    public int deleteObject(Integer id) {
        if(id==null||id<=0) throw new IllegalArgumentException("请先选择");
        int i1 = sysRoleMenuDao.deleteObjectsByRoleId(id);
        int rows = sysRoleDao.deleteObject(id);
        if(rows==0)
            throw new ServiceException("此记录可能已经不存在");
        return rows;
    }

    @Override
    public SysRoleMenu findObjectById(Integer id) {
        if(id==null||id<=0) throw new IllegalArgumentException("id的值不合法");
        SysRoleMenu result = sysRoleDao.findObjectById(id);
        Integer[] menuIdsByRoleId = sysRoleMenuDao.findMenuIdsByRoleId(id);

        if(result==null) throw new ServiceException("此记录已经不存在");
        return result;
    }
    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 3:41 下午
     * Method:
     * Description:
     * 更新角色信息
     *     更新自身信息
     *     删除原有角色菜单关系数据
     *     添加新的关系数据
     */
    @Override
    public int updateObject(SysRole entity, Integer[] menuIds) {
        if(entity ==null) throw new IllegalArgumentException("更新的对象不能为空");
        if(entity.getId()==null) throw new IllegalArgumentException("id的值不能为空");
        if(StringUtils.isEmpty(entity.getName())) throw new IllegalArgumentException("角色的名字不能为空");
        if(menuIds==null||menuIds.length==0) throw new IllegalArgumentException("必须为角色指定一个权限");
        int rows = sysRoleDao.updateObject(entity);
        if(rows==0)
            throw new ServiceException("对象可能已经不存在");
        //1.)先把关系表中的关系数据全部删除
        sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
        //2.)再将新的角色和菜单关系添加到sys_role_menus表中
        sysRoleMenuDao.insertObjects(entity.getId(),menuIds);
        return 0;
    }

    /**
     * Auther: mengguoqing@gmail.com
     * Date: 2020/6/17 3:24 下午
     * Method:
     * Description:
     * 保存角色和菜单的关系数据
     */
    @Override
    public int saveObject(SysRole entity, Integer[]menuIds) {
        if(entity ==null) throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(entity.getName())) throw new IllegalArgumentException("角色名不允许为空");
        if(menuIds==null||menuIds.length==0) throw new ServiceException("必须为角色分配权限");
        //1.)添加角色信息到sys_roles表中
        int i = sysRoleDao.insertObject(entity);
        //2.）添加角色和菜单关系到sys_role_menus表中
        System.out.println(entity.getId()+ Arrays.toString(menuIds));
        int i1 = sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
        return 0;
    }

    @Override
    public List<CheckBox> findObjects() {
        return sysRoleDao.findObjects01();
    }

}
