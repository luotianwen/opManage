package com.op.entity.menu;

import java.io.Serializable;

/**
 * 项目名：outdoorPortal 类描述：菜单列表对象 创建人：Yan 创建时间： 2015-11-16 下午4:28:53
 * 最后修改时间：2015-11-16下午4:28:53
 */
public class ZTree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 节点ID
	private String id;
	// 父ID
	private String pId;
	// 名称
	private String name;
	// 是否选中
	private boolean checked = false;

	/*-----------------------------------------------------*/

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}


}
