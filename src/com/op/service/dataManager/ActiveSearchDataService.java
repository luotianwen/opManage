package com.op.service.dataManager;

import java.util.List;
import java.util.Map;

import com.op.entity.dataManager.ActiveSearchData;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;

import org.springframework.stereotype.Service;


@Service("activeSearchDataService")
public interface ActiveSearchDataService {
	
	/**
	 * 方法描述：活动筛选条件集合
	 * 返回类型：List<ActiveSearchData>
	 * @return
	 * @throws Exception
	 */
	public List<ActiveSearchData> selectList(Page page) throws Exception;
	
	/**
	 * 方法描述：活动筛选条件集合
	 * 返回类型：List<ActiveSearchData>
	 * @return
	 * @throws Exception
	 */
	public List<ActiveSearchData> selectList() throws Exception;
	
	/**
	 * 方法描述：保存数据
	 * 返回类型：void
	 * @param data
	 * @param map
	 * @throws Exception
	 */
	public void saveData(ActiveSearchData data,Users user) throws Exception;
	
	/**
	 * 方法描述：删除数据
	 * 返回类型：void
	 * @param data
	 * @param map
	 * @throws Exception
	 */
	public void deleteData(Map<String,Object> map) throws Exception;
	
	/**
	 * 方法描述：更新数据
	 * 返回类型：void
	 * @param data
	 * @param map
	 * @throws Exception
	 */
	public void updateData(ActiveSearchData data,Users user) throws Exception;
	
	/**
	 * 方法描述： 根据ID查询数据
	 * 返回类型：ActiveSearchData
	 * @param asd_id
	 * @return
	 * @throws Exception
	 */
	public ActiveSearchData selectById(String asd_id) throws Exception;
}
