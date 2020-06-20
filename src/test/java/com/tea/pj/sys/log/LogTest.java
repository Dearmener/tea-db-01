package com.tea.pj.sys.log;

import com.tea.pj.common.bo.PageObject;
import com.tea.pj.sys.dao.SysLogDao;
import com.tea.pj.sys.entity.SysLog;
import com.tea.pj.sys.entity.SysUser;
import com.tea.pj.sys.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LogTest {

    @Autowired
    private SysLogDao sysLogDao;

    @Autowired
    private SysUserService userService;

    @Test
    public void test1(){
        List<SysLog> admin = sysLogDao.findPageObjects("admin", 1, 5);
        int row = sysLogDao.getRowCount("admin");
        System.out.println(row);
        for (SysLog sysLog : admin) {
            System.out.println(sysLog);
        }

    }

    @Test
    public void testSysUserService(){
        PageObject<SysUser> po = userService.findPageObjects("admin",1);
        //System.out.println("rowCount"+po.getRowCount());
    }

}
