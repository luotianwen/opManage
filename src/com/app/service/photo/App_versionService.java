package com.app.service.photo;

import java.util.List;
import java.util.Map;

import com.app.entity.photo.App_version;
import com.op.plugin.page.Page;
/** 
 * APP版本发布(app_version)接口
 * @author sen 
 * @version Revision: 1.00 
 *  Date: 2016-10-24 10:45:04 
 */  
public interface App_versionService {

	/**
	 * 查询所有APP版本
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_version> findAllversion(Page<String> page) throws Exception;
	
	/**
	 * 根据ID查询APP版本
	 */
	public App_version findversionById(String id) throws Exception;
	
	/**
	 * 修改APP版本
	 * @param app_version
	 * @throws Exception
	 */
	public void updateversion(App_version app_version) throws Exception;
	
	/**
	 * 新增APP版本
	 * @param app_version
	 * @throws Exception
	 */
	public void saveversion(App_version app_version) throws Exception;

	
}
