package com.example.demo.service;

import com.example.demo.base.result.Results;
import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysRolePermission;

import java.util.List;

public interface SysPermissionService {
    Results<SysPermission> listAllPermission();

    Results<SysRolePermission> listAllPermissionByRoleId(Integer roleId);

    Results<SysPermission> menuList();

    Results<SysPermission> listAllPermissionTypeIsOne();

    Results<SysPermission> insert(SysPermission sysPermission);

    SysPermission getPermissionById(Integer id);

    Results<SysPermission> update(SysPermission sysPermission);

    List<SysPermission> getPermissionByUserId(Integer id);
}
