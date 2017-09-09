package com.op.service.screening;

import java.util.List;
import java.util.Map;

import com.op.entity.screening.Screening;
import com.op.plugin.page.Page;

/** 
 * 筛选条件(screening)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-08-20 13:25:21 
 */  
public interface ScreeningService {
	
	/**
	 * 新增筛选条件
	 * @param screening
	 * @throws Exception
	 */
    void addScreening(Screening screening) throws Exception;
    
    /**
     * 查询所有筛选条件
     * @return
     * @throws Exception
     */
    List<Screening> findAllScreening(Page<Map<String,String>> page) throws Exception;
    
    /**
     * 查询所有子筛选条件
     * @return
     * @throws Exception
     */
    List<Screening> findScreeningByParentId(Map<String,String> map) throws Exception;
    
    /**
     * 修改筛选条件
     * @param screening
     * @throws Exception
     */
    void updateScreening(Screening screening) throws Exception;
    
    /**
     * 删除筛选条件
     * @param screening
     * @throws Exception
     */
    void deleteScreening(String id,String sc_modularType) throws Exception;
    
    /**
     * 查询所有父级条件
     */
    List<Screening> goScreeningAddGetParentList(String type) throws Exception;
    
    /**
     * 根据ID查询筛选条件
     */
    Screening findScreeningById(String id) throws Exception;
    
    
}
