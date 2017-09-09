package com.op.dto.activity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.op.entity.activity.ActiveApplicant;
/** 
 * 活动报名（订单）表(activeSignup)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-07 13:56:37 
 */  
public class ActiveSignupDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String asu_id;
 	//应急联系人
  	 private String asu_user_emergency;
 	//应急联系人手机号码
  	 private String asu_user_emergency_phone;
 	//报名联系人手机号码
  	 private String asu_link_user_phone;
 	//订单备注
  	 private String asu_order_area;
 	//活动ID
  	 private String asu_active_id;
 	//支付流水号
  	 private String asu_user_account_num;
 	//支付宝交易号
  	 private String asu_trade_no;
 	//付款时间
  	 private Date asu_pay_time;
 	//付款总额(元)
  	 private Double asu_account_paid;
 	//应付款总额(元)(方便支付订单)
  	 private Double asu_account_payable;
 	//预付款总额
  	 private Double asu_reserve_price;
 	//支付状态（1：未支付；2：已支付；）
  	 private int asu_pay_state;
 	//支付方式（0：免费；1：平台交易；2：当面交易）
  	 private int asu_price_type;
 	//报名时间
  	 private Date asu_create_time;
 	//创建用户ID
  	 private String asu_user_id;
 	//最后修改时间
  	 private Date asu_last_update_time;
 	//最后修改用户
  	 private String asu_last_update_user;
 	//是否已经删除(0：默认；1：是；)
  	 private int asu_is_delete;
 	//是否评价（0：默认；1：是）
  	 private int asu_is_comment;
 	//与本人关系
  	 private String asu_user_relation;
 	//装备
  	 private String asu_equipment;
 	//报名状态（10：等待领队确认；20：领队已确认；30：交易完成；40：报名已取消；50：等待领队确认取消；）
  	 private int asu_state;
 	//订单类型（1：活动订单；其余待定）
  	 private int asu_type;
 	//领队是否已经删除(0：默认；1：是；)
  	 private int asu_leader_is_delete;


   	//报名活动名称
    	 private String title;
   	//报名用户名
    	 private String userName;

    	 //报名人列表
    private List<ActiveApplicant> applicantList;
	 
    /**
    *id
	* @return
    */ 
	public String getAsu_id() {
		return asu_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setAsu_id(String asu_id) {
		this.asu_id = asu_id;
	}
    /**
    *应急联系人
	* @return
    */ 
	public String getAsu_user_emergency() {
		return asu_user_emergency;
	}
    /**
    *应急联系人
	* @param type
    */ 
	public void setAsu_user_emergency(String asu_user_emergency) {
		this.asu_user_emergency = asu_user_emergency;
	}
    /**
    *应急联系人手机号码
	* @return
    */ 
	public String getAsu_user_emergency_phone() {
		return asu_user_emergency_phone;
	}
    /**
    *应急联系人手机号码
	* @param type
    */ 
	public void setAsu_user_emergency_phone(String asu_user_emergency_phone) {
		this.asu_user_emergency_phone = asu_user_emergency_phone;
	}
    /**
    *报名联系人手机号码
	* @return
    */ 
	public String getAsu_link_user_phone() {
		return asu_link_user_phone;
	}
    /**
    *报名联系人手机号码
	* @param type
    */ 
	public void setAsu_link_user_phone(String asu_link_user_phone) {
		this.asu_link_user_phone = asu_link_user_phone;
	}
    /**
    *订单备注
	* @return
    */ 
	public String getAsu_order_area() {
		return asu_order_area;
	}
    /**
    *订单备注
	* @param type
    */ 
	public void setAsu_order_area(String asu_order_area) {
		this.asu_order_area = asu_order_area;
	}
    /**
    *活动ID
	* @return
    */ 
	public String getAsu_active_id() {
		return asu_active_id;
	}
    /**
    *活动ID
	* @param type
    */ 
	public void setAsu_active_id(String asu_active_id) {
		this.asu_active_id = asu_active_id;
	}
    /**
    *支付流水号
	* @return
    */ 
	public String getAsu_user_account_num() {
		return asu_user_account_num;
	}
    /**
    *支付流水号
	* @param type
    */ 
	public void setAsu_user_account_num(String asu_user_account_num) {
		this.asu_user_account_num = asu_user_account_num;
	}
    /**
    *支付宝交易号
	* @return
    */ 
	public String getAsu_trade_no() {
		return asu_trade_no;
	}
    /**
    *支付宝交易号
	* @param type
    */ 
	public void setAsu_trade_no(String asu_trade_no) {
		this.asu_trade_no = asu_trade_no;
	}
    /**
    *付款时间
	* @return
    */ 
	public Date getAsu_pay_time() {
		return asu_pay_time;
	}
    /**
    *付款时间
	* @param type
    */ 
	public void setAsu_pay_time(Date asu_pay_time) {
		this.asu_pay_time = asu_pay_time;
	}
    /**
    *付款总额(元)
	* @return
    */ 
	public Double getAsu_account_paid() {
		return asu_account_paid;
	}
    /**
    *付款总额(元)
	* @param type
    */ 
	public void setAsu_account_paid(Double asu_account_paid) {
		this.asu_account_paid = asu_account_paid;
	}
    /**
    *应付款总额(元)(方便支付订单)
	* @return
    */ 
	public Double getAsu_account_payable() {
		return asu_account_payable;
	}
    /**
    *应付款总额(元)(方便支付订单)
	* @param type
    */ 
	public void setAsu_account_payable(Double asu_account_payable) {
		this.asu_account_payable = asu_account_payable;
	}
    /**
    *预付款总额
	* @return
    */ 
	public Double getAsu_reserve_price() {
		return asu_reserve_price;
	}
    /**
    *预付款总额
	* @param type
    */ 
	public void setAsu_reserve_price(Double asu_reserve_price) {
		this.asu_reserve_price = asu_reserve_price;
	}
    /**
    *支付状态（1：未支付；2：已支付；）
	* @return
    */ 
	public int getAsu_pay_state() {
		return asu_pay_state;
	}
    /**
    *支付状态（1：未支付；2：已支付；）
	* @param type
    */ 
	public void setAsu_pay_state(int asu_pay_state) {
		this.asu_pay_state = asu_pay_state;
	}
    /**
    *支付方式（0：免费；1：平台交易；2：当面交易）
	* @return
    */ 
	public int getAsu_price_type() {
		return asu_price_type;
	}
    /**
    *支付方式（0：免费；1：平台交易；2：当面交易）
	* @param type
    */ 
	public void setAsu_price_type(int asu_price_type) {
		this.asu_price_type = asu_price_type;
	}
    /**
    *报名时间
	* @return
    */ 
	public Date getAsu_create_time() {
		return asu_create_time;
	}
    /**
    *报名时间
	* @param type
    */ 
	public void setAsu_create_time(Date asu_create_time) {
		this.asu_create_time = asu_create_time;
	}
    /**
    *创建用户ID
	* @return
    */ 
	public String getAsu_user_id() {
		return asu_user_id;
	}
    /**
    *创建用户ID
	* @param type
    */ 
	public void setAsu_user_id(String asu_user_id) {
		this.asu_user_id = asu_user_id;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public Date getAsu_last_update_time() {
		return asu_last_update_time;
	}
    /**
    *最后修改时间
	* @param type
    */ 
	public void setAsu_last_update_time(Date asu_last_update_time) {
		this.asu_last_update_time = asu_last_update_time;
	}
    /**
    *最后修改用户
	* @return
    */ 
	public String getAsu_last_update_user() {
		return asu_last_update_user;
	}
    /**
    *最后修改用户
	* @param type
    */ 
	public void setAsu_last_update_user(String asu_last_update_user) {
		this.asu_last_update_user = asu_last_update_user;
	}
    /**
    *是否已经删除(0：默认；1：是；)
	* @return
    */ 
	public int getAsu_is_delete() {
		return asu_is_delete;
	}
    /**
    *是否已经删除(0：默认；1：是；)
	* @param type
    */ 
	public void setAsu_is_delete(int asu_is_delete) {
		this.asu_is_delete = asu_is_delete;
	}
    /**
    *是否评价（0：默认；1：是）
	* @return
    */ 
	public int getAsu_is_comment() {
		return asu_is_comment;
	}
    /**
    *是否评价（0：默认；1：是）
	* @param type
    */ 
	public void setAsu_is_comment(int asu_is_comment) {
		this.asu_is_comment = asu_is_comment;
	}
    /**
    *与本人关系
	* @return
    */ 
	public String getAsu_user_relation() {
		return asu_user_relation;
	}
    /**
    *与本人关系
	* @param type
    */ 
	public void setAsu_user_relation(String asu_user_relation) {
		this.asu_user_relation = asu_user_relation;
	}
    /**
    *装备
	* @return
    */ 
	public String getAsu_equipment() {
		return asu_equipment;
	}
    /**
    *装备
	* @param type
    */ 
	public void setAsu_equipment(String asu_equipment) {
		this.asu_equipment = asu_equipment;
	}
    /**
    *报名状态（10：等待领队确认；20：领队已确认；30：交易完成；40：报名已取消；50：等待领队确认取消；）
	* @return
    */ 
	public int getAsu_state() {
		return asu_state;
	}
    /**
    *报名状态（10：等待领队确认；20：领队已确认；30：交易完成；40：报名已取消；50：等待领队确认取消；）
	* @param type
    */ 
	public void setAsu_state(int asu_state) {
		this.asu_state = asu_state;
	}
    /**
    *订单类型（1：活动订单；其余待定）
	* @return
    */ 
	public int getAsu_type() {
		return asu_type;
	}
    /**
    *订单类型（1：活动订单；其余待定）
	* @param type
    */ 
	public void setAsu_type(int asu_type) {
		this.asu_type = asu_type;
	}
    /**
    *领队是否已经删除(0：默认；1：是；)
	* @return
    */ 
	public int getAsu_leader_is_delete() {
		return asu_leader_is_delete;
	}
    /**
    *领队是否已经删除(0：默认；1：是；)
	* @param type
    */ 
	public void setAsu_leader_is_delete(int asu_leader_is_delete) {
		this.asu_leader_is_delete = asu_leader_is_delete;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<ActiveApplicant> getApplicantList() {
		return applicantList;
	}
	public void setApplicantList(List<ActiveApplicant> applicantList) {
		this.applicantList = applicantList;
	}
	
}
