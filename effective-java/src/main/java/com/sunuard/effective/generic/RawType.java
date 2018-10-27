package com.sunuard.effective.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13.
 */
public class RawType {
    public static void main(String[] args){
        List<String> list=new ArrayList<String>();
        doSome3(list,2);
    }
    /*
    不能将List<String> 当做List<Object>使用
     */
    static void doSome1(List<Object> list,Object o){
        list.add(o);
    }
    /*
    不能将null以外的任何元素放入到List<?>中
     */
    static void doSome2(List<?> list,Object o){
        list.add(null);
    }
    static void doSome3(List<? extends Object> list,Object o){
        list.add(null);
    }
    /*
    @SuppressWarnings("unchecked")用来禁止当前方法编译警告，
    通常声明在变量、方法 上，永远不要在整个类上使用此注解！
    加这个注解前提是确保代码是类型安全的，否则应该消除警告
     */
    @SuppressWarnings("unchecked")
    static void unCkeck(){
        List<Integer> list=new ArrayList();
        list.add(2);
        Integer str=list.get(0);
    }
}
