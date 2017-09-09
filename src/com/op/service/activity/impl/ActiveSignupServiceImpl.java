package com.op.service.activity.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.dto.activity.ActiveSignupDTO;
import com.op.dto.order.ActivityRefundOrdersDTO;
import com.op.entity.activity.ActiveSignup;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.activity.ActiveSignupService;
import com.op.util.Const;

@Service("activeSignupServiceImpl")
public class ActiveSignupServiceImpl implements ActiveSignupService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

    /**
     * 	查询有退款的活动订单	
     * @param page
     * @return
     * @throws Exception
     */
	public List<ActivityRefundOrdersDTO> getActiveRefundListPage(Page page) throws Exception{
		
		return (List<ActivityRefundOrdersDTO>)dao.findForList("activeSignupMapper.getActiveRefundListPage",page);
	}
	
    /**
     * 根据订单ID查询退款订单详细详细
     * @param orderId
     * @return
     * @throws Exception
     */
	public ActiveSignupDTO getActiveRefundByOrderId(String orderId) throws Exception{
		return (ActiveSignupDTO)dao.findForObject("activeSignupMapper.getActiveRefundByOrderId",orderId);
	 }
	
    /**
     * 检查退款订单是否有相同交易号
     * @param ids
     * @return
     * @throws Exception
     */
	public List<Map<String,Object>> jcxtjyh(String[] ids) throws Exception{
		return (List<Map<String,Object>>)dao.findForList("activeSignupMapper.jcxtjyh",ids);
	}
    /**
     * 查询详细的退款信息
     * @param ids
     * @return
     * @throws Exception
     */
	public List<ActiveSignup> getActiveRefundByIds(String[] ids) throws Exception{
		
		return (List<ActiveSignup>)dao.findForList("activeSignupMapper.getActiveRefundById",ids);
	}
	
	/**
	 * 修改退款成功的订单状态
	 * @param order_id 订单id
	 * @param state 订单状态 （1：退款中；2：退款完成；3：退款失败）
	 * @param batch_no 退款批次号
	 * @throws Exception
	 */
	public void updateRefundState(String[] order_id,int state,String batch_no) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("asu_order_id", order_id);
		map.put("state", state);
		map.put("batch_no", batch_no);
 		Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
 		map.put("aol_info", "您的退款申请已开始处理，预计72小时内到账，若超时未到账，请联系客服处理。");
 		// 操作人ID
 		map.put("aol_create_user_id", user.getuId());
 		// 操作人姓名
 		map.put("aol_create_user_name", user.getuName());
 		dao.update("activeSignupMapper.updateRefundState", map);
 		dao.save("activityOrderLogMapper.insertLog", map);
	}
	
    /**
     * 根据批次号查询退款成功状态未更新的订单
     * @param refund_batch_number
     * @return
     * @throws Exception
     */
	public List<ActiveSignup> getActiveRefundByBatchNumber(String refund_batch_number) throws Exception{
		return (List<ActiveSignup>)dao.findForList("activeSignupMapper.getActiveRefundByBatchNumber",refund_batch_number);
	}
	
/*	*//**
	 * 修改退款成功的订单状态
	 * @param asu_trade_no 支付流水号
	 * @param batch_no 退款批次号 
	 * @param state 订单状态 （1：退款中；2：退款完成；3：退款失败）
	 * @throws Exception
	 *//*
	public void updateRefundState(String asu_trade_no,String batch_no,int state) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", state);
		map.put("batch_no", batch_no);
		map.put("aol_create_user_id", "系统");
 		Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
 		map.put("aol_info", "退款已完成，若未到账，请联系客服处理。");
 		// 操作人姓名
 		map.put("aol_create_user_name", "系统");
 		dao.update("activeSignupMapper.updateReturnRefundState", map);
 		dao.save("activityOrderLogMapper.insertLog2", map);
	}*/
	
	/**
	 * 修改退款成功的订单状态
	 * @param list 退款信息集合
	 * @param state 订单状态 （1：退款中；2：退款完成；3：退款失败）
	 * @throws Exception
	 */
	public void updateRefundState(List<Map<String,Object>>  list) throws Exception{
		
		List<Map<String,Object>>  logList = new ArrayList<Map<String,Object>>();
		int size = list.size();
		for(int i=0;i<size;i++){
			Map<String,Object> mapList = list.get(i);
			Map<String,Object> map = new HashMap<String,Object>();
			// 操作人姓名
	 		map.put("aol_create_user_name", "系统");
	 		map.put("aol_create_user_id", null);
	 		//交易号
	 		map.put("asu_trade_no", mapList.get("asu_trade_no"));
	 		//退款批次号
	 		map.put("batch_no", mapList.get("batch_no"));
			if(mapList.get("state").equals(2)){
				map.put("aol_info", "退款已完成，若未及时到账，请联系客服处理。");
			}else if(mapList.get("state").equals(3)){
				map.put("aol_info", "退款成功,自动关闭退款，如有疑问，请联系客服处理。");
			}else{
				map.put("aol_info", "退款失败，如有疑问，请联系客服处理。");
			}
			logList.add(map);
		}
		
		dao.update("activeSignupMapper.updateReturnRefundStateByList", list);
		dao.save("activityOrderLogMapper.insertLogByList", logList);
	}
	
	
	
	
	
	
	/***********************************************************************************************************/
	

	/**
	 * 获取系统所有活动订单
	 * @param page
	 * @return
	 */
	public List<ActiveSignupDTO> getAllOrder(Page<?> page)throws Exception{
		return (List<ActiveSignupDTO>)dao.findForList("activeSignupMapper.getAllOrderListPage", page);
	}
	
}
