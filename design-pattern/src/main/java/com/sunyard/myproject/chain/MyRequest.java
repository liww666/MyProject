package com.sunyard.myproject.chain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/24.
 */
public class MyRequest implements Request{
    private Map<String,Object> attrs=new HashMap<String, Object>();
    @Override
    public void addAttribute(String key, Object value) {
        attrs.put(key,value);
    }

    @Override
    public Map<String, Object> getAttrs() {
        return  this.attrs;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "attrs=" + attrs +
                '}';
    }
}
