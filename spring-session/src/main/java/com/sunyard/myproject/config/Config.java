package com.sunyard.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Administrator on 2018/6/14.
 */
@EnableRedisHttpSession
public class Config {
    @Bean
    public LettuceConnectionFactory connectionFactory(){
        return  new LettuceConnectionFactory();
    }
}
