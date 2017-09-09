package com.op.service.withdrawals;

import java.util.List;
import java.util.Map;

import com.op.entity.withdrawals.WithdrawalsType;
import com.op.plugin.page.Page;
/** 
 * 用户提现类型(withdrawalsType)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-24 15:11:37 
 */  
public interface WithdrawalsTypeService {

	/**
	 * 查询所有的提现方式接口
	 * @param page
	 * @return
	 */
	List<WithdrawalsType> getListPage(Page<WithdrawalsType> page)throws Exception;
	/**
	 * 修改提现方式的可用状态
	 * @param id
	 */
	void isAvailable(String id)throws Exception;

    

	
}
