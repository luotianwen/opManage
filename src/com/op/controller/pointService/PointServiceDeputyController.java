package com.op.controller.pointService;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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
import com.op.dto.point.PointServiceDeputyDTO;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointServiceDeputyService;
import com.op.util.Const;
import com.op.util.PropertyFile;

/** 
 * 地点服务基本信息表(副)(pointServiceDeputy)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 10:51:23 
 */ 
@Controller
@RequestMapping(value="/pointServiceDeputy")
public class PointServiceDeputyController extends BaseController {
	
	@Resource(name="pointServiceDeputyServiceImpl")
	private PointServiceDeputyService pointServiceDeputyServiceImpl;

	
	/**
	 * 获取所有待审核的地点信息
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="check")
	public ModelAndView check(ModelAndView mv,Page<?> page) throws Exception{
		List<?> list = pointServiceDeputyServiceImpl.getCheckList(page);
		mv.addObject("pointList", list);
		mv.setViewName("pointService/pointcheck");
		return mv;
	}	
	/**
	 * 查看详情
	 * @param id
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="details/{id}")
	public ModelAndView details(@PathVariable("id") String id,ModelAndView mv) throws Exception{
		PointServiceDeputyDTO point = pointServiceDeputyServiceImpl.getPointById(id);
		mv.addObject("point", point);
		mv.setViewName("pointService/pointinfo");
		return mv;
	}
	/**
	 * 审核处理
	 * @return
	 */
	@RequestMapping(value="handle")
	@ResponseBody
	public Map<String,Object> handle(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Users user = this.getSessionUser();
			map.put("ps_id",this.getParameter("ps_id"));
			map.put("ps_check_user_id",user.getuId());
			map.put("ps_state",this.getParameter("ps_state"));
			map.put("ps_point_service_id",this.getParameter("ps_point_service_id")); 
			map.put("ps_error_comment",this.getParameter("ps_error_comment"));
			map.put("pa_id",this.getParameter("pa_id"));
			map.put("user_id",this.getParameter("user_id"));
			
			//审核业务处理 
			pointServiceDeputyServiceImpl.pointCheckById(map);
 
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			
			String surl = "";
			try {
				Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
				
				surl=prop.get("url")+"/pointService/newPointService/"+this.getParameter("ps_id");
				URL url = new URL(surl);
				URLConnection rulConnection = url.openConnection();
				HttpURLConnection httpUrlConnection  = (HttpURLConnection) rulConnection;
				httpUrlConnection.setConnectTimeout(300000);
				httpUrlConnection.setReadTimeout(300000);
				httpUrlConnection.connect();
				String code = new Integer(httpUrlConnection.getResponseCode()).toString();
				//String message = httpUrlConnection.getResponseMessage();
				if(!code.startsWith("2")){
					logger.error("访问玩嘛生成新的场馆项目静态页面失败");
				}
				
			}catch(Exception e){
				logger.error("访问玩嘛生成新的场馆项目静态页面异常",e);
			}
			
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常!!!");
		}
		return map;
	}
}
