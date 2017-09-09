package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.photo.App_forbid_photo;
import com.app.service.photo.App_forbid_photoService;
import com.op.controller.BaseController;
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * 用户禁言(app_forbid_photo)Controller
 * @author sen 
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */ 
@Controller
@RequestMapping(value="/forbidphoto")
public class App_forbid_photoController extends BaseController {
	
	@Resource(name="app_forbid_photoServiceImpl")
	private App_forbid_photoService app_forbid_photoServiceImpl;

	/**
	 * 查询所有用户禁言
	 */
	@RequestMapping("/findAllForbidPhoto")
	public ModelAndView findAllForbidPhoto(ModelAndView mv,Page<String> page){
		try {
			List<App_forbid_photo> list = app_forbid_photoServiceImpl.findAllForbidPhoto(page);
			mv.addObject("list", list);
			mv.setViewName("app/forbidphoto/forbidphoto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 根据ID查询用户禁言
	 */
	@RequestMapping("/findForbidPhotoById")
	@ResponseBody
	public ModelAndView findForbidPhotoById(ModelAndView mv,String id){
		try {
			App_forbid_photo forbid_photo = app_forbid_photoServiceImpl.findForbidPhotoById(id);
			mv.addObject("forbid_photo", forbid_photo);
			mv.setViewName("app/forbidphoto/edit");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 * 用户禁言
	 */
	@RequestMapping("/forbidUser")
	@ResponseBody
	public ModelAndView forbidUser(ModelAndView mv,App_forbid_photo app_forbid_photo){
		mv.addObject("forbid", app_forbid_photo);
		try {
			Map<String,String> map = app_forbid_photoServiceImpl.forbidUser(app_forbid_photo);
			mv.addObject("map", map);
			mv.setViewName("app/photo/report");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.setViewName("500");
		}
		
		return mv;
	}
	
	/**
	 * 新增用户禁言
	 */
	@RequestMapping("/saveForbidPhoto")
	@ResponseBody
	public Map<String,String> saveForbidPhoto(App_forbid_photo app_forbid_photo){
		Map<String,String> map = new HashMap<String,String>();
		app_forbid_photo.setFp_cuser(this.getSessionUser().getuId());
		try {
			app_forbid_photoServiceImpl.saveForbidPhoto(map,app_forbid_photo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "保存失败！");
			map.put(Const.ERROR_INFO, "用户禁言失败，请稍后再试！");
		}
		
		return map;
	}
	
	
	/**
	 * 修改用户禁言
	 */
	@RequestMapping("/updateForbidPhoto")
	@ResponseBody
	public Map<String,String> updateForbidPhoto(App_forbid_photo app_forbid_photo){
		Map<String,String> map = new HashMap<String,String>();
		
		app_forbid_photo.setFp_updateuser(this.getSessionUser().getuId());
		try {
			app_forbid_photoServiceImpl.updateForbidPhoto(app_forbid_photo);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改禁言信息失败，请稍后再试！");
		}
		
		return map;
	}
	
	
}
