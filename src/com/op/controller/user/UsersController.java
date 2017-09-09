package com.op.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.users.UserInfo;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.service.authority.ArraysService;
import com.op.service.authority.RolesService;
import com.op.service.users.UsersService;
import com.op.task.AvatarUploadOss;
import com.op.util.Const;
import com.op.util.DateUtil;
import com.op.util.FileUpload;
import com.op.util.MD5;
import com.op.util.UuidUtil;

/**
 * 
*    
* 项目名称：outdoorPortal   
* 类名称：TestUserController   
* 类描述：   会员管理
* 创建人：Win Zhong   
* 创建时间：2015年11月5日 下午4:46:13   
* 修改人：Win Zhong   
* 修改时间：2015年11月5日 下午4:46:13   
* 修改备注：   
* @version    
*
 */
@Controller
@RequestMapping(value="/user")
public class UsersController extends BaseController{

    
    @Resource(name="usersServiceImpl")
    UsersService usersService;

	@Resource(name="rolesServiceImpl")
	private RolesService rolesServiceImpl;
	
	@Resource(name="arraysServiceImpl")
	private ArraysService arraysServiceImpl;
	
    @Resource(name="avatarUploadOssImpl")
    AvatarUploadOss avatarUploadOssImpl;
	
    /**
     * 获取系统用户列表
     * @param page
     * @param users
     * @return
     * @throws Exception
     */
	@RequestMapping(value="sysList")
	public ModelAndView sysList(Page<Users> page,Users users)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		page.setT(users);
		List<Users> usersList = usersService.getSysListPage(page);
		mv.addObject("page",page);
		mv.addObject("usersList",usersList);
		mv.addObject("user",users);
		mv.setViewName("admin/user/sysUser");
		return mv;
	}

    
    /**
     * 获取会员用户列表
     * @param page
     * @param users
     * @return
     * @throws Exception
     */
	@RequestMapping(value="userList")
	public ModelAndView userList(Page<Users> page,UserInfo users)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		page.setT(users);
		List<Users> usersList = usersService.getUsersListPage(page);
		mv.addObject("page",page);
		mv.addObject("usersList",usersList);
		mv.addObject("user",users);
		mv.setViewName("admin/user/user");
		return mv;
	}
	 
	/**
	 * 根据用户ID 获取用户详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getUserInfo/{userId}")
	@ResponseBody
	public String getUserInfo(@PathVariable("userId") String userId)throws Exception{ 
		
		UserInfo user = usersService.findUserById(userId);
	 
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"tab-content\">"
					+"<div class=\"tab-pane active\">"
					+"<div class=\"row m-b-lg\">"
					+"<div class=\"col-lg-4 text-center\">"
					+"<h2>"+user.getuName()+"</h2>"
					+"<div class=\"m-b-sm\">"
					+"<img alt=\"image\" class=\"img-circle img-gyrate\" src=\""+user.getuHeadImg()+"\" style=\"width: 100px\">"
					+"</div>"
					+"</div>"
					+"<div class=\"col-lg-8\">"
					+"<h3>"
					+"个人简介"
					+"</h3>"
					+"<p>"
					+"性别："+user.getSex()
					+"</p>"
					+"<p>"
					+"邮箱："+user.getuEmail()
					+"</p>"
					+"<p>"
					+"电话："+user.getuPhone()
					+"</p>"
					+"<p>"
					+"常用登录地区："
					+"</p>"
					+"<p>"
					+"注册时间："+user.getuCreateTime()
					+"</p>"
					+"<p>"
					+"身份类型："+user.getuType()
					+"</p>"
					+"<p>"
					+"评分剩余量："
					+"</p> "
					+"<br>"
					+"<a type=\"button\" class=\"btn btn-primary btn-sm btn-block\"><i class=\"fa fa-envelope\"></i> 发送邮件"
					+"</a>"
					+"</div>"
					+"</div>"
					+"<div class=\"client-detail\">"
					+"<div class=\"full-height-scroll\">"
					+"<strong>当前动态</strong>"
					+"<ul class=\"list-group clear-list\">"
					+"<li class=\"list-group-item fist-item\">"
					+"<span class=\"pull-right\"> 2次 </span> 参加活动"
					+"</li>"
					+"<li class=\"list-group-item\">"
					+"<span class=\"pull-right\"> 5次 </span> 发布活动"
					+"</li>"
					+"<li class=\"list-group-item\">"
					+"<span class=\"pull-right\"> 5次 </span> 违　　规"
					+"</li>"
					+"<li class=\"list-group-item\">"
					+"<span class=\"pull-right\"> 5次 </span> 处　　罚"
					+"</li>"
					+"</ul>"
					+"<strong>备注</strong>"
					+"<p>"
					+"暂无备注！"
					+"</p>"
					+"<hr/>"
					+"<strong>时间轴</strong>"
					+"<div id=\"vertical-timeline\" class=\"vertical-container light-timeline\">"
					+"<div class=\"vertical-timeline-block\">"
					+"<div class=\"vertical-timeline-icon navy-bg\">"
					+"<i class=\"fa fa-users\"></i>"
					+"</div>"
					+"<div class=\"vertical-timeline-content\">"
					+"<h2>参加活动</h2>"
					+"<p>十一月十一日通州运河自行车赛"
					+"</p>"
					+"<a href=\"#\" class=\"btn btn-sm btn-primary\"> 更多信息</a>"
					+"<span class=\"vertical-date\">"
					+"今天 <br>"
					+"<small>11月9日</small>"
					+"</span>"
					+"</div>"
					+"</div>"     
					+"</div>"
					+"</div>"
					+"</div>"
					+"</div>"
					+"</div>");
		System.err.println(sb.toString());
		return sb.toString();
	}	 
	

	/**
	 * 根据用户ID 获取用户详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goEditUser/{userId}")
	public ModelAndView goEditUser(@PathVariable("userId") String userId)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("admin/user/editUser");
		return mv;
	}
	
	/**
	 * 根据用户ID 获取系统用户详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goEditSysUser/{userId}")
	public ModelAndView goEditSysUser(@PathVariable("userId") String userId)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		//获取系统用户信息
		UserInfo user = usersService.findSysUserById(userId);
		mv.addObject("user", user);
		//获取分组
		List<Map<String,Object>> arrays = arraysServiceImpl.getSysArrayList();
		mv.addObject("arrays", arrays);
		if(!StringUtils.isEmpty(user.getaId())){
			//获取角色
			List<Map<String,Object>> roles = rolesServiceImpl.getSysUserRoleByaId(user.getaId()) ;
			mv.addObject("roles", roles);
		}
		
		mv.setViewName("admin/user/editSysUser");
		return mv;
	}	

	/**
	 * 去新增系统用户页面
	 * @return
	 * @throws Exception
	 */ 
	@RequestMapping(value="goAddSysUser")
	public ModelAndView goAddSysUser()throws Exception{
		ModelAndView mv = new ModelAndView();
		//获取分组
		List<Map<String,Object>> arrays = arraysServiceImpl.getSysArrayList();
		mv.addObject("arrays", arrays);
		mv.setViewName("admin/user/editSysUser");
		return mv;
	}
	

	/**
	 * 新增系统用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addSysUser")
	@ResponseBody
	public Map<String,Object> addSysUser(UserInfo user){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			map.put("newPassword", this.getParameter("newPassword"));
			map.put("user", user);
			usersService.saveSysUser(map);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常!!!");
		}
		return map;
	}
	
	/**
	 * 更改用户冻结状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="userFrozen/{userId}")
	@ResponseBody
	public Map<String,Object> userFrozen(@PathVariable("userId") String userId){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			map.clear();
			usersService.updateUserFrozenTypeByUid(userId);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新异常");
		}
		return map;
	}

	
	/**
	 * 更改用户冻结状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="jinyan")
	@ResponseBody
	public Map<String,Object> jinyan(){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			map.put("duration", this.getParameter("duration"));
			map.put("uId", this.getParameter("id"));
			usersService.updateUserGAGTypeByUid(map);
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新异常");
		}
		return map;
	}	
	
	/**
	 * 删除系统用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="delSysUser/{userId}")
	@ResponseBody
	public Map<String,Object> delSysUser(@PathVariable("userId") String userId){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			map.clear();
			usersService.deleteSysUser(userId);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "删除异常!!!");
		}
		return map;
	}	
	
	/**
	 * 系统用户头像
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="sysUserAvatar")
	public ModelAndView userAvatar(ModelAndView mv)throws Exception{ 
		mv.addObject("avatar",this.getSessionUser().getuHeadImg());
		mv.setViewName("admin/user/sysUserAvatar");
		return mv;
	}
	
	/**
	 * 修改系统用户头像
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysUserAvatar")
	@ResponseBody
	public Object updateSysUserAvatar(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		String  day = DateUtil.getDays(), fileName = UuidUtil.get32UUID()+".png";
		ServletContext application = request.getSession().getServletContext();
        String savePath = application.getRealPath("/") + "upload/avatar/"+day;
        String saveUrl = "upload/avatar/"+day+"/";
		String result = this.getParameter("image");         
		if(FileUpload.Base64TurnPicture(result,savePath,fileName)){
			try {
				Users user = this.getSessionUser();
				map.put("avatarUrl", saveUrl+fileName);
				map.put("userId", user.getuId());
				usersService.updateSysUserAvatar(map);
				user.setuHeadImg(saveUrl+fileName);
				map.clear();
				map.put("src", saveUrl+fileName);
				map.put("result", "true");
			    avatarUploadOssImpl.upload(user);
			} catch (Exception e) {
				map.clear();
				map.put("result", "err");
			}
		}else{
			map.put("result", "err");
		}
		return map;
	}
	
	@RequestMapping(value="sysUserPassword")
	public ModelAndView sysUserPassword(ModelAndView mv)throws Exception{ 
		mv.setViewName("admin/user/sysUserPassword");
		return mv;
	}	
	
	@RequestMapping(value="updateSysUserPassword")
	@ResponseBody
	public Map<String,Object> updateSysUserPassword(ModelAndView mv)throws Exception{ 
		Map<String,Object> map = new HashMap<String,Object>();
		String uPassword = this.getParameter("uPassword");
		String newPassword = this.getParameter("newPassword");
		String checkPassword = this.getParameter("checkPassword");
		Users user = this.getSessionUser();
		//判断原密码是否正确
		if(user.getuPassword().equals(MD5.md5(uPassword))){
			if(newPassword.equals(checkPassword)){
				map.put("newPassword",MD5.md5(newPassword));
				map.put("uPassword", MD5.md5(uPassword));
				map.put("userId", user.getuId());
				try {
					usersService.updateSysUserPassword(map);
					user.setuPassword(map.get("newPassword").toString());
					map.clear();				
					map.put("msg", "密码修改成功");
					map.put("result", "true");
				} catch (Exception e) {
					map.clear();				
					map.put("msg", "密码修改失败");
					map.put("result", "err");
				}
			}else{
				map.put("msg", "新密码两次输入不一致");
				map.put("result", "err");
			}
		}else{
			map.put("msg", "原密码输入错误！");
			map.put("result", "err");
		}
		return map;
	}		
	
	
}
