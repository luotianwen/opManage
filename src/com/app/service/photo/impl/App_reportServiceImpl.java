package com.app.service.photo.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.app.dto.photo.App_commentReplyDTO;
import com.app.dto.photo.App_photocommentDTO;
import com.app.dto.photo.App_photodescDTO;
import com.app.dto.photo.App_photoreplyDTO;
import com.app.entity.photo.App_report;
import com.app.service.photo.App_reportService;
import com.op.dao.BaseDao; 
import com.op.plugin.page.Page;
import com.op.util.DateUtil;

/** 
 * 举报(app_report)接口实现类
 * @author sen
 * @version Revision: 1.00 
 *  Date: 2016-10-18 20:32:44 
 */  
@Service("app_reportServiceImpl")
public class App_reportServiceImpl implements App_reportService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有举报用户
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<App_report> findAllReport(Page<String> page) throws Exception{
		return (List<App_report>) dao.findForList("app_reportMapper.findAllReport", page);
	}
	
	/**
	 * 根据ID查询举报用户
	 */
	public App_report findReportById(Map<String,String> map,String id) throws Exception{
		App_report report = (App_report) dao.findForObject("app_reportMapper.findReportById", id);
		
//		if("0".equals(report.getPr_id())){
//			if("0".equals(report.getPc_id())){
//				App_photodescDTO desc = (App_photodescDTO) dao.findForObject("app_photodescMapper.findPhotodescById", report.getPd_id());
//				
//				map.put("uName", desc.getPd_cuser());
//				map.put("content", desc.getPd_content()+"("+desc.getPd_photo_count()+"张图片)");
//				map.put("time", desc.getPd_cdate());
//			}else{
//				App_photocommentDTO comment = (App_photocommentDTO) dao.findForObject("app_photocommentMapper.findPhotoCommentById", report.getPc_id());
//				
//				map.put("uName", comment.getuName());
//				map.put("content", comment.getPc_content());
//				map.put("time", DateUtil.getTime(comment.getPc_cdate()));
//			}
//		}else{
//			App_photoreplyDTO reply = (App_photoreplyDTO) dao.findForObject("app_photoreplyMapper.findReplyCommentById", report.getPr_id());
//			
//			map.put("uName", reply.getrName());
//			String replyStr = "";
//			if(!StringUtils.isEmpty(reply.getBrName())){
//				replyStr = "回复 "+reply.getBrName()+" : ";
//			}
//			map.put("content", replyStr+reply.getPr_content());
//			map.put("time", DateUtil.getTime(reply.getPr_date()));
//		}
		
		if("0".equals(report.getPr_id())){
			App_photodescDTO desc = (App_photodescDTO) dao.findForObject("app_photodescMapper.findPhotodescById", report.getPd_id());
			
			map.put("uName", desc.getPd_cuser());
			map.put("content", desc.getPd_content()+"("+desc.getPd_photo_count()+"张图片)");
			map.put("time", desc.getPd_cdate());
		}else{
			App_commentReplyDTO comment = (App_commentReplyDTO) dao.findForObject("app_commentReplyMapper.findCommentReplyById", report.getPr_id());
			
			map.put("uName", comment.getrName());
			String replyStr = "";
			if(!StringUtils.isEmpty(comment.getBrName())){
				replyStr = "回复 "+comment.getBrName()+" : ";
			}
			map.put("content", replyStr+comment.getCr_content());
			map.put("time", DateUtil.getTime(comment.getCr_cdate()));
		}
		
		return report;
	}
	
	/**
	 * 修改举报用户
	 * @param app_report
	 * @throws Exception
	 */
	public void updateReport(App_report app_report) throws Exception{
		dao.update("app_reportMapper.updateReport", app_report);
	}
	
	/**
	 * 举报用户
	 * @param app_report
	 * @throws Exception
	 */
	public void report(App_report app_report) throws Exception{
		dao.save("app_reportMapper.savereport", app_report);
	}
	
}
