package com.op.splot.entity;
import java.io.Serializable;

/**
 * 景点级别
 */
public class Spotlevel  implements Serializable {
	 
	
	//columns START
    /**
     * id
     */ 	
	private Integer id;
    /**
     * 名称
     */ 	
	private String name;
    /**
     * 状态（1：正常，0：下线）
     */ 	
	private Integer status;
    /**
     * 更新时间
     */ 	
	private String cdate;
    /**
     * 说明
     */ 	
	private String notes;
	//columns END

 
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	public void setCdate(String value) {
		this.cdate = value;
	}
	
	public String getCdate() {
		return this.cdate;
	}
	public void setNotes(String value) {
		this.notes = value;
	}
	
	public String getNotes() {
		return this.notes;
	}

	
	 
}
 
