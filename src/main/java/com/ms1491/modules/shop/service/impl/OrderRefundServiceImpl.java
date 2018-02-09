package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.OrderRefundDao;
import com.ms1491.modules.shop.entity.OrderRefundEntity;
import com.ms1491.modules.shop.service.OrderRefundService;



@Service("orderRefundService")
public class OrderRefundServiceImpl implements OrderRefundService {
	@Autowired
	private OrderRefundDao orderRefundDao;
	
	@Override
	public OrderRefundEntity queryObject(Integer id){
		return orderRefundDao.queryObject(id);
	}
	
	@Override
	public List<OrderRefundEntity> queryList(Map<String, Object> map){
		return orderRefundDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderRefundDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderRefundEntity orderRefund){
		orderRefundDao.save(orderRefund);
	}
	
	@Override
	public void update(OrderRefundEntity orderRefund){
		orderRefundDao.update(orderRefund);
	}
	
	@Override
	public void delete(Integer id){
		orderRefundDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderRefundDao.deleteBatch(ids);
	}
	
}
