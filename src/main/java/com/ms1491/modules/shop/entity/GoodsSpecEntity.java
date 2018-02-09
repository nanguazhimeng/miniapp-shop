package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 规格管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class GoodsSpecEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//商品
	private Integer goodsid;
	//标题
	private String title;
	//排序
	private Integer displayorder;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：商品
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	/**
	 * 获取：商品
	 */
	public Integer getGoodsid() {
		return goodsid;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：排序
	 */
	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}
	/**
	 * 获取：排序
	 */
	public Integer getDisplayorder() {
		return displayorder;
	}
}
