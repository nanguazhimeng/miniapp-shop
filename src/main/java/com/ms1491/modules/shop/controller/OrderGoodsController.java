package com.ms1491.modules.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms1491.common.utils.R;
import com.ms1491.modules.shop.entity.OrderGoodsEntity;
import com.ms1491.modules.shop.service.OrderGoodsService;


/**
 * 订单商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/ordergoods")
public class OrderGoodsController {
	@Autowired
	private OrderGoodsService orderGoodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list/{outTradeNo}")
	@RequiresPermissions("order:list")
	public R list(@PathVariable("outTradeNo") String outTradeNo){
		//查询列表数据
		Map<String, Object> params = new HashMap<>();
		params.put("outTradeNo", outTradeNo);
		List<OrderGoodsEntity> ordergoodsList = orderGoodsService.queryList(params);
		
		return R.ok().put("ordergoodsList", ordergoodsList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("ordergoods:info")
	public R info(@PathVariable("id") Integer id){
		OrderGoodsEntity orderGoods = orderGoodsService.queryObject(id);
		
		return R.ok().put("orderGoods", orderGoods);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ordergoods:save")
	public R save(@RequestBody OrderGoodsEntity orderGoods){
		orderGoodsService.save(orderGoods);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ordergoods:update")
	public R update(@RequestBody OrderGoodsEntity orderGoods){
		orderGoodsService.update(orderGoods);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ordergoods:delete")
	public R delete(@RequestBody Integer[] ids){
		orderGoodsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
