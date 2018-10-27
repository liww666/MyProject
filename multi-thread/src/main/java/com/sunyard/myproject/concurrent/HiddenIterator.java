package com.sunyard.myproject.concurrent;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 2018/8/9.
 */
public class HiddenIterator {
    private  final Set<Integer> set=new HashSet<>();
    public synchronized void add(Integer i){
        set.add(i);
    }
    public synchronized void remove(Integer i){
        set.remove(i);
    }
    public void addTenThings(){
        Random random=new Random();
        for(int i=0;i<10;i++){
            set.add(i);
        }
        //toString()会对set进行迭代，而HiddenIterator又不是线程安全的,
        // 所以可能会ConcurrentModificationException
        System.out.println("DEBUG:add ten elements to " + set);
    }
    public static void main(String[] args){
        final HiddenIterator hiddenIterator=new HiddenIterator();
        new Thread(){
            public void run(){
                while(true){
                    hiddenIterator.remove(0);
                }
            }
        }.start();
        while(true){
            hiddenIterator.addTenThings();
        }
    }
}
