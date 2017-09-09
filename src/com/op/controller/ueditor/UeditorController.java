package com.op.controller.ueditor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.op.controller.BaseController;
import com.op.plugin.baidu.ueditor.ActionEnter;
import com.op.util.DateUtil;
@Controller
@RequestMapping(value="/ueditor")
public class UeditorController extends BaseController{

	   @RequestMapping("/dispatch")
       public void config(HttpServletRequest request,  HttpServletResponse response) {
		   response.setCharacterEncoding( "utf-8" );
		   response.setHeader("Content-Type" , "text/html");
		   String rootPath = request.getServletContext().getRealPath( "/" );//+"/static/plugins";
			try {
				response.getWriter().write( new ActionEnter( request, rootPath ).exec() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
	
	
}
