package com.ms1491.modules.appuser.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ms1491.modules.appuser.entity.UserEntity;
import com.ms1491.modules.sys.dao.BaseDao;
/**
 * 用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:09
 */
 @Mapper
public interface UserDao extends BaseDao<UserEntity> {
	    UserEntity queryByPhone(String phone);
	    
	    UserEntity queryByOpenId(String openId);
	    
	    UserEntity queryByManagerUserId(Long managerUserId);
	    
}
