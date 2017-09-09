package com.op.plugin.emayclient;

import java.rmi.RemoteException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.op.plugin.emayclient.client.SingletonClient;

/**
 * 项目名：outdoorPortal
 * 类描述：短信接口
 * 创建人：Yan
 * 创建时间： 2015-11-30 上午9:48:44
 * 最后修改时间：2015-11-30上午9:48:44
 */
public class EmacySMS {

	// 短信内容的最前面要加签名，【XX】 是一个签名格式（中文中括号和签名内容
	private static String signature;
	static{
		ResourceBundle bundle = PropertyResourceBundle.getBundle("emayclient");
		signature = bundle.getString("signature");
	}
	/**
	 * 方法描述：发送短信
	 * 返回类型：int
	 * @param phone 手机号码数组
	 * @param info 发送信息
	 * @return
	 */
	public static int sendSMS(String[] phone,String info){
		int i=-1;
		try {
			i = SingletonClient.getClient().sendSMS(phone, signature+info, "",5);
		} catch (RemoteException e) {
			i=-1;
		}
		return i;
	}
}
