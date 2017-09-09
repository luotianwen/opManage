package com.op.service.usercenter.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.usercenter.ComplaintLeadInfo;
import com.op.plugin.page.Page;
import com.op.service.usercenter.ComplaintLeadService;

/**
 * 项目名：outdoorPortal
 * 类描述：投诉领队实现类
 * 创建人：panyongwei
 * 创建时间： 2016年1月13日 14:37:54
 */
@Service("complaintLeadServiceImpl")
public class ComplaintLeadServiceImpl implements ComplaintLeadService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 查询所有投诉领队信息
	 */
	public List<ComplaintLeadInfo> selectComplaintLead(Page<ComplaintLeadInfo> page)
			throws Exception {
		return (List<ComplaintLeadInfo>) dao.findForList("complaintLeadMapper.selectComplaintLeadPage", page);
	}

	/**
	 * 根据id处理投诉信息
	 */
	public void updateComplaintLead(Map<String, Object> map) throws Exception {
		dao.update("complaintLeadMapper.updateComplaintLead", map);
	}

}
