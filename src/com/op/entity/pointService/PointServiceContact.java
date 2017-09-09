package com.op.entity.pointService;

import java.io.Serializable;
import java.util.Date;
/** 
 * 地点服务联系方式(pointServiceContact)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-23 13:55:34 
 */  
public class PointServiceContact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int psc_id;
 	//地点服务id
  	 private int psc_point_service_id;
 	//联系方式
  	 private String psc_number;



	 
    /**
    *id
	* @return
    */ 
	public int getPsc_id() {
		return psc_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPsc_id(int psc_id) {
		this.psc_id = psc_id;
	}
    /**
    *地点服务id
	* @return
    */ 
	public int getPsc_point_service_id() {
		return psc_point_service_id;
	}
    /**
    *地点服务id
	* @param type
    */ 
	public void setPsc_point_service_id(int psc_point_service_id) {
		this.psc_point_service_id = psc_point_service_id;
	}
    /**
    *联系方式
	* @return
    */ 
	public String getPsc_number() {
		return psc_number;
	}
    /**
    *联系方式
	* @param type
    */ 
	public void setPsc_number(String psc_number) {
		this.psc_number = psc_number;
	}
	
}
