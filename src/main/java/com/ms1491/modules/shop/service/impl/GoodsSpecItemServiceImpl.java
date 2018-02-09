package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.GoodsSpecItemDao;
import com.ms1491.modules.shop.entity.GoodsSpecItemEntity;
import com.ms1491.modules.shop.service.GoodsSpecItemService;



@Service("goodsSpecItemService")
public class GoodsSpecItemServiceImpl implements GoodsSpecItemService {
	@Autowired
	private GoodsSpecItemDao goodsSpecItemDao;
	
	@Override
	public GoodsSpecItemEntity queryObject(Integer id){
		return goodsSpecItemDao.queryObject(id);
	}
	
	@Override
	public List<GoodsSpecItemEntity> queryList(Map<String, Object> map){
		return goodsSpecItemDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsSpecItemDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodsSpecItemEntity goodsSpecItem){
		goodsSpecItemDao.save(goodsSpecItem);
	}
	
	@Override
	public void update(GoodsSpecItemEntity goodsSpecItem){
		goodsSpecItemDao.update(goodsSpecItem);
	}
	
	@Override
	public void delete(Integer id){
		goodsSpecItemDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		goodsSpecItemDao.deleteBatch(ids);
	}
	
}
