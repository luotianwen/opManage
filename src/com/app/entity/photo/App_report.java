package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 举报(app_report)实体类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-18 20:32:44 
 */  
public class App_report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int r_id;
 	//举报人
  	 private String r_cuser;
 	//被举报人
  	 private String r_report_user;
 	//举报时间
  	 private Date r_cdate;
 	//举报原因
  	 private String r_reason;
 	//描述ID
  	 private String pd_id;
 	//评论ID
  	 private String pc_id;
 	//回复ID
  	 private String pr_id;
 	//处理人
  	 private String r_deal_user;
 	//处理时间
  	 private Date r_deal_time;
 	//处理备注
  	 private String r_deal_remark;
 	//处理结果（0：未处理；1：已处理）
  	 private int r_deal_result;

  	 //被举报人昵称
  	 private String r_report_user_name;
  	 
	 
    /**
    *id
	* @return
    */ 
	public int getR_id() {
		return r_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
    /**
    *举报人
	* @return
    */ 
	public String getR_cuser() {
		return r_cuser;
	}
    /**
    *举报人
	* @param type
    */ 
	public void setR_cuser(String r_cuser) {
		this.r_cuser = r_cuser;
	}
    /**
    *被举报人
	* @return
    */ 
	public String getR_report_user() {
		return r_report_user;
	}
    /**
    *被举报人
	* @param type
    */ 
	public void setR_report_user(String r_report_user) {
		this.r_report_user = r_report_user;
	}
    /**
    *举报时间
	* @return
    */ 
	public Date getR_cdate() {
		return r_cdate;
	}
    /**
    *举报时间
	* @param type
    */ 
	public void setR_cdate(Date r_cdate) {
		this.r_cdate = r_cdate;
	}
    /**
    *举报原因
	* @return
    */ 
	public String getR_reason() {
		return r_reason;
	}
    /**
    *举报原因
	* @param type
    */ 
	public void setR_reason(String r_reason) {
		this.r_reason = r_reason;
	}
    /**
    *描述ID
	* @return
    */ 
	public String getPd_id() {
		return pd_id;
	}
    /**
    *描述ID
	* @param type
    */ 
	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}
    /**
    *评论ID
	* @return
    */ 
	public String getPc_id() {
		return pc_id;
	}
    /**
    *评论ID
	* @param type
    */ 
	public void setPc_id(String pc_id) {
		this.pc_id = pc_id;
	}
    /**
    *回复ID
	* @return
    */ 
	public String getPr_id() {
		return pr_id;
	}
    /**
    *回复ID
	* @param type
    */ 
	public void setPr_id(String pr_id) {
		this.pr_id = pr_id;
	}
    /**
    *处理人
	* @return
    */ 
	public String getR_deal_user() {
		return r_deal_user;
	}
    /**
    *处理人
	* @param type
    */ 
	public void setR_deal_user(String r_deal_user) {
		this.r_deal_user = r_deal_user;
	}
    /**
    *处理时间
	* @return
    */ 
	public Date getR_deal_time() {
		return r_deal_time;
	}
    /**
    *处理时间
	* @param type
    */ 
	public void setR_deal_time(Date r_deal_time) {
		this.r_deal_time = r_deal_time;
	}
    /**
    *处理备注
	* @return
    */ 
	public String getR_deal_remark() {
		return r_deal_remark;
	}
    /**
    *处理备注
	* @param type
    */ 
	public void setR_deal_remark(String r_deal_remark) {
		this.r_deal_remark = r_deal_remark;
	}
    /**
    *处理结果
	* @return
    */ 
	public int getR_deal_result() {
		return r_deal_result;
	}
    /**
    *处理结果
	* @param type
    */ 
	public void setR_deal_result(int r_deal_result) {
		this.r_deal_result = r_deal_result;
	}
	public String getR_report_user_name() {
		return r_report_user_name;
	}
	public void setR_report_user_name(String r_report_user_name) {
		this.r_report_user_name = r_report_user_name;
	}
	
}
