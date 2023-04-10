package com.baiyuechu.auth;

import com.baiyuechu.auth.mapper.SysRoleMapper;
import com.baiyuechu.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMPdemo1 {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询所有角色
     */
    @Test
    public void selectAllRoles() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);

    }

    /**
     * 添加角色
     */
    @Test
    public void addRole() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);
    }
}
