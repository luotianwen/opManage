package com.op.service.usercheck.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.usercheck.UserCheck;
import com.op.plugin.page.Page;
import com.op.service.usercheck.UserCheckService;

/**
 * 
 * ClassName: User_CheckServiceImpl 
 * @Description: 
 * @author WinZhong
 * @date 2016年1月11日 下午1:15:06
 */
@Service("userCheckServiceImpl")
public class UserCheckServiceImpl implements UserCheckService {
	
	@Resource(name="baseDaoImpl")
	private BaseDao dao;
	
 
	
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
	public List<UserCheck> getvettedListPage(Page<Map<String,Object>> page)throws Exception{
		
		
		return (List<UserCheck>)dao.findForList("UserCheckMapper.getvettedListPage", page);
	}
	
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
	public UserCheck findById(String id)throws Exception{
		
		return (UserCheck)dao.findForObject("UserCheckMapper.findById", id);
	}
	
	/**
	 * 修改开始审核状态 
	 * @param id
	 * @throws Exception
	 */
	public void updateStartVettedState(String id)throws Exception{
		dao.update("UserCheckMapper.updateStartVettedState", id);
	}
	
	
	/**
	 * 修改审核状态 
	 * @param map
	 * @throws Exception
	 */
	public void updateVettedState(Map<String,Object> map)throws Exception{
		dao.update("UserCheckMapper.updateVettedState", map);
		// 审核成功，修改用戶身份
		if("3".equals(map.get("ucProgress"))){
			dao.update("UsersMapper.updateUType", map);
		}else{
			dao.update("UsersMapper.updateFailUType", map);
		}
	}
}
