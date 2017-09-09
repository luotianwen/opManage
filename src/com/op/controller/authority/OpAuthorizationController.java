package com.op.controller.authority;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.op.entity.menu.ZTree;
import com.op.service.authority.OpAuthorizationService;
import com.op.util.Const;

/** 
 * 前台角色菜单对应表(opAuthorization)Controller
 * @author 世峰户外商城 
 * @version Revision: 1.00 
 *  Date: 2016-01-13 15:16:53 
 */ 
@Controller
@RequestMapping(value="/opAuthorization")
public class OpAuthorizationController{
	
	@Resource(name="opAuthorizationServiceImpl")
	private OpAuthorizationService opAuthorizationServiceImpl;

	/**
	 * 方法描述：跳转分配门户角色权限页面
	 * 返回类型：ModelAndView
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/goSysUserType")
	public ModelAndView goSysUserType(ModelAndView mv){
		mv.setViewName("admin/authority/op/userTypeList");
		return mv;
	}
	
	/**
	 * 方法描述：该角色菜单权限
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMenuTree")
	public ModelAndView goMenuTree(@RequestParam String rId,ModelAndView mv) throws Exception{
		List<ZTree> list = opAuthorizationServiceImpl.getRoleMenus(rId);

		mv.addObject("rId", rId);
		mv.addObject("menus", JSONArray.fromObject(list));
		
		mv.setViewName("admin/authority/op/menuTree");
		return mv;
	}

	
	/**
	 * 方法描述：绑定该角色菜单资源
	 * 返回类型：Map<String,Object>
	 * @param rId
	 * @return
	 */
	@RequestMapping(value="/linkRoleMenus")
	@ResponseBody
	public Map<String,Object> linkRoleMenus(@RequestParam int rId,@RequestParam String ids){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			opAuthorizationServiceImpl.savelinkRoleMenus(rId,ids,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, map.get(Const.ERROR_INFO)==null?"保存数据异常，请稍后重试!!!":map.get(Const.ERROR_INFO));
		}
		return map;
	}
}
