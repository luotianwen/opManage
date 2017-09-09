package com.op.controller.withdrawals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.users.Users;
import com.op.entity.withdrawals.CashWithdrawals;
import com.op.plugin.page.Page;
import com.op.service.withdrawals.CashWithdrawalsService;
import com.op.util.Const;

/** 
 * 用户资金提现申请表(cashWithdrawals)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-25 13:42:49 
 */ 
@Controller
@RequestMapping(value="/txsq")
public class CashWithdrawalsController extends BaseController {
	
	@Resource(name="cashWithdrawalsServiceImpl")
	private CashWithdrawalsService cashWithdrawalsServiceImpl;

	/**
	  * 获取系统用户列表
	  * @param page
	  * @param users
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="list")
	public ModelAndView sysList(Page<CashWithdrawals> page,CashWithdrawals cashWithdrawals)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		page.setT(cashWithdrawals);
		List<CashWithdrawals> cashWithdrawalsList = cashWithdrawalsServiceImpl.getListPage(page);
		mv.addObject("page",page);
		mv.addObject("cashWithdrawalsList",cashWithdrawalsList);
		mv.setViewName("withdrawals/cashWithdrawals");
		return mv;
	} 
 
	/**
	 * 根据Id获取申请详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="details/{id}")
	public ModelAndView sysList(@PathVariable("id") String id)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		CashWithdrawals  withdrawals = cashWithdrawalsServiceImpl.findCashWithdrawalsById(id);
		//如果是提交申请状态就改为财务处理状态
		if("1".equals(withdrawals.getCw_state())){
			cashWithdrawalsServiceImpl.updateCashWithdrawalsState(id, 2, this.getSessionUser());
		}
		mv.addObject("withdrawals",withdrawals);
		mv.addObject("user",this.getSessionUser());
		mv.setViewName("withdrawals/cashWithdrawalsInfo");
		return mv;
	}
	
	/**
	 * 提现申请处理
	 * @return
	 */
	@RequestMapping(value="handle")
	@ResponseBody
	public Map<String,Object> handle(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Users user = this.getSessionUser();
			map.put("id",this.getParameter("id"));
			map.put("user_id",user.getuId());
			map.put("user_name",user.getuName());
			map.put("cw_state",this.getParameter("cw_state")); 
			map.put("success_message",this.getParameter("success_message"));  
			map.put("success_screenshot",this.getParameter("success_screenshot"));  
			map.put("remarks",this.getParameter("remarks"));  
			cashWithdrawalsServiceImpl.updateCashWithdrawalsState(map); 
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常!!!");
		}
		return map;
	}
}
