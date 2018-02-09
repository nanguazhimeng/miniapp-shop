package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.GoodsSpecDao;
import com.ms1491.modules.shop.entity.GoodsSpecEntity;
import com.ms1491.modules.shop.service.GoodsSpecService;



@Service("goodsSpecService")
public class GoodsSpecServiceImpl implements GoodsSpecService {
	@Autowired
	private GoodsSpecDao goodsSpecDao;
	
	@Override
	public GoodsSpecEntity queryObject(Integer id){
		return goodsSpecDao.queryObject(id);
	}
	
	@Override
	public List<GoodsSpecEntity> queryList(Map<String, Object> map){
		return goodsSpecDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsSpecDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodsSpecEntity goodsSpec){
		goodsSpecDao.save(goodsSpec);
	}
	
	@Override
	public void update(GoodsSpecEntity goodsSpec){
		goodsSpecDao.update(goodsSpec);
	}
	
	@Override
	public void delete(Integer id){
		goodsSpecDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		goodsSpecDao.deleteBatch(ids);
	}
	
}
