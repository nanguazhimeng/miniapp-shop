package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.GoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface GoodsService {
	
	GoodsEntity queryObject(Integer id);
	
	List<GoodsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsEntity goods);
	
	void update(GoodsEntity goods);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
