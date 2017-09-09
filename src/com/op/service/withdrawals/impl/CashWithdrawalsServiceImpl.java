package com.op.service.withdrawals.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.entity.users.Users;
import com.op.entity.withdrawals.CashWithdrawals;
import com.op.plugin.page.Page;
import com.op.service.withdrawals.CashWithdrawalsService;
import com.op.util.FileUtil;
import com.op.util.UuidUtil;

/** 
 * 用户资金提现申请表(cashWithdrawals)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-25 09:36:36 
 */  
@Service("cashWithdrawalsServiceImpl")
public class CashWithdrawalsServiceImpl implements CashWithdrawalsService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	
	/**
	 * 获取提现申请列表
	 * @param page
	 * @return
	 */
	public List<CashWithdrawals> getListPage(Page<CashWithdrawals> page)throws Exception{
		return (List<CashWithdrawals>)dao.findForList("cashWithdrawalsMapper.getListPage", page);
	}
	
	/**
	 * 根据Id获取申请详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CashWithdrawals findCashWithdrawalsById(String id)throws Exception{
		return (CashWithdrawals)dao.findForObject("cashWithdrawalsMapper.findCashWithdrawalsById", id);
	}
	
	/**
	 * 修改提现状态
	 * 提现状态（1：提交申请；2：财务处理；3：提现完成；4：提现失败；）
	 * @param id
	 * @param state
	 * @param user
	 * @throws Exception
	 */
	public void updateCashWithdrawalsState(String id,int state,Users user)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",id);
		map.put("user_id",user.getuId());
		map.put("user_name",user.getuName());
		map.put("cw_state",state);
		dao.update("cashWithdrawalsMapper.updateCashWithdrawalsState", map);
		getStateLog(state, map);
		dao.save("cashWithdrawalsLogMapper.insertLog", map); 
	}
	
	/**
	 * 修改提现状态
	 * 提现状态（1：提交申请；2：财务处理；3：提现完成；4：提现失败；）
	 * @param map
	 * @throws Exception
	 */
	public void updateCashWithdrawalsState(Map<String,Object> map)throws Exception{
		int state = Integer.valueOf(map.get("cw_state").toString());
		dao.update("cashWithdrawalsMapper.updateCashWithdrawalsState2", map);
		getStateLog(state, map);
		dao.save("cashWithdrawalsLogMapper.insertLog", map); 
		if(3 == state){
			
			String rootPath = this.getClass().getResource("").getPath();
			rootPath = rootPath.substring(1, rootPath.indexOf("WEB-INF"));
			String success_screenshot = map.get("success_screenshot").toString();
			String newFileDirectory = "static/screenshot";
			String newFilePath = newFileDirectory+success_screenshot.substring(success_screenshot.lastIndexOf("/"));
			//判断服务器系统
			if(System.getProperties().getProperty("os.name").indexOf("Windows") != -1){
				success_screenshot = rootPath + success_screenshot;
				newFileDirectory = rootPath + newFileDirectory;
			}else{
				success_screenshot = "/"+rootPath + success_screenshot;
				newFileDirectory =  "/"+rootPath + newFileDirectory;
			}
			FileUtil.moveFile(success_screenshot,newFileDirectory);
			map.put("success_screenshot", newFilePath);
			dao.update("cashWithdrawalsMapper.updateScreenshotPath", map);
		}

	}
	
	private void getStateLog(int state,Map<String,Object> map){
		switch (state) {
		case 2:
			map.put("log","您的提现申请财务已开始处理，感谢您的耐心等待");
			break;
		case 3:
			map.put("log","您的提现申请财务已处理完成，请您注意查收");
			break;
		case 4:
			map.put("log","您的提现申请处理失败，如有疑问请联系客服");
			break;
		default:
			break;
		}
	}
}
