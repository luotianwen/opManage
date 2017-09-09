package com.op.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * 项目名：outdoorPortal
 * 类描述：使用Freemarker替换Java字符串定义变量
 * 创建人：Yan
 * 创建时间： 2016-1-27 下午1:57:09
 * 最后修改时间：2016-1-27下午1:57:09
 */
public class FreeMarkerReplaceUtil {

	
	public static String freemarkerProcess(Map input, String templateStr) {  
	    StringTemplateLoader stringLoader = new StringTemplateLoader();  
	    String template = "content";  
	    stringLoader.putTemplate(template, templateStr);  
	    Configuration cfg = new Configuration();  
	    cfg.setTemplateLoader(stringLoader);  
	    try {  
	        Template templateCon = cfg.getTemplate(template);  
	        StringWriter writer = new StringWriter();  
	        templateCon.process(input, writer);  
	        return writer.toString();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } catch (TemplateException e) {  
	        e.printStackTrace();  
	    }  
	    return null;  
	} 
	
	
	public static void main(String[] args) throws Exception {
		String template = "你好${name}，今天是${date?string('yyyy-MM-dd')}"; //变量参考freemarker语法  
	    Map m = new HashMap();
	    m.put("name", "管理员");
	    m.put("date", new Date());
	    System.out.println(freemarkerProcess(m, template));
		
	}
}
