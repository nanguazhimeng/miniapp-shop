package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.OrderGoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface OrderGoodsService {
	
	OrderGoodsEntity queryObject(Integer id);
	
	List<OrderGoodsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderGoodsEntity orderGoods);
	
	void update(OrderGoodsEntity orderGoods);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
