package com.ms1491.modules.shop.service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.entity.CategoryEntity;

/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public interface CategoryService {
	
	CategoryEntity queryObject(Integer id);
	
	List<CategoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CategoryEntity category);
	
	void update(CategoryEntity category);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	List<CategoryEntity> queryListParentId(Integer pid);
}
