package com.ms1491.modules.shop.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.ms1491.common.utils.DataUtils;
import com.ms1491.common.utils.PageUtils;
import com.ms1491.common.utils.Query;
import com.ms1491.common.utils.R;
import com.ms1491.modules.payment.service.AlipayClientFactory;
import com.ms1491.modules.shop.entity.OrderEntity;
import com.ms1491.modules.shop.service.OrderService;


/**
 * 订单管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("order:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderEntity> orderList = orderService.queryList(query);
		int total = orderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	/**
	 * 
	 * @param out
	 * @param request
	 * @param response
	 * @param orderId
	 */
	@RequestMapping("/payment")
	public R payment(Integer orderId ){
		try {
			OrderEntity order = orderService.queryObject(orderId);
			
			Map<String, String> maps = new HashMap<String, String>();
			//商户订单号，商户网站订单系统中唯一订单号，必填
			maps.put("out_trade_no", order.getOutTradeNo());  
			//付款金额，必填
	        maps.put("total_amount", order.getPrice().toString());  
	        //订单名称，必填
	        maps.put("subject", "云服务器ECS(包月)");
	      //商品描述，可空
	        maps.put("body", "云服务器ECS(包月)");
	        AlipayClientFactory ali = new AlipayClientFactory(); 
	        String form = ali.pc_Pay(maps); 
	        
			return R.ok().put("form", form);
		}catch(AlipayApiException e){
			e.printStackTrace();
			return R.error();
		}
		
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{orderId}")
	@RequiresPermissions("order:info")
	public R info(@PathVariable("orderId") Integer orderId){
		
		OrderEntity order = orderService.queryObject(orderId);
		
		return R.ok().put("order", order);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("order:save")
	public R save(@RequestBody OrderEntity order){
		orderService.save(order);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("order:update")
	public R update(@RequestBody OrderEntity order){
		orderService.update(order);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("order:delete")
	public R delete(@RequestBody Integer[] ids){
		orderService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
