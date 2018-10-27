package com.sunyard.myproject.singleton;

/**
 * 枚举单例，因为枚举对象是不可变的，所以是线程安全的
 * Created by Administrator on 2018/9/22.
 */
public enum EnumSingleton implements Singleton {
    INSTANCE {
        /*
        每个枚举对象都可以重写外部类的方法
         */
        @Override
        public void doSome() {
            System.out.println("INSTANCE doSome...");
        }
    };
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    static{
        System.out.println(Thread.currentThread().getName()+"| loading EnumSingleton...");
    }

    private EnumSingleton(){
        System.out.println(Thread.currentThread().getName()+"|new EnumSingleton...");
    }

    public  void doSome(){
        System.out.println("EnumSingleton doSome...");
    };

    public static Singleton getInstance(){
        return INSTANCE;
    }
}
