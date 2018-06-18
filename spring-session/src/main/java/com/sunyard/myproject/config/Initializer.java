package com.sunyard.myproject.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Administrator on 2018/6/14.
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
    public Initializer() {
        super(Config.class);
    }
}
