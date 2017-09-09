package com.app.service.photo;

import java.util.List;
import java.util.Map;

import com.app.entity.photo.App_forbid_photo;
import com.op.plugin.page.Page;
/** 
 * 用户禁言表(app_forbid_photo)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-18 20:32:44 
 */  
public interface App_forbid_photoService {

	/**
	 * 查询所有用户禁言
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_forbid_photo> findAllForbidPhoto(Page<String> page) throws Exception;
	
	/**
	 * 根据ID查询用户禁言
	 */
	public App_forbid_photo findForbidPhotoById(String id) throws Exception;
	
	/**
	 * 修改用户禁言
	 * @param app_forbid_photo
	 * @throws Exception
	 */
	public void updateForbidPhoto(App_forbid_photo app_forbid_photo) throws Exception;
	
	/**
	 * 用户禁言
	 */
	public Map<String,String> forbidUser(App_forbid_photo app_forbid_photo) throws Exception;
	
	/**
	 * 新增用户禁言
	 * @param app_forbid_photo
	 * @throws Exception
	 */
	public void saveForbidPhoto(Map<String,String> map,App_forbid_photo app_forbid_photo) throws Exception;

	
}
