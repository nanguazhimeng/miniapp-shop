package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.GoodsDao;
import com.ms1491.modules.shop.entity.GoodsEntity;
import com.ms1491.modules.shop.service.GoodsService;



@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public GoodsEntity queryObject(Integer id){
		return goodsDao.queryObject(id);
	}
	
	@Override
	public List<GoodsEntity> queryList(Map<String, Object> map){
		return goodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodsEntity goods){
		goodsDao.save(goods);
	}
	
	@Override
	public void update(GoodsEntity goods){
		goodsDao.update(goods);
	}
	
	@Override
	public void delete(Integer id){
		goodsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		goodsDao.deleteBatch(ids);
	}
	
}
