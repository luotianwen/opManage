package com.op.service.screening.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.op.dao.BaseDao; 
import com.op.dto.screening.ScreeningDTO;
import com.op.entity.screening.Screening;
import com.op.plugin.page.Page;
import com.op.service.screening.ScreeningService;
import com.op.util.SerializationUtil;
import com.op.util.jedis.RedisUtil;

/** 
 * 筛选条件(screening)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-08-20 13:25:21 
 */  
@Service("screeningServiceImpl")
public class ScreeningServiceImpl implements ScreeningService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 新增筛选条件
	 * @param screening
	 * @throws Exception
	 */
    public void addScreening(Screening screening) throws Exception{
    	dao.save("screeningMapper.addScreening", screening);
    	
    	List<ScreeningDTO> list = (List<ScreeningDTO>) dao.findForList("screeningMapper.findAllScreening", screening.getSc_modularType());
		
    	Jedis jedis = RedisUtil.getJedis();
		jedis.set((screening.getSc_modularType()+"Screening").getBytes(),SerializationUtil.serialize(list));
    };
    
    /**
     * 查询所有筛选条件
     * @return
     * @throws Exception
     */
    public List<Screening> findAllScreening(Page<Map<String,String>> page) throws Exception{
    	return (List<Screening>) dao.findForList("screeningMapper.findAllScreeningPage", page);
    };
    
    /**
     * 查询所有子筛选条件
     * @return
     * @throws Exception
     */
    public List<Screening> findScreeningByParentId(Map<String,String> map) throws Exception{
    	return (List<Screening>) dao.findForList("screeningMapper.findScreeningByParentId", map);
    }
    
    /**
     * 修改筛选条件
     * @param screening
     * @throws Exception
     */
    public void updateScreening(Screening screening) throws Exception{
    	dao.update("screeningMapper.updateScreening", screening);
    	
    	List<ScreeningDTO> list = (List<ScreeningDTO>) dao.findForList("screeningMapper.findAllScreening", screening.getSc_modularType());
		
    	Jedis jedis = RedisUtil.getJedis();
		jedis.set((screening.getSc_modularType()+"Screening").getBytes(),SerializationUtil.serialize(list));
    };
    
    /**
     * 删除筛选条件
     * @param screening
     * @throws Exception
     */
    public void deleteScreening(String id,String sc_modularType) throws Exception{
    	dao.delete("screeningMapper.deleteScreening", id);
    	
    	List<ScreeningDTO> list = (List<ScreeningDTO>) dao.findForList("screeningMapper.findAllScreening", sc_modularType);
		
    	Jedis jedis = RedisUtil.getJedis();
		jedis.set((sc_modularType+"Screening").getBytes(),SerializationUtil.serialize(list));
    };
	
    /**
     * 查询所有父级条件
     */
    public List<Screening> goScreeningAddGetParentList(String type) throws Exception{
    	return (List<Screening>) dao.findForList("screeningMapper.goScreeningAddGetParentList", type);
    	
    }
    
    /**
     * 根据ID查询筛选条件
     */
    public Screening findScreeningById(String id) throws Exception{
    	return (Screening) dao.findForObject("screeningMapper.findScreeningById", id);
    }   
    
}
