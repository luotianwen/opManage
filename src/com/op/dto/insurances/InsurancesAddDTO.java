package com.op.dto.insurances;


public class InsurancesAddDTO {

 	//保障期限ID
 	 private String id;
	//保险产品ID
 	 private int productId;
	//最低保障期限
 	 private String minDeadline;
	//最长保障期限
 	 private String maxDeadline;
	//期限单位（1：天；2：年）
 	 private String unit;
 	//计划ID
  	 private int planId;
 	//产品价格（单位：元）
  	 private String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getMinDeadline() {
		return minDeadline;
	}
	public void setMinDeadline(String minDeadline) {
		this.minDeadline = minDeadline;
	}
	public String getMaxDeadline() {
		return maxDeadline;
	}
	public void setMaxDeadline(String maxDeadline) {
		this.maxDeadline = maxDeadline;
	}
	public int getUnit() {
		return unit.equals("天")?1:2;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
  	 
  	 
}
