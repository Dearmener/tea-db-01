package com.tea.pj.sys.user;

import com.tea.pj.sys.dao.SysUserDao;
import com.tea.pj.sys.entity.SysUser;
import com.tea.pj.sys.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * creatd by mengguoqing on 2020/6/17 6:16 下午
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void testUserDao(){
        List<SysUser> pageObjects = sysUserDao.findPageObjects(null, 1, 3);
        for (SysUser pageObject : pageObjects) {
            System.out.println(pageObject);
        }
    }

    @Test
    public void testUserService(){

        //sysUserService.insertObjects();
    }

}
