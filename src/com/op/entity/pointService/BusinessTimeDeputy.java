package com.op.entity.pointService;

import java.io.Serializable;
import java.util.Date;
/** 
 * 地点服务营业日(副)(businessTimeDeputy)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 14:44:04 
 */  
public class BusinessTimeDeputy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int psabd_id;
 	//营业开始时间
  	 private String psabd_start_date;
 	//营业结束时间
  	 private String psabd_end_date;
 	//地点服务ID
  	 private int psabd_point_service_id;



	 
    /**
    *id
	* @return
    */ 
	public int getPsabd_id() {
		return psabd_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPsabd_id(int psabd_id) {
		this.psabd_id = psabd_id;
	}
    /**
    *营业开始时间
	* @return
    */ 
	public String getPsabd_start_date() {
		return psabd_start_date;
	}
    /**
    *营业开始时间
	* @param type
    */ 
	public void setPsabd_start_date(String psabd_start_date) {
		this.psabd_start_date = psabd_start_date;
	}
    /**
    *营业结束时间
	* @return
    */ 
	public String getPsabd_end_date() {
		return psabd_end_date;
	}
    /**
    *营业结束时间
	* @param type
    */ 
	public void setPsabd_end_date(String psabd_end_date) {
		this.psabd_end_date = psabd_end_date;
	}
    /**
    *地点服务ID
	* @return
    */ 
	public int getPsabd_point_service_id() {
		return psabd_point_service_id;
	}
    /**
    *地点服务ID
	* @param type
    */ 
	public void setPsabd_point_service_id(int psabd_point_service_id) {
		this.psabd_point_service_id = psabd_point_service_id;
	}
	
}
