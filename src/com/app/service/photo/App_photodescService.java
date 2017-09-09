package com.app.service.photo;

import java.util.List;
import java.util.Map;

import com.app.dto.photo.App_photodescDTO;
import com.app.entity.photo.App_photodesc;
import com.op.plugin.page.Page;
/** 
 * 照片表(app_photo)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-15 14:13:04 
 */  
public interface App_photodescService {

	/**
	 * 查询所有照片
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_photodesc> findAllPhotodesc(Page<App_photodescDTO> page) throws Exception;

	/**
	 * 根据ID查询照片详细信息
	 * @param id 照片ID
	 * @return
	 * @throws Exception
	 */
	public App_photodescDTO findPhotodescById(String id) throws Exception;
	
	/**
	 * 审核
	 */
	public void updatePhotodesc(Map<String,String> map) throws Exception;
	
}
