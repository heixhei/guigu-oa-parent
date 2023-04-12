package com.baiyuechu.auth.service.impl;

import com.baiyuechu.auth.mapper.SysRoleMapper;
import com.baiyuechu.auth.service.SysRoleService;
import com.baiyuechu.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * SysRoleService接口实现类
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
