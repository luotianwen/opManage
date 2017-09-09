package com.op.controller.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.menu.Menus;
import com.op.entity.menu.ZTree;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.menu.MenusService;
import com.op.util.Const;
/**
 * 项目名：outdoorPortal
 * 类描述：系统菜单操作
 * 创建人：Yan
 * 创建时间： 2015-11-17 下午3:07:21
 * 最后修改时间：2015-11-17下午3:07:21
 */
@Controller
@RequestMapping(value="/menus")
public class MenusController extends BaseController {
	
	@Resource(name="menusServiceImpl")
	private MenusService menusServiceImpl;
 
	/**
	 * 方法描述：主菜单集合
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/menuList")
	public ModelAndView getMenuList(Page page,ModelAndView mv) throws Exception{
		List<Menus> menus = menusServiceImpl.getMenuList(page);
		mv.addObject("menus", menus);
		mv.addObject("page", page);
		mv.setViewName("admin/menu/menuList");
		return mv;
	}
	
	/**
	 * 方法描述：查询子菜单
	 * 返回类型：List<Menus>
	 * @param mParentId
	 * @return
	 */
	@RequestMapping(value="/getMenuByParentId")
	@ResponseBody
	public Map<String,Object> getMenuByParentId(@RequestParam(value="mParentId") String mParentId){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			List<Menus> menus = menusServiceImpl.getMenuListById(mParentId);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			map.put("menus", menus);
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "查询异常!!!");
		}
		return map;
	}
	
	/**
	 * 方法描述：跳转添加菜单页面
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMenuAddView")
	public ModelAndView goMenuAddView(ModelAndView mv) throws Exception{
		List<Menus> menus = menusServiceImpl.goMenuAddGetParentList();
		mv.addObject("menus", menus);
		mv.setViewName("admin/menu/menuAdd");
		return mv;
	}
	
	/**
	 * 方法描述：保存菜单
	 * 返回类型：Map<String,Object>
	 * @return
	 */
	@RequestMapping(value="/saveMenu")
	@ResponseBody
	public Map<String,Object> saveMenu(Menus menu,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			Users user = (Users) session.getAttribute(Const.SESSION_USER);
			menusServiceImpl.saveMenu(user.getuId(),menu,map);
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
	public Map<String,Object> deleteMenu(@RequestParam(value="mId") String mId,@RequestParam(value="tp") String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			menusServiceImpl.deleteMenu(mId,tp,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
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
	public ModelAndView goMenuEditView(@RequestParam(value="mId") String mId,ModelAndView mv) throws Exception{
		Menus menu = menusServiceImpl.getMenuBymId(mId);
		mv.addObject("menu", menu);
		mv.setViewName("admin/menu/menuEdit");
		return mv;
	}
	
	/**
	 * 方法描述：更改菜单
	 * 返回类型：Map<String,Object>
	 * @return
	 */
	@RequestMapping(value="/updateMenu")
	@ResponseBody
	public Map<String,Object> updateMenu(Menus menu,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		
		try {
			Users user = (Users) session.getAttribute(Const.SESSION_USER);
			menusServiceImpl.updateMenu(user.getuId(),menu,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 方法描述：该角色菜单权限
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMenuTree")
	public ModelAndView goMenuTree(@RequestParam(value="rId") String rId,ModelAndView mv) throws Exception{
		List<ZTree> list = menusServiceImpl.getRoleMenus(rId);
		
		mv.addObject("menus", JSONArray.fromObject(list));
		mv.addObject("rId", rId);
		mv.setViewName("admin/authority/menuTree");
		return mv;
	}
}
