package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.BrandDao;
import com.ms1491.modules.shop.entity.BrandEntity;
import com.ms1491.modules.shop.service.BrandService;



@Service("brandService")
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;
	
	@Override
	public BrandEntity queryObject(Integer id){
		return brandDao.queryObject(id);
	}
	
	@Override
	public List<BrandEntity> queryList(Map<String, Object> map){
		return brandDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return brandDao.queryTotal(map);
	}
	
	@Override
	public void save(BrandEntity brand){
		brandDao.save(brand);
	}
	
	@Override
	public void update(BrandEntity brand){
		brandDao.update(brand);
	}
	
	@Override
	public void delete(Integer id){
		brandDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		brandDao.deleteBatch(ids);
	}
	
}
