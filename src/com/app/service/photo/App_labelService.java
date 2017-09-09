package com.app.service.photo;

import java.util.List;
import java.util.Map;

import com.app.entity.photo.App_label;
import com.op.plugin.page.Page;
/** 
 * 照片标签(app_label)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */  
public interface App_labelService {

	/**
	 * 查询所有照片标签
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_label> findAllLabel(Page<String> page) throws Exception;
	
	/**
	 * 根据ID查询照片标签
	 */
	public App_label findLabelById(String id) throws Exception;
	
	/**
	 * 修改照片标签
	 * @param app_Label
	 * @throws Exception
	 */
	public void updateLabel(App_label app_label,Map<String,String> map) throws Exception;
	
	/**
	 * 新增照片标签
	 * @param app_Label
	 * @throws Exception
	 */
	public void saveLabel(App_label app_label,Map<String,String> map) throws Exception;
	
	/**
	 * 删除照片标签
	 * @param app_Label
	 * @throws Exception
	 */
	public void deleteLabel(String id,String type) throws Exception;

	
}
