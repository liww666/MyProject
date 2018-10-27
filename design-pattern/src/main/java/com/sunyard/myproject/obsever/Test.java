package com.sunyard.myproject.obsever;

/**
 * Created by Administrator on 2018/9/13.
 */
public class Test {
    public static void main(String[] args){
        Publisher publisher=new DefaultPublisher();
        publisher.addListener(new DefaultListener());
        publisher.publish(new DefaultEvent());
        publisher.publish(new InitEvent());
    }
}
