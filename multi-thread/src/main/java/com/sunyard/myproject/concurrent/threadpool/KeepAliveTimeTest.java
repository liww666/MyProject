package com.sunyard.myproject.concurrent.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池keepAliveTime测试
 * Created by Administrator on 2018/10/27.
 */
public class KeepAliveTimeTest {
    public static void main(String[] args) {
        ExecutorService executor=null;
        try {
           executor= new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1));
            Runnable task1 = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("task1 is running...");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            };
            Runnable task2 = new Runnable() {
                @Override
                public void run() {
//                    while (true) {
                        System.out.println("task2 is running...");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
//                    }
                }
            };
            Runnable task3 = new Runnable() {
                @Override
                public void run() {
//                    while (true) {
                    System.out.println("task3 is running...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
//                    }
                }
            };

            executor.execute(task1);
            executor.execute(task2);
            executor.execute(task3);

        }finally {
            executor.shutdown();
        }

    }
}
