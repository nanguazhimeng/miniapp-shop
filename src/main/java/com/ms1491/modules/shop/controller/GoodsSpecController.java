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
import com.ms1491.modules.shop.entity.GoodsSpecEntity;
import com.ms1491.modules.shop.service.GoodsSpecService;


/**
 * 规格管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/goodsspec")
public class GoodsSpecController {
	@Autowired
	private GoodsSpecService goodsSpecService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("goodsspec:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsSpecEntity> goodsSpecList = goodsSpecService.queryList(query);
		int total = goodsSpecService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsSpecList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("goodsspec:info")
	public R info(@PathVariable("id") Integer id){
		GoodsSpecEntity goodsSpec = goodsSpecService.queryObject(id);
		
		return R.ok().put("goodsSpec", goodsSpec);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("goodsspec:save")
	public R save(@RequestBody GoodsSpecEntity goodsSpec){
		goodsSpecService.save(goodsSpec);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("goodsspec:update")
	public R update(@RequestBody GoodsSpecEntity goodsSpec){
		goodsSpecService.update(goodsSpec);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("goodsspec:delete")
	public R delete(@RequestBody Integer[] ids){
		goodsSpecService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
