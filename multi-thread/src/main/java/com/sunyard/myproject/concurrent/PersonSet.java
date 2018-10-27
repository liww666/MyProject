package com.sunyard.myproject.concurrent;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过封闭机制来确保线程安全
 * Created by Administrator on 2018/8/7.
 */
public class PersonSet {
    private final Set<String> mySet=new HashSet<>();

    public synchronized void add(String str){
        mySet.add(str);
    }
    public synchronized boolean containStr(String str){
        return mySet.contains(str);
    }
}
