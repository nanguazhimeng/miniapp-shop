package com.ms1491.modules.shop.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
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
import com.ms1491.modules.appuser.entity.UserEntity;
import com.ms1491.modules.appuser.service.UserService;
import com.ms1491.modules.payment.service.AlipayClientFactory;
import com.ms1491.modules.shop.dao.OrderGoodsDao;
import com.ms1491.modules.shop.dao.StoreDao;
import com.ms1491.modules.shop.entity.CartEntity;
import com.ms1491.modules.shop.entity.OrderEntity;
import com.ms1491.modules.shop.entity.OrderGoodsEntity;
import com.ms1491.modules.shop.entity.StoreEntity;
import com.ms1491.modules.shop.service.CartService;
import com.ms1491.modules.shop.service.GoodsService;
import com.ms1491.modules.shop.service.OrderService;
import com.ms1491.modules.sys.controller.AbstractController;


/**
 * 购物车
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/cart")
public class CartController extends AbstractController{
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderGoodsDao orderGoodsDao;
	@Autowired
	private StoreDao storeDao;
	
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cart:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		UserEntity user = userService.queryByManagerUserId(getUserId());
		params.put("uid", user.getId());
        Query query = new Query(params);

		List<CartEntity> cartList = cartService.queryList(query);
		int total = cartService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(cartList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("cart:info")
	public R info(@PathVariable("id") Integer id){
		CartEntity cart = cartService.queryObject(id);
		
		return R.ok().put("cart", cart);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("cart:save")
	public R save(@RequestBody CartEntity cart){
		cartService.save(cart);
		
		return R.ok();
	}
	/**
	 * 创建订单
	 */
	@RequestMapping("/createOrder")
	@RequiresPermissions("goods:save")
	public R createOrder(@RequestBody OrderEntity order){
		//订单
		//支付订单
		//支付宝
		Long managerUserId = getUserId();
		UserEntity user = userService.queryByManagerUserId(managerUserId);
		Integer uid = user.getId();
		StoreEntity mystore = storeDao.queryByUid(uid);
		Integer puid = user.getPid();
		StoreEntity parentStore = storeDao.queryByUid(puid);
		
		order.setUid(uid);
		String outTradeNo = DataUtils.buildOutTradeNo();
		order.setOutTradeNo(outTradeNo);
		order.setDeductprice(new BigDecimal("0"));
		order.setStatus(0);
		order.setCreatetime(new Date());
		order.setStoreid(parentStore.getId());
		order.setMystoreid(mystore.getId());
		orderService.save(order);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("uid", uid);
		List<CartEntity> cartList = cartService.queryList(map);
		if(cartList!=null){
//			List<OrderGoodsEntity> orderGoodslist = new LinkedList<OrderGoodsEntity>();
			for (CartEntity cartEntity : cartList) {
				OrderGoodsEntity orderGoods = new OrderGoodsEntity();
				orderGoods.setGoodsid(cartEntity.getGoodsid());
				orderGoods.setMarketprice(cartEntity.getMarketprice());
				orderGoods.setOutTradeNo(outTradeNo);
				orderGoods.setTotal(cartEntity.getTotal());
				orderGoodsDao.save(orderGoods);
			}
			
		}
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("cart:update")
	public R update(@RequestBody CartEntity cart){
		cartService.update(cart);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("cart:delete")
	public R delete(@RequestBody Integer[] ids){
		cartService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
