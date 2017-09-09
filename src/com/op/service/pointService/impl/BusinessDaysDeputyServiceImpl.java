package com.op.service.pointService.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.service.pointService.BusinessDaysDeputyService;

/** 
 * 营业日集合(副)(businessDaysDeputy)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 14:44:04 
 */  
@Service("businessDaysDeputyServiceImpl")
public class BusinessDaysDeputyServiceImpl implements BusinessDaysDeputyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
}
