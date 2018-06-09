package com.sunyard.builder;

/**
 * Created by Administrator on 2018/5/20.
 */
public class ConcreteBuilder extends Builder {
    private Product pro=new Product();
    @Override
    public void setPart() {

    }

    @Override
    public Product buildProduct() {
        return pro;
    }
}
