package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 收藏管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class FavoriteEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户id
	private Integer uid;
	//商品id
	private Integer goodsid;
	//商品名称
	private String goodsname;
	//市场价
	private BigDecimal marketprice;
	//原价
	private BigDecimal originalprice;
	//缩略图
	private String img;
	//创建时间
	private Date createetime;

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
	 * 设置：商品名称
	 */
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsname() {
		return goodsname;
	}
	/**
	 * 设置：市场价
	 */
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	/**
	 * 获取：市场价
	 */
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	/**
	 * 设置：原价
	 */
	public void setOriginalprice(BigDecimal originalprice) {
		this.originalprice = originalprice;
	}
	/**
	 * 获取：原价
	 */
	public BigDecimal getOriginalprice() {
		return originalprice;
	}
	/**
	 * 设置：缩略图
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：缩略图
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateetime(Date createetime) {
		this.createetime = createetime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateetime() {
		return createetime;
	}
}
