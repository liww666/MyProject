package com.sunyard.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/4/5.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping("/")
    public String toLogin(HttpServletRequest request){
        System.out.println(request.getClass().getName());
        return "main";
    }
}
