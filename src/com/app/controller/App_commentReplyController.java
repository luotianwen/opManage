package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.photo.App_commentReplyDTO;
import com.app.dto.photo.App_photocommentDTO;
import com.app.dto.photo.App_photoreplyDTO;
import com.app.service.photo.App_commentReplyService;
import com.app.service.photo.App_photocommentService;
import com.app.service.photo.App_photoreplyService;
import com.op.plugin.page.Page;
import com.op.util.Const;

@Controller
@RequestMapping("/commentReply")
public class App_commentReplyController {

	@Resource(name="app_commentReplyServiceImpl")
	public App_commentReplyService app_commentReplyServiceImpl;
	
	@RequestMapping("/findAllComment")
	public ModelAndView findAllComment(ModelAndView mv,Page<String> page){
		try {
			List<App_commentReplyDTO> dto = app_commentReplyServiceImpl.findReplyComment(page);
			mv.addObject("dto", dto);
			mv.setViewName("app/photo/commentList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 删除回复
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteReply")
	@ResponseBody
	public Map<String,String> deleteReply(String id){
		Map<String,String> map = new HashMap<String,String>();
		try {
			app_commentReplyServiceImpl.deleteReply(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "删除回复失败，请稍后再试！");
		}
		return map;
	}
	
}
