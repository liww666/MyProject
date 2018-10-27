package com.sunyard.myproject.obsever;

/**
 * Created by Administrator on 2018/9/13.
 */
public interface Publisher {
    void publish(Event e);
    void addListener(Listener listener);
}
