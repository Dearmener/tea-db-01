package com.tea.pj.sys.service;

import com.tea.pj.sys.entity.Node;
import com.tea.pj.sys.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {
    List<Map<String,Object>> findObjects();

    int deleteObjects(Integer id);

    List<Node> doFindZtreeMenuNodes();

    int insertObject(SysMenu entity);

    int updateObject(SysMenu entity);
}
