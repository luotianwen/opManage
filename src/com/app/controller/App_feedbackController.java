package com.app.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.feedback.App_feedbackDTO;
import com.app.entity.feedback.App_feedback;
import com.app.service.feedback.App_feedbackService;
import com.op.controller.BaseController;
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * APP反馈(app_feedback)Controller
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-11-03 10:55:45 
 */ 
@Controller
@RequestMapping(value="/app_feedback")
public class App_feedbackController extends BaseController {
	
	@Resource(name="app_feedbackServiceImpl")
	private App_feedbackService app_feedbackServiceImpl;

	@RequestMapping(value="/findAllapp_feedback")
	public ModelAndView findAllapp_feedback(Page page,ModelAndView mv){
		try {
			List<App_feedback> list = app_feedbackServiceImpl.findAllapp_feedback(page);
			mv.addObject("list", list);
			mv.addObject("page", page);
			mv.setViewName("app/feedback/feedbackList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value="/findapp_feedbackById")
	@ResponseBody
	public ModelAndView findapp_feedbackById(ModelAndView mv,String id){
		try {
			App_feedbackDTO dto = app_feedbackServiceImpl.findapp_feedbackById(id);
			mv.addObject("feedback", dto);
			mv.setViewName("app/feedback/feedbackEdit");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	@RequestMapping(value="/updateapp_feedback")
	@ResponseBody
	public Map<String,String> updateapp_feedback(App_feedback app_feedback){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, "500");

		try {
			app_feedback.setF_deal_user(this.getSessionUser().getuId());
			app_feedbackServiceImpl.updateapp_feedback(app_feedback);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	
 
}
