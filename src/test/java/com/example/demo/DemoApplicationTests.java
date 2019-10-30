package com.example.demo;

import com.example.demo.dao.SysUserMapper;
import com.example.demo.entity.SysUser;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    DataSource dataSource;

    @Resource
    SysUserMapper sysUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
        //System.out.println(dataSource.getClass());
        //SysUser admin = sysUserMapper.getUsername("admin");
        //System.out.println(admin);
        /*SysUser sysUser = new SysUser();
        sysUser.setUsername("root");
        sysUser.setPassword("root");
        System.out.println(sysUser);*/
        /*int insert = sysUserMapper.insert(sysUser);
        System.out.println(sysUser);
        int insert_2 = sysUserMapper.insert_2(sysUser);
        System.out.println(sysUser);*/
        /*List<SysUser> sysUser2 = sysUserMapper.get();
        System.out.println(sysUser2);*/
        String encode = passwordEncoder.encode("cddadmincdd");
        System.out.println(encode);
    }

}
