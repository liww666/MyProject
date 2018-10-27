package com.sunyard.myproject.obsever;

/**
 * Created by Administrator on 2018/9/13.
 */
public class DefaultListener implements Listener {
    @Override
    public void onEvent(Event e) {
        System.out.println(e.getName()+"发生了");
    }
}
