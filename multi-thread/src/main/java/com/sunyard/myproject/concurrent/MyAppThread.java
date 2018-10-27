package com.sunyard.myproject.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/8/14.
 */
public class MyAppThread extends Thread {
   public  static final String DEFAULT_NAME="MyAppThread";
    private static final AtomicInteger created=new AtomicInteger();
    private static final AtomicInteger alive=new AtomicInteger();
    private static final Logger log=Logger.getAnonymousLogger();

    public MyAppThread(Runnable r,String poolName) {
        super(r,poolName+"-"+created.incrementAndGet());
        log.log(Level.FINE,"created num:"+created.get());
        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.log(Level.SEVERE,"Uncaught in "+t.getName(),e);
            }
        });
    }

    public void run(){
        log.log(Level.FINE,"Created "+getName());
        try{
            log.log(Level.FINE,"alive num:"+alive.get());
            alive.incrementAndGet();
            super.run();
        }finally {
            alive.decrementAndGet();
            log.log(Level.FINE,getName()+" exited");
        }

    }

    public static AtomicInteger getCreated() {
        return created;
    }

    public static AtomicInteger getAlive() {
        return alive;
    }
}
