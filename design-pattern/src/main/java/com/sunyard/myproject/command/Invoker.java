package com.sunyard.myproject.command;

/**
 * Created by Administrator on 2018/9/23.
 */
public class Invoker {
    private Command command;
    public void setCommand(Command command){
        this.command=command;
    }
    public void action(){
        this.command.execute();
    }
}
