package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 退款订单
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class OrderRefundEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer uid;
	//订单号
	private String outTradeNo;
	//价格
	private BigDecimal price;
	//原因
	private String reason;
	//图片
	private String imgs;
	//内容
	private String content;
	//状态
	private Integer status;
	//商家回复
	private String reply;
	//创建时间
	private Date createtime;

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
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：原因
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：图片
	 */
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	/**
	 * 获取：图片
	 */
	public String getImgs() {
		return imgs;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：商家回复
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * 获取：商家回复
	 */
	public String getReply() {
		return reply;
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
}
