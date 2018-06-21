package com.sunyard.myproject.service.impl;

import com.sunyard.myproject.entity.SysUser;
import com.sunyard.myproject.entity.Topic;
import com.sunyard.myproject.mapper.SysUserMapper;
import com.sunyard.myproject.service.SysUserService;
import com.sunyard.myproject.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
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
        return sysUserMapper.findByUsername(username);
    }
}
