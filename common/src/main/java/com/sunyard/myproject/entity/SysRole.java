package com.sunyard.myproject.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/6/19.
 */
public class SysRole implements Serializable {
    private Integer id;
    private String name;
    private List<SysAuth> auths;

    public List<SysAuth> getAuths() {
        return auths;
    }

    public void setAuths(List<SysAuth> auths) {
        this.auths = auths;
    }

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
