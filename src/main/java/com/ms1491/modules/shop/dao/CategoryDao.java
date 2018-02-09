package com.ms1491.modules.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.shop.entity.CategoryEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
 @Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
		/**
		 * 根据父菜单，查询子分类
		 * @param parentId 父分类ID
		 */
		List<CategoryEntity> queryListParentId(Integer pid);
}
