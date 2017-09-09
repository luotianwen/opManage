package com.op.service.lines.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.lines.SubsectionLines;
import com.op.service.lines.LinesService;

/** 
 * 活动线路表(lines)实现类
 * @author 潘永威
 * @version Revision: 1.00 
 *  Date: 2015年12月14日 15:22:35
 */ 
@Service("linesServiceImpl")
public class LinesServiceImpl implements LinesService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 列表(全部)
	 */
	@Override
	public List<SubsectionLines> selectList() throws Exception {
		return (List<SubsectionLines>) dao.findForList("linesMapper.selectList", null);
	}

	/**
	 * 方法描述：根据ID查看该线路详情
	 * 返回类型：Lines
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public SubsectionLines selectLineById(String id) throws Exception {
		
		return (SubsectionLines) dao.findForObject("linesMapper.selectLineById", id);
	}
}
