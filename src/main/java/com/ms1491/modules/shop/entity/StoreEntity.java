package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 店铺管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class StoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//店铺id
	private Integer id;
	//用户id
	private Integer uid;
	//logo
	private String logo;
	//店铺名称
	private String storename;
	//简介
	private String desc;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 设置：logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：店铺名称
	 */
	public void setStorename(String storename) {
		this.storename = storename;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getStorename() {
		return storename;
	}
	/**
	 * 设置：简介
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：简介
	 */
	public String getDesc() {
		return desc;
	}
}
