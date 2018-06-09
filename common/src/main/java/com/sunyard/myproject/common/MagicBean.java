package com.sunyard.myproject.common;

/**
 * Created by Administrator on 2018/4/18.
 */
public class MagicBean {
    private String magic;

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public MagicBean(){
        System.out.println("MagicBean is constrcuting...");
    }
}
