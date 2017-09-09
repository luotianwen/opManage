package com.op.splot.service;

import java.util.List;
import java.util.Map;

import com.op.plugin.page.Page;
import com.op.splot.dto.splot.SearchVO;
import com.op.splot.dto.splot.SpotOrderInfoDTO;
/** 
 * 景点订单(s_order)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-09-21 13:40:39 
 */  
public interface S_orderService {

	/**
     * 查询用户所有订单信息
     * @param user_id   用户id
     * @param orderId   订单id
     * @return
     * @throws Exception
     */
	List<SpotOrderInfoDTO> getAllUserOrder(Page<Map<String,Object>> page)throws Exception;
	
	/**
	 * 查看订单详情
	 * @param userId 用户ID
	 * @param id 订单ID
	 * @return
	 * @throws Exception
	 */
	SpotOrderInfoDTO findUserOrderInfo(String userId,String id) throws Exception;

    List<SpotOrderInfoDTO> spotMoneyList(SearchVO searchVO) throws Exception;
}
