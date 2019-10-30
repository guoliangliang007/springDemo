package com.example.demo.service;

import com.example.demo.base.result.Results;
import com.example.demo.entity.SysRoleUser;

public interface SysRoleUserService {

    Results<SysRoleUser> getRoleUserByUserId(Integer id);
}
