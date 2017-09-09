package com.op.service.pointService;

import java.util.List;

import com.op.dto.pointService.PointAuthDTO;
import com.op.plugin.page.Page;
/** 
 * 地点商户认领认证信息(pointAuth)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-27 09:49:18 
 */  
public interface PointAuthService {

	/**
	 * 获取所有地点商户认领认证审核信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PointAuthDTO> getList(Page<PointAuthDTO> page)throws Exception;

	/**
	 * 根据id获取地点商户认领认证审核信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	PointAuthDTO findById(String id)throws Exception;

	/**
	 * 审核认证信息
	 * @param pa
	 * @throws Exception
	 */
	void examine(PointAuthDTO pa)throws Exception;

    

	
}
