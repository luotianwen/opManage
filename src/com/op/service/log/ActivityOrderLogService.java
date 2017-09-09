package com.op.service.log;

import java.util.List;

import org.springframework.stereotype.Service;

import com.op.entity.log.ActivityOrderLog;

/**
 * 项目名：outdoorPortal
 * 类描述：订单日志Service
 * 创建人：Yan
 * 创建时间： 2016-1-7 下午5:39:28
 * 最后修改时间：2016-1-7下午5:39:28
 */
public interface ActivityOrderLogService {
	
	/**
	 * 根据订单ID查询退款日志
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	List<ActivityOrderLog> getLogByOrderId(String orderId)throws Exception;
	
	
	
}
