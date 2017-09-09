package com.op.dto.pointService;

import java.util.Date;
import java.util.List;

public class InsertCategoryDTO {

	// N级菜单
	int categoryLevel;
	// 类型父id
	int parentId;
	// 一级类型ID
	Integer oneTypeId;
	// 修改时间
	Date updateTime;
	// 修改人
	String updateUserId;

	List<CategoryNameAndOrderDTO> category;


	public List<CategoryNameAndOrderDTO> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryNameAndOrderDTO> category) {
		this.category = category;
	}

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Integer getOneTypeId() {
		return oneTypeId;
	}

	public void setOneTypeId(Integer oneTypeId) {
		this.oneTypeId = oneTypeId == null?0:oneTypeId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

}
