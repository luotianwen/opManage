package com.op.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
*    
* 项目名称：outdoorPortal   
* 类名称：FileUpload   
* 类描述：   文件上传工具类
* 创建人：Win Zhong   
* 创建时间：2015年12月2日 下午3:19:37   
* 修改人：Win Zhong   
* 修改时间：2015年12月2日 下午3:19:37   
* 修改备注：   
* @version    
*
 */
public class FileUpload {

	/**
	 * @param file 			//文件对象
	 * @param filePath		//上传路径
	 * @param fileName		//文件名
	 * @return  文件名
	 */
	public static String fileUp(MultipartFile file, String filePath, String fileName){
		String extName = ""; // 扩展名格式：
		try {
			if (file.getOriginalFilename().lastIndexOf(".") >= 0){
				extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			}
			copyFile(file.getInputStream(), filePath, fileName+extName).replaceAll("-", "");
		} catch (IOException e) {
			System.out.println(e);
		}
		return fileName+extName;
	}
	
	/**
	 * 写文件到当前目录的upload目录中
	 * 
	 * @param in
	 * @param fileName
	 * @throws IOException
	 */
	private static String copyFile(InputStream in, String dir, String realName)
			throws IOException {
		File file = new File(dir, realName);
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		FileUtils.copyInputStreamToFile(in, file);
		return realName;
	}
	
	/**
	 * base64字符串转化成图片  
	 * @param content
	 * @param savePath
	 * @param fileName
	 * @return
	 */
    public static boolean Base64TurnPicture(String content,String savePath,String fileName){   
    	if (content == null) // 图像数据为空
    		return false;
    	//System.out.println("========"+content);
		try {
			// 检查目录
	        File uploadDir = new File(savePath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			byte[] bs = Base64.decodeBase64(content.split(",")[1]);
			FileOutputStream os = new FileOutputStream(savePath+"/"+fileName);
			os.write(bs);
			os.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }  
	
	
}
