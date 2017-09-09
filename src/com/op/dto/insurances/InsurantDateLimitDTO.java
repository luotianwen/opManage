package com.op.dto.insurances;

import java.util.List;

import com.op.entity.insurances.InsurancePrice;

public class InsurantDateLimitDTO {

	
	//id
	 private int id;
	//保险产品ID
	 private int productId;
	//最低保障期限
	 private int minDeadline;
	//最长保障期限
	 private int maxDeadline;
	//期限单位（1：天；2：年）
	 private int unit;

	private List<InsurancePrice> priceList;//保险价格
	
	 
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
   *最低保障期限
	* @return
   */ 
	public int getMinDeadline() {
		return minDeadline;
	}
   /**
   *最低保障期限
	* @param type
   */ 
	public void setMinDeadline(int minDeadline) {
		this.minDeadline = minDeadline;
	}
   /**
   *最长保障期限
	* @return
   */ 
	public int getMaxDeadline() {
		return maxDeadline;
	}
   /**
   *最长保障期限
	* @param type
   */ 
	public void setMaxDeadline(int maxDeadline) {
		this.maxDeadline = maxDeadline;
	}
   /**
   *期限单位（1：天；2：年）
	* @return
   */ 
	public int getUnit() {
		return unit;
	}
   /**
   *期限单位（1：天；2：年）
	* @param type
   */ 
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public List<InsurancePrice> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<InsurancePrice> priceList) {
		this.priceList = priceList;
	}
	
	
}
