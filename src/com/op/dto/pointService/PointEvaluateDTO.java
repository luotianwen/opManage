package com.op.dto.pointService;

import java.util.Date;
import java.util.List;

import com.op.entity.pointService.PointEvaluateImg;

public class PointEvaluateDTO {

	// id
	private String pse_id;
	// 总体评价星级（1-5星）
	private int pse_star;
	// 评价内容
	private String pse_evaluate_comment;
	// 停车信息(车停哪里了？收费么？)
	private String pse_park_info;
	// 评价人
	private String pse_create_user_id;
	// 评价时间
	private Date pse_create_time;
	// 人均(元)
	private double pse_price;
	// 是否删除(0:否;1:是)
	private int pse_delete;
	// 是否匿名(0:否;1:是)
	private int pse_anonymous;
	//审核人
	private String auditor_id;
	//审核失败备注
	private String audit_notes;
	//审核状态(0:待审核;10:审核中;20:审核成功;30:审核失败)
	private String audit_state;
	//审核时间
	private Date auditor_time;
	
	// 地点服务id
	private int ps_id;
	//场馆中文名
	private String ps_zh_name;
	
	//评论图片
	List<PointEvaluateImg> pointEvaluateImglist;
	
	
	public String getPse_id() {
		return pse_id;
	}
	public void setPse_id(String pse_id) {
		this.pse_id = pse_id;
	}
	public int getPse_star() {
		return pse_star;
	}
	public void setPse_star(int pse_star) {
		this.pse_star = pse_star;
	}
	public String getPse_evaluate_comment() {
		return pse_evaluate_comment;
	}
	public void setPse_evaluate_comment(String pse_evaluate_comment) {
		this.pse_evaluate_comment = pse_evaluate_comment;
	}
	public String getPse_park_info() {
		return pse_park_info;
	}
	public void setPse_park_info(String pse_park_info) {
		this.pse_park_info = pse_park_info;
	}
	public String getPse_create_user_id() {
		return pse_create_user_id;
	}
	public void setPse_create_user_id(String pse_create_user_id) {
		this.pse_create_user_id = pse_create_user_id;
	}
	public Date getPse_create_time() {
		return pse_create_time;
	}
	public void setPse_create_time(Date pse_create_time) {
		this.pse_create_time = pse_create_time;
	}
	public double getPse_price() {
		return pse_price;
	}
	public void setPse_price(double pse_price) {
		this.pse_price = pse_price;
	}
	public int getPse_delete() {
		return pse_delete;
	}
	public void setPse_delete(int pse_delete) {
		this.pse_delete = pse_delete;
	}
	public int getPse_anonymous() {
		return pse_anonymous;
	}
	public void setPse_anonymous(int pse_anonymous) {
		this.pse_anonymous = pse_anonymous;
	}
	public String getAuditor_id() {
		return auditor_id;
	}
	public void setAuditor_id(String auditor_id) {
		this.auditor_id = auditor_id;
	}
	public String getAudit_notes() {
		return audit_notes;
	}
	public void setAudit_notes(String audit_notes) {
		this.audit_notes = audit_notes;
	}
	public String getAudit_state() {
		return audit_state;
	}
	public void setAudit_state(String audit_state) {
		this.audit_state = audit_state;
	}
	public Date getAuditor_time() {
		return auditor_time;
	}
	public void setAuditor_time(Date auditor_time) {
		this.auditor_time = auditor_time;
	}
	public int getPs_id() {
		return ps_id;
	}
	public void setPs_id(int ps_id) {
		this.ps_id = ps_id;
	}
	public String getPs_zh_name() {
		return ps_zh_name;
	}
	public void setPs_zh_name(String ps_zh_name) {
		this.ps_zh_name = ps_zh_name;
	}
	public List<PointEvaluateImg> getPointEvaluateImglist() {
		return pointEvaluateImglist;
	}
	public void setPointEvaluateImglist(List<PointEvaluateImg> pointEvaluateImglist) {
		this.pointEvaluateImglist = pointEvaluateImglist;
	}
	
	
	
}
