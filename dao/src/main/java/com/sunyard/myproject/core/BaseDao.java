package com.sunyard.myproject.core;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */
public interface BaseDao<T,D extends Serializable> {
    void insert(T t);
    int deleteById(D id);
    int delete(T t);
    void update(T t);
    T findById(D id);
    List<T> findAll();
}
