package com.ms1491.modules.shop.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.shop.entity.OrderGoodsEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 订单商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
 @Mapper
public interface OrderGoodsDao extends BaseDao<OrderGoodsEntity> {
	
}
