package com.app.entity.photo;

import java.io.Serializable;

/**
 * 图片标签(app_label)实体类
 * 
 * @author Win Zhong
 * @version Revision: 1.00 Date: 2016-10-17 16:13:58
 */
public class App_photolabel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ID
	private int pl_id;
	// 描述ID
	private int pd_id;
	// 内容
	private String pl_content;
	// 标签ID
	private int l_id;

	public int getPl_id() {
		return pl_id;
	}

	public void setPl_id(int pl_id) {
		this.pl_id = pl_id;
	}

	public int getPd_id() {
		return pd_id;
	}

	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}

	public String getPl_content() {
		return pl_content;
	}

	public void setPl_content(String pl_content) {
		this.pl_content = pl_content;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

}
