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
import com.ms1491.modules.shop.entity.CategoryEntity;
import com.ms1491.modules.shop.service.CategoryService;


/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
@RestController
@RequestMapping("shop/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("category:list")
	public List<CategoryEntity> list(){
		//查询列表数据
		List<CategoryEntity> goodscategoryList = categoryService.queryList(new HashMap<String, Object>());
//		//添加顶级菜单
//		GoodscategoryEntity root = new GoodscategoryEntity();
//		root.setGoodscategoryId("0");
//		root.setName("一级分类");
//		root.setPid("-1");
//		root.setOpen(true);
//		goodscategoryList.add(root);
		return goodscategoryList;
		}
	/**
	 * 选择列表
	 */
	@RequestMapping("/select")
	@RequiresPermissions("category:list")
	public  R  select(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		
		List<CategoryEntity> categoryList = categoryService.queryList(map);
		//添加顶级菜单
		CategoryEntity root = new CategoryEntity();
		root.setId(0);
		root.setName("一级分类");
		root.setPid(-1);
		root.setOpen(true);
		categoryList.add(root);
		return R.ok().put("categoryList", categoryList);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("category:info")
	public R info(@PathVariable("id") Integer id){
		CategoryEntity category = categoryService.queryObject(id);
		
		return R.ok().put("category", category);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("category:save")
	public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("category:update")
	public R update(@RequestBody CategoryEntity category){
		categoryService.update(category);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("category:delete")
	public R delete( Integer id){

		//判断是否有子菜单或按钮
		List<CategoryEntity> goodscategoryList = categoryService.queryListParentId(id);
		if(goodscategoryList.size() > 0){
			return R.error("请先删除分类");
		}

		categoryService.deleteBatch(new Integer[]{id});
		return R.ok();
	}
	
}
