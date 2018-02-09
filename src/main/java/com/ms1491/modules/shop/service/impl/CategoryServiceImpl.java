package com.ms1491.modules.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.shop.dao.CategoryDao;
import com.ms1491.modules.shop.entity.CategoryEntity;
import com.ms1491.modules.shop.service.CategoryService;



@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public CategoryEntity queryObject(Integer id){
		return categoryDao.queryObject(id);
	}
	
	@Override
	public List<CategoryEntity> queryList(Map<String, Object> map){
		return categoryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return categoryDao.queryTotal(map);
	}
	
	@Override
	public void save(CategoryEntity category){
		categoryDao.save(category);
	}
	
	@Override
	public void update(CategoryEntity category){
		categoryDao.update(category);
	}
	
	@Override
	public void delete(Integer id){
		categoryDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		categoryDao.deleteBatch(ids);
	}

	@Override
	public List<CategoryEntity> queryListParentId(Integer pid) {
		return categoryDao.queryListParentId(pid);
	}
	
}
