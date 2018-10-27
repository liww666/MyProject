package com.sunyard.myproject.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/9/23.
 */
public class MyInvocationHandler implements InvocationHandler {
    /*
    目标对象
     */
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /*
    执行目标对象方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------before-----");
        Object result=method.invoke(target,args);
        System.out.println("-------after-----");
        return result;
    }
}
