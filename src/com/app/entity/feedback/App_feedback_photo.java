package com.app.entity.feedback;

import java.io.Serializable;
import java.util.Date;
/** 
 * 反馈图片(app_feedback_photo)实体类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-11-03 10:55:45 
 */  
public class App_feedback_photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int fp_id;
 	//反馈ID
  	 private int f_id;
 	//图片路径
  	 private String fp_url;



	 
    /**
    *id
	* @return
    */ 
	public int getFp_id() {
		return fp_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setFp_id(int fp_id) {
		this.fp_id = fp_id;
	}
    /**
    *反馈ID
	* @return
    */ 
	public int getF_id() {
		return f_id;
	}
    /**
    *反馈ID
	* @param type
    */ 
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
    /**
    *图片路径
	* @return
    */ 
	public String getFp_url() {
		return fp_url;
	}
    /**
    *图片路径
	* @param type
    */ 
	public void setFp_url(String fp_url) {
		this.fp_url = fp_url;
	}
	
}
