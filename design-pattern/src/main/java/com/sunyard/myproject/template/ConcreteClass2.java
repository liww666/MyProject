package com.sunyard.myproject.template;

/**
 * Created by Administrator on 2018/9/22.
 */
public class ConcreteClass2 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println(this.getClass().getName()+" doSomething...");
    }

    @Override
    protected void doAnything() {
        System.out.println(this.getClass().getName()+" doAnything...");
    }
}
