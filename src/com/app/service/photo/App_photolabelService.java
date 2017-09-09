package com.app.service.photo;

import java.util.List;
import java.util.Map;

import com.app.entity.photo.App_photolabel;
import com.op.plugin.page.Page;
/** 
 * 用户图片标签(app_photolabel)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-11-04 16:08:22 
 */  
public interface App_photolabelService {

    /**
	 * 查询所有用户图片标签
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_photolabel> findAllapp_photolabel(Page page) throws Exception;
	
	/**
	 * 将用户图片标签设置为系统标签
	 * @param name 用户标签名
	 * @throws Exception
	 */
	public void updateapp_photolabel(String name,Map<String,String> map) throws Exception;
	

	
}
