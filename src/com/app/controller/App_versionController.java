package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.photo.App_version;
import com.app.service.photo.App_versionService;
import com.op.controller.BaseController;
import com.op.plugin.page.Page;
import com.op.util.Const;

@Controller
@RequestMapping(value="appversion")
public class App_versionController extends BaseController{
	@Resource(name="app_versionServiceImpl")
	private App_versionService app_versionServiceImpl;
	
	/**
	 * 查询所有APP版本
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAllversion")
	public ModelAndView findAllversion(ModelAndView mv,Page<String> page){
		try {
			List<App_version> list = app_versionServiceImpl.findAllversion(page);
			mv.addObject("list", list);
			mv.setViewName("app/version/version");
		} catch (Exception e) {
			logger.error("查询所有APP版本异常！", e);
		}
		return mv;
	}

	/**
	 * 根据ID查询APP版本
	 * @param mv
	 * @param id
	 * @return
	 */
	@RequestMapping("/findversionById")
	public ModelAndView findversionById(ModelAndView mv,String id){
		
		try {
			App_version version = app_versionServiceImpl.findversionById(id);
			mv.addObject("version", version);
			mv.setViewName("app/version/edit");
		} catch (Exception e) {
			logger.error("根据ID查询APP版本异常！", e);
		}
		return mv;
	}
	
	/**
	 * 修改APP版本信息
	 * @param version
	 * @return
	 */
	@RequestMapping("/updateversion")
	@ResponseBody
	public Map<String,String> updateversion(App_version version){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_versionServiceImpl.updateversion(version);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("修改APP版本信息", e);
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改APP版本信息失败，请稍后再试！");
		}
		
		return map;
	}
	
	/**
	 * 新增APP版本信息
	 * @param version
	 * @return
	 */
	@RequestMapping("/saveversion")
	@ResponseBody
	public Map<String,String> saveversion(App_version version){
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			app_versionServiceImpl.saveversion(version);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.error("新增APP版本信息", e);
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "新增APP版本信息失败，请稍后再试！");
		}
		
		return map;
	}
	
	
}
