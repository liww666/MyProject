package com.sunyard.myproject.chain;

/**
 * Created by Administrator on 2018/9/24.
 */
public class ConcreteHandler2 implements Handler {
    @Override
    public void doHandle(Request req,Response res,HandlerChain chain) {
        System.out.println(" ConcreteHandler2 get request:"+req);
        System.out.println("do handler2...");
        req.addAttribute("handler2", "ConcreteHandler2");
        chain.doHandle(req, res);
        System.out.println(" ConcreteHandler2 get response:" + res);
    }
}
