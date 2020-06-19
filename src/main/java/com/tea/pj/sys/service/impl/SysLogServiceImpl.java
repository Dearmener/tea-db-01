package com.tea.pj.sys.service.impl;

import com.tea.pj.common.bo.PageObject;
import com.tea.pj.common.exception.ServiceException;
import com.tea.pj.sys.dao.SysLogDao;
import com.tea.pj.sys.entity.SysLog;
import com.tea.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        if(pageCurrent==null || pageCurrent<1) throw new IllegalArgumentException("当前页码值不合法");
        int rowCount = sysLogDao.getRowCount(username);
        if(rowCount==0) throw new ServiceException("没有对应记录");
        int pageSize=3;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysLog> records = sysLogDao.findPageObjects(username,startIndex,pageSize);
        return new PageObject<>(records,rowCount,pageSize,pageCurrent);
    }
}
