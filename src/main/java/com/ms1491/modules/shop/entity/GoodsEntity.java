package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 商品管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//分类
	private String cates;
	//品牌
	private Integer brandid;
	//标题
	private String goodsname;
	//描述
	private String desc;
	//图片内容
	private String img;
	//文本内容
	private String imgs;
	//现价
	private BigDecimal marketprice;
	//成本
	private BigDecimal costprice;
	//原价
	private BigDecimal originprice;
	//活动开始时间
	private Date starttime;
	//活动结束时间
	private Date endtime;
	//运费设置
	private Integer expressRule;
	//运费
	private BigDecimal expressprice;
	//来源
	private String location;
	//标签
	private String label;
	//库存
	private Integer total;
	//创建时间
	private Date createtime;
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
	 * 设置：分类
	 */
	public void setCates(String cates) {
		this.cates = cates;
	}
	/**
	 * 获取：分类
	 */
	public String getCates() {
		return cates;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	/**
	 * 获取：品牌
	 */
	public Integer getBrandid() {
		return brandid;
	}
	/**
	 * 设置：标题
	 */
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	/**
	 * 获取：标题
	 */
	public String getGoodsname() {
		return goodsname;
	}
	/**
	 * 设置：描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：图片内容
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图片内容
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：文本内容
	 */
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	/**
	 * 获取：文本内容
	 */
	public String getImgs() {
		return imgs;
	}
	/**
	 * 设置：现价
	 */
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	/**
	 * 获取：现价
	 */
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	/**
	 * 设置：成本
	 */
	public void setCostprice(BigDecimal costprice) {
		this.costprice = costprice;
	}
	/**
	 * 获取：成本
	 */
	public BigDecimal getCostprice() {
		return costprice;
	}
	/**
	 * 设置：原价
	 */
	public void setOriginprice(BigDecimal originprice) {
		this.originprice = originprice;
	}
	/**
	 * 获取：原价
	 */
	public BigDecimal getOriginprice() {
		return originprice;
	}
	/**
	 * 设置：活动开始时间
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	/**
	 * 获取：活动开始时间
	 */
	public Date getStarttime() {
		return starttime;
	}
	/**
	 * 设置：活动结束时间
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	/**
	 * 获取：活动结束时间
	 */
	public Date getEndtime() {
		return endtime;
	}
	/**
	 * 设置：运费设置
	 */
	public void setExpressRule(Integer expressRule) {
		this.expressRule = expressRule;
	}
	/**
	 * 获取：运费设置
	 */
	public Integer getExpressRule() {
		return expressRule;
	}
	/**
	 * 设置：运费
	 */
	public void setExpressprice(BigDecimal expressprice) {
		this.expressprice = expressprice;
	}
	/**
	 * 获取：运费
	 */
	public BigDecimal getExpressprice() {
		return expressprice;
	}
	/**
	 * 设置：来源
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：来源
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：标签
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * 获取：标签
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * 设置：库存
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	/**
	 * 获取：库存
	 */
	public Integer getTotal() {
		return total;
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
