package com.op.service.menu;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.entity.menu.Menus;
import com.op.entity.menu.OpMenus;
import com.op.plugin.page.Page;


@Service("opMenusService")
public interface OpMenusService {
	
	/**
	 * 方法描述：查询所有前台菜单
	 * 返回类型：List<OpMenus>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<OpMenus> menus(Page page) throws Exception;

	/**
	 * 方法描述：添加菜单功能，查询顶级菜单
	 * 返回类型：List<Menus>
	 * @return
	 * @throws Exception
	 */
	List<OpMenus> goMenuAddGetParentList() throws Exception;
	/**
	 * 方法描述：保存菜单
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void saveMenu(String uId,OpMenus menu,Map<String, Object> map) throws Exception;

	/**
	 * 方法描述：跳转菜单编辑页面
	 * 返回类型：OpMenus
	 * @param opm_id
	 * @return
	 * @throws Exception
	 */
	OpMenus getMenuBymId(String opm_id) throws Exception;

	/**
	 * 方法描述：更改菜单
	 * 返回类型：void
	 * @param uId
	 * @param menu
	 * @param map
	 * @throws Exception
	 */
	void updateMenu(String uId, OpMenus menu, Map<String, Object> map) throws Exception;

	/**
	 * 方法描述：删除
	 * 返回类型：void
	 * @param mId
	 * @param tp
	 * @param map
	 * @throws Exception
	 */
	void deleteMenu(String mId, String tp, Map<String, Object> map) throws Exception;

	/**
	 * 方法描述：查询子菜单
	 * 返回类型：List<OpMenus>
	 * @param opm_parent_id
	 * @return
	 * @throws Exception
	 */
	List<OpMenus> getMenuListById(String opm_parent_id) throws Exception;
}
