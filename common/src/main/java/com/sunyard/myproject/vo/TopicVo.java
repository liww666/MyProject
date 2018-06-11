package com.sunyard.myproject.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/9.
 */
public class TopicVo implements Serializable {
    private String id ;
    private String  name;
    private String  teacher;
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
