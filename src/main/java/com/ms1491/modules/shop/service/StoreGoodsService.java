package com.ms1491.modules.shop.service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.entity.StoreGoodsEntity;

/**
 * 店铺-商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public interface StoreGoodsService {
	
	StoreGoodsEntity queryObject(Integer id);
	
	List<StoreGoodsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StoreGoodsEntity storeGoods);
	
	void update(StoreGoodsEntity storeGoods);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	StoreGoodsEntity queryObjectByStoreIdAndGoodsId(Map<String, Object> map);
	
}
