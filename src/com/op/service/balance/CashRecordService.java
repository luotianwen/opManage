package com.op.service.balance;

import java.util.List;

import com.op.dto.balance.CashRecordDTO;
import com.op.plugin.page.Page;
/** 
 * 账户资金明细表(cashRecord)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-25 13:42:49 
 */  
public interface CashRecordService {

	/**
	 * 根据用户资金账户ID获取收支明细
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<CashRecordDTO> getCashRecordListPageByBalanceId(Page<?> page)throws Exception;

    

	
}
