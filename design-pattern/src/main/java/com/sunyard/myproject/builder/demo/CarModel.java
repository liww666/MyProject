package com.sunyard.myproject.builder.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/22.
 */
public abstract class CarModel {
    protected abstract void start();
    protected abstract void running();
    protected abstract void stop();
    private List<String> seq=new ArrayList<String>();
    public final void run(){
        for(String str:this.seq){
            if("start".equalsIgnoreCase(str)){
                start();
            }
            if("running".equalsIgnoreCase(str)){
                running();
            }
            if("stop".equalsIgnoreCase(str)){
                stop();
            }
        }
    }
    public void setSeq(List<String> seq){
        this.seq=seq;
    }
    protected String getName(){
        return this.getClass().getName();
    }
}
