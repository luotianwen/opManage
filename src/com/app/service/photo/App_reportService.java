package com.app.service.photo;

import java.util.List;
import java.util.Map;

import com.app.entity.photo.App_report;
import com.op.plugin.page.Page;
/** 
 * 举报(app_report)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-18 20:32:44 
 */  
public interface App_reportService {

	/**
	 * 查询所有举报用户
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_report> findAllReport(Page<String> page) throws Exception;
	
	/**
	 * 根据ID查询举报用户
	 */
	public App_report findReportById(Map<String,String> map,String id) throws Exception;
	
	/**
	 * 修改举报用户
	 * @param app_report
	 * @throws Exception
	 */
	public void updateReport(App_report app_report) throws Exception;
	
	/**
	 * 举报用户
	 * @param app_report
	 * @throws Exception
	 */
	void report(App_report app_report) throws Exception;
	
	
}
