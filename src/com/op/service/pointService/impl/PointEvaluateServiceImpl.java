package com.op.service.pointService.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.dto.pointService.PointEvaluateDTO;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointEvaluateService;

/** 
 * 地点服务评价(pointEvaluate)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-07-28 11:22:41 
 */  
@Service("pointEvaluateServiceImpl")
public class PointEvaluateServiceImpl implements PointEvaluateService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 分页查询所有待审核项目
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PointEvaluateDTO> findAuditEvaluate(Page<?> page) throws Exception{
		return (List<PointEvaluateDTO>) dao.findForList("pointEvaluateMapper.findAuditEvaluatePage", page);
	}
	
	/**
     * 根据id获取详细信息
     * @param id
     * @return
     * @throws Exception
     */
	
	public PointEvaluateDTO findPointEvaluateDTO(String id) throws Exception{
		return (PointEvaluateDTO) dao.findForObject("pointEvaluateMapper.findPointEvaluateDTO", id);
	}
	
    /**
     * 审核处理
     * @param map
     */
    public void auditEvaluate(Map<String,String> map) throws Exception{
    	dao.update("pointEvaluateMapper.auditEvaluate", map);
    }
	
}
