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
import com.ms1491.modules.shop.entity.GoodsEntity;
import com.ms1491.modules.shop.service.GoodsService;


/**
 * 商品管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("goods:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsEntity> goodsList = goodsService.queryList(query);
		int total = goodsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("goods:info")
	public R info(@PathVariable("id") Integer id){
		GoodsEntity goods = goodsService.queryObject(id);
		
		return R.ok().put("goods", goods);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("goods:save")
	public R save(@RequestBody GoodsEntity goods){
		goodsService.save(goods);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("goods:update")
	public R update(@RequestBody GoodsEntity goods){
		goodsService.update(goods);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("goods:delete")
	public R delete(@RequestBody Integer[] ids){
		goodsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
