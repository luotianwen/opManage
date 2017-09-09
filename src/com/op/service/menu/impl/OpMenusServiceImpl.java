package com.op.service.menu.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.menu.Menus;
import com.op.entity.menu.OpMenus;
import com.op.plugin.page.Page;
import com.op.service.menu.OpMenusService;
import com.op.util.Const;
import com.op.util.UuidUtil;


@Service("opMenusServiceImpl")
public class OpMenusServiceImpl implements OpMenusService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 方法描述：查询所有前台菜单
	 * 实现接口：@see com.op.service.menu.OpMenusService#menus(com.op.plugin.Page)
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OpMenus> menus(Page page) throws Exception {
		
		return (List<OpMenus>) dao.findForList("opMenusMapper.menusPage", page);
	}

	/**
	 * 方法描述：添加菜单功能，查询顶级菜单
	 * 实现接口：@see com.op.service.menu.MenusService#goMenuAddGetParentList()
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OpMenus> goMenuAddGetParentList() throws Exception {
		
		return (List<OpMenus>) dao.findForList("opMenusMapper.goMenuAddGetParentList", null);
	}

	/**
	 * 方法描述：保存菜单
	 * 实现接口：@see com.op.service.menu.MenusService#saveMenu(com.op.entity.menu.Menus)
	 * @param menu
	 * @return
	 */
	@Override
	public void saveMenu(String uId,OpMenus menu,Map<String,Object> map)  throws Exception{
		// 保存
		menu.setOpm_last_update_time(new Date());
		menu.setOpm_last_update_user(uId);
		dao.save("opMenusMapper.saveMenu", menu);
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	/**
	 * 方法描述：跳转菜单编辑页面
	 * 实现接口：@see com.op.service.menu.MenusService#getMenuBymId(java.lang.String)
	 * @param mId
	 * @return
	 * @throws Exception
	 */
	@Override
	public OpMenus getMenuBymId(String opm_id) throws Exception {
		// TODO Auto-generated method stub
		return (OpMenus) dao.findForObject("opMenusMapper.getMenuBymId", opm_id);
	}

	/**
	 * 方法描述：更改菜单
	 * 实现接口：@see com.op.service.menu.MenusService#updateMenu(java.util.Map)
	 * @param map
	 * @return
	 */
	@Override
	public void updateMenu(String uId,OpMenus menu,Map<String, Object> map) throws Exception{
		// 保存
		menu.setOpm_last_update_time(new Date());
		menu.setOpm_last_update_user(uId);
		dao.update("opMenusMapper.updateMenu", menu);
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	/**
	 * 方法描述：删除
	 * 实现接口：@see com.op.service.menu.MenusService#deleteMenu(java.util.Map)
	 * @description
	 * 	check：判断该菜单是否关联了角色
	 *  delete：删除菜单表、删除对应的角色
	 * @param map
	 * @return
	 */
	@Override
	public void deleteMenu(String mId,String tp,Map<String, Object> map)  throws Exception{
		// 判断该菜单是否绑定角色
		int roleNum = (int) dao.findForObject("opAuthorizationMapper.checkMenusForRoleByMid", mId);
		if(roleNum > 0){
			map.put(Const.ERROR_INFO, "该菜单已经关联了角色，请前往[组织管理菜单]解除角色的菜单关联，再进行删除菜单操作!");
			return;
		}
		if(tp.equals("main")){
			dao.delete("opMenusMapper.deleteMenuMain", mId);
		}else{
			dao.delete("opMenusMapper.deleteMenuChildren", mId);
		}
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	/**
	 * 方法描述：查询子菜单
	 * 实现接口：@see com.op.service.menu.MenusService#getMenuListById(java.lang.String)
	 * @param mParentId
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<OpMenus> getMenuListById(String opm_parent_id) throws Exception {
		return (List<OpMenus>) dao.findForList("opMenusMapper.getMenuListById", opm_parent_id);
	}
	
}
