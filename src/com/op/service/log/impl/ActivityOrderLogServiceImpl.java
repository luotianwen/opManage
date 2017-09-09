package com.op.service.log.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.log.ActivityOrderLog;
import com.op.service.log.ActivityOrderLogService;

/**
 * 项目名：outdoorPortal
 * 类描述：订单日志ServiceImpl
 * 创建人：Yan
 * 创建时间： 2016-1-7 下午5:39:41
 * 最后修改时间：2016-1-7下午5:39:41
 */
@Service("activityOrderLogServiceImpl")
public class ActivityOrderLogServiceImpl implements ActivityOrderLogService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据订单ID查询退款日志
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<ActivityOrderLog> getLogByOrderId(String orderId)throws Exception{
		return (List<ActivityOrderLog>)dao.findForList("activityOrderLogMapper.getLogByOrderId", orderId);
	}
	
	
}
