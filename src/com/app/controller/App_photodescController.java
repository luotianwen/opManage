package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.photo.App_photodescDTO;
import com.app.entity.photo.App_photodesc;
import com.app.service.photo.App_photodescService;
import com.op.controller.BaseController;
import com.op.plugin.page.Page;
import com.op.util.Const;

@Controller
@RequestMapping("/photodesc")
public class App_photodescController extends BaseController{
	@Resource(name="app_photodescServiceImpl")
	public App_photodescService app_photodescServiceImpl;
	
	@RequestMapping("/findAllPhotodesc")
	public ModelAndView findAllPhotodesc(ModelAndView mv,Page<App_photodescDTO> page,App_photodescDTO app_photodescDTO){
		if(StringUtils.isEmpty(app_photodescDTO.getPd_status())){
			app_photodescDTO.setPd_status("all");
		}
		page.setT(app_photodescDTO);
		try {
			List<App_photodesc> photos = app_photodescServiceImpl.findAllPhotodesc(page);
			mv.addObject("photos", photos);
				mv.setViewName("app/photo/photo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/examine/{id}")
	public ModelAndView examine(ModelAndView mv,@PathVariable("id") String id){
		try {
			App_photodescDTO dto = app_photodescServiceImpl.findPhotodescById(id);
			mv.addObject("dto", dto);
			mv.setViewName("app/photo/examine");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/examine")
	@ResponseBody
	public Map<String,String> examine(){
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("userId", this.getSessionUser().getuId());
		map.put("pd_id", this.getParameter("pd_id"));
		map.put("pd_status", this.getParameter("pd_status"));
		map.put("pd_auditremark", this.getParameter("pd_auditremark"));
		
		try {
			app_photodescServiceImpl.updatePhotodesc(map);
		} catch (Exception e) {
			map.clear();
			map.put(Const.RESPONSE_STATE, "500");
			logger.error("审核方法异常！！！！！！！", e);
		}
		return map;
	}
	
	
	
}
