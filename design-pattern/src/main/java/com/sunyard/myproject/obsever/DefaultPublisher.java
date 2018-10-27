package com.sunyard.myproject.obsever;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13.
 */
public class DefaultPublisher implements Publisher {
    private List<Listener> listeners=new ArrayList<Listener>();
    @Override
    public void publish(Event e) {
        for(Listener listener:listeners){
            listener.onEvent(e);
        }

    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
}
