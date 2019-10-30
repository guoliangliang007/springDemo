package com.example.demo.service.impl;

import com.example.demo.base.result.ResponseCode;
import com.example.demo.base.result.Results;
import com.example.demo.dao.SysRoleUserMapper;
import com.example.demo.entity.SysRoleUser;
import com.example.demo.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysRoleUserServiceImpl  implements SysRoleUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;
    @Override
    public Results<SysRoleUser> getRoleUserByUserId(Integer id) {
        return Results.success(ResponseCode.SUCCESS,sysRoleUserMapper.getRoleUserByUserId(id));
    }
}
