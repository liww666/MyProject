package com.sunyard.myproject.service;

import com.sunyard.myproject.core.BaseService;
import com.sunyard.myproject.entity.SysUser;
import com.sunyard.myproject.vo.SysUserVo;

/**
 * Created by Administrator on 2018/6/20.
 */
public interface SysUserService extends BaseService<SysUser,SysUserVo,Integer> {
    SysUser findByUsername(String username);
}
