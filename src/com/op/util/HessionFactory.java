package com.op.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

import com.caucho.hessian.client.HessianProxyFactory;
import com.op.plugin.hession.UpdateRemote;

public class HessionFactory {

	private static HessianProxyFactory factory;
	private static UpdateRemote basic;
	private static String url;
	private static Properties prop; 

	static{
		try {
			prop = Resources.getResourceAsProperties("hession.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url = prop.get("opurl")+"";
		factory = new HessianProxyFactory();
	}
	
	/**
	 * 方法描述：获取远程调用实例
	 * 返回类型：UpdateRemote
	 * @return
	 */
	public static UpdateRemote getInterface(){
		if(basic == null){
			try {
				synchronized(HessionFactory.class){
					basic = (UpdateRemote) factory.create(UpdateRemote.class, url);
				}
			} catch (MalformedURLException e) {
				return null;
			}
		}
		// 创建远程请求对象
		return basic;
	}
	
	public static String getUrl(){
		return url;
	}
	
	/**
	 * 方法描述：刷新缓存对象
	 * 返回类型：void
	 * @throws MalformedURLException
	 */
	public static void refreshUrl() throws Exception{
		prop = Resources.getResourceAsProperties("hession.properties");
		
		url = prop.get("opurl")+"";
		basic = (UpdateRemote) factory.create(UpdateRemote.class, url);
	}
	
	private HessionFactory(){
		
	}
}
