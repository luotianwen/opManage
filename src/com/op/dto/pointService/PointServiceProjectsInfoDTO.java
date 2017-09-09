package com.op.dto.pointService;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.op.entity.pointService.PointComboCrowdType;
import com.op.entity.pointService.PointProjectsImg;

public class PointServiceProjectsInfoDTO {
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
	// 项目备注
	private String psp_item_comment;
	// 有效期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date psp_validity_date_start;
	// 有效期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date psp_validity_date_end;
	// 能否退款（0：是；1：否）
	private int psp_is_refund;
	// 预约提醒(必填)
	private String psp_appointment;
	// 温馨提示(必填)
	private String psp_reminder;
	// 不可用日期
	private String psp_not_time;
	// 限购限用提醒
	private String psp_limit;
	// 规则提醒
	private String psp_rule;
	// 适用人数
	private String psp_people_number;
	//创建人
	private String psp_create;
	//创建时间
	private Date psp_create_time;
	//项目状态(0:待审核;1:审核成功;2:审核失败)
	private String psp_state;
	//修改关联ID（标识多条数据为历史备份数据）
	private String psp_update_id;
	//审核人
	private String auditor_id; 
	//审核时间
	private Date auditor_time;
	//审核意见
	private String auditNotes;
	
	// 项目图片
	private List<PointProjectsImg> pointProjectsImgList;

	// 适合人群
	private List<PointComboCrowdType> pointComboCrowdTypeList;

	
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

	public String getPsp_item_comment() {
		return psp_item_comment;
	}

	public void setPsp_item_comment(String psp_item_comment) {
		this.psp_item_comment = psp_item_comment;
	}

	public Date getPsp_validity_date_start() {
		return psp_validity_date_start;
	}

	public void setPsp_validity_date_start(Date psp_validity_date_start) {
		this.psp_validity_date_start = psp_validity_date_start;
	}

	public Date getPsp_validity_date_end() {
		return psp_validity_date_end;
	}

	public void setPsp_validity_date_end(Date psp_validity_date_end) {
		this.psp_validity_date_end = psp_validity_date_end;
	}

	public int getPsp_is_refund() {
		return psp_is_refund;
	}

	public void setPsp_is_refund(int psp_is_refund) {
		this.psp_is_refund = psp_is_refund;
	}

	public String getPsp_appointment() {
		return psp_appointment;
	}

	public void setPsp_appointment(String psp_appointment) {
		this.psp_appointment = psp_appointment;
	}

	public String getPsp_reminder() {
		return psp_reminder;
	}

	public void setPsp_reminder(String psp_reminder) {
		this.psp_reminder = psp_reminder;
	}

	public String getPsp_not_time() {
		return psp_not_time;
	}

	public void setPsp_not_time(String psp_not_time) {
		this.psp_not_time = psp_not_time;
	}

	public String getPsp_limit() {
		return psp_limit;
	}

	public void setPsp_limit(String psp_limit) {
		this.psp_limit = psp_limit;
	}

	public String getPsp_rule() {
		return psp_rule;
	}

	public void setPsp_rule(String psp_rule) {
		this.psp_rule = psp_rule;
	}

	public String getPsp_people_number() {
		return psp_people_number;
	}

	public void setPsp_people_number(String psp_people_number) {
		this.psp_people_number = psp_people_number;
	}

	public List<PointProjectsImg> getPointProjectsImgList() {
		return pointProjectsImgList;
	}

	public void setPointProjectsImgList(List<PointProjectsImg> pointProjectsImgList) {
		this.pointProjectsImgList = pointProjectsImgList;
	}

	public List<PointComboCrowdType> getPointComboCrowdTypeList() {
		return pointComboCrowdTypeList;
	}

	public void setPointComboCrowdTypeList(
			List<PointComboCrowdType> pointComboCrowdTypeList) {
		this.pointComboCrowdTypeList = pointComboCrowdTypeList;
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

	public String getAuditor_id() {
		return auditor_id;
	}

	public void setAuditor_id(String auditor_id) {
		this.auditor_id = auditor_id;
	}

	public Date getAuditor_time() {
		return auditor_time;
	}

	public void setAuditor_time(Date auditor_time) {
		this.auditor_time = auditor_time;
	}

	public String getAuditNotes() {
		return auditNotes;
	}

	public void setAuditNotes(String auditNotes) {
		this.auditNotes = auditNotes;
	}

	
}
