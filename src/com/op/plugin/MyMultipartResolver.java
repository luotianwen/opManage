package com.op.plugin;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/**
 *  
*    
* 项目名称：opManage   
* 类名称：MyMultipartResolver   
* 类描述：   上传文件过滤
* 创建人：Win Zhong   
* 创建时间：2015年12月30日 下午1:33:06   
* 修改人：Win Zhong   
* 修改时间：2015年12月30日 下午1:33:06   
* 修改备注：   
* @version    
*
 */
public class MyMultipartResolver extends CommonsMultipartResolver {
 
    @Override
    public boolean isMultipart(HttpServletRequest request) {
        String action = request.getParameter("action");
        if(action!=null){  // ueditor 上传图片的时候 不进行request 的转换
            return false;
        }
        return super.isMultipart(request);
    }
 
}
