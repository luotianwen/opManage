package com.op.service.usercenter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.op.entity.usercenter.ComplaintImage;

/**
 * 投诉领队证据图片(接口)
 * @author PYW
 * Date: 2016年1月14日 14:38:34
 */
@Service("complaintImageService")
public interface ComplaintImageService {
	/**
	 * 查询所有的投诉领队证据图片
	 */
	List<ComplaintImage> selectCI() throws Exception;
}
