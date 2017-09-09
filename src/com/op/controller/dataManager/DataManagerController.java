package com.op.controller.dataManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.entity.dataManager.ActiveSearchData;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.dataManager.ActiveSearchDataService;
import com.op.util.Const;


@Controller
@RequestMapping(value="dataManager")
public class DataManagerController {

	// 活动筛选条件
	@Resource(name="activeSearchDataServiceImpl")
	private ActiveSearchDataService activeSearchDataServiceImpl;
	
	/**
	 * 方法描述：筛选条件数据维护
	 * 返回类型：ModelAndView
	 * @return
	 */
	@RequestMapping(value="activeSearch")
	public ModelAndView activeSearch(Page<?> page,ModelAndView mv) throws Exception{
		// 活动筛选条件集合
		List<ActiveSearchData> activeSearchDatas = activeSearchDataServiceImpl.selectList(page);
		
		mv.addObject("page", page);
		mv.addObject("activeSearchDatas", activeSearchDatas);
		mv.setViewName("admin/dataManager/activeSearchDataList");
		return mv;
	}
	
	/**
	 * 方法描述：跳转新增数据页面
	 * 返回类型：ModelAndView
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="goDataAddView")
	public ModelAndView goDataAddView(ModelAndView mv) throws Exception{
		
		// 查询已存在的菜单
		List<ActiveSearchData> activeSearchDatas = activeSearchDataServiceImpl.selectList();

		mv.addObject("activeSearchDatas", activeSearchDatas);
		mv.setViewName("admin/dataManager/activeSearchAdd");
		return mv;
	}
	
	/**
	 * 方法描述：保存数据
	 * 返回类型：ModelAndView
	 * @return
	 */
	@RequestMapping(value="saveData")
	@ResponseBody
	public Map<String,Object> saveData(HttpSession session,ActiveSearchData data){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SESSION_USER);
		try {
			activeSearchDataServiceImpl.saveData(data, user);
			resultMap.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put(Const.RESPONSE_STATE, "500");
			resultMap.put(Const.ERROR_INFO, "保存异常，请稍后重试。");
		}
		return resultMap;
	}
	

	
	/**
	 * 方法描述：删除数据
	 * 返回类型：ModelAndView
	 * @return
	 */
	@RequestMapping(value="deleteData")
	@ResponseBody
	public Map<String,Object> deleteData(String asd_id,String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("asd_id", asd_id);
		map.put("tp", tp);
		try {
			activeSearchDataServiceImpl.deleteData(map);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "删除异常，请稍后重试。");
		}
		return map;
	}
	
	/**
	 * 方法描述：更新数据
	 * 返回类型：ModelAndView
	 * @return
	 */
	@RequestMapping(value="updateData")
	@ResponseBody
	public Map<String,Object> updateData(HttpSession session,ActiveSearchData data){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SESSION_USER);
		try {
			activeSearchDataServiceImpl.updateData(data, user);
			resultMap.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			resultMap.put(Const.RESPONSE_STATE, "500");
			resultMap.put(Const.ERROR_INFO, "保存异常，请稍后重试。");
		}
		return resultMap;
	}
	
	
	/**
	 * 方法描述：跳转编辑页面
	 * 返回类型：ModelAndView
	 * @param asd_id
	 * @param mv
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="goDataEditView")
	public ModelAndView goDataEditView(String asd_id,ModelAndView mv) throws Exception{
		ActiveSearchData data = activeSearchDataServiceImpl.selectById(asd_id);
		mv.addObject("data", data);
		mv.setViewName("admin/dataManager/activeSearchDataEdit");
		return mv;
	}
}
