package com.example.demo.service.impl;

import com.example.demo.base.result.ResponseCode;
import com.example.demo.base.result.Results;
import com.example.demo.dao.SysRoleUserMapper;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.entity.SysRoleUser;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public Results sysUserPageLimit(Integer offset, Integer limit) {
        return  Results.success(sysUserMapper.countTotal(),sysUserMapper.sysUserLimit(offset,limit));
    }

    @Override
    public Results saveUser(SysUser sysUser, Integer roleId) {
        if(null!=roleId && !"".equals(roleId)){
            //处理手机号是否重复
            SysUser user = sysUserMapper.getSysUserByPhone(sysUser.getPhone());
            if(null!=user){
                return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
            }
            sysUser.setStatus(1);
            sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
            sysUserMapper.insert(sysUser);
            SysRoleUser sysRoleUser = new SysRoleUser();
            sysRoleUser.setSysRoleId(roleId);
            sysRoleUser.setSysUserId(sysUser.getId());
            sysRoleUserMapper.insert(sysRoleUser);
            return Results.success();
        }
        return Results.failure();
    }

    @Override
    public SysUser getSysUserById(Integer id) {
        return sysUserMapper.getSysUserById(id);
    }

    @Override
    public Results<SysUser> editSave(SysUser sysUser, Integer roleId) {
        if(null!=roleId && !"".equals(roleId)){
            //处理手机号是否重复
            SysUser user = sysUserMapper.getSysUserByPhone(sysUser.getPhone());
            if(null!=user && user.getId().intValue()!=sysUser.getId().intValue()){
                return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
            }
            sysUserMapper.update(sysUser);
            SysRoleUser sysRoleUser = new SysRoleUser();
            sysRoleUser.setSysRoleId(roleId);
            sysRoleUser.setSysUserId(sysUser.getId());
            sysRoleUserMapper.updateByUserId(sysRoleUser);
            return Results.success();
        }
        return Results.failure();
    }

    @Override
    public SysUser getSysUser(String username) {
        return sysUserMapper.getSysUser(username);
    }
}
