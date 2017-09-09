package com.op.plugin.hession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.caucho.hessian.client.HessianProxyFactory;
import com.op.dto.hession.ResponseDTO;
import com.op.util.HessionFactory;

public class Test {

	public static void main(String[] args) throws MalformedURLException, FileNotFoundException {

		//UpdateRemote basic = HessionFactory.getInterface();
		
		/*Map<String,String> map = new HashMap<String,String>();
		map.put("/activity/activityInfo**", "authc,roleOrFilter[\"1\"]");
		
		// hession集成spring后方法重载是会报错的，建议写成不同的接口名 
		ResponseDTO dto = basic.updateShiro(map);
		System.out.println(dto.getState());
		System.out.println(dto.getError());*/
		
		/*System.out.println("-------------------------调用远程接口数据-------------------");
		int num = basic.getOnLineUserIds().size();
		System.out.println("【远程调用】门户项目在线人数:"+num);
		System.out.println("-------------------------针对单独用户发送远程数据-------------------");
		basic.sendMessageToUser("4", "呵呵思密达");*/
		
		
		Set<String> set  = new HashSet<String>();
		set.add("yxx");
		System.out.println(Arrays.asList(set));
	}
	
}
