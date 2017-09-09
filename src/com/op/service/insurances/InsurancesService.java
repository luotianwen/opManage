package com.op.service.insurances;

import java.util.List;
import java.util.Map;

import com.op.dto.insurances.InsurancesDTO;
import com.op.plugin.page.Page;
/** 
 * 保险信息(Insurances)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:09 
 */  
public interface InsurancesService {

	/**
	 * 初始化保险信息
	 * @param user_id  操作用户ID
	 * @throws Exception
	 */
    void initInsurances(String user_id)throws Exception;

	/**
	 * 修改保险信息
	 * @param map
	 * @throws Exception
	 */
    void updateInsurances(Map<String,Object> map)throws Exception;

    /**
     * 获取保险列表
     * @param page
     * @return
     */
	List<InsurancesDTO> getInsurances(Page<Object> page)throws Exception;

    /**
     * 根据保险产品ID获取保险详细信息
     * @param productId
     * @return
     * @throws Exception
     */
	InsurancesDTO findInsurancesById(int productId)throws Exception;

	/**
	 * 禁用启用保险
	 * @param map
	 * @throws Exception
	 */
	void isEnable(Map<String, Object> map)throws Exception;

	
}
