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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.op.controller.BaseController;
import com.op.service.withdrawals.WithdrawalsAccountService;

/** 
 * 用户提现账户(withdrawalsAccount)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-24 15:11:37 
 */ 
@Controller
@RequestMapping(value="/withdrawalsAccount")
public class WithdrawalsAccountController extends BaseController {
	
	@Resource(name="withdrawalsAccountServiceImpl")
	private WithdrawalsAccountService withdrawalsAccountServiceImpl;

	 
 
}
