package com.example.demo.dao;

import com.example.demo.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysUserMapper {
    @Results({
            @Result(property = "id",column = "id",id=true),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "paswword")
    })
    @Select("select * from sys_user where username =#{username}")
   SysUser getUsername(String username);


    //返回主键 前提：主键自增长
    @Insert("insert into sys_user(username,password,phone,status,birthdy) values (#{username},#{password},#{phone},#{status},#{birthdy})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(SysUser sysUser);

    //返回主键 前提：主键非自增长
    @Insert("insert into sys_user(username,password) values (#{username},#{password})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",resultType = Integer.class,before = false)
    int insert_2(SysUser sysUser);


    List<SysUser> get();

    @Select("select count(id) from sys_user")
    Integer countTotal();

    @Select("select * from sys_user order by id limit #{start},#{limit}")
    List<SysUser> sysUserLimit(@Param("start") Integer offset,@Param("limit") Integer limit);

    @Select("select * from sys_user where phone = #{phone} limit 1")
    SysUser getSysUserByPhone(String phone);

    @Select("select * from sys_user where id =#{id}")
    SysUser getSysUserById(Integer id);

    @Update("update sys_user set username =#{username},phone=#{phone},birthdy=#{birthdy} where id =#{id}")
    void update(SysUser sysUser);


    @Select("select * from sys_user where username =#{username}")
    SysUser getSysUser(String username);
}
