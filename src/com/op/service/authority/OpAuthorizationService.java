package com.op.service.authority;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.dto.hession.ResponseDTO;
import com.op.entity.menu.ZTree;

@Service("opAuthorizationService")
public interface OpAuthorizationService {

	/**
	 * 方法描述：封装菜单节点
	 * 返回类型：List<ZTree>
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	List<ZTree> getRoleMenus(String rId) throws Exception;

	/**
	 * 方法描述：绑定角色资源
	 * 返回类型：void
	 * @param rId
	 * @param mIds
	 * @param map
	 * @throws Exception
	 */
	void savelinkRoleMenus(int rId, String mIds, Map<String, Object> map) throws Exception;

	/**
	 * 方法描述：刷新缓存
	 * 返回类型：void
	 * @throws Exception
	 */
	ResponseDTO initCache();
	
}
