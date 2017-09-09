package com.op.service.withdrawals.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.op.dao.BaseDao; 
import com.op.service.withdrawals.WithdrawalsAccountService;
/** 
 * 用户提现账户(withdrawalsAccount)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-24 15:11:37 
 */  
@Service("withdrawalsAccountServiceImpl")
public class WithdrawalsAccountServiceImpl implements WithdrawalsAccountService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
}
