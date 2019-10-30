package com.example.demo.dao;

import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysRolePermission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysPermissionMapper {
     @Results({
             @Result(property = "id",column = "id",id=true),
             @Result(property = "pId",column = "parentid"),
             @Result(property = "name",column = "name")
     })
     @Select("select id,parentid,name from sys_permission")
     List<SysPermission> findAll() ;

    @Results({
            @Result(property = "id",column = "id",id=true),
            @Result(property = "pId",column = "parentid"),
            @Result(property = "name",column = "name")
    })
    @Select("select * from sys_permission")
    List<SysPermission> menuList();

    @Results({
            @Result(property = "id",column = "id",id=true),
            @Result(property = "pId",column = "parentid"),
            @Result(property = "name",column = "name")
    })
    @Select("select id,parentid,name from sys_permission where type=1")
    List<SysPermission> findAllTypeIsOne();
    @Insert("insert into sys_permission(parentid,name,css,href,type,permission,sort)" +
            "values(#{pId},#{name},#{css},#{href},#{type},#{permission},#{sort})")
    void insert(SysPermission sysPermission);

    @Select("select * from sys_permission where id = #{id}")
    SysPermission getPermissionById(Integer id);

    @Update("update sys_permission set name=#{name},css=#{css}," +
            "href=#{href},permission=#{permission},sort=#{sort} where id=#{id} ")
    void update(SysPermission sysPermission);

    @Results({
            @Result(property = "id",column = "id",id=true),
            @Result(property = "pId",column = "parentid"),
            @Result(property = "name",column = "name")
    })
    @Select("select sp.* from \n" +
            " sys_role_user sru \n" +
            "left join sys_role_permission srp on srp.roleid = sru.sys_role_id \n" +
            "left join sys_permission sp on sp.id = srp.permissionid\n" +
            "where sru.sys_user_id =1")
    List<SysPermission> getPermissionByUserId(Integer userId);
}
