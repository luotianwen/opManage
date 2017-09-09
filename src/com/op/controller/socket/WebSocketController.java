package com.op.controller.socket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.dto.online.SearchDTO;
import com.op.entity.users.Users;
import com.op.plugin.hession.UpdateRemote;
import com.op.plugin.page.Page;
import com.op.service.socket.WebSocketService;
import com.op.service.users.UsersService;
import com.op.util.Const;
import com.op.util.HessionFactory;
import com.op.util.PropertyFile;
/**
 * 项目名：opManage
 * 类描述：推送服务
 * 创建人：Yan
 * 创建时间： 2016-1-16 下午5:36:07
 * 最后修改时间：2016-1-16下午5:36:07
 */
@Controller
@RequestMapping(value="webSocketController")
public class WebSocketController {

	@Resource(name="webSocketServiceImpl")
	WebSocketService webSocketServiceImpl;
	
    @Resource(name="usersServiceImpl")
    UsersService usersService;

	/**
	 * 方法描述：远程调用显示当前门户登录用户
	 * 返回类型：ModelAndView
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/soud")
	public ModelAndView showOpUsersData(ModelAndView mv,Page<SearchDTO> page,SearchDTO search) throws Exception{
		// 获取门户网站在线人数
		UpdateRemote remote = HessionFactory.getInterface();
		
		// 在线用户ID集合
		List<String> uIds = null;
		try {
			uIds = remote.getOnLineUserIds();
		} catch (Exception e) {
			mv.addObject(Const.RESPONSE_STATE, 500);
			Map<String,String> prop = PropertyFile.getPropertiesMap("outdoorPortalUrl.properties");
			mv.addObject("url", prop.get("url"));
		}
		// 人数数量
		Integer num = 0;
		if(uIds != null){
			// 人数数量
			num = uIds.size();
			// 查询对象
			search.setuIds(uIds);
			page.setT(search);
			
			List<Users> users = usersService.getOnLineUserByIds(page);
			mv.addObject("users", users);
		}
		
		mv.addObject("search", search);
		mv.addObject("num", num);
		mv.addObject("page", page);
		
		mv.setViewName("message/users");
		return mv;
	}
	
	
	/**
	 * 方法描述：向指定用户推送消息
	 * 返回类型：Map<String,Object>
	 * @param userId
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/sendMessageToUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> sendMessageToUser(String userId, String message){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			webSocketServiceImpl.sendMessageToUser(userId, message, map);
		} catch (Exception e) {
			map.put(Const.ERROR_INFO, "发送异常,异常信息为:"+e.toString());
		}
		return map;
	}
	
	
	/**
	 * 方法描述：批量用户推送消息
	 * 返回类型：Map<String,Object>
	 * @param userId
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/sendMessageToUsers",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> sendMessageToUsers(String userId, String message){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			webSocketServiceImpl.sendMessageToUsers(userId, message, map);
		} catch (Exception e) {
			map.put(Const.ERROR_INFO, "发送异常,异常信息为:"+e.toString());
		}
		return map;
	}
	
	
	/**
	 * 方法描述：全部用户推送消息
	 * 返回类型：Map<String,Object>
	 * @param userId
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/sendMessageTosessions",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> sendMessageTosessions(String message){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			webSocketServiceImpl.sendMessageTosessions(message, map);
		} catch (Exception e) {
			map.put(Const.ERROR_INFO, "异常信息:"+e.toString());
		}
		return map;
	}

	/**
	 * 方法描述：刷新远程调用缓存对象
	 * 返回类型：Map<String,Object>
	 * @param message
	 * @return
	 */
	@RequestMapping(value="/refreshUrl",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> refreshUrl(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			HessionFactory.refreshUrl();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			map.put(Const.ERROR_INFO, "异常信息:"+e.toString());
		}
		return map;
	}
	
	
}
