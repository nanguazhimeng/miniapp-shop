package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.OrderRefundEntity;

import java.util.List;
import java.util.Map;

/**
 * 退款订单
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface OrderRefundService {
	
	OrderRefundEntity queryObject(Integer id);
	
	List<OrderRefundEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderRefundEntity orderRefund);
	
	void update(OrderRefundEntity orderRefund);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
