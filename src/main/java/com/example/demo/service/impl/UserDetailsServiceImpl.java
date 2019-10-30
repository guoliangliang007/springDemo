package com.example.demo.service.impl;

import com.example.demo.entity.SysPermission;
import com.example.demo.entity.SysUser;
import com.example.demo.security.LoginUser;
import com.example.demo.service.SysPermissionService;
import com.example.demo.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
   private SysUserService sysUserService;

   @Autowired
   private SysPermissionService sysPermissionService;

  /* @Autowired
   private PasswordEncoder passwordEncoder;*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.getSysUser(username);
        if(null == sysUser){
            throw new UsernameNotFoundException("用户" + username + "不存在");
        }else if(SysUser.Status.DISABLED ==sysUser.getStatus() ){
            throw new LockedException("用户被锁定");
        }
        //GrantedAuthority 是security 提供的权限类
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser,loginUser);
        //权限封装
        loginUser.setPermissionList(sysPermissionService.getPermissionByUserId(loginUser.getId()));

         return loginUser;
    }
}
