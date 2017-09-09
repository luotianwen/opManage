package com.op.dto.travels;

import java.util.Date;

public class TravelsDTO {
	// id
	private String id;
	// 发布者ID
	private String uName;
	// 游记标题
	private String title;
	// 关联目的地
	private String address;
	// 出发时间
	private Date departure_time;
	// 出行天数
	private int travel_days;
	// 人物
	private String travel_person;
	// 人均费用
	private int per_capita_cost;
	// 发布状态（1：草稿；2：发布审核；3：发布成功；4：审核失败；5：再次审核）
	private String issued_state;
	// 审核人ID
	private String auditor_id;
	// 审核时间
	private Date auditor_time;
	//审核意见
	private String auditNotes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Date departure_time) {
		this.departure_time = departure_time;
	}
	public int getTravel_days() {
		return travel_days;
	}
	public void setTravel_days(int travel_days) {
		this.travel_days = travel_days;
	}
	public String getTravel_person() {
		return travel_person;
	}
	public void setTravel_person(String travel_person) {
		this.travel_person = travel_person;
	}
	public int getPer_capita_cost() {
		return per_capita_cost;
	}
	public void setPer_capita_cost(int per_capita_cost) {
		this.per_capita_cost = per_capita_cost;
	}
	public String getAuditNotes() {
		return auditNotes;
	}
	public void setAuditNotes(String auditNotes) {
		this.auditNotes = auditNotes;
	}
	public String getIssued_state() {
		return issued_state;
	}
	public void setIssued_state(String issued_state) {
		this.issued_state = issued_state;
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
	
}
