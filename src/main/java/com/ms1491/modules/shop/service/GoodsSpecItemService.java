package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.GoodsSpecItemEntity;

import java.util.List;
import java.util.Map;

/**
 * 规则项管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface GoodsSpecItemService {
	
	GoodsSpecItemEntity queryObject(Integer id);
	
	List<GoodsSpecItemEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsSpecItemEntity goodsSpecItem);
	
	void update(GoodsSpecItemEntity goodsSpecItem);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
