package com.sunuard.effective.common;

import java.util.Iterator;

/**
 * forEach遍历的对象要实现Iterable接口，数组除外
 * Created by Administrator on 2018/9/16.
 */
public class ForEachTest {
    public static void main(String[] args){
        String[] strs={"a","b","c","d"};
        Integer[] ints={1,2,3,4};
        MyList<String> list=new MyList<String>(strs);
        MyList<Integer> intList=new MyList<Integer>(ints);
        for(String str:list){
            System.out.println(str);
        }
        System.out.println("- --- ------  ------- ---- -- ---");
        for(String str:strs){
            System.out.println(str);
        }
        System.out.println("--- -------- ----- --- --- ----");
        for(Integer num:intList){
            System.out.println(num);
        }
        System.out.println("- -- ----- ----- ---- -- -- --- -");
        for(Integer num:ints){
            System.out.println(num);
        }
    }
    /*
    Iterable 泛型必须要加，否则遍历时返回的是Object
     */
    private static  class MyList<T> implements Iterable<T>{
        private T[] objs;

        public MyList(T[] objs) {
            this.objs = objs;
        }

        @Override
        public Iterator<T> iterator() {
            return new MyIterator();
        }
        private  class MyIterator implements Iterator<T>{
            private int index;

            @Override
            public boolean hasNext() {
                return index<objs.length;
            }

            @Override
            public T next() {
                return objs[index++];
            }
        }
    }
}
