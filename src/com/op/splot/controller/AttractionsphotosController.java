package com.op.splot.controller;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.op.controller.BaseController;
import com.op.splot.dto.splot.AttractionsphotosDTO;
import com.op.splot.entity.Attractionsphotos;
import com.op.splot.entity.Spot;
import com.op.splot.service.AttractionsphotosService;
import com.op.splot.service.SpotService;
import com.op.plugin.page.Page;
import com.op.util.Const;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
/**景点照片
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value="/attractionsphotos")
public class AttractionsphotosController extends BaseController {
	private static Log logger = LogFactory.getLog(AttractionsphotosController.class);
	//景点照片
	@Resource(name="attractionsphotosServiceImpl")
	private AttractionsphotosService attractionsphotosServiceImpl;

@RequestMapping(value="/attractionsphotosList")
public ModelAndView getAttractionsphotosList(Page page,ModelAndView mv) throws Exception{
	List<AttractionsphotosDTO> attractionsphotosDTO = attractionsphotosServiceImpl.getAttractionsphotosList(page);
	mv.addObject("attractionsphotosDTO", attractionsphotosDTO);
	mv.addObject("page", page);
	mv.setViewName("splot/Attractionsphotos/AttractionsphotosList");
	return mv;
	}

@RequestMapping(value="/saveAttractionsphotos")
@ResponseBody
public Map<String,Object> saveAttractionsphotos(Attractionsphotos attractionsphotos ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		attractionsphotosServiceImpl.saveAttractionsphotos( attractionsphotos,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

@RequestMapping(value = "/editAttractionsphotos")
@ResponseBody
public ModelAndView editAttractionsphotos(ModelAndView mv) throws Exception{
		String id = this.getParameter("id");
		if(!StringUtils.isEmpty(id)){
		List<Attractionsphotos> attractionsphotos = attractionsphotosServiceImpl.findById(id);
		mv.addObject("attractionsphotos", attractionsphotos);
		}
		mv.addObject("sid", id);
		mv.setViewName("splot/Attractionsphotos/AttractionsphotosEdit");
		return mv;
		}
@RequestMapping(value="/deleteAttractionsphotos")
@ResponseBody
public Map<String,Object> deleteAttractionsphotos(@RequestParam(value="mId") String mId,@RequestParam(value="tp") String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {
		attractionsphotosServiceImpl.deleteAttractionsphotos(mId,tp,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
		}
		return map;
		}

/**
 *
 * 返回类型：Map<String,Object>
 * @return
 */
@RequestMapping(value="/updateAttractionsphotos")
@ResponseBody
public Map<String,Object> updateAttractionsphotos(String id ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		attractionsphotosServiceImpl.updateAttractionsphotos( id,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

		}
