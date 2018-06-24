package com.sunyard.myproject.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/23.
 */
public class SysAuth implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
