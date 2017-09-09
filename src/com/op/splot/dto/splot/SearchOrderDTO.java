package com.op.splot.dto.splot;

public class SearchOrderDTO {
	String tabCode;
	String channel;
	String productName;
	String orderId;
	String create_time_star;
	String create_time_end;
	String create_time;
	String pay_time_star;
	String pay_time_end;
	String uName;
	public String getTabCode() {
		return tabCode;
	}
	public void setTabCode(String tabCode) {
		this.tabCode = tabCode;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getCreate_time_star() {
		return create_time_star;
	}
	public void setCreate_time_star(String create_time_star) {
		this.create_time_star = create_time_star;
	}
	public String getCreate_time_end() {
		return create_time_end;
	}
	public void setCreate_time_end(String create_time_end) {
		this.create_time_end = create_time_end;
	}
	public String getPay_time_star() {
		return pay_time_star;
	}
	public void setPay_time_star(String pay_time_star) {
		this.pay_time_star = pay_time_star;
	}
	public String getPay_time_end() {
		return pay_time_end;
	}
	public void setPay_time_end(String pay_time_end) {
		this.pay_time_end = pay_time_end;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
}
