package com.sunyard.myproject.chain;

import java.util.Map;

/**
 * Created by Administrator on 2018/9/24.
 */
public interface Request {
    void addAttribute(String key,Object value);
    Map<String,Object> getAttrs();
}
