package com.sunyard.myproject.service.impl;

import com.sunyard.myproject.jedis.JedisClient;
import com.sunyard.myproject.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/6/26.
 */
@Component
public class CacheServiceImpl implements CacheService {
    @Value("${Topic_Hkey:topic_hkey}")
    private String topic_hkey;
    @Autowired
    private JedisClient jedisClient;
    @Override
    public void sync(String key) {
        jedisClient.hdel(topic_hkey,key);
    }
}
