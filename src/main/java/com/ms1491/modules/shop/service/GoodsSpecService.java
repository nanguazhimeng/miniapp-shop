package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.GoodsSpecEntity;

import java.util.List;
import java.util.Map;

/**
 * 规格管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface GoodsSpecService {
	
	GoodsSpecEntity queryObject(Integer id);
	
	List<GoodsSpecEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsSpecEntity goodsSpec);
	
	void update(GoodsSpecEntity goodsSpec);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
