package com.op.entity.insurances;

import java.io.Serializable;
/** 
 * 保险价格(InsurancePrice)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 16:12:34 
 */  
public class InsurancePrice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private int id;
 	//保险产品ID
  	 private int productId;
 	//期限ID
  	 private int idl_id;
 	//计划ID
  	 private int planId;
 	//产品价格（单位：元）
  	 private String price;



	 
    /**
    *id
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *id
	* @param type
    */ 
	public void setId(int id) {
		this.id = id;
	}
    /**
    *保险产品ID
	* @return
    */ 
	public int getProductId() {
		return productId;
	}
    /**
    *保险产品ID
	* @param type
    */ 
	public void setProductId(int productId) {
		this.productId = productId;
	}
    /**
    *期限ID
	* @return
    */ 
	public int getIdl_id() {
		return idl_id;
	}
    /**
    *期限ID
	* @param type
    */ 
	public void setIdl_id(int idl_id) {
		this.idl_id = idl_id;
	}
    /**
    *计划ID
	* @return
    */ 
	public int getPlanId() {
		return planId;
	}
    /**
    *计划ID
	* @param type
    */ 
	public void setPlanId(int planId) {
		this.planId = planId;
	}
    /**
    *产品价格（单位：元）
	* @return
    */ 
	public String getPrice() {
		return price;
	}
    /**
    *产品价格（单位：元）
	* @param type
    */ 
	public void setPrice(String price) {
		this.price = price;
	}
	
}
