package com.op.service.pointService.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.dto.point.PointServiceDeputyDTO;
import com.op.entity.pointService.PointService;
import com.op.entity.pointService.PointServiceDeputy;
import com.op.plugin.page.Page;
import com.op.service.pointService.PointServiceDeputyService;
import com.op.util.StringUtil;

/** 
 * 地点服务基本信息表(副)(pointServiceDeputy)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-06-21 10:51:23 
 */  
@Service("pointServiceDeputyServiceImpl")
public class PointServiceDeputyServiceImpl implements PointServiceDeputyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	

	/**
	 * 分页获取所有待审核的地点信息
	 * @param page
	 * @return
	 * @throws Exception 
	 */
	public List<?> getCheckList(Page<?> page) throws Exception{
		
		return (List<?>)dao.findForList("pointServiceDeputyMapper.getCheckListPage", page);
	}

	/**
	 * 根据id获取详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PointServiceDeputyDTO getPointById(String id) throws Exception{
		return (PointServiceDeputyDTO)dao.findForObject("pointServiceDeputyMapper.getPointById", id);
	}

	/**
	 * 审核处理
	 * @param map
	 */
	public void pointCheckById(Map<String, Object> map) throws Exception {
		//30：审核成功；40：审核失败
		if("30".equals(map.get("ps_state"))){
			String ps_id = map.get("ps_id").toString();
			PointServiceDeputyDTO point = (PointServiceDeputyDTO)dao.findForObject("pointServiceDeputyMapper.getPointById", ps_id);
			//判断是否是新增
			if(0 == point.getPs_is_add()){
				//新增场馆数据
				PointService pointService = new PointService();
				pointService.setPs_id(Integer.valueOf(ps_id));
				dao.save("pointServiceMapper.saveByCheck", pointService);
				
				Map<String,String> dataMap = new HashMap<String,String>();
				dataMap.put("ps_id", ps_id);
				dataMap.put("update_id", pointService.getPs_id()+"");
				
				map.put("update_id", pointService.getPs_id()+"");
				
				//新增营业日数据
				dao.save("businessDaysMapper.saveByCheck", dataMap);
				//新增营业时间数据
				dao.save("businessTimeMapper.saveByCheck", dataMap);
				//新增场馆联系方式数据
				dao.save("pointServiceContactMapper.saveByCheck", dataMap);
				//新增年场馆图片数据
				dao.save("pointServiceImgMapper.saveByCheck", dataMap);
				
				if(!"".equals(map.get("pa_id")+"")){
					//修改认证信息
					dao.update("pointAuthMapper.updatePointAuth", map);
					//审核成功，修改地点认证信息
					dao.update("pointServiceMapper.updateAuthExamine", map);
					//修改用户身份
					dao.update("UsersMapper.updateUTypeForPointService", map.get("user_id"));
				}
			}else{
				PointServiceDeputy pointServiceDeputy = (PointServiceDeputy) dao.findForObject("pointServiceDeputyMapper.findPointServiceDeputyByPsId", ps_id);
				pointServiceDeputy.setPs_check_user_id(map.get("ps_check_user_id")+"");
				dao.update("pointServiceMapper .updateByCheck", pointServiceDeputy);
				
				Map<String,Object> updateMap = new HashMap<String,Object>();
				updateMap.put("ps_id", pointServiceDeputy.getPs_id()+"");
				updateMap.put("update_id", pointServiceDeputy.getPs_point_service_id());
				
				dao.delete("businessDaysMapper.deleteByCheck", updateMap);
				dao.save("businessDaysMapper.saveByCheck", updateMap);
				
				dao.delete("businessTimeMapper.deleteByCheck", updateMap);
				dao.save("businessTimeMapper.saveByCheck", updateMap);
				
				dao.delete("pointServiceContactMapper.deleteByCheck", updateMap);
				dao.save("pointServiceContactMapper.saveByCheck", updateMap);
				
				dao.delete("pointServiceImgMapper.deleteByCheck", updateMap);
				dao.save("pointServiceImgMapper.saveByCheck", updateMap);
			}
			dao.update("pointServiceDeputyMapper.checkTrue", map);
		}else{
			dao.update("pointServiceDeputyMapper.checkError", map);
		}
	}
}
