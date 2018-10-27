package com.sunyard.myproject.command;

/**
 * Created by Administrator on 2018/9/23.
 */
public class Client {
    public static void main(String[] args){
        Invoker invoker=new Invoker();
        Command command=new DeletePageCommand();
        invoker.setCommand(command);
        invoker.action();

        invoker.setCommand(new ChangeCodeCommand());
        invoker.action();
    }
}
