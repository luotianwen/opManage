package com.op.entity.balance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/** 
 * 用户资金账户余额表(balance)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-04-08 13:20:52 
 */  
public class Balance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//ID
  	 private String id;
 	//用户ID
  	 private String user_id;
 	//支付密码(MD5加密后的结果)
  	 private String payPassword;
 	//可用金额
  	 private BigDecimal available_money;
 	//冻结金额
  	 private BigDecimal frozen_money;
 	//账户状态（1：有效；2：冻结；）
  	 private String state;
 	//更新时间
  	 private Date update_time;
 	//更改用户状态备注
  	 private String remarks;
 	//更改用户状态操作人名称
  	 private String operator_name;
 	//更改用户状态操作人id
  	 private String operator_id;



	 
    /**
    *ID
    */ 
	public String getId() {
		return id;
	}
    /**
    *ID
    */ 
	public void setId(String id) {
		this.id = id;
	}
    /**
    *用户ID
    */ 
	public String getUser_id() {
		return user_id;
	}
    /**
    *用户ID
    */ 
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
    /**
    *支付密码(MD5加密后的结果)
    */ 
	public String getPayPassword() {
		return payPassword;
	}
    /**
    *支付密码(MD5加密后的结果)
    */ 
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
    /**
    *可用金额
    */ 
	public BigDecimal getAvailable_money() {
		return available_money;
	}
    /**
    *可用金额
    */ 
	public void setAvailable_money(BigDecimal available_money) {
		this.available_money = available_money;
	}
    /**
    *冻结金额
    */ 
	public BigDecimal getFrozen_money() {
		return frozen_money;
	}
    /**
    *冻结金额
    */ 
	public void setFrozen_money(BigDecimal frozen_money) {
		this.frozen_money = frozen_money;
	}
    /**
    *账户状态（1：有效；2：冻结；）
    */ 
	public String getState() {
		return state;
	}
    /**
    *账户状态（1：有效；2：冻结；）
    */ 
	public void setState(String state) {
		this.state = state;
	}
    /**
    *更新时间
    */ 
	public Date getUpdate_time() {
		return update_time;
	}
    /**
    *更新时间
    */ 
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
    /**
    *更改用户状态备注
    */ 
	public String getRemarks() {
		return remarks;
	}
    /**
    *更改用户状态备注
    */ 
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    /**
    *更改用户状态操作人名称
    */ 
	public String getOperator_name() {
		return operator_name;
	}
    /**
    *更改用户状态操作人名称
    */ 
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
    /**
    *更改用户状态操作人id
    */ 
	public String getOperator_id() {
		return operator_id;
	}
    /**
    *更改用户状态操作人id
    */ 
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}
	
}
