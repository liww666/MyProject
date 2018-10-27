package com.sunyard.myproject.obsever;

/**
 * Created by Administrator on 2018/9/13.
 */
public class InitEvent implements Event {
    private String name="初始化事件";
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
}
