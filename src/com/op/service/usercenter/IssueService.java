package com.op.service.usercenter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.entity.usercenter.Issue;
import com.op.entity.usercenter.IssueInfo;
import com.op.plugin.page.Page;

/**
 * 意见建议(接口)
 * @author panyongwei
 * Date: 2016年1月11日 11:49:00
 */
@Service("issueService")
public interface IssueService {
	/**
	 * 查询所有意见建议
	 */
	List<Issue> selectIssue(Page<IssueInfo> page) throws Exception;
	/**
	 * 根据id审核意见和建议
	 */
	void updateIssue(Map<String, Object> map) throws Exception;
}
