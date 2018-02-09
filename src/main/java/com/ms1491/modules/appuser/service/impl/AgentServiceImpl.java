package com.ms1491.modules.appuser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.appuser.dao.AgentDao;
import com.ms1491.modules.appuser.entity.AgentEntity;
import com.ms1491.modules.appuser.service.AgentService;



@Service("agentService")
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentDao agentDao;
	
	@Override
	public AgentEntity queryObject(Integer id){
		return agentDao.queryObject(id);
	}
	
	@Override
	public List<AgentEntity> queryList(Map<String, Object> map){
		return agentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return agentDao.queryTotal(map);
	}
	
	@Override
	public void save(AgentEntity agent){
		agentDao.save(agent);
	}
	
	@Override
	public void update(AgentEntity agent){
		agentDao.update(agent);
	}
	
	@Override
	public void delete(Integer id){
		agentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		agentDao.deleteBatch(ids);
	}

	@Override
	public AgentEntity queryByUid(Integer uid) {
		return agentDao.queryByUid(uid);
	}
	
}
