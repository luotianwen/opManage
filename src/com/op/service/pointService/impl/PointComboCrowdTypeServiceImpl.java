package com.op.service.pointService.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;

import com.op.dao.BaseDao; 
import com.op.entity.email.EmailTemplate;
import com.op.entity.pointService.PointComboCrowdType;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointComboCrowdTypeService;
import com.op.util.SerializationUtil;
import com.op.util.jedis.RedisUtil;

/** 
 * 地点项目/套餐适合人群字典表(pointComboCrowdType)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-24 13:42:52 
 */  
@Service("pointComboCrowdTypeServiceImpl")
public class PointComboCrowdTypeServiceImpl implements PointComboCrowdTypeService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 获取字典表所有数据
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PointComboCrowdType> getList(Page<?> page)throws Exception {
		return (List<PointComboCrowdType>)dao.findForList("pointComboCrowdTypeMapper.getListPage", page);
	}
	
	/**
	 * 根据id获取字典表数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PointComboCrowdType findById(String id)throws Exception {
		return (PointComboCrowdType)dao.findForObject("pointComboCrowdTypeMapper.findById", id);
	}

	/**
	 * 保存字典信息
	 * @param pointComboCrowdType
	 * @throws Exception
	 */
	public void save(PointComboCrowdType pointComboCrowdType)throws Exception {
		//判断是否是新增
		if(StringUtils.isEmpty(pointComboCrowdType.getId())){
			//新增
			dao.save("pointComboCrowdTypeMapper.save", pointComboCrowdType);
		}else{
			//更新
			dao.update("pointComboCrowdTypeMapper.update", pointComboCrowdType);
		}
	}
	

	 
	/**
	 * 异步刷新字典缓存
	 * @throws Exception
	 */
	@Async
	public void shuaxinhuancun()throws Exception {
		//获取全部字典数据
		List<PointComboCrowdType>  pointComboCrowdTypeList = (List<PointComboCrowdType>)dao.findForList("pointComboCrowdTypeMapper.getAll", null);
		Map<String,String> map = new HashMap<String,String>();
		for(PointComboCrowdType pointComboCrowdType:pointComboCrowdTypeList){
				map.put(pointComboCrowdType.getId(), pointComboCrowdType.getPcct_describe());
		}
	  	  Jedis jedis = RedisUtil.getJedis();
	  	  //删除就缓存
	  	  jedis.del("POINT_SERVICE_CROWD".getBytes());
	  	  //存入缓存
	  	  jedis.set("POINT_SERVICE_CROWD".getBytes(),SerializationUtil.serialize(map));
	}
	
}
