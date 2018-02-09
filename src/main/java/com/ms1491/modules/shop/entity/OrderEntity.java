package com.ms1491.modules.shop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 订单管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-11 17:41:46
 */
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户
	private Integer uid;
	//openid
	private String openid;
	//订单编号
	private String outTradeNo;
	//商品
	private String title;
	//价格
	private BigDecimal price= new BigDecimal(0);
	//打折抵扣
	private BigDecimal discountprice = new BigDecimal(0);
	//优惠券抵扣
	private BigDecimal deductprice= new BigDecimal(0);
	//优惠券
	private Integer couponid;
	//快递方式
	private Integer expresrule;
	//快递费
	private BigDecimal expressprice= new BigDecimal(0);
	//数量
	private Integer total;
	//支付方式
	private Integer paytype;
	//状态
	private Integer status;
	//退款id
	private Integer refundid;
	//地址
	private String address;
	//手机号
	private String phone;
	//联系人
	private String realname;
	//备注
	private String remark;
	//支付时间
	private Date paytime;
	//结束时间
	private Date finishtime;
	
	private Integer type;
	
	private Integer mystoreid;
	
	private Integer storeid;
	//创建时间
	private Date createtime;
	
	private String username;
	
	private String userphone;
	
	private String storename;

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
	 * 设置：用户
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：订单编号
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
	 * 设置：打折抵扣
	 */
	public void setDiscountprice(BigDecimal discountprice) {
		this.discountprice = discountprice;
	}
	/**
	 * 获取：打折抵扣
	 */
	public BigDecimal getDiscountprice() {
		return discountprice;
	}
	/**
	 * 设置：优惠券抵扣
	 */
	public void setDeductprice(BigDecimal deductprice) {
		this.deductprice = deductprice;
	}
	/**
	 * 获取：优惠券抵扣
	 */
	public BigDecimal getDeductprice() {
		return deductprice;
	}
	/**
	 * 设置：优惠券
	 */
	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}
	/**
	 * 获取：优惠券
	 */
	public Integer getCouponid() {
		return couponid;
	}
	/**
	 * 设置：快递方式
	 */
	public void setExpresrule(Integer expresrule) {
		this.expresrule = expresrule;
	}
	/**
	 * 获取：快递方式
	 */
	public Integer getExpresrule() {
		return expresrule;
	}
	/**
	 * 设置：快递费
	 */
	public void setExpressprice(BigDecimal expressprice) {
		this.expressprice = expressprice;
	}
	/**
	 * 获取：快递费
	 */
	public BigDecimal getExpressprice() {
		return expressprice;
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
	 * 设置：支付方式
	 */
	public void setPaytype(Integer paytype) {
		this.paytype = paytype;
	}
	/**
	 * 获取：支付方式
	 */
	public Integer getPaytype() {
		return paytype;
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
	 * 设置：退款id
	 */
	public void setRefundid(Integer refundid) {
		this.refundid = refundid;
	}
	/**
	 * 获取：退款id
	 */
	public Integer getRefundid() {
		return refundid;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：联系人
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：联系人
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：支付时间
	 */
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	/**
	 * 获取：支付时间
	 */
	public Date getPaytime() {
		return paytime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getFinishtime() {
		return finishtime;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getMystoreid() {
		return mystoreid;
	}
	public void setMystoreid(Integer mystoreid) {
		this.mystoreid = mystoreid;
	}
	public Integer getStoreid() {
		return storeid;
	}
	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}

	
}
