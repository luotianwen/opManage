package com.app.service.photo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dto.photo.App_photocommentDTO;
import com.app.entity.photo.App_photocomment;
import com.app.service.photo.App_photocommentService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;

/** 
 * 评论照片(app_photocomment)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-15 14:13:04 
 */  
@Service("app_photocommentServiceImpl")
public class App_photocommentServiceImpl implements App_photocommentService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有照片评论
	 * @param page
	 * @return
	 * @throws Exception
	 */
    public List<App_photocommentDTO> findAllComment(Page<String> page) throws Exception{
    	return (List<App_photocommentDTO>) dao.findForList("app_photocommentMapper.findAllCommentPage", page);
    }
	
}
