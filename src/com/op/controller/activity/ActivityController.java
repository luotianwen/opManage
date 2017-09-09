package com.op.controller.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.dto.activity.ActiveSignupDTO;
import com.op.dto.order.ActivityRefundOrdersDTO;
import com.op.entity.activity.ActiveSignup;
import com.op.entity.activity.ActivityInfo;
import com.op.entity.alipay.Refund;
import com.op.entity.alipay.RefundInfo;
import com.op.entity.channels.Channels;
import com.op.entity.classification.Classification;
import com.op.entity.log.ActivityOrderLog;
import com.op.plugin.alipay.util.UtilDate;
import com.op.plugin.page.Page;
import com.op.service.activity.ActiveSignupService;
import com.op.service.activity.ActivityService;
import com.op.service.channels.ChannelsService;
import com.op.service.classification.ClassificationService;
import com.op.service.lines.LinesService;
import com.op.service.log.ActivityOrderLogService;
import com.op.service.suitablecrowd.SuitableCrowdService;
import com.op.service.zd.ActiveChildrenAgeService;
import com.op.service.zd.ActiveDifficultyTypeService;
import com.op.util.Const;
import com.op.util.PropertyFile;
/** 
 * 活动发布信息表(activity)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2015-11-30 11:16:49 
 */ 
@Controller
@RequestMapping(value="/activity")
public class ActivityController extends BaseController {
	
	// 活动service
	@Resource(name="activityServiceImpl")
	private ActivityService activityServiceImpl;
	
	// 活动频道
	@Resource(name="channelsServiceImpl")
	private ChannelsService channelsServiceImpl;
	
	// 活动类型
	@Resource(name="classificationServiceImpl")
	private ClassificationService classificationServiceImpl;
	
	// 适合人群
	@Resource(name="suitableCrowdServiceImpl")
	private SuitableCrowdService suitableCrowdServiceImpl;
	
	// 活动等级
	@Resource(name="activeDifficultyTypeServiceImpl")
	private ActiveDifficultyTypeService activeDifficultyTypeServiceImpl;
	
	// 年龄段
	@Resource(name="activeChildrenAgeServiceImpl")
	private ActiveChildrenAgeService activeChildrenAgeServiceImpl;

	// 线路
	@Resource(name="linesServiceImpl")
	private LinesService linesServiceImpl;
	
	// 活动退款订单
	@Resource(name="activeSignupServiceImpl")
	private ActiveSignupService activeSignupServiceImpl;
	
	// 活动退款订单
	@Resource(name="activityOrderLogServiceImpl")
	private ActivityOrderLogService activityOrderLogServiceImpl;
	
	/**
	 * 获取待审核的活动列表
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/pending")
	public ModelAndView getPendingActivitylist(Page<ActivityInfo> page,ActivityInfo activity,ModelAndView mv) throws Exception{
		//待审核状态
		int states[] = {2,4};
		String activityId = this.getParameter("activityId");
		if(!StringUtils.isEmpty(activityId)){
			activity.setId(Integer.parseInt(activityId));
		}
		activity.setStates(states);
		page.setT(activity);
		List<Channels> channelsList = channelsServiceImpl.selectList();//查询频道信息
		List<Classification> classificationList = classificationServiceImpl.selectList();//查询活动类型信息
		List<ActivityInfo> activityList =  activityServiceImpl.getActivityByStateListPage(page);
		mv.addObject("page",page);
		mv.addObject("parameter", activity);
		mv.addObject("activityList", activityList);
		mv.addObject("channelsList",channelsList);
		mv.addObject("classificationList",classificationList);
		mv.setViewName("admin/activity/activity");
		return mv;
	}
	/**
	 *根据活动ID查看待审核活动详细信息
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/pending/{id}")
	public ModelAndView getPendingActivity(ModelAndView mv,@PathVariable("id") String id) throws Exception{
		Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
		mv.addObject("url", prop.get("url"));
		mv.addObject("id", id);
		mv.setViewName("admin/activity/examine");
		return mv;
	}
	/**
	 * 审核活动 
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/examine")
	@ResponseBody
	public Map<String, Object> activityExamine(ModelAndView mv) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("id", this.getParameter("id"));
			map.put("state", this.getParameter("state"));
			map.put("auditor", this.getSessionUser().getuId());
			map.put("auditTime", new Date());
			map.put("auditNotes", this.getParameter("auditNotes"));
			activityServiceImpl.updateActivityState(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			
			//Solr增量更新地址 活动审核成功后刷新Solr索引 
			//http://192.168.1.222:8080/search/activity/dataimport?command=delta-import&clean=false&commit=true
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新异常");
		} 
		return map;
	}
	
	/**
	 * 获取审核通过发布成功的活动列表
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView getActivityManagelist(Page<ActivityInfo> page,ActivityInfo activity,ModelAndView mv) throws Exception{
		//审核通过发布成功状态
		int states[] = {5};
		String activityId = this.getParameter("activityId");
		if(!StringUtils.isEmpty(activityId)){
			activity.setId(Integer.parseInt(activityId));
		}
		activity.setStates(states);
		page.setT(activity);
		List<Channels> channelsList = channelsServiceImpl.selectList();//查询频道信息
		List<Classification> classificationList = classificationServiceImpl.selectList();//查询活动类型信息
		List<ActivityInfo> activityList =  activityServiceImpl.getActivityByStateListPage(page);
		mv.addObject("page",page);
		mv.addObject("parameter", activity);
		mv.addObject("activityList", activityList);
		mv.addObject("channelsList",channelsList);
		mv.addObject("classificationList",classificationList);
		
		Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
		mv.addObject("url", prop.get("url"));
		
		mv.setViewName("admin/activity/manage");
		
		return mv;
	}	
	
	
	/**
	 * 活动退款管理
	 * @param page
	 * @param activeSignup
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/refund")
	public ModelAndView refund(Page<ActivityRefundOrdersDTO> page,ActivityRefundOrdersDTO activeOrder,ModelAndView mv) throws Exception{
		page.setT(activeOrder);
		List<ActivityRefundOrdersDTO> refundList = activeSignupServiceImpl.getActiveRefundListPage(page);
		mv.addObject("page",page);
		mv.addObject("refundList", refundList);
		mv.addObject("parameter", activeOrder);
		mv.setViewName("activity/refund/activityRefund");
		return mv;
	}

	/**
	 * 活动退款清单
	 * @param mv
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/refundDetails/{ids}")
	public ModelAndView refundDetails(ModelAndView mv,@PathVariable("ids") String ids) throws Exception{
		 	String[] order_id = ids.split("_");
			//检查退款订单是否有相同交易号
			List<Map<String,Object>> checkJyhList = activeSignupServiceImpl.jcxtjyh(order_id);
			if(checkJyhList.size()>0){
				Map<String,Object> map = checkJyhList.get(0);
				if(Integer.valueOf(map.get("COUNTS").toString()) > 1){
					mv.addObject("msg", "批量退款中存在相同的交易号：<strong>"+map.get("ASU_TRADE_NO")+"</strong>"); 
					mv.setViewName("activity/refund/errRefund");
					return mv;
				}
			}
		 	List<ActiveSignup> refundList = activeSignupServiceImpl.getActiveRefundByIds(order_id);
		 	mv.addObject("ids", ids);
		 	mv.addObject("refundList", refundList);
			mv.setViewName("activity/refund/refundDetails");
		return mv;
	}
	
	
	
	/**
	 * 活动退款
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/refund/{ids}")
	public ModelAndView refundById(ModelAndView mv,@PathVariable("ids") String ids,HttpSession session) throws Exception{
		String[] order_id = ids.split("_");
		//检查退款订单是否有相同交易号
		List<Map<String,Object>> checkJyhList = activeSignupServiceImpl.jcxtjyh(order_id);
		if(checkJyhList.size()>0){
			Map<String,Object> map = checkJyhList.get(0);
			if(Integer.valueOf(map.get("COUNTS").toString()) > 1){
				mv.addObject("msg", "批量退款中存在相同的交易号：<strong>"+map.get("ASU_TRADE_NO")+"</strong>"); 
				mv.setViewName("activity/refund/errRefund");
				return mv;
			}
		}
		//获取待退款的订单信息
	 	List<ActiveSignup> refundOrderList = activeSignupServiceImpl.getActiveRefundByIds(order_id);
	 	//生成退款批次号
	 	Random randomNumber = new Random();
	 	String batch_no = UtilDate.getOrderNum()+Const.ACTIVITY_REFUND_TYPE+(randomNumber.nextInt(10000)+100);
	 	//修改订单退款状态为退款中
	 	activeSignupServiceImpl.updateRefundState(order_id, 1,batch_no);
	 	
		if(refundOrderList != null){
			//退款集合
			List<RefundInfo> refundinfoList = new ArrayList<RefundInfo>();
			//封装的退款实体
			Refund refund = new Refund();
			int size = refundOrderList.size();
			for(int i =0;i<size;i++){
				ActiveSignup as = refundOrderList.get(i);
				RefundInfo refundInfo = new RefundInfo();
				//refundInfo.setRefund_fee(as.getAsu_refund_price().toString());
				refundInfo.setTrade_no(as.getAsu_trade_no());
				//refundInfo.setRefund_reason("《活动订单退款详情》订单号:"+as.getAsu_order_id()+" 退款金额:"+as.getAsu_refund_price());
				refundinfoList.add(refundInfo);
			}
			
			//设置退款批次号
			refund.setBatch_no(batch_no);
			refund.setRefundinfoList(refundinfoList);
			refund.setNotify_url("/activity/refundResult/{batch_no}.html");
			session.setAttribute("refund", refund); 
			mv.setViewName("redirect:/refund/payBatchPwdRefund.html");
		}else{
			logger.info("处理退款请求失败");
			mv.setViewName("pay/errRefund");
		}	 
		return mv;
	}
	
	
	/**
	 * 活动退款管理
	 * @param page
	 * @param activeSignup
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/refundResult/{batch_no}")
	public ModelAndView refundResult(ModelAndView mv,@PathVariable("batch_no") String batch_no,HttpSession session) throws Exception{

		//批量退款数据中转账成功的笔数
		//String success_num = this.getParameter("success_num");

		//批量退款数据中的详细信息
		//String result_details = this.getParameter("result_details");
		
		 
		
		/*RefundInfo refundInfo = (RefundInfo)session.getAttribute(batch_no);
		if(refundInfo != null){
			 if("success".equals(refundInfo.getRefund_result())){
				 activeSignupServiceImpl.updateRefundType(refundInfo.getOrder_id());
				 mv.setViewName("pay/refundSuccess");
			 }else{
				 mv.setViewName("pay/errRefund");
			 }
			
		}else{
			logger.info("处理退款请求失败");
			mv.setViewName("pay/errRefund");
		}	*/
		return mv;
	}
 
	/**
	 * 活动退款
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/info/{orderId}")
	public ModelAndView refundByOrderId(ModelAndView mv,@PathVariable("orderId") String orderId) throws Exception{
		//获取待退款的订单信息
		ActiveSignupDTO refundOrder = activeSignupServiceImpl.getActiveRefundByOrderId(orderId);
	 	//获取日志信息
	 	List<ActivityOrderLog> log = activityOrderLogServiceImpl.getLogByOrderId(orderId);
		mv.addObject("orderInfo", refundOrder);
		mv.addObject("log", log);
		mv.setViewName("activity/refund/refundInfo");
		return mv;
	}
	
	/**
	 * 查询所有关闭活动
	 */
	@RequestMapping("/closeList")
	public ModelAndView closeList(ModelAndView mv,Page page){
		try {
			List<ActivityInfo> activityList =  activityServiceImpl.getActivityByClose(page);
			mv.addObject("page",page);
			mv.addObject("activityList",activityList);
			mv.setViewName("admin/activity/close-activity");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	/**
	 *根据活动ID查看待审核活动详细信息
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/close/{id}")
	public ModelAndView close(ModelAndView mv,@PathVariable("id") String id) throws Exception{
		Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
		mv.addObject("url", prop.get("url"));
		mv.addObject("id", id);
		mv.setViewName("admin/activity/close");
		return mv;
	}
	
	/**
	 * 审核活动 
	 * @param page
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/closeActive")
	@ResponseBody
	public Map<String, Object> closeActive() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("id", this.getParameter("id"));
			map.put("state", this.getParameter("state"));
			activityServiceImpl.closeActive(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新异常");
		} 
		return map;
	}
	
	
}
