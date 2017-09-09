package com.op.controller.pointService;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.dto.pointService.PointEvaluateDTO;
import com.op.dto.pointService.PointServiceProjectsAuditDTO;
import com.op.dto.pointService.PointServiceProjectsInfoDTO;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointEvaluateService;
import com.op.util.Const;

/**
 * 地点服务评价(pointEvaluate)Controller
 * 
 * @author Win Zhong
 * @version Revision: 1.00 Date: 2016-07-28 11:22:41
 */
@Controller
@RequestMapping(value = "/pointEvaluate")
public class PointEvaluateController extends BaseController {

	@Resource(name = "pointEvaluateServiceImpl")
	private PointEvaluateService pointEvaluateServiceImpl;

	
	@RequestMapping("/allEvaluateAudit")
	public ModelAndView allEvaluateAudit(ModelAndView mv,Page<?> page){
		try {
			List<PointEvaluateDTO> list = pointEvaluateServiceImpl.findAuditEvaluate(page);
			
			mv.addObject("list", list);
			mv.setViewName("pointService/pointEvaluate/evaluatecheck");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/details/{id}")
	@ResponseBody
	public ModelAndView details(@PathVariable("id") String id,ModelAndView mv){
		try {
			PointEvaluateDTO pointEvaluateDTO = pointEvaluateServiceImpl.findPointEvaluateDTO(id);
			mv.addObject("dto", pointEvaluateDTO);
			mv.setViewName("pointService/pointEvaluate/evaluateinfo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 审核项目
	 * @param id
	 * @return
	 */
	@RequestMapping("/audit")
	@ResponseBody
	public Map<String,String> audit(String id){
		Map<String,String> map = new HashMap<String,String>();
		
		Users users = this.getSessionUser();
		map.put("pse_id", this.getParameter("pse_id"));
		map.put("audit_state", this.getParameter("audit_state"));
		map.put("audit_notes", this.getParameter("audit_notes"));
		map.put("userId", users.getuId());
		
		try {
			pointEvaluateServiceImpl.auditEvaluate(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "审核点评异常");
			logger.error("审核点评异常", e);
		}
		return map;
	}
	
	
}
