package com.ms1491.modules.appuser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 代理管理
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:08
 */
public class AgentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户
	private Integer uid;
	//个人业绩
	private BigDecimal subSpend;
	//团队业绩
	private BigDecimal teamSpend;
	//总佣金
	private BigDecimal totalCommission;
	//未提佣金
	private BigDecimal commission;
	//真实姓名
	private String realname;
	//银行名称
	private String bankName;
	//银行卡号
	private String bankAcount;
	//身份证正面照
	private String idCardFace;
	//身份证反面照
	private String idCardBack;
	//手机号
	private String contactPhone;
	//地址
	private String contactAddress;
	//email
	private String contactEmail;
	//状态
	private Integer status;
	//审核时间
	private Date checkTime;
	//创建时间
	private Date createTime;
	
	private String username;
	
	private String rolename;
	
	private String avatar;
	
	private String pname;
	
	private String phone;
	
	private Long managerUserId;
	

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
	 * 设置：个人业绩
	 */
	public void setSubSpend(BigDecimal subSpend) {
		this.subSpend = subSpend;
	}
	/**
	 * 获取：个人业绩
	 */
	public BigDecimal getSubSpend() {
		return subSpend;
	}
	/**
	 * 设置：团队业绩
	 */
	public void setTeamSpend(BigDecimal teamSpend) {
		this.teamSpend = teamSpend;
	}
	/**
	 * 获取：团队业绩
	 */
	public BigDecimal getTeamSpend() {
		return teamSpend;
	}
	/**
	 * 设置：总佣金
	 */
	public void setTotalCommission(BigDecimal totalCommission) {
		this.totalCommission = totalCommission;
	}
	/**
	 * 获取：总佣金
	 */
	public BigDecimal getTotalCommission() {
		return totalCommission;
	}
	/**
	 * 设置：未提佣金
	 */
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
	/**
	 * 获取：未提佣金
	 */
	public BigDecimal getCommission() {
		return commission;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：银行名称
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取：银行名称
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 设置：银行卡号
	 */
	public void setBankAcount(String bankAcount) {
		this.bankAcount = bankAcount;
	}
	/**
	 * 获取：银行卡号
	 */
	public String getBankAcount() {
		return bankAcount;
	}
	/**
	 * 设置：身份证正面照
	 */
	public void setIdCardFace(String idCardFace) {
		this.idCardFace = idCardFace;
	}
	/**
	 * 获取：身份证正面照
	 */
	public String getIdCardFace() {
		return idCardFace;
	}
	/**
	 * 设置：身份证反面照
	 */
	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}
	/**
	 * 获取：身份证反面照
	 */
	public String getIdCardBack() {
		return idCardBack;
	}
	/**
	 * 设置：手机号
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：手机号
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：地址
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	/**
	 * 获取：地址
	 */
	public String getContactAddress() {
		return contactAddress;
	}
	/**
	 * 设置：email
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * 获取：email
	 */
	public String getContactEmail() {
		return contactEmail;
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
	 * 设置：审核时间
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getCheckTime() {
		return checkTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getManagerUserId() {
		return managerUserId;
	}
	public void setManagerUserId(Long managerUserId) {
		this.managerUserId = managerUserId;
	}
	
}
