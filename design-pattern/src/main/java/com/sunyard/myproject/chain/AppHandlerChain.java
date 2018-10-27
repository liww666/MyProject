package com.sunyard.myproject.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/24.
 */
public class AppHandlerChain implements HandlerChain {
    private List<Handler> handlers=new ArrayList<Handler>();
    private Servlet servlet;
    private int currentPos=0;
    @Override
    public void doHandle(Request req,Response res) {
        if(handlers.size()>0&&currentPos<handlers.size()){
            System.out.println(" do handler in AppHandlerChain at pos :"+currentPos);
            handlers.get(currentPos++).doHandle(req,res,this);
        }else if(handlers.size()<=0){
            System.out.println(" no handler in AppHandlerChain");
        }else{
            System.out.println("at the end of AppHandlerChain ");
            servlet.service(req,res);
        }
    }
    public void addHandler(Handler handler){
        this.handlers.add(handler);
    }

    @Override
    public void setServlet(Servlet servlet) {
        this.servlet=servlet;
    }
}
