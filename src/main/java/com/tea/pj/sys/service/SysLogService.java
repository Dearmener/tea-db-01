package com.tea.pj.sys.service;

import com.tea.pj.common.bo.PageObject;
import com.tea.pj.sys.entity.SysLog;

public interface SysLogService {
    PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);
}
