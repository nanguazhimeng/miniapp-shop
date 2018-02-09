package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 店铺-商品
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2017-09-26 14:42:32
 */
public class StoreGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private Integer id;
	//店铺id
	private Integer storeId;
	//商品id
	private Integer goodsId;
	//分类id
	private Integer goodscategoryId;
	//图片
	private String img;
	//名称
	private String title;
	//库存
	private Integer total;
	//销量
	private Integer sales;
	//价格
	private BigDecimal marketprice;
	//原价格
	private BigDecimal originalprice;
	//销售状态
	private Integer salesStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodscategoryId() {
		return goodscategoryId;
	}
	public void setGoodscategoryId(Integer goodscategoryId) {
		this.goodscategoryId = goodscategoryId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	public BigDecimal getOriginalprice() {
		return originalprice;
	}
	public void setOriginalprice(BigDecimal originalprice) {
		this.originalprice = originalprice;
	}
	public Integer getSalesStatus() {
		return salesStatus;
	}
	public void setSalesStatus(Integer salesStatus) {
		this.salesStatus = salesStatus;
	}
	
}
