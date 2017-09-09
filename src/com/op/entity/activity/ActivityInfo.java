package com.op.entity.activity;

import java.util.Date;


/**
 * 活动发布信息表(activity)实体类
 * 
 * @author Win Zhong
 * @version Revision: 1.00 Date: 2015-11-30 11:16:49
 */
public class ActivityInfo extends Activity{

 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 发布者名称
	 */
	private String userName;
	// 身份类型（1：个人发布者；2：企业；）
	protected int uType;
 	//审核人
 	 private String auditor;
	//审核时间
 	 private Date auditTime;
	//审核备注
 	 private String auditNotes;
 	 //关闭活动(0：正常；1：申请关闭；2：审核通过；3：审核失败)
 	 private String a_close;
	//活动状态
 	 private int[] states;
 	 private String ch_name;
 	 private String cl_name;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getuType() {
		return uType;
	}

	public void setuType(int uType) {
		this.uType = uType;
	}
    /**
    *审核人
    */ 
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
    /**
    *审核时间
    */ 
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
    /**
    *审核备注
    */ 
	public String getAuditNotes() {
		return auditNotes;
	}
	public void setAuditNotes(String auditNotes) {
		this.auditNotes = auditNotes;
	}

	public int[] getStates() {
		return states;
	}

	public void setStates(int[] states) {
		this.states = states;
	}

	public String getCh_name() {
		return ch_name;
	}

	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}

	public String getCl_name() {
		return cl_name;
	}

	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}

	public String getA_close() {
		return a_close;
	}

	public void setA_close(String a_close) {
		this.a_close = a_close;
	}
	
 
	
}
