package com.sunyard.myproject.chain;

/**
 * Created by Administrator on 2018/9/24.
 */
public class ConcreteHandler1 implements Handler {
    @Override
    public void doHandle(Request req,Response res,HandlerChain chain) {
        System.out.println(" ConcreteHandler1 get request:"+req);
        System.out.println("do handler1...");
        req.addAttribute("handler1", "ConcreteHandler1");
        chain.doHandle(req, res);
        System.out.println(" ConcreteHandler1 get response:"+res);
    }
}
