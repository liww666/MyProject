package com.sunyard.myproject.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Administrator on 2018/6/23.
 */
public class MyGrantedAuthority implements GrantedAuthority {
    private String auth;

    public MyGrantedAuthority(String auth) {
        this.auth = auth;
    }

    public MyGrantedAuthority() {
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String getAuthority() {
        return this.auth;
    }
}
