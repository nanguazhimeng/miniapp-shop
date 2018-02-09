package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String brandname;
	//
	private String img;
	//
	private String desc;
	//
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
	 * 设置：
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	/**
	 * 获取：
	 */
	public String getBrandname() {
		return brandname;
	}
	/**
	 * 设置：
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：
	 */
	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}
	/**
	 * 获取：
	 */
	public Integer getDisplayorder() {
		return displayorder;
	}
}
