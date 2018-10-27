package com.sunyard.myproject.command;

/**
 * Created by Administrator on 2018/9/23.
 */
public abstract class Group {
    public abstract void find();
    public abstract void add();
    public abstract void delete();
    public abstract void change();
    public abstract void plan();
    protected String getName(){
        return this.getClass().getName();
    }
}
