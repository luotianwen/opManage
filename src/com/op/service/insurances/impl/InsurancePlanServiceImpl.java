package com.op.service.insurances.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.entity.insurances.InsurancePlan;
import com.op.service.insurances.InsurancePlanService;

/** 
 * 保险计划详情(InsurancePlan)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:13 
 */  
@Service("insurancePlanServiceImpl")
public class InsurancePlanServiceImpl implements InsurancePlanService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	


	/**
	 * 根据保险产品id获取保险计划
	 * @param productId
	 * @return
	 * @throws Exception
	 */
    public List<InsurancePlan> getPlanByproductId(int productId)throws Exception{
    	return (List<InsurancePlan>)dao.findForList("InsurancePlanMapper.findPlanByProductId", productId);
    }
}
