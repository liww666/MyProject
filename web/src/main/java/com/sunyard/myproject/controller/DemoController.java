package com.sunyard.myproject.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Administrator on 2018/3/29.
 */
@Controller
@ConfigurationProperties(prefix = "user")
@EnableConfigurationProperties
public class DemoController {

    @RequestMapping("/hello")
    public String doSome(Model model){
        /*
        因为/hello请求被ingore,所以获取不到当前用户的信息
         */
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        User user=(User)(authentication==null?null:authentication.getPrincipal());
        if(user!=null){
            model.addAttribute("name", user.getUsername());
            model.addAttribute("userId",user.getPassword());
        }
        return "Hello";
    }

}
