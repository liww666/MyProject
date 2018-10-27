package com.sunyard.myproject.chain;

import java.util.Map;

/**
 * Created by Administrator on 2018/9/24.
 */
public class DefaultServlet implements Servlet {
    @Override
    public void service(Request req, Response res) {
        System.out.println(" defaultServlet do service(request:"+req+",response:"+res+")...");
        for(Map.Entry<String,Object> entry:req.getAttrs().entrySet()){
            res.addAttribute(entry.getKey(),entry.getValue());
        }
    }
}
