package com.op.entity.alipay;

import java.util.List;

public class Refund {
	
 
	/*
	 * 批次号
	 */
	private String batch_no;
	
	/*
	 * 通知结果url
	 */
	private String notify_url;
	
	/*
	 * 退款结果
	 */
	private String refund_result;	
	/*
	 *签名 
	 */
	private String sign;
	
	/*
	 * 退款订单信息列表
	 */
	private List<RefundInfo> refundinfoList;
 

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getRefund_result() {
		return refund_result;
	}

	public void setRefund_result(String refund_result) {
		this.refund_result = refund_result;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public List<RefundInfo> getRefundinfoList() {
		return refundinfoList;
	}

	public void setRefundinfoList(List<RefundInfo> refundinfoList) {
		this.refundinfoList = refundinfoList;
	}	
	 
	

}
