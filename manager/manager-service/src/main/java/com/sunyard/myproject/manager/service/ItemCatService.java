package com.sunyard.myproject.manager.service;

import com.sunyard.myproject.manager.pojo.TbItemCat;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
public interface ItemCatService {
    public List<TbItemCat> getItemCatList(Long parentId) throws Exception;
}
