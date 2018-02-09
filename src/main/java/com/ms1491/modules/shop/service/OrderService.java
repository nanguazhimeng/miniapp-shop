package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface OrderService {
	
	OrderEntity queryObject(Integer id);
	
	List<OrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderEntity order);
	
	void update(OrderEntity order);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	OrderEntity queryByOutTradeNo(String outTradeNo);
}
