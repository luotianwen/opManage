package com.op.dto.point;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.op.dto.pointService.PointAuthDTO;
import com.op.entity.pointService.PointServiceContactDeputy;
import com.op.entity.pointService.PointServiceImgDeputy;
/** 
 * 地点服务基本信息表(副)(pointServiceDeputy)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 14:44:04 
 */  
public class PointServiceDeputyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int ps_id;
 	//地点中文名
  	 private String ps_zh_name;
 	//地点英文名
  	 private String ps_en_name;
 	//终极类型
  	 private String ps_type;
 	//省id
  	 private String ps_province_id;
 	//市id
  	 private String ps_city_id;
 	//区/县id
  	 private String ps_countys_id;
 	//省名
  	 private String ps_province_name;
 	//市名
  	 private String ps_city_name;
 	//区/县名
  	 private String ps_countys_name;
 	//详细地址
  	 private String ps_address;
 	//位置经纬度坐标（保存实例： (纬度,经度））
  	 private String ps_coordinates;
 	//交通
  	 private String ps_traffic;
 	//创建时间
  	 private Date ps_create_time;
 	//创建用户id
  	 private String ps_create_user_id;
 	//创建用户name
  	 private String ps_create_user_name;
 	//发布状态(10：待审核；20：审核中；30：审核成功；40：审核失败；)
  	 private int ps_state;
 	//审核失败备注
  	 private String ps_error_comment;
 	//审核人
  	 private String ps_check_user_id;
 	//审核人
  	 private String ps_check_user_name;
 	//修改地点服务ID
  	 private String ps_point_service_id;
 	//新增标识（0：是：1：否）
  	 private int ps_is_add;
  	 
  	 
  	 
  	 //营业时间
  	 private List<BusinessTimeDeputyDTO> businessTime;
  	 //联系方式
  	 private List<PointServiceContactDeputy> contact;
  	 //图片
  	 private List<PointServiceImgDeputy> imgs;

  	 //认证信息
  	 private PointAuthDTO pointAuthDTO;
	 
    /**
    *id
	* @return
    */ 
	public int getPs_id() {
		return ps_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPs_id(int ps_id) {
		this.ps_id = ps_id;
	}
    /**
    *地点中文名
	* @return
    */ 
	public String getPs_zh_name() {
		return ps_zh_name;
	}
    /**
    *地点中文名
	* @param type
    */ 
	public void setPs_zh_name(String ps_zh_name) {
		this.ps_zh_name = ps_zh_name;
	}
    /**
    *地点英文名
	* @return
    */ 
	public String getPs_en_name() {
		return ps_en_name;
	}
    /**
    *地点英文名
	* @param type
    */ 
	public void setPs_en_name(String ps_en_name) {
		this.ps_en_name = ps_en_name;
	}
    /**
    *终极类型
	* @return
    */ 
	public String getPs_type() {
		return ps_type;
	}
    /**
    *终极类型
	* @param type
    */ 
	public void setPs_type(String ps_type) {
		this.ps_type = ps_type;
	}
    /**
    *省id
	* @return
    */ 
	public String getPs_province_id() {
		return ps_province_id;
	}
    /**
    *省id
	* @param type
    */ 
	public void setPs_province_id(String ps_province_id) {
		this.ps_province_id = ps_province_id;
	}
    /**
    *市id
	* @return
    */ 
	public String getPs_city_id() {
		return ps_city_id;
	}
    /**
    *市id
	* @param type
    */ 
	public void setPs_city_id(String ps_city_id) {
		this.ps_city_id = ps_city_id;
	}
    /**
    *区/县id
	* @return
    */ 
	public String getPs_countys_id() {
		return ps_countys_id;
	}
    /**
    *区/县id
	* @param type
    */ 
	public void setPs_countys_id(String ps_countys_id) {
		this.ps_countys_id = ps_countys_id;
	}
    /**
    *详细地址
	* @return
    */ 
	public String getPs_address() {
		return ps_address;
	}
    /**
    *详细地址
	* @param type
    */ 
	public void setPs_address(String ps_address) {
		this.ps_address = ps_address;
	}
    /**
    *位置经纬度坐标（保存实例： (纬度,经度））
	* @return
    */ 
	public String getPs_coordinates() {
		return ps_coordinates;
	}
    /**
    *位置经纬度坐标（保存实例： (纬度,经度））
	* @param type
    */ 
	public void setPs_coordinates(String ps_coordinates) {
		this.ps_coordinates = ps_coordinates;
	}
    /**
    *交通
	* @return
    */ 
	public String getPs_traffic() {
		return ps_traffic;
	}
    /**
    *交通
	* @param type
    */ 
	public void setPs_traffic(String ps_traffic) {
		this.ps_traffic = ps_traffic;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getPs_create_time() {
		return ps_create_time;
	}
    /**
    *创建时间
	* @param type
    */ 
	public void setPs_create_time(Date ps_create_time) {
		this.ps_create_time = ps_create_time;
	}
    /**
    *创建用户id
	* @return
    */ 
	public String getPs_create_user_id() {
		return ps_create_user_id;
	}
    /**
    *创建用户id
	* @param type
    */ 
	public void setPs_create_user_id(String ps_create_user_id) {
		this.ps_create_user_id = ps_create_user_id;
	}
    /**
    *发布状态(10：待审核；20：审核中；30：审核成功；40：审核失败；)
	* @return
    */ 
	public int getPs_state() {
		return ps_state;
	}
    /**
    *发布状态(10：待审核；20：审核中；30：审核成功；40：审核失败；)
	* @param type
    */ 
	public void setPs_state(int ps_state) {
		this.ps_state = ps_state;
	}
    /**
    *审核失败备注
	* @return
    */ 
	public String getPs_error_comment() {
		return ps_error_comment;
	}
    /**
    *审核失败备注
	* @param type
    */ 
	public void setPs_error_comment(String ps_error_comment) {
		this.ps_error_comment = ps_error_comment;
	}
    /**
    *审核人
	* @return
    */ 
	public String getPs_check_user_id() {
		return ps_check_user_id;
	}
    /**
    *审核人
	* @param type
    */ 
	public void setPs_check_user_id(String ps_check_user_id) {
		this.ps_check_user_id = ps_check_user_id;
	}
    /**
    *修改地点服务ID
	* @return
    */ 
	public String getPs_point_service_id() {
		return ps_point_service_id;
	}
    /**
    *修改地点服务ID
	* @param type
    */ 
	public void setPs_point_service_id(String ps_point_service_id) {
		this.ps_point_service_id = ps_point_service_id;
	}
	public String getPs_province_name() {
		return ps_province_name;
	}
	public void setPs_province_name(String ps_province_name) {
		this.ps_province_name = ps_province_name;
	}
	public String getPs_city_name() {
		return ps_city_name;
	}
	public void setPs_city_name(String ps_city_name) {
		this.ps_city_name = ps_city_name;
	}
	public String getPs_countys_name() {
		return ps_countys_name;
	}
	public void setPs_countys_name(String ps_countys_name) {
		this.ps_countys_name = ps_countys_name;
	}
	public String getPs_create_user_name() {
		return ps_create_user_name;
	}
	public void setPs_create_user_name(String ps_create_user_name) {
		this.ps_create_user_name = ps_create_user_name;
	}
	public String getPs_check_user_name() {
		return ps_check_user_name;
	}
	public void setPs_check_user_name(String ps_check_user_name) {
		this.ps_check_user_name = ps_check_user_name;
	}
	public List<BusinessTimeDeputyDTO> getBusinessTime() {
		return businessTime;
	}
	public void setBusinessTime(List<BusinessTimeDeputyDTO> businessTime) {
		this.businessTime = businessTime;
	}
	public List<PointServiceContactDeputy> getContact() {
		return contact;
	}
	public void setContact(List<PointServiceContactDeputy> contact) {
		this.contact = contact;
	}
	public List<PointServiceImgDeputy> getImgs() {
		return imgs;
	}
	public void setImgs(List<PointServiceImgDeputy> imgs) {
		this.imgs = imgs;
	}
    /**
    *新增标识（0：是：1：否）
	* @return
    */ 
	public int getPs_is_add() {
		return ps_is_add;
	}
    /**
    *新增标识（0：是：1：否）
	* @param type
    */ 
	public void setPs_is_add(int ps_is_add) {
		this.ps_is_add = ps_is_add;
	}
	public PointAuthDTO getPointAuthDTO() {
		return pointAuthDTO;
	}
	public void setPointAuthDTO(PointAuthDTO pointAuthDTO) {
		this.pointAuthDTO = pointAuthDTO;
	}
 
}
