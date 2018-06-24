package com.sunyard.myproject.controller;

import com.sunyard.myproject.entity.Topic;
import com.sunyard.myproject.service.TopicService;
import com.sunyard.myproject.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private TopicService topicService;

    //选题系统首页
    @RequestMapping(value = "/topic",method = RequestMethod.GET)
    public String getTopicAll(Model model){
        List<Topic> topics=topicService.findAll();
        model.addAttribute("topics",topics);
        return "topic";
    }
    //检查选题的逻辑
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String checkTopic(Topic topic){
//        String id=request.getParameter("id");
//        String number=request.getParameter("number");
//        Topic topic=new Topic();
//        topic.setId(id);
//        topic.setNumber(number);
        String result=topicService.check(topic);
        return result;
    }

    @RequestMapping("/get")
    public String get(String id,Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        TopicVo vo=topicService.findById(id);
        model.addAttribute("topicVo",vo);
        return "topic_detail";
    }
}
