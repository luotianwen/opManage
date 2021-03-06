package com.op.service.pointService;

import java.util.List;
import java.util.Map;

import com.op.dto.pointService.PointEvaluateDTO;
import com.op.dto.pointService.PointServiceProjectsAuditDTO;
import com.op.dto.pointService.PointServiceProjectsInfoDTO;
import com.op.plugin.page.Page;
/** 
 * 地点服务评价(pointEvaluate)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-07-28 11:22:41 
 */  
public interface PointEvaluateService {
	
	/**
	 * 分页查询所有待审核项目
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PointEvaluateDTO> findAuditEvaluate(Page<?> page) throws Exception;
	
    /**
     * 根据id获取详细信息
     * @param id
     * @return
     * @throws Exception
     */
	PointEvaluateDTO findPointEvaluateDTO(String id) throws Exception;
    
    /**
     * 审核处理
     * @param map
     */
    void auditEvaluate(Map<String,String> map) throws Exception;
	
	
}
