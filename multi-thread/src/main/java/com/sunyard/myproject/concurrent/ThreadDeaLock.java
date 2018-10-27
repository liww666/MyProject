package com.sunyard.myproject.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池，如果所有正在运行的线程等待其他处于就绪队列线程的运行结果，就会产生死锁
 * Created by Administrator on 2018/8/14.
 */
public class ThreadDeaLock {
    public static void main(String[] args){
        final Lock lock=new ReentrantLock();
        final Condition condition=lock.newCondition();
        ExecutorService service= Executors.newFixedThreadPool(1);
        service.execute(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    condition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
    }
}
