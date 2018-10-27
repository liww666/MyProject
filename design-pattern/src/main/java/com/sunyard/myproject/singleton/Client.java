package com.sunyard.myproject.singleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/9/22.
 */
public class Client {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSome();
//        singleton.doSome();
//        singletonWithMultiThread(PrimarySingleton.class);
        EnumSingleton obj=(EnumSingleton)EnumSingleton.getInstance();
        obj.doSome();
    }

    public static void singletonWithSingleThread() {

    }

    public static void singletonWithMultiThread(final Class clazz) {
        ThreadPoolExecutor executor = null;
        try {
            BlockingQueue workQueue=new LinkedBlockingDeque(5);
            executor = new ThreadPoolExecutor(3, 5, 5, TimeUnit.MINUTES, workQueue);
            System.out.println(executor.getActiveCount());
            final CountDownLatch latch = new CountDownLatch(1);
            /*
            当提交的任务数大于maxPoolSize+workQueue.size()时，会激活线程池的饱和策略
            默认情况下回抛出RejectedExecutionException
             */
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"| workQueue.size="+workQueue.size());
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            latch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Singleton singleton =Client.getInstanceByClass(clazz) ;
                        System.out.println(Thread.currentThread().getName() + "|"+singleton);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            System.out.println(Thread.currentThread().getName() + " | go !!!");
            latch.countDown();
        } finally {
            executor.shutdown();
        }
    }

    public static Singleton getInstanceByClass(Class clazz){
        Singleton singleton=null;
        Method[] methods=clazz.getDeclaredMethods();
        for(Method method:methods){
            System.out.println(Thread.currentThread().getName()+"|"+clazz.getName() + " method name:" + method.getName());
            if("getInstance".equals(method.getName())){
                try {
                    singleton=(Singleton)method.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return singleton;
    }

}
