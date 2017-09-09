package com.op.service.travels;

import java.util.List;
import java.util.Map;

import com.op.dto.travels.TravelsDTO;
import com.op.entity.travels.Travels;
import com.op.plugin.page.Page;
/** 
 * 游记(travels)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-04-18 14:30:31 
 */  
public interface TravelsService {

	/**
	 * 查询所有游记
	 */
	List<TravelsDTO> findTravelsAllPage(Page<Map<String,Object>> page) throws Exception;
	
	/**
	 * 根据ID查询游记
	 */
	Travels findTravelsById(Map<String,String> map) throws Exception;
	
	/**
	 * 删除游记
	 */
	void delTravels(Travels travels,Map<String,Object> map) throws Exception;
	
	/**
	 * 审核游记
	 */
	void examineTravels(Map<String,Object> map)throws Exception;
}
