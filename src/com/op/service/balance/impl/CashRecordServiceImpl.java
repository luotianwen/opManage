package com.op.service.balance.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.dto.balance.CashRecordDTO;
import com.op.plugin.page.Page;
import com.op.service.balance.CashRecordService;

/** 
 * 账户资金明细表(cashRecord)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-25 13:42:49 
 */  
@Service("cashRecordServiceImpl")
public class CashRecordServiceImpl implements CashRecordService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据用户资金账户ID获取收支明细
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CashRecordDTO> getCashRecordListPageByBalanceId(Page<?> page)throws Exception{
		return (List<CashRecordDTO>)dao.findForList("cashRecordMapper.getCashRecordListPageByBalanceId", page);
	}
}
