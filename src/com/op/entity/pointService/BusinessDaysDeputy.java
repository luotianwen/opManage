package com.op.entity.pointService;

import java.io.Serializable;
import java.util.Date;
/** 
 * 营业日集合(副)(businessDaysDeputy)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 14:44:04 
 */  
public class BusinessDaysDeputy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int psbd_id;
 	//营业日
  	 private String psbd_day;
 	//地点服务ID
  	 private int psbd_point_service_id;
 	//地点服务营业日ID
  	 private int psabd_id;



	 
    /**
    *id
	* @return
    */ 
	public int getPsbd_id() {
		return psbd_id;
	}
    /**
    *id
	* @param type
    */ 
	public void setPsbd_id(int psbd_id) {
		this.psbd_id = psbd_id;
	}
    /**
    *营业日
	* @return
    */ 
	public String getPsbd_day() {
		return psbd_day;
	}
    /**
    *营业日
	* @param type
    */ 
	public void setPsbd_day(String psbd_day) {
		this.psbd_day = psbd_day;
	}
    /**
    *地点服务ID
	* @return
    */ 
	public int getPsbd_point_service_id() {
		return psbd_point_service_id;
	}
    /**
    *地点服务ID
	* @param type
    */ 
	public void setPsbd_point_service_id(int psbd_point_service_id) {
		this.psbd_point_service_id = psbd_point_service_id;
	}
    /**
    *地点服务营业日ID
	* @return
    */ 
	public int getPsabd_id() {
		return psabd_id;
	}
    /**
    *地点服务营业日ID
	* @param type
    */ 
	public void setPsabd_id(int psabd_id) {
		this.psabd_id = psabd_id;
	}
	
}
