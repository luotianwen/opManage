package com.op.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.op.entity.VerifyCodeUtil;
import com.op.entity.users.Users;
import com.op.util.Common;
import com.op.util.Const;
import com.op.util.geetest.GeetestLib;

/**
 * 项目名：outdoorPortal
 * 类描述：登录
 * 创建人：Yan
 * 创建时间： 2015-11-30 上午9:50:16
 * 最后修改时间：2015-11-30上午9:50:16
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

	@RequestMapping("/getVerifyCodeImage")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		// 将验证码放到HttpSession里面
		request.getSession().setAttribute("verifyCode", verifyCode);
		System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
		// 设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
		// 写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, 
			@RequestParam(value="username") String username, 
			@RequestParam(value="password") String password,
			ModelAndView mv
			/*,@RequestParam(value="verifyCode",required=false) String submitCode*/) {
		HttpSession session = request.getSession();
		
		// 计算当前session登录次数
		//Integer loginNum = countSessionLoginNum(session);
		
		mv.addObject("username", username);
		mv.addObject("password", password);
		//mv.addObject("loginNum", loginNum);
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);

		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		boolean flag = false;
		try {
			// 获取登录IP
			currentUser.getSession().setAttribute(Const.LOGIN_IP, Common.getRemoteAddrIp(request));
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken（验证token）,并将其发送给已配置的Realm执行必须的认证检查
			currentUser.login(token);
			flag = true;
		} catch (Exception uae) {
			flag = false;
			mv.addObject(Const.RESPONSE_STATE, "500");
			mv.addObject(Const.ERROR_INFO, "用户名或密码不正确");
		}
		// 验证是否登录成功
		if (flag) {
			// 清除session登录次数
			session.removeAttribute(Const.SESSION_LOGIN_ERROR_NUM);
			// 必须清空(一：重定向优化访问地址栏变化；二：springMVC重向定会把参数带到地址栏后面，所以要清空)
			mv.clear();

			Users user = (Users) currentUser.getSession().getAttribute(Const.SESSION_USER);
			
			// 必须重定向 redirect:
			mv.setViewName("redirect:/admin/index.html");

			// 判断是否拥有角色
			if (StringUtils.isEmpty(user.getrId())) {
				mv.addObject(Const.RESPONSE_STATE, "500");
				mv.addObject(Const.ERROR_INFO, "当前账户还未赋予角色!");
				mv.setViewName("login");
			}

		} else {
			token.clear();
			mv.setViewName("login");
		}
		return mv;

	}
	
	/**
	 * 方法描述：计算当前session登录次数
	 * 返回类型：Integer
	 * @param session
	 * @return
	 */
	public Integer countSessionLoginNum(HttpSession session){
		Integer loginNum = 0;
		// 记录当前session次数
		Integer sessionLoginNum = (Integer) session.getAttribute(Const.SESSION_LOGIN_ERROR_NUM);
		if(sessionLoginNum == null){
			loginNum = 1;
		}else{
			loginNum = sessionLoginNum + 1;
		}
		session.setAttribute(Const.SESSION_LOGIN_ERROR_NUM, loginNum);
		
		return loginNum;
	}

	/**
	 * 方法描述：登录验证
	 * 返回类型：boolean
	 * @param request
	 * @param mv
	 * @return
	 */
	public boolean loginGeeTest(ModelAndView mv,HttpServletRequest request){
		// get session to share the object
		GeetestLib geetest = GeetestLib.getGtSession(request);
		int gt_server_status_code = GeetestLib
				.getGtServerStatusSession(request);

		String gtResult = "fail";

		if (gt_server_status_code == 1) {
			gtResult = geetest.enhencedValidateRequest(request);
			System.out.println(gtResult);
		} else {
			// TODO use you own system when geetest-server is down:failback
			System.out.println("failback:use your own server captcha validate");
			gtResult = "fail";
			
			gtResult=geetest.failbackValidateRequest(request);
		}

		if (gtResult.equals(GeetestLib.success_res)) {
			// TODO handle the Success result
			mv.addObject(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			return true;

		} else if (gtResult.equals(GeetestLib.forbidden_res)) {
			// TODO handle the Forbidden result
			mv.addObject(Const.RESPONSE_STATE, 500);
			mv.addObject(Const.ERROR_INFO, "禁止登录验证处理!");
		} else {
			// TODO handle the Fail result
			mv.addObject(Const.RESPONSE_STATE, 500);
			mv.addObject(Const.ERROR_INFO, "验证失败！");
		}
		mv.setViewName("login");
		return false;
	}
	
	/**
	 * 方法描述：注销 返回类型：String
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.html";
	}
}
