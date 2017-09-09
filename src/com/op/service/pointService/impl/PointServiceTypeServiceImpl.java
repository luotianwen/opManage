package com.op.service.pointService.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;

import com.op.dao.BaseDao;
import com.op.dto.pointService.CategoryNameAndOrderDTO;
import com.op.dto.pointService.InsertCategoryDTO;
import com.op.entity.pointService.PointServiceType;
import com.op.service.pointService.PointServiceTypeService;
import com.op.util.SerializationUtil;
import com.op.util.jedis.RedisUtil;


@Service("pointServiceTypeServiceImpl")
public class PointServiceTypeServiceImpl implements PointServiceTypeService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	
	/**
	 * 方法描述：所有一级分类集合
	 * 实现接口：@see com.op.service.pointService.PointServiceTypeService#all()
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PointServiceType> oneTypeAll() throws Exception {
		byte[] key = "POINT_SERVICE_TYPES".getBytes();
		Jedis jedis = RedisUtil.getJedis();
		byte[] types = jedis.get(key);
		
		if(types != null){
			return (List<PointServiceType>) SerializationUtil.deserialize(types);
		}
		
		List<PointServiceType> list = (List<PointServiceType>) dao.findForList("pointServiceTypeMapper.oneTypeAll",null);
		
		for(Iterator<PointServiceType> it=list.iterator();it.hasNext();){
			PointServiceType pst = it.next();
			jedis.set(("POINT_SERVICE_TYPES"+pst.getOneTypeId()).getBytes(), SerializationUtil.serialize(pst.getList()));
			pst.setList(null);
		}
		
		if(list.size()>0){
			jedis.set(key, SerializationUtil.serialize(list));	
		}
		
		return list;
	}
	
	
	void updateRedisCategory() throws Exception{
		byte[] key = "POINT_SERVICE_TYPES".getBytes();
		Jedis jedis = RedisUtil.getJedis();
		List<PointServiceType> list = (List<PointServiceType>) dao.findForList("pointServiceTypeMapper.oneTypeAll",null);
		for(Iterator<PointServiceType> it=list.iterator();it.hasNext();){
			PointServiceType pst = it.next();
			jedis.set(("POINT_SERVICE_TYPES"+pst.getOneTypeId()).getBytes(), SerializationUtil.serialize(pst.getList()));
			pst.setList(null);
		}
		jedis.set(key, SerializationUtil.serialize(list));
	}


	/**
	 * 方法描述：添加分类
	 * 实现接口：@see com.op.service.pointService.PointServiceTypeService#addType(com.op.entity.pointService.PointServiceType)
	 * @param type
	 * @throws Exception
	 */
	@Override
	public void addTypes(InsertCategoryDTO dto) throws Exception {
		// 清除list为空的元素
		List<CategoryNameAndOrderDTO> list = dto.getCategory();
		for(int i=0,len=list.size();i<len;){
			CategoryNameAndOrderDTO cnod = list.get(i);
			if(StringUtils.isEmpty(cnod.getCategoryName())){
				list.remove(i);
				len=list.size();
			}else{
				i++;
			}
		}
		dao.save("pointServiceTypeMapper.addTypes", dto);
		updateRedisCategory();
	}


	/**
	 * 方法描述：删除分类
	 * 实现接口：@see com.op.service.pointService.PointServiceTypeService#deleteTypes(java.lang.String, java.lang.String)
	 * @param id
	 * @param level
	 * @throws Exception
	 */
	@Override
	public void deleteTypes(Map<String,String> map) throws Exception {
		dao.update("pointServiceTypeMapper.updateCategoryIsDelete", map);
		updateRedisCategory();
	}


	/**
	 * 方法描述：编辑分类
	 * 实现接口：@see com.op.service.pointService.PointServiceTypeService#editType(java.util.Map)
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void editType(Map<String, Object> map) throws Exception {
		dao.update("pointServiceTypeMapper.editType", map);
		updateRedisCategory();
	}


	/**
	 * 方法描述：锁定/解锁分类
	 * 实现接口：@see com.op.service.pointService.PointServiceTypeService#lockOrUnLock(java.util.Map)
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void lockOrUnLock(Map<String, Object> map) throws Exception {
		dao.update("pointServiceTypeMapper.lockOrUnLock", map);
		updateRedisCategory();
	}
}
