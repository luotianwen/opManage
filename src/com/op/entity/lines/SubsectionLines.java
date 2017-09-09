package com.op.entity.lines;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 活动线路分段信息表(lines)实体类
 * 
 * @author 世峰户外商城
 * @version Revision: 1.00 Date: 2015-12-14 09:50:55
 */
public class SubsectionLines implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 分段线路ID
	private String l_id;
	// 分段活动描述
	private String l_active_description;
	// 分段活动图片描述
	private String l_active_iamge_description;
	// 分段线路地图标注坐标集合
	private String coordinates;
	// 分段线路名称
	private String l_name;
	// 分段线路描述
	private String l_description;
	// 分段线路特色
	private String l_feature;
	// 分段线路图片描述
	private String l_image_description;
	// 总体线路ID
	private String l_al_id;
	// 分段线路上传时间
	private Date l_create_time;
	// 分段线路上传作者
	private String l_create_user;
	// 分段线路修改时间
	private Date l_update_time;
	// 分段线路修改人
	private String l_update_user;
	// 分段线路起点坐标
	private String l_start_location;
	// 分段线路终点坐标
	private String l_last_location;
	// 交通工具
	private String l_vehicle;
	// 餐饮
	private String l_diet;
	// 住宿
	private String l_accommodation;

	// 图片集合
	private List<LineImages> lineImages;
	
	/**
	 * 图片集合
	 */
	public List<LineImages> getLineImages() {
		return lineImages;
	}

	public void setLineImages(List<LineImages> lineImages) {
		this.lineImages = lineImages;
	}

	/**
	 * 分段线路ID
	 */
	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	/**
	 * 分段活动描述
	 */
	public String getL_active_description() {
		return l_active_description;
	}

	public void setL_active_description(String l_active_description) {
		this.l_active_description = l_active_description;
	}

	/**
	 * 分段活动图片描述
	 */
	public String getL_active_iamge_description() {
		return l_active_iamge_description;
	}

	public void setL_active_iamge_description(String l_active_iamge_description) {
		this.l_active_iamge_description = l_active_iamge_description;
	}

	/**
	 * 分段线路地图标注坐标集合
	 */
	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * 分段线路名称
	 */
	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/**
	 * 分段线路描述
	 */
	public String getL_description() {
		return l_description;
	}

	public void setL_description(String l_description) {
		this.l_description = l_description;
	}

	/**
	 * 分段线路特色
	 */
	public String getL_feature() {
		return l_feature;
	}

	public void setL_feature(String l_feature) {
		this.l_feature = l_feature;
	}

	/**
	 * 分段线路图片描述
	 */
	public String getL_image_description() {
		return l_image_description;
	}

	public void setL_image_description(String l_image_description) {
		this.l_image_description = l_image_description;
	}

	/**
	 * 总体线路ID
	 */
	public String getL_al_id() {
		return l_al_id;
	}

	public void setL_al_id(String l_al_id) {
		this.l_al_id = l_al_id;
	}

	/**
	 * 分段线路上传时间
	 */
	public Date getL_create_time() {
		return l_create_time;
	}

	public void setL_create_time(Date l_create_time) {
		this.l_create_time = l_create_time;
	}

	/**
	 * 分段线路上传作者
	 */
	public String getL_create_user() {
		return l_create_user;
	}

	public void setL_create_user(String l_create_user) {
		this.l_create_user = l_create_user;
	}

	/**
	 * 分段线路修改时间
	 */
	public Date getL_update_time() {
		return l_update_time;
	}

	public void setL_update_time(Date l_update_time) {
		this.l_update_time = l_update_time;
	}

	/**
	 * 分段线路修改人
	 */
	public String getL_update_user() {
		return l_update_user;
	}

	public void setL_update_user(String l_update_user) {
		this.l_update_user = l_update_user;
	}

	/**
	 * 分段线路起点坐标
	 */
	public String getL_start_location() {
		return l_start_location;
	}

	public void setL_start_location(String l_start_location) {
		this.l_start_location = l_start_location;
	}

	/**
	 * 分段线路终点坐标
	 */
	public String getL_last_location() {
		return l_last_location;
	}

	public void setL_last_location(String l_last_location) {
		this.l_last_location = l_last_location;
	}

	/**
	 * 交通工具
	 */
	public String getL_vehicle() {
		return l_vehicle;
	}

	public void setL_vehicle(String l_vehicle) {
		this.l_vehicle = l_vehicle;
	}

	/**
	 * 餐饮
	 */
	public String getL_diet() {
		return l_diet;
	}

	public void setL_diet(String l_diet) {
		this.l_diet = l_diet;
	}

	/**
	 * 住宿
	 */
	public String getL_accommodation() {
		return l_accommodation;
	}

	public void setL_accommodation(String l_accommodation) {
		this.l_accommodation = l_accommodation;
	}

}
