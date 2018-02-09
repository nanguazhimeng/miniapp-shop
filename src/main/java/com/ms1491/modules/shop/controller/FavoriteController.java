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
import com.ms1491.modules.shop.entity.FavoriteEntity;
import com.ms1491.modules.shop.service.FavoriteService;


/**
 * 收藏管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/favorite")
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("favorite:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FavoriteEntity> favoriteList = favoriteService.queryList(query);
		int total = favoriteService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(favoriteList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("favorite:info")
	public R info(@PathVariable("id") Integer id){
		FavoriteEntity favorite = favoriteService.queryObject(id);
		
		return R.ok().put("favorite", favorite);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("favorite:save")
	public R save(@RequestBody FavoriteEntity favorite){
		favoriteService.save(favorite);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("favorite:update")
	public R update(@RequestBody FavoriteEntity favorite){
		favoriteService.update(favorite);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("favorite:delete")
	public R delete(@RequestBody Integer[] ids){
		favoriteService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
