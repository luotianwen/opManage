package com.app.entity.photo;

import java.io.Serializable;

/**
 * 图片分类(app_classify)实体类
 * 
 * @author Win Zhong
 * @version Revision: 1.00 Date: 2016-10-17 16:13:58
 */
public class App_photoclassify implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ID
	private int pc_id;
	// 描述ID
	private int pd_id;
	// 内容
	private String pc_content;
	// 分类ID
	private int c_id;

	public int getPc_id() {
		return pc_id;
	}

	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}

	public int getPd_id() {
		return pd_id;
	}

	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}

	public String getPc_content() {
		return pc_content;
	}

	public void setPc_content(String pc_content) {
		this.pc_content = pc_content;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

}
