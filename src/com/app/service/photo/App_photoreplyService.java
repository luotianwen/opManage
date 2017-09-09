package com.app.service.photo;

import java.util.List;

import com.app.dto.photo.App_photoreplyDTO;
import com.op.plugin.page.Page;
/** 
 * 照片回复表(app_photoreply)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-15 14:13:04 
 */  
public interface App_photoreplyService {

	/**
	 * 根据评论ID查询回复
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<App_photoreplyDTO> findReplyComment(Page<String> page) throws Exception;

	
}
