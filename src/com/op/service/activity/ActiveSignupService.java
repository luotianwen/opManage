package com.op.service.activity;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.dto.activity.ActiveSignupDTO;
import com.op.dto.order.ActivityRefundOrdersDTO;
import com.op.entity.activity.ActiveSignup;
import com.op.plugin.page.Page;

@Service("activeSignupService")
public interface ActiveSignupService {

    /**
     * 	查询有退款的活动订单	
     * @param page
     * @return
     * @throws Exception
     */
	List<ActivityRefundOrdersDTO> getActiveRefundListPage(Page page) throws Exception;
	
    /**
     * 根据订单ID查询退款订单详细详细
     * @param orderId
     * @return
     * @throws Exception
     */
	ActiveSignupDTO getActiveRefundByOrderId(String orderId) throws Exception;

    /**
     * 检查退款订单是否有相同交易号
     * @param ids
     * @return
     * @throws Exception
     */
	List<Map<String,Object>> jcxtjyh(String[] ids) throws Exception;
	
    /**
     * 查询详细的退款信息
     * @param ids
     * @return
     * @throws Exception
     */
	List<ActiveSignup> getActiveRefundByIds(String[] ids) throws Exception;
	
	/**
	 * 修改退款成功的订单状态
	 * @param order_id 订单id
	 * @param state 订单状态 （1：退款中；2：退款完成；3：退款失败）
	 * @param batch_no 退款批次号
	 * @throws Exception
	 */
	void updateRefundState(String[] order_id,int state,String batch_no) throws Exception;

/*	*//**
	 * 修改退款成功的订单状态
	 * @param asu_trade_no 支付流水号
	 * @param batch_no 退款批次号 
	 * @param state 订单状态 （1：退款中；2：退款完成；3：退款失败）
	 * @throws Exception
	 *//*
	void updateRefundState(String asu_trade_no,String batch_no,int state) throws Exception;*/
	/**
	 * 修改退款成功的订单状态
	 * @param list 退款信息集合
	 * @param state 订单状态 （1：退款中；2：退款完成；3：退款失败）
	 * @throws Exception
	 */
	void updateRefundState(List<Map<String,Object>>  list) throws Exception;
	
    /**
     *  根据批次号查询退款成功状态未更新的订单
     * @param refund_batch_number
     * @return
     * @throws Exception
     */
	List<ActiveSignup> getActiveRefundByBatchNumber(String refund_batch_number) throws Exception;

	
	/**
	 * 获取系统所有活动订单
	 * @param page
	 * @return
	 */
	List<ActiveSignupDTO> getAllOrder(Page<?> page)throws Exception;
}
