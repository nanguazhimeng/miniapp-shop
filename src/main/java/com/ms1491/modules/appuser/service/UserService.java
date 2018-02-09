package com.ms1491.modules.appuser.service;

import java.util.List;
import java.util.Map;

import com.ms1491.modules.appuser.entity.UserEntity;

/**
 * 用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:09
 */
public interface UserService {
	
	UserEntity queryObject(Integer uid);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	public void register(String exclusiveCode , String username,String phone, String password);
	
	UserEntity queryByPhone(String phone);
	
	UserEntity queryByOpenId(String openId);
	
	UserEntity queryByManagerUserId(Long managerUserId);

	/**
	 * 用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	long login(String mobile, String password);
	
	void toAgent(Integer id);
}
