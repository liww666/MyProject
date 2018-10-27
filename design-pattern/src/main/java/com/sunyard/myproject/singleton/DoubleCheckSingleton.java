package com.sunyard.myproject.singleton;

/**
 * Created by Administrator on 2018/9/22.
 */
public class DoubleCheckSingleton implements Singleton {
    private DoubleCheckSingleton(){

    }
    private static volatile DoubleCheckSingleton instance;
    public static Singleton getInstance(){
        if(instance==null){
            Thread.yield();
            synchronized (DoubleCheckSingleton.class){
                /*
                这个if一定要加，否则当其他线程通过第一个if而instance还没创建好时，
                就会出现实例化多个instance；
                 */
                if(instance==null){
                    instance=new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
