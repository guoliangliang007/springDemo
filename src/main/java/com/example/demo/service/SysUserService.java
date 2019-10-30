package com.example.demo.service;

import com.example.demo.base.result.Results;
import com.example.demo.entity.SysUser;

public interface SysUserService {
    Results sysUserPageLimit(Integer offset, Integer limit);

    Results saveUser(SysUser sysUser, Integer roleId);

    SysUser getSysUserById(Integer id);

    Results<SysUser> editSave(SysUser sysUser, Integer roleId);

    SysUser getSysUser(String username);
}
