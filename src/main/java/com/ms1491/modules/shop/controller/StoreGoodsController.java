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
import com.ms1491.common.validator.ValidatorUtils;
import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.modules.shop.entity.StoreGoodsEntity;
import com.ms1491.modules.shop.service.StoreGoodsService;


/**
 * 店铺-商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
@RestController
@RequestMapping("shop/storegoods")
public class StoreGoodsController {
	@Autowired
	private StoreGoodsService storeGoodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("storegoods:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<StoreGoodsEntity> storeGoodsList = storeGoodsService.queryList(query);
		int total = storeGoodsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(storeGoodsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("storegoods:info")
	public R info(@PathVariable("id") Integer id){
		StoreGoodsEntity storeGoods = storeGoodsService.queryObject(id);
		
		return R.ok().put("storeGoods", storeGoods);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("storegoods:save")
	public R save(@RequestBody StoreGoodsEntity storeGoods){
		ValidatorUtils.validateEntity(storeGoods,AddGroup.class);
		
		storeGoodsService.save(storeGoods);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("storegoods:update")
	public R update(@RequestBody StoreGoodsEntity storeGoods){
		storeGoodsService.update(storeGoods);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("storegoods:delete")
	public R delete(@RequestBody Integer[] ids){
		storeGoodsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
