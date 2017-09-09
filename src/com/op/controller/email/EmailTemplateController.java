package com.op.controller.email;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.email.EmailTemplate;
import com.op.plugin.page.Page;
import com.op.service.email.EmailTemplateService;
import com.op.util.Const;
import com.op.util.DateUtil;
import com.op.util.mail.EmailUtil;
/**
 * 
*    
* 项目名称：opManage   
* 类名称：EmailTemplateController   
* 类描述：   
* 创建人：Win Zhong   
* 创建时间：2015年12月29日 上午10:23:19   
* 修改人：Win Zhong   
* 修改时间：2015年12月29日 上午10:23:19   
* 修改备注：   
* @version    
*
 */
@Controller
@RequestMapping(value="/et")
public class EmailTemplateController extends BaseController{

    @Resource(name="emailTemplateServiceImpl")
    EmailTemplateService emailTemplateService;

	@Resource(name="emailUtil")
	private EmailUtil emailUtil;
	
    /**
     * 
     * @param page
     * @param emailTemplate
     * @return
     * @throws Exception
     */
	@RequestMapping(value="etList")
	public ModelAndView etList(Page<EmailTemplate> page,EmailTemplate emailTemplate)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		page.setT(emailTemplate);
		List<EmailTemplate> emailTemplateList = emailTemplateService.selectEmailTemplate(page);
		mv.addObject("page",page);
		mv.addObject("emailTemplateList",emailTemplateList);
		mv.setViewName("email/email");
		return mv;
	}

	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goEditEt/{id}")
	public ModelAndView goEditEt(@PathVariable("id") String id)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		EmailTemplate emailTemplate = emailTemplateService.findEmailTemplateById(id);
		mv.addObject("emailTemplate",emailTemplate);
		if("edit".equals(this.getParameter("type"))){
			mv.setViewName("email/editEmail");
		}else{
			mv.setViewName("email/viewEmail");
		}
		return mv;
	}
	
	@RequestMapping(value="editEt")
	@ResponseBody
	public Map<String,Object> goEditEt(){ 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("et_id", this.getParameter("et_id"));
		map.put("et_name", this.getParameter("et_name"));
		map.put("et_title", this.getParameter("et_title"));
		map.put("et_template", this.getParameter("et_template"));
		map.put("", this.getParameter(""));
		try {
			emailTemplateService.updateEmailTemplate(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新失败！");
		}
		return map;
	}

	/**
	 * 刷新Email模板缓存数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="init")
	@ResponseBody
	public Map<String,Object> init(){ 
		Map<String,Object> map = new HashMap<String,Object>(); 
		 try {
			emailTemplateService.initEmailTemplate();
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "刷新缓存失败！");
		}
		return map;
	}
	
	
	/**
	 * 测试发送邮件模板
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="testSendEmail")
	@ResponseBody
	public Map<String,Object> testSendEmail(){ 
		Map<String,Object> map = new HashMap<String,Object>(); 
		String key = this.getParameter("key");
		String email = this.getParameter("email");
		 try {
			 	switch (key) {
				case "EmailCheck":
					emailUtil.testSendCheckEmail(email,key);
					break;
				case "Welcome":
					emailUtil.testSendEmail(email,key,null);
					break;
				case "order":
					//模板参数
					Map<String,Object> parameter = new HashMap<String,Object>();
					parameter.put("date", DateUtil.getTime());
					parameter.put("orderNumber", "测试订单号9999999999");
					emailUtil.testSendEmail(email,key,parameter);
					break;

				default:
					break;
				}
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "邮件发送失败！");
		}
		return map;
	}
	
	
}
