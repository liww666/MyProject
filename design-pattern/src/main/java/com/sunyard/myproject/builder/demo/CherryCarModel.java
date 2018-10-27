package com.sunyard.myproject.builder.demo;

/**
 * Created by Administrator on 2018/9/22.
 */
public class CherryCarModel extends CarModel {
    @Override
    protected void start() {
        System.out.println(this.getName()+" start...");
    }

    @Override
    protected void running() {
        System.out.println(this.getName()+" running...");
    }

    @Override
    protected void stop() {
        System.out.println(this.getName()+" stop...");
    }
}
