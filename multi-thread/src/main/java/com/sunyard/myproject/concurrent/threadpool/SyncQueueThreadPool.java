package com.sunyard.myproject.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/10/27.
 */
public class SyncQueueThreadPool {
    public static void main(String[] args) {
        ExecutorService executor=new ThreadPoolExecutor(1,1,3, TimeUnit.MINUTES,new SynchronousQueue<Runnable>());
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("task1 is running...");
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task2 is running...");
            }
        });
    }
}
