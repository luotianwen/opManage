package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.photo.App_photocommentDTO;
import com.app.dto.photo.App_photoreplyDTO;
import com.app.service.photo.App_photocommentService;
import com.app.service.photo.App_photoreplyService;
import com.op.plugin.page.Page;
import com.op.util.Const;

@Controller
@RequestMapping("/photocomment")
public class App_photocommentController {

	@Resource(name="app_photocommentServiceImpl")
	public App_photocommentService app_photocommentServiceImpl;
	
	@Resource(name="app_photoreplyServiceImpl")
	public App_photoreplyService app_photoreplyServiceImpl;
	
	@RequestMapping("/findAllComment")
	public ModelAndView findAllComment(ModelAndView mv,Page<String> page){
		try {
			List<App_photocommentDTO> dto = app_photocommentServiceImpl.findAllComment(page);
			mv.addObject("dto", dto);
			mv.setViewName("app/photo/commentList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	@RequestMapping("/findReplyComment")
	@ResponseBody
	public Map<String,Object> findReplyComment(Page<String> page){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<App_photoreplyDTO> dto = app_photoreplyServiceImpl.findReplyComment(page);
			map.put("dto", dto);
			map.put("page", page);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
		}
		return map;
	}
	
	
	
	
}
