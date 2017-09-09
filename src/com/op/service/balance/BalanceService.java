package com.op.service.balance;

import java.util.List;
import java.util.Map;

import com.op.dto.balance.BalanceDTO;
import com.op.plugin.page.Page;
/** 
 * 用户资金账户余额表(balance)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-25 13:42:49 
 */  
public interface BalanceService {

	/**
	 * 根据账户id获取用户余额信息
	 * @param userId
	 * @return
	 */
	BalanceDTO getBalanceById(String id)throws Exception;
	
	/**
	 * 获取用户资金列表
	 * @param page
	 * @return
	 */
	List<BalanceDTO> getBalanceList(Page<BalanceDTO> page)throws Exception;

	/**
	 * 禁用启用用户资金账户
	 * @param map
	 */
	int isEnable(Map<String, Object> map)throws Exception;


	
}
