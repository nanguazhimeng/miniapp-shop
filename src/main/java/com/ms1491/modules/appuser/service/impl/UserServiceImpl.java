package com.ms1491.modules.appuser.service.impl;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms1491.common.exception.RRException;
import com.ms1491.common.validator.Assert;
import com.ms1491.modules.api.utils.ApiCode;
import com.ms1491.modules.appuser.dao.AgentDao;
import com.ms1491.modules.appuser.dao.UserDao;
import com.ms1491.modules.appuser.entity.AgentEntity;
import com.ms1491.modules.appuser.entity.UserEntity;
import com.ms1491.modules.appuser.service.UserService;



@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AgentDao agentDao;
	
	@Override
	public UserEntity queryObject(Integer userId){
		return userDao.queryObject(userId);
	}
	
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}
	
	@Override
	public void register(String exclusiveCode ,String username, String phone, String password){
		int puid = 0;
		if(StringUtils.isNotBlank(exclusiveCode)){//邀请码是否有效
			if(exclusiveCode.startsWith("U")){
				exclusiveCode = exclusiveCode.replace("U", "");
				if(StringUtils.isNumeric(exclusiveCode)){
					puid = Integer.parseInt(exclusiveCode);
					UserEntity puser = userDao.queryObject(puid);
					if(puser==null){
						throw new RRException("邀请码错误",ApiCode.AC_INVALID_PARAMETER);
					}
				}else{
					throw new RRException("邀请码错误",ApiCode.AC_INVALID_PARAMETER);
				}
			}else{
				throw new RRException("邀请码错误",ApiCode.AC_INVALID_PARAMETER);
			}
		}
		UserEntity olduser= userDao.queryByPhone(phone);
		if(olduser!=null){
			throw new RRException("手机号已被注册",ApiCode.AC_REGISTER_FAILED);
		}
		
		UserEntity user = new UserEntity();
		UserEntity puser = userDao.queryObject(puid);
		if(puser!=null){
			user.setPid(puid);
		}
		user.setRoleId(6L);//普通用户
		user.setStatus("1");
		user.setAccountMoney(new BigDecimal(0));
		user.setTestMoney(new BigDecimal(0));
		user.setPersonalSpend(new BigDecimal(0));
		user.setPhone(phone);
		user.setUsername(username);
		user.setPassword(DigestUtils.sha256Hex(password));
		user.setCreateTime(new Date());
		userDao.save(user);
	}
	
	@Override
	public void update(UserEntity user){
		userDao.update(user);
	}
	
	@Override
	public void delete(Integer userId){
		userDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Integer[] userIds){
		userDao.deleteBatch(userIds);
	}

	@Override
	public UserEntity queryByPhone(String phone) {
		return userDao.queryByPhone(phone);
	}

	@Override
	public long login(String phone, String password) {
		UserEntity user = queryByPhone(phone);
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(password))){
			throw new RRException("手机号或密码错误");
		}

		return user.getId();
	}

	@Override
	public UserEntity queryByOpenId(String openId) {
		return userDao.queryByOpenId(openId);
	}

	@Override
	public void save(UserEntity user) {
		user.setCreateTime(new Date());
		userDao.save(user);
	}

	@Override
	public void toAgent(Integer id) {
		AgentEntity oldAgent = agentDao.queryByUid(id);
		if(oldAgent==null){
			AgentEntity agent = new AgentEntity();
			agent.setUid(id);
			agent.setStatus(1);
			agent.setCheckTime(new Date());
			agent.setCreateTime(new Date());
			agent.setSubSpend(new BigDecimal(0));
			agent.setTeamSpend(new BigDecimal(0));
			agent.setTotalCommission(new BigDecimal(0));
			agent.setCommission(new BigDecimal(0));
			agentDao.save(agent);
			
		}else if(oldAgent!=null&&oldAgent.getStatus()==1){
			throw new RRException("该手机号已经是代理商");
		}else{
			oldAgent.setStatus(1);
			oldAgent.setCheckTime(new Date());
			agentDao.update(oldAgent);
		}
		
	}

	@Override
	public UserEntity queryByManagerUserId(Long managerUserId) {
		return userDao.queryByManagerUserId(managerUserId);
	}
}
