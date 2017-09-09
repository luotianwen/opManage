package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;
/** 
 * 图片描述(app_photodesc)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-10-17 16:13:58 
 */  
public class App_photodesc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//ID
  	 private int pd_id;
 	//描述内容
  	 private String pd_content;
 	//坐标
  	 private String pd_coordinate;
  	 //拍摄地址
  	 private String pd_address;
 	//省
  	 private String pd_province;
  	 //市
  	 private String pd_city;
  	 //区
  	 private String pd_district;
 	//创建时间
  	 private Date pd_cdate;
 	//修改时间
  	 private Date pd_udate;
 	//创建用户
  	 private String pd_cuser;
 	//状态(0：待审核；1：审核中；2：审核通过；3：审核失败)
  	 private int pd_status;
 	//删除(0：正常；1：回收站；2：删除)
  	 private int pd_delete;
  	 //照片数量
  	 private int pd_photo_count;
 	//点赞次数
  	 private int pd_like_count;
 	//评论次数
  	 private int pd_comment_count;
 	//收藏人数
  	 private int pd_collect_count;
 	//审核人
  	 private String pd_audituser;
 	//审核时间
  	 private Date pd_audittime;
 	//审核备注
  	 private String pd_auditremark;



	 
    /**
    *ID
	* @return
    */ 
	public int getPd_id() {
		return pd_id;
	}
    /**
    *ID
	* @param type
    */ 
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
    /**
    *描述内容
	* @return
    */ 
	public String getPd_content() {
		return pd_content;
	}
    /**
    *描述内容
	* @param type
    */ 
	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}
    /**
    *坐标
	* @return
    */ 
	public String getPd_coordinate() {
		return pd_coordinate;
	}
    /**
    *坐标
	* @param type
    */ 
	public void setPd_coordinate(String pd_coordinate) {
		this.pd_coordinate = pd_coordinate;
	}
	/**
	 * 拍摄地址
	 * @return
	 */
    public String getPd_address() {
		return pd_address;
	}
    /**
	 * 拍摄地址
	 * @return
	 */
	public void setPd_address(String pd_address) {
		this.pd_address = pd_address;
	}
	/**
     * 省
     * @return
     */
    public String getPd_province() {
		return pd_province;
	}
    /**
     * 省
     * @return
     */
	public void setPd_province(String pd_province) {
		this.pd_province = pd_province;
	}
	/**
     * 市
     * @return
     */
	public String getPd_city() {
		return pd_city;
	}
	/**
     * 市
     * @return
     */
	public void setPd_city(String pd_city) {
		this.pd_city = pd_city;
	}
	/**
     * 区
     * @return
     */
	public String getPd_district() {
		return pd_district;
	}
	/**
     * 区
     * @return
     */
	public void setPd_district(String pd_district) {
		this.pd_district = pd_district;
	}
	/**
    *创建时间
	* @return
    */ 
	public Date getPd_cdate() {
		return pd_cdate;
	}
    /**
    *创建时间
	* @param type
    */ 
	public void setPd_cdate(Date pd_cdate) {
		this.pd_cdate = pd_cdate;
	}
    /**
    *修改时间
	* @return
    */ 
	public Date getPd_udate() {
		return pd_udate;
	}
    /**
    *修改时间
	* @param type
    */ 
	public void setPd_udate(Date pd_udate) {
		this.pd_udate = pd_udate;
	}
    /**
    *创建用户
	* @return
    */ 
	public String getPd_cuser() {
		return pd_cuser;
	}
    /**
    *创建用户
	* @param type
    */ 
	public void setPd_cuser(String pd_cuser) {
		this.pd_cuser = pd_cuser;
	}
    /**
    *状态(0：待审核；1：审核中；2：审核通过；3：审核失败)
	* @return
    */ 
	public int getPd_status() {
		return pd_status;
	}
    /**
    *状态(0：待审核；1：审核中；2：审核通过；3：审核失败)
	* @param type
    */ 
	public void setPd_status(int pd_status) {
		this.pd_status = pd_status;
	}
    /**
    *删除(0：正常；1：回收站；2：删除)
	* @return
    */ 
	public int getPd_delete() {
		return pd_delete;
	}
    /**
    *删除(0：正常；1：回收站；2：删除)
	* @param type
    */ 
	public void setPd_delete(int pd_delete) {
		this.pd_delete = pd_delete;
	}
	/**
	 * 照片数量
	 */
	public int getPd_photo_count() {
		return pd_photo_count;
	}
	/**
	 * 照片数量
	 */
	public void setPd_photo_count(int pd_photo_count) {
		this.pd_photo_count = pd_photo_count;
	}
    /**
    *点赞次数
	* @return
    */ 
	public int getPd_like_count() {
		return pd_like_count;
	}
	/**
    *点赞次数
	* @param type
    */ 
	public void setPd_like_count(int pd_like_count) {
		this.pd_like_count = pd_like_count;
	}
    /**
    *评论次数
	* @return
    */ 
	public int getPd_comment_count() {
		return pd_comment_count;
	}
    /**
    *评论次数
	* @param type
    */ 
	public void setPd_comment_count(int pd_comment_count) {
		this.pd_comment_count = pd_comment_count;
	}
    /**
    *收藏人数
	* @return
    */ 
	public int getPd_collect_count() {
		return pd_collect_count;
	}
    /**
    *收藏人数
	* @param type
    */ 
	public void setPd_collect_count(int pd_collect_count) {
		this.pd_collect_count = pd_collect_count;
	}
    /**
    *审核人
	* @return
    */ 
	public String getPd_audituser() {
		return pd_audituser;
	}
    /**
    *审核人
	* @param type
    */ 
	public void setPd_audituser(String pd_audituser) {
		this.pd_audituser = pd_audituser;
	}
    /**
    *审核时间
	* @return
    */ 
	public Date getPd_audittime() {
		return pd_audittime;
	}
    /**
    *审核时间
	* @param type
    */ 
	public void setPd_audittime(Date pd_audittime) {
		this.pd_audittime = pd_audittime;
	}
    /**
    *审核备注
	* @return
    */ 
	public String getPd_auditremark() {
		return pd_auditremark;
	}
    /**
    *审核备注
	* @param type
    */ 
	public void setPd_auditremark(String pd_auditremark) {
		this.pd_auditremark = pd_auditremark;
	}
	
}
