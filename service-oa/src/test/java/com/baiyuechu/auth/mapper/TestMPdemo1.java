package com.baiyuechu.auth.mapper;

import com.baiyuechu.auth.mapper.SysRoleMapper;
import com.baiyuechu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * SysRoleMapper接口测试
 */
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
        System.out.println(sysRole.getId());
    }
    /**
     * 修改角色
     */
    @Test
    public void updateRole() {
        //根据id查询
        SysRole sysRole = sysRoleMapper.selectById(10);
        //设置修改值
        sysRole.setRoleName("atguigu角色管理员");
        //调用方法实现最终修改
        int rows = sysRoleMapper.updateById(sysRole);
        System.out.println(rows);
    }

    /**
     *逻辑删除角色
     */
    @Test
    public void deleteRole() {
        int rows = sysRoleMapper.deleteById(10);
        System.out.println(rows);
    }

    /**
     * 批量删除角色
     */
    @Test
    public void deleteRoleBatch() {
        int rows = sysRoleMapper.deleteBatchIds(Arrays.asList(10, 11));
        System.out.println(rows);

    }

    /**
     * 条件查询
     * QueryWrapper
     */
    @Test
    public void testQuery1() {
        //创建QueryWrapper对象，调用方法封装条件
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", "用户管理员");
        //调用mp方法实现查询操作
        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);
        System.out.println(sysRoles);
    }

    /**
     * 条件查询
     * LambdaQueryWrapper
     */
    @Test
    public void testQuery2() {
        //创建LambdaQueryWrapper对象，调用方法封装条件
        //记得LambdaQueryWrapper<SysRole>这里得变成具体实体类，不然会报错，不适用于lambda形式
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName, "用户管理员");
        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);
        System.out.println(sysRoles);

    }
}
