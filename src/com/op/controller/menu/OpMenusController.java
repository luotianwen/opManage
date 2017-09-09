package com.op.controller.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.entity.menu.Menus;
import com.op.entity.menu.OpMenus;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.menu.OpMenusService;
import com.op.util.Const;

/** 
 * 前台菜单管理(opMenus)Controller
 * @author Yan
 * @version Revision: 1.00 
 *  Date: 2016-01-13 15:16:53 
 */ 
@Controller
@RequestMapping(value="/opMenus")
public class OpMenusController{
	
	@Resource(name="opMenusServiceImpl")
	private OpMenusService opMenusServiceImpl;

	/**
	 * 方法描述：查看菜单
	 * 返回类型：ModelAndView
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="menus")
	public ModelAndView opMenus(Page page,ModelAndView mv) throws Exception{
		// 前台菜单集合
		List<OpMenus> menus = opMenusServiceImpl.menus(page);
		mv.addObject("menus", menus);
		mv.addObject("page", page);
		mv.setViewName("admin/menu/op/menuList");
		return mv;
	}
	
	/**
	 * 方法描述：跳转添加菜单页面
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMenuAddView")
	public ModelAndView goMenuAddView(ModelAndView mv) throws Exception{
		List<OpMenus> menus = opMenusServiceImpl.goMenuAddGetParentList();
		mv.addObject("menus", menus);
		mv.setViewName("admin/menu/op/menuAdd");
		return mv;
	}
	
	/**
	 * 方法描述：保存菜单
	 * 返回类型：Map<String,Object>
	 * @return
	 */
	@RequestMapping(value="/saveMenu")
	@ResponseBody
	public Map<String,Object> saveMenu(OpMenus menu,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			Users user = (Users) session.getAttribute(Const.SESSION_USER);
			opMenusServiceImpl.saveMenu(user.getuId(),menu,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 方法描述：跳转菜单编辑页面
	 * 返回类型：ModelAndView
	 * @param mId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/goMenuEditView")
	public ModelAndView goMenuEditView(@RequestParam(value="opm_id") String opm_id,ModelAndView mv) throws Exception{
		OpMenus menu = opMenusServiceImpl.getMenuBymId(opm_id);
		mv.addObject("menu", menu);
		mv.setViewName("admin/menu/op/menuEdit");
		return mv;
	}
	
	/**
	 * 方法描述：更改菜单
	 * 返回类型：Map<String,Object>
	 * @return
	 */
	@RequestMapping(value="/updateMenu")
	@ResponseBody
	public Map<String,Object> updateMenu(OpMenus menu,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			Users user = (Users) session.getAttribute(Const.SESSION_USER);
			opMenusServiceImpl.updateMenu(user.getuId(),menu,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 方法描述：删除
	 * 返回类型：Map<String,Object>
	 * @param mId
	 * @return
	 */
	@RequestMapping(value="/deleteMenu")
	@ResponseBody
	public Map<String,Object> deleteMenu(@RequestParam(value="opm_id") String opm_id,@RequestParam(value="tp") String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			opMenusServiceImpl.deleteMenu(opm_id,tp,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 方法描述：查询子菜单
	 * 返回类型：List<Menus>
	 * @param mParentId
	 * @return
	 */
	@RequestMapping(value="/getMenuByParentId")
	@ResponseBody
	public Map<String,Object> getMenuByParentId(@RequestParam(value="opm_parent_id") String opm_parent_id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			List<OpMenus> menus = opMenusServiceImpl.getMenuListById(opm_parent_id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			map.put("menus", menus);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "查询异常!!!");
		}
		return map;
	}
}
