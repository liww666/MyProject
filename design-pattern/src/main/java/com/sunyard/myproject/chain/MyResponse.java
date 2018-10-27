package com.sunyard.myproject.chain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/24.
 */
public class MyResponse implements Response {
    private Map<String,Object> attrs=new HashMap<String, Object>();
    @Override
    public void addAttribute(String key, Object value) {
        this.attrs.put(key,value);
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "attrs=" + attrs +
                '}';
    }
}
