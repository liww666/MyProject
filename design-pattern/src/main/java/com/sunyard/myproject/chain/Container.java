package com.sunyard.myproject.chain;

/**
 * Created by Administrator on 2018/9/24.
 */
public class Container {
    private HandlerChain chain;


    public Container(HandlerChain chain) {
        this.chain = chain;

    }
    public void init(){
        System.out.println(" init container...");
        chain.setServlet(new DefaultServlet());
        chain.addHandler(new ConcreteHandler1());
        chain.addHandler(new ConcreteHandler2());
    }
    public void service(Request request,Response response){
        chain.doHandle(request,response);
    }
}
