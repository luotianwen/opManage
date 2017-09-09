package com.op.service.withdrawals;

import java.util.List;
import java.util.Map;

import com.op.entity.users.Users;
import com.op.entity.withdrawals.CashWithdrawals;
import com.op.plugin.page.Page;
/** 
 * 用户资金提现申请表(cashWithdrawals)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-25 09:36:36 
 */  
public interface CashWithdrawalsService {

	/**
	 * 获取提现申请列表
	 * @param page
	 * @return
	 */
	List<CashWithdrawals> getListPage(Page<CashWithdrawals> page)throws Exception;

	/**
	 * 根据Id获取申请详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	CashWithdrawals findCashWithdrawalsById(String id)throws Exception;


	/**
	 * 修改提现状态
	 * 提现状态（1：提交申请；2：财务处理；3：提现完成；4：提现失败；）
	 * @param id
	 * @param state
	 * @param user
	 * @throws Exception
	 */
	void updateCashWithdrawalsState(String id,int state,Users user)throws Exception;

	/**
	 * 修改提现状态
	 * 提现状态（1：提交申请；2：财务处理；3：提现完成；4：提现失败；）
	 * @param map
	 * @throws Exception
	 */
	void updateCashWithdrawalsState(Map<String,Object> map)throws Exception;
	
}
