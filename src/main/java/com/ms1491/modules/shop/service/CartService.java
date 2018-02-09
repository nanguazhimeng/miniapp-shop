package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.CartEntity;

import java.util.List;
import java.util.Map;

/**
 * 购物车
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface CartService {
	
	CartEntity queryObject(Integer id);
	
	List<CartEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CartEntity cart);
	
	void update(CartEntity cart);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
