package com.sunyard.myproject.service;

import com.sunyard.myproject.core.BaseService;
import com.sunyard.myproject.entity.Topic;
import com.sunyard.myproject.vo.TopicVo;

import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
public interface TopicService extends BaseService<Topic,TopicVo,String>{
    String check(Topic topic);
}
