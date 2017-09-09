package com.op.service.pointService.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.dto.pointService.PointAuthDTO;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointAuthService;

/** 
 * 地点商户认领认证信息(pointAuth)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-27 09:49:18 
 */  
@Service("pointAuthServiceImpl")
public class PointAuthServiceImpl implements PointAuthService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;


	/**
	 * 获取所有地点商户认领认证审核信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PointAuthDTO> getList(Page<PointAuthDTO> page)throws Exception {
		return (List<PointAuthDTO>)dao.findForList("pointAuthMapper.getListPage", page);
	}

	/**
	 * 根据id获取地点商户认领认证审核信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PointAuthDTO findById(String id)throws Exception {
		return (PointAuthDTO)dao.findForObject("pointAuthMapper.findById", id);
	}


	/**
	 * 审核认证信息
	 * @param pa
	 * @throws Exception
	 */
	public void examine(PointAuthDTO pa)throws Exception {
		dao.update("pointAuthMapper.updateExamine", pa);
		/**
		//审核成功，修改地点认证信息
		if("3".equals(pa.getAuditor_state())){
			dao.update("pointServiceMapper.updateAuthExamine", pa);
			
			dao.update("usersMapper.updateUTypeForPointService", pa.getUser_id());
		}
		 
		 */
	}
}
