package com.op.service.dataManager.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.dataManager.ActiveSearchData;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.dataManager.ActiveSearchDataService;
import com.op.util.UuidUtil;

@Service("activeSearchDataServiceImpl")
public class ActiveSearchDataServiceImpl implements ActiveSearchDataService {
	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 方法描述：活动筛选条件集合
	 * 返回类型：List<ActiveSearchData>
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ActiveSearchData> selectList(Page page) throws Exception {
		
		return (List<ActiveSearchData>) dao.findForList("activeSearchDataMapper.selectListPage", page);
	}

	/**
	 * 方法描述：活动筛选条件集合
	 * 返回类型：List<ActiveSearchData>
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ActiveSearchData> selectList() throws Exception {
		
		return (List<ActiveSearchData>) dao.findForList("activeSearchDataMapper.selectList", null);
	}

	/**
	 * 方法描述：保存数据
	 * 实现接口：@see com.op.service.dataManager.ActiveSearchDataService#saveData(com.op.entity.dataManager.ActiveSearchData, java.util.Map)
	 * @param data
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void saveData(ActiveSearchData data,Users user)
			throws Exception {
		
		Date currentDate = new Date();
		data.setAsd_create_user(user.getuId());
		data.setAsd_create_time(currentDate);
		data.setAsd_update_time(currentDate);
		data.setAsd_update_user(user.getuId());
		data.setAsd_update_user_name(user.getuName());
		
		// 暂时不保存子条件的类型默认为0
		if(!"0".equals(data.getAsd_parent_id())){
			data.setAsd_type(0);
		}
		
		dao.save("activeSearchDataMapper.saveData", data);
		
	}
	
	
	/**
	 * 方法描述：删除数据
	 * 返回类型：void
	 * @param data
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void deleteData(Map<String,Object> map) throws Exception {
		
		dao.delete("activeSearchDataMapper.deleteData", map);
		
	}

	
	/**
	 * 方法描述：更新数据
	 * 返回类型：void
	 * @param data
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void updateData(ActiveSearchData data, Users user) throws Exception {
		
		Date currentDate = new Date();
		data.setAsd_update_time(currentDate);
		data.setAsd_update_user(user.getuId());
		data.setAsd_update_user_name(user.getuName());
		
		dao.update("activeSearchDataMapper.updateData", data);
	}

	
	/**
	 * 方法描述： 根据ID查询数据
	 * 返回类型：ActiveSearchData
	 * @param asd_id
	 * @return
	 * @throws Exception
	 */
	@Override
	public ActiveSearchData selectById(String asd_id) throws Exception {
		
		return (ActiveSearchData) dao.findForObject("activeSearchDataMapper.selectById", asd_id);
	}
}
