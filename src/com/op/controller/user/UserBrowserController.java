package com.op.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.browser.UserBrowser;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.browser.UserBrowserService;
/** 
 * 用户浏览器(UserBrowser)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-01-28 14:38:42 
 */ 
@Controller
@RequestMapping(value="/userBrowser")
public class UserBrowserController extends BaseController {
	
	@Resource(name="userBrowserServiceImpl")
	private UserBrowserService userBrowserServiceImpl;

    /**
     * 用户浏览器列表
     * @param page
     * @return
     * @throws Exception
     */
	@RequestMapping(value="userBrowserList")
	public ModelAndView userBrowserList(Page<Object> page)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		page.setT("");
		List<UserBrowser> userBrowserList = userBrowserServiceImpl.getUserBrowserList(page);
		mv.addObject("page",page);
		mv.addObject("userBrowserList",userBrowserList);
		mv.setViewName("browser/browser");
		return mv;
	}
	
	
}
