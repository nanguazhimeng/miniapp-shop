package com.ms1491.modules.shop.controller;

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
import com.ms1491.modules.shop.entity.StoreEntity;
import com.ms1491.modules.shop.service.StoreService;


/**
 * 店铺管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("store:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<StoreEntity> storeList = storeService.queryList(query);
		int total = storeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(storeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("store:info")
	public R info(@PathVariable("id") String id){
		StoreEntity store = storeService.queryObject(id);
		
		return R.ok().put("store", store);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("store:save")
	public R save(@RequestBody StoreEntity store){
		storeService.save(store);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("store:update")
	public R update(@RequestBody StoreEntity store){
		storeService.update(store);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("store:delete")
	public R delete(@RequestBody String[] ids){
		storeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
