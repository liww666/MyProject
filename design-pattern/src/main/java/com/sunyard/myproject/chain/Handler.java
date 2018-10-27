package com.sunyard.myproject.chain;

/**
 * Created by Administrator on 2018/9/24.
 */
public interface Handler {
    void doHandle(Request req,Response res,HandlerChain chain);
}
