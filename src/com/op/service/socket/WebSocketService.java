package com.op.service.socket;

import java.util.Map;

import org.springframework.stereotype.Service;


@Service("webSocketService")
public interface WebSocketService {
	/**
	 * 方法描述：向指定用户推送消息
	 * 返回类型：void
	 * @param userId
	 * @param message
	 */
	void sendMessageToUser(String userId, String message,Map<String,Object> map)throws Exception;
	/**
	 * 方法描述：批量向用户推送消息
	 * 返回类型：void
	 * @param userId
	 * @param message
	 */
	void sendMessageToUsers(String userId, String message,Map<String,Object> map)throws Exception;
	/**
	 * 方法描述：全部向用户推送消息
	 * 返回类型：void
	 * @param userId
	 * @param message
	 */
	void sendMessageTosessions(String message,Map<String,Object> map)throws Exception;
}
