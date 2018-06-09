package com.sunyard.myproject.manager.service;

import com.sunyard.myproject.entity.EUTreeNode;
import com.sunyard.myproject.entity.TaotaoResult;

import java.util.List;



public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
