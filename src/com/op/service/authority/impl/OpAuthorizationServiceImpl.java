package com.op.service.authority.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.dto.hession.ResponseDTO;
import com.op.dto.shiro.ShiroDTO;
import com.op.entity.authority.OpAuthorization;
import com.op.entity.menu.OpMenus;
import com.op.entity.menu.ZTree;
import com.op.plugin.hession.UpdateRemote;
import com.op.service.authority.OpAuthorizationService;
import com.op.util.Const;
import com.op.util.HessionFactory;
import com.op.util.UuidUtil;


@Service("opAuthorizationServiceImpl")
public class OpAuthorizationServiceImpl implements OpAuthorizationService{
	
	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	

	/**
	 * 方法描述：封装菜单节点
	 * 实现接口：@see com.op.service.menu.MenusService#getRoleMenus(java.lang.String)
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ZTree> getRoleMenus(String rId) throws Exception {
		// 查询所有菜单
		List<OpMenus> menus = (List<OpMenus>) dao.findForList("opMenusMapper.findAllMenus", null);
		// 查询该角色对应的菜单
		List<String> mIds = (List<String>) dao.findForList("opAuthorizationMapper.findMenusByRId", rId);
		// 树形菜单对象
		List<ZTree> ztrees = new ArrayList<ZTree>();
		
		// 匹配资源，封装树形对象
		int menusLength = menus.size();
		for(int i=0;i<menusLength;i++){
			ZTree ztree = new ZTree();
			OpMenus menu = menus.get(i);
			ztree.setId(menu.getOpm_id());
			ztree.setpId(menu.getOpm_parent_id());
			ztree.setName(menu.getOpm_name());
			
			for(int j=0;j<mIds.size();j++){// 匹配是否已经关联
				String mId = mIds.get(j);
				if(menu.getOpm_id().equals(mId)){
					ztree.setChecked(true);
					mIds.remove(j);// 匹配则移除，优化匹配效率
					break;
				}
			}
			
			ztrees.add(ztree);
		}
		return ztrees;
	}
	
	
	/**
	 * 方法描述：绑定角色资源
	 * 实现接口：@see com.op.service.menu.MenusService#linkRoleMenus(java.util.Map)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void savelinkRoleMenus(int rId,String mIds,Map<String, Object> map) throws Exception {
		// 删除历史信息
		map.put(Const.ERROR_INFO, "删除历史信息异常，请稍后重试!!!");
		dao.delete("opAuthorizationMapper.deleteAuthorizationByRid", rId);
		map.remove(Const.ERROR_INFO);
		
		// 保存新的数据
		if(!StringUtils.isEmpty(mIds)){
			List<OpAuthorization> list = new ArrayList<OpAuthorization>();
			String[] ids = mIds.split(",");
			int idsLength = ids.length;
			for(int i=0;i<idsLength;i++){
				OpAuthorization auth = new OpAuthorization();
				auth.setOpa_user_type(rId);
				auth.setOpa_menu_id(ids[i]);
				list.add(auth);
			}
			
			map.put(Const.ERROR_INFO, "保存数据异常，请稍后重试!!!");
			dao.save("opAuthorizationMapper.saveAuthorizations", list);
			map.remove(Const.ERROR_INFO);
			
		}
		
		// 测试代码
		map.remove(Const.ERROR_INFO);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		
		// 远程更新缓存
		// 远程地址
		// 请求更新
		ResponseDTO dto = initCache();
		// 响应判断
		if(dto.getState() == 200){
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.ERROR_INFO, "异常信息："+dto.getError()+"<br>请确认：<br><span style='color:red;'>【①：门户项目正否常运行；<br>②：远程请求地址是否异常】</span>");
			throw new Exception(dto.getError());
		}
		
	}
	

	
	
	/**
	 * 方法描述：刷新缓存
	 * 实现接口：@see com.op.service.emay.EmayInfoService#initEmailTemplate()
	 * @throws Exception
	 */
	@Override
	public ResponseDTO initCache() {
		ResponseDTO dto = null;
		try {
			// 发送更新请求
			dto = HessionFactory.getInterface().updateShiro(initOtherPermission());
		} catch (Exception e) {
			dto = new ResponseDTO(500,e.toString());
		}
		return dto;
	}
	
	/**
	 * 方法描述：构造缓存
	 * 返回类型：Map<String,String>
	 * @return
	 */
	public Map<String, String> initOtherPermission() {
		Map<String,String> map = new HashMap<String,String>();
		try {
			System.out.println("-------------------------------加载第三方资源至远程shiro权限	开始-------------------------------------");
			List<ShiroDTO> shiroList = (List<ShiroDTO>) dao.findForList("opAuthorizationMapper.findAuthorizationForMenus", null);
			// 封装Map结构
			for (ShiroDTO dto : shiroList) {
				String path = dto.getPath();
				/*------------------重构资源路径--------------------------*/
				int indexOf = path.indexOf(".");
				
				// 修改访问路径通配符
				if(indexOf != -1){
					path = path.substring(0, indexOf)+"**";
				}else{
					path = path+"**";
				}
				// 根目录设置
				if(path.indexOf("/") != 0){
					path = "/"+path;
				}
				/*------------------重构资源路径--------------------------*/
				
				// 判断该资源是否已经对应了角色
				String roles = map.get(path);
				// 确定路径是否具有角色映射资源
				if(StringUtils.isEmpty(roles)){
					map.put(path, "authc,roleOrFilter[\""+dto.getRoleId()+"\"]");
				}else{
					// 如果该路径已经对应角色，向该路径添加下一个角色的对应关系(/controller/method** = authc,roleOrFilter["role1,role2"])
					roles = roles.substring(roles.indexOf("\"")+1, roles.lastIndexOf("\""));// 取出原来的角色字符串集合
					map.put(path, "authc,roleOrFilter[\""+roles+","+dto.getRoleId()+"\"]");// 重新封装
				}
			}
			System.out.println("-------------------------------加载第三方资源至远程shiro权限	结束-------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
