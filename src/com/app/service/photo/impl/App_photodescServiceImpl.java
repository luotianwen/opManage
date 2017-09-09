package com.app.service.photo.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dto.photo.App_photodescDTO;
import com.app.entity.photo.App_photodesc;
import com.app.service.photo.App_photodescService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * 照片表(app_photo)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-15 14:13:04 
 */  
@Service("app_photodescServiceImpl")
public class App_photodescServiceImpl implements App_photodescService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有照片
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_photodesc> findAllPhotodesc(Page<App_photodescDTO> page) throws Exception{
		return (List<App_photodesc>) dao.findForList("app_photodescMapper.findAllPhotodescPage", page);
	};
	
	/**
	 * 根据ID查询照片详细信息
	 * @param id 照片ID
	 * @return
	 * @throws Exception
	 */
	public App_photodescDTO findPhotodescById(String id) throws Exception{
		return (App_photodescDTO) dao.findForObject("app_photodescMapper.findPhotodescById", id);
	}
	
	/**
	 * 审核
	 */
	public void updatePhotodesc(Map<String,String> map) throws Exception{
		dao.update("app_photodescMapper.updatePhotodesc", map);
		
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}
	
	
}
