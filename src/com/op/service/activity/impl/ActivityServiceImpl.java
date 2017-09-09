package com.op.service.activity.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.activity.Activity;
import com.op.entity.activity.ActivityInfo;
import com.op.plugin.page.Page;
import com.op.service.activity.ActivityService;
import com.op.util.EhcacheUtil;

/**
 * 项目名：outdoorPortal
 * 类描述：活动Service实现类
 * 创建人：Yan
 * 创建时间： 2015-12-14 上午11:55:36
 * 最后修改时间：2015-12-14上午11:55:36
 */
@Service("activityServiceImpl")
public class ActivityServiceImpl implements ActivityService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	@Resource(name = "ehcacheUtil")
	private EhcacheUtil ehcacheUtil;
	
	
	/**
	 * 获取待审活动列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ActivityInfo> getActivityByStateListPage(Page<ActivityInfo> page)throws Exception{
		List<ActivityInfo> activityInfoList = (List<ActivityInfo>)dao.findForList("activityMapper.getActivityByStateListPage",page);
		/*Object obj = ehcacheUtil.get("page",activityInfoList.hashCode()+"");
		
		//System.err.println("《page.hashCode()****：》"+ page.hashCode());
		System.err.println("《当前页****：》"+ page.getCurrentPage());
		if( obj!= null){
//			System.err.println("《对比结果集HashCode：》"+la.hashCode());
			page.setEntityOrField(true);
			page.setTotalResult((int)obj);
			page.getCurrentResult();
			page.getShowCount();
			page.getCurrentResult();
		}else{
//			System.err.println("《存入结果集HashCode：》"+la.hashCode());
			ehcacheUtil.put("page",activityInfoList.hashCode()+"",page.getTotalResult());
		} */
		return activityInfoList;	
	}
	
	/**
	 * 活动审核
	 * @param map
	 */
	public void updateActivityState(Map<String, Object> map)throws Exception{
		dao.update("activityMapper.updateActivityState", map);
	}
	
	/**
	 * 关闭活动审核
	 */
	public void closeActive(Map<String,Object> map) throws Exception{
		dao.update("activityMapper.closeActive",  map);
	}
	
	/**
	 * 方法描述：根据活动ID查询活动详情
	 * 返回类型：Activity
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Activity detailById(int id) throws Exception {
		return (Activity)dao.findForObject("activityMapper.detailById", id);
	}
	
	/**
	 * 查询所有申请关闭活动
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ActivityInfo> getActivityByClose(Page<ActivityInfo> page)throws Exception{
		return (List<ActivityInfo>)dao.findForList("activityMapper.getActivityByClose",page);
	}
	
	
}
