package com.op.service.browser.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.browser.UserBrowser;
import com.op.plugin.page.Page;
import com.op.service.browser.UserBrowserService;

@Service("userBrowserServiceImpl")
public class UserBrowserServiceImpl implements UserBrowserService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
   
	
	/**
	 * 获取用户浏览器列表
	 * @param page
	 * @return
	 */
   public List<UserBrowser> getUserBrowserList(Page<Object> page)throws Exception{
	   return (List<UserBrowser>)dao.findForList("UserBrowserMapper.getUserBrowserList", page);
   }
	
}
