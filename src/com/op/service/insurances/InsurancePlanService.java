package com.op.service.insurances;

import java.util.List;

import com.op.entity.insurances.InsurancePlan;
/** 
 * 保险计划详情(InsurancePlan)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:13 
 */  
public interface InsurancePlanService {

	/**
	 * 根据保险产品id获取保险计划
	 * @param productId
	 * @return
	 * @throws Exception
	 */
    List<InsurancePlan> getPlanByproductId(int productId)throws Exception;

	
}
