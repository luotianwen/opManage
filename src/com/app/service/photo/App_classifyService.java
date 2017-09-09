package com.app.service.photo;

import java.util.List;

import com.app.entity.photo.App_classify;
import com.op.plugin.page.Page;
/** 
 * 照片分类(app_classify)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */  
public interface App_classifyService {

	/**
	 * 查询所有照片分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_classify> findAllClassify(Page<String> page) throws Exception;
	
	/**
	 * 根据ID查询照片分类
	 */
	public App_classify findClassifyById(String id) throws Exception;
	
	/**
	 * 修改照片分类
	 * @param app_classify
	 * @throws Exception
	 */
	public void updateClassify(App_classify app_classify) throws Exception;
	
	/**
	 * 新增照片分类
	 * @param app_classify
	 * @throws Exception
	 */
	public void saveClassify(App_classify app_classify) throws Exception;
	
	/**
	 * 删除照片分类
	 * @param app_classify
	 * @throws Exception
	 */
	public void deleteClassify(String id,String type) throws Exception;
	
	
}
