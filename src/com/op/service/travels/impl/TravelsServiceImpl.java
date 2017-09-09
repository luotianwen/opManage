package com.op.service.travels.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.dto.travels.TravelsDTO;
import com.op.entity.travels.Travels;
import com.op.plugin.page.Page;
import com.op.service.travels.TravelsService;

/** 
 * 游记(travels)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-04-18 14:30:31 
 */  
@Service("travelsServiceImpl")
public class TravelsServiceImpl implements TravelsService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有游记
	 */
	public List<TravelsDTO> findTravelsAllPage(Page<Map<String,Object>> page) throws Exception{
		return (List<TravelsDTO>) dao.findForList("travelsMapper.getTravelsAllPage", page);
	}
	
	/**
	 * 根据ID查询游记
	 */
	public Travels findTravelsById(Map<String,String> map) throws Exception{
		return (Travels) dao.findForObject("travelsMapper.findTravelsById", map);
	}
	
	/**
	 * 删除游记
	 */
	public void delTravels(Travels travels,Map<String,Object> map) throws Exception{
		Map<String,String> travelsMap = new HashMap<String,String>();
		travelsMap.put("id", travels.getId());
		travelsMap.put("user_id", travels.getUser_id());
		
		travels = (Travels) dao.findForObject("travelsMapper.findTravelsByIdforDel", travelsMap);
		if(travels!=null){
			if("1".equals(travels.getIssued_state())||"4".equals(travels.getIssued_state())){
				dao.delete("travelsMapper.deleteTravels", travels);
				dao.delete("travelsContentMapper.deleteTravels", travels);
				dao.delete("travelsTitleMapper.deleteTravels", travels);
				dao.delete("travelsPhotosMapper.deleteTravels", travels);
			}else{
				dao.update("travelsMapper.deleteTravelsByRelease", travels);
			}
			
			
		}
		
	}

	/**
	 * 审核游记
	 */
	public void examineTravels(Map<String,Object> map)throws Exception{
		dao.update("travelsMapper.examineTravels", map);
	}
	
}
