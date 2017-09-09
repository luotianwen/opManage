package com.op.controller.pointService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.pointService.PointComboCrowdType;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointComboCrowdTypeService;
import com.op.util.Const;

/** 
 * 地点项目/套餐适合人群字典表(pointComboCrowdType)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-24 13:42:52 
 */ 
@Controller
@RequestMapping(value="/pcct")
public class PointComboCrowdTypeController extends BaseController {
	
	@Resource(name="pointComboCrowdTypeServiceImpl")
	private PointComboCrowdTypeService pointComboCrowdTypeServiceImpl;

	/**
	 * 获取字典表所有数据
	 * @param mv
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list")
	public ModelAndView list(ModelAndView mv,Page<String> page) throws Exception{
		page.setT(this.getParameter("pcct_describe"));
		List<PointComboCrowdType> list = pointComboCrowdTypeServiceImpl.getList(page);
		mv.addObject("list", list);
		mv.setViewName("pointService/pcct");
		return mv;
	}
 
	/**
	 * 获取字典表所有数据
	 * @param mv
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="edit")
	public ModelAndView edit(ModelAndView mv) throws Exception{
		String id = this.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			PointComboCrowdType  p = pointComboCrowdTypeServiceImpl.findById(id);
			mv.addObject("p", p);
		}
		mv.setViewName("pointService/pcctEdit");
		return mv;
	}
	
	
	/**
	 * 审核处理
	 * @return
	 */
	@RequestMapping(value="save")
	@ResponseBody
	public Map<String,Object> save(PointComboCrowdType pointComboCrowdType){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pointComboCrowdTypeServiceImpl.save(pointComboCrowdType);
			pointComboCrowdTypeServiceImpl.shuaxinhuancun();
			map.clear();
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
