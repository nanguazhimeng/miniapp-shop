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
import com.ms1491.modules.shop.entity.OrderRefundEntity;
import com.ms1491.modules.shop.service.OrderRefundService;


/**
 * 退款订单
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/orderrefund")
public class OrderRefundController {
	@Autowired
	private OrderRefundService orderRefundService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("orderrefund:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderRefundEntity> orderRefundList = orderRefundService.queryList(query);
		int total = orderRefundService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderRefundList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("orderrefund:info")
	public R info(@PathVariable("id") Integer id){
		OrderRefundEntity orderRefund = orderRefundService.queryObject(id);
		
		return R.ok().put("orderRefund", orderRefund);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("orderrefund:save")
	public R save(@RequestBody OrderRefundEntity orderRefund){
		orderRefundService.save(orderRefund);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("orderrefund:update")
	public R update(@RequestBody OrderRefundEntity orderRefund){
		orderRefundService.update(orderRefund);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("orderrefund:delete")
	public R delete(@RequestBody Integer[] ids){
		orderRefundService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
