package com.op.service.activity;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.entity.activity.Activity;
import com.op.entity.activity.ActivityInfo;
/**
 * 项目名：outdoorPortal
 * 类描述：活动Service
 * 创建人：Yan
 * 创建时间： 2015-12-14 上午11:54:54
 * 最后修改时间：2015-12-14上午11:54:54
 */
import com.op.plugin.page.Page;

/**
 * 数据库中(活动信息)接口
 * @author PYW
 * Date: 2015年12月18日 09:29:12
 */
@Service("activityService")
public interface ActivityService {
 
	/**
	 * 获取待审活动列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ActivityInfo> getActivityByStateListPage(Page<ActivityInfo> page)throws Exception;
	
	/**
	 * 活动审核
	 * @param map
	 */
	public void updateActivityState(Map<String, Object> map)throws Exception;

	/**
	 * 关闭活动审核
	 */
	public void closeActive(Map<String,Object> map) throws Exception;
	
	/**
	 * 方法描述：根据活动ID查询活动详情
	 * 返回类型：Activity
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Activity detailById(int id) throws Exception;

	/**
	 * 查询所有申请关闭活动
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ActivityInfo> getActivityByClose(Page<ActivityInfo> page)throws Exception;
	
}
