package com.sunyard.myproject.mapper;

import com.sunyard.myproject.core.BaseDao;
import com.sunyard.myproject.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
@Mapper
public interface TopicMapper extends BaseDao<Topic,String>{

}
