package com.op.service.pointService;

import java.util.List;
import java.util.Map;

import com.op.dto.point.PointServiceDeputyDTO;
import com.op.plugin.page.Page;
/** 
 * 地点服务基本信息表(副)(pointServiceDeputy)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 10:51:23 
 */  
public interface PointServiceDeputyService {

	/**
	 * 分页获取所有待审核的地点信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<?> getCheckList(Page<?> page) throws Exception;

	/**
	 * 根据id获取详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	PointServiceDeputyDTO getPointById(String id) throws Exception;

	/**
	 * 审核处理
	 * @param map
	 */
	void pointCheckById(Map<String, Object> map) throws Exception;

    

	
}
