package com.op.entity.menu;

import java.io.Serializable;
import java.util.Date;

/**
 * 前台菜单管理(opMenus)实体类
 * 
 * @author 世峰户外商城
 * @version Revision: 1.00 Date: 2016-01-13 15:16:53
 */
public class OpMenus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	private String opm_id;
	// 菜单名称
	private String opm_name;
	// 菜单父ID(0为顶级菜单)
	private String opm_parent_id;
	// 菜单排序
	private int opm_order;
	// 访问路径
	private String opm_path;
	// 最后更新时间
	private Date opm_last_update_time;
	// 操作人
	private String opm_last_update_user;

	/**
	 * id
	 */
	public String getOpm_id() {
		return opm_id;
	}

	public void setOpm_id(String opm_id) {
		this.opm_id = opm_id;
	}

	/**
	 * 菜单名称
	 */
	public String getOpm_name() {
		return opm_name;
	}

	public void setOpm_name(String opm_name) {
		this.opm_name = opm_name;
	}

	/**
	 * 菜单父ID(0为顶级菜单)
	 */
	public String getOpm_parent_id() {
		return opm_parent_id;
	}

	public void setOpm_parent_id(String opm_parent_id) {
		this.opm_parent_id = opm_parent_id;
	}

	/**
	 * 菜单排序
	 */
	public int getOpm_order() {
		return opm_order;
	}

	public void setOpm_order(int opm_order) {
		this.opm_order = opm_order;
	}

	/**
	 * 访问路径
	 */
	public String getOpm_path() {
		return opm_path;
	}

	public void setOpm_path(String opm_path) {
		this.opm_path = opm_path;
	}

	/**
	 * 最后更新时间
	 */
	public Date getOpm_last_update_time() {
		return opm_last_update_time;
	}

	public void setOpm_last_update_time(Date opm_last_update_time) {
		this.opm_last_update_time = opm_last_update_time;
	}

	/**
	 * 操作人
	 */
	public String getOpm_last_update_user() {
		return opm_last_update_user;
	}

	public void setOpm_last_update_user(String opm_last_update_user) {
		this.opm_last_update_user = opm_last_update_user;
	}

}
