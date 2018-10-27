package com.sunyard.myproject.jvm_lock;

import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2018/7/25.
 * 偏向锁实验
 * 偏向锁核心思想：如果程序没有竞争，则取消之前已经取得锁的线程同步操作
 * 通过设置虚拟机参数-XX:BiasedLockingStartupDelay=0，让虚拟机启动立即启用偏向锁，否则默认虚拟机启动后4秒启用
 */
public class BiasedLock {
    private static List<Integer> numList=new Vector<>();
    public static void main(String[] args){
        long begin=System.currentTimeMillis();
        int count=0;
        int startNum=0;
        while(count<10000000){
            numList.add(startNum);
            count++;
            startNum+=2;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }
}
