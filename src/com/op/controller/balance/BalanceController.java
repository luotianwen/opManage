package com.op.controller.balance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.dto.balance.BalanceDTO;
import com.op.dto.balance.CashRecordDTO;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.balance.BalanceService;
import com.op.service.balance.CashRecordService;
import com.op.util.Const;

/** 
 * 用户资金账户余额表(balance)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-29 17:14:09 
 */ 
@Controller
@RequestMapping(value="/user/balance")
public class BalanceController extends BaseController {
	
	@Resource(name="balanceServiceImpl")
	private BalanceService balanceServiceImpl;
	
	@Resource(name="cashRecordServiceImpl")
	private CashRecordService cashRecordServiceImpl;
	
	/**
	 * 获取用户资金列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list")
	public ModelAndView list(ModelAndView mv,Page<BalanceDTO> page,BalanceDTO balance)throws Exception{
		page.setT(balance);
		List<BalanceDTO> balanceList = balanceServiceImpl.getBalanceList(page);
		mv.addObject("balanceList",balanceList);
		mv.setViewName("balance/balance");
		return mv;
	} 
	/**
	 * 禁用启用用户资金账户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="isEnable")
	@ResponseBody
	public Map<String,Object> isEnable(){
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			Users user = this.getSessionUser();
			 map.put("user_id", user.getuId());
			 map.put("id", this.getParameter("id"));
			 int count = balanceServiceImpl.isEnable(map);
			 map.clear(); 
			 if(0 == count){
				 map.put(Const.RESPONSE_STATE, 500);
				 map.put(Const.ERROR_INFO, "更新失败");
			 }else{
				 map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("禁用启用用户资金账户失败:", e);
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "禁用启用用户资金账户失败！");
		}
		return map;
	}

	/**
	 * 查看用户资金详细信息
	 * @param id
	 * @param mv
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="details/{id}")
	public ModelAndView details(@PathVariable("id") String id,ModelAndView mv,Page<String> page)throws Exception{ 
		BalanceDTO balance = balanceServiceImpl.getBalanceById(id);
		page.setT(id);
		List<CashRecordDTO> cashRecordList = cashRecordServiceImpl.getCashRecordListPageByBalanceId(page);
		mv.addObject("balance",balance);
		mv.addObject("cashRecordList",cashRecordList);
		mv.setViewName("balance/details");
		return mv;
	}

	 
} 
