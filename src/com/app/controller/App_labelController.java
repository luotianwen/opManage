package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.photo.App_label;
import com.app.entity.photo.App_photolabel;
import com.app.service.photo.App_labelService;
import com.app.service.photo.App_photolabelService;
import com.op.controller.BaseController;
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * 照片标签(app_label)Controller
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */ 
@Controller
@RequestMapping(value="/label")
public class App_labelController extends BaseController {
	
	@Resource(name="app_labelServiceImpl")
	private App_labelService app_labelServiceImpl;
	
	@Resource(name="app_photolabelServiceImpl")
	private App_photolabelService app_photolabelServiceImpl;

	
	/**
	 * 查询所有照片标签
	 */
	@RequestMapping("/findAllLabel")
	public ModelAndView findAllLabel(ModelAndView mv,Page<String> page){
		try {
			List<App_label> list = app_labelServiceImpl.findAllLabel(page);
			mv.addObject("list", list);
			mv.setViewName("app/label/label");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 根据ID查询照片标签
	 */
	@RequestMapping("/findLabelById")
	public ModelAndView findLabelById(ModelAndView mv,String id){
		try {
			App_label label = app_labelServiceImpl.findLabelById(id);
			mv.addObject("label", label);
			mv.setViewName("app/label/edit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 新增照片标签
	 */
	@RequestMapping("/saveLabel")
	@ResponseBody
	public Map<String,String> saveLabel(App_label app_label){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_labelServiceImpl.saveLabel(app_label,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "新增标签失败，请稍后再试！");
		}
		
		return map;
	}
	
	
	/**
	 * 修改照片标签
	 */
	@RequestMapping("/updateLabel")
	@ResponseBody
	public Map<String,String> updateLabel(App_label app_label){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_labelServiceImpl.updateLabel(app_label,map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改标签失败，请稍后再试！");
		}
		
		return map;
	}
	
	/**
	 * 停用照片标签
	 */
	@RequestMapping("/deleteLabel")
	@ResponseBody
	public Map<String,String> deleteLabel(String id,String type){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_labelServiceImpl.deleteLabel(id,type);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "停用标签失败，请稍后再试！");
		}
		
		return map;
	}
	
	/**
	 * 查询用户自定义标签
	 */
	@RequestMapping("/photoLabel")
	public ModelAndView findAllphotoLabel(ModelAndView mv,Page<String> page){
		try {
			List<App_photolabel> list = app_photolabelServiceImpl.findAllapp_photolabel(page);
			mv.addObject("list", list);
			mv.setViewName("app/label/photolabel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 将用户标签设为系统标签
	 * @param name
	 * @return
	 */
	@RequestMapping("/updatePhotoLabel")
	@ResponseBody
	public Map<String,String> updatePhotoLabel(String name){
		Map<String,String> map = new HashMap<String,String>();
		try {
			app_photolabelServiceImpl.updateapp_photolabel(name, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "设置失败，请稍后再试！");
		}
		
		return map;
	}
	
}
