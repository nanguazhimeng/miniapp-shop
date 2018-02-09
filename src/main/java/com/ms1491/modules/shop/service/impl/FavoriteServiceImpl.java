package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.FavoriteDao;
import com.ms1491.modules.shop.entity.FavoriteEntity;
import com.ms1491.modules.shop.service.FavoriteService;



@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	private FavoriteDao favoriteDao;
	
	@Override
	public FavoriteEntity queryObject(Integer id){
		return favoriteDao.queryObject(id);
	}
	
	@Override
	public List<FavoriteEntity> queryList(Map<String, Object> map){
		return favoriteDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return favoriteDao.queryTotal(map);
	}
	
	@Override
	public void save(FavoriteEntity favorite){
		favoriteDao.save(favorite);
	}
	
	@Override
	public void update(FavoriteEntity favorite){
		favoriteDao.update(favorite);
	}
	
	@Override
	public void delete(Integer id){
		favoriteDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		favoriteDao.deleteBatch(ids);
	}
	
}
