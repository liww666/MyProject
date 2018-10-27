package com.sunyard.myproject.command;

/**
 * Created by Administrator on 2018/9/23.
 */
public class PageGroup extends Group {
    @Override
    public void find() {
        System.out.println(this.getName()+" find...");
    }

    @Override
    public void add() {
        System.out.println(this.getName()+" add...");
    }

    @Override
    public void delete() {
        System.out.println(this.getName()+" delete...");
    }

    @Override
    public void change() {
        System.out.println(this.getName()+" change...");
    }

    @Override
    public void plan() {
        System.out.println(this.getName()+" plan...");
    }
}
