package com.op.controller.screening;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.screening.Screening;
import com.op.plugin.page.Page;
import com.op.service.screening.ScreeningService;
import com.op.util.Const;

/** 
 * 筛选条件(screening)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-08-20 13:25:21 
 */ 
@Controller
@RequestMapping(value="/screening")
public class ScreeningController extends BaseController {
	
	@Resource(name="screeningServiceImpl")
	private ScreeningService screeningServiceImpl;

	/**
	 * 查询所有筛选条件
	 * @param mv
	 * @param type
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/findAllScreening")
	public ModelAndView findAllScreening(ModelAndView mv,String type,Page<Map<String,String>> page){
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("sc_modularType", type);
			map.put("sc_parent_id", "0");
			
			page.setT(map);
			List<Screening> list = screeningServiceImpl.findAllScreening(page);
			
			if("pointService".equals(type)){
				mv.addObject("typeName", "场馆");
			}else if("activity".equals(type)){
				mv.addObject("typeName", "活动");
			}else if("splot".equals(type)){
				mv.addObject("typeName", "景点");
			}
			
			mv.addObject("list", list);
			mv.addObject("sc_modularType", type);
			mv.setViewName("screening/screeningList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询所有筛选条件方法异常!!!!!!!!!", e);
		}
		
		return mv;
	}
 
	/**
	 * 查询所有子筛选条件
	 * @param mv
	 * @param type
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/findScreeningByParentId")
	@ResponseBody
	public Map<String,Object> findScreeningByParentId(String type,String parentId){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("sc_modularType", type);
			map.put("sc_parent_id", parentId);
			
			List<Screening> list = screeningServiceImpl.findScreeningByParentId(map);
			
			dataMap.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			dataMap.put("screening",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("查询所有筛选条件方法异常!!!!!!!!!", e);
			dataMap.put(Const.RESPONSE_STATE, "500");
			dataMap.put(Const.ERROR_INFO, "查询子筛选条件错误！请联系相关人员处理！");
		}
		
		return dataMap;
	}
	
	/**
	 * 新增筛选条件
	 * @param screening
	 * @return
	 */
	@RequestMapping("/addScreening")
	@ResponseBody
	public Map<String,String> addScreening(Screening screening){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, "500");
		map.put(Const.ERROR_INFO, "新增筛选条件失败！请联系相关人员处理！");
		
		try {
			screening.setSc_create(this.getSessionUser().getuId());
			screeningServiceImpl.addScreening(screening);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("新增筛选条件方法异常!!!!!!!!!", e);
		}
		
		return map;
	}
	
	/**
	 * 修改筛选条件
	 * @param screening
	 * @return
	 */
	@RequestMapping("/updateScreening")
	@ResponseBody
	public Map<String,String> updateScreening(Screening screening){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, "500");
		
		try {
			screening.setSc_update(this.getSessionUser().getuId());
			screeningServiceImpl.updateScreening(screening);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("修改筛选条件方法异常!!!!!!!!!", e);
		}
		
		return map;
	}
	
	/**
	 * 删除筛选条件
	 * @param screening
	 * @return
	 */
	@RequestMapping("/deleteScreening")
	@ResponseBody
	public Map<String,String> deleteScreening(String id,String sc_modularType){
		Map<String,String> map = new HashMap<String,String>();
		map.put(Const.RESPONSE_STATE, "500");
		
		try {
			screeningServiceImpl.deleteScreening(id,sc_modularType);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("删除筛选条件方法异常!!!!!!!!!", e);
		}
		
		return map;
	}
	
	/**
	 * 跳转新增页面
	 * @param mv
	 * @param type
	 * @return
	 */
	@RequestMapping("/goScreeningAddView")
	public ModelAndView goScreeningAddView(ModelAndView mv,String type){
		try {
			List<Screening> screeningList = screeningServiceImpl.goScreeningAddGetParentList(type);
			mv.addObject("screeningList", screeningList);
			mv.addObject("sc_modularType", type);
			mv.setViewName("screening/screeningAdd");
		} catch (Exception e) {
			logger.error("跳转新增页面方法异常!!!!!!!!!", e);
		}
		return mv;
	}
	
	/**
	 * 跳转修改页面
	 * @param mv
	 * @return
	 */
	@RequestMapping("/goScreeningEditView")
	public ModelAndView goScreeningEditView(ModelAndView mv,String scId){
		try {
			Screening screening = screeningServiceImpl.findScreeningById(scId);
			
			mv.addObject("screening", screening);
			mv.setViewName("screening/screeningEdit");
		} catch (Exception e) {
			logger.error("跳转编辑页面方法异常!!!!!!!!!", e);
		}
		
		return mv;
	}
	
	
}
