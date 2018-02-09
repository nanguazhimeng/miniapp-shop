package com.ms1491.modules.shop.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.shop.entity.StoreGoodsEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 店铺-商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
 @Mapper
public interface StoreGoodsDao extends BaseDao<StoreGoodsEntity> {
	 
	 StoreGoodsEntity queryObjectByStoreIdAndGoodsId(Map<String, Object> map);
	 
}
