package com.sunyard.myproject.config;

import com.sunyard.myproject.filter.TestFilter;
import com.sunyard.myproject.interceptor.TestInterceptor;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import javax.servlet.FilterRegistration;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/3/28.
 */
@Configuration
@EnableWebMvc
public class MyWebMVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm){
        ContentNegotiatingViewResolver cnvr =
                new ContentNegotiatingViewResolver();
        cnvr.setContentNegotiationManager(cnm);
        return cnvr;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public TestFilter testFilter(){
        return  new TestFilter();
    }

    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistration=new FilterRegistrationBean(testFilter());
        filterRegistration.addUrlPatterns("/**");
        return filterRegistration;
    }
}
