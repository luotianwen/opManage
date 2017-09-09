package com.op.service.authority;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 项目名：outdoorPortal
 * 类描述：权限Service
 * 创建人：Yan
 * 创建时间： 2015-11-30 上午9:52:29
 * 最后修改时间：2015-11-30上午9:52:29
 */
@Service("authorizationService")
public interface AuthorizationService {
	
	/**
	 * 方法描述：保存角色和菜单的关联
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void savelinkRoleMenus(String rId,String ids,Map<String,Object> map) throws Exception;

}

