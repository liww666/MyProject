package com.sunyard.myproject.template;

/**
 * Created by Administrator on 2018/9/22.
 */
public abstract class AbstractClass {
    protected abstract void doSomething();
    protected abstract void doAnything();
    public final void run(){
        doSomething();
        doAnything();
    }
}
