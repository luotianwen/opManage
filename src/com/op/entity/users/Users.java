package com.op.entity.users;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


import com.op.entity.authority.Roles;

/**
 * 项目名：outdoorPortal 类描述：用户基本信息 创建人：Yan 创建时间： 2015-11-7 上午11:22:46
 * 最后修改时间：2015-11-7上午11:22:46
 */
public class Users implements Serializable {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	// 用户ID
	protected String uId;
	// 用户昵称 OR 法定代表人姓名
	protected String uName;
	// 用户邮箱
	protected String uEmail;
	// 用户手机
	protected String uPhone;
	// 用户密码
	protected String uPassword;
	// 用户性别（1：男；2：女）
	protected int uSex;
	// 用户头像
	protected String uHeadImg;
	// 常用登录地区（推送附近活动）
	protected String uLoginAreaCode;
	// 创建时间
	protected Date uCreateTime;
	// 最后修改时间
	protected Date uLastUpdateTime;
	// 身份类型（1：个人发布者；2：企业；3：普通用户；4：后台管理用户）
	protected int uType;
	// 当前评分剩余量（发布者 OR 企业）
	protected int uScoreNum;
	// 用户角色ID
	protected String rId;
	// 账户是否被冻结（1：是；2：否）
	private int isFroZen;
	// 被禁言（1：是；2：否）
	private int isGAG;
	// 最后一次登录Ip
	private String uLoginIp;
	// 最后一次登录时间
	private Date uLoginDate;
	// 登录次数
	private int uLoginCount;
	// 角色集合【实际只有一种角色，此list是为了应为shiro泛型】
	protected Roles role;
 
	
	/*---------------------------------------------*/

	public Roles getRole() {
		return role;
	}

	public int getIsFroZen() {
		return isFroZen;
	}

	public void setIsFroZen(int isFroZen) {
		this.isFroZen = isFroZen;
	}

	public int getIsGAG() {
		return isGAG;
	}

	public void setIsGAG(int isGAG) {
		this.isGAG = isGAG;
	}

	public String getuLoginIp() {
		return uLoginIp;
	}

	public void setuLoginIp(String uLoginIp) {
		this.uLoginIp = uLoginIp;
	}

	public Date getuLoginDate() {
		return uLoginDate;
	}

	public void setuLoginDate(Date uLoginDate) {
		this.uLoginDate = uLoginDate;
	}


	public int getuLoginCount() {
		return uLoginCount;
	}

	public void setuLoginCount(int uLoginCount) {
		this.uLoginCount = uLoginCount;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public int getuSex() {
		return uSex;
	}

	public void setuSex(int uSex) {
		this.uSex = uSex;
	}

	public String getuHeadImg() {
/*		//头像为空显示默认头像
		if(StringUtils.isEmpty(uHeadImg)){
			uHeadImg = "static/portrait/default.jpg";
		}*/
		return uHeadImg;
	}

	public void setuHeadImg(String uHeadImg) {
		this.uHeadImg = uHeadImg;
	}

	public String getuLoginAreaCode() {
		return uLoginAreaCode;
	}

	public void setuLoginAreaCode(String uLoginAreaCode) {
		this.uLoginAreaCode = uLoginAreaCode;
	}

	public Date getuCreateTime() {
		return uCreateTime;
	}

	public void setuCreateTime(Date uCreateTime) {
		this.uCreateTime = uCreateTime;
	}

	public Date getuLastUpdateTime() {
		return uLastUpdateTime;
	}

	public void setuLastUpdateTime(Date uLastUpdateTime) {
		this.uLastUpdateTime = uLastUpdateTime;
	}

	public int getuType() {
		return uType;
	}

	public void setuType(int uType) {
		this.uType = uType;
	}

	public int getuScoreNum() {
		return uScoreNum;
	}

	public void setuScoreNum(int uScoreNum) {
		this.uScoreNum = uScoreNum;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public Users() {

	}

	public Users(String uEmail, String uPhone, String uPassword) {
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		this.uPassword = uPassword;
	}
}
