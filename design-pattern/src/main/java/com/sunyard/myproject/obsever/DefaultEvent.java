package com.sunyard.myproject.obsever;

/**
 * Created by Administrator on 2018/9/13.
 */
public class DefaultEvent implements Event {

    private String name="默认事件";

    public DefaultEvent() {
    }

    public DefaultEvent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

}
