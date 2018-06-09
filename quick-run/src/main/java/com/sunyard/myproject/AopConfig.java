package com.sunyard.myproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 2018/4/19.
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }
}
