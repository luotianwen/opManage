package com.app.service.photo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.app.dto.photo.App_commentReplyDTO;
import com.app.dto.photo.App_photocommentDTO;
import com.app.dto.photo.App_photodescDTO;
import com.app.dto.photo.App_photoreplyDTO;
import com.app.entity.photo.App_forbid_photo;
import com.app.service.photo.App_forbid_photoService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;
import com.op.util.Const;
import com.op.util.DateUtil;

/** 
 * 用户禁言表(app_forbid_photo)接口实现类
 * @author sen 
 * @version Revision: 1.00 
 *  Date: 2016-10-18 20:32:44 
 */  
@Service("app_forbid_photoServiceImpl")
public class App_forbid_photoServiceImpl implements App_forbid_photoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有用户禁言
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_forbid_photo> findAllForbidPhoto(Page<String> page) throws Exception{
		return (List<App_forbid_photo>) dao.findForList("app_forbid_photoMapper.findAllForbidPhoto", page);
	}
	
	/**
	 * 根据ID查询用户禁言
	 */
	public App_forbid_photo findForbidPhotoById(String id) throws Exception{
		return (App_forbid_photo) dao.findForObject("app_forbid_photoMapper.findForbidPhotoById", id);
	}
	
	/**
	 * 修改用户禁言
	 * @param app_forbid_photo
	 * @throws Exception
	 */
	public void updateForbidPhoto(App_forbid_photo app_forbid_photo) throws Exception{
		dao.update("app_forbid_photoMapper.updateForbidPhoto", app_forbid_photo);
	}
	
	/**
	 * 用户禁言
	 */
	public Map<String,String> forbidUser(App_forbid_photo app_forbid_photo) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		
//		if("0".equals(app_forbid_photo.getPr_id())){
//			if("0".equals(app_forbid_photo.getPc_id())){
//				App_photodescDTO desc = (App_photodescDTO) dao.findForObject("app_photodescMapper.findPhotodescById", app_forbid_photo.getPd_id());
//				
//				map.put("uName", desc.getPd_cuser());
//				map.put("content", desc.getPd_content()+"("+desc.getPd_photo_count()+"张图片)");
//				map.put("time", desc.getPd_cdate());
//			}else{
//				App_photocommentDTO comment = (App_photocommentDTO) dao.findForObject("app_photocommentMapper.findPhotoCommentById", app_forbid_photo.getPc_id());
//				
//				map.put("uName", comment.getuName());
//				map.put("content", comment.getPc_content());
//				map.put("time", DateUtil.getTime(comment.getPc_cdate()));
//			}
//		}else{
//			App_photoreplyDTO reply = (App_photoreplyDTO) dao.findForObject("app_photoreplyMapper.findReplyCommentById", app_forbid_photo.getPr_id());
//			
//			map.put("uName", reply.getrName());
//			String replyStr = "";
//			if(!StringUtils.isEmpty(reply.getBrName())){
//				replyStr = "回复 "+reply.getBrName()+" : ";
//			}
//			map.put("content", replyStr+reply.getPr_content());
//			map.put("time", DateUtil.getTime(reply.getPr_date()));
//		}
		
		if("0".equals(app_forbid_photo.getPr_id())){
			App_photodescDTO desc = (App_photodescDTO) dao.findForObject("app_photodescMapper.findPhotodescById", app_forbid_photo.getPd_id());
			
			map.put("uName", desc.getPd_cuser());
			map.put("content", desc.getPd_content()+"("+desc.getPd_photo_count()+"张图片)");
			map.put("time", desc.getPd_cdate());
		}else{
			App_commentReplyDTO comment = (App_commentReplyDTO) dao.findForObject("app_commentReplyMapper.findCommentReplyById", app_forbid_photo.getPr_id());
			
			map.put("uName", comment.getrName());
			String replyStr = "";
			if(!StringUtils.isEmpty(comment.getBrName())){
				replyStr = "回复 "+comment.getBrName()+" : ";
			}
			map.put("content", replyStr+comment.getCr_content());
			map.put("time", DateUtil.getTime(comment.getCr_cdate()));
		}
		
		
		
		return map;
	}
	
	/**
	 * 新增用户禁言
	 * @param app_forbid_photo
	 * @throws Exception
	 */
	public void saveForbidPhoto(Map<String,String> map,App_forbid_photo app_forbid_photo) throws Exception{
		int count = (int) dao.findForObject("app_forbid_photoMapper.findForbidPhotoCount", app_forbid_photo.getFp_forbid_user());
		if(count>0){
			map.put(Const.RESPONSE_STATE, "500");
			map.put(Const.ERROR_INFO, "该用户已被禁言！");
		}else{
			dao.save("app_forbid_photoMapper.saveForbidPhoto", app_forbid_photo);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
		
		
	}
	
}
