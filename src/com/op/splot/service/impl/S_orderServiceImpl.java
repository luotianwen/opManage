package com.op.splot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.op.splot.dto.splot.SearchVO;
import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.plugin.page.Page;
import com.op.splot.dto.splot.SpotOrderInfoDTO;
import com.op.splot.service.S_orderService;

/** 
 * 景点订单(s_order)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-09-21 13:40:39 
 */  
@Service("s_orderServiceImpl")
public class S_orderServiceImpl implements S_orderService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
     * 查询用户所有订单信息
     * @param page

     * @return
     * @throws Exception
     */
	public List<SpotOrderInfoDTO> getAllUserOrder(Page<Map<String,Object>> page)throws Exception{
		return (List<SpotOrderInfoDTO>) dao.findForList("s_orderMapper.getAllUserOrderPage", page);
	}
	
	/**
	 * 查看订单详情
	 * @param userId 用户ID
	 * @param id 订单ID
	 * @return
	 * @throws Exception
	 */
	public SpotOrderInfoDTO findUserOrderInfo(String userId,String id) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("id", id);
		
		return (SpotOrderInfoDTO) dao.findForObject("s_orderMapper.findUserOrderInfo", map);
	}

	@Override
	public List<SpotOrderInfoDTO> spotMoneyList(SearchVO searchVO) throws Exception {

		String[] rowFields = searchVO.getRowFieldString().substring(0, searchVO.getRowFieldString().length()-1).split(",");
		searchVO.setRowFields(rowFields);
		searchVO.getRowFieldVO().setShowRowField(searchVO.getRowFields());

		return (List<SpotOrderInfoDTO>) dao.findForList("s_orderMapper.spotMoneyList",searchVO);
	}

}
