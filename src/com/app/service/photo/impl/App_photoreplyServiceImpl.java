package com.app.service.photo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dto.photo.App_photoreplyDTO;
import com.app.service.photo.App_photoreplyService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;

/** 
 * 照片回复表(app_photoreply)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-15 14:13:04 
 */  
@Service("app_photoreplyServiceImpl")
public class App_photoreplyServiceImpl implements App_photoreplyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据评论ID查询回复
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_photoreplyDTO> findReplyComment(Page<String> page) throws Exception{
		return (List<App_photoreplyDTO>) dao.findForList("app_photoreplyMapper.findReplyCommentPage", page);
	}
	
}
