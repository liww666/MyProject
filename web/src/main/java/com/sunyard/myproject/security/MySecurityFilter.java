package com.sunyard.myproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2018/6/23.
 */
@Component
public class MySecurityFilter extends AbstractSecurityInterceptor implements Filter {
    @Autowired
    private MySecurityMetadataSource mySecurityMetadataSource;

    @Autowired
    private MyAccessDecisoinManager myAccessDecisoinManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostConstruct
    public void init(){
        super.setAuthenticationManager(authenticationManager);
        super.setAccessDecisionManager(myAccessDecisoinManager);
    }
    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        System.out.println("obtainSecurityMetadataSource");
        return this.mySecurityMetadataSource;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter===========================init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation( servletRequest, servletResponse, filterChain );
        invoke(fi);
    }

    public void invoke( FilterInvocation fi ) throws IOException, ServletException{
        System.out.println("filter..........................");
        InterceptorStatusToken  token = super.beforeInvocation(fi);
        try{
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }finally{
            super.afterInvocation(token, null);
        }

    }

    @Override
    public void destroy() {
        System.out.println("filter===========================end");
    }
}
