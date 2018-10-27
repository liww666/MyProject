package com.sunyard.myproject.reference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2018/9/26.
 */
public class WeakReferenceStack<E> {
    private  List<WeakReference<E>> stackReferences;
    private int stackPointer=0;
    public WeakReferenceStack(){
        this.stackReferences=new ArrayList<>();
    }
    public void push(E e){
        this.stackReferences.add(stackPointer,new WeakReference<E>(e));
        stackPointer++;
    }
    public E pop(){
        E e=this.stackReferences.get(--stackPointer).get();
        return e;
    }
    public E peek(){
        return this.stackReferences.get(stackPointer-1).get();
    }
}
