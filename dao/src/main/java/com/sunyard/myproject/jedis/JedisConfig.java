package com.sunyard.myproject.jedis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2018/6/25.
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisPool jedisPool(){
        JedisPool jedisPool=new JedisPool("localhost",6379);
        return jedisPool;
    }

}
