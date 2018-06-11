package com.sunyard.myproject.core;

import com.sunyard.myproject.entity.Topic;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
public interface BaseService<T,V,D extends Serializable> {
    List<Topic> findAll();
    V findById(D id);
}
