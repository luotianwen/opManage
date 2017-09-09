package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.photo.App_classify;
import com.app.service.photo.App_classifyService;
import com.op.controller.BaseController;
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * 照片分类(app_classify)Controller
 * @author sen 
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */ 
@Controller
@RequestMapping(value="/classify")
public class App_classifyController extends BaseController {
	
	@Resource(name="app_classifyServiceImpl")
	private App_classifyService app_classifyServiceImpl;

	/**
	 * 查询所有照片分类
	 */
	@RequestMapping("/findAllClassify")
	public ModelAndView findAllClassify(ModelAndView mv,Page<String> page){
		try {
			List<App_classify> list = app_classifyServiceImpl.findAllClassify(page);
			mv.addObject("list", list);
			mv.setViewName("app/classify/classify");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 根据ID查询照片分类
	 */
	@RequestMapping("/findClassifyById")
	public ModelAndView findClassifyById(ModelAndView mv,String id){
		try {
			App_classify classify = app_classifyServiceImpl.findClassifyById(id);
			mv.addObject("classify", classify);
			mv.setViewName("app/classify/edit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 新增照片分类
	 */
	@RequestMapping("/saveClassify")
	@ResponseBody
	public Map<String,String> saveClassify(App_classify app_Classify){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_classifyServiceImpl.saveClassify(app_Classify);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "新增分类失败，请稍后再试！");
		}
		
		return map;
	}
	
	
	/**
	 * 修改照片分类
	 */
	@RequestMapping("/updateClassify")
	@ResponseBody
	public Map<String,String> updateClassify(App_classify app_Classify){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_classifyServiceImpl.updateClassify(app_Classify);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改分类失败，请稍后再试！");
		}
		
		return map;
	}
	
	/**
	 * 停用照片分类
	 */
	@RequestMapping("/deleteClassify")
	@ResponseBody
	public Map<String,String> deleteClassify(String id,String type){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_classifyServiceImpl.deleteClassify(id,type);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "停用分类失败，请稍后再试！");
		}
		
		return map;
	}
 
}
