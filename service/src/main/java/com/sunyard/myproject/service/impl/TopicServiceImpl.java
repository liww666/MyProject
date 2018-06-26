package com.sunyard.myproject.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sunyard.myproject.entity.Topic;
import com.sunyard.myproject.exception.TopicNotFoundException;
import com.sunyard.myproject.jedis.JedisClient;
import com.sunyard.myproject.mapper.TopicMapper;
import com.sunyard.myproject.service.CacheService;
import com.sunyard.myproject.service.TopicService;
import com.sunyard.myproject.vo.TopicVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    private ObjectMapper objectMapper=new ObjectMapper();
    @Autowired
    private CacheService cacheService;
    @Value("${Topic_Hkey:topic_hkey}")
    private String topic_hkey;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private JedisClient jedisClient;
    @Override
    public List<Topic> findAll() {
        return this.topicMapper.findAll();
    }

    @Override
    public TopicVo findById(String id) {
        String result=jedisClient.hget(topic_hkey, id);
        if(StringUtils.isNotBlank(result)){
            TopicVo vo= null;
            try {
                vo = objectMapper.readValue(result,TopicVo.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return vo;
        }
        Topic topic=topicMapper.findById(id);
        TopicVo vo=new TopicVo();
        vo.setId(topic.getId());
        vo.setNumber(topic.getNumber());
        vo.setTeacher(topic.getTeacher());
        vo.setName(topic.getName());
        try {
            jedisClient.hset(topic_hkey,id, objectMapper.writeValueAsString(vo));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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
        cacheService.sync(topic.getId());
        return "success";
    }
}
