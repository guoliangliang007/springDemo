package com.example.demo.dao;

import com.example.demo.entity.SysRoleUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SysRoleUserMapper {

    @Insert("insert into sys_role_user(sys_user_id,sys_role_id) values(#{sysUserId},#{SysRoleId})")
    void insert(SysRoleUser sysRoleUser);

    @Select("select *  from sys_role_user where sys_user_id = #{id}")
    SysRoleUser getRoleUserByUserId(Integer id);

    @Update("update sys_role_user set sys_role_id = #{sysRoleId} where sys_user_id =#{sysUserId}")
    void updateByUserId(SysRoleUser sysRoleUser);
}
