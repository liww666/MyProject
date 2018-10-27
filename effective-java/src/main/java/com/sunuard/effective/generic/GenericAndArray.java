package com.sunuard.effective.generic;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13.
 */
public class GenericAndArray {
    /*
    数组是具体化的
    泛型是通过擦除的
     */
    public static void main(String[] args){
        //运行错误
        Object[] objs=new Long[10];
        objs[0]="iii";

        //编译错误
//        List<Object> ol=new ArrayList<Long>() ;
//        ol.add("iii");
    }
}
