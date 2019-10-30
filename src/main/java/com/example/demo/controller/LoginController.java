package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping("login.html")
    public String loginView(){
        log.info("去登录界面");
        return "login";
    }

    @RequestMapping("login")
    public void login(String username,String password){
       log.info("username:"+username);
        log.info("password:"+password);
    }
}
