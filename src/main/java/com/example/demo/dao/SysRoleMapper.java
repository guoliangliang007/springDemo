package com.example.demo.dao;

import com.example.demo.entity.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    @Select("select * from sys_role")
    List<SysRole> getAllRole() ;

    @Select("select count(id) from sys_role")
    Integer countTotal();
    @Select("select * from sys_role order by id limit #{start},#{limit}")
    List<SysRole> sysUserLimit(@Param("start") Integer offset, @Param("limit") Integer limit);
    @Select("select * from sys_role where id = #{id}")
    SysRole getRoleById(Integer id);

    @Insert("insert into sys_role(role_name,describes) values (#{roleName},#{describes})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(SysRole sysRole);
}
