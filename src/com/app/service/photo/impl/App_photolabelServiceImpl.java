package com.app.service.photo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.entity.photo.App_label;
import com.app.entity.photo.App_photolabel;
import com.app.service.photo.App_photolabelService;
import com.op.dao.BaseDao;
import com.op.plugin.page.Page;
import com.op.util.Const;

/** 
 * 用户图片标签(app_photolabel)接口实现类
 * @author sen
 * @app_photolabel Revision: 1.00 
 *  Date: 2016-11-04 16:08:22 
 */  
@Service("app_photolabelServiceImpl")
public class App_photolabelServiceImpl implements App_photolabelService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有用户图片标签
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_photolabel> findAllapp_photolabel(Page page) throws Exception{
		return (List<App_photolabel>) dao.findForList("app_photolabelMapper.findAllapp_photolabelPage", page);
	}
	
	/**
	 * 将用户图片标签设置为系统标签
	 * @param name 用户标签名
	 * @throws Exception
	 */
	public void updateapp_photolabel(String name,Map<String,String> map) throws Exception{
		Map<String,String> labelMap = new HashMap<String,String>();
		labelMap.put("l_id", "0");
		labelMap.put("l_name", name);
		
		int count = (int) dao.findForObject("app_labelMapper.findLabelCount", labelMap);
		
		if(count==0){
			App_label app_label = new App_label();
			app_label.setL_name(name);
			
			dao.save("app_labelMapper.saveLabel", app_label);
			dao.save("app_photolabelMapper.updateapp_photolabel", app_label);
			
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "该标签已存在");
		}
		
		
	}
	
}
