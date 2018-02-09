package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.StoreDao;
import com.ms1491.modules.shop.entity.StoreEntity;
import com.ms1491.modules.shop.service.StoreService;



@Service("storeService")
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreDao storeDao;
	
	@Override
	public StoreEntity queryObject(String storeId){
		return storeDao.queryObject(storeId);
	}
	
	@Override
	public List<StoreEntity> queryList(Map<String, Object> map){
		return storeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return storeDao.queryTotal(map);
	}
	
	@Override
	public void save(StoreEntity store){
		storeDao.save(store);
	}
	
	@Override
	public void update(StoreEntity store){
		storeDao.update(store);
	}
	
	@Override
	public void delete(String storeId){
		storeDao.delete(storeId);
	}
	
	@Override
	public void deleteBatch(String[] storeIds){
		storeDao.deleteBatch(storeIds);
	}
	
}
