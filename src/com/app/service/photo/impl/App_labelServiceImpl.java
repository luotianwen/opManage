package com.app.service.photo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.entity.photo.App_label;
import com.app.service.photo.App_labelService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * 照片标签(app_label)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */  
@Service("app_labelServiceImpl")
public class App_labelServiceImpl implements App_labelService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有照片标签
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_label> findAllLabel(Page<String> page) throws Exception{
		return (List<App_label>) dao.findForList("app_labelMapper.findAllLabel", page);
	}
	
	/**
	 * 根据ID查询照片标签
	 */
	public App_label findLabelById(String id) throws Exception{
		return (App_label) dao.findForObject("app_labelMapper.findLabelById", id);
	}
	
	/**
	 * 修改照片标签
	 * @param app_Label
	 * @throws Exception
	 */
	public void updateLabel(App_label app_label,Map<String,String> map) throws Exception{
		Map<String,String> labelMap = new HashMap<String,String>();
		labelMap.put("l_id", app_label.getL_id());
		labelMap.put("l_name", app_label.getL_name());
		
		int count = (int) dao.findForObject("app_labelMapper.findLabelCount", labelMap);
		
		if(count==0){
			dao.update("app_labelMapper.updateLabel", app_label);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "该标签已存在");
		}
	}
	
	/**
	 * 新增照片标签
	 * @param app_Label
	 * @throws Exception
	 */
	public void saveLabel(App_label app_label,Map<String,String> map) throws Exception{
		int count = (int) dao.findForObject("app_labelMapper.findLabelCount", app_label);
		
		if(count==0){
			dao.save("app_labelMapper.saveLabel", app_label);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "该标签已存在");
		}
		
	}
	
	/**
	 * 删除照片标签
	 * @param app_Label
	 * @throws Exception
	 */
	public void deleteLabel(String id,String type) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("type", type);
		dao.delete("app_labelMapper.deleteLabel", map);
	}
	
}
