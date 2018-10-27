package com.sunyard.myproject.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/9/23.
 */
public class Client {
    public static void main(String[] args){
        UserInterface target=new UserInterfaceImpl();
        UserInterface proxy=(UserInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), new MyInvocationHandler(target));
        proxy.add();
    }
}
