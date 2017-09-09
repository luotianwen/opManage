package com.op.service.pointService.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.service.pointService.PointServiceImgDeputyService;

/** 
 * 地点服务图片(副)(pointServiceImgDeputy)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 14:44:04 
 */  
@Service("pointServiceImgDeputyServiceImpl")
public class PointServiceImgDeputyServiceImpl implements PointServiceImgDeputyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
}
