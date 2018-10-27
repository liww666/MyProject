package com.sunyard.myproject.template;

import com.sunyard.myproject.template.AbstractClass;
import com.sunyard.myproject.template.ConcreteClass1;
import com.sunyard.myproject.template.ConcreteClass2;

/**
 * Created by Administrator on 2018/9/22.
 */
public class Client {
    public static void main(String[] args){
        AbstractClass obj1=new ConcreteClass1();
        obj1.run();
        AbstractClass obj=new ConcreteClass2();
        obj.run();
    }
}
