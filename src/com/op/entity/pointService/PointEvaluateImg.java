package com.op.entity.pointService;

import java.io.Serializable;
import java.util.Date;
/** 
 * 地点服务评价图片表(pointEvaluateImg)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-07-28 11:22:41 
 */  
public class PointEvaluateImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String psei_id;
 	//评价ID
  	 private int psei_venue_evaluate_id;
 	//图片地址
  	 private String psei_img_url;
 	//创建人
  	 private String psei_create_user_id;
 	//创建时间
  	 private Date psei_create_time;



	 
    /**
    *id
	* @return
    */ 
	public String getPsei_id() {
		return psei_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPsei_id(String psei_id) {
		this.psei_id = psei_id;
	}
    /**
    *评价ID
	* @return
    */ 
	public int getPsei_venue_evaluate_id() {
		return psei_venue_evaluate_id;
	}
    /**
    *评价ID
	* @param type
    */ 
	public void setPsei_venue_evaluate_id(int psei_venue_evaluate_id) {
		this.psei_venue_evaluate_id = psei_venue_evaluate_id;
	}
    /**
    *图片地址
	* @return
    */ 
	public String getPsei_img_url() {
		return psei_img_url;
	}
    /**
    *图片地址
	* @param type
    */ 
	public void setPsei_img_url(String psei_img_url) {
		this.psei_img_url = psei_img_url;
	}
    /**
    *创建人
	* @return
    */ 
	public String getPsei_create_user_id() {
		return psei_create_user_id;
	}
    /**
    *创建人
	* @param type
    */ 
	public void setPsei_create_user_id(String psei_create_user_id) {
		this.psei_create_user_id = psei_create_user_id;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getPsei_create_time() {
		return psei_create_time;
	}
    /**
    *创建时间
	* @param type
    */ 
	public void setPsei_create_time(Date psei_create_time) {
		this.psei_create_time = psei_create_time;
	}
	
}
