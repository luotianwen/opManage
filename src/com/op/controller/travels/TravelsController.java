package com.op.controller.travels;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
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
import com.op.dto.travels.TravelsDTO;
import com.op.dto.travels.TravelsSearchDTO;
import com.op.plugin.page.Page;
import com.op.service.travels.TravelsService;
import com.op.util.Const;
import com.op.util.PropertyFile;

/** 
 * 游记(travels)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-04-18 14:30:31 
 */ 
@Controller
@RequestMapping(value="/travels")
public class TravelsController extends BaseController {
	@Resource(name="travelsServiceImpl")
	private TravelsService travelsServiceImpl;
	
	/**
	 * 游记审核列表
	 * @param mv
	 * @param page
	 * @param travelsSearchDTO
	 * @return
	 */
	@RequestMapping("/examineTravels")
	public ModelAndView examineTravels(ModelAndView mv,Page<Map<String,Object>> page,TravelsSearchDTO travelsSearchDTO){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type", "examine");
		map.put("travelsSearchDTO", travelsSearchDTO);
		try {
			page.setT(map);
			List<TravelsDTO> travels = travelsServiceImpl.findTravelsAllPage(page);
			mv.addObject("travels",travels);
			mv.setViewName("admin/travels/travels");
			
		} catch (Exception e) {
			logger.error("游记审核异常", e);
		}
		return mv;
	}
	
	/**
	 *根据游记ID查看待审核游记详细信息
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/examine/{id}")
	public ModelAndView getExamineTravels(ModelAndView mv,@PathVariable("id") String id) throws Exception{
		Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
		mv.addObject("url", prop.get("url"));
		mv.addObject("id", id);
		mv.setViewName("admin/travels/examine");
		return mv;
	}
	
	/**
	 * 审核游记
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/examine")
	@ResponseBody
	public Map<String, Object> activityExamine(ModelAndView mv) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("id", this.getParameter("id"));
			map.put("issued_state", this.getParameter("issued_state"));
			map.put("auditor_id", this.getSessionUser().getuId());
			map.put("auditor_time", new Date());
			map.put("auditNotes", this.getParameter("auditNotes"));
			travelsServiceImpl.examineTravels(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			
			String surl = "";
			try {
				Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
				surl=prop.get("url")+"/travels/newTravels/"+this.getParameter("id");
				
				URL url = new URL(surl);
				URLConnection rulConnection = url.openConnection();
				HttpURLConnection httpUrlConnection  =  (HttpURLConnection) rulConnection;
				httpUrlConnection.setConnectTimeout(300000);
				httpUrlConnection.setReadTimeout(300000);
				httpUrlConnection.connect();
				String code = new Integer(httpUrlConnection.getResponseCode()).toString();
				//String message = httpUrlConnection.getResponseMessage();
				if(!code.startsWith("2")){
					logger.error("访问玩嘛生成新的游记静态页面失败");
				}
				
			}catch(Exception e){
				logger.error("访问玩嘛生成新的游记静态页面异常",e);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新异常");
		}
		return map;
	}
	
	/**
	 * 获取审核成功的游记列表
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/manageTravels")
	public ModelAndView manageTravels(ModelAndView mv,Page<Map<String,Object>> page,TravelsSearchDTO travelsSearchDTO){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type", "manage");
		map.put("travelsSearchDTO", travelsSearchDTO);
		try {
			page.setT(map);
			List<TravelsDTO> travels = travelsServiceImpl.findTravelsAllPage(page);
			mv.addObject("travels",travels);
			
			Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
			mv.addObject("url", prop.get("url"));
			
			mv.setViewName("admin/travels/manage");
			
		} catch (Exception e) {
			logger.error("游记审核异常", e);
		}
		return mv;
	}
	
	
}
