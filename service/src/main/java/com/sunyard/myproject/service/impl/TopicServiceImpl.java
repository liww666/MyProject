package com.sunyard.myproject.service.impl;

import com.sunyard.myproject.entity.Topic;
import com.sunyard.myproject.exception.TopicNotFoundException;
import com.sunyard.myproject.mapper.TopicMapper;
import com.sunyard.myproject.service.TopicService;
import com.sunyard.myproject.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public List<Topic> findAll() {
        return this.topicMapper.findAll();
    }

    @Override
    public TopicVo findById(String id) {
        Topic topic=topicMapper.findById(id);
        TopicVo vo=new TopicVo();
        vo.setId(topic.getId());
        vo.setNumber(topic.getNumber());
        vo.setTeacher(topic.getTeacher());
        vo.setName(topic.getName());
        return vo;
    }

    @Override
    public String check(Topic topic) {
        Topic topic1=topicMapper.findById(topic.getId());
        //如果提交的俩个属性为空
        if (topic1==null||topic1.getNumber().equals("")){
            //返回iderror.html
//            return "iderror";
            throw new TopicNotFoundException();
        }
        if ((!topic1.getNumber().equals("0"))||topic.getNumber().equals("0")){
            return "numbererror";
        }
        topicMapper.update(topic);
        return "success";
    }
}
