package com.op.entity.usercenter;

import java.util.Date;
/** 
 * 活动报名表(activeSignup)实体类
 * @author Yan
 * @version Revision: 1.00 
 *  Date: 2015-12-16 11:12:22 
 */  
public class ActiveSignup {


 	//id
  	 private String asu_id;
 	//参加人员姓名
  	 private String asu_user_name;
 	//参加人员性别（1：男；2：女）
  	 private int asu_user_sex;
 	//参加人员手机号码
  	 private String asu_user_phone;
 	//参加人员证件类型
  	 private int asu_user_certificates_type;
 	//参加人员证件号码
  	 private String asu_user_certificates_num;
 	//应急联系人
  	 private String asu_user_emergency;
 	//应急联系人手机号码
  	 private String asu_user_emergency_phone;
 	//活动ID
  	 private String asu_active_id;
 	//创建用户ID
  	 private String asu_user_id;
 	//报名时间
  	 private Date asu_create_time;
 	//报名状态
  	 private int asu_state;
 	//已付款总额(元)
  	 private int asu_account_paid;
 	//支付流水号
  	 private String asu_user_account_num;
 	//申请退款时间
  	 private Date asu_refund_time;
 	//退款状态
  	 private int asu_refund_state;
 	//是否申请退款（0：默认；1：是；）
  	 private int asu_refund_flag;



	 
    /**
    *id
    */ 
	public String getAsu_id() {
		return asu_id;
	}
	public void setAsu_id(String asu_id) {
		this.asu_id = asu_id;
	}
    /**
    *参加人员姓名
    */ 
	public String getAsu_user_name() {
		return asu_user_name;
	}
	public void setAsu_user_name(String asu_user_name) {
		this.asu_user_name = asu_user_name;
	}
    /**
    *参加人员性别（1：男；2：女）
    */ 
	public int getAsu_user_sex() {
		return asu_user_sex;
	}
	public void setAsu_user_sex(int asu_user_sex) {
		this.asu_user_sex = asu_user_sex;
	}
    /**
    *参加人员手机号码
    */ 
	public String getAsu_user_phone() {
		return asu_user_phone;
	}
	public void setAsu_user_phone(String asu_user_phone) {
		this.asu_user_phone = asu_user_phone;
	}
    /**
    *参加人员证件类型
    */ 
	public int getAsu_user_certificates_type() {
		return asu_user_certificates_type;
	}
	public void setAsu_user_certificates_type(int asu_user_certificates_type) {
		this.asu_user_certificates_type = asu_user_certificates_type;
	}
    /**
    *参加人员证件号码
    */ 
	public String getAsu_user_certificates_num() {
		return asu_user_certificates_num;
	}
	public void setAsu_user_certificates_num(String asu_user_certificates_num) {
		this.asu_user_certificates_num = asu_user_certificates_num;
	}
    /**
    *应急联系人
    */ 
	public String getAsu_user_emergency() {
		return asu_user_emergency;
	}
	public void setAsu_user_emergency(String asu_user_emergency) {
		this.asu_user_emergency = asu_user_emergency;
	}
    /**
    *应急联系人手机号码
    */ 
	public String getAsu_user_emergency_phone() {
		return asu_user_emergency_phone;
	}
	public void setAsu_user_emergency_phone(String asu_user_emergency_phone) {
		this.asu_user_emergency_phone = asu_user_emergency_phone;
	}
    /**
    *活动ID
    */ 
	public String getAsu_active_id() {
		return asu_active_id;
	}
	public void setAsu_active_id(String asu_active_id) {
		this.asu_active_id = asu_active_id;
	}
    /**
    *创建用户ID
    */ 
	public String getAsu_user_id() {
		return asu_user_id;
	}
	public void setAsu_user_id(String asu_user_id) {
		this.asu_user_id = asu_user_id;
	}
    /**
    *报名时间
    */ 
	public Date getAsu_create_time() {
		return asu_create_time;
	}
	public void setAsu_create_time(Date asu_create_time) {
		this.asu_create_time = asu_create_time;
	}
    /**
    *报名状态
    */ 
	public int getAsu_state() {
		return asu_state;
	}
	public void setAsu_state(int asu_state) {
		this.asu_state = asu_state;
	}
    /**
    *已付款总额(元)
    */ 
	public int getAsu_account_paid() {
		return asu_account_paid;
	}
	public void setAsu_account_paid(int asu_account_paid) {
		this.asu_account_paid = asu_account_paid;
	}
    /**
    *支付流水号
    */ 
	public String getAsu_user_account_num() {
		return asu_user_account_num;
	}
	public void setAsu_user_account_num(String asu_user_account_num) {
		this.asu_user_account_num = asu_user_account_num;
	}
    /**
    *申请退款时间
    */ 
	public Date getAsu_refund_time() {
		return asu_refund_time;
	}
	public void setAsu_refund_time(Date asu_refund_time) {
		this.asu_refund_time = asu_refund_time;
	}
    /**
    *退款状态
    */ 
	public int getAsu_refund_state() {
		return asu_refund_state;
	}
	public void setAsu_refund_state(int asu_refund_state) {
		this.asu_refund_state = asu_refund_state;
	}
    /**
    *是否申请退款（0：默认；1：是；）
    */ 
	public int getAsu_refund_flag() {
		return asu_refund_flag;
	}
	public void setAsu_refund_flag(int asu_refund_flag) {
		this.asu_refund_flag = asu_refund_flag;
	}
	
}
