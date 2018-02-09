package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 规则项管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class GoodsSpecItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//规格id
	private Integer specid;
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
	 * 设置：规格id
	 */
	public void setSpecid(Integer specid) {
		this.specid = specid;
	}
	/**
	 * 获取：规格id
	 */
	public Integer getSpecid() {
		return specid;
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
