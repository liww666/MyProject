package com.sunyard.myproject.builder;

/**
 * Created by Administrator on 2018/5/20.
 */
public class Director {
    private Builder builder=new ConcreteBuilder();
    public Product getProduct(){
        builder.setPart();
        return builder.buildProduct();
    }
    public static void main(String[] args){
        new Director().getProduct();
    }
}
