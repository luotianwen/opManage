package com.op.plugin.baidu.ueditor.upload;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.op.plugin.baidu.ueditor.define.State;
import com.op.util.aliyun.AliyunOSSFactory;
import com.op.util.aliyun.AliyunOSSProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Uploader {
	private HttpServletRequest request = null;
	private Map<String, Object> conf = null;

	public Uploader(HttpServletRequest request, Map<String, Object> conf) {
		this.request = request;
		this.conf = conf;
	}

	public final State doExec() {
		String filedName = (String) this.conf.get("fieldName");
		State state = null;

		if ("true".equals(this.conf.get("isBase64"))) {
			state = Base64Uploader.save(this.request.getParameter(filedName),
					this.conf);
		} else {
			state = BinaryUploader.save(this.request, this.conf);
			
			try {
				//文件上传阿里云处理
				JSONObject stateJson = new JSONObject(state.toJSONString());
				//设置本地路径，防止上传阿里云失败，图片不显示
				state.putInfo( "url", AliyunOSSProperties.LOCALURL+stateJson.get("url"));
				// 初始化OSSClient
				OSSClient client = AliyunOSSFactory.getOSSClient();
				// 创建上传Object的Metadata
				ObjectMetadata meta = new ObjectMetadata();
				// 获取指定文件的输入流
				String uploadFilePath = (String) this.conf.get("rootPath") + (String) stateJson.get("url");
				File file = new File(uploadFilePath);
				InputStream content = new FileInputStream(file);
				// 必须设置ContentLength
				meta.setContentLength(file.length());
				// 上传Object.
				PutObjectResult result = client.putObject(AliyunOSSProperties.BUCKETNAME, "email/"+file.getName(),content, meta);
				// 打印ETag
				//System.out.println(result.getETag());
				System.out.println("文件上传阿里云OSS云存储成功,文件ETag："+result.getETag());
				state.putInfo( "url", AliyunOSSProperties.VISITURL+"email/"+file.getName());
			} catch (OSSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return state;
	}
}
