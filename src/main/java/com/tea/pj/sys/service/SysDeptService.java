package com.tea.pj.sys.service;

import com.tea.pj.sys.entity.Node;
import com.tea.pj.sys.entity.SysDepts;

import java.util.List;
import java.util.Map;

/**
 * creatd by mengguoqing on 2020/6/19 10:11 上午
 */
public interface SysDeptService {
    List<Map<String,Object>> findObjects();
    List<Node> findZTreeNodes();
    int saveObject(SysDepts entity);
    int updateObject(SysDepts entity);
    int deleteObject(Integer id);
}
