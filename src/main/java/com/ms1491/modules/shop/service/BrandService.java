package com.ms1491.modules.shop.service;

import com.ms1491.modules.shop.entity.BrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface BrandService {
	
	BrandEntity queryObject(Integer id);
	
	List<BrandEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BrandEntity brand);
	
	void update(BrandEntity brand);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
