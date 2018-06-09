package com.sunyard.myproject.config;

import com.sunyard.myproject.common.MagicBean;
import com.sunyard.myproject.condition.MagicExistsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/4/18.
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
