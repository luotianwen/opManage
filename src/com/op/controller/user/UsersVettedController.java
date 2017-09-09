package com.op.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.usercheck.UserCheck;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.usercheck.UserCheckService;
import com.op.service.users.UsersService;
import com.op.util.Const;

/**
 * 
*    
* 项目名称：outdoorPortal   
* 类名称：UsersVettedController   
* 类描述：   会员资质审核
* 创建人：Win Zhong   
* 创建时间：2015年11月16日 上午10:40:25   
* 修改人：Win Zhong   
* 修改时间：2015年11月16日 上午10:40:25   
* 修改备注：   
* @version    
*
 */
@Controller
@RequestMapping(value="usersVetted")
public class UsersVettedController extends BaseController{

    
    @Resource(name="userCheckServiceImpl")
    UserCheckService userCheckServiceImpl;
    
    Logger log = Logger.getLogger(this.getClass());

    /**
     * 获取待审核会员用户列表
     * @param page
     * @param users
     * @return
     * @throws Exception
     */
	@RequestMapping(value="vettedList")
	public ModelAndView vettedList(Page<Map<String,Object>> page,ModelAndView mv)throws Exception{ 
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("uName", this.getParameter("uName"));
		parameter.put("ucType", this.getParameter("ucType"));
		parameter.put("ucProgress", this.getParameter("ucProgress"));
		page.setT(parameter);
		List<UserCheck> vettedList =  userCheckServiceImpl.getvettedListPage(page);
		mv.addObject("page",page);
		mv.addObject("vettedList",vettedList);
		mv.addObject("parameter",parameter);
		mv.setViewName("vetted/usersVetted");
		return mv;
	}

    /**
     * 查看认证信息
     * @param id
     * @param mv
     * @return
     * @throws Exception
     */
	@RequestMapping(value="show/{id}")
	public ModelAndView show(@PathVariable("id") String id,ModelAndView mv)throws Exception{ 
		UserCheck vetted =  userCheckServiceImpl.findById(id);
		mv.addObject("vetted",vetted);
		if(vetted.getUcType() == 1){
			mv.setViewName("vetted/ordinary");
		}else if(vetted.getUcType() == 2){
			mv.setViewName("vetted/enterprises");
		}
		mv.addObject("isVetted","false");
		return mv;
	}
	
    /**
     * 开始审核
     * @param id
     * @param mv
     * @return
     * @throws Exception
     */
	@RequestMapping(value="startVetted/{id}")
	public ModelAndView startVetted(@PathVariable("id") String id,ModelAndView mv)throws Exception{ 
		UserCheck vetted =  userCheckServiceImpl.findById(id);
		mv.addObject("vetted",vetted);
		if(vetted.getUcType() == 1){
			mv.setViewName("vetted/ordinary");
		}else if(vetted.getUcType() == 2){
			mv.setViewName("vetted/enterprises");
		}
		mv.addObject("isVetted","true");
		//修改开始审核状态  
		userCheckServiceImpl.updateStartVettedState(id);
		return mv;
	}	
	
    /**
     * 审核
     * @param page
     * @param users
     * @return
     * @throws Exception
     */
	@RequestMapping(value="vetted")
	@ResponseBody
	public Map<String,Object> vetted(){ 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ucProgress", this.getParameter("ucProgress"));
		map.put("ucFailRemarks", this.getParameter("ucFailRemarks"));
		map.put("ucId", this.getParameter("ucId"));
		map.put("userId", this.getSessionUser().getuId());
		try {
			userCheckServiceImpl.updateVettedState(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			log.error("审核企业资质失败", e);
			// TODO Auto-generated catch block
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "审核失败！");
		}
		return map;
	}
	
	
}
