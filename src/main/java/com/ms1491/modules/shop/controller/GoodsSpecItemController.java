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
import com.ms1491.modules.shop.entity.GoodsSpecItemEntity;
import com.ms1491.modules.shop.service.GoodsSpecItemService;


/**
 * 规则项管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/goodsspecitem")
public class GoodsSpecItemController {
	@Autowired
	private GoodsSpecItemService goodsSpecItemService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("goodsspecitem:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsSpecItemEntity> goodsSpecItemList = goodsSpecItemService.queryList(query);
		int total = goodsSpecItemService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsSpecItemList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("goodsspecitem:info")
	public R info(@PathVariable("id") Integer id){
		GoodsSpecItemEntity goodsSpecItem = goodsSpecItemService.queryObject(id);
		
		return R.ok().put("goodsSpecItem", goodsSpecItem);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("goodsspecitem:save")
	public R save(@RequestBody GoodsSpecItemEntity goodsSpecItem){
		goodsSpecItemService.save(goodsSpecItem);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("goodsspecitem:update")
	public R update(@RequestBody GoodsSpecItemEntity goodsSpecItem){
		goodsSpecItemService.update(goodsSpecItem);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("goodsspecitem:delete")
	public R delete(@RequestBody Integer[] ids){
		goodsSpecItemService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
