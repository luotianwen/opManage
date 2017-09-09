package com.op.dto.pointService;

import java.util.Date;

public class PointServiceProjectsAuditDTO {
	// 场馆ID
	private String ps_id;
	// 中文名
	private String ps_zh_name;

	// 项目id
	private int psp_id;
	// 项目名称
	private String psp_item_name;
	// 项目原价
	private double psp_item_price;
	// 项目打折价
	private double psp_discount_price;
	//创建人
	private String psp_create;
	//创建时间
	private Date psp_create_time;
	//项目状态(0:待审核;1:审核成功;2:审核失败)
	private String psp_state;
	//修改关联ID（标识多条数据为历史备份数据）
	private String psp_update_id;
	
	public String getPs_id() {
		return ps_id;
	}
	public void setPs_id(String ps_id) {
		this.ps_id = ps_id;
	}
	public String getPs_zh_name() {
		return ps_zh_name;
	}
	public void setPs_zh_name(String ps_zh_name) {
		this.ps_zh_name = ps_zh_name;
	}
	public int getPsp_id() {
		return psp_id;
	}
	public void setPsp_id(int psp_id) {
		this.psp_id = psp_id;
	}
	public String getPsp_item_name() {
		return psp_item_name;
	}
	public void setPsp_item_name(String psp_item_name) {
		this.psp_item_name = psp_item_name;
	}
	public double getPsp_item_price() {
		return psp_item_price;
	}
	public void setPsp_item_price(double psp_item_price) {
		this.psp_item_price = psp_item_price;
	}
	public double getPsp_discount_price() {
		return psp_discount_price;
	}
	public void setPsp_discount_price(double psp_discount_price) {
		this.psp_discount_price = psp_discount_price;
	}
	public String getPsp_create() {
		return psp_create;
	}
	public void setPsp_create(String psp_create) {
		this.psp_create = psp_create;
	}
	public Date getPsp_create_time() {
		return psp_create_time;
	}
	public void setPsp_create_time(Date psp_create_time) {
		this.psp_create_time = psp_create_time;
	}
	public String getPsp_state() {
		return psp_state;
	}
	public void setPsp_state(String psp_state) {
		this.psp_state = psp_state;
	}
	public String getPsp_update_id() {
		return psp_update_id;
	}
	public void setPsp_update_id(String psp_update_id) {
		this.psp_update_id = psp_update_id;
	}
	
	
}
