package com.op.service.usercenter.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.usercenter.Issue;
import com.op.entity.usercenter.IssueInfo;
import com.op.plugin.page.Page;
import com.op.service.usercenter.IssueService;

/**
 * 意见建议(实现类)
 * @author panyongwei
 * Date: 2016年1月11日 11:49:00
 */
@Service("issueServiceImpl")
public class IssueServiceImpl implements IssueService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 查询所有意见建议
	 */
	public List<Issue> selectIssue(Page<IssueInfo> page) throws Exception {
		return (List<Issue>) dao.findForList("issueMapper.selectIssuePage", page);
	}

	/**
	 * 根据id审核意见和建议
	 */
	public void updateIssue(Map<String, Object> map) throws Exception {
		dao.update("issueMapper.updateIssue", map);
	}
	
}
