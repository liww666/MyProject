package com.sunyard.myproject.chain;

/**
 * Created by Administrator on 2018/9/24.
 */
public class Client {
    public static void main(String[] args){
       Container container=new Container(new AppHandlerChain());
        container.init();
        container.service(new MyRequest(),new MyResponse());
    }
}
