package com.op.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.entity.users.Users;
import com.op.plugin.emayclient.EmacySMS;
import com.op.service.users.UsersService;
import com.op.util.Common;
import com.op.util.Const;

/**
 * 项目名：outdoorPortal
 * 类描述：注册
 * 创建人：Yan
 * 创建时间： 2015-11-30 上午9:50:31
 * 最后修改时间：2015-11-30上午9:50:31
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController extends BaseController {

	@Resource(name = "usersServiceImpl")
	private UsersService usersServiceImpl;

	/**
	 * 方法描述：注册新用户 返回类型：ModelAndView
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public ModelAndView register(Users user, HttpServletRequest request, @RequestParam String yzm) {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();;
		HttpSession session = request.getSession();
		// 保存用户输入的未经过系统加密的密码，为了报错后保存显示原生密码
		mv.addObject("password", user.getuPassword());
		// 保存用户输入的验证码
		mv.addObject("yzm", yzm);
		// 匹配session中的验证码
		Object sessionYzm = session.getAttribute(Const.YZM);
		// 匹配验证码
		if (StringUtils.isEmpty(sessionYzm) || !yzm.equals(sessionYzm + "")) {
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "验证码错误!");
			mv.setViewName("register");
		}
		// 匹配验证码对应的手机号
		else if (!user.getuPhone().equals(session.getAttribute(Const.REGIS_PHONE) + "")) {
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "该手机号不是接受验证码的手机号!");
			mv.setViewName("register");
		}
		// 验证手机号码唯一性，保存用户
		else {
			Date curDate = new Date();
			Date postDate = (Date) session.getAttribute(Const.POST_YZM_TIME);
			long ss = (curDate.getTime() - postDate.getTime())/1000;
			// 判断验证码有效时间为5分钟
			if(ss/60 > 5 || ( ss/60 == 5 && ss%60 > 0) ){
				map.put(Const.RESPONSE_STATE, 500);
				map.put(Const.ERROR_INFO, "验证码已经失效!");
				mv.setViewName("register");
			}else{
				// 获取最后一次登录IP
				user.setuLoginIp(Common.getRemoteAddrIp(request));
				map.put("user", user);
				try {
					// 保存用户
					usersServiceImpl.saveUser(map);
					// 验证出错
					if (!Const.RESPONSE_SUCCESS.equals(map.get(Const.RESPONSE_STATE))) {
						mv.setViewName("register");
					}
					// 保存用户成功
					else {
						session.removeAttribute(Const.YZM);// 销毁验证码
						session.removeAttribute(Const.REGIS_PHONE);// 销毁接收验证码手机号
						session.removeAttribute(Const.POST_YZM_TIME);// 销毁验证码发送时间
						session.setAttribute(Const.SESSION_USER, user);// 保存当前登录用户到session
						mv.clear();// 防止重定向资源保留问题
						mv.setViewName("redirect:/index.html"); // 刚注册的用户为普通用户，重定向到主页
						return mv;
					}
				} catch (Exception e) {
					map.clear();
					map.put(Const.RESPONSE_STATE, 500);
					map.put(Const.ERROR_INFO, "保存异常!!!");
					mv.setViewName("register");
				}
			}
		}
		mv.addObject("user", user);
		mv.addObject("map", JSONObject.fromObject(map));
		return mv;
	}

	/**
	 * 方法描述：发送验证码 返回类型：Map<String,Object>
	 * 
	 * @return
	 */
	@RequestMapping(value = "/postYzm",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> postYzm(@RequestParam String phone, HttpSession session) {
		Map<String,Object> map = new HashMap<String,Object>();;
		// 验证手机号码唯一性
		boolean flag = false;
		try {
			phone = phone.trim();
			flag = usersServiceImpl.checkUserPhoneUnique(phone);
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "验证手机号唯一性异常!");
		}
		if (flag) {// 手机号码可以注册
			// 判断是否在注册规定时间外
			Date currentDate = new Date();
			Date postDate = (Date) session.getAttribute(Const.POST_YZM_TIME);// 上一次发送验证码时间
			if (session.getAttribute(Const.POST_YZM_TIME) == null || (currentDate.getTime() - postDate.getTime()) / 1000 >= Const.POST_YZM_INTERVAL_TIME) {
				int yzm = (int) (Math.random() * 8999) + 1000;
				String info = "验证码：" + yzm + ",有效时间为≤5分钟。欢迎注册玩嘛,跟我一起玩天下!(客服绝不会索取此验证码，切勿告知他人)";

				int i = EmacySMS.sendSMS(new String[] { phone }, info);
				if (i == 0) {// 发送成功
					session.setAttribute(Const.YZM, yzm);// 保存session验证码，防止客户过滤前段验证
					session.setAttribute(Const.REGIS_PHONE, phone);// 保存接受验证码的手机号，防止用户恶意获取验证码后用别的号码进行注册
					session.setAttribute(Const.POST_YZM_TIME, currentDate);// 保存当前session接受验证码时间，防止恶意发送短信
					// 保存数据前端进行验证
					map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
					map.put(Const.YZM, yzm);
					map.put(Const.REGIS_PHONE, phone);
					System.out.println("------------------------------------验证码：" + yzm);
				} else {// 发送失败
					map.put(Const.RESPONSE_STATE, 500);
					map.put(Const.ERROR_INFO, "发送失败，请稍后重试!!!");
				}
			} else {// 规定为60秒获取一次验证码
				map.put(Const.RESPONSE_STATE, 500);
				map.put(Const.ERROR_INFO, "短信发送间隔为60秒，请稍后重试!!!");
			}
		} else {// 手机号码已经存在
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "该手机号码已经注册过，<a href='login.html'>直接登录</a>，如果非本人注册，点击此处<a href='javascript:layer.msg('待开发')'>找回密码</a>!");
		}
		return map;
	}
}
