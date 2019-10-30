package com.example.demo.controller;

import com.example.demo.base.result.Results;
import com.example.demo.entity.SysRole;
import com.example.demo.entity.SysRoleUser;
import com.example.demo.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysRoleUserController {

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @RequestMapping("/roleUser/roleId")
    @ResponseBody
    public Results<SysRoleUser> roleId(Integer id){
        return sysRoleUserService.getRoleUserByUserId(id);
    }

}
