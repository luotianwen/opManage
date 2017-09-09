package com.op.controller.complaintlead;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.usercenter.ComplaintLeadInfo;
import com.op.plugin.page.Page;
import com.op.service.usercenter.ComplaintImageService;
import com.op.service.usercenter.ComplaintLeadService;
import com.op.util.Const;


/**
 * 投诉领队实体类(审核)
 * @author panyongwei
 * Date: 2016年1月13日 14:37:28
 */
@RequestMapping("/complaintLead")
@Controller
public class ComplaintLeadController extends BaseController {
		// 投诉领队
		@Resource(name="complaintLeadServiceImpl")
		private ComplaintLeadService complaintLeadServiceImpl;
		
		//证据图片
		@Resource(name="complaintImageServiceImpl")
		private ComplaintImageService complaintImageServiceImpl;
		
		/**
		 * 查询所有投诉领队信息
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/selectCL")
		public ModelAndView selectCL(Page<ComplaintLeadInfo> page,ComplaintLeadInfo cli,ModelAndView mav) throws Exception{
			page.setT(cli);
			mav.setViewName("disputemanager/activitydispute/activitydispute");
			mav.addObject("CLList",complaintLeadServiceImpl.selectComplaintLead(page));//投诉领队信息
			mav.addObject("CIList",complaintImageServiceImpl.selectCI());//证据图片
			mav.addObject("CLI",cli);//网页中传到后台的条件在传回去.
			return mav;
		}
		
		/**
		 *根据投诉领队id打开处理投诉领队页面
		 * @param page
		 * @return 
		 * @throws Exception
		 */
		@RequestMapping("/clId/{id}")
		public ModelAndView clId(ModelAndView mv,@PathVariable String id){
			mv.addObject("cl_id", id);
			mv.setViewName("disputemanager/activitydispute/complaintreview");
			return mv;
		}
		
		/**
		 * 根据投诉id处理投诉信息
		 * @return
		 */
		@RequestMapping("updateCL")
		@ResponseBody
		public Map<String,Object> updateCL(Map<String, Object> clcMap,String cl_id,int state,String handleResults){
			Map<String,Object> map=new HashMap<String,Object>();//返回操作信息
			map.put(Const.RESPONSE_STATE, "200");//默认执行此操作成功!
			map.put(Const.SUCCESS_INFO, "操作成功!");
			try {
				clcMap.put("cl_id", cl_id);//投诉id
				clcMap.put("state", state);//投诉状态
				clcMap.put("handleResults", handleResults);//处理意见
				clcMap.put("operator", this.getSessionUser().getuId());//处理人
				complaintLeadServiceImpl.updateComplaintLead(clcMap);
			} catch (Exception e) {
				map.put(Const.RESPONSE_STATE, "500");
				map.put(Const.ERROR_INFO, "审核意见建议失败!");
			}
			return map;
		}
}
