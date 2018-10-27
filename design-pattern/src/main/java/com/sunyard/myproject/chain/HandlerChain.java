package com.sunyard.myproject.chain;

/**
 * Created by Administrator on 2018/9/24.
 */
public interface HandlerChain {
    void doHandle(Request req,Response res);
    void addHandler(Handler handler);
    void setServlet(Servlet servlet);
}
