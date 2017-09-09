package com.app.service.feedback;

import java.util.List;

import com.app.dto.feedback.App_feedbackDTO;
import com.app.entity.feedback.App_feedback;
import com.op.plugin.page.Page;
/** 
 * APP反馈(app_feedback)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-11-03 10:55:45 
 */  
public interface App_feedbackService {

    /**
	 * 查询所有APP反馈
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_feedback> findAllapp_feedback(Page page) throws Exception;
	
	/**
	 * 根据ID查询APP反馈
	 */
	public App_feedbackDTO findapp_feedbackById(String id) throws Exception;
	
	/**
	 * 修改APP反馈
	 * @param app_feedback
	 * @throws Exception
	 */
	public void updateapp_feedback(App_feedback app_feedback) throws Exception;
	
	
}
