package com.op.util;

import java.io.File;
/**
 * 
*    
* 项目名称：opManage   
* 类名称：FileUtil   
* 类描述：   文件操作工具类
* 创建人：Win Zhong   
* 创建时间：2016年2月26日 下午1:48:09   
* 修改人：Win Zhong   
* 修改时间：2016年2月26日 下午1:48:09   
* 修改备注：   
* @version    
*
 */
public class FileUtil {

	/**
	 * 移动文件到指定目录
	 * @param filePath 文件原路径
	 * @param newFileDirectory 新的文件目录地址
	 * @throws Exception
	 */
	public static void moveFile(String filePath,String newFileDirectory)throws Exception{
		  File file = new File(filePath);  
		  File moveDir = new File(newFileDirectory);// 创建目标目录  
          if(!moveDir.exists()) {// 判断目标目录是否存在  
              moveDir.mkdirs();// 不存在则创建  
          }  
          if(file.renameTo(new File(newFileDirectory+"\\" + file.getName()))) {  
              System.out.println("File is moved successful!");  
          }else {  
              System.out.println("File is failed to move!");  
          }  
	} 
	
}
