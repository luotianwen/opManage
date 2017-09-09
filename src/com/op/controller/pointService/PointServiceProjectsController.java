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
import com.op.dto.pointService.PointServiceProjectsAuditDTO;
import com.op.dto.pointService.PointServiceProjectsInfoDTO;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointServiceProjectsService;
import com.op.util.Const;
import com.op.util.PropertyFile;

/**
 * 地点服务项目(pointServiceProjects)Controller
 * 
 * @author Win Zhong
 * @version Revision: 1.00 Date: 2016-07-28 11:22:41
 */
@Controller
@RequestMapping(value = "/pointServiceProjects")
public class PointServiceProjectsController extends BaseController {

	@Resource(name = "pointServiceProjectsServiceImpl")
	private PointServiceProjectsService pointServiceProjectsServiceImpl;

	@RequestMapping("/allProjectAudit")
	public ModelAndView allProjectAudit(ModelAndView mv,Page<?> page){
		try {
			List<PointServiceProjectsAuditDTO> list = pointServiceProjectsServiceImpl.findAuditProject(page);
			
			mv.addObject("list", list);
			mv.setViewName("pointService/project/projectcheck");
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
			PointServiceProjectsInfoDTO pointServiceProjectsInfoDTO = pointServiceProjectsServiceImpl.findPointServiceProjectsInfoDTO(id);
			mv.addObject("dto", pointServiceProjectsInfoDTO);
			mv.setViewName("pointService/project/projectinfo");
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
		map.put("psp_id", this.getParameter("psp_id"));
		map.put("psp_update_id", this.getParameter("psp_update_id"));
		map.put("psp_state", this.getParameter("psp_state"));
		map.put("auditNotes", this.getParameter("auditNotes"));
		map.put("userId", users.getuId());
		
		try {
			pointServiceProjectsServiceImpl.auditProject(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			
			String surl = "";
			try {
				Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
				
				surl=prop.get("url")+"/pointServiceProjects/newProject/"+this.getParameter("psp_id");
				URL url = new URL(surl);
				URLConnection rulConnection = url.openConnection();
				HttpURLConnection httpUrlConnection  = (HttpURLConnection) rulConnection;
				httpUrlConnection.setConnectTimeout(300000);
				httpUrlConnection.setReadTimeout(300000);
				httpUrlConnection.connect();
				String code = new Integer(httpUrlConnection.getResponseCode()).toString();
				//String message = httpUrlConnection.getResponseMessage();
				if(!code.startsWith("2")){
					logger.error("访问玩嘛生成新的场馆项目静态页面失败");
				}
				
			}catch(Exception e){
				logger.error("访问玩嘛生成新的场馆项目静态页面异常",e);
			}
			
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "审核项目异常");
			logger.error("审核项目异常", e);
		}
		return map;
	}
	
	
	
}
