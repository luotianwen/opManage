package com.op.service.usercheck;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.entity.usercheck.UserCheck;
import com.op.plugin.page.Page;

/**
 * 
 * ClassName: User_CheckService 
 * @Description: 
 * @author WinZhong
 * @date 2016年1月11日 下午1:14:43
 */
public interface UserCheckService {
	
	/**
	 * 
	 * @Description: 获取用户申请列表 
	 * @param page
	 * @return
	 * @throws Exception   
	 * @return List<UserCheck>  
	 * @author WinZhong
	 * @date 2016年1月11日 下午2:55:40
	 */
	List<UserCheck> getvettedListPage(Page<Map<String,Object>> page)throws Exception;
	
	/**
	 * 
	 * @Description: 根据id查找用户详细信息
	 * @param id
	 * @return
	 * @throws Exception   
	 * @return UserCheck  
	 * @author WinZhong
	 * @date 2016年1月11日 下午2:54:47
	 */
	UserCheck findById(String id)throws Exception;
	
	/**
	 * 修改开始审核状态 
	 * @param id
	 * @throws Exception
	 */
	void updateStartVettedState(String id)throws Exception;
	
	
	/**
	 * 修改审核状态 
	 * @param map
	 * @throws Exception
	 */
	void updateVettedState(Map<String,Object> map)throws Exception;
	
	
}
