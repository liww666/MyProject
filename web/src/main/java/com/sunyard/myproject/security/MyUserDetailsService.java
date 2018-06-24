package com.sunyard.myproject.security;

import com.sunyard.myproject.entity.SysAuth;
import com.sunyard.myproject.entity.SysRole;
import com.sunyard.myproject.entity.SysUser;
import com.sunyard.myproject.mapper.SysUserMapper;
import com.sunyard.myproject.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/18.
 */
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser=sysUserMapper.findByUsername(s);
        if(sysUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role:sysUser.getRoles())
        {
            for(SysAuth auth:role.getAuths()){

                authorities.add(new MyGrantedAuthority(auth.getName()));
                System.out.println(auth.getName());
            }
        }
        return new org.springframework.security.core.userdetails.User(sysUser.getUsername(),
                sysUser.getPassword(), authorities);
    }
}
