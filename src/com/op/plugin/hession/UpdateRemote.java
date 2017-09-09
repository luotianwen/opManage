package com.op.plugin.hession;

import java.util.List;
import java.util.Map;

import com.op.dto.hession.ResponseDTO;
/**
 * 项目名：opManage
 * 类描述：【请求远程更新操作】接口对象
 * 		注意，hession集成spring后方法重载是会报错的，建议写成不同的接口名
 * 创建人：Yan
 * 创建时间： 2016-1-14 下午4:48:17
 * 最后修改时间：2016-1-14下午4:48:17
 */
public interface UpdateRemote {

	/**
	 * 方法描述：远程更新权限
	 * 返回类型：ResponseDTO
	 * @param map
	 * @return
	 */
	public ResponseDTO updateShiro(Map<String, String> map);

    /**
     * 给所有在线用户发送消息
     * @param message
     * @throws IOException 
     */
    public ResponseDTO sendMessageTosessions(String message);
    
    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     * @throws IOException 
     */
    public ResponseDTO sendMessageToUser(String userId, String message);
    
    /**
     * 批量用户发送消息
     *
     * @param userName
     * @param message
     * @throws IOException 
     */
    public ResponseDTO sendMessageToUsers(String[] userIds, String message);

	/**
	 * 方法描述：获取所有在线人数ID
	 * 返回类型：Set<String>
	 * @return
	 */
	public List<String> getOnLineUserIds();
	
}
