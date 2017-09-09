package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.photo.App_report;
import com.app.service.photo.App_reportService;
import com.op.controller.BaseController;
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * 举报用户(app_report)Controller
 * @author sen 
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */ 
@Controller
@RequestMapping(value="/report")
public class App_reportController extends BaseController {
	
	@Resource(name="app_reportServiceImpl")
	private App_reportService app_reportServiceImpl;

	/**
	 * 查询所有举报用户
	 */
	@RequestMapping("/findAllReport")
	public ModelAndView findAllReport(ModelAndView mv,Page<String> page){
		try {
			List<App_report> list = app_reportServiceImpl.findAllReport(page);
			mv.addObject("list", list);
			mv.setViewName("app/report/report");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 根据ID查询举报用户
	 */
	@RequestMapping("/findReportById")
	public ModelAndView findReportById(ModelAndView mv,String id){
		try {
			Map<String,String> map = new HashMap<String,String>();
			App_report report = app_reportServiceImpl.findReportById(map,id);
			
			mv.addObject("report", report);
			mv.addObject("map", map);
			mv.setViewName("app/report/edit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 修改举报用户
	 */
	@RequestMapping("/updateReport")
	@ResponseBody
	public Map<String,String> updateReport(App_report app_report){
		Map<String,String> map = new HashMap<String,String>();
		
		app_report.setR_deal_user(this.getSessionUser().getuId());
		try {
			app_reportServiceImpl.updateReport(app_report);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改举报用户信息失败，请稍后再试！");
		}
		
		return map;
	}
	
	/**
	 * 新增举报用户
	 * @param report
	 */
	@RequestMapping("/report")
	@ResponseBody
	public void report(App_report report){
		report.setR_cuser(this.getSessionUser().getuId());
		try {
			app_reportServiceImpl.report(report);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
