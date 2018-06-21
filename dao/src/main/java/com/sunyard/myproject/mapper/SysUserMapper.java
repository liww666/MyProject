package com.sunyard.myproject.mapper;

import com.sunyard.myproject.core.BaseDao;
import com.sunyard.myproject.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2018/6/19.
 */
@Mapper
public interface SysUserMapper extends BaseDao<SysUser,Integer> {
    SysUser findByUsername(String username);
}
