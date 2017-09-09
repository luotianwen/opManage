package com.op.service.usercenter;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.entity.usercenter.ComplaintLeadInfo;
import com.op.plugin.page.Page;


/**
 * 项目名：outdoorPortal
 * 类描述：投诉领队接口
 * 创建人：panyongwei
 * 创建时间： 2016年1月13日 14:38:26
 */
@Service("complaintLeadService")
public interface ComplaintLeadService {
	/**
	 * 查询所有投诉领队信息
	 */
	List<ComplaintLeadInfo> selectComplaintLead(Page<ComplaintLeadInfo> page) throws Exception;
	/**
	 * 根据id处理投诉信息
	 */
	void updateComplaintLead(Map<String, Object> map) throws Exception;
	
}
