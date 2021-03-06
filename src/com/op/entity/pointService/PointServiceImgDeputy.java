package com.op.entity.pointService;

import java.io.Serializable;
import java.util.Date;
/** 
 * 地点服务图片(副)(pointServiceImgDeputy)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 14:44:04 
 */  
public class PointServiceImgDeputy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int psi_id;
 	//图片地址
  	 private String psi_url;
 	//上传时间
  	 private Date psi_upload_time;
 	//上传作者id
  	 private String psi_upload_user_id;
 	//地点服务id
  	 private int psi_point_service_id;



	 
    /**
    *id
	* @return
    */ 
	public int getPsi_id() {
		return psi_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPsi_id(int psi_id) {
		this.psi_id = psi_id;
	}
    /**
    *图片地址
	* @return
    */ 
	public String getPsi_url() {
		return psi_url;
	}
    /**
    *图片地址
	* @param type
    */ 
	public void setPsi_url(String psi_url) {
		this.psi_url = psi_url;
	}
    /**
    *上传时间
	* @return
    */ 
	public Date getPsi_upload_time() {
		return psi_upload_time;
	}
    /**
    *上传时间
	* @param type
    */ 
	public void setPsi_upload_time(Date psi_upload_time) {
		this.psi_upload_time = psi_upload_time;
	}
    /**
    *上传作者id
	* @return
    */ 
	public String getPsi_upload_user_id() {
		return psi_upload_user_id;
	}
    /**
    *上传作者id
	* @param type
    */ 
	public void setPsi_upload_user_id(String psi_upload_user_id) {
		this.psi_upload_user_id = psi_upload_user_id;
	}
    /**
    *地点服务id
	* @return
    */ 
	public int getPsi_point_service_id() {
		return psi_point_service_id;
	}
    /**
    *地点服务id
	* @param type
    */ 
	public void setPsi_point_service_id(int psi_point_service_id) {
		this.psi_point_service_id = psi_point_service_id;
	}
	
}
