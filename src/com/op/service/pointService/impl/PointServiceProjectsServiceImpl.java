package com.op.service.pointService.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.op.dao.BaseDao; 
import com.op.dto.pointService.PointServiceProjectsAuditDTO;
import com.op.dto.pointService.PointServiceProjectsInfoDTO;
import com.op.entity.pointService.PointServiceProjects;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointServiceProjectsService;

/** 
 * 地点服务项目(pointServiceProjects)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-07-28 11:22:41 
 */  
@Service("pointServiceProjectsServiceImpl")
public class PointServiceProjectsServiceImpl implements PointServiceProjectsService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 分页查询所有待审核项目
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PointServiceProjectsAuditDTO> findAuditProject(Page<?> page) throws Exception{
    	
		return (List<PointServiceProjectsAuditDTO>) dao.findForList("pointServiceProjectsMapper.findAuditProjectPage", page);
    }
	
    /**
     * 根据id获取详细信息
     * @param id
     * @return
     * @throws Exception
     */
    public PointServiceProjectsInfoDTO findPointServiceProjectsInfoDTO(String id) throws Exception{
    	
    	return (PointServiceProjectsInfoDTO) dao.findForObject("pointServiceProjectsMapper.findPointServiceProjectsInfoDTO", id);
    }
    
    /**
     * 审核处理
     * @param map
     */
    public void auditProject(Map<String,String> map) throws Exception{
    	if("1".equals(map.get("psp_state"))){
    		if("0".equals(map.get("psp_update_id"))||StringUtils.isEmpty(map.get("psp_update_id"))){
    			dao.update("pointServiceProjectsMapper.auditSuccess", map);
    		}else{
    			dao.update("pointServiceProjectsMapper.auditSuccess", map);
    			PointServiceProjects newProject = (PointServiceProjects) dao.findForObject("pointServiceProjectsMapper.findPointServiceProject", map.get("psp_id"));
    			PointServiceProjects oldProject = (PointServiceProjects) dao.findForObject("pointServiceProjectsMapper.findPointServiceProject", map.get("psp_update_id"));
    			oldProject.setPsp_update_id(oldProject.getPsp_id());
    			oldProject.setPsp_id(newProject.getPsp_id());
    			oldProject.setPsp_update(map.get("userId"));
    			oldProject.setPsp_update_time(new Date());
    			newProject.setPsp_id(newProject.getPsp_update_id());
    			newProject.setPsp_update_id(0);
    			
    			dao.update("pointServiceProjectsMapper.updateNew", oldProject);
    			dao.update("pointServiceProjectsMapper.updateNew", newProject);
    			
    			dao.update("pointServiceProjectsMapper.updateOrderSnapshotId", map);
    			
    		}
    	}else if("2".equals(map.get("psp_state"))){
    		dao.update("pointServiceProjectsMapper.auditFail", map);
    	}
    	
    }
	
	
}
