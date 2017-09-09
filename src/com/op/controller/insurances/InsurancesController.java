package com.op.controller.insurances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.dto.insurances.InsurancesAddDTO;
import com.op.dto.insurances.InsurancesDTO;
import com.op.entity.insurances.InsurancePlan;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.insurances.InsurancePlanService;
import com.op.service.insurances.InsurancesService;
import com.op.service.insurances.InsurantDateLimitService;
import com.op.util.Const;
import com.op.util.Logger;
import com.op.util.fileread.PdfRead;

/** 
 * 保险信息(Insurances)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:09 
 */ 
@Controller
@RequestMapping(value="/insurances")
public class InsurancesController extends BaseController {
	
	@Resource(name="insurancesServiceImpl")
	private InsurancesService insurancesServiceImpl;
	
	@Resource(name="insurancePlanServiceImpl")
	private InsurancePlanService insurancePlanServiceImpl;
	
	@Resource(name="insurantDateLimitServiceImpl")
	private InsurantDateLimitService insurantDateLimitServiceImpl;
	
	protected Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="init")
	@ResponseBody
	public Map<String,Object> init(){
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			Users user = this.getSessionUser();
			insurancesServiceImpl.initInsurances(user.getuId());
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("初始化保险信息失败:", e);
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "初始化保险信息失败！");
		}
		return map;
	}
	 
	/**
	 * 保存编辑的保险信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="save")
	@ResponseBody
	public Map<String,Object> save(){
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
			Users user = this.getSessionUser();
			 map.put("user_id", user.getuId());
			 map.put("productId", this.getParameter("productId"));
			 map.put("startAge", this.getParameter("startAge"));
			 map.put("endAge", this.getParameter("endAge"));
			 insurancesServiceImpl.updateInsurances(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("初始化保险信息失败:", e);
			map.clear();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "初始化保险信息失败！");
		}
		return map;
	}
	
	
	
		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="list")
		public ModelAndView list(ModelAndView mv,Page<Object> page){
			try {
				List<InsurancesDTO>  insurancesList= insurancesServiceImpl.getInsurances(page);
				mv.addObject("insurancesList", insurancesList);
				mv.setViewName("insurances/insurances");
			}catch(Exception e) {
				// TODO Auto-generated catch block
				logger.error("获取保险信息失败:", e);
			}
			
			return mv;
		}
		 
		/**
		 *  
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="edit/{productId}")
		public ModelAndView edit(ModelAndView mv,@PathVariable("productId") int productId){
			try {
				InsurancesDTO  insurances= insurancesServiceImpl.findInsurancesById(productId);
				mv.addObject("i", insurances);
				mv.setViewName("insurances/edit_insurances");
			}catch(Exception e) {
				// TODO Auto-generated catch block
				logger.error("获取保险信息失败:", e);
			}
			
			return mv;
		}

		 
		/**
		 *  
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="analysis/{productId}")
		@ResponseBody
		public Map<String,Object> analysis(ModelAndView mv,@PathVariable("productId") int productId,HttpServletRequest request){
			Map<String,Object> map = new HashMap<String,Object>(); 
			try {
				String url = this.getParameter("url"); 
				List<String> list = PdfRead.read(url, request);
				List<InsurancesAddDTO> addList = new ArrayList<InsurancesAddDTO>();
				List<InsurancePlan> planList = insurancePlanServiceImpl.getPlanByproductId(productId);
				for(String str:list){
					//System.out.println(str+"    \n长度"+str.split(" ").length);
					String[] s = str.split(" ");
					int p = 0;
					for(int i =2;i<s.length;i++){
						InsurancesAddDTO add = new InsurancesAddDTO();
						System.out.println("s[0]==========="+s[0].replaceAll("\\D+", ""));
						String[] frame = s[0].split("‐");
						if(frame.length == 1){
							frame = s[0].split("-");
						}
						add.setMinDeadline(frame[0].replaceAll("\\D+", ""));
						if(frame.length>1){
							add.setMaxDeadline(frame[1].replaceAll("\\D+", ""));
						}
						InsurancePlan plan = planList.get(p);

						add.setUnit(s[1].replaceAll("[^\u4e00-\u9fa5]", ""));
						add.setPrice(s[i].replaceAll("[^.\\d]", ""));
						System.out.println(s[1]+"==========="+s[i]+"==========="+s[i].replaceAll("[^.\\d]", "")+"**************"+add.getPrice());
						add.setPlanId(plan.getPlanId());
						add.setProductId(productId);
						addList.add(add);
						p++;
					}
				}
			 
				insurantDateLimitServiceImpl.deleteDateLimitAndPrice(productId);
				insurantDateLimitServiceImpl.saveDateLimitAndPrice(addList);
				map.clear();
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("解析失败:", e);
				map.clear();
				map.put(Const.RESPONSE_STATE, 500);
				map.put(Const.ERROR_INFO, "解析失败！");
			}
			return map;
		}
		
		/**
		 * 禁用启用保险
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="isEnable")
		@ResponseBody
		public Map<String,Object> isEnable(){
			Map<String,Object> map = new HashMap<String,Object>(); 
			try {
				Users user = this.getSessionUser();
				 map.put("user_id", user.getuId());
				 map.put("productId", this.getParameter("id"));
				 insurancesServiceImpl.isEnable(map);
				map.clear();
				map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("禁用启用保险失败:", e);
				map.clear();
				map.put(Const.RESPONSE_STATE, 500);
				map.put(Const.ERROR_INFO, "禁用启用保险失败！");
			}
			return map;
		}	
		
}
