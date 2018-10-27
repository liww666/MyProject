package com.sunyard.myproject.singleton;

/**
 * Created by Administrator on 2018/9/22.
 */
public class PrimarySingleton implements Singleton{
    private PrimarySingleton(){}
    public static PrimarySingleton getInstance(){
        if(instance==null){
            Thread.yield();
            instance=new PrimarySingleton();
        }
        return instance;
    }
    private static PrimarySingleton instance;
}
