package com.op.controller.emay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.entity.emay.EmayInfo;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.emay.EmayInfoService;
import com.op.util.Const;
/** 
 * 短信模板信息表(emayInfo)Controller
 * @author 世峰户外商城 
 * @version Revision: 1.00 
 *  Date: 2016-01-11 14:31:08 
 */ 
@Controller
@RequestMapping(value="/emayInfo")
public class EmayInfoController{
	
	@Resource(name="emayInfoServiceImpl")
	private EmayInfoService emayInfoServiceImpl;

	/**
	 * 方法描述：查询短信模板
	 * 返回类型：ModelAndView
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/emays")
	public ModelAndView emays(Page<EmayInfo> page,ModelAndView mv,EmayInfo emay) throws Exception{
		page.setT(emay);
		
		List<EmayInfo> emays = emayInfoServiceImpl.emays(page);
		mv.addObject("page", page);
		mv.addObject("emays", emays);
		mv.setViewName("emay/emay");
		return mv;
	}


	/**
	 * 刷新短信模板缓存数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="init")
	@ResponseBody
	public Map<String,Object> init()throws Exception{ 
		Map<String,Object> map = new HashMap<String,Object>(); 
		 try {
			 emayInfoServiceImpl.initEmailTemplate(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "刷新缓存失败！");
		}
		return map;
	}
	
	/**
	 * 方法描述：修改短信模板
	 * 返回类型：Map<String,Object>
	 * @param emay
	 * @param session
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public Map<String,Object> update(EmayInfo emay,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>(); 
		
		try {
			Users user = (Users) session.getAttribute(Const.SESSION_USER); 
			emay.setEl_update_user(user.getuId());
			emayInfoServiceImpl.update(emay, resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put(Const.RESPONSE_STATE, 500);
			resultMap.put(Const.ERROR_INFO, "保存异常！");
		}
		
		return resultMap;
	}
	
}
