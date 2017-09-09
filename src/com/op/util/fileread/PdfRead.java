package com.op.util.fileread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.op.util.DateUtil;
import com.op.util.UuidUtil;

public class PdfRead {

	public static void main(String[] args) throws Exception {
		System.out.println("50?".replaceAll("\\D+", ""));
	}
	
	public static List<String> read(String url,HttpServletRequest request) throws Exception{
		 String  day = DateUtil.getDays(), fileName = UuidUtil.get32UUID()+".pdf";
	     ServletContext application = request.getSession().getServletContext();
		 String savePath = application.getRealPath("/") + "upload/temp/"+day+"/";
	        // 检查目录
	        File uploadDir = new File(savePath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
		 download(url, savePath+fileName);
		
		// TODO Auto-generated method stub
	   FileInputStream fis = new FileInputStream(new File(savePath+fileName));    
       PDFParser p = new PDFParser(fis);     
       p.parse();     
       PDDocument pdd = p.getPDDocument();     
       PDFTextStripper ts = new PDFTextStripper();     
       String c = ts.getText(pdd);//new String(ts.getText(pdd).getBytes(),"UTF-8");     
       pdd.close();     
       fis.close();    
       //System.out.println("***编码"+getEncoding(c));
       //System.out.println(c);
       String[] s = c.split("\\r\\n");
       List<String> list = new ArrayList<String>();
       for(int i = 4;i<s.length-1;i++){
       	//System.out.println(s[i].replaceAll(" 天 ", " ").replaceAll("天 ", " "));
       	list.add(s[i].replaceAll(" 天 ", "天 ").replaceAll("天 ", " 天 "));
       }
      return list;
	}
	
	/**
	   * 下载文件到本地
	   *
	   * @param urlString
	   *          被下载的文件地址
	   * @param filename
	   *          本地文件名
	   * @throws Exception
	   *           各种异常
	   */
	public static void download(String urlString, String filename) throws Exception {
	    // 构造URL
	    URL url = new URL(urlString);
	    // 打开连接
	    URLConnection con = url.openConnection();
	    // 输入流
	    InputStream is = con.getInputStream();
	    // 1K的数据缓冲
	    byte[] bs = new byte[1024];
	    // 读取到的数据长度
	    int len;
	    // 输出的文件流
	    OutputStream os = new FileOutputStream(filename);
	    // 开始读取
	    while ((len = is.read(bs)) != -1) {
	      os.write(bs, 0, len);
	    }
	    // 完毕，关闭所有链接
	    os.close();
	    is.close();
	}   
	public static String getEncoding(String str) {      
	       String encode = "GB2312";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s = encode;      
	              return s;      
	           }      
	       } catch (Exception exception) {      
	       }      
	       encode = "ISO-8859-1";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s1 = encode;      
	              return s1;      
	           }      
	       } catch (Exception exception1) {      
	       }      
	       encode = "UTF-8";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s2 = encode;      
	              return s2;      
	           }      
	       } catch (Exception exception2) {      
	       }      
	       encode = "GBK";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s3 = encode;      
	              return s3;      
	           }      
	       } catch (Exception exception3) {      
	       }      
	      return "";      
	   }      

}
