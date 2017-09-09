package com.app.dto.feedback;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.app.entity.feedback.App_feedback_photo;

/**
 * APP反馈(app_feedback)实体类
 * 
 * @author sen
 * @version Revision: 1.00 Date: 2016-11-03 10:55:45
 */
public class App_feedbackDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	private int f_id;
	// 反馈内容
	private String f_content;
	// 反馈用户
	private String f_user_id;
	// 联系方式
	private String f_linkman;
	// 创建时间
	private Date f_create_time;
	// 处理人
	private String f_deal_user;
	// 处理状态（1：未处理；2：已处理）
	private String f_deal_result;
	// 处理时间
	private Date f_deal_time;
	// 处理备注
	private String f_deal_remark;

	//反馈图片
	private List<App_feedback_photo> photos;
	
	/**
	 * id
	 * 
	 * @return
	 */
	public int getF_id() {
		return f_id;
	}

	/**
	 * id
	 * 
	 * @param type
	 */
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	/**
	 * 反馈内容
	 * 
	 * @return
	 */
	public String getF_content() {
		return f_content;
	}

	/**
	 * 反馈内容
	 * 
	 * @param type
	 */
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}

	/**
	 * 反馈用户
	 * 
	 * @return
	 */
	public String getF_user_id() {
		return f_user_id;
	}

	/**
	 * 反馈用户
	 * 
	 * @param type
	 */
	public void setF_user_id(String f_user_id) {
		this.f_user_id = f_user_id;
	}

	/**
	 * 联系方式
	 * 
	 * @return
	 */
	public String getF_linkman() {
		return f_linkman;
	}

	/**
	 * 联系方式
	 * 
	 * @param type
	 */
	public void setF_linkman(String f_linkman) {
		this.f_linkman = f_linkman;
	}

	/**
	 * 创建时间
	 * 
	 * @return
	 */
	public Date getF_create_time() {
		return f_create_time;
	}

	/**
	 * 创建时间
	 * 
	 * @param type
	 */
	public void setF_create_time(Date f_create_time) {
		this.f_create_time = f_create_time;
	}

	/**
	 * 处理人
	 * 
	 * @return
	 */
	public String getF_deal_user() {
		return f_deal_user;
	}

	/**
	 * 处理人
	 * 
	 * @param type
	 */
	public void setF_deal_user(String f_deal_user) {
		this.f_deal_user = f_deal_user;
	}

	/**
	 * 处理状态（1：未处理；2：已处理）
	 * 
	 * @return
	 */
	public String getF_deal_result() {
		return f_deal_result;
	}

	/**
	 * 处理状态（1：未处理；2：已处理）
	 * 
	 * @param type
	 */
	public void setF_deal_result(String f_deal_result) {
		this.f_deal_result = f_deal_result;
	}

	/**
	 * 处理时间
	 * 
	 * @return
	 */
	public Date getF_deal_time() {
		return f_deal_time;
	}

	/**
	 * 处理时间
	 * 
	 * @param type
	 */
	public void setF_deal_time(Date f_deal_time) {
		this.f_deal_time = f_deal_time;
	}

	/**
	 * 处理备注
	 * 
	 * @return
	 */
	public String getF_deal_remark() {
		return f_deal_remark;
	}

	/**
	 * 处理备注
	 * 
	 * @param type
	 */
	public void setF_deal_remark(String f_deal_remark) {
		this.f_deal_remark = f_deal_remark;
	}

	/**
	 * 反馈图片
	 * @return
	 */
	public List<App_feedback_photo> getPhotos() {
		return photos;
	}

	/**
	 * 反馈图片
	 * @return
	 */
	public void setPhotos(List<App_feedback_photo> photos) {
		this.photos = photos;
	}

}
