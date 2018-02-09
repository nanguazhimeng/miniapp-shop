package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.FavoriteEntity;

import java.util.List;
import java.util.Map;

/**
 * 收藏管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface FavoriteService {
	
	FavoriteEntity queryObject(Integer id);
	
	List<FavoriteEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FavoriteEntity favorite);
	
	void update(FavoriteEntity favorite);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
