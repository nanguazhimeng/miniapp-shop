package com.ms1491.modules.appuser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.ms1491.common.validator.group.AddGroup;
import com.ms1491.common.validator.group.UpdateGroup;



/**
 * 用户表
 * 
 * @author lcm
 * @email 282392926@qq.com
 * @date 2018-01-23 14:50:09
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//上级
	private Integer pid;
	
	private String openid;
	
	private String unionid;
	//昵称
	@NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String username;
	//手机号
	@NotBlank(message="手机号不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String phone;
	//密码
	@NotBlank(message="密码不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String password;
	//状态
	private String status;
	//头像
	private String avatar;
	//性别
	private String gender;
	//
	private Date birthday;
	//角色
	private Long roleId;
	
	private Integer fans;
	//账户余额
	private BigDecimal accountMoney;
	//体验金
	private BigDecimal testMoney;
	//
	private Date createTime;
	//我的专属码
	private String exclusiveCode;
	//二维码
	private String twoDimensionCode;
	//个人消费
	private BigDecimal personalSpend;
	
	private String rolename;
	
	private String pname;
	
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
	 * 设置：昵称
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：昵称
	 */
	public String getUsername() {
		return username;
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
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：性别（男Y女X）
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别（男Y女X）
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：角色
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * 设置：账户余额
	 */
	public void setAccountMoney(BigDecimal accountMoney) {
		this.accountMoney = accountMoney;
	}
	/**
	 * 获取：账户余额
	 */
	public BigDecimal getAccountMoney() {
		return accountMoney;
	}
	/**
	 * 设置：体验金
	 */
	public void setTestMoney(BigDecimal testMoney) {
		this.testMoney = testMoney;
	}
	/**
	 * 获取：体验金
	 */
	public BigDecimal getTestMoney() {
		return testMoney;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：我的专属码
	 */
	public void setExclusiveCode(String exclusiveCode) {
		this.exclusiveCode = exclusiveCode;
	}
	/**
	 * 获取：我的专属码
	 */
	public String getExclusiveCode() {
		return exclusiveCode;
	}
	/**
	 * 设置：二维码
	 */
	public void setTwoDimensionCode(String twoDimensionCode) {
		this.twoDimensionCode = twoDimensionCode;
	}
	/**
	 * 获取：二维码
	 */
	public String getTwoDimensionCode() {
		return twoDimensionCode;
	}
	/**
	 * 设置：个人消费
	 */
	public void setPersonalSpend(BigDecimal personalSpend) {
		this.personalSpend = personalSpend;
	}
	/**
	 * 获取：个人消费
	 */
	public BigDecimal getPersonalSpend() {
		return personalSpend;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getFans() {
		return fans;
	}
	public void setFans(Integer fans) {
		this.fans = fans;
	}
	public Long getManagerUserId() {
		return managerUserId;
	}
	public void setManagerUserId(Long managerUserId) {
		this.managerUserId = managerUserId;
	}
	
}
