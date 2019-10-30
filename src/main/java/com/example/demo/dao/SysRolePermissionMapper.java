package com.example.demo.dao;

import com.example.demo.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRolePermissionMapper {

    void insert(@Param("id") Integer id, @Param("list") List<Integer> list);

    @Select("select * from sys_role_permission where roleid = #{roleId}")
    List<SysRolePermission> listAllPermissionByRoleId(Integer roleId);
}
