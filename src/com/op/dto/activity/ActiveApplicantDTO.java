package com.op.dto.activity;

import java.io.Serializable;
import java.util.Date;
/** 
 * 订单报名人表(activeApplicant)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-07 13:56:37 
 */  
public class ActiveApplicantDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String aa_id;
 	//操作日志ID
  	 private String aal_id;
 	//订单ID
  	 private String asu_id;
 	//参加人员姓名
  	 private String aa_user_name;
 	//参加人员性别（1：男；2：女）
  	 private int aa_user_sex;
 	//参加人员手机号码
  	 private String aa_user_phone;
 	//参加人员证件类型
  	 private int aa_user_certificates_type;
 	//参加人员证件号码
  	 private String aa_user_certificates_num;
 	//活动ID
  	 private String aa_active_id;
 	//报名状态（10：等待领队确认；20：领队已确认；30：交易完成；40：报名已取消；50：等待领队确认取消；）
  	 private int aa_state;
 	//是否申请退款（0：默认；1：是；）
  	 private int aa_refund_flag;
 	//退款状态（80：等待领队确认；90：等待用户确认；100：等待退款到账；110：退款关闭；120：等待客服处理；130：退款完成）
  	 private int aa_refund_state;
 	//退款总额
  	 private int aa_refund_price;
 	//申请退款时间
  	 private Date aa_refund_time;
 	//最后修改时间
  	 private Date aa_last_update_time;
 	//最后修改用户
  	 private String aa_last_update_user;
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
 	//创建用户ID
  	 private String aa_user_id;
 	//报名时间
  	 private Date aa_create_time;



	 
    /**
    *id
	* @return
    */ 
	public String getAa_id() {
		return aa_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setAa_id(String aa_id) {
		this.aa_id = aa_id;
	}
    /**
    *操作日志ID
	* @return
    */ 
	public String getAal_id() {
		return aal_id;
	}
    /**
    *操作日志ID
	* @param type
    */ 
	public void setAal_id(String aal_id) {
		this.aal_id = aal_id;
	}
    /**
    *订单ID
	* @return
    */ 
	public String getAsu_id() {
		return asu_id;
	}
    /**
    *订单ID
	* @param type
    */ 
	public void setAsu_id(String asu_id) {
		this.asu_id = asu_id;
	}
    /**
    *参加人员姓名
	* @return
    */ 
	public String getAa_user_name() {
		return aa_user_name;
	}
    /**
    *参加人员姓名
	* @param type
    */ 
	public void setAa_user_name(String aa_user_name) {
		this.aa_user_name = aa_user_name;
	}
    /**
    *参加人员性别（1：男；2：女）
	* @return
    */ 
	public int getAa_user_sex() {
		return aa_user_sex;
	}
    /**
    *参加人员性别（1：男；2：女）
	* @param type
    */ 
	public void setAa_user_sex(int aa_user_sex) {
		this.aa_user_sex = aa_user_sex;
	}
    /**
    *参加人员手机号码
	* @return
    */ 
	public String getAa_user_phone() {
		return aa_user_phone;
	}
    /**
    *参加人员手机号码
	* @param type
    */ 
	public void setAa_user_phone(String aa_user_phone) {
		this.aa_user_phone = aa_user_phone;
	}
    /**
    *参加人员证件类型
	* @return
    */ 
	public int getAa_user_certificates_type() {
		return aa_user_certificates_type;
	}
    /**
    *参加人员证件类型
	* @param type
    */ 
	public void setAa_user_certificates_type(int aa_user_certificates_type) {
		this.aa_user_certificates_type = aa_user_certificates_type;
	}
    /**
    *参加人员证件号码
	* @return
    */ 
	public String getAa_user_certificates_num() {
		return aa_user_certificates_num;
	}
    /**
    *参加人员证件号码
	* @param type
    */ 
	public void setAa_user_certificates_num(String aa_user_certificates_num) {
		this.aa_user_certificates_num = aa_user_certificates_num;
	}
    /**
    *活动ID
	* @return
    */ 
	public String getAa_active_id() {
		return aa_active_id;
	}
    /**
    *活动ID
	* @param type
    */ 
	public void setAa_active_id(String aa_active_id) {
		this.aa_active_id = aa_active_id;
	}
    /**
    *报名状态（10：等待领队确认；20：领队已确认；30：交易完成；40：报名已取消；50：等待领队确认取消；）
	* @return
    */ 
	public int getAa_state() {
		return aa_state;
	}
    /**
    *报名状态（10：等待领队确认；20：领队已确认；30：交易完成；40：报名已取消；50：等待领队确认取消；）
	* @param type
    */ 
	public void setAa_state(int aa_state) {
		this.aa_state = aa_state;
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
	public int getAa_refund_price() {
		return aa_refund_price;
	}
    /**
    *退款总额
	* @param type
    */ 
	public void setAa_refund_price(int aa_refund_price) {
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
    *最后修改时间
	* @return
    */ 
	public Date getAa_last_update_time() {
		return aa_last_update_time;
	}
    /**
    *最后修改时间
	* @param type
    */ 
	public void setAa_last_update_time(Date aa_last_update_time) {
		this.aa_last_update_time = aa_last_update_time;
	}
    /**
    *最后修改用户
	* @return
    */ 
	public String getAa_last_update_user() {
		return aa_last_update_user;
	}
    /**
    *最后修改用户
	* @param type
    */ 
	public void setAa_last_update_user(String aa_last_update_user) {
		this.aa_last_update_user = aa_last_update_user;
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
    /**
    *创建用户ID
	* @return
    */ 
	public String getAa_user_id() {
		return aa_user_id;
	}
    /**
    *创建用户ID
	* @param type
    */ 
	public void setAa_user_id(String aa_user_id) {
		this.aa_user_id = aa_user_id;
	}
    /**
    *报名时间
	* @return
    */ 
	public Date getAa_create_time() {
		return aa_create_time;
	}
    /**
    *报名时间
	* @param type
    */ 
	public void setAa_create_time(Date aa_create_time) {
		this.aa_create_time = aa_create_time;
	}
	
}
