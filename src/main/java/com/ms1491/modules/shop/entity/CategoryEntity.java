package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//分类名称
	private String name;
	//分类图片
	private String iconurl;
	//上级
	private Integer pid;
	//排序
	private Integer displayorder;
	
	private String parentName;
	
	/**
	 * ztree属性
	 */
	private Boolean open;
	private List<?> list;

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
	 * 设置：分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：分类名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：分类图片
	 */
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}
	/**
	 * 获取：分类图片
	 */
	public String getIconurl() {
		return iconurl;
	}
	/**
	 * 设置：上级
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：上级
	 */
	public Integer getPid() {
		return pid;
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
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
