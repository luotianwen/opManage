package com.op.entity.alipay;

public class RefundInfo {
	
	/*
	 * 支付宝交易号
	 */
	private String trade_no;	
	
	/*
	 * 退款额度
	 */
	private String refund_fee;	
 
	/*
	 * 	退款理由 及详情
	 */
	private String refund_reason;
	
 
	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getRefund_reason() {
		return refund_reason;
	}

	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
 

}
