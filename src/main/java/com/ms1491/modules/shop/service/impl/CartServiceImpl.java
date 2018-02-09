package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.CartDao;
import com.ms1491.modules.shop.entity.CartEntity;
import com.ms1491.modules.shop.service.CartService;



@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	
	@Override
	public CartEntity queryObject(Integer id){
		return cartDao.queryObject(id);
	}
	
	@Override
	public List<CartEntity> queryList(Map<String, Object> map){
		return cartDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return cartDao.queryTotal(map);
	}
	
	@Override
	public void save(CartEntity cart){
		cartDao.save(cart);
	}
	
	@Override
	public void update(CartEntity cart){
		cartDao.update(cart);
	}
	
	@Override
	public void delete(Integer id){
		cartDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		cartDao.deleteBatch(ids);
	}
	
}