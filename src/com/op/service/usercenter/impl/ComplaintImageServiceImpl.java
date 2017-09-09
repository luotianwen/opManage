package com.op.service.usercenter.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.op.dao.BaseDao;
import com.op.entity.usercenter.ComplaintImage;
import com.op.entity.usercenter.LinkSignUpUser;
import com.op.service.usercenter.ComplaintImageService;
import com.op.service.usercenter.LinkSignUpUserService;

/**
 * 投诉领队证据图片(接口)
 * @author PYW
 * Date: 2016年1月14日 14:38:34
 */
@Service("complaintImageServiceImpl")
public class ComplaintImageServiceImpl implements ComplaintImageService{
	
	@Resource(name="baseDaoImpl")
	private BaseDao dao;

	/**
	 * 查询所有的投诉领队证据图片
	 */
	public List<ComplaintImage> selectCI() throws Exception {
		return (List<ComplaintImage>) dao.findForList("complaintImageMapper.selectCI", null);
	}
}
