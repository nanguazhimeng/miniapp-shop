package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 订单商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class OrderGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//订单号
	private String outTradeNo;
	//商品id
	private Integer goodsid;
	//市场价
	private BigDecimal marketprice;
	//数量
	private Integer total;
	//规格
	private String items;
	//规格
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
	 * 设置：订单号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
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
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	
}
