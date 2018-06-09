package com.sunyard.myproject.filter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Administrator on 2018/4/27.
 */
public class TestFilter implements Filter{
    Logger logger= LoggerFactory.getLogger(TestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter before...");
//        HttpServletRequest request=(HttpServletRequest)servletRequest;
//        HttpServletResponse response=(HttpServletResponse)servletResponse;
//        if(request.getServletPath().equals("/topic")){
//            response.sendRedirect("/login");
//            return;
//        }
        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("doFilter after...");
    }

    @Override
    public void destroy() {

    }
}
