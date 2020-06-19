package com.tea.pj.sys.service.impl;

import com.tea.pj.common.exception.ServiceException;
import com.tea.pj.sys.dao.SysMenuDao;
import com.tea.pj.sys.dao.SysRoleMenuDao;
import com.tea.pj.sys.entity.Node;
import com.tea.pj.sys.entity.SysMenu;
import com.tea.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    SysRoleMenuDao sysRoleMenuDao;

    @Override
    public List<Map<String,Object>> findObjects() {
        List<Map<String, Object>> list = sysMenuDao.doFindObjects();
        if(list==null || list.size()==0)
            throw new ServiceException("没有对应的菜单信息");
        return list;
    }

    @Override
    public int deleteObjects(Integer id) {
        //1.参数校验
        if(id==null || id<1)
            throw new IllegalArgumentException("id值无效");
        //2.基于id统计子菜单数，并进行校验
        int childCount = sysMenuDao.getChildCount(id);
        if(childCount>0)
            throw new ServiceException("请先删除子菜单");
            //3.删除菜单角色关系数据
            //4.删除菜单自身信息
            int i1 = sysRoleMenuDao.deleteObjectsByRoleId(id);
            int rows = sysMenuDao.deleteObject(id);
            if(rows==0)
                throw new ServiceException("记录可能不存在了");

        return 0;
    }

    @Override
    public List<Node> doFindZtreeMenuNodes() {
        List<Node> ztreeMenuNodes = sysMenuDao.findZtreeMenuNodes();
        return ztreeMenuNodes;
    }

    @Override
    public int insertObject(SysMenu entity) {
        int i = sysMenuDao.insertObject(entity);
        return 0;
    }

    @Override
    public int updateObject(SysMenu entity) {
        int i = sysMenuDao.updateObject(entity);
        return 0;
    }
}

