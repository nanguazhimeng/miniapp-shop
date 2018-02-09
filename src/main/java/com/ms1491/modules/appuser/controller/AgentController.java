package com.ms1491.modules.appuser.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.modules.appuser.entity.AgentEntity;
import com.ms1491.modules.appuser.service.AgentService;


/**
 * 代理管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:08
 */
@RestController
@RequestMapping("appuser/agent")
public class AgentController {
	@Autowired
	private AgentService agentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("agent:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AgentEntity> agentList = agentService.queryList(query);
		int total = agentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(agentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("agent:info")
	public R info(@PathVariable("id") Integer id){
		AgentEntity agent = agentService.queryObject(id);
		
		return R.ok().put("agent", agent);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("agent:save")
	public R save(@RequestBody AgentEntity agent){
		agentService.save(agent);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("agent:update")
	public R update(@RequestBody AgentEntity agent){
		agentService.update(agent);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("agent:delete")
	public R delete(@RequestBody Integer[] ids){
		agentService.deleteBatch(ids);
		
		return R.ok();
	}
	@RequestMapping("/check")
	@RequiresPermissions("agent:update")
	public R check(@RequestBody AgentEntity agent){
		agent.setStatus(1);
		agent.setCheckTime(new Date());
		agentService.update(agent);
		
		return R.ok();
	}
}
