package com.example.demo.controller;


import com.example.demo.base.result.PageRequest;
import com.example.demo.base.result.ResponseCode;
import com.example.demo.base.result.Results;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.entity.SysRoleUser;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@Api(value = "用户管理")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/hello")
    public  String hello(Model model){
        model.addAttribute("name","thymeleaf");
        return "admin-list";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/user/list")
    @ResponseBody
    public Results user_list(PageRequest request){
        request.countOffset();
        log.info(request.toString());
        return sysUserService.sysUserPageLimit(request.getOffset(),request.getLimit());
    }



    @RequestMapping("/user/add")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public String user_add(PageRequest request){
        return "user/admin-add";
    }

    @RequestMapping("/user/addSave")
    @ResponseBody
    public Results<SysUser> user_addSave(SysUser sysUser,Integer roleId){
        return sysUserService.saveUser(sysUser, roleId);
    }
    @ApiOperation(value = "修改用户信息",notes ="根据用户id修改")
    @ApiImplicitParam(name="sysUser",value = "用户实体类",required = false)
    @RequestMapping(value = "/user/edit",method = RequestMethod.POST)
    public String user_edit(SysUser sysUser,Model model){
        model.addAttribute(sysUserService.getSysUserById(sysUser.getId()));
        return "user/admin-edit";
    }
    @ApiOperation(value = "修改用户信息保存",notes ="根据用户id修改保存")
    @RequestMapping(value="/user/editSave",method = RequestMethod.POST)
    @ResponseBody
    public Results<SysUser> user_editSave(SysUser sysUser,Integer roleId){
        return sysUserService.editSave(sysUser, roleId);
    }
}
