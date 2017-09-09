package com.app.service.photo.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.entity.photo.App_version;
import com.app.service.photo.App_versionService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;

/** 
 * APP版本发布(app_version)接口实现类
 * @author sen 
 * @version Revision: 1.00 
 *  Date: 2016-10-24 10:45:04 
 */  
@Service("app_versionServiceImpl")
public class App_versionServiceImpl implements App_versionService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有APP版本
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_version> findAllversion(Page<String> page) throws Exception{
		return (List<App_version>) dao.findForList("app_versionMapper.findAllversionPage", page);
	}
	
	/**
	 * 根据ID查询APP版本
	 */
	public App_version findversionById(String id) throws Exception{
		return (App_version) dao.findForObject("app_versionMapper.findversionById", id);
	}
	
	/**
	 * 修改APP版本
	 * @param app_version
	 * @throws Exception
	 */
	public void updateversion(App_version app_version) throws Exception{
		if("1".equals(app_version.getIsNewest())){
			dao.update("app_versionMapper.updateversionFroNewest","");
		}
		
		dao.update("app_versionMapper.updateversion", app_version);
	}
	
	/**
	 * 新增APP版本
	 * @param app_version
	 * @throws Exception
	 */
	public void saveversion(App_version app_version) throws Exception{
		dao.save("app_versionMapper.saveversion", app_version);
	}
}
