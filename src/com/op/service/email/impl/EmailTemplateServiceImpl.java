package com.op.service.email.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.op.dao.BaseDao;
import com.op.entity.email.EmailTemplate;
import com.op.plugin.page.Page;
import com.op.service.email.EmailTemplateService;
import com.op.util.Const;
import com.op.util.SerializationUtil;
import com.op.util.jedis.RedisUtil;
/**
 * 
*    
* 项目名称：outdoorPortal   
* 类名称：EmailTemplateServiceImpl   
* 类描述：   
* 创建人：Win Zhong   
* 创建时间：2015年12月28日 下午1:23:29   
* 修改人：Win Zhong   
* 修改时间：2015年12月28日 下午1:23:29   
* 修改备注：   
* @version    
*
 */
@Service("emailTemplateServiceImpl")
public class EmailTemplateServiceImpl implements EmailTemplateService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 获取模板数据
	 * @return
	 * @throws Exception
	 */
	public List<EmailTemplate> selectEmailTemplate(Page<EmailTemplate> page)throws Exception{
		List<EmailTemplate>  emailTemplateList = (List<EmailTemplate>) dao.findForList("EmailTemplate.selectEmailTemplatePage", page);
		return emailTemplateList;
	}
	
	/**
	 * 根据模板ID查询模板数据
	 * @return
	 * @throws Exception
	 */
	public EmailTemplate findEmailTemplateById(String id)throws Exception{
		EmailTemplate  emailTemplate = (EmailTemplate) dao.findForObject("EmailTemplate.findEmailTemplateById", id);
		return emailTemplate;
	}
	
	/**
	 * 更新模板数据
	 * @return
	 * @throws Exception
	 */
	public void updateEmailTemplate(Map<String,Object> map)throws Exception{
		
		dao.update("EmailTemplate.updateEmailTemplate", map);
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}
	
	
	/**
	 * 初始化邮件发送模板数据
	 * @return
	 * @throws Exception
	 */
	public void initEmailTemplate()throws Exception{
		List<EmailTemplate>  emailTemplateList = (List<EmailTemplate>) dao.findForList("EmailTemplate.initEmailTemplate", null);
		Map<String,EmailTemplate> map = new HashMap<String,EmailTemplate>();
		for(EmailTemplate emailTemplate:emailTemplateList){
				map.put(emailTemplate.getEt_id(), emailTemplate);
		}
	  	  Jedis jedis = RedisUtil.getJedis();
	  	  jedis.del("EmailTemplate".getBytes());
	  	  jedis.set("EmailTemplate".getBytes(),SerializationUtil.serialize(map));
		
	}
	
	
}
