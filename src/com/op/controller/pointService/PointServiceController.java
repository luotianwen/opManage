package com.op.controller.pointService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

import com.op.dto.pointService.InsertCategoryDTO;
import com.op.entity.pointService.PointServiceType;
import com.op.entity.users.Users;
import com.op.service.pointService.PointServiceTypeService;
import com.op.util.Const;
import com.op.util.SerializationUtil;
import com.op.util.jedis.RedisUtil;

/**
 * 项目名：opManage
 * 类描述：场馆分类
 * 创建人：Yan
 * 创建时间： 2016-6-16 下午3:18:00
 * 最后修改时间：2016-6-16下午3:18:00
 */
@Controller
@RequestMapping(value="/pointService")
public class PointServiceController {

	@Resource(name="pointServiceTypeServiceImpl")
	PointServiceTypeService pointServiceTypeServiceImpl;
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 方法描述：查看所有一级分类
	 * 返回类型：ModelAndView
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="oneTypeAll")
	public ModelAndView oneTypeAll(ModelAndView mv) throws Exception{
		List<PointServiceType> list = pointServiceTypeServiceImpl.oneTypeAll();
		
		mv.addObject("list", list);
		mv.setViewName("pointService/pointServiceList");
		return mv;
	}
	
	/**
	 * 方法描述：跳转添加菜单页面
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goTypeAddView")
	public ModelAndView goMenuAddView(ModelAndView mv) throws Exception{
		byte[] key = "POINT_SERVICE_TYPES".getBytes();
		Jedis jedis = RedisUtil.getJedis();
		byte[] types = jedis.get(key);
		mv.addObject("onePointServices",(List<PointServiceType>) SerializationUtil.deserialize(types));
		mv.setViewName("pointService/typeAdd");
		return mv;
	}
	
	/**
	 * 方法描述：跳转编辑分类页面
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goTypeEditView")
	public ModelAndView goTypeEditView(ModelAndView mv,
			@RequestParam(value="id") String id,
			@RequestParam(value="categoryName") String categoryName,
			@RequestParam(value="orderNumber") String orderNumber) throws Exception{
		
		mv.addObject("id", id);
		mv.addObject("orderNumber", orderNumber);
		mv.addObject("categoryName", categoryName);
		
		mv.setViewName("pointService/typeEdit");
		return mv;
	}
	
	
	
	
	/**
	 * 方法描述：修改分类
	 * 返回类型：Map<String,String>
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/editType")
	@ResponseBody
	public Map<String,Object> editType(
			@RequestParam(value="id") String id,
			@RequestParam(value="categoryName") String categoryName,
			@RequestParam(value="orderNumber") String orderNumber){
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
		
		try {
			map.put("id", id);
			map.put("categoryName", categoryName);
			map.put("orderNumber", orderNumber);
			map.put("updateUserId", user.getuId());
			map.put("updateTime", new Date());
			pointServiceTypeServiceImpl.editType(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			map.clear();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改分类异常");
			log.error("修改分类异常", e);
		}
		return map;
	}
	
	
	
	
	/**
	 * 方法描述：添加分类
	 * 返回类型：Map<String,String>
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/addType")
	@ResponseBody
	public Map<String,String> addType(InsertCategoryDTO dto){
		Map<String,String> map = new HashMap<String,String>();
		
		Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
		dto.setUpdateUserId(user.getuId());
		dto.setUpdateTime(new Date());
		
		try {
			pointServiceTypeServiceImpl.addTypes(dto);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "添加分类异常");
			log.error("添加分类异常", e);
		}
		
		return map;
	}
	
	
	/**
	 * 方法描述：删除分类
	 * 返回类型：Map<String,String>
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/deleteType")
	@ResponseBody
	public Map<String,String> deleteType(
			@RequestParam(value="categoryId") String categoryId,
			@RequestParam(value="level") String level){
		Map<String,String> map = new HashMap<String,String>();
		map.put("categoryId", categoryId);
		map.put("level", level);
		
		try {
			pointServiceTypeServiceImpl.deleteTypes(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			map.clear();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "删除分类异常");
			log.error("删除分类异常", e);
		}
		
		return map;
	}
	
	/**
	 * 方法描述：获取子级分类
	 * 返回类型：Map<String,String>
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/getChildrenTypes")
	@ResponseBody
	public Map<String,Object> getChildrenTypes(@RequestParam(value="oneTypeId") String oneTypeId){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Jedis jedis = RedisUtil.getJedis();
			map.put("childrens", (List<PointServiceType>)SerializationUtil.deserialize(jedis.get(("POINT_SERVICE_TYPES"+oneTypeId).getBytes())));
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			map.clear();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改分类异常");
			log.error("修改分类异常", e);
		}
		return map;
	}
	
	/**
	 * 方法描述：获取所有子级分类
	 * 返回类型：Map<String,String>
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/getAllTypes",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getAllTypes(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			byte[] key = "POINT_SERVICE_TYPES".getBytes();
			Jedis jedis = RedisUtil.getJedis();
			byte[] types = jedis.get(key);
			
			List<PointServiceType> list = (List<PointServiceType>) SerializationUtil.deserialize(types);
			
			for(int i=0,len=list.size();i<len;i++){
				PointServiceType type = list.get(i);
				List<PointServiceType> list2 = (List<PointServiceType>) SerializationUtil.deserialize(jedis.get(("POINT_SERVICE_TYPES"+type.getOneTypeId()).getBytes()));
				type.setList(list2);
			}
			
			map.put("childrens", list);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			map.clear();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改分类异常");
			log.error("修改分类异常", e);
		}
		return map;
	}
	
	/**
	 * 方法描述：锁定分类
	 * 返回类型：Map<String,String>
	 * @param id
	 * @param isLock
	 * @return
	 */
	@RequestMapping(value="/lockOrUnLock")
	@ResponseBody
	public Map<String,Object> lockOrUnLock(@RequestParam(value="id") String id,
			@RequestParam(value="isLock") int isLock){
		Users user = (Users) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("isLock", isLock);
		map.put("updateUserId", user.getuId());
		map.put("updateTime", new Date());
		try {
			pointServiceTypeServiceImpl.lockOrUnLock(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			map.clear();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "修改分类异常");
			log.error("锁定/解锁分类异常", e);
		}
		return map;
	}
}
