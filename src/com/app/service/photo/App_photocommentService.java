package com.app.service.photo;

import java.util.List;

import com.app.dto.photo.App_photocommentDTO;
import com.op.plugin.page.Page;
/** 
 * 评论照片(app_photocomment)接口
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-15 14:13:04 
 */  
public interface App_photocommentService {

	/**
	 * 查询所有照片评论
	 * @param page
	 * @return
	 * @throws Exception
	 */
    public List<App_photocommentDTO> findAllComment(Page<String> page) throws Exception;

	
}
