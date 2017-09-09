package com.op.entity.pointService;

import java.io.Serializable;
import java.util.Date;
/** 
 * 地点项目/套餐适合人群字典表(pointComboCrowdType)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-24 13:42:52 
 */  
public class PointComboCrowdType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private String id;
 	//说明
  	 private String pcct_describe;



	 
    /**
    *id
	* @return
    */ 
	public String getId() {
		return id;
	}
    /**
    *id
	* @param type
    */ 
	public void setId(String id) {
		this.id = id;
	}
    /**
    *说明
	* @return
    */ 
	public String getPcct_describe() {
		return pcct_describe;
	}
    /**
    *说明
	* @param type
    */ 
	public void setPcct_describe(String pcct_describe) {
		this.pcct_describe = pcct_describe;
	}
	
}
