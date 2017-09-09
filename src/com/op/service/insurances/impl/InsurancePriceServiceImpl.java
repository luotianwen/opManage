package com.op.service.insurances.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.service.insurances.InsurancePriceService;

/** 
 * 保险价格(InsurancePrice)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:13 
 */  
@Service("insurancePriceServiceImpl")
public class InsurancePriceServiceImpl implements InsurancePriceService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
}
