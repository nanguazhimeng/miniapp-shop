package com.ms1491.modules.appuser.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.appuser.entity.AgentEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 代理管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:08
 */
 @Mapper
public interface AgentDao extends BaseDao<AgentEntity> {
	 AgentEntity queryByUid(Integer uid);
}
