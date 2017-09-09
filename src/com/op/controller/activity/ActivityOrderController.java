package com.op.controller.activity;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.dto.activity.ActiveSignupDTO;
import com.op.entity.activity.ActiveSignup;
import com.op.plugin.page.Page;
import com.op.service.activity.ActiveSignupService;
/** 
 * 活动发布信息表(activity)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2015-11-30 11:16:49 
 */ 
@Controller
@RequestMapping(value="/ao")
public class ActivityOrderController extends BaseController {
	
	
	// 活动退款订单
	@Resource(name="activeSignupServiceImpl")
	private ActiveSignupService activeSignupServiceImpl;
	
	
	/**
	 * 获取系统所有活动订单
	 * @param page
	 * @param activeSignup
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView getList(Page<ActiveSignup> page,ActiveSignup activeSignup,ModelAndView mv) throws Exception{
		 
		 
		List<ActiveSignupDTO> activeSignupList = activeSignupServiceImpl.getAllOrder(page);
		
		mv.addObject("activeSignupList", activeSignupList);
		mv.setViewName("activity/order/activityOrder");
		return mv;
	}
	
}
