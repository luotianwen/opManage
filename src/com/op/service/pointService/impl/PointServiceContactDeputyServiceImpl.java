package com.op.service.pointService.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.service.pointService.PointServiceContactDeputyService;

/** 
 * 地点服务联系方式(副)(pointServiceContactDeputy)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 14:44:03 
 */  
@Service("pointServiceContactDeputyServiceImpl")
public class PointServiceContactDeputyServiceImpl implements PointServiceContactDeputyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
}
