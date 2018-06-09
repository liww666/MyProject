package com.sunyard.myproject.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/3/29.
 */
@Controller
@ConfigurationProperties(prefix = "user")
@EnableConfigurationProperties
public class DemoController {
    private String userId;

    @RequestMapping("/")
    public String doSome(Model model){
        model.addAttribute("name","Lww");
        model.addAttribute("userId",getUserId());
        return "Hello";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
