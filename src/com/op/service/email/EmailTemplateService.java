package com.op.service.email;

import java.util.List;
import java.util.Map;

import com.op.entity.email.EmailTemplate;
import com.op.plugin.page.Page;

public interface EmailTemplateService {

	/**
	 * 查询模板数据
	 * @return
	 * @throws Exception
	 */
	List<EmailTemplate> selectEmailTemplate(Page<EmailTemplate> page)throws Exception;
	
	/**
	 * 根据模板ID查询模板数据
	 * @return
	 * @throws Exception
	 */
	EmailTemplate findEmailTemplateById(String id)throws Exception;	
	/**
	 * 更新模板数据
	 * @return
	 * @throws Exception
	 */
	void updateEmailTemplate(Map<String,Object> map)throws Exception;
	
	/**
	 * 初始化邮件发送模板数据
	 * @return
	 * @throws Exception
	 */
	void initEmailTemplate()throws Exception;
}
