package com.ms1491.modules.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1491.modules.shop.dao.StoreGoodsDao;
import com.ms1491.modules.shop.entity.StoreGoodsEntity;
import com.ms1491.modules.shop.service.StoreGoodsService;



@Service("storeGoodsService")
public class StoreGoodsServiceImpl implements StoreGoodsService {
	@Autowired
	private StoreGoodsDao storeGoodsDao;
	
	@Override
	public StoreGoodsEntity queryObject(Integer id){
		return storeGoodsDao.queryObject(id);
	}
	
	@Override
	public List<StoreGoodsEntity> queryList(Map<String, Object> map){
		return storeGoodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return storeGoodsDao.queryTotal(map);
	}
	
	@Override
	public void save(StoreGoodsEntity storeGoods){
		storeGoodsDao.save(storeGoods);
	}
	
	@Override
	public void update(StoreGoodsEntity storeGoods){
		storeGoodsDao.update(storeGoods);
	}
	
	@Override
	public void delete(Integer id){
		storeGoodsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		storeGoodsDao.deleteBatch(ids);
	}

	@Override
	public StoreGoodsEntity queryObjectByStoreIdAndGoodsId(
			Map<String, Object> map) {
		return storeGoodsDao.queryObjectByStoreIdAndGoodsId(map);
	}
	
}
