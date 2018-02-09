package com.ms1491.modules.appuser.service;

import com.ms1491.modules.appuser.entity.AgentEntity;

import java.util.List;
import java.util.Map;

/**
 * 代理管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:08
 */
public interface AgentService {
	
	AgentEntity queryObject(Integer id);
	
	List<AgentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AgentEntity agent);
	
	void update(AgentEntity agent);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	AgentEntity queryByUid(Integer uid);
	
}
