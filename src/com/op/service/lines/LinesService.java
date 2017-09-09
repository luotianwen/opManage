package com.op.service.lines;

import java.util.List;

import org.springframework.stereotype.Service;

import com.op.entity.lines.SubsectionLines;

/** 
 * 活动线路表(lines)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2015年12月14日 15:18:53
 */ 
@Service("linesService")
public interface LinesService {
	
	/**
	 * 列表(全部)
	 */
	public List<SubsectionLines> selectList() throws Exception;
	
	/**
	 * 方法描述：根据ID查看该线路详情
	 * 返回类型：Lines
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SubsectionLines selectLineById(String id) throws Exception;
	
}
