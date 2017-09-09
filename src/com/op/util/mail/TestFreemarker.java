package com.op.util.mail;


import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TestFreemarker {

  /**
   * @param args
   */
  public static void main(String[] args) {

    
    Configuration cfg = new Configuration();
    StringTemplateLoader stringLoader = new StringTemplateLoader();
    String templateContent="欢迎：${name}";
    stringLoader.putTemplate("myTemplate",templateContent);
    
    cfg.setTemplateLoader(stringLoader);
    
    try {
      Template template = cfg.getTemplate("myTemplate","utf-8");
      Map root = new HashMap();  
      root.put("name", "javaboy2012");
      
      StringWriter writer = new StringWriter();  
      try {
        template.process(root, writer);
        System.out.println(writer.toString());  
      } catch (TemplateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }  
  
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }





  }

}