package com.op.entity.activity;

/**
 * 活动装备(activeEquipment)实体类
 * 
 * @author Yan
 * @version Revision: 1.00 Date: 2015-12-10 10:51:35
 */
public class ActiveEquipment {

	// id
	private int ae_id;
	// 装备名称
	private String ae_name;
	// 装备描述
	private String ae_description;
	// 活动ID
	private int activeId;

	/**
	 * id
	 */
	public int getAe_id() {
		return ae_id;
	}

	public void setAe_id(int ae_id) {
		this.ae_id = ae_id;
	}

	/**
	 * 装备名称
	 */
	public String getAe_name() {
		return ae_name;
	}

	public void setAe_name(String ae_name) {
		this.ae_name = ae_name;
	}

	/**
	 * 装备描述
	 */
	public String getAe_description() {
		return ae_description;
	}

	public void setAe_description(String ae_description) {
		this.ae_description = ae_description;
	}

	/**
	 * 活动ID
	 */
	public int getActiveId() {
		return activeId;
	}

	public void setActiveId(int activeId) {
		this.activeId = activeId;
	}

}
