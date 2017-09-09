package com.app.service.photo.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.service.photo.App_photoService;
import com.op.dao.BaseDao; 

/** 
 * 照片表(app_photo)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-15 14:13:04 
 */  
@Service("app_photoServiceImpl")
public class App_photoServiceImpl implements App_photoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
}
