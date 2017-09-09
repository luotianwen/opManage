package com.app.service.feedback.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dto.feedback.App_feedbackDTO;
import com.app.entity.feedback.App_feedback;
import com.app.service.feedback.App_feedbackService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;

/** 
 * APP反馈(app_feedback)接口实现类
 * @author sen 
 * @app_feedback Revision: 1.00 
 *  Date: 2016-11-03 10:55:45 
 */  
@Service("app_feedbackServiceImpl")
public class App_feedbackServiceImpl implements App_feedbackService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有APP反馈
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_feedback> findAllapp_feedback(Page page) throws Exception{
		return (List<App_feedback>) dao.findForList("app_feedbackMapper.findAllapp_feedbackPage", page);
	}
	
	/**
	 * 根据ID查询APP反馈
	 */
	public App_feedbackDTO findapp_feedbackById(String id) throws Exception{
		return (App_feedbackDTO) dao.findForObject("app_feedbackMapper.findapp_feedbackById", id);
	}
	
	/**
	 * 修改APP反馈
	 * @param app_feedback
	 * @throws Exception
	 */
	public void updateapp_feedback(App_feedback app_feedback) throws Exception{
		dao.update("app_feedbackMapper.updateapp_feedback", app_feedback);
	}
}
