package com.op.task;

import com.op.entity.users.Users;


/**
 * 
 * ClassName: AvatarUploadOss 
 * @Description: 上传头像到阿里云OSS
 * @author WinZhong
 * @date 2016年1月21日 下午3:51:23
 */
public interface AvatarUploadOss {
	
	/**
	 * 
	 * @Description: 
	 * @param user   
	 * @return void  
	 * @author WinZhong
	 * @date 2016年1月21日 下午4:01:40
	 */
	void upload(Users user);
	

}
