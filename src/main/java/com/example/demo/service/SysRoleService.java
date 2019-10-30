package com.example.demo.service;

import com.example.demo.base.result.Results;
import com.example.demo.entity.SysRole;

public interface SysRoleService {
    Results<SysRole> getAllRole();

    Results sysRolePageLimit(Integer offset, Integer limit);

    SysRole getRoleById(Integer id);

    void saveRoleAndPermission(String name, String describe, String ids);
}
