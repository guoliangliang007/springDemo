package com.example.demo.controller;

import com.example.demo.base.result.PageRequest;
import com.example.demo.base.result.Results;
import com.example.demo.entity.SysRole;
import com.example.demo.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/role/all")
    @ResponseBody
    public Results<SysRole> role_all(){
      return sysRoleService.getAllRole();
    }


    @RequestMapping("/role/role_list")
    public String role_list(){
        return "/role/admin-role";
    }

    @RequestMapping("/role/list")
    @ResponseBody
    public Results role_list(PageRequest request){
        request.countOffset();
        return sysRoleService.sysRolePageLimit(request.getOffset(),request.getLimit());
    }
    @RequestMapping("/role/add")
    public String role_add(){
        return "/role/role-add";
    }

    @RequestMapping("/role/addSave")
    @ResponseBody
    public Results role_addSave(String name, String describe, String ids){
        log.info(name); log.info(describe);
        log.info(ids);
        sysRoleService.saveRoleAndPermission(name,describe,ids);
       return Results.success();
    }

    @RequestMapping("/role/edit")
    public String role_edit(Integer id, Model modelAndView){
        modelAndView.addAttribute(sysRoleService.getRoleById(id));
        return "/role/role-edit";
    }
}
