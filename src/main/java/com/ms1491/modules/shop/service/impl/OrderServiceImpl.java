package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.OrderDao;
import com.ms1491.modules.shop.entity.OrderEntity;
import com.ms1491.modules.shop.service.OrderService;



@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public OrderEntity queryObject(Integer id){
		return orderDao.queryObject(id);
	}
	
	@Override
	public List<OrderEntity> queryList(Map<String, Object> map){
		return orderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderEntity order){
		orderDao.save(order);
	}
	
	@Override
	public void update(OrderEntity order){
		orderDao.update(order);
	}
	
	@Override
	public void delete(Integer id){
		orderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderDao.deleteBatch(ids);
	}

	@Override
	public OrderEntity queryByOutTradeNo(String outTradeNo) {
		return orderDao.queryByOutTradeNo(outTradeNo);
	}
	
}
