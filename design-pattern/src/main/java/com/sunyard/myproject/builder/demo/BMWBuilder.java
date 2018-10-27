package com.sunyard.myproject.builder.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/22.
 */
public class BMWBuilder {
    private List<String> seq=new ArrayList<String>();
    public BMWBuilder addStart(){
        this.seq.add("start");
        return this;
    }
    public BMWBuilder addRunning(){
        this.seq.add("running");
        return this;
    }
    public BMWBuilder addStop(){
        this.seq.add("stop");
        return this;
    }
    public CarModel build(){
        CarModel bmwCarModel=new BMWCarModel();
        bmwCarModel.setSeq(this.seq);
        return bmwCarModel;
    }
}
