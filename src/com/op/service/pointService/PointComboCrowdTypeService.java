package com.op.service.pointService;

import java.util.List;

import com.op.entity.pointService.PointComboCrowdType;
import com.op.plugin.page.Page;
/** 
 * 地点项目/套餐适合人群字典表(pointComboCrowdType)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-24 13:42:52 
 */  
public interface PointComboCrowdTypeService {

	/**
	 * 获取字典表所有数据
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<PointComboCrowdType> getList(Page<?> page)throws Exception;
	
	/**
	 * 根据id获取字典表数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	PointComboCrowdType findById(String id)throws Exception;
 
	/**
	 * 异步刷新字典缓存
	 * @throws Exception
	 */
	void shuaxinhuancun()throws Exception;

	/**
	 * 保存字典信息
	 * @param pointComboCrowdType
	 * @throws Exception
	 */
	void save(PointComboCrowdType pointComboCrowdType)throws Exception;

    

	
}
