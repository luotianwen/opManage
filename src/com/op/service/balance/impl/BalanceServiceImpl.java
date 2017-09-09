package com.op.service.balance.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.dto.balance.BalanceDTO;
import com.op.plugin.page.Page;
import com.op.service.balance.BalanceService;

/** 
 * 用户资金账户余额表(balance)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-25 13:42:49 
 */  
@Service("balanceServiceImpl")
public class BalanceServiceImpl implements BalanceService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据账户id获取用户余额信息
	 * @param userId
	 * @return
	 */
	public BalanceDTO getBalanceById(String id)throws Exception{
		return (BalanceDTO)dao.findForObject("balanceMapper.getBalanceById", id);
	}
	/**
	 * 禁用启用用户资金账户
	 * @param map
	 */
	public int isEnable(Map<String, Object> map)throws Exception{
		return (int)dao.update("balanceMapper.isEnable", map);
	}
	/**
	 * 获取用户资金列表
	 * @param page
	 * @return
	 */
	public List<BalanceDTO> getBalanceList(Page<BalanceDTO> page)throws Exception{
		return (List<BalanceDTO>)dao.findForList("balanceMapper.getBalanceListPage", page);
	}

	
	 
}
