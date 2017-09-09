package com.op.dto.pointService;

public class CategoryNameAndOrderDTO {
	// 类型名称
	String categoryName;
	// 菜单排序
	int orderNumber;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
