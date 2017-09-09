package com.op.controller.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import Decoder.BASE64Decoder;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.op.controller.BaseController;
import com.op.util.DateUtil;
import com.op.util.FileUpload;
import com.op.util.ImageMarkLogoUtil;
import com.op.util.UuidUtil;
import com.op.util.aliyun.AliyunOSSFactory;
import com.op.util.aliyun.AliyunOSSProperties;

/**
 * 
*    
* 项目名称：outdoorPortal   
* 类名称：PicturesController   
* 类描述：   
* 创建人：Win Zhong   
* 创建时间：2015年12月2日 下午3:05:36   
* 修改人：Win Zhong   
* 修改时间：2015年12月2日 下午3:05:36   
* 修改备注：   
* @version    
*
 */
@Controller
public class FileUploadController extends BaseController {
	
	//@Resource(name="fileUploadService")
	//private FileUploadService fileUploadService;
	
	/**
	 * 上传文件
	 */
	@RequestMapping(value="/fileUpload")
	@ResponseBody
	public Object fileUpload(@RequestParam(required=false) MultipartFile file,HttpServletRequest request) throws Exception{
			Map<String,Object> map = new HashMap<String,Object>();;
			String  day = DateUtil.getDays(), fileName = "";
	        ServletContext application = request.getSession().getServletContext();
	        String savePath = application.getRealPath("/") + "upload/temp/"+day;
	        String saveUrl = "upload/temp/"+day+"/";
	        // 检查目录
	        File uploadDir = new File(savePath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
		 
			if (null != file && !file.isEmpty()) {
			 	//文件上传路径
				fileName = FileUpload.fileUp(file, savePath, UuidUtil.get32UUID());				//执行上传
				//加水印
				//ImageMarkLogoUtil.markImageByText(" 仲成 \r\n\r\n www.winzhong.net", savePath+"/"+fileName, savePath+"/"+fileName, -45);  
				map.put("src", saveUrl+fileName);
				map.put("result", "true");
				//session.setAttribute(key, uploadFilesList);
			}else{
				System.out.println("上传文件出错！");
				map.put("msg", "上传文件出错！");
				map.put("result", "err");
			}
		 
			
		 
		 
			
		return map;
	}

	/**
	 * 上传文件
	 */
	@RequestMapping(value="/fileUploadTest")
	@ResponseBody
	public Object fileUploadTest(@RequestParam(required=false) MultipartFile file,HttpServletRequest request,HttpSession session) throws Exception{
			Map<String,Object> map = new HashMap<String,Object>();;
			String key = request.getParameter("key");
			List<String> uploadFilesList = (List<String>)session.getAttribute(key);;
			if(StringUtils.isEmpty(uploadFilesList)){
				uploadFilesList = new ArrayList<String>();
			}else{
				for(String str:uploadFilesList){
					System.err.println("---《src="+str+"》---");
				}
			}
			System.err.println("------------《key="+key+"》--------------");
			String  day = DateUtil.getDays(), fileName = "";
	        ServletContext application = request.getSession().getServletContext();
	        String savePath = application.getRealPath("/") + "upload/temp/"+day;
	        String saveUrl = "upload/temp/"+day+"/";
	        // 检查目录
	        File uploadDir = new File(savePath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
		 
			if (null != file && !file.isEmpty()) {
			 	//文件上传路径
				fileName = FileUpload.fileUp(file, savePath, UuidUtil.get32UUID());				//执行上传
				uploadFilesList.add(saveUrl+fileName);
				map.put("fileName", fileName);
				map.put("result", "true");
				//session.setAttribute(key, uploadFilesList);
			}else{
				System.out.println("上传文件出错！");
				map.put("msg", "上传文件出错！");
				map.put("result", "err");
			}
		 
			//加水印
			//Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);
		 
		 
			
		return map;
	}

	/**
	 * 上传文件
	 */
	@RequestMapping(value="/headUpload")
	@ResponseBody
	public Object headUpload(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();;
		String  day = DateUtil.getDays(), fileName = UuidUtil.get32UUID()+".png";
		ServletContext application = request.getSession().getServletContext();
        String savePath = application.getRealPath("/") + "upload/temp/"+day;
        String saveUrl = "upload/temp/"+day+"/";
		String result = this.getParameter("image");         
		if(FileUpload.Base64TurnPicture(result,savePath,fileName)){
			map.put("src", saveUrl+fileName);
			map.put("result", "true");
		}else{
			map.put("result", "err");
		}
		return map;
	}
	 

	/**
	 * 获取OSS签名   OSS web直传
	 */
	@RequestMapping(value="/ts")
	@ResponseBody
	public Object ts(HttpServletRequest request) throws Exception{
		    
	        Map<String, String> respMap = new LinkedHashMap<String, String>();
	        OSSClient client = AliyunOSSFactory.getOSSClient();
	        try { 	
	        	long expireTime = 30;
	        	long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
	            Date expiration = new Date(expireEndTime);
	            PolicyConditions policyConds = new PolicyConditions();
	            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
	            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, "avatar/");
	            String postPolicy = client.generatePostPolicy(expiration, policyConds);
	            byte[] binaryData = postPolicy.getBytes("utf-8");
	            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
	            String postSignature = client.calculatePostSignature(postPolicy);
	            respMap.put("accessid", AliyunOSSProperties.ACCESSKEYID);
	            respMap.put("policy", encodedPolicy);
	            respMap.put("signature", postSignature);
	            //respMap.put("expire", formatISO8601Date(expiration));
	            respMap.put("dir", "avatar/");
	            respMap.put("host", AliyunOSSProperties.ENDPOINT);
	            respMap.put("expire", String.valueOf(expireEndTime / 1000));
	            JSONObject ja1 = JSONObject.fromObject(respMap);
	            System.out.println(ja1.toString());
	            //response.setHeader("Access-Control-Allow-Origin", "*");
	            //response.setHeader("Access-Control-Allow-Methods", "GET, POST");
	            //response(request, response, ja1.toString());
	            return respMap;
	        } catch (Exception e) {
	            respMap.clear();
	            return respMap;
	        }
	    
	}
	
	
	
	
	
	
	/**
	 * 删除
	 */
	/*@RequestMapping(value="/delete")
	public void delete(PrintWriter out){
		logBefore(logger, "删除Pictures");
		PageData pd = new PageData();
		try{
			if(Jurisdiction.buttonJurisdiction(menuUrl, "del")){
				pd = this.getPageData();
				DelAllFile.delFolder(PathUtil.getClasspath()+ Const.FILEPATHIMG + pd.getString("PATH")); //删除图片
				picturesService.delete(pd);
			}
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}*/
	
	/**
	 * 修改
	 */
	/*@RequestMapping(value="/edit")
	public ModelAndView edit(
			HttpServletRequest request,
			@RequestParam(value="tp",required=false) MultipartFile file,
			@RequestParam(value="tpz",required=false) String tpz,
			@RequestParam(value="PICTURES_ID",required=false) String PICTURES_ID,
			@RequestParam(value="TITLE",required=false) String TITLE,
			@RequestParam(value="MASTER_ID",required=false) String MASTER_ID,
			@RequestParam(value="BZ",required=false) String BZ
			) throws Exception{
		logBefore(logger, "修改Pictures");
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(Jurisdiction.buttonJurisdiction(menuUrl, "edit")){
			pd.put("PICTURES_ID", PICTURES_ID);		//图片ID
			pd.put("TITLE", TITLE);					//标题
			pd.put("MASTER_ID", MASTER_ID);			//属于ID
			pd.put("BZ", BZ);						//备注
			
			if(null == tpz){tpz = "";}
			String  ffile = DateUtil.getDays(), fileName = "";
			if (null != file && !file.isEmpty()) {
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;		//文件上传路径
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//执行上传
				pd.put("PATH", ffile + "/" + fileName);				//路径
				pd.put("NAME", fileName);
			}else{
				pd.put("PATH", tpz);
			}
			Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);//加水印
			picturesService.edit(pd);				//执行修改数据库
		}
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}*/
	
	 
}
