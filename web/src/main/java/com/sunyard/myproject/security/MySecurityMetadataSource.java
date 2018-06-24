package com.sunyard.myproject.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Administrator on 2018/6/23.
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private Map<String,Collection<ConfigAttribute>> resourceMap;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(resourceMap==null){
            loadResourceDefine();
        }
        FilterInvocation filterInvocation=(FilterInvocation)o;
        Iterator<String> iter=resourceMap.keySet().iterator();
        while (iter.hasNext()){
            String url=iter.next();
            if(new AntPathRequestMatcher(url).matches(filterInvocation.getRequest())){
                return resourceMap.get(url);
            }
        }
        return null;
    }

    private void loadResourceDefine() {
        resourceMap=new HashMap<>();
        List<ConfigAttribute> list1=new ArrayList<>();
        list1.add(new SecurityConfig("user_manager"));
        resourceMap.put("/topic",list1);
        List<ConfigAttribute> list2=new ArrayList<>();
        list2.add(new SecurityConfig("auth_manager"));
        resourceMap.put("/get",list2);

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
