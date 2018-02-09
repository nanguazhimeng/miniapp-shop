package com.ms1491.modules.appuser.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.exception.RRException;
import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.common.validator.ValidatorUtils;
import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.modules.appuser.entity.UserEntity;
import com.ms1491.modules.appuser.service.UserService;
import com.ms1491.modules.sys.controller.AbstractController;
import com.ms1491.modules.sys.entity.SysUserEntity;
import com.ms1491.modules.sys.service.SysUserService;


/**
 * 用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:09
 */
@RestController
@RequestMapping("appuser/user")
public class UserController  extends AbstractController {
	@Autowired
	private UserService userService;
	@Autowired
	private SysUserService sysUserService;	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("user:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserEntity> userList = userService.queryList(query);
		int total = userService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("user:info")
	public R info(@PathVariable("id") Integer id){
		UserEntity user = userService.queryObject(id);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("user:save")
	public R save(@RequestBody UserEntity user){
		ValidatorUtils.validateEntity(user,AddGroup.class);
		
		userService.register(user.getExclusiveCode(), user.getUsername(), user.getPhone(), user.getPassword());
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("user:update")
	public R update(@RequestBody UserEntity user){
		userService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("user:delete")
	public R delete(@RequestBody Integer[] ids){
		
		userService.deleteBatch(ids);
		
		return R.ok();
	}
	/**
	 * 升为代理
	 */
	@RequestMapping("/toAgent")
	@RequiresPermissions("user:update")
	public R toAgent(@RequestParam Integer id){
		UserEntity user = userService.queryObject(id);
		if(user.getRoleId()!=6){
			throw new RRException("该手机号已经是代理商");
		}
		
		userService.toAgent(id);
		
		SysUserEntity managerUser = new SysUserEntity();
		managerUser.setCreateTime(new Date());
		managerUser.setCreateUserId(getUserId());
		managerUser.setUsername(user.getPhone());
		managerUser.setMobile(user.getPhone());
		managerUser.setPassword("123456");
		managerUser.setStatus(1);
		List<Long> roleIdList = new LinkedList<>();
		roleIdList.add(5L);
		managerUser.setRoleIdList(roleIdList);
		sysUserService.save(managerUser);
		
		managerUser = sysUserService.queryByUserName(user.getPhone());
		user.setRoleId(5L);
		user.setManagerUserId(managerUser.getUserId());
		userService.update(user);
		
		return R.ok();
	}
	/**
	 * 获取折扣信息
	 */
	@RequestMapping("/getDiscount")
	public R getDiscount(){
		UserEntity user = userService.queryByManagerUserId(getUserId());
		Double discount = 0.00;
		if(user.getRoleId()==1){
			discount = 0.60;
		}else{
			discount = 0.60;
		}
		return R.ok().put("discount", discount);
	}
}
