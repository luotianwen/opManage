package com.op.service.insurances;

import java.util.List;

import com.op.dto.insurances.InsurancesAddDTO;

/** 
 * 保险保障期限(InsurantDateLimit)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:13 
 */  
public interface InsurantDateLimitService {

	/**
	 * 根据保险产品ID删除价格及保障期限
	 * @param productId
	 * @throws Exception
	 */
    void deleteDateLimitAndPrice(int productId)throws Exception;
	/**
	 * 添加保险期限及价格
	 * @param addList
	 * @throws Exception
	 */
    void saveDateLimitAndPrice(List<InsurancesAddDTO> addList)throws Exception;

	
}
