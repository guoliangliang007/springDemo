package com.example.demo.service.impl;

import com.example.demo.base.result.Results;
import com.example.demo.dao.SysPermissionMapper;
import com.example.demo.dao.SysRoleMapper;
import com.example.demo.dao.SysRolePermissionMapper;
import com.example.demo.entity.SysRole;
import com.example.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Override
    public Results<SysRole> getAllRole() {
        return Results.success(0,sysRoleMapper.getAllRole());
    }

    @Override
    public Results sysRolePageLimit(Integer offset, Integer limit) {
        return Results.success(sysRoleMapper.countTotal(),sysRoleMapper.sysUserLimit(offset,limit));
    }

    @Override
    public SysRole getRoleById(Integer id) {
        return sysRoleMapper.getRoleById(id);
    }

    @Override
    public void saveRoleAndPermission(String name, String describe, String ids) {
        SysRole sysRole = new SysRole();
        sysRole.setDescribes(describe);
        sysRole.setRoleName(name);
        sysRoleMapper.insert(sysRole);
        List<Integer> list = new ArrayList<Integer>();
        String[] split = ids.split(",");
        for (String id:split) {
            list.add(Integer.valueOf(id));
        }
        sysRolePermissionMapper.insert(sysRole.getId(),list);
    }
}
