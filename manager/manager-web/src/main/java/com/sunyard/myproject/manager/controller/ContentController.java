package com.sunyard.myproject.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/4/11.
 */
@Controller
public class ContentController {
    @RequestMapping("/content")
    public String toContent(){
        return "content";
    }

    @RequestMapping("/itemlist")
    public String itemList(){
        return "item-list";
    }

}
