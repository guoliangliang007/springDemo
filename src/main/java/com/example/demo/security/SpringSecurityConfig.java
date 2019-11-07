package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler;
    @Autowired
    private  AuthenticationFailHandlerImpl authenticationFailHandlerImpl;
    //自定义登录验证逻辑
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(createPasswordEncoder());
    }

    //密码加密
    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();// 解决跨站请求
        http.headers().frameOptions().sameOrigin();//解決X-frame-Options
        http.authorizeRequests() //开始权限配置
                .antMatchers("/druid/stat","/login.html","/xadmin/**",
                        "/treetable-lay/**",
                        "/ztree/**",
                        "/static/**")  //请求放行的资源
                .permitAll()
                .anyRequest().authenticated(); //任何请求都要验证
        //自定义登录界面
       // http.formLogin().loginPage("/login.html").loginProcessingUrl("/logins");
        http.formLogin().loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandlerImpl);
        //super.configure(http);
    }
}
