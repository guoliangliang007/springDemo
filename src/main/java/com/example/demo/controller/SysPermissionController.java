package com.example.demo.controller;

import com.example.demo.base.result.Results;
import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysRolePermission;
import com.example.demo.service.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping(value="/permission/permission-list")
    public String permissionList(){
        return "/permission/permission-list";
    }

    @RequestMapping(value="/permission/add")
    public String permissionAdd(){
        return "/permission/permission-add";
    }

    @RequestMapping(value="/permission/addSave")
    @ResponseBody
    public Results<SysPermission> addSave(SysPermission sysPermission){
        log.info(sysPermission.toString());
        return sysPermissionService.insert(sysPermission);
    }

    @RequestMapping(value="/permission/edit")
    public String permissionEdit(@RequestParam("id") Integer id, Model model){
        log.info("id:"+id+"");
        model.addAttribute(sysPermissionService.getPermissionById(id));
        return "/permission/permission-edit";
    }
    @RequestMapping(value="/permission/addEdit")
    @ResponseBody
    public Results<SysPermission> permissionSaveEdit(SysPermission sysPermission){
        return sysPermissionService.update(sysPermission);
    }
    @RequestMapping(value="/permission/list")
    @ResponseBody
    public Results<SysPermission> menuList(){
        return sysPermissionService.menuList();
    }

    @RequestMapping(value="/permission/listAllPermission")
    @ResponseBody
    public Results<SysPermission> listAllPermission(){
        Results<SysPermission> sysPermissionResults = sysPermissionService.listAllPermission();
        return sysPermissionResults;
    }

    @RequestMapping(value="/permission/listAllPermissionTypeIsOne")
    @ResponseBody
    public Results<SysPermission> listAllPermissionTypeIsOne(){
        Results<SysPermission> sysPermissionResults = sysPermissionService.listAllPermissionTypeIsOne();
        return sysPermissionResults;
    }
    @RequestMapping(value="/permission/listAllPermissionId")
    @ResponseBody
    public Results<SysRolePermission> listAllPermissionId(Integer roleId){
        Results<SysRolePermission> sysPermissionResults = sysPermissionService.listAllPermissionByRoleId(roleId);
        return sysPermissionResults;
    }
}
