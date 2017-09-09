package com.op.controller.issue;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.usercenter.IssueInfo;
import com.op.plugin.page.Page;
import com.op.service.usercenter.IssueService;
import com.op.util.Const;

/** 
 * 意见建议(issue)Controller
 * @author 世峰户外商城 
 * @version Revision: 1.00 
 *  Date: 2016-01-08 13:46:46 
 */ 
@Controller
@RequestMapping(value="/issue")
public class IssueController extends BaseController {
	
	@Resource(name="issueServiceImpl")
	private IssueService issueServiceImpl;
	
	/**
	 * 查询所有意见建议
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectIssue")
	public ModelAndView selectIssue(Page<IssueInfo> page,IssueInfo ii,ModelAndView mav) throws Exception{
		page.setT(ii);
		mav.setViewName("disputemanager/proposemanager/propose");
		mav.addObject("issueList",issueServiceImpl.selectIssue(page));//查询结果
		mav.addObject("ii",ii);//网页中传到后台的条件在传回去.
		return mav;
	}
	
	/**
	 *根据意见建议ID查看意见建议详细信息
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/issueId/{id}")
	public ModelAndView issueId(ModelAndView mv,@PathVariable String id){
		mv.addObject("id", id);
		mv.setViewName("disputemanager/proposemanager/examinepropose");
		return mv;
	}
	
	/**
	 * 根据id审核意见和建议
	 * @return
	 */
	@RequestMapping("updateIssue")
	@ResponseBody
	public Map<String,Object> updateIssue(Map<String, Object> issueMap,String id,String postil){
		Map<String,Object> map=new HashMap<String,Object>();//返回操作信息
		map.put(Const.RESPONSE_STATE, "200");//默认执行此操作成功!
		map.put(Const.SUCCESS_INFO, "操作成功!");
		try {
			issueMap.put("id", id);
			issueMap.put("postil", postil);//处理意见
			issueMap.put("operator", this.getSessionUser().getuId());//处理人
			issueServiceImpl.updateIssue(issueMap);
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "审核意见建议失败!");
		}
		return map;
	}
}