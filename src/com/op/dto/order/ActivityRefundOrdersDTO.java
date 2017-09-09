package com.op.dto.order;

import java.io.Serializable;
import java.util.Date;
/**
 * 活动退款订单DTO 
 * @author WinZhong
 *
 */
public class ActivityRefundOrdersDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String asu_id;
 	//订单备注
  	 private String asu_order_area;
 	//报名联系人手机号码
  	 private String asu_link_user_phone;
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
 	//报名时间
  	 private Date asu_create_time;
 	//创建用户ID
  	 private String asu_user_id; 
 	//报名状态（10：等待领队确认；20：领队已确认；30：交易完成；40：报名已取消；50：等待领队确认取消；）
  	 private int asu_state;
 	//是否申请退款（0：默认；1：是；）
  	 private int aa_refund_flag;
 	//退款状态（80：等待领队确认；90：等待用户确认；100：等待退款到账；110：退款关闭；120：等待客服处理；130：退款完成）
  	 private int aa_refund_state;
 	//退款总额
  	 private Double aa_refund_price;
 	//申请退款时间
  	 private Date aa_refund_time;
 	//退款操作人(财务)
  	 private String aa_refund_user;
 	//退款备注
  	 private String aa_refund_area;
 	//领队退款备注
  	 private String aa_leader_refund_area;
 	//退款批次号
  	 private String refund_batch_number;
 	//退款时间（后台操作退款生成的时间）
  	 private Date aa_refund_date;
 	//报名联系人（1：是；2：不是）
  	 private int aa_signup_linkman;

  	//报名活动名称
   	 private String title;
  	//报名用户名
   	 private String userName;

	 
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
    *是否申请退款（0：默认；1：是；）
	* @return
    */ 
	public int getAa_refund_flag() {
		return aa_refund_flag;
	}
    /**
    *是否申请退款（0：默认；1：是；）
	* @param type
    */ 
	public void setAa_refund_flag(int aa_refund_flag) {
		this.aa_refund_flag = aa_refund_flag;
	}
    /**
    *退款状态（80：等待领队确认；90：等待用户确认；100：等待退款到账；110：退款关闭；120：等待客服处理；130：退款完成）
	* @return
    */ 
	public int getAa_refund_state() {
		return aa_refund_state;
	}
    /**
    *退款状态（80：等待领队确认；90：等待用户确认；100：等待退款到账；110：退款关闭；120：等待客服处理；130：退款完成）
	* @param type
    */ 
	public void setAa_refund_state(int aa_refund_state) {
		this.aa_refund_state = aa_refund_state;
	}
    /**
    *退款总额
	* @return
    */ 
	public Double getAa_refund_price() {
		return aa_refund_price;
	}
    /**
    *退款总额
	* @param type
    */ 
	public void setAa_refund_price(Double aa_refund_price) {
		this.aa_refund_price = aa_refund_price;
	}
    /**
    *申请退款时间
	* @return
    */ 
	public Date getAa_refund_time() {
		return aa_refund_time;
	}
    /**
    *申请退款时间
	* @param type
    */ 
	public void setAa_refund_time(Date aa_refund_time) {
		this.aa_refund_time = aa_refund_time;
	}
    /**
    *退款操作人(财务)
	* @return
    */ 
	public String getAa_refund_user() {
		return aa_refund_user;
	}
    /**
    *退款操作人(财务)
	* @param type
    */ 
	public void setAa_refund_user(String aa_refund_user) {
		this.aa_refund_user = aa_refund_user;
	}
    /**
    *退款备注
	* @return
    */ 
	public String getAa_refund_area() {
		return aa_refund_area;
	}
    /**
    *退款备注
	* @param type
    */ 
	public void setAa_refund_area(String aa_refund_area) {
		this.aa_refund_area = aa_refund_area;
	}
    /**
    *领队退款备注
	* @return
    */ 
	public String getAa_leader_refund_area() {
		return aa_leader_refund_area;
	}
    /**
    *领队退款备注
	* @param type
    */ 
	public void setAa_leader_refund_area(String aa_leader_refund_area) {
		this.aa_leader_refund_area = aa_leader_refund_area;
	}
    /**
    *退款批次号
	* @return
    */ 
	public String getRefund_batch_number() {
		return refund_batch_number;
	}
    /**
    *退款批次号
	* @param type
    */ 
	public void setRefund_batch_number(String refund_batch_number) {
		this.refund_batch_number = refund_batch_number;
	}
    /**
    *退款时间（后台操作退款生成的时间）
	* @return
    */ 
	public Date getAa_refund_date() {
		return aa_refund_date;
	}
    /**
    *退款时间（后台操作退款生成的时间）
	* @param type
    */ 
	public void setAa_refund_date(Date aa_refund_date) {
		this.aa_refund_date = aa_refund_date;
	}
    /**
    *报名联系人（1：是；2：不是）
	* @return
    */ 
	public int getAa_signup_linkman() {
		return aa_signup_linkman;
	}
    /**
    *报名联系人（1：是；2：不是）
	* @param type
    */ 
	public void setAa_signup_linkman(int aa_signup_linkman) {
		this.aa_signup_linkman = aa_signup_linkman;
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
	
}
