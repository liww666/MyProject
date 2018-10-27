package com.sunyard.myproject.factory;

/**
 * Created by Administrator on 2018/9/21.
 */
public class FactoryA extends AbstractFactory {
    @Override
    Product create()  {
        return new ProductA();
    }
}
