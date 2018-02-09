package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 购物车
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户id
	private Integer uid;
	//商品id
	private Integer goodsid;
	//数量
	private Integer total;
	//规格id
	private String itemid;
	//规格
	private String items;
	//创建时间
	private Date createtime;
	
	//分类
	private String cates;
	//现价
	private BigDecimal marketprice;
	//标题
	private String goodsname;

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
	 * 设置：用户id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：商品id
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	/**
	 * 获取：商品id
	 */
	public Integer getGoodsid() {
		return goodsid;
	}
	/**
	 * 设置：数量
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	/**
	 * 获取：数量
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * 设置：规格id
	 */
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	/**
	 * 获取：规格id
	 */
	public String getItemid() {
		return itemid;
	}
	/**
	 * 设置：规格
	 */
	public void setItems(String items) {
		this.items = items;
	}
	/**
	 * 获取：规格
	 */
	public String getItems() {
		return items;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	public String getCates() {
		return cates;
	}
	public void setCates(String cates) {
		this.cates = cates;
	}
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	
}
