package com.op.dto.insurances;

import java.util.Date;
import java.util.List;

import com.op.entity.insurances.InsurancePlan;
import com.op.entity.insurances.InsurancePrice;
import com.op.entity.insurances.InsurantDateLimit;

public class InsurancesDTO {

	
	private int productId;// 产品id
	private String productName;// 产品名称
	private String companyName;// 公司名称
 	//承保年龄开始
 	 private int startAge;
	//承保年龄结束
 	 private int endAge;
	private int type;// 产品类型 0：境内旅意险，1：寿险健康险，2：境外旅意险，3：家财险
 	//是否启用(1：启用；2否[玩嘛])
 	 private int isEnable;
	//是否下架（0未下架，1下架[惠泽]）
 	 private int invalid;
	private String userName;//操作用户
	private Date update_time;//操作时间

	private List<InsurancePlan> planList;//保险计划
	private List<InsurantDateLimitDTO> dateLimitList;//保障期限
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<InsurantDateLimitDTO> getDateLimitList() {
		return dateLimitList;
	}
	public void setDateLimitList(List<InsurantDateLimitDTO> dateLimitList) {
		this.dateLimitList = dateLimitList;
	}
	public List<InsurancePlan> getPlanList() {
		return planList;
	}
	public void setPlanList(List<InsurancePlan> planList) {
		this.planList = planList;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getStartAge() {
		return startAge;
	}
	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}
	public int getEndAge() {
		return endAge;
	}
	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}

    /**
    *是否下架（0未下架，1下架[惠泽]）
	* @return
    */ 
	public int getInvalid() {
		return invalid;
	}
    /**
    *是否下架（0未下架，1下架[惠泽]）
	* @param type
    */ 
	public void setInvalid(int invalid) {
		this.invalid = invalid;
	}
	
}
