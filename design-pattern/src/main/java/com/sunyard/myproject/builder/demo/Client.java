package com.sunyard.myproject.builder.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/22.
 */
public class Client {
    public static void main(String[] args){
        /*

         没有使用Builder时写法
        List<String> bmwSeq=new ArrayList<String>();
        bmwSeq.add("start");
        bmwSeq.add("running");
        bmwSeq.add("stop");
        CarModel bmwCar=new BMWCarModel();
        bmwCar.setSeq(bmwSeq);
        bmwCar.run();
        */
        BMWBuilder bmwBuilder=new BMWBuilder();
        bmwBuilder.addRunning().addStop().addStart();
        CarModel bmwCar=bmwBuilder.build();
        bmwCar.run();

    }
}
