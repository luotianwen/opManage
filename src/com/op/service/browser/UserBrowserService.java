package com.op.service.browser;

import java.util.List;

import com.op.entity.browser.UserBrowser;
import com.op.plugin.page.Page;
 
public interface UserBrowserService {
	
	/**
	 * 获取用户浏览器列表
	 * @param page
	 * @return
	 */
   List<UserBrowser> getUserBrowserList(Page<Object> page)throws Exception;
	
	
}
