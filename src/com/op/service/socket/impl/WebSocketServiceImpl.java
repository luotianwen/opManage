package com.op.service.socket.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.dto.hession.ResponseDTO;
import com.op.service.socket.WebSocketService;
import com.op.util.Const;
import com.op.util.HessionFactory;

@Service("webSocketServiceImpl")
public class WebSocketServiceImpl implements WebSocketService{

	/**
	 * 方法描述：向指定用户推送消息
	 * 实现接口：@see com.op.service.socket.WebSocketService#sendMessageToUser(java.lang.String, java.lang.String)
	 * @param userId
	 * @param message
	 */
	@Override
	public void sendMessageToUser(String userId, String message,Map<String,Object> map)throws Exception {
		// TODO Auto-generated method stub
		ResponseDTO dto = HessionFactory.getInterface().sendMessageToUser(userId, message);
		// 获取返回状态
		map.put(Const.RESPONSE_STATE, dto.getState());
		// 发送成功条数
		map.put(Const.POST_SUCCESS_NUM, dto.getPostSuccessNum());
		
	}

	/**
	 * 方法描述：批量向用户推送消息
	 * 实现接口：@see com.op.service.socket.WebSocketService#sendMessageToUsers(java.lang.String, java.lang.String, java.util.Map)
	 * @param userId
	 * @param message
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void sendMessageToUsers(String userId, String message,
			Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		
		// 获取hession实例对象发送消息
		ResponseDTO dto = HessionFactory.getInterface().sendMessageToUsers(userId.split(","), message);
		
		// 获取返回状态
		map.put(Const.RESPONSE_STATE, dto.getState());
		// 发送成功条数
		map.put(Const.POST_SUCCESS_NUM, dto.getPostSuccessNum());
		// 发送失败条数
		map.put(Const.POST_ERROR_NUM, dto.getPostErrorNum());
		
	}

	/**
	 * 方法描述：全部向用户推送消息
	 * 实现接口：@see com.op.service.socket.WebSocketService#sendMessageTosessions(java.lang.String, java.util.Map)
	 * @param message
	 * @param map
	 * @throws Exception
	 */
	@Override
	public void sendMessageTosessions(String message, Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		
		// 获取hession实例对象发送消息
		ResponseDTO dto = HessionFactory.getInterface().sendMessageTosessions(message);
		
		// 获取返回状态
		map.put(Const.RESPONSE_STATE, dto.getState());
		// 发送成功条数
		map.put(Const.POST_SUCCESS_NUM, dto.getPostSuccessNum());
		// 发送失败条数
		map.put(Const.POST_ERROR_NUM, dto.getPostErrorNum());
		
	}

}
