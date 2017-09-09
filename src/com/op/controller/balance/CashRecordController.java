package com.op.controller.balance;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.op.controller.BaseController;
import com.op.service.balance.CashRecordService;

 

/** 
 * 账户资金明细表(cashRecord)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-29 17:14:09 
 */ 
@Controller
@RequestMapping(value="/cashRecord")
public class CashRecordController extends BaseController {
	
	@Resource(name="cashRecordServiceImpl")
	private CashRecordService cashRecordServiceImpl;

	
	 
}
