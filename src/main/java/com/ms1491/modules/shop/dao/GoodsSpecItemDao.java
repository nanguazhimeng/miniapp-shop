package com.ms1491.modules.shop.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.shop.entity.GoodsSpecItemEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 规则项管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
 @Mapper
public interface GoodsSpecItemDao extends BaseDao<GoodsSpecItemEntity> {
	
}
