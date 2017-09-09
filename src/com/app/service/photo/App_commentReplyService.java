package com.app.service.photo;

import java.util.List;

import com.app.dto.photo.App_commentReplyDTO;
import com.op.plugin.page.Page;
/** 
 * 照片评论(app_commentReply)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-19 21:47:45 
 */  
public interface App_commentReplyService {

	/**
	 * 根据描述ID查询回复
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<App_commentReplyDTO> findReplyComment(Page<String> page) throws Exception;

	/**
	 * 删除回复
	 */
	void deleteReply(String id) throws Exception;
	
}
