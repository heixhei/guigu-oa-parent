package com.baiyuechu.auth.controller;

import com.baiyuechu.auth.service.SysRoleService;
import com.baiyuechu.common.config.handler.BaiyuechuException;
import com.baiyuechu.common.result.Result;
import com.baiyuechu.common.result.ResultCodeEnum;
import com.baiyuechu.model.system.SysRole;
import com.baiyuechu.vo.system.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SysRoleController层
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")

public class SysRoleController {
    //注入SysRoleService
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询所有角色
     */
    @ApiOperation(value = "获取全部角色")
    @GetMapping("/findAll")
    public Result findAll() {
        //测试全局异常
        //int i = 10 / 0;
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaiyuechuException(200001, "出现自定义异常");
        }
        List<SysRole> sysRoles = sysRoleService.list(null);
        return Result.ok(sysRoles);
    }

    /**
     * 分页查询角色
     *
     * @param page
     * @param limit
     * @param sysRoleQueryVo
     * @return
     */
    @ApiOperation(value = "分页查询角色")
    @GetMapping("/{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo) {
        //1.创建Page对象，传递分页相关参数
        Page<SysRole> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        //2.封装条件,判断条件是否为空，不为空进行分装
        String roleName = sysRoleQueryVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)) {
            //封装 模糊查询
            wrapper.like(SysRole::getRoleName, roleName);
        }
        //调用sysRoleService方法实现
        IPage<SysRole> sysRoleIPage = sysRoleService.page(pageParam, wrapper);
        return Result.ok(sysRoleIPage);
    }

    /**
     * 添加角色
     *
     * @param sysRole
     * @return
     */
    @ApiOperation("添加角色")
    @PostMapping("/save")
    public Result saveRole(@RequestBody SysRole sysRole) {
        boolean flag = sysRoleService.save(sysRole);
        return Result.ok();
    }

    /**
     * 根据ID查询角色
     *
     * @param id
     * @return
     */
    @ApiOperation("根据ID查询角色")
    @GetMapping("/get/{id}")
    public Result selectRoleByID(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    @ApiOperation("修改角色")
    @PutMapping("/update")
    public Result updateByID(@RequestBody SysRole sysRole) {
        boolean flag = sysRoleService.updateById(sysRole);
        return Result.ok();
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        boolean flag = sysRoleService.removeById(id);
        return Result.ok();
    }

    @ApiOperation("批量删除角色")
    @DeleteMapping("batchmove")
    public Result batchMove(@RequestBody List<Long> list) {
        boolean flag = sysRoleService.removeByIds(list);
        return Result.ok();
    }
}
