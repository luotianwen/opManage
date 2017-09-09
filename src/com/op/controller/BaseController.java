package com.op.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.op.entity.users.Users;
import com.op.util.Const;
import com.op.util.Logger;
/**
 * 
*    
* 项目名称：opManage   
* 类名称：BaseController   
* 类描述：   所有Controller都得继承BaseController
* 创建人：Win Zhong   
* 创建时间：2016年3月14日 下午4:57:04   
* 修改人：Win Zhong   
* 修改时间：2016年3月14日 下午4:57:04   
* 修改备注：   
* @version    
*
 */
public class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	// protected ModelAndView mv = this.getModelAndView();
	/**
	 * ThreadLocal确保高并发下每个请求的request，response都是独立的
	 */
	/*
	 * private static ThreadLocal<ServletRequest> tRequest = new
	 * ThreadLocal<ServletRequest>(); private static
	 * ThreadLocal<ServletResponse> tResponse = new
	 * ThreadLocal<ServletResponse>();
	 */
	/*private static ThreadLocal<ModelAndView> tMv = new ThreadLocal<ModelAndView>();
	private static ThreadLocal<Map<String, Object>> tMap = new ThreadLocal<Map<String, Object>>();*/

	/**
	 * 线程安全初始化reque，respose对象
	 * 
	 * @param request
	 * @param response
	 * @date 2015年12月3日
	 * @author WinZhong
	 */
	/*
	 * @ModelAttribute public void initReqAndRep(HttpServletRequest request,
	 * HttpServletResponse response) { System.out.println(
	 * "\n---------------------------------------------------------------------------"
	 * ); System.out.println(
	 * "------------------每次进入controllor前我都会先执行哦       WinZhong------------------"
	 * ); System.out.println(
	 * "---------------------------------------------------------------------------\n"
	 * ); //tRequest.set(request); //tResponse.set(response); }
	 */

	/**
	 * 线程安全
	 * 
	 * @return
	 * @date 2015年12月3日
	 * @author WinZhong
	 */
	/*
	 * public HttpServletRequest request() { return (HttpServletRequest)
	 * tRequest.get(); }
	 */

	/**
	 * 线程安全
	 * 
	 * @return
	 * @date 2015年12月3日
	 * @author WinZhong
	 */
	/*public ModelAndView getModelAndView() {
		if (tMv.get() == null) {
			tMv.set(new ModelAndView());
		}
		return tMv.get();
	}*/

	/**
	 * 线程安全
	 * 
	 * @return
	 * @date 2015年12月3日
	 * @author WinZhong
	 */
	/*public Map<String, Object> getMap() {
		if (tMap.get() == null) {
			tMap.set(new HashMap<String, Object>());
		}
		return tMap.get();
	}*/

	/**
	 * 线程安全
	 * 
	 * @return
	 * @date 2015年12月3日
	 * @author WinZhong
	 */
	/*
	 * public HttpServletResponse response() { return (HttpServletResponse)
	 * tResponse.get(); }
	 */

	/**
     * 把request中的参数封装到指定的bean中
     *
     * @param request
     * @param obj
     * @return Object
     * @author WinZhong
     */
    public Object packReturnByRequest(HttpServletRequest request,Object obj) {
        Map<String, Object> keyMap = findKeyMapByRequest(request);
        Field field = null;
        Set<String> keys = keyMap.keySet();
        for (String key : keys) {
            try {
                field = obj.getClass().getDeclaredField(key);
                Class<?> beanType = field.getType();
                Object value = keyMap.get(key);
                String setMethodName = "set"+ key.substring(0, 1).toUpperCase() + key.substring(1);
                Method m;
                m = obj.getClass().getMethod(setMethodName, beanType);
                m.invoke(obj, value);
            } catch (Exception e1) {
                continue;
            }
        }
        return obj;
    }

    /**
     * 把request里面的参数转化成map
     *
     * @param request
     * @return Map<String,Object>
     * @author WinZhong
     */
    public Map<String, Object> findKeyMapByRequest(HttpServletRequest request) {
        Map<String, Object> keyMap = new HashMap<String, Object>();
        Enumeration<String> enu = request.getParameterNames();
        String[] item ;
        while (enu.hasMoreElements()) {
            String paramname = enu.nextElement();
            item = request.getParameterValues(paramname);
            if(item.length == 1){
                //String paramvalue = request.getParameter(paramname);
                keyMap.put(paramname, item[0]);
            }else{
            	keyMap.put(paramname, item);
            }

        }
        return keyMap;
    }
	
	/**
	 * 获取页面传递的某一个参数值,
	 */
	public String getParameter(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request.getParameter(key);
	}

	/**
	 * 获取页面传递的某一个数组值,
	 */
	public String[] getParameterValues(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request.getParameterValues(key);
	}

	/**
	 * 方法描述：AJAX请求封装数据 返回类型：Map<String,Object>
	 * 
	 * @return
	 */
	/*
	 * public Map<String,Object> getHashMap(){ if(StringUtils.isEmpty(map)){ map
	 * = new HashMap<String,Object>(); }else{ //map.clear(); } return map; }
	 */
	
	
/*    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        *//**
         * 自动转换日期类型的字段格式
         *//*
        //binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        *//**
         * 防止XSS攻击
         *//*
        binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
    }*/
	
    /**
     * 获取保存在Session中的用户对象  
     * @param request
     * @return
     */
    protected Users getSessionUser() {  
        return (Users) SecurityUtils.getSubject().getSession().getAttribute(Const.SESSION_USER);  
    }  
	
	
	/**
	 * @ModelAttribute 这个注解作用.每次执行controllor前都会先执行这个方法
	 * @param request
	 */
	/*@ModelAttribute
	public void init(HttpServletRequest request) {

		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println("------------------每次进入controllor前我都会先执行哦       WinZhong------------------");
		System.out.println("---------------------------------------------------------------------------\n");
	}*/

}