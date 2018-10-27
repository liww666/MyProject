package com.sunyard.myproject.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunyard.myproject.entity.SysUser;
import com.sunyard.myproject.entity.Topic;
import com.sunyard.myproject.jedis.JedisClient;
import com.sunyard.myproject.mapper.SysUserMapper;
import com.sunyard.myproject.service.SysUserService;
import com.sunyard.myproject.vo.SysUserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    private ObjectMapper objectMapper=new ObjectMapper();

    @Value ("${User_Hkey:user_hkey}")
    private String user_hkey;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private JedisClient jedisClient;
    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public SysUserVo findById(Integer id) {
        return null;
    }

    @Override
    public SysUser findByUsername(String username) {
        String result=jedisClient.hget(user_hkey, username);
        if(StringUtils.isNotBlank(result)){
            SysUser user= null;
            try {
                user = objectMapper.readValue(result,SysUser.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return user;
        }
        SysUser sysUser=sysUserMapper.findByUsername(username);

        try {
            jedisClient.hset(user_hkey,username, objectMapper.writeValueAsString(sysUser));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return sysUser;
    }
}
