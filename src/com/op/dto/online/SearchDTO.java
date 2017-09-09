package com.op.dto.online;

import java.util.List;
import java.util.Set;

/**
 * 项目名：opManage 类描述：查询在线用户ＤＴＯ 创建人：Yan 创建时间： 2016-1-18 上午10:04:44
 * 最后修改时间：2016-1-18上午10:04:44
 */
public class SearchDTO {
	// 用户名
	private String uName;
	// 用户类型
	private int uType;
	// 用户ID集合
	private List<String> uIds;

	/*--------------------------------------------	get	&&	set ------------------------*/

	public String getuName() {
		return uName;
	}

	public List<String> getuIds() {
		return uIds;
	}

	public void setuIds(List<String> uIds) {
		this.uIds = uIds;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getuType() {
		return uType;
	}

	public void setuType(int uType) {
		this.uType = uType;
	}

}
