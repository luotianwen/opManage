package com.app.service.photo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.entity.photo.App_classify;
import com.app.service.photo.App_classifyService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;

/** 
 * 照片分类(app_classify)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-17 20:37:45 
 */  
@Service("app_classifyServiceImpl")
public class App_classifyServiceImpl implements App_classifyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有图片分类
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_classify> findAllClassify(Page<String> page) throws Exception{
		return (List<App_classify>) dao.findForList("app_classifyMapper.findAllClassify", page);
	}
	
	/**
	 * 根据ID查询照片分类
	 */
	public App_classify findClassifyById(String id) throws Exception{
		return (App_classify) dao.findForObject("app_classifyMapper.findClassifyById", id);
	}
	
	/**
	 * 修改图片分类
	 * @param app_classify
	 * @throws Exception
	 */
	public void updateClassify(App_classify app_classify) throws Exception{
		dao.update("app_classifyMapper.updateClassify", app_classify);
	}
	
	/**
	 * 新增图片分类
	 * @param app_classify
	 * @throws Exception
	 */
	public void saveClassify(App_classify app_classify) throws Exception{
		dao.save("app_classifyMapper.saveClassify", app_classify);
	}
	
	/**
	 * 删除图片分类
	 * @param app_classify
	 * @throws Exception
	 */
	public void deleteClassify(String id,String type) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("type", type);
		dao.delete("app_classifyMapper.deleteClassify", map);
	}
	
}
