package com.op.entity.travels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 游记评论(travelsComment)实体类
 * 
 * @author 世峰户外商城
 * @version Revision: 1.00 Date: 2016-05-05 14:41:12
 */
public class TravelsComment implements Serializable {

	/**
	 * 
	 */
	static final long serialVersionUID = 1L;

	// id
	int tc_id;
	// 评论内容
	String tc_content;
	// 评论时间
	Date tc_createTime;
	// 评论人
	String tc_createUser;
	// 游记ID
	String tc_travelsId;
	// 评论图片地址
	String tc_img;
	// 回复集合
	List<TravelsCommentReply> replys;

	/**
	 * id
	 */
	public int getTc_id() {
		return tc_id;
	}

	public void setTc_id(int tc_id) {
		this.tc_id = tc_id;
	}

	/**
	 * 评论内容
	 */
	public String getTc_content() {
		return tc_content;
	}

	public void setTc_content(String tc_content) {
		this.tc_content = tc_content;
	}

	/**
	 * 评论时间
	 */
	public Date getTc_createTime() {
		return tc_createTime;
	}

	public void setTc_createTime(Date tc_createTime) {
		this.tc_createTime = tc_createTime;
	}

	/**
	 * 评论人
	 */
	public String getTc_createUser() {
		return tc_createUser;
	}

	public void setTc_createUser(String tc_createUser) {
		this.tc_createUser = tc_createUser;
	}

	/**
	 * 游记ID
	 */
	public String getTc_travelsId() {
		return tc_travelsId;
	}

	public void setTc_travelsId(String tc_travelsId) {
		this.tc_travelsId = tc_travelsId;
	}

	/**
	 * 评论图片地址
	 */
	public String getTc_img() {
		return tc_img;
	}

	public void setTc_img(String tc_img) {
		this.tc_img = tc_img;
	}

}
