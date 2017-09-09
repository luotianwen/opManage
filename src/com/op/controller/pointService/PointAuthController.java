package com.op.controller.pointService;

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
import com.op.dto.pointService.PointAuthDTO;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointAuthService;
import com.op.util.Const;

/** 
 * 地点商户认领认证信息(pointAuth)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-27 09:49:18 
 */ 
@Controller
@RequestMapping(value="/pointAuth")
public class PointAuthController extends BaseController {
	
	@Resource(name="pointAuthServiceImpl")
	private PointAuthService pointAuthServiceImpl;

	/**
	 * 获取所有地点商户认领认证审核信息
	 * @param mv
	 * @param page
	 * @param pa
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list")
	public ModelAndView list(ModelAndView mv,Page<PointAuthDTO> page,PointAuthDTO pa) throws Exception{
		page.setT(pa);
		List<PointAuthDTO> pointAuthList = pointAuthServiceImpl.getList(page);
		mv.addObject("pointAuthList", pointAuthList);
		mv.addObject("pa", pa);
		mv.setViewName("pointService/pointAuthList");
		return mv;
	}

	/**
	 * 根据id获取地点商户认领认证审核信息
	 * @param id
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="check/{id}")
	public ModelAndView check(@PathVariable("id") String id,ModelAndView mv) throws Exception{
		PointAuthDTO pointAuth = pointAuthServiceImpl.findById(id);
		mv.addObject("pa", pointAuth);
		System.out.println("啦啦啦啦啦啦啦");
		mv.setViewName("pointService/pointAuth");
		return mv;
	}
 
	/**
	 * 审核处理
	 * @return
	 */
	@RequestMapping(value="examine")
	@ResponseBody
	public Map<String,Object> save(PointAuthDTO pa){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Users user = this.getSessionUser();
			pa.setAuditor_id(user.getuId());
			pointAuthServiceImpl.examine(pa);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常!!!");
		}
		return map;
	}
	
}
