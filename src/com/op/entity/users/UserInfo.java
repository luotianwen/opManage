package com.op.entity.users;

/**
 * 项目名：outdoorPortal
 * 类描述：用户基本信息
 * 创建人：Yan
 * 创建时间： 2015-11-7 上午11:22:46
 * 最后修改时间：2015-11-7上午11:22:46
 */
public class UserInfo extends Users{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	//分组ID
	private String aId;
	//角色名字
	private String rName;
	
	
	public String getSex(){
		if(uSex == 1){
			return "男";
		}else{	
			return "女";
		}
	}

	public String getaId() {
		return aId;
	}


	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}



 
	
}
