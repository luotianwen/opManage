package com.app.service.photo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dto.photo.App_commentReplyDTO;
import com.app.service.photo.App_commentReplyService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;

/** 
 * 照片评论(app_commentReply)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-19 21:47:45 
 */  
@Service("app_commentReplyServiceImpl")
public class App_commentReplyServiceImpl implements App_commentReplyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据描述ID查询回复
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_commentReplyDTO> findReplyComment(Page<String> page) throws Exception{
		return (List<App_commentReplyDTO>) dao.findForList("app_commentReplyMapper.findReplyCommentPage", page);
	}
	
	/**
	 * 删除回复
	 */
	public void deleteReply(String id) throws Exception{
		dao.update("app_commentReplyMapper.deleteReply", id);
	}
	
}
