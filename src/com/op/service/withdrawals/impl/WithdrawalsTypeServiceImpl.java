package com.op.service.withdrawals.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.withdrawals.WithdrawalsType;
import com.op.plugin.page.Page;
import com.op.service.withdrawals.WithdrawalsTypeService;


@Service("withdrawalsTypeServiceImpl")
public class WithdrawalsTypeServiceImpl implements WithdrawalsTypeService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	 
	/**
	 * 查询所有的提现方式接口
	 * @param page
	 * @return
	 */
	public List<WithdrawalsType> getListPage(Page<WithdrawalsType> page)throws Exception{
		return (List<WithdrawalsType>)dao.findForList("withdrawalsTypeMapper.getListPage", page);
	};
	/**
	 * 修改提现方式的可用状态
	 * @param id
	 */
	public void isAvailable(String id)throws Exception{
		dao.update("withdrawalsTypeMapper.isAvailable", id);
	}
}
