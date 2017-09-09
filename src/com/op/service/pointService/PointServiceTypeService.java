package com.op.service.pointService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.dto.pointService.InsertCategoryDTO;
import com.op.entity.pointService.PointServiceType;


@Service("pointServiceTypeService")
public interface PointServiceTypeService {
	
	/**
	 * 方法描述：所有一级类型
	 * 返回类型：List<PointServiceType>
	 * @return
	 * @throws Exception
	 */
	List<PointServiceType> oneTypeAll()throws Exception;
		
	/**
	 * 方法描述：添加分类
	 * 返回类型：void
	 * @param type
	 * @throws Exception
	 */
	void addTypes(InsertCategoryDTO dto)throws Exception;
	
	
	/**
	 * 方法描述：删除分类
	 * 返回类型：void
	 * @param type
	 * @throws Exception
	 */
	void deleteTypes(Map<String,String> map)throws Exception;
	
	
	/**
	 * 方法描述：编辑分类
	 * 返回类型：void
	 * @param type
	 * @throws Exception
	 */
	void editType(Map<String,Object> map)throws Exception;
	
	/**
	 * 方法描述：锁定/解锁分类
	 * 返回类型：void
	 * @param type
	 * @throws Exception
	 */
	void lockOrUnLock(Map<String,Object> map)throws Exception;
	
	
	
}
