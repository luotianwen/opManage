package com.op.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.op.controller.BaseController;
import com.op.entity.classification.Classification;
import com.op.entity.menu.Menus;
import com.op.entity.users.Users;
import com.op.service.classification.ClassificationService;
import com.op.service.menu.MenusService;
import com.op.util.Const;
/**
 * 
*    
* 项目名称：outdoorPortal   
* 类名称：IndexController   
* 类描述：  登录成功跳转控制
* 创建人：Win Zhong   
* 创建时间：2015年11月11日 下午4:47:24   
* 修改人：Win Zhong   
* 修改时间：2015年11月11日 下午4:47:24   
* 修改备注：   
* @version    
*
 */
@Controller
public class IndexController extends BaseController{

	@Resource(name = "menusServiceImpl")
	private MenusService menusServiceImpl;
	// 活动类型
	@Resource(name="classificationServiceImpl")
	private ClassificationService classificationServiceImpl;
	/**
	 * 跳转到后台管理首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="admin/index")
	public ModelAndView adminIndex(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		Users user = (Users) session.getAttribute(Const.SESSION_USER);
        List<Menus> menus = menusServiceImpl.getUserMenuList(user.getrId());
		mv.addObject("menus", menus);
		mv.setViewName("admin/index");
		return mv;
	}
	 
	/**
	 * 跳转到网站首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="index")
	public ModelAndView index()throws Exception{ 
		ModelAndView mv = new ModelAndView();

		// 查询活动类型集合，级别默认为0（当前是一级菜单）
		int level = 1;
		List<Classification> types = classificationServiceImpl.findTypesByLevel(level);
		
		mv.addObject("types", types);
		mv.setViewName("index");
		return mv;
	}	

	/**
	 * 方法描述：goRegister
	 * 返回类型：ModelAndView
	 * @return
	 */
	@RequestMapping(value="/register")
	public ModelAndView goRegister(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	
	/**
	 * 方法描述：记录访问的路径，登录过后进行跳转
	 * 返回类型：ModelAndView
	 * @param url
	 * @return
	 */
	@RequestMapping(value="/loginSaveUrl")
	public ModelAndView goLogin(String url,HttpSession session){
		session.setAttribute(Const.SAVE_URL, url);
		ModelAndView mv = new ModelAndView("redirect:/login.html");
		return mv;
	}
	

	
	
	/**
	 * 方法描述：记录访问的路径，登录过后进行跳转
	 * 返回类型：ModelAndView
	 * @param url
	 * @return
	 */
	@RequestMapping(value="/login")
	public ModelAndView goLogin(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
}
