package com.op.service.usercenter.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.op.dao.BaseDao;
import com.op.entity.usercenter.LinkSignUpUser;
import com.op.service.usercenter.LinkSignUpUserService;

/**
 * 常用报名人(实现类)
 * @author PYW
 * Date: 2015年12月21日 15:06:12
 */
@Service("linkSignUpUserServiceImpl")
public class LinkSignUpUserServiceImpl implements LinkSignUpUserService{
	
	@Resource(name="baseDaoImpl")
	private BaseDao dao;

	/**
	 * 返回  常用报名人信息 
	 */
	public List<LinkSignUpUser> selectUser(String lsuuu_create_user) throws Exception {
		return (List<LinkSignUpUser>) dao.findForList("linkSignUpUserMapper.selectUser",lsuuu_create_user);
	}

	/**
	 *添加常用报名人
	 */
	public void insertUser(LinkSignUpUser lsuu) throws Exception {
		dao.save("linkSignUpUserMapper.insertUser",lsuu);
	}

	/**
	 * 修改常用报名人
	 */
	public void updateUser(LinkSignUpUser lsuu) throws Exception {
		dao.update("linkSignUpUserMapper.updateUser",lsuu);
	}

	/**
	 * 删除常用报名人
	 */
	public void deleteUser(LinkSignUpUser lsuu) throws Exception {
		dao.delete("linkSignUpUserMapper.deleteUser",lsuu);
	}
	/**
	 * 根据常用人id和创建人查找出相应的列
	 */
	public LinkSignUpUser selectUserId(LinkSignUpUser lsuu) throws Exception {
		return (LinkSignUpUser) dao.findForObject("linkSignUpUserMapper.selectUserId", lsuu);
	}
	
}
