package com.example.demo.service.impl;

import com.example.demo.base.result.Results;
import com.example.demo.dao.SysPermissionMapper;
import com.example.demo.dao.SysRolePermissionMapper;
import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysRolePermission;
import com.example.demo.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public Results<SysPermission> listAllPermission() {
        List<SysPermission> datas = sysPermissionMapper.findAll();
        /*JSONArray jSONArray = new JSONArray();
        setsysPermissionTree(0,datas,jSONArray);*/
        return Results.success(0,datas);
    }

    @Override
    public Results<SysRolePermission> listAllPermissionByRoleId(Integer roleId) {
        List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.listAllPermissionByRoleId(roleId);
        return Results.success(0,sysRolePermissions);
    }

    @Override
    public Results<SysPermission> menuList() {
        return Results.success(0,sysPermissionMapper.menuList());
    }

    @Override
    public Results<SysPermission> listAllPermissionTypeIsOne() {
        return Results.success(0,sysPermissionMapper.findAllTypeIsOne());
    }

    @Override
    public Results<SysPermission> insert(SysPermission sysPermission) {
        sysPermissionMapper.insert(sysPermission);
        return Results.success();
    }

    @Override
    public SysPermission getPermissionById(Integer id) {
        return sysPermissionMapper.getPermissionById(id);
    }

    @Override
    public Results<SysPermission> update(SysPermission sysPermission) {
        sysPermissionMapper.update(sysPermission);
        return Results.success();
    }

    @Override
    public List<SysPermission> getPermissionByUserId(Integer userId) {
        return sysPermissionMapper.getPermissionByUserId(userId);
    }

 /*   private void setsysPermissionTree(int parentId, List<SysPermission> sysPermissionAll, JSONArray jSONArray) {
        for (SysPermission per: sysPermissionAll) {
                if(per.getParentid().equals(parentId+"")){
                    String string = JSONObject.toJSONString(per);
                    JSONObject parent = (JSONObject)JSONObject.parse(string);
                    jSONArray.add(parent);
                    if(sysPermissionAll.stream().filter(p ->p.getParentid().equals(per.getId())).findAny()!=null){
                        JSONArray child = new JSONArray();
                        parent.put("child",child);
                        setsysPermissionTree(per.getId(),sysPermissionAll,child);
                    }
                }
        }
    }*/
}
