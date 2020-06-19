package com.tea.pj.sys.role;

import com.tea.pj.sys.dao.SysRoleDao;
import com.tea.pj.sys.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleTest {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Test
    public void testDao(){
        List<SysRole> sysRoles = sysRoleDao.findObjects(null,0,3);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }
}
