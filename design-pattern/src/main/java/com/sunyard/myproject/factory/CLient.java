package com.sunyard.myproject.factory;

/**
 * Created by Administrator on 2018/9/21.
 */
public class CLient {
    public static void main(String[] args){
        AbstractFactory factory=new FactoryA();
        Product product=factory.create();
        product.say();
    }
}
